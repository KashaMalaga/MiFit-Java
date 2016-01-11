package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;

abstract class a extends SQLiteOpenHelper {
    static final String a = "SDB";
    private static final String b = "shoes.db";
    private static final int c = 8;

    public a(Context context) {
        super(context, b, null, c);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM partners");
            sQLiteDatabase.execSQL("DELETE FROM myshoes");
            sQLiteDatabase.execSQL("DELETE FROM shoesdata");
            sQLiteDatabase.execSQL("DELETE FROM myshoesstat");
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN brand TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN type INTEGER");
            } catch (Exception e) {
            }
        }
        if (i < 3) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE partners ADD COLUMN uri TEXT");
            } catch (Exception e2) {
            }
        }
        if (i < 4) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN cached TEXT");
            } catch (Exception e3) {
            }
        }
        if (i < 5) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS myshoesstat ( _id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,nexttimestamp INTEGER DEFAULT 0, UNIQUE (deviceid,sn,shoesid) ON CONFLICT REPLACE)");
            } catch (Exception e4) {
            }
        }
        if (i < 6) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE partners ADD COLUMN biguri TEXT");
            } catch (Exception e5) {
            }
        }
        if (i < 7) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE partners ADD COLUMN synctime INTEGER DEFAULT 0");
            } catch (Exception e6) {
            }
        }
        if (i < c) {
            try {
                String a = k.a(sQLiteDatabase, c.a);
                if (!TextUtils.isEmpty(a)) {
                    if (!a.contains(g.t)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN deviceid TEXT DEFAULT ''");
                    }
                    if (!a.contains(g.p)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN sn TEXT DEFAULT ''");
                    }
                    if (!a.contains(b.e)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoes ADD COLUMN shoesid TEXT DEFAULT ''");
                    }
                }
                a = k.a(sQLiteDatabase, g.a);
                if (!TextUtils.isEmpty(a)) {
                    if (!a.contains(g.t)) {
                        sQLiteDatabase.execSQL("ALTER TABLE shoesdata ADD COLUMN deviceid TEXT DEFAULT  ''");
                    }
                    if (!a.contains(g.p)) {
                        sQLiteDatabase.execSQL("ALTER TABLE shoesdata ADD COLUMN sn TEXT DEFAULT ''");
                    }
                    if (!a.contains(b.e)) {
                        sQLiteDatabase.execSQL("ALTER TABLE shoesdata ADD COLUMN shoesid TEXT DEFAULT ''");
                    }
                }
                String a2 = k.a(sQLiteDatabase, e.a);
                if (!TextUtils.isEmpty(a2)) {
                    if (!a2.contains(g.t)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoesstat ADD COLUMN deviceid TEXT DEFAULT ''");
                    }
                    if (!a2.contains(g.p)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoesstat ADD COLUMN sn TEXT DEFAULT ''");
                    }
                    if (!a.contains(b.e)) {
                        sQLiteDatabase.execSQL("ALTER TABLE myshoesstat ADD COLUMN shoesid TEXT DEFAULT ''");
                    }
                }
            } catch (Exception e7) {
            }
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS partners ( _id INTEGER PRIMARY KEY AUTOINCREMENT,brand TEXT,type INTEGER DEFAULT 0,synctime INTEGER DEFAULT 0,summary TEXT,biguri TEXT,uri TEXT, UNIQUE (brand,type) ON CONFLICT REPLACE)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS myshoes ( _id INTEGER PRIMARY KEY AUTOINCREMENT,date INTEGER DEFAULT 0,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,brand TEXT,type INTEGER DEFAULT 0,state INTEGER DEFAULT 0,summary TEXT,synced INTEGER DEFAULT 0,cached TEXT, UNIQUE (deviceid,sn,shoesid) ON CONFLICT REPLACE)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shoesdata ( _id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,date TEXT,summary TEXT,data BLOB,synced INTEGER DEFAULT 0, UNIQUE (date,deviceid,sn,shoesid) ON CONFLICT REPLACE)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS myshoesstat ( _id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,nexttimestamp INTEGER DEFAULT 0, UNIQUE (deviceid,sn,shoesid) ON CONFLICT REPLACE)");
    }

    protected SQLiteDatabase a(boolean z) {
        if (!z) {
            return getReadableDatabase();
        }
        try {
            return getWritableDatabase();
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return z ? getWritableDatabase() : getReadableDatabase();
        }
    }

    protected void a() {
        try {
            close();
        } catch (IllegalStateException e) {
            C0596r.a(a, e.getMessage());
        }
    }

    protected void b() {
        C0596r.e(a, "dropAllDataTable");
        a(a(true));
    }

    protected void c() {
        a();
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

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e(a, "onDowngrade  oldVersion = " + i + "  newVersion = " + i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e(a, "onUpgrade  oldVersion = " + i + "  newVersion = " + i2);
        a(sQLiteDatabase, i, i2);
    }
}
