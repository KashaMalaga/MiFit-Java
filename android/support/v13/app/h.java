package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;
import kankan.wheel.widget.a;

public abstract class h extends ae {
    private static final String c = "FragmentPagerAdapter";
    private static final boolean d = false;
    private final FragmentManager e;
    private FragmentTransaction f = null;
    private Fragment g = null;

    public h(FragmentManager fragmentManager) {
        this.e = fragmentManager;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + a.ci + j;
    }

    public abstract Fragment a(int i);

    public Parcelable a() {
        return null;
    }

    public Object a(ViewGroup viewGroup, int i) {
        if (this.f == null) {
            this.f = this.e.beginTransaction();
        }
        long b = b(i);
        Fragment findFragmentByTag = this.e.findFragmentByTag(a(viewGroup.getId(), b));
        if (findFragmentByTag != null) {
            this.f.attach(findFragmentByTag);
        } else {
            findFragmentByTag = a(i);
            this.f.add(viewGroup.getId(), findFragmentByTag, a(viewGroup.getId(), b));
        }
        if (findFragmentByTag != this.g) {
            a.a(findFragmentByTag, false);
            a.b(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f == null) {
            this.f = this.e.beginTransaction();
        }
        this.f.detach((Fragment) obj);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public long b(int i) {
        return (long) i;
    }

    public void b(ViewGroup viewGroup) {
        if (this.f != null) {
            this.f.commitAllowingStateLoss();
            this.f = null;
            this.e.executePendingTransactions();
        }
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.g) {
            if (this.g != null) {
                a.a(this.g, false);
                a.b(this.g, false);
            }
            if (fragment != null) {
                a.a(fragment, true);
                a.b(fragment, true);
            }
            this.g = fragment;
        }
    }
}
