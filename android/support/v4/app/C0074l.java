package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class C0074l {
    private static final String a = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] b = new int[]{16843531};

    C0074l() {
    }

    public static Drawable a(Activity activity) {
        Context themedContext;
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            themedContext = actionBar.getThemedContext();
        }
        TypedArray obtainStyledAttributes = themedContext.obtainStyledAttributes(null, b, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static Object a(Object obj, Activity activity, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }

    public static Object a(Object obj, Activity activity, Drawable drawable, int i) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
        return obj;
    }
}
