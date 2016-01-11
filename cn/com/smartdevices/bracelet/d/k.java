package cn.com.smartdevices.bracelet.d;

public final class k {
    public static final String a = "contourtrack";
    static final String b = "CREATE TABLE IF NOT EXISTS contourtrack(_id INTEGER PRIMARY KEY AUTOINCREMENT,trackid INTEGER,uri TEXT,summery TEXT,data TEXT,synced INTEGER DEFAULT 0,gcnt INTEGER DEFAULT 0,v INTEGER DEFAULT 0,type INTEGER DEFAULT 0, UNIQUE (trackid) ON CONFLICT REPLACE );";
    static final String c = "ALTER TABLE contourtrack ADD COLUMN summery TEXT";
}
