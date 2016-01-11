package cn.com.smartdevices.bracelet.shoes.data.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;

class k {
    private k() {
    }

    public static String a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        try {
            cursor = sQLiteDatabase.rawQuery(String.format("SELECT sql from sqlite_master WHERE type = 'table' AND name = '%s'", new Object[]{str}), null);
            String str2;
            if (cursor == null || cursor.getCount() == 0) {
                str2 = a.f;
                if (cursor == null) {
                    return str2;
                }
                cursor.close();
                return str2;
            } else if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("sql"));
                if (cursor == null) {
                    return str2;
                }
                cursor.close();
                return str2;
            } else {
                if (cursor != null) {
                    cursor.close();
                }
                return a.f;
            }
        } catch (Exception e) {
            C0596r.d("DBUtils", e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? a.f : str;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        if (sQLiteDatabase == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        Object a = a(sQLiteDatabase, str);
        return !TextUtils.isEmpty(a) && a.contains(str2);
    }
}
