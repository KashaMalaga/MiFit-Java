package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public class ce {
    public static final String a = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    public static final String b = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    private static ch c;

    static {
        if (VERSION.SDK_INT >= 16) {
            c = new ck();
        } else if (VERSION.SDK_INT >= 14) {
            c = new cj();
        } else {
            c = new ci();
        }
    }

    public static String a(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        return callingPackage == null ? activity.getIntent().getStringExtra(a) : callingPackage;
    }

    public static void a(Menu menu, int i, cf cfVar) {
        MenuItem findItem = menu.findItem(i);
        if (findItem == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
        }
        a(findItem, cfVar);
    }

    public static void a(MenuItem menuItem, cf cfVar) {
        c.a(menuItem, cfVar);
    }

    public static ComponentName b(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? (ComponentName) activity.getIntent().getParcelableExtra(b) : callingActivity;
    }
}
