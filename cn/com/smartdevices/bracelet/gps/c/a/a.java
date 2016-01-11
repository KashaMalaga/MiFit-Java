package cn.com.smartdevices.bracelet.gps.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;

abstract class a extends SQLiteOpenHelper {
    static final String a = "SDB";
    private static final String b = "sports.db";
    private static final int c = 3;

    public a(Context context) {
        super(context, b, null, c);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM sportconfig");
            sQLiteDatabase.execSQL("DELETE FROM trackinfo");
            sQLiteDatabase.execSQL("DELETE FROM trackloc");
            sQLiteDatabase.execSQL("DELETE FROM contourtrack");
            sQLiteDatabase.execSQL("DELETE FROM trackdeathbook");
            sQLiteDatabase.execSQL("DELETE FROM sportstat");
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
        }
    }

    protected static void a(Exception exception) {
        C0596r.a(a, exception.getMessage());
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) ? false : b.a.equals(str) || l.a.equals(str) || h.a.equals(str) || f.a.equals(str) || d.a.equals(str);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sportconfig(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,data TEXT,sync INTEGER DEFAULT 0 , UNIQUE (type) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,date TEXT,trackid INTEGER,distance REAL DEFAULT 0,usedtime INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL,groupCnt INTEGER DEFAULT 0,sync INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackloc(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,latitude REAL,longitude REAL,altitude REAL,time INTEGER,extra TEXT, UNIQUE (time) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS contourtrack(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,uri TEXT,summery TEXT,data TEXT,synced INTEGER DEFAULT 0,gcnt INTEGER DEFAULT 0,v INTEGER DEFAULT 0,type INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS trackdeathbook(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,type INTEGER DEFAULT 4,summary TEXT,data TEXT DEFAULT NULL, UNIQUE (trackid) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sportstat(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,trackid INTEGER,summary TEXT,state INTEGER DEFAULT 0 , UNIQUE (type) ON CONFLICT REPLACE);");
    }

    protected SQLiteDatabase a(boolean z) {
        if (!z) {
            return getReadableDatabase();
        }
        try {
            return getWritableDatabase();
        } catch (Throwable e) {
            Log.e(a, e.getMessage(), e);
            C0596r.a(a, e.getMessage());
            return z ? getWritableDatabase() : getReadableDatabase();
        }
    }

    public void a() {
        C0596r.e(a, "clearGPSSportTable");
        a(a(true));
    }

    protected void b() {
        try {
            close();
        } catch (IllegalStateException e) {
            C0596r.a(a, e.getMessage());
        }
    }

    protected void c() {
        C0596r.e(a, "dropAllDataTable");
        a(a(true));
    }

    protected void d() {
        b();
        try {
            a(false);
        } catch (SQLiteException e) {
            C0596r.a(a, e.getMessage());
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0596r.e(a, "BaseSportDBHelper onCreate");
        b(sQLiteDatabase);
    }

    @SuppressLint({"NewApi"})
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e(a, "onDowngrade  oldVersion = " + i + "  newVersion = " + i2);
        super.onDowngrade(sQLiteDatabase, i, i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e(a, "onUpgrade  oldVersion = " + i + "  newVersion = " + i2);
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sportstat(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,trackid INTEGER,summary TEXT,state INTEGER DEFAULT 0 , UNIQUE (type) ON CONFLICT REPLACE);");
            } catch (Exception e) {
                C0596r.a(a, e.getMessage());
            }
        }
        if (i < c) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE sportstat ADD COLUMN trackid INTEGER");
            } catch (Exception e2) {
                C0596r.a(a, e2.getMessage());
            }
        }
    }
}
