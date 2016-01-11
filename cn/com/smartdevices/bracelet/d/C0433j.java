package cn.com.smartdevices.bracelet.d;

import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.b.a;
import cn.com.smartdevices.bracelet.gps.c.a.b;
import cn.com.smartdevices.bracelet.gps.c.a.d;
import cn.com.smartdevices.bracelet.gps.c.a.f;
import cn.com.smartdevices.bracelet.gps.c.a.h;
import cn.com.smartdevices.bracelet.gps.c.a.l;
import java.util.List;

final class C0433j {
    private C0433j() {
    }

    static void a(SQLiteDatabase sQLiteDatabase) {
        List a = a.a(sQLiteDatabase);
        if (a != null && a.size() != 0) {
            try {
                if (a.contains(h.a)) {
                    sQLiteDatabase.execSQL("DELETE FROM sportconfig");
                }
                if (a.contains(d.a)) {
                    sQLiteDatabase.execSQL("DELETE FROM trackinfo");
                }
                if (a.contains(f.a)) {
                    sQLiteDatabase.execSQL("DELETE FROM trackloc");
                }
                if (a.contains(b.a)) {
                    sQLiteDatabase.execSQL("DELETE FROM contourtrack");
                }
                if (a.contains(l.a)) {
                    sQLiteDatabase.execSQL("DELETE FROM trackdeathbook");
                }
            } catch (Exception e) {
                C0596r.a("DB", e.getMessage());
            }
        }
    }

    static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i >= 3) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE trackinfo ADD COLUMN groupCnt INTEGER");
            } catch (Exception e) {
                C0596r.a("DB", e.getMessage());
            }
        }
        if (i >= 6) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE trackinfo ADD COLUMN distance REAL DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE trackinfo ADD COLUMN usedtime INTEGER DEFAULT 0");
            } catch (Exception e2) {
                C0596r.a("DB", e2.getMessage());
            }
        }
        if (i >= 9) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE contourtrack ADD COLUMN summery TEXT");
            } catch (Exception e22) {
                C0596r.a("DB", e22.getMessage());
            }
        }
        if (i >= 11) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackdeathbook(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,type INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL, UNIQUE (trackid) ON CONFLICT REPLACE);");
            } catch (Exception e222) {
                C0596r.a("DB", e222.getMessage());
            }
        }
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sportconfig(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,data TEXT,sync INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,date TEXT,trackid INTEGER,distance REAL DEFAULT 0,usedtime INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL,groupCnt INTEGER DEFAULT 0,sync INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackloc(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,latitude REAL,longitude REAL,altitude REAL,time INTEGER,extra TEXT, UNIQUE (time) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contourtrack(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,uri TEXT,summery TEXT,data TEXT,synced INTEGER DEFAULT 0,gcnt INTEGER DEFAULT 0,v INTEGER DEFAULT 0,type INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackdeathbook(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,type INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL, UNIQUE (trackid) ON CONFLICT REPLACE);");
    }
}
