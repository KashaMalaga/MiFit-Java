package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.a.r;
import android.support.v4.content.l;
import android.support.v4.view.a.C0113o;

public class aC {
    public static final String a = "android.support.PARENT_ACTIVITY";
    private static final String b = "NavUtils";
    private static final aD c;

    static {
        if (VERSION.SDK_INT >= 16) {
            c = new aF();
        } else {
            c = new aE();
        }
    }

    private aC() {
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? l.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static Intent a(Context context, Class<?> cls) {
        String b = b(context, new ComponentName(context, cls));
        if (b == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, b);
        return b(context, componentName) == null ? l.a(componentName) : new Intent().setComponent(componentName);
    }

    public static void a(Activity activity) {
        Intent b = b(activity);
        if (b == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        b(activity, b);
    }

    public static boolean a(Activity activity, Intent intent) {
        return c.a(activity, intent);
    }

    public static Intent b(Activity activity) {
        return c.a(activity);
    }

    @r
    public static String b(Context context, ComponentName componentName) {
        return c.a(context, context.getPackageManager().getActivityInfo(componentName, C0113o.h));
    }

    public static void b(Activity activity, Intent intent) {
        c.b(activity, intent);
    }

    @r
    public static String c(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
