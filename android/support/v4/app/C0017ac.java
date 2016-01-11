package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;
import kankan.wheel.widget.a;

public abstract class C0017ac extends ae {
    private static final String c = "FragmentPagerAdapter";
    private static final boolean d = false;
    private final R e;
    private aj f = null;
    private Fragment g = null;

    public C0017ac(R r) {
        this.e = r;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + a.ci + j;
    }

    public Parcelable a() {
        return null;
    }

    public abstract Fragment a(int i);

    public Object a(ViewGroup viewGroup, int i) {
        if (this.f == null) {
            this.f = this.e.a();
        }
        long b = b(i);
        Fragment a = this.e.a(C0017ac.a(viewGroup.getId(), b));
        if (a != null) {
            this.f.e(a);
        } else {
            a = a(i);
            this.f.a(viewGroup.getId(), a, C0017ac.a(viewGroup.getId(), b));
        }
        if (a != this.g) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f == null) {
            this.f = this.e.a();
        }
        this.f.d((Fragment) obj);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public long b(int i) {
        return (long) i;
    }

    public void b(ViewGroup viewGroup) {
        if (this.f != null) {
            this.f.i();
            this.f = null;
            this.e.c();
        }
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.g) {
            if (this.g != null) {
                this.g.setMenuVisibility(false);
                this.g.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.g = fragment;
        }
    }
}
