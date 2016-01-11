package de.greenrobot.dao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

public class CountQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    final class QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        protected CountQuery<T2> createQuery() {
            return new CountQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    private CountQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData;
    }

    static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (CountQuery) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr)).forCurrentThread();
    }

    public long count() {
        checkThread();
        SQLiteDatabase database = this.dao.getDatabase();
        String str = this.sql;
        long j = this.parameters;
        Cursor rawQuery = database.rawQuery(str, j);
        try {
            if (!rawQuery.moveToNext()) {
                throw new DaoException("No result for count");
            } else if (!rawQuery.isLast()) {
                throw new DaoException("Unexpected row count: " + rawQuery.getCount());
            } else if (rawQuery.getColumnCount() != 1) {
                throw new DaoException("Unexpected column count: " + rawQuery.getColumnCount());
            } else {
                j = rawQuery.getLong(0);
                return j;
            }
        } finally {
            rawQuery.close();
        }
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.queryData.forCurrentThread(this);
    }

    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }
}
