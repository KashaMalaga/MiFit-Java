package android.support.v13.app;

import android.app.Fragment;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ae;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class i extends ae {
    private static final String c = "FragmentStatePagerAdapter";
    private static final boolean d = false;
    private final FragmentManager e;
    private FragmentTransaction f = null;
    private ArrayList<SavedState> g = new ArrayList();
    private ArrayList<Fragment> h = new ArrayList();
    private Fragment i = null;

    public i(FragmentManager fragmentManager) {
        this.e = fragmentManager;
    }

    public abstract Fragment a(int i);

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
                this.e.putFragment(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public Object a(ViewGroup viewGroup, int i) {
        if (this.h.size() > i) {
            Fragment fragment = (Fragment) this.h.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f == null) {
            this.f = this.e.beginTransaction();
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
        a.a(a, false);
        a.b(a, false);
        this.h.set(i, a);
        this.f.add(viewGroup.getId(), a);
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
                    Fragment fragment = this.e.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.h.size() <= parseInt) {
                            this.h.add(null);
                        }
                        a.a(fragment, false);
                        this.h.set(parseInt, fragment);
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
            this.f = this.e.beginTransaction();
        }
        while (this.g.size() <= i) {
            this.g.add(null);
        }
        this.g.set(i, this.e.saveFragmentInstanceState(fragment));
        this.h.set(i, null);
        this.f.remove(fragment);
    }

    public boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
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
        if (fragment != this.i) {
            if (this.i != null) {
                a.a(this.i, false);
                a.b(this.i, false);
            }
            if (fragment != null) {
                a.a(fragment, true);
                a.b(fragment, true);
            }
            this.i = fragment;
        }
    }
}
