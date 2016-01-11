package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0190n {
    private static final String a = "ActionProvider(support)";
    private final Context b;
    private C0191o c;
    private C0192p d;

    public C0190n(Context context) {
        this.b = context;
    }

    public Context a() {
        return this.b;
    }

    public View a(MenuItem menuItem) {
        return b();
    }

    public void a(C0191o c0191o) {
        this.c = c0191o;
    }

    public void a(C0192p c0192p) {
        if (!(this.d == null || c0192p == null)) {
            Log.w(a, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.d = c0192p;
    }

    public void a(SubMenu subMenu) {
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    public abstract View b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public void e() {
        if (this.d != null && c()) {
            this.d.a(d());
        }
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }
}
