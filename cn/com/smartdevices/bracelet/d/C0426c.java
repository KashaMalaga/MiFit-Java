package cn.com.smartdevices.bracelet.d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;

class C0426c {
    C0426c() {
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM cloud_config");
            sQLiteDatabase.execSQL("DELETE FROM localcache");
            sQLiteDatabase.execSQL("DELETE FROM selfgoal");
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_config(_id INTEGER PRIMARY KEY AUTOINCREMENT,config TEXT,value TEXT,time_stamp BIGINT,dummy1 TEXT,dummy2 TEXT,dummy3 TEXT,dummy4 TEXT, dummy5 TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS localcache(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,expire_time BIGINT,sync INTEGER DEFAULT 0,reserved1 TEXT,reserved2 TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS selfgoal(_id INTEGER PRIMARY KEY AUTOINCREMENT,value INTEGER,weight INTEGER,reserved1 TEXT,reserved2 TEXT,sync INTEGER DEFAULT 0);");
    }
}
