package cn.com.smartdevices.bracelet.d;

public final class o {
    public static final String a = "trackloc";
    static final String b = "CREATE TABLE IF NOT EXISTS trackloc(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,latitude REAL,longitude REAL,altitude REAL,time INTEGER,extra TEXT, UNIQUE (time) ON CONFLICT REPLACE);";
}
