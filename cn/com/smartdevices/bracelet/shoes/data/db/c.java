package cn.com.smartdevices.bracelet.shoes.data.db;

public final class c {
    public static final String a = "myshoes";
    static final String b = "CREATE TABLE IF NOT EXISTS myshoes ( _id INTEGER PRIMARY KEY AUTOINCREMENT,date INTEGER DEFAULT 0,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,brand TEXT,type INTEGER DEFAULT 0,state INTEGER DEFAULT 0,summary TEXT,synced INTEGER DEFAULT 0,cached TEXT, UNIQUE (deviceid,sn,shoesid) ON CONFLICT REPLACE)";
    static final String c = "ALTER TABLE myshoes ADD COLUMN brand TEXT";
    static final String d = "ALTER TABLE myshoes ADD COLUMN type INTEGER";
    static final String e = "ALTER TABLE myshoes ADD COLUMN cached TEXT";
    static final String f = "ALTER TABLE myshoes ADD COLUMN sn TEXT DEFAULT ''";
    static final String g = "ALTER TABLE myshoes ADD COLUMN deviceid TEXT DEFAULT ''";
    static final String h = "ALTER TABLE myshoes ADD COLUMN shoesid TEXT DEFAULT ''";
}
