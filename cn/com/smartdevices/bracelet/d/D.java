package cn.com.smartdevices.bracelet.d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;

public class D {
    static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM date_data");
            if (sQLiteDatabase.getVersion() >= 14) {
                sQLiteDatabase.execSQL("DELETE FROM heartrate");
            }
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 13) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE date_data ADD COLUMN summary_hr TEXT;");
            } catch (Exception e) {
                C0596r.d("DB", "add summary_hr occurs exception:" + e.getMessage());
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE date_data ADD COLUMN data_hr BLOB;");
            } catch (Exception e2) {
                C0596r.d("DB", "add data_hr occurs exception:" + e2.getMessage());
            }
        }
        if (i < 14) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS heartrate(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,time LONG,hr INTEGER,sync INTEGER);");
            } catch (Exception e22) {
                C0596r.d("DB", "add heartrate table occurs exception:" + e22.getMessage());
            }
        }
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS date_data(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,source INTEGER DEFAULT 0,date TEXT,summary TEXT,indexs TEXT,data BLOB,data_hr BLOB,summary_hr TEXT,sync INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS heartrate(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,time LONG,hr INTEGER,sync INTEGER);");
    }
}
