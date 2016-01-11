package cn.com.smartdevices.bracelet.shoes.data.db;

public final class g {
    public static final String a = "shoesdata";
    static final String b = "CREATE TABLE IF NOT EXISTS shoesdata ( _id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,date TEXT,summary TEXT,data BLOB,synced INTEGER DEFAULT 0, UNIQUE (date,deviceid,sn,shoesid) ON CONFLICT REPLACE)";
    static final String c = "ALTER TABLE shoesdata ADD COLUMN sn TEXT DEFAULT ''";
    static final String d = "ALTER TABLE shoesdata ADD COLUMN deviceid TEXT DEFAULT  ''";
    static final String e = "ALTER TABLE shoesdata ADD COLUMN shoesid TEXT DEFAULT ''";
}
