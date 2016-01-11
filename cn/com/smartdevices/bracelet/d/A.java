package cn.com.smartdevices.bracelet.d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;

public final class A {
    public static final String a = "parterconfig";
    static final String b = "CREATE TABLE IF NOT EXISTS parterconfig(_id  INTEGER PRIMARY KEY AUTOINCREMENT,color TEXT,title TEXT,sub_title TEXT,share_content TEXT,icon ICON,third_app_id TEXT,expire_time INTEGER DEFAULT 0,status INTEGER DEFAULT 0,url TEXT );";
    static final String c = "ALTER TABLE parterconfig ADD COLUMN status INTEGER DEFAULT 0";
    static final String d = "ALTER TABLE parterconfig ADD COLUMN share_content TEXT";

    static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM parterconfig");
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i >= 5) {
            try {
                sQLiteDatabase.execSQL(c);
            } catch (Exception e) {
                C0596r.a("DB", e.getMessage());
            }
        }
        if (i >= 10) {
            try {
                sQLiteDatabase.execSQL(d);
            } catch (Exception e2) {
                C0596r.a("DB", e2.getMessage());
            }
        }
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b);
    }
}
