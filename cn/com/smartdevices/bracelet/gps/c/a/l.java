package cn.com.smartdevices.bracelet.gps.c.a;

public final class l {
    public static final String a = "trackdeathbook";
    static final String b = "CREATE TABLE IF NOT EXISTS trackdeathbook(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,type INTEGER DEFAULT 4,summary TEXT,data TEXT DEFAULT NULL, UNIQUE (trackid) ON CONFLICT REPLACE);";
}
