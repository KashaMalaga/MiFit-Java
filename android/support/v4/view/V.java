package android.support.v4.view;

import android.view.MenuItem;

class V {
    V() {
    }

    public static MenuItem a(MenuItem menuItem, X x) {
        return menuItem.setOnActionExpandListener(new W(x));
    }

    public static boolean a(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static boolean b(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    public static boolean c(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }
}
