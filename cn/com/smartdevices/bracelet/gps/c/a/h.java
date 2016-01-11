package cn.com.smartdevices.bracelet.gps.c.a;

public final class h {
    public static final String a = "sportconfig";
    static final String b = "CREATE TABLE IF NOT EXISTS sportconfig(_id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER,data TEXT,sync INTEGER DEFAULT 0 , UNIQUE (type) ON CONFLICT REPLACE);";
}
