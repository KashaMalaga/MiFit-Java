package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class W implements OnActionExpandListener {
    private X a;

    public W(X x) {
        this.a = x;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.a.b(menuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.a.a(menuItem);
    }
}
