package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import java.util.List;

public class Query<T> extends AbstractQuery<T> {
    private final int limitPosition;
    private final int offsetPosition;
    private final QueryData<T> queryData;

    final class QueryData<T2> extends AbstractQueryData<T2, Query<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i, int i2) {
            super(abstractDao, str, strArr);
            this.limitPosition = i;
            this.offsetPosition = i2;
        }

        protected Query<T2> createQuery() {
            return new Query(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    private Query(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr);
        this.queryData = queryData;
        this.limitPosition = i;
        this.offsetPosition = i2;
    }

    static <T2> Query<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i, int i2) {
        return (Query) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), i, i2).forCurrentThread();
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    public Query<T> forCurrentThread() {
        return (Query) this.queryData.forCurrentThread(this);
    }

    public List<T> list() {
        checkThread();
        return this.daoAccess.loadAllAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public LazyList<T> listLazy() {
        checkThread();
        return new LazyList(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), true);
    }

    public LazyList<T> listLazyUncached() {
        checkThread();
        return new LazyList(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), false);
    }

    public void setLimit(int i) {
        checkThread();
        if (this.limitPosition == -1) {
            throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        }
        this.parameters[this.limitPosition] = Integer.toString(i);
    }

    public void setOffset(int i) {
        checkThread();
        if (this.offsetPosition == -1) {
            throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        }
        this.parameters[this.offsetPosition] = Integer.toString(i);
    }

    public void setParameter(int i, Object obj) {
        if (i < 0 || !(i == this.limitPosition || i == this.offsetPosition)) {
            super.setParameter(i, obj);
            return;
        }
        throw new IllegalArgumentException("Illegal parameter index: " + i);
    }

    public T unique() {
        checkThread();
        return this.daoAccess.loadUniqueAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }
}
