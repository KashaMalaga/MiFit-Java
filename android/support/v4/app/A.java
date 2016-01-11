package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.l.a;
import android.support.v4.l.g;
import android.support.v4.view.a.C0113o;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class A extends aj implements S, Runnable {
    static final String a = "FragmentManager";
    static final int c = 0;
    static final int d = 1;
    static final int e = 2;
    static final int f = 3;
    static final int g = 4;
    static final int h = 5;
    static final int i = 6;
    static final int j = 7;
    int A;
    CharSequence B;
    ArrayList<String> C;
    ArrayList<String> D;
    final U b;
    E k;
    E l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    boolean u = true;
    String v;
    boolean w;
    int x = -1;
    int y;
    CharSequence z;

    public A(U u) {
        this.b = u;
    }

    private F a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = c;
        F f = new F(this);
        f.d = new View(this.b.u);
        int i2 = c;
        int i3 = c;
        while (i2 < sparseArray.size()) {
            int i4 = a(sparseArray.keyAt(i2), f, z, (SparseArray) sparseArray, (SparseArray) sparseArray2) ? d : i3;
            i2 += d;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && a(i4, f, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = d;
            }
            i += d;
        }
        return i3 == 0 ? null : f;
    }

    private a<String, View> a(F f, Fragment fragment, boolean z) {
        a aVar = new a();
        if (this.C != null) {
            C0025al.a((Map) aVar, fragment.getView());
            if (z) {
                aVar.c(this.D);
            } else {
                aVar = a(this.C, this.D, aVar);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.D, (Map) aVar);
            }
            a(f, aVar, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.D, (Map) aVar);
            }
            b(f, aVar, false);
        }
        return aVar;
    }

    private a<String, View> a(F f, boolean z, Fragment fragment) {
        a b = b(f, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.D, (Map) b);
            }
            a(f, b, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.D, (Map) b);
            }
            b(f, b, true);
        }
        return b;
    }

    private static a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        a<String, View> aVar2 = new a();
        int size = arrayList.size();
        for (int i = c; i < size; i += d) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return C0025al.a(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private static Object a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0025al.a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, a<String, View> aVar) {
        return obj != null ? C0025al.a(obj, fragment.getView(), (ArrayList) arrayList, (Map) aVar) : obj;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.b;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        E e = new E();
        e.c = i2;
        e.d = fragment;
        a(e);
    }

    private void a(F f, int i, Object obj) {
        if (this.b.m != null) {
            for (int i2 = c; i2 < this.b.m.size(); i2 += d) {
                Fragment fragment = (Fragment) this.b.m.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        C0025al.a(obj, fragment.mView, false);
                        f.b.remove(fragment.mView);
                    } else if (!f.b.contains(fragment.mView)) {
                        C0025al.a(obj, fragment.mView, true);
                        f.b.add(fragment.mView);
                    }
                }
            }
        }
    }

    private void a(F f, Fragment fragment, Fragment fragment2, boolean z, a<String, View> aVar) {
        cn cnVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (cnVar != null) {
            cnVar.b(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    private void a(F f, a<String, View> aVar, boolean z) {
        int size = this.D == null ? c : this.D.size();
        for (int i = c; i < size; i += d) {
            String str = (String) this.C.get(i);
            View view = (View) aVar.get((String) this.D.get(i));
            if (view != null) {
                String a = C0025al.a(view);
                if (z) {
                    a(f.a, str, a);
                } else {
                    a(f.a, a, str);
                }
            }
        }
    }

    private void a(F f, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new C(this, view, obj, arrayList, f, z, fragment, fragment2));
    }

    private static void a(F f, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = c; i < arrayList.size(); i += d) {
                a(f.a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(a<String, View> aVar, F f) {
        if (this.D != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(this.D.get(c));
            if (view != null) {
                f.c.a = view;
            }
        }
    }

    private static void a(a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null && !str.equals(str2)) {
            for (int i = c; i < aVar.size(); i += d) {
                if (str.equals(aVar.c(i))) {
                    aVar.a(i, (Object) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void a(View view, F f, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new D(this, view, f, i, obj));
    }

    private boolean a(int i, F f, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.b.v.a(i);
        if (view == null) {
            return false;
        }
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a = a(fragment, z);
        Object a2 = a(fragment, fragment2, z);
        Object b = b(fragment2, z);
        if (a == null && a2 == null && b == null) {
            return false;
        }
        a aVar = null;
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            aVar = a(f, fragment2, z);
            if (aVar.isEmpty()) {
                arrayList.add(f.d);
            } else {
                arrayList.addAll(aVar.values());
            }
            cn cnVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
            if (cnVar != null) {
                cnVar.a(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Object a3 = a(b, fragment2, arrayList2, aVar);
        if (!(this.D == null || aVar == null)) {
            View view2 = (View) aVar.get(this.D.get(c));
            if (view2 != null) {
                if (a3 != null) {
                    C0025al.a(a3, view2);
                }
                if (a2 != null) {
                    C0025al.a(a2, view2);
                }
            }
        }
        ar b2 = new B(this, fragment);
        if (a2 != null) {
            a(f, view, a2, fragment, fragment2, z, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        Map aVar2 = new a();
        Object a4 = C0025al.a(a, a3, a2, z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap());
        if (a4 != null) {
            C0025al.a(a, a2, view, b2, f.d, f.c, f.a, arrayList3, aVar2, arrayList);
            a(view, f, i, a4);
            C0025al.a(a4, f.d, true);
            a(f, i, a4);
            C0025al.a((ViewGroup) view, a4);
            C0025al.a(view, f.d, a, arrayList3, a3, arrayList2, a2, arrayList, a4, f.b, aVar2);
        }
        return a4 != null;
    }

    private a<String, View> b(F f, Fragment fragment, boolean z) {
        a aVar = new a();
        View view = fragment.getView();
        if (view == null || this.C == null) {
            return aVar;
        }
        C0025al.a((Map) aVar, view);
        if (z) {
            return a(this.C, this.D, aVar);
        }
        aVar.c(this.D);
        return aVar;
    }

    private static Object b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0025al.a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private void b(F f, a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = c; i < size; i += d) {
            String str = (String) aVar.b(i);
            String a = C0025al.a((View) aVar.c(i));
            if (z) {
                a(f.a, str, a);
            } else {
                a(f.a, a, str);
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.v.a()) {
            for (E e = this.k; e != null; e = e.a) {
                switch (e.c) {
                    case d /*1*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    case e /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = e.d;
                        if (this.b.m != null) {
                            fragment = fragment2;
                            for (int i = c; i < this.b.m.size(); i += d) {
                                Fragment fragment3 = (Fragment) this.b.m.get(i);
                                if (fragment == null || fragment3.mContainerId == fragment.mContainerId) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        a((SparseArray) sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        b((SparseArray) sparseArray2, fragment);
                        break;
                    case f /*3*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case g /*4*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case h /*5*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    case i /*6*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case j /*7*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public int a() {
        return this.x;
    }

    int a(boolean z) {
        if (this.w) {
            throw new IllegalStateException("commit already called");
        }
        if (U.b) {
            Log.v(a, "Commit: " + this);
            a("  ", null, new PrintWriter(new g(a)), null);
        }
        this.w = true;
        if (this.t) {
            this.x = this.b.a(this);
        } else {
            this.x = -1;
        }
        this.b.a((Runnable) this, z);
        return this.x;
    }

    public F a(boolean z, F f, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (U.b) {
            Log.v(a, "popFromBackStack: " + this);
            a("  ", null, new PrintWriter(new g(a)), null);
        }
        if (f == null) {
            if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                f = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
            }
        } else if (!z) {
            a(f, this.D, this.C);
        }
        e(-1);
        int i = f != null ? c : this.s;
        int i2 = f != null ? c : this.r;
        E e = this.l;
        while (e != null) {
            int i3 = f != null ? c : e.g;
            int i4 = f != null ? c : e.h;
            Fragment fragment;
            Fragment fragment2;
            switch (e.c) {
                case d /*1*/:
                    fragment = e.d;
                    fragment.mNextAnim = i4;
                    this.b.a(fragment, U.d(i2), i);
                    break;
                case e /*2*/:
                    fragment = e.d;
                    if (fragment != null) {
                        fragment.mNextAnim = i4;
                        this.b.a(fragment, U.d(i2), i);
                    }
                    if (e.i == null) {
                        break;
                    }
                    for (int i5 = c; i5 < e.i.size(); i5 += d) {
                        fragment2 = (Fragment) e.i.get(i5);
                        fragment2.mNextAnim = i3;
                        this.b.a(fragment2, false);
                    }
                    break;
                case f /*3*/:
                    fragment2 = e.d;
                    fragment2.mNextAnim = i3;
                    this.b.a(fragment2, false);
                    break;
                case g /*4*/:
                    fragment2 = e.d;
                    fragment2.mNextAnim = i3;
                    this.b.c(fragment2, U.d(i2), i);
                    break;
                case h /*5*/:
                    fragment = e.d;
                    fragment.mNextAnim = i4;
                    this.b.b(fragment, U.d(i2), i);
                    break;
                case i /*6*/:
                    fragment2 = e.d;
                    fragment2.mNextAnim = i3;
                    this.b.e(fragment2, U.d(i2), i);
                    break;
                case j /*7*/:
                    fragment2 = e.d;
                    fragment2.mNextAnim = i3;
                    this.b.d(fragment2, U.d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + e.c);
            }
            e = e.b;
        }
        if (z) {
            this.b.a(this.b.t, U.d(i2), i, true);
            f = null;
        }
        if (this.x >= 0) {
            this.b.c(this.x);
            this.x = -1;
        }
        return f;
    }

    public aj a(int i) {
        this.r = i;
        return this;
    }

    public aj a(int i, int i2) {
        return a(i, i2, (int) c, (int) c);
    }

    public aj a(int i, int i2, int i3, int i4) {
        this.n = i;
        this.o = i2;
        this.p = i3;
        this.q = i4;
        return this;
    }

    public aj a(int i, Fragment fragment) {
        a(i, fragment, null, (int) d);
        return this;
    }

    public aj a(int i, Fragment fragment, String str) {
        a(i, fragment, str, (int) d);
        return this;
    }

    public aj a(Fragment fragment) {
        E e = new E();
        e.c = f;
        e.d = fragment;
        a(e);
        return this;
    }

    public aj a(Fragment fragment, String str) {
        a((int) c, fragment, str, (int) d);
        return this;
    }

    public aj a(View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            String a = C0025al.a(view);
            if (a == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.C == null) {
                this.C = new ArrayList();
                this.D = new ArrayList();
            }
            this.C.add(a);
            this.D.add(str);
        }
        return this;
    }

    public aj a(CharSequence charSequence) {
        this.y = c;
        this.z = charSequence;
        return this;
    }

    public aj a(String str) {
        if (this.u) {
            this.t = true;
            this.v = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    void a(E e) {
        if (this.k == null) {
            this.l = e;
            this.k = e;
        } else {
            e.b = this.l;
            this.l.a = e;
            this.l = e;
        }
        e.e = this.n;
        e.f = this.o;
        e.g = this.p;
        e.h = this.q;
        this.m += d;
    }

    public void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.v.a()) {
            for (E e = this.k; e != null; e = e.a) {
                switch (e.c) {
                    case d /*1*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case e /*2*/:
                        if (e.i != null) {
                            for (int size = e.i.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray2, (Fragment) e.i.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case f /*3*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    case g /*4*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    case h /*5*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    case i /*6*/:
                        b((SparseArray) sparseArray2, e.d);
                        break;
                    case j /*7*/:
                        a((SparseArray) sparseArray, e.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.v);
            printWriter.print(" mIndex=");
            printWriter.print(this.x);
            printWriter.print(" mCommitted=");
            printWriter.println(this.w);
            if (this.r != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.r));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.s));
            }
            if (!(this.n == 0 && this.o == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.o));
            }
            if (!(this.p == 0 && this.q == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.q));
            }
            if (!(this.y == 0 && this.z == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.y));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.z);
            }
            if (!(this.A == 0 && this.B == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.A));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.B);
            }
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = c;
            E e = this.k;
            while (e != null) {
                String str3;
                switch (e.c) {
                    case c /*0*/:
                        str3 = "NULL";
                        break;
                    case d /*1*/:
                        str3 = "ADD";
                        break;
                    case e /*2*/:
                        str3 = "REPLACE";
                        break;
                    case f /*3*/:
                        str3 = "REMOVE";
                        break;
                    case g /*4*/:
                        str3 = "HIDE";
                        break;
                    case h /*5*/:
                        str3 = "SHOW";
                        break;
                    case i /*6*/:
                        str3 = "DETACH";
                        break;
                    case j /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + e.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(e.d);
                if (z) {
                    if (!(e.e == 0 && e.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(e.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(e.f));
                    }
                    if (!(e.g == 0 && e.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(e.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(e.h));
                    }
                }
                if (e.i != null && e.i.size() > 0) {
                    for (int i2 = c; i2 < e.i.size(); i2 += d) {
                        printWriter.print(str2);
                        if (e.i.size() == d) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(e.i.get(i2));
                    }
                }
                e = e.a;
                i += d;
            }
        }
    }

    public int b() {
        return this.y;
    }

    public aj b(int i) {
        this.s = i;
        return this;
    }

    public aj b(int i, Fragment fragment) {
        return b(i, fragment, null);
    }

    public aj b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, (int) e);
        return this;
    }

    public aj b(Fragment fragment) {
        E e = new E();
        e.c = g;
        e.d = fragment;
        a(e);
        return this;
    }

    public aj b(CharSequence charSequence) {
        this.A = c;
        this.B = charSequence;
        return this;
    }

    public int c() {
        return this.A;
    }

    public aj c(int i) {
        this.y = i;
        this.z = null;
        return this;
    }

    public aj c(Fragment fragment) {
        E e = new E();
        e.c = h;
        e.d = fragment;
        a(e);
        return this;
    }

    public aj d(int i) {
        this.A = i;
        this.B = null;
        return this;
    }

    public aj d(Fragment fragment) {
        E e = new E();
        e.c = i;
        e.d = fragment;
        a(e);
        return this;
    }

    public CharSequence d() {
        return this.y != 0 ? this.b.u.getText(this.y) : this.z;
    }

    public aj e(Fragment fragment) {
        E e = new E();
        e.c = j;
        e.d = fragment;
        a(e);
        return this;
    }

    public CharSequence e() {
        return this.A != 0 ? this.b.u.getText(this.A) : this.B;
    }

    void e(int i) {
        if (this.t) {
            if (U.b) {
                Log.v(a, "Bump nesting in " + this + " by " + i);
            }
            for (E e = this.k; e != null; e = e.a) {
                Fragment fragment;
                if (e.d != null) {
                    fragment = e.d;
                    fragment.mBackStackNesting += i;
                    if (U.b) {
                        Log.v(a, "Bump nesting of " + e.d + " to " + e.d.mBackStackNesting);
                    }
                }
                if (e.i != null) {
                    for (int size = e.i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) e.i.get(size);
                        fragment.mBackStackNesting += i;
                        if (U.b) {
                            Log.v(a, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public boolean f() {
        return this.u;
    }

    public aj g() {
        if (this.t) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.u = false;
        return this;
    }

    public int h() {
        return a(false);
    }

    public int i() {
        return a(true);
    }

    public String j() {
        return this.v;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public boolean m() {
        return this.m == 0;
    }

    public void run() {
        if (U.b) {
            Log.v(a, "Run: " + this);
        }
        if (!this.t || this.x >= 0) {
            F a;
            e((int) d);
            if (VERSION.SDK_INT >= 21) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                b(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            } else {
                Object obj = null;
            }
            int i = a != null ? c : this.s;
            int i2 = a != null ? c : this.r;
            E e = this.k;
            while (e != null) {
                int i3 = a != null ? c : e.e;
                int i4 = a != null ? c : e.f;
                Fragment fragment;
                switch (e.c) {
                    case d /*1*/:
                        fragment = e.d;
                        fragment.mNextAnim = i3;
                        this.b.a(fragment, false);
                        break;
                    case e /*2*/:
                        Fragment fragment2;
                        fragment = e.d;
                        if (this.b.m != null) {
                            fragment2 = fragment;
                            for (int i5 = c; i5 < this.b.m.size(); i5 += d) {
                                fragment = (Fragment) this.b.m.get(i5);
                                if (U.b) {
                                    Log.v(a, "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment2 == null || fragment.mContainerId == fragment2.mContainerId) {
                                    if (fragment == fragment2) {
                                        e.d = null;
                                        fragment2 = null;
                                    } else {
                                        if (e.i == null) {
                                            e.i = new ArrayList();
                                        }
                                        e.i.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.t) {
                                            fragment.mBackStackNesting += d;
                                            if (U.b) {
                                                Log.v(a, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                                            }
                                        }
                                        this.b.a(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.b.a(fragment2, false);
                        break;
                    case f /*3*/:
                        fragment = e.d;
                        fragment.mNextAnim = i4;
                        this.b.a(fragment, i2, i);
                        break;
                    case g /*4*/:
                        fragment = e.d;
                        fragment.mNextAnim = i4;
                        this.b.b(fragment, i2, i);
                        break;
                    case h /*5*/:
                        fragment = e.d;
                        fragment.mNextAnim = i3;
                        this.b.c(fragment, i2, i);
                        break;
                    case i /*6*/:
                        fragment = e.d;
                        fragment.mNextAnim = i4;
                        this.b.d(fragment, i2, i);
                        break;
                    case j /*7*/:
                        fragment = e.d;
                        fragment.mNextAnim = i3;
                        this.b.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + e.c);
                }
                e = e.a;
            }
            this.b.a(this.b.t, i2, i, true);
            if (this.t) {
                this.b.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.x >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.x);
        }
        if (this.v != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.v);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
