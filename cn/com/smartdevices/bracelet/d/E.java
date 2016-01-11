package cn.com.smartdevices.bracelet.d;

public final class E {
    public static final String a = "date_data";
    static final String b = "CREATE TABLE IF NOT EXISTS date_data(id INTEGER PRIMARY KEY AUTOINCREMENT,type INTEGER DEFAULT 0,source INTEGER DEFAULT 0,date TEXT,summary TEXT,indexs TEXT,data BLOB,data_hr BLOB,summary_hr TEXT,sync INTEGER);";
    static final String c = "ALTER TABLE date_data ADD COLUMN summary_hr TEXT;";
    static final String d = "ALTER TABLE date_data ADD COLUMN data_hr BLOB;";
}
