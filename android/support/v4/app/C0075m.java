package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.a.r;
import android.support.v4.content.c;

public class C0075m extends c {
    private static C0076p a(cn cnVar) {
        return cnVar != null ? new C0077n(cnVar) : null;
    }

    public static void a(Activity activity, Intent intent, int i, @r Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0081s.a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, Intent intent, @r Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0081s.a(activity, intent, bundle);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void a(Activity activity, cn cnVar) {
        if (VERSION.SDK_INT >= 21) {
            C0078o.a(activity, C0075m.a(cnVar));
        }
    }

    public static boolean a(Activity activity) {
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        C0080r.a(activity);
        return true;
    }

    public static void b(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0081s.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity, cn cnVar) {
        if (VERSION.SDK_INT >= 21) {
            C0078o.b(activity, C0075m.a(cnVar));
        }
    }

    public static void c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0078o.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0078o.b(activity);
        }
    }

    public static void e(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0078o.c(activity);
        }
    }
}
