package de.greenrobot.dao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.FastCursor;
import de.greenrobot.dao.internal.TableStatements;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;
    protected final SQLiteDatabase db;
    protected IdentityScope<K, T> identityScope;
    protected IdentityScopeLong<T> identityScopeLong;
    protected final int pkOrdinal;
    protected final AbstractDaoSession session;
    protected TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        this.db = daoConfig.db;
        this.identityScope = daoConfig.getIdentityScope();
        if (this.identityScope instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) this.identityScope;
        }
        this.statements = daoConfig.statements;
        this.pkOrdinal = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
    }

    private void deleteByKeyInsideSynchronized(K k, SQLiteStatement sQLiteStatement) {
        if (k instanceof Long) {
            sQLiteStatement.bindLong(1, ((Long) k).longValue());
        } else if (k == null) {
            throw new DaoException("Cannot delete entity, key is null");
        } else {
            sQLiteStatement.bindString(1, k.toString());
        }
        sQLiteStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        assertSinglePk();
        SQLiteStatement deleteStatement = this.statements.getDeleteStatement();
        Iterable iterable3 = null;
        this.db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                Object keyVerified;
                if (this.identityScope != null) {
                    this.identityScope.lock();
                    iterable3 = new ArrayList();
                }
                if (iterable != null) {
                    try {
                        for (T keyVerified2 : iterable) {
                            keyVerified = getKeyVerified(keyVerified2);
                            deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                            if (iterable3 != null) {
                                iterable3.add(keyVerified);
                            }
                        }
                    } catch (Throwable th) {
                        if (this.identityScope != null) {
                            this.identityScope.unlock();
                        }
                    }
                }
                if (iterable2 != null) {
                    for (Object keyVerified3 : iterable2) {
                        deleteByKeyInsideSynchronized(keyVerified3, deleteStatement);
                        if (iterable3 != null) {
                            iterable3.add(keyVerified3);
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.db.setTransactionSuccessful();
            if (!(iterable3 == null || this.identityScope == null)) {
                this.identityScope.remove(iterable3);
            }
            this.db.endTransaction();
        } catch (Throwable th2) {
            this.db.endTransaction();
        }
    }

    private long executeInsert(T t, SQLiteStatement sQLiteStatement) {
        long executeInsert;
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (sQLiteStatement) {
                bindValues(sQLiteStatement, t);
                executeInsert = sQLiteStatement.executeInsert();
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (sQLiteStatement) {
                    bindValues(sQLiteStatement, t);
                    executeInsert = sQLiteStatement.executeInsert();
                }
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            } catch (Throwable th) {
                this.db.endTransaction();
            }
        }
        updateKeyAfterInsertAndAttach(t, executeInsert, true);
        return executeInsert;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executeInsertInTx(android.database.sqlite.SQLiteStatement r6, java.lang.Iterable<T> r7, boolean r8) {
        /*
        r5 = this;
        r0 = r5.db;
        r0.beginTransaction();
        monitor-enter(r6);	 Catch:{ all -> 0x0039 }
        r0 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        r0.lock();	 Catch:{ all -> 0x0036 }
    L_0x000f:
        r0 = r7.iterator();	 Catch:{ all -> 0x002b }
    L_0x0013:
        r1 = r0.hasNext();	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0044;
    L_0x0019:
        r1 = r0.next();	 Catch:{ all -> 0x002b }
        r5.bindValues(r6, r1);	 Catch:{ all -> 0x002b }
        if (r8 == 0) goto L_0x0040;
    L_0x0022:
        r2 = r6.executeInsert();	 Catch:{ all -> 0x002b }
        r4 = 0;
        r5.updateKeyAfterInsertAndAttach(r1, r2, r4);	 Catch:{ all -> 0x002b }
        goto L_0x0013;
    L_0x002b:
        r0 = move-exception;
        r1 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        if (r1 == 0) goto L_0x0035;
    L_0x0030:
        r1 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        r1.unlock();	 Catch:{ all -> 0x0036 }
    L_0x0035:
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0036 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x0039:
        r0 = move-exception;
        r1 = r5.db;
        r1.endTransaction();
        throw r0;
    L_0x0040:
        r6.execute();	 Catch:{ all -> 0x002b }
        goto L_0x0013;
    L_0x0044:
        r0 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x004d;
    L_0x0048:
        r0 = r5.identityScope;	 Catch:{ all -> 0x0036 }
        r0.unlock();	 Catch:{ all -> 0x0036 }
    L_0x004d:
        monitor-exit(r6);	 Catch:{ all -> 0x0036 }
        r0 = r5.db;	 Catch:{ all -> 0x0039 }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0039 }
        r0 = r5.db;
        r0.endTransaction();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.dao.AbstractDao.executeInsertInTx(android.database.sqlite.SQLiteStatement, java.lang.Iterable, boolean):void");
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
        }
    }

    protected void attachEntity(T t) {
    }

    protected final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        if (this.identityScope != null && k != null) {
            if (z) {
                this.identityScope.put(k, t);
            } else {
                this.identityScope.putNoLock(k, t);
            }
        }
    }

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    public long count() {
        return DatabaseUtils.queryNumEntries(this.db, '\'' + this.config.tablename + '\'');
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteAll() {
        this.db.execSQL("DELETE FROM '" + this.config.tablename + "'");
        if (this.identityScope != null) {
            this.identityScope.clear();
        }
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        SQLiteStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            } catch (Throwable th) {
                this.db.endTransaction();
            }
        }
        if (this.identityScope != null) {
            this.identityScope.remove((Object) k);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public boolean detach(T t) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t), t);
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public SQLiteDatabase getDatabase() {
        return this.db;
    }

    protected abstract K getKey(T t);

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        if (t == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement());
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement());
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public long insertWithoutSettingPk(T t) {
        long executeInsert;
        SQLiteStatement insertStatement = this.statements.getInsertStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (insertStatement) {
                bindValues(insertStatement, t);
                executeInsert = insertStatement.executeInsert();
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (insertStatement) {
                    bindValues(insertStatement, t);
                    executeInsert = insertStatement.executeInsert();
                }
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            } catch (Throwable th) {
                this.db.endTransaction();
            }
        }
        return executeInsert;
    }

    protected abstract boolean isEntityUpdateable();

    public T load(K k) {
        assertSinglePk();
        if (k == null) {
            return null;
        }
        if (this.identityScope != null) {
            T t = this.identityScope.get(k);
            if (t != null) {
                return t;
            }
        }
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()}));
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    protected List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            List<T> loadAllFromCursor = loadAllFromCursor(cursor);
            return loadAllFromCursor;
        } finally {
            cursor.close();
        }
    }

    protected List<T> loadAllFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<T> arrayList = new ArrayList(count);
        if (cursor instanceof CrossProcessCursor) {
            CursorWindow window = ((CrossProcessCursor) cursor).getWindow();
            if (window != null) {
                if (window.getNumRows() == count) {
                    cursor = new FastCursor(window);
                } else {
                    DaoLog.d("Window vs. result size: " + window.getNumRows() + "/" + count);
                }
            }
        }
        if (cursor.moveToFirst()) {
            if (this.identityScope != null) {
                this.identityScope.lock();
                this.identityScope.reserveRoom(count);
            }
            while (true) {
                try {
                    arrayList.add(loadCurrent(cursor, 0, false));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
        }
        return arrayList;
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    protected final T loadCurrent(Cursor cursor, int i, boolean z) {
        T 2;
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            2 = z ? this.identityScopeLong.get2(j) : this.identityScopeLong.get2NoLock(j);
            if (2 != null) {
                return 2;
            }
            2 = readEntity(cursor, i);
            attachEntity(2);
            if (z) {
                this.identityScopeLong.put2(j, 2);
                return 2;
            }
            this.identityScopeLong.put2NoLock(j, 2);
            return 2;
        } else if (this.identityScope != null) {
            Object readKey = readKey(cursor, i);
            if (i != 0 && readKey == null) {
                return null;
            }
            2 = z ? this.identityScope.get(readKey) : this.identityScope.getNoLock(readKey);
            if (2 != null) {
                return 2;
            }
            2 = readEntity(cursor, i);
            attachEntity(readKey, 2, z);
            return 2;
        } else if (i != 0 && readKey(cursor, i) == null) {
            return null;
        } else {
            2 = readEntity(cursor, i);
            attachEntity(2);
            return 2;
        }
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    protected T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            T loadUnique = loadUnique(cursor);
            return loadUnique;
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    protected abstract T readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, T t, int i);

    protected abstract K readKey(Cursor cursor, int i);

    public void refresh(T t) {
        assertSinglePk();
        Object keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            } else if (rawQuery.isLast()) {
                readEntity(rawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            }
        } finally {
            rawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        SQLiteStatement updateStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            return;
        }
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
        } catch (Throwable th) {
            this.db.endTransaction();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateInTx(java.lang.Iterable<T> r5) {
        /*
        r4 = this;
        r0 = r4.statements;
        r1 = r0.getUpdateStatement();
        r0 = r4.db;
        r0.beginTransaction();
        monitor-enter(r1);	 Catch:{ all -> 0x0036 }
        r0 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r0 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        r0.lock();	 Catch:{ all -> 0x0033 }
    L_0x0015:
        r0 = r5.iterator();	 Catch:{ all -> 0x0028 }
    L_0x0019:
        r2 = r0.hasNext();	 Catch:{ all -> 0x0028 }
        if (r2 == 0) goto L_0x003d;
    L_0x001f:
        r2 = r0.next();	 Catch:{ all -> 0x0028 }
        r3 = 0;
        r4.updateInsideSynchronized(r2, r1, r3);	 Catch:{ all -> 0x0028 }
        goto L_0x0019;
    L_0x0028:
        r0 = move-exception;
        r2 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        if (r2 == 0) goto L_0x0032;
    L_0x002d:
        r2 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        r2.unlock();	 Catch:{ all -> 0x0033 }
    L_0x0032:
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r0 = move-exception;
        r1 = r4.db;
        r1.endTransaction();
        throw r0;
    L_0x003d:
        r0 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0046;
    L_0x0041:
        r0 = r4.identityScope;	 Catch:{ all -> 0x0033 }
        r0.unlock();	 Catch:{ all -> 0x0033 }
    L_0x0046:
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        r0 = r4.db;	 Catch:{ all -> 0x0036 }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0036 }
        r0 = r4.db;
        r0.endTransaction();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.dao.AbstractDao.updateInTx(java.lang.Iterable):void");
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key == null) {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        } else {
            sQLiteStatement.bindString(length, key.toString());
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    protected abstract K updateKeyAfterInsert(T t, long j);

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }
}
