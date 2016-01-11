package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;

class C0072j {
    private static final String a = "ActionBarDrawerToggleHoneycomb";
    private static final int[] b = new int[]{16843531};

    C0072j() {
    }

    public static Drawable a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(b);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static Object a(Object obj, Activity activity, int i) {
        Object c0073k = obj == null ? new C0073k(activity) : obj;
        C0073k c0073k2 = (C0073k) c0073k;
        if (c0073k2.a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0073k2.b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w(a, "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return c0073k;
    }

    public static Object a(Object obj, Activity activity, Drawable drawable, int i) {
        Object c0073k = obj == null ? new C0073k(activity) : obj;
        C0073k c0073k2 = (C0073k) c0073k;
        if (c0073k2.a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0073k2.a.invoke(actionBar, new Object[]{drawable});
                c0073k2.b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w(a, "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (c0073k2.c != null) {
            c0073k2.c.setImageDrawable(drawable);
        } else {
            Log.w(a, "Couldn't set home-as-up indicator");
        }
        return c0073k;
    }
}
