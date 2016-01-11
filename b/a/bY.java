package b.a;

import android.content.Context;
import android.content.res.Resources;
import cn.com.smartdevices.bracelet.push.f;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;

public class bY {
    private static final String a = bY.class.getName();
    private static bY b = null;
    private Resources c;
    private final String d;
    private final String e = "drawable";
    private final String f = SyncShoesDataService.d;
    private final String g = "layout";
    private final String h = "anim";
    private final String i = f.m;
    private final String j = "string";
    private final String k = "array";

    private bY(Context context) {
        this.c = context.getResources();
        this.d = context.getPackageName();
    }

    private int a(String str, String str2) {
        int identifier = this.c.getIdentifier(str, str2, this.d);
        if (identifier != 0) {
            return identifier;
        }
        bX.b(a, "getRes(" + str2 + "/ " + str + ")");
        bX.b(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        return 0;
    }

    public static synchronized bY a(Context context) {
        bY bYVar;
        synchronized (bY.class) {
            if (b == null) {
                b = new bY(context.getApplicationContext());
            }
            bYVar = b;
        }
        return bYVar;
    }

    public int a(String str) {
        return a(str, "anim");
    }

    public int b(String str) {
        return a(str, SyncShoesDataService.d);
    }

    public int c(String str) {
        return a(str, "drawable");
    }

    public int d(String str) {
        return a(str, "layout");
    }

    public int e(String str) {
        return a(str, f.m);
    }

    public int f(String str) {
        return a(str, "string");
    }

    public int g(String str) {
        return a(str, "array");
    }
}
