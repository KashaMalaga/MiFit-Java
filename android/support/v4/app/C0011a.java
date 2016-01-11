package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.c;
import android.support.v4.view.C0198v;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.u;
import android.view.MenuItem;
import android.view.View;

@Deprecated
public class C0011a implements u {
    private static final C0065c a;
    private static final float b = 0.33333334f;
    private static final int c = 16908332;
    private final Activity d;
    private final C0069g e;
    private final DrawerLayout f;
    private boolean g;
    private boolean h;
    private Drawable i;
    private Drawable j;
    private C0071i k;
    private final int l;
    private final int m;
    private final int n;
    private Object o;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            a = new C0068f();
        } else if (i >= 11) {
            a = new C0067e();
        } else {
            a = new C0066d();
        }
    }

    public C0011a(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !C0011a.a((Context) activity), i, i2, i3);
    }

    public C0011a(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.g = true;
        this.d = activity;
        if (activity instanceof C0070h) {
            this.e = ((C0070h) activity).a();
        } else {
            this.e = null;
        }
        this.f = drawerLayout;
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.i = c();
        this.j = c.a((Context) activity, i);
        this.k = new C0071i(this, this.j);
        this.k.b(z ? b : 0.0f);
    }

    private static boolean a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && VERSION.SDK_INT >= 21;
    }

    public void a() {
        if (this.f.k((int) C0198v.c)) {
            this.k.a(1.0f);
        } else {
            this.k.a(0.0f);
        }
        if (this.g) {
            a(this.k, this.f.k((int) C0198v.c) ? this.n : this.m);
        }
    }

    public void a(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = c.a(this.d, i);
        }
        a(drawable);
    }

    public void a(Configuration configuration) {
        if (!this.h) {
            this.i = c();
        }
        this.j = c.a(this.d, this.l);
        a();
    }

    public void a(Drawable drawable) {
        if (drawable == null) {
            this.i = c();
            this.h = false;
        } else {
            this.i = drawable;
            this.h = true;
        }
        if (!this.g) {
            a(this.i, 0);
        }
    }

    void a(Drawable drawable, int i) {
        if (this.e != null) {
            this.e.a(drawable, i);
        } else {
            this.o = a.a(this.o, this.d, drawable, i);
        }
    }

    public void a(View view) {
        this.k.a(1.0f);
        if (this.g) {
            c(this.n);
        }
    }

    public void a(View view, float f) {
        float a = this.k.a();
        this.k.a(f > 0.5f ? Math.max(a, Math.max(0.0f, f - 0.5f) * 2.0f) : Math.min(a, f * 2.0f));
    }

    public void a(boolean z) {
        if (z != this.g) {
            if (z) {
                a(this.k, this.f.k((int) C0198v.c) ? this.n : this.m);
            } else {
                a(this.i, 0);
            }
            this.g = z;
        }
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != c || !this.g) {
            return false;
        }
        if (this.f.l((int) C0198v.c)) {
            this.f.j((int) C0198v.c);
        } else {
            this.f.i((int) C0198v.c);
        }
        return true;
    }

    public void b(int i) {
    }

    public void b(View view) {
        this.k.a(0.0f);
        if (this.g) {
            c(this.m);
        }
    }

    public boolean b() {
        return this.g;
    }

    Drawable c() {
        return this.e != null ? this.e.a() : a.a(this.d);
    }

    void c(int i) {
        if (this.e != null) {
            this.e.a(i);
        } else {
            this.o = a.a(this.o, this.d, i);
        }
    }
}
