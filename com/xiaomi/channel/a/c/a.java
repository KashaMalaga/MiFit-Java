package com.xiaomi.channel.a.c;

import com.xiaomi.market.sdk.o;

public class a {
    public static final boolean a = o.w.contains("2A2FE0D7");
    public static final boolean b;
    public static final boolean c = "LOGABLE".equalsIgnoreCase(o.w);
    public static final boolean d = o.w.contains("YY");
    public static boolean e = o.w.equalsIgnoreCase("TEST");
    public static final boolean f = "BETA".equalsIgnoreCase(o.w);
    public static final boolean g;
    private static int h;

    static {
        boolean z = false;
        boolean z2 = a || "DEBUG".equalsIgnoreCase(o.w);
        b = z2;
        if (o.w != null && o.w.startsWith("RC")) {
            z = true;
        }
        g = z;
        h = 1;
        if (o.w.equalsIgnoreCase("SANDBOX")) {
            h = 2;
        } else if (o.w.equalsIgnoreCase("ONEBOX")) {
            h = 3;
        } else {
            h = 1;
        }
    }

    public static void a(int i) {
        h = i;
    }

    public static boolean a() {
        return h == 2;
    }

    public static boolean b() {
        return h == 3;
    }

    public static int c() {
        return h;
    }
}
