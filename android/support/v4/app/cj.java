package android.support.v4.app;

import android.view.MenuItem;

class cj extends ci {
    cj() {
    }

    public void a(MenuItem menuItem, cf cfVar) {
        cl.a(menuItem, cfVar.b(), cfVar.a());
        if (a(menuItem)) {
            menuItem.setIntent(cfVar.c());
        }
    }

    boolean a(MenuItem menuItem) {
        return !menuItem.hasSubMenu();
    }
}
