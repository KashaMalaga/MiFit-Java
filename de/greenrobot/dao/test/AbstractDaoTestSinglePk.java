package de.greenrobot.dao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import com.a.a.a.C0912u;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    protected Set<K> usedPks = new HashSet();

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
    }

    protected abstract T createEntity(K k);

    protected T createEntityWithRandomPk() {
        return createEntity(nextPk());
    }

    protected abstract K createRandomPk();

    protected K nextPk() {
        for (int i = 0; i < 100000; i++) {
            K createRandomPk = createRandomPk();
            if (this.usedPks.add(createRandomPk)) {
                return createRandomPk;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    protected Cursor queryWithDummyColumnsInFront(int i, String str, K k) {
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        for (int i3 = 0; i3 < i; i3++) {
            stringBuilder.append(str).append(f.i);
        }
        SqlUtils.appendColumns(stringBuilder, C0912u.a, this.dao.getAllColumns()).append(" FROM ");
        stringBuilder.append(this.dao.getTablename()).append(" T");
        if (k != null) {
            stringBuilder.append(" WHERE ");
            assertEquals(1, this.dao.getPkColumns().length);
            stringBuilder.append(this.dao.getPkColumns()[0]).append("=");
            DatabaseUtils.appendValueToSql(stringBuilder, k);
        }
        Cursor rawQuery = this.db.rawQuery(stringBuilder.toString(), null);
        assertTrue(rawQuery.moveToFirst());
        while (i2 < i) {
            try {
                assertEquals(str, rawQuery.getString(i2));
                i2++;
            } catch (RuntimeException e) {
                rawQuery.close();
                throw e;
            }
        }
        if (k != null) {
            assertEquals(1, rawQuery.getCount());
        }
        return rawQuery;
    }

    protected void runLoadPkTest(int i) {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(i, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.readKey(queryWithDummyColumnsInFront, i));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    protected void setUp() {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn != null) {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
                this.pkColumn = property;
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testCount() {
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(1, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(2, this.dao.count());
    }

    public void testDelete() {
        Object nextPk = nextPk();
        this.dao.deleteByKey(nextPk);
        this.dao.insert(createEntity(nextPk));
        assertNotNull(this.dao.load(nextPk));
        this.dao.deleteByKey(nextPk);
        assertNull(this.dao.load(nextPk));
    }

    public void testDeleteAll() {
        Iterable<Object> arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx((Iterable) arrayList);
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        for (Object key : arrayList) {
            Object key2 = this.daoAccess.getKey(key2);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteByKeyInTx() {
        Iterable arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        Iterable arrayList2 = new ArrayList();
        arrayList2.add(this.daoAccess.getKey(arrayList.get(0)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(3)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(4)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(8)));
        this.dao.deleteByKeyInTx(arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object next : arrayList2) {
            assertNotNull(next);
            assertNull(this.dao.load(next));
        }
    }

    public void testDeleteInTx() {
        Iterable arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        Iterable<Object> arrayList2 = new ArrayList();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.dao.deleteInTx((Iterable) arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object key : arrayList2) {
            Object key2 = this.daoAccess.getKey(key2);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testInsertAndLoad() {
        Object nextPk = nextPk();
        Object createEntity = createEntity(nextPk);
        this.dao.insert(createEntity);
        assertEquals(nextPk, this.daoAccess.getKey(createEntity));
        nextPk = this.dao.load(nextPk);
        assertNotNull(nextPk);
        assertEquals(this.daoAccess.getKey(createEntity), this.daoAccess.getKey(nextPk));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        Iterable arrayList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        assertEquals((long) arrayList.size(), this.dao.count());
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        Iterable arrayList = new ArrayList();
        Iterable arrayList2 = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Object createEntityWithRandomPk = createEntityWithRandomPk();
            if (i % 2 == 0) {
                arrayList.add(createEntityWithRandomPk);
            }
            arrayList2.add(createEntityWithRandomPk);
        }
        this.dao.insertOrReplaceInTx(arrayList);
        this.dao.insertOrReplaceInTx(arrayList2);
        assertEquals((long) arrayList2.size(), this.dao.count());
    }

    public void testInsertOrReplaceTwice() {
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        long insert = this.dao.insert(createEntityWithRandomPk);
        long insertOrReplace = this.dao.insertOrReplace(createEntityWithRandomPk);
        if (this.dao.getPkProperty().type == Long.class) {
            assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertTwice() {
        Object createEntity = createEntity(nextPk());
        this.dao.insert(createEntity);
        try {
            this.dao.insert(createEntity);
            fail("Inserting twice should not work");
        } catch (SQLException e) {
        }
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        Iterable arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            arrayList.add(createEntity(nextPk()));
        }
        this.dao.insertInTx(arrayList);
        assertEquals(arrayList.size(), this.dao.loadAll().size());
    }

    public void testLoadPk() {
        runLoadPkTest(0);
    }

    public void testLoadPkWithOffset() {
        runLoadPkTest(10);
    }

    public void testQuery() {
        this.dao.insert(createEntityWithRandomPk());
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        this.dao.insert(createEntityWithRandomPk());
        String str = "WHERE " + this.dao.getPkColumns()[0] + "=?";
        List queryRaw = this.dao.queryRaw(str, nextPk.toString());
        assertEquals(1, queryRaw.size());
        assertEquals(nextPk, this.daoAccess.getKey(queryRaw.get(0)));
    }

    public void testReadWithOffset() {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(5, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.getKey(this.daoAccess.readEntity(queryWithDummyColumnsInFront, 5)));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void testRowId() {
        assertTrue(this.dao.insert(createEntityWithRandomPk()) != this.dao.insert(createEntityWithRandomPk()));
    }

    public void testUpdate() {
        this.dao.deleteAll();
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        this.dao.insert(createEntityWithRandomPk);
        this.dao.update(createEntityWithRandomPk);
        assertEquals(1, this.dao.count());
    }
}
