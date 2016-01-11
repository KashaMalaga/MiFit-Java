package de.greenrobot.dao.query;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import java.util.Date;
import java.util.List;

public interface WhereCondition {

    public abstract class AbstractCondition implements WhereCondition {
        protected final boolean hasSingleValue;
        protected final Object value;
        protected final Object[] values;

        public AbstractCondition() {
            this.hasSingleValue = false;
            this.value = null;
            this.values = null;
        }

        public AbstractCondition(Object obj) {
            this.value = obj;
            this.hasSingleValue = true;
            this.values = null;
        }

        public AbstractCondition(Object[] objArr) {
            this.value = null;
            this.hasSingleValue = false;
            this.values = objArr;
        }

        public void appendValuesTo(List<Object> list) {
            if (this.hasSingleValue) {
                list.add(this.value);
            }
            if (this.values != null) {
                for (Object add : this.values) {
                    list.add(add);
                }
            }
        }
    }

    public class PropertyCondition extends AbstractCondition {
        public final String op;
        public final Property property;

        public PropertyCondition(Property property, String str) {
            this.property = property;
            this.op = str;
        }

        public PropertyCondition(Property property, String str, Object obj) {
            super(checkValueForType(property, obj));
            this.property = property;
            this.op = str;
        }

        public PropertyCondition(Property property, String str, Object[] objArr) {
            super(checkValuesForType(property, objArr));
            this.property = property;
            this.op = str;
        }

        private static Object checkValueForType(Property property, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            } else if (property.type == Date.class) {
                if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                }
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + obj);
            } else if (property.type != Boolean.TYPE && property.type != Boolean.class) {
                return obj;
            } else {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                } else if (obj instanceof Number) {
                    int intValue = ((Number) obj).intValue();
                    if (intValue == 0 || intValue == 1) {
                        return obj;
                    }
                    throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                } else if (!(obj instanceof String)) {
                    return obj;
                } else {
                    String str = (String) obj;
                    if ("TRUE".equalsIgnoreCase(str)) {
                        return Integer.valueOf(1);
                    }
                    if ("FALSE".equalsIgnoreCase(str)) {
                        return Integer.valueOf(0);
                    }
                    throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was " + obj);
                }
            }
        }

        private static Object[] checkValuesForType(Property property, Object[] objArr) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = checkValueForType(property, objArr[i]);
            }
            return objArr;
        }

        public void appendTo(StringBuilder stringBuilder, String str) {
            if (str != null) {
                stringBuilder.append(str).append('.');
            }
            stringBuilder.append('\'').append(this.property.columnName).append('\'').append(this.op);
        }
    }

    public class StringCondition extends AbstractCondition {
        protected final String string;

        public StringCondition(String str) {
            this.string = str;
        }

        public StringCondition(String str, Object obj) {
            super(obj);
            this.string = str;
        }

        public StringCondition(String str, Object... objArr) {
            super(objArr);
            this.string = str;
        }

        public void appendTo(StringBuilder stringBuilder, String str) {
            stringBuilder.append(this.string);
        }
    }

    void appendTo(StringBuilder stringBuilder, String str);

    void appendValuesTo(List<Object> list);
}
