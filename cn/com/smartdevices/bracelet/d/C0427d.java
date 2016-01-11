package cn.com.smartdevices.bracelet.d;

import cn.com.smartdevices.bracelet.push.i;

public class C0427d {
    public static final String a = "cloud_config";
    static final String b = "CREATE TABLE IF NOT EXISTS cloud_config(_id INTEGER PRIMARY KEY AUTOINCREMENT,config TEXT,value TEXT,time_stamp BIGINT,dummy1 TEXT,dummy2 TEXT,dummy3 TEXT,dummy4 TEXT, dummy5 TEXT);";

    static boolean a(String str) {
        return i.e.equals(str) || C0428e.c.equals(str);
    }

    static boolean a(String[] strArr) {
        for (String a : strArr) {
            if (!C0427d.a(a)) {
                return false;
            }
        }
        return true;
    }
}
