package cn.com.smartdevices.bracelet.gps.c.a;

public final class d {
    public static final String a = "trackinfo";
    static final String b = "CREATE TABLE IF NOT EXISTS trackinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,date TEXT,trackid INTEGER,distance REAL DEFAULT 0,usedtime INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL,groupCnt INTEGER DEFAULT 0,sync INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE);";
    static final String c = "ALTER TABLE trackinfo ADD COLUMN groupCnt INTEGER";
    static final String d = "ALTER TABLE trackinfo ADD COLUMN distance REAL DEFAULT 0";
    static final String e = "ALTER TABLE trackinfo ADD COLUMN usedtime INTEGER DEFAULT 0";
}
