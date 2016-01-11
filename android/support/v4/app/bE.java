package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import java.util.HashSet;
import java.util.Set;
import kankan.wheel.widget.a;

public class bE {
    public static final String a = "android.support.useSideChannel";
    public static final String b = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    static final int c = 19;
    private static final String d = "NotifManCompat";
    private static final int e = 1000;
    private static final int f = 6;
    private static final String g = "enabled_notification_listeners";
    private static final int h = p.a();
    private static final Object i = new Object();
    private static String j;
    private static Set<String> k = new HashSet();
    private static final Object n = new Object();
    private static bM o;
    private static final bG p;
    private final Context l;
    private final NotificationManager m = ((NotificationManager) this.l.getSystemService("notification"));

    static {
        if (VERSION.SDK_INT >= 14) {
            p = new C0039bJ();
        } else if (VERSION.SDK_INT >= 5) {
            p = new bI();
        } else {
            p = new bH();
        }
    }

    private bE(Context context) {
        this.l = context;
    }

    public static bE a(Context context) {
        return new bE(context);
    }

    private void a(bO bOVar) {
        synchronized (n) {
            if (o == null) {
                o = new bM(this.l.getApplicationContext());
            }
        }
        o.a(bOVar);
    }

    private static boolean a(Notification notification) {
        Bundle a = aK.a(notification);
        return a != null && a.getBoolean(a);
    }

    public static Set<String> b(Context context) {
        String string = Secure.getString(context.getContentResolver(), g);
        if (!(string == null || string.equals(j))) {
            String[] split = string.split(a.ci);
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (i) {
                k = hashSet;
                j = string;
            }
        }
        return k;
    }

    public void a() {
        this.m.cancelAll();
        if (VERSION.SDK_INT <= c) {
            a(new bF(this.l.getPackageName()));
        }
    }

    public void a(int i) {
        a(null, i);
    }

    public void a(int i, Notification notification) {
        a(null, i, notification);
    }

    public void a(String str, int i) {
        p.a(this.m, str, i);
        if (VERSION.SDK_INT <= c) {
            a(new bF(this.l.getPackageName(), i, str));
        }
    }

    public void a(String str, int i, Notification notification) {
        if (a(notification)) {
            a(new bK(this.l.getPackageName(), i, str, notification));
            p.a(this.m, str, i);
            return;
        }
        p.a(this.m, str, i, notification);
    }
}
