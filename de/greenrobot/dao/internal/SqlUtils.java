package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoException;

public class SqlUtils {
    public static StringBuilder appendColumn(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\'').append(str).append('\'');
        return stringBuilder;
    }

    public static StringBuilder appendColumn(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str).append(".'").append(str2).append('\'');
        return stringBuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringBuilder, String str, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            appendColumn(stringBuilder, str, strArr[i]);
            if (i < length - 1) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append('\'').append(strArr[i]).append('\'');
            if (i < length - 1) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder stringBuilder, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(stringBuilder, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder stringBuilder, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(stringBuilder, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                stringBuilder.append(',');
            }
        }
        return stringBuilder;
    }

    public static StringBuilder appendPlaceholders(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                stringBuilder.append("?,");
            } else {
                stringBuilder.append('?');
            }
        }
        return stringBuilder;
    }

    public static String createSqlDelete(String str, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder("DELETE FROM ");
        stringBuilder.append(str);
        if (strArr != null && strArr.length > 0) {
            stringBuilder.append(" WHERE ");
            appendColumnsEqValue(stringBuilder, str, strArr);
        }
        return stringBuilder.toString();
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str2).append(" (");
        appendColumns(stringBuilder, strArr);
        stringBuilder.append(") VALUES (");
        appendPlaceholders(stringBuilder, strArr.length);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static String createSqlSelect(String str, String str2, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        appendColumns(stringBuilder, str2, strArr).append(" FROM ");
        stringBuilder.append(str).append(' ').append(str2).append(' ');
        return stringBuilder.toString();
    }

    public static String createSqlSelectCountStar(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        stringBuilder.append(str).append(' ');
        if (str2 != null) {
            stringBuilder.append(str2).append(' ');
        }
        return stringBuilder.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE ");
        stringBuilder.append(str).append(" SET ");
        appendColumnsEqualPlaceholders(stringBuilder, strArr);
        stringBuilder.append(" WHERE ");
        appendColumnsEqValue(stringBuilder, str, strArr2);
        return stringBuilder.toString();
    }
}
