package cn.com.smartdevices.bracelet.gps.c.a;

public final class j {
    public static final String a = "sportstat";
    static final String b = "CREATE TABLE IF NOT EXISTS sportstat(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,trackid INTEGER,summary TEXT,state INTEGER DEFAULT 0 , UNIQUE (type) ON CONFLICT REPLACE);";
    static final String c = "ALTER TABLE sportstat ADD COLUMN trackid INTEGER";
}
