package cn.com.smartdevices.bracelet.shoes.data.db;

public final class i {
    public static final String a = "partners";
    static final String b = "CREATE TABLE IF NOT EXISTS partners ( _id INTEGER PRIMARY KEY AUTOINCREMENT,brand TEXT,type INTEGER DEFAULT 0,synctime INTEGER DEFAULT 0,summary TEXT,biguri TEXT,uri TEXT, UNIQUE (brand,type) ON CONFLICT REPLACE)";
    static final String c = "ALTER TABLE partners ADD COLUMN uri TEXT";
    static final String d = "ALTER TABLE partners ADD COLUMN biguri TEXT";
    static final String e = "ALTER TABLE partners ADD COLUMN synctime INTEGER DEFAULT 0";
}
