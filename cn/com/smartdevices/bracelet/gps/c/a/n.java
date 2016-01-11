package cn.com.smartdevices.bracelet.gps.c.a;

public final class n {
    public static final String a = "DROP VIEW trackinfoview";
    public static final String b = "trackinfoview";
    public static final String c = "CREATE TEMP VIEW trackinfoview AS SELECT *, strftime('%Y-%m',trackinfo.date) AS month FROM trackinfo";
}
