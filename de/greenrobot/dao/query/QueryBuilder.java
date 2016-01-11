package de.greenrobot.dao.query;

import com.a.a.a.C0912u;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalQueryDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.WhereCondition.PropertyCondition;
import de.greenrobot.dao.query.WhereCondition.StringCondition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao<T, ?> dao;
    private StringBuilder joinBuilder;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private final String tablePrefix;
    private final List<Object> values;
    private final List<WhereCondition> whereConditions;

    protected QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, C0912u.a);
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao, String str) {
        this.dao = abstractDao;
        this.tablePrefix = str;
        this.values = new ArrayList();
        this.whereConditions = new ArrayList();
    }

    private void appendWhereClause(StringBuilder stringBuilder, String str) {
        this.values.clear();
        if (!this.whereConditions.isEmpty()) {
            stringBuilder.append(" WHERE ");
            ListIterator listIterator = this.whereConditions.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.hasPrevious()) {
                    stringBuilder.append(" AND ");
                }
                WhereCondition whereCondition = (WhereCondition) listIterator.next();
                whereCondition.appendTo(stringBuilder, str);
                whereCondition.appendValuesTo(this.values);
            }
        }
    }

    private void checkOrderBuilder() {
        if (this.orderBuilder == null) {
            this.orderBuilder = new StringBuilder();
        } else if (this.orderBuilder.length() > 0) {
            this.orderBuilder.append(f.i);
        }
    }

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder(abstractDao);
    }

    private void orderAscOrDesc(String str, Property... propertyArr) {
        for (Property property : propertyArr) {
            checkOrderBuilder();
            append(this.orderBuilder, property);
            if (String.class.equals(property.type)) {
                this.orderBuilder.append(" COLLATE LOCALIZED");
            }
            this.orderBuilder.append(str);
        }
    }

    protected void addCondition(StringBuilder stringBuilder, List<Object> list, WhereCondition whereCondition) {
        checkCondition(whereCondition);
        whereCondition.appendTo(stringBuilder, this.tablePrefix);
        whereCondition.appendValuesTo(list);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return combineWhereConditions(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    protected StringBuilder append(StringBuilder stringBuilder, Property property) {
        checkProperty(property);
        stringBuilder.append(this.tablePrefix).append('.').append('\'').append(property.columnName).append('\'');
        return stringBuilder;
    }

    public Query<T> build() {
        int size;
        int i = -1;
        String selectAll = (this.joinBuilder == null || this.joinBuilder.length() == 0) ? InternalQueryDaoAccess.getStatements(this.dao).getSelectAll() : SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns());
        StringBuilder stringBuilder = new StringBuilder(selectAll);
        appendWhereClause(stringBuilder, this.tablePrefix);
        if (this.orderBuilder != null && this.orderBuilder.length() > 0) {
            stringBuilder.append(" ORDER BY ").append(this.orderBuilder);
        }
        if (this.limit != null) {
            stringBuilder.append(" LIMIT ?");
            this.values.add(this.limit);
            size = this.values.size() - 1;
        } else {
            size = -1;
        }
        if (this.offset != null) {
            if (this.limit == null) {
                throw new IllegalStateException("Offset cannot be set without limit");
            }
            stringBuilder.append(" OFFSET ?");
            this.values.add(this.offset);
            i = this.values.size() - 1;
        }
        String stringBuilder2 = stringBuilder.toString();
        if (LOG_SQL) {
            DaoLog.d("Built SQL for query: " + stringBuilder2);
        }
        if (LOG_VALUES) {
            DaoLog.d("Values for query: " + this.values);
        }
        return Query.create(this.dao, stringBuilder2, this.values.toArray(), size, i);
    }

    public CountQuery<T> buildCount() {
        StringBuilder stringBuilder = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.dao.getTablename(), this.tablePrefix));
        appendWhereClause(stringBuilder, this.tablePrefix);
        String stringBuilder2 = stringBuilder.toString();
        if (LOG_SQL) {
            DaoLog.d("Built SQL for count query: " + stringBuilder2);
        }
        if (LOG_VALUES) {
            DaoLog.d("Values for count query: " + this.values);
        }
        return CountQuery.create(this.dao, stringBuilder2, this.values.toArray());
    }

    public DeleteQuery<T> buildDelete() {
        String tablename = this.dao.getTablename();
        StringBuilder stringBuilder = new StringBuilder(SqlUtils.createSqlDelete(tablename, null));
        appendWhereClause(stringBuilder, this.tablePrefix);
        tablename = stringBuilder.toString().replace(this.tablePrefix + ".'", tablename + ".'");
        if (LOG_SQL) {
            DaoLog.d("Built SQL for delete query: " + tablename);
        }
        if (LOG_VALUES) {
            DaoLog.d("Values for delete query: " + this.values);
        }
        return DeleteQuery.create(this.dao, tablename, this.values.toArray());
    }

    protected void checkCondition(WhereCondition whereCondition) {
        if (whereCondition instanceof PropertyCondition) {
            checkProperty(((PropertyCondition) whereCondition).property);
        }
    }

    protected void checkProperty(Property property) {
        Object obj = null;
        if (this.dao != null) {
            for (Property property2 : this.dao.getProperties()) {
                if (property == property2) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                throw new DaoException("Property '" + property.name + "' is not part of " + this.dao);
            }
        }
    }

    protected WhereCondition combineWhereConditions(String str, WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        StringBuilder stringBuilder = new StringBuilder("(");
        List arrayList = new ArrayList();
        addCondition(stringBuilder, arrayList, whereCondition);
        stringBuilder.append(str);
        addCondition(stringBuilder, arrayList, whereCondition2);
        for (WhereCondition whereCondition3 : whereConditionArr) {
            stringBuilder.append(str);
            addCondition(stringBuilder, arrayList, whereCondition3);
        }
        stringBuilder.append(')');
        return new StringCondition(stringBuilder.toString(), arrayList.toArray());
    }

    public long count() {
        return buildCount().count();
    }

    public <J> QueryBuilder<J> join(Class<J> cls, Property property) {
        throw new UnsupportedOperationException();
    }

    public <J> QueryBuilder<J> joinToMany(Class<J> cls, Property property) {
        throw new UnsupportedOperationException();
    }

    public QueryBuilder<T> limit(int i) {
        this.limit = Integer.valueOf(i);
        return this;
    }

    public List<T> list() {
        return build().list();
    }

    public CloseableListIterator<T> listIterator() {
        return build().listIterator();
    }

    public LazyList<T> listLazy() {
        return build().listLazy();
    }

    public LazyList<T> listLazyUncached() {
        return build().listLazyUncached();
    }

    public QueryBuilder<T> offset(int i) {
        this.offset = Integer.valueOf(i);
        return this;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return combineWhereConditions(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public QueryBuilder<T> orderAsc(Property... propertyArr) {
        orderAscOrDesc(" ASC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderCustom(Property property, String str) {
        checkOrderBuilder();
        append(this.orderBuilder, property).append(' ');
        this.orderBuilder.append(str);
        return this;
    }

    public QueryBuilder<T> orderDesc(Property... propertyArr) {
        orderAscOrDesc(" DESC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderRaw(String str) {
        checkOrderBuilder();
        this.orderBuilder.append(str);
        return this;
    }

    public T unique() {
        return build().unique();
    }

    public T uniqueOrThrow() {
        return build().uniqueOrThrow();
    }

    public QueryBuilder<T> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.whereConditions.add(whereCondition);
        for (WhereCondition whereCondition2 : whereConditionArr) {
            checkCondition(whereCondition2);
            this.whereConditions.add(whereCondition2);
        }
        return this;
    }

    public QueryBuilder<T> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.whereConditions.add(or(whereCondition, whereCondition2, whereConditionArr));
        return this;
    }
}
