package cn.com.smartdevices.bracelet.d;

public final class s {
    public static final String a = "trackdeathbook";
    static final String b = "CREATE TABLE IF NOT EXISTS trackdeathbook(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,type INTEGER DEFAULT 0,summary TEXT,data TEXT DEFAULT NULL, UNIQUE (trackid) ON CONFLICT REPLACE);";
}
