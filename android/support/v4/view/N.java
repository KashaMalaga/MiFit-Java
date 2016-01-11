package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.e.a.b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class N {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    static final S f;
    private static final String g = "MenuItemCompat";

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f = new Q();
        } else if (i >= 11) {
            f = new P();
        } else {
            f = new O();
        }
    }

    public static MenuItem a(MenuItem menuItem, T t) {
        return menuItem instanceof b ? ((b) menuItem).a(t) : f.a(menuItem, t);
    }

    public static MenuItem a(MenuItem menuItem, C0190n c0190n) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a(c0190n);
        }
        Log.w(g, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem instanceof b ? ((b) menuItem).setActionView(view) : f.a(menuItem, view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).getActionView() : f.a(menuItem);
    }

    public static void a(MenuItem menuItem, int i) {
        if (menuItem instanceof b) {
            ((b) menuItem).setShowAsAction(i);
        } else {
            f.a(menuItem, i);
        }
    }

    public static C0190n b(MenuItem menuItem) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a();
        }
        Log.w(g, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static MenuItem b(MenuItem menuItem, int i) {
        return menuItem instanceof b ? ((b) menuItem).setActionView(i) : f.b(menuItem, i);
    }

    public static boolean c(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).expandActionView() : f.b(menuItem);
    }

    public static boolean d(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).collapseActionView() : f.c(menuItem);
    }

    public static boolean e(MenuItem menuItem) {
        return menuItem instanceof b ? ((b) menuItem).isActionViewExpanded() : f.d(menuItem);
    }
}
