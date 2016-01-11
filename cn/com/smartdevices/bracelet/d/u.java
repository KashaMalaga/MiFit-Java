package cn.com.smartdevices.bracelet.d;

public final class u {
    public static final String a = "DROP VIEW trackinfoview";
    public static final String b = "trackinfoview";
    public static final String c = "CREATE TEMP VIEW trackinfoview AS SELECT *, strftime('%Y-%m',trackinfo.date) AS month FROM trackinfo";
}
