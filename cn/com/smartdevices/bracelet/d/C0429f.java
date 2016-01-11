package cn.com.smartdevices.bracelet.d;

public final class C0429f {
    public static final long a = 600000;
    public static final long b = 86400000;
    public static final long c = 604800000;
    public static final long d = -1;
    public static final String e = "localcache";
    static final String f = "CREATE TABLE IF NOT EXISTS localcache(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,expire_time BIGINT,sync INTEGER DEFAULT 0,reserved1 TEXT,reserved2 TEXT);";
}
