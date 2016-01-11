package android.support.v4.view;

import android.view.MenuItem;

class Q extends P {
    Q() {
    }

    public MenuItem a(MenuItem menuItem, T t) {
        return t == null ? V.a(menuItem, null) : V.a(menuItem, new R(this, t));
    }

    public boolean b(MenuItem menuItem) {
        return V.a(menuItem);
    }

    public boolean c(MenuItem menuItem) {
        return V.b(menuItem);
    }

    public boolean d(MenuItem menuItem) {
        return V.c(menuItem);
    }
}
