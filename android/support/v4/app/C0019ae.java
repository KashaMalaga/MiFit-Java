package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.ae;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0019ae extends ae {
    private static final String c = "FragmentStatePagerAdapter";
    private static final boolean d = false;
    private final R e;
    private aj f = null;
    private ArrayList<SavedState> g = new ArrayList();
    private ArrayList<Fragment> h = new ArrayList();
    private Fragment i = null;

    public C0019ae(R r) {
        this.e = r;
    }

    public Parcelable a() {
        Bundle bundle = null;
        if (this.g.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.g.size()];
            this.g.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.h.size(); i++) {
            Fragment fragment = (Fragment) this.h.get(i);
            if (fragment != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.e.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public abstract Fragment a(int i);

    public Object a(ViewGroup viewGroup, int i) {
        if (this.h.size() > i) {
            Fragment fragment = (Fragment) this.h.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f == null) {
            this.f = this.e.a();
        }
        Fragment a = a(i);
        if (this.g.size() > i) {
            SavedState savedState = (SavedState) this.g.get(i);
            if (savedState != null) {
                a.setInitialSavedState(savedState);
            }
        }
        while (this.h.size() <= i) {
            this.h.add(null);
        }
        a.setMenuVisibility(false);
        a.setUserVisibleHint(false);
        this.h.set(i, a);
        this.f.a(viewGroup.getId(), a);
        return a;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.g.clear();
            this.h.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.g.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.e.a(bundle, str);
                    if (a != null) {
                        while (this.h.size() <= parseInt) {
                            this.h.add(null);
                        }
                        a.setMenuVisibility(false);
                        this.h.set(parseInt, a);
                    } else {
                        Log.w(c, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f == null) {
            this.f = this.e.a();
        }
        while (this.g.size() <= i) {
            this.g.add(null);
        }
        this.g.set(i, this.e.a(fragment));
        this.h.set(i, null);
        this.f.a(fragment);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
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
        if (fragment != this.i) {
            if (this.i != null) {
                this.i.setMenuVisibility(false);
                this.i.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.i = fragment;
        }
    }
}
