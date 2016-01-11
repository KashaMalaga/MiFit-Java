package cn.com.smartdevices.bracelet.shoes.data.db;

public final class e {
    public static final String a = "myshoesstat";
    static final String b = "CREATE TABLE IF NOT EXISTS myshoesstat ( _id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,source INTEGER,mac TEXT NOT NULL DEFAULT '',deviceid TEXT NOT NULL DEFAULT '',sn TEXT NOT NULL DEFAULT '',shoesid TEXT ,nexttimestamp INTEGER DEFAULT 0, UNIQUE (deviceid,sn,shoesid) ON CONFLICT REPLACE)";
    static final String c = "ALTER TABLE myshoesstat ADD COLUMN sn TEXT DEFAULT ''";
    static final String d = "ALTER TABLE myshoesstat ADD COLUMN deviceid TEXT DEFAULT ''";
    static final String e = "ALTER TABLE myshoesstat ADD COLUMN shoesid TEXT DEFAULT ''";
}
