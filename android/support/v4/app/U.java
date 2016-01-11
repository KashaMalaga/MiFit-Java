package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.l.f;
import android.support.v4.l.g;
import android.support.v4.view.a.C0113o;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kankan.wheel.widget.a;

final class U extends R implements Factory {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(a.bg);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(a.bg);
    static final int J = 220;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 4;
    public static final int O = 5;
    public static final int P = 6;
    static boolean b = d;
    static final String c = "FragmentManager";
    static final boolean d;
    static final String e = "android:target_req_state";
    static final String f = "android:target_state";
    static final String g = "android:view_state";
    static final String h = "android:user_visible_hint";
    String A;
    boolean B;
    Bundle C = null;
    SparseArray<Parcelable> D = null;
    Runnable E = new V(this);
    ArrayList<Runnable> i;
    Runnable[] j;
    boolean k;
    ArrayList<Fragment> l;
    ArrayList<Fragment> m;
    ArrayList<Integer> n;
    ArrayList<A> o;
    ArrayList<Fragment> p;
    ArrayList<A> q;
    ArrayList<Integer> r;
    ArrayList<T> s;
    int t = 0;
    FragmentActivity u;
    Q v;
    Fragment w;
    boolean x;
    boolean y;
    boolean z;

    static {
        boolean z = d;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        d = z;
    }

    U() {
    }

    static Animation a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(d);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, K, 0.5f, K, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(G);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void a(RuntimeException runtimeException) {
        Log.e(c, runtimeException.getMessage());
        Log.e(c, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new g(c));
        if (this.u != null) {
            try {
                this.u.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e(c, "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e(c, "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case aj.I /*4097*/:
                return z ? K : L;
            case aj.K /*4099*/:
                return z ? O : P;
            case aj.J /*8194*/:
                return z ? M : N;
            default:
                return -1;
        }
    }

    public static int d(int i) {
        switch (i) {
            case aj.I /*4097*/:
                return aj.J;
            case aj.K /*4099*/:
                return aj.K;
            case aj.J /*8194*/:
                return aj.I;
            default:
                return 0;
        }
    }

    private void z() {
        if (this.y) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.A != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.A);
        }
    }

    public int a(A a) {
        int size;
        synchronized (this) {
            if (this.r == null || this.r.size() <= 0) {
                if (this.q == null) {
                    this.q = new ArrayList();
                }
                size = this.q.size();
                if (b) {
                    Log.v(c, "Setting back stack index " + size + " to " + a);
                }
                this.q.add(a);
            } else {
                size = ((Integer) this.r.remove(this.r.size() - 1)).intValue();
                if (b) {
                    Log.v(c, "Adding back stack index " + size + " with " + a);
                }
                this.q.set(size, a);
            }
        }
        return size;
    }

    public SavedState a(Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle g = g(fragment);
        return g != null ? new SavedState(g) : null;
    }

    public Fragment a(int i) {
        int size;
        Fragment fragment;
        if (this.m != null) {
            for (size = this.m.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.m.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.l != null) {
            for (size = this.l.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.l.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.l.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.l.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment a(String str) {
        int size;
        Fragment fragment;
        if (!(this.m == null || str == null)) {
            for (size = this.m.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.m.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.l == null || str == null)) {
            for (size = this.l.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.l.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public aj a() {
        return new A(this);
    }

    Animation a(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.u, fragment.mNextAnim);
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case K /*1*/:
                return a(this.u, 1.125f, 1.0f, 0.0f, 1.0f);
            case L /*2*/:
                return a(this.u, 1.0f, 0.975f, 1.0f, 0.0f);
            case M /*3*/:
                return a(this.u, 0.975f, 1.0f, 0.0f, 1.0f);
            case N /*4*/:
                return a(this.u, 1.0f, 1.075f, 1.0f, 0.0f);
            case O /*5*/:
                return a(this.u, 0.0f, 1.0f);
            case P /*6*/:
                return a(this.u, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.u.getWindow() != null) {
                    i2 = this.u.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new Y(this, i, i2), (boolean) d);
    }

    void a(int i, int i2, int i3, boolean z) {
        if (this.u == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.t != i) {
            this.t = i;
            if (this.l != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.l.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.l.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, (boolean) d);
                        if (fragment.mLoaderManager != null) {
                            a = i5 | fragment.mLoaderManager.a();
                            i4 += K;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4 += K;
                    i5 = a;
                }
                if (i5 == 0) {
                    i();
                }
                if (this.x && this.u != null && this.t == O) {
                    this.u.g();
                    this.x = d;
                }
            }
        }
    }

    public void a(int i, A a) {
        synchronized (this) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            int size = this.q.size();
            if (i < size) {
                if (b) {
                    Log.v(c, "Setting back stack index " + i + " to " + a);
                }
                this.q.set(i, a);
            } else {
                while (size < i) {
                    this.q.add(null);
                    if (this.r == null) {
                        this.r = new ArrayList();
                    }
                    if (b) {
                        Log.v(c, "Adding available back stack index " + size);
                    }
                    this.r.add(Integer.valueOf(size));
                    size += K;
                }
                if (b) {
                    Log.v(c, "Adding back stack index " + i + " with " + a);
                }
                this.q.add(a);
            }
        }
    }

    void a(int i, boolean z) {
        a(i, 0, 0, z);
    }

    public void a(Configuration configuration) {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i += K) {
                Fragment fragment = (Fragment) this.m.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    void a(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i += K) {
                        fragment = (Fragment) arrayList.get(i);
                        if (b) {
                            Log.v(c, "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.mIndex];
                        fragmentState.k = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = d;
                        fragment.mAdded = d;
                        fragment.mTarget = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.u.getClassLoader());
                            fragment.mSavedViewState = fragmentState.j.getSparseParcelableArray(g);
                            fragment.mSavedFragmentState = fragmentState.j;
                        }
                    }
                }
                this.l = new ArrayList(fragmentManagerState.a.length);
                if (this.n != null) {
                    this.n.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.a.length; i2 += K) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.a(this.u, this.w);
                        if (b) {
                            Log.v(c, "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.l.add(a);
                        fragmentState2.k = null;
                    } else {
                        this.l.add(null);
                        if (this.n == null) {
                            this.n = new ArrayList();
                        }
                        if (b) {
                            Log.v(c, "restoreAllState: avail #" + i2);
                        }
                        this.n.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3 += K) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.mTargetIndex >= 0) {
                            if (fragment.mTargetIndex < this.l.size()) {
                                fragment.mTarget = (Fragment) this.l.get(fragment.mTargetIndex);
                            } else {
                                Log.w(c, "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                                fragment.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.m = new ArrayList(fragmentManagerState.b.length);
                    for (i = 0; i < fragmentManagerState.b.length; i += K) {
                        fragment = (Fragment) this.l.get(fragmentManagerState.b[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i]));
                        }
                        fragment.mAdded = true;
                        if (b) {
                            Log.v(c, "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.m.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.m.add(fragment);
                    }
                } else {
                    this.m = null;
                }
                if (fragmentManagerState.c != null) {
                    this.o = new ArrayList(fragmentManagerState.c.length);
                    for (i2 = 0; i2 < fragmentManagerState.c.length; i2 += K) {
                        A a2 = fragmentManagerState.c[i2].a(this);
                        if (b) {
                            Log.v(c, "restoreAllState: back stack #" + i2 + " (index " + a2.x + "): " + a2);
                            a2.a("  ", new PrintWriter(new g(c)), (boolean) d);
                        }
                        this.o.add(a2);
                        if (a2.x >= 0) {
                            a(a2.x, a2);
                        }
                    }
                    return;
                }
                this.o = null;
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (b) {
            Log.v(c, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack() ? true : d;
        if (!fragment.mDetached || z) {
            if (this.m != null) {
                this.m.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.x = true;
            }
            fragment.mAdded = d;
            fragment.mRemoving = true;
            a(fragment, z ? 0 : K, i, i2, (boolean) d);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r10.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.mRemoving;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.mState;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.mState;
    L_0x001a:
        r0 = r10.mDeferStart;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.mState;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.mState;
        if (r0 >= r11) goto L_0x024b;
    L_0x0029:
        r0 = r10.mFromLayout;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.mInLayout;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.mAnimatingAway = r7;
        r2 = r10.mStateAfterAnimating;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.mState;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0131;
            case 2: goto L_0x01fa;
            case 3: goto L_0x01fa;
            case 4: goto L_0x021b;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.mState = r11;
        goto L_0x0031;
    L_0x0048:
        r0 = b;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r10.mSavedFragmentState;
        if (r0 == 0) goto L_0x00a8;
    L_0x0068:
        r0 = r10.mSavedFragmentState;
        r1 = r9.u;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r10.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.mSavedViewState = r0;
        r0 = r10.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r9.a(r0, r1);
        r10.mTarget = r0;
        r0 = r10.mTarget;
        if (r0 == 0) goto L_0x0095;
    L_0x008b:
        r0 = r10.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.mTargetRequestCode = r0;
    L_0x0095:
        r0 = r10.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.mUserVisibleHint = r0;
        r0 = r10.mUserVisibleHint;
        if (r0 != 0) goto L_0x00a8;
    L_0x00a3:
        r10.mDeferStart = r5;
        if (r11 <= r6) goto L_0x00a8;
    L_0x00a7:
        r11 = r6;
    L_0x00a8:
        r0 = r9.u;
        r10.mActivity = r0;
        r0 = r9.w;
        r10.mParentFragment = r0;
        r0 = r9.w;
        if (r0 == 0) goto L_0x00e4;
    L_0x00b4:
        r0 = r9.w;
        r0 = r0.mChildFragmentManager;
    L_0x00b8:
        r10.mFragmentManager = r0;
        r10.mCalled = r3;
        r0 = r9.u;
        r10.onAttach(r0);
        r0 = r10.mCalled;
        if (r0 != 0) goto L_0x00e9;
    L_0x00c5:
        r0 = new android.support.v4.app.co;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e4:
        r0 = r9.u;
        r0 = r0.e;
        goto L_0x00b8;
    L_0x00e9:
        r0 = r10.mParentFragment;
        if (r0 != 0) goto L_0x00f2;
    L_0x00ed:
        r0 = r9.u;
        r0.a(r10);
    L_0x00f2:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x00fb;
    L_0x00f6:
        r0 = r10.mSavedFragmentState;
        r10.performCreate(r0);
    L_0x00fb:
        r10.mRetaining = r3;
        r0 = r10.mFromLayout;
        if (r0 == 0) goto L_0x0131;
    L_0x0101:
        r0 = r10.mSavedFragmentState;
        r0 = r10.getLayoutInflater(r0);
        r1 = r10.mSavedFragmentState;
        r0 = r10.performCreateView(r0, r7, r1);
        r10.mView = r0;
        r0 = r10.mView;
        if (r0 == 0) goto L_0x0244;
    L_0x0113:
        r0 = r10.mView;
        r10.mInnerView = r0;
        r0 = r10.mView;
        r0 = android.support.v4.app.aH.a(r0);
        r10.mView = r0;
        r0 = r10.mHidden;
        if (r0 == 0) goto L_0x012a;
    L_0x0123:
        r0 = r10.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x012a:
        r0 = r10.mView;
        r1 = r10.mSavedFragmentState;
        r10.onViewCreated(r0, r1);
    L_0x0131:
        if (r11 <= r5) goto L_0x01fa;
    L_0x0133:
        r0 = b;
        if (r0 == 0) goto L_0x014f;
    L_0x0137:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x014f:
        r0 = r10.mFromLayout;
        if (r0 != 0) goto L_0x01ea;
    L_0x0153:
        r0 = r10.mContainerId;
        if (r0 == 0) goto L_0x03a6;
    L_0x0157:
        r0 = r9.v;
        r1 = r10.mContainerId;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01a6;
    L_0x0163:
        r1 = r10.mRestored;
        if (r1 != 0) goto L_0x01a6;
    L_0x0167:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "No view found for id 0x";
        r2 = r2.append(r3);
        r3 = r10.mContainerId;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = r10.getResources();
        r4 = r10.mContainerId;
        r3 = r3.getResourceName(r4);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.a(r1);
    L_0x01a6:
        r10.mContainer = r0;
        r1 = r10.mSavedFragmentState;
        r1 = r10.getLayoutInflater(r1);
        r2 = r10.mSavedFragmentState;
        r1 = r10.performCreateView(r1, r0, r2);
        r10.mView = r1;
        r1 = r10.mView;
        if (r1 == 0) goto L_0x0248;
    L_0x01ba:
        r1 = r10.mView;
        r10.mInnerView = r1;
        r1 = r10.mView;
        r1 = android.support.v4.app.aH.a(r1);
        r10.mView = r1;
        if (r0 == 0) goto L_0x01d8;
    L_0x01c8:
        r1 = r9.a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01d3;
    L_0x01ce:
        r2 = r10.mView;
        r2.startAnimation(r1);
    L_0x01d3:
        r1 = r10.mView;
        r0.addView(r1);
    L_0x01d8:
        r0 = r10.mHidden;
        if (r0 == 0) goto L_0x01e3;
    L_0x01dc:
        r0 = r10.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01e3:
        r0 = r10.mView;
        r1 = r10.mSavedFragmentState;
        r10.onViewCreated(r0, r1);
    L_0x01ea:
        r0 = r10.mSavedFragmentState;
        r10.performActivityCreated(r0);
        r0 = r10.mView;
        if (r0 == 0) goto L_0x01f8;
    L_0x01f3:
        r0 = r10.mSavedFragmentState;
        r10.restoreViewState(r0);
    L_0x01f8:
        r10.mSavedFragmentState = r7;
    L_0x01fa:
        if (r11 <= r6) goto L_0x021b;
    L_0x01fc:
        r0 = b;
        if (r0 == 0) goto L_0x0218;
    L_0x0200:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0218:
        r10.performStart();
    L_0x021b:
        if (r11 <= r8) goto L_0x0045;
    L_0x021d:
        r0 = b;
        if (r0 == 0) goto L_0x0239;
    L_0x0221:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0239:
        r10.mResumed = r5;
        r10.performResume();
        r10.mSavedFragmentState = r7;
        r10.mSavedViewState = r7;
        goto L_0x0045;
    L_0x0244:
        r10.mInnerView = r7;
        goto L_0x0131;
    L_0x0248:
        r10.mInnerView = r7;
        goto L_0x01ea;
    L_0x024b:
        r0 = r10.mState;
        if (r0 <= r11) goto L_0x0045;
    L_0x024f:
        r0 = r10.mState;
        switch(r0) {
            case 1: goto L_0x0256;
            case 2: goto L_0x02d6;
            case 3: goto L_0x02b5;
            case 4: goto L_0x0294;
            case 5: goto L_0x0270;
            default: goto L_0x0254;
        };
    L_0x0254:
        goto L_0x0045;
    L_0x0256:
        if (r11 >= r5) goto L_0x0045;
    L_0x0258:
        r0 = r9.z;
        if (r0 == 0) goto L_0x0267;
    L_0x025c:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x0267;
    L_0x0260:
        r0 = r10.mAnimatingAway;
        r10.mAnimatingAway = r7;
        r0.clearAnimation();
    L_0x0267:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x0343;
    L_0x026b:
        r10.mStateAfterAnimating = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0270:
        r0 = 5;
        if (r11 >= r0) goto L_0x0294;
    L_0x0273:
        r0 = b;
        if (r0 == 0) goto L_0x028f;
    L_0x0277:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x028f:
        r10.performPause();
        r10.mResumed = r3;
    L_0x0294:
        if (r11 >= r8) goto L_0x02b5;
    L_0x0296:
        r0 = b;
        if (r0 == 0) goto L_0x02b2;
    L_0x029a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b2:
        r10.performStop();
    L_0x02b5:
        if (r11 >= r6) goto L_0x02d6;
    L_0x02b7:
        r0 = b;
        if (r0 == 0) goto L_0x02d3;
    L_0x02bb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02d3:
        r10.performReallyStop();
    L_0x02d6:
        r0 = 2;
        if (r11 >= r0) goto L_0x0256;
    L_0x02d9:
        r0 = b;
        if (r0 == 0) goto L_0x02f5;
    L_0x02dd:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f5:
        r0 = r10.mView;
        if (r0 == 0) goto L_0x0308;
    L_0x02f9:
        r0 = r9.u;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0308;
    L_0x0301:
        r0 = r10.mSavedViewState;
        if (r0 != 0) goto L_0x0308;
    L_0x0305:
        r9.f(r10);
    L_0x0308:
        r10.performDestroyView();
        r0 = r10.mView;
        if (r0 == 0) goto L_0x033b;
    L_0x030f:
        r0 = r10.mContainer;
        if (r0 == 0) goto L_0x033b;
    L_0x0313:
        r0 = r9.t;
        if (r0 <= 0) goto L_0x03a3;
    L_0x0317:
        r0 = r9.z;
        if (r0 != 0) goto L_0x03a3;
    L_0x031b:
        r0 = r9.a(r10, r12, r3, r13);
    L_0x031f:
        if (r0 == 0) goto L_0x0334;
    L_0x0321:
        r1 = r10.mView;
        r10.mAnimatingAway = r1;
        r10.mStateAfterAnimating = r11;
        r1 = new android.support.v4.app.Z;
        r1.<init>(r9, r10);
        r0.setAnimationListener(r1);
        r1 = r10.mView;
        r1.startAnimation(r0);
    L_0x0334:
        r0 = r10.mContainer;
        r1 = r10.mView;
        r0.removeView(r1);
    L_0x033b:
        r10.mContainer = r7;
        r10.mView = r7;
        r10.mInnerView = r7;
        goto L_0x0256;
    L_0x0343:
        r0 = b;
        if (r0 == 0) goto L_0x035f;
    L_0x0347:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x035f:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x0366;
    L_0x0363:
        r10.performDestroy();
    L_0x0366:
        r10.mCalled = r3;
        r10.onDetach();
        r0 = r10.mCalled;
        if (r0 != 0) goto L_0x038e;
    L_0x036f:
        r0 = new android.support.v4.app.co;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x038e:
        if (r14 != 0) goto L_0x0045;
    L_0x0390:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x0399;
    L_0x0394:
        r9.e(r10);
        goto L_0x0045;
    L_0x0399:
        r10.mActivity = r7;
        r10.mParentFragment = r7;
        r10.mFragmentManager = r7;
        r10.mChildFragmentManager = r7;
        goto L_0x0045;
    L_0x03a3:
        r0 = r7;
        goto L_0x031f;
    L_0x03a6:
        r0 = r7;
        goto L_0x01a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.U.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void a(Fragment fragment, boolean z) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        if (b) {
            Log.v(c, "add: " + fragment);
        }
        d(fragment);
        if (!fragment.mDetached) {
            if (this.m.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.m.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = d;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.x = true;
            }
            if (z) {
                c(fragment);
            }
        }
    }

    public void a(FragmentActivity fragmentActivity, Q q, Fragment fragment) {
        if (this.u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.u = fragmentActivity;
        this.v = q;
        this.w = fragment;
    }

    public void a(T t) {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(t);
    }

    public void a(Runnable runnable, boolean z) {
        if (!z) {
            z();
        }
        synchronized (this) {
            if (this.z || this.u == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            this.i.add(runnable);
            if (this.i.size() == K) {
                this.u.d.removeCallbacks(this.E);
                this.u.d.post(this.E);
            }
        }
    }

    public void a(String str, int i) {
        a(new X(this, str, i), (boolean) d);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.l != null) {
            size = this.l.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(a.ci);
                for (i = 0; i < size; i += K) {
                    fragment = (Fragment) this.l.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.m != null) {
            size = this.m.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i += K) {
                    fragment = (Fragment) this.m.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.p != null) {
            size = this.p.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i += K) {
                    fragment = (Fragment) this.p.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.o != null) {
            size = this.o.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i += K) {
                    A a = (A) this.o.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(a.toString());
                    a.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.q != null) {
                int size2 = this.q.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i += K) {
                        a = (A) this.q.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(a);
                    }
                }
            }
            if (this.r != null && this.r.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.r.toArray()));
            }
        }
        if (this.i != null) {
            i = this.i.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.i.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2 += K;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.v);
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.y);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.z);
        if (this.x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.x);
        }
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.A);
        }
        if (this.n != null && this.n.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.n.toArray()));
        }
    }

    boolean a(Handler handler, String str, int i, int i2) {
        if (this.o == null) {
            return d;
        }
        int size;
        A a;
        if (str == null && i < 0 && (i2 & K) == 0) {
            size = this.o.size() - 1;
            if (size < 0) {
                return d;
            }
            a = (A) this.o.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            a.a(sparseArray, sparseArray2);
            a.a(true, null, sparseArray, sparseArray2);
            k();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.o.size() - 1;
                while (size2 >= 0) {
                    a = (A) this.o.get(size2);
                    if ((str != null && str.equals(a.j())) || (i >= 0 && i == a.x)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return d;
                }
                if ((i2 & K) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        a = (A) this.o.get(size2);
                        if ((str == null || !str.equals(a.j())) && (i < 0 || i != a.x)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.o.size() - 1) {
                return d;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.o.size() - 1; size2 > size; size2--) {
                arrayList.add(this.o.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2 += K) {
                ((A) arrayList.get(size2)).a(sparseArray3, sparseArray4);
            }
            F f = null;
            int i3 = 0;
            while (i3 <= size3) {
                if (b) {
                    Log.v(c, "Popping back stack state: " + arrayList.get(i3));
                }
                i3 += K;
                f = ((A) arrayList.get(i3)).a(i3 == size3 ? true : d, f, sparseArray3, sparseArray4);
            }
            k();
        }
        return true;
    }

    public boolean a(Menu menu) {
        if (this.m == null) {
            return d;
        }
        boolean z = d;
        for (int i = 0; i < this.m.size(); i += K) {
            Fragment fragment = (Fragment) this.m.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.m != null) {
            int i2 = 0;
            z = d;
            while (i2 < this.m.size()) {
                fragment = (Fragment) this.m.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2 += K;
                z = z;
            }
        } else {
            z = d;
        }
        if (this.p != null) {
            while (i < this.p.size()) {
                fragment = (Fragment) this.p.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i += K;
            }
        }
        this.p = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.m == null) {
            return d;
        }
        for (int i = 0; i < this.m.size(); i += K) {
            Fragment fragment = (Fragment) this.m.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return d;
    }

    public Fragment b(String str) {
        if (!(this.l == null || str == null)) {
            for (int size = this.l.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.l.get(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    public S b(int i) {
        return (S) this.o.get(i);
    }

    void b(A a) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(a);
        k();
    }

    public void b(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.k) {
            this.B = true;
            return;
        }
        fragment.mDeferStart = d;
        a(fragment, this.t, 0, 0, d);
    }

    public void b(Fragment fragment, int i, int i2) {
        if (b) {
            Log.v(c, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, (boolean) d, i2);
                if (a != null) {
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.x = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void b(T t) {
        if (this.s != null) {
            this.s.remove(t);
        }
    }

    public void b(Menu menu) {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i += K) {
                Fragment fragment = (Fragment) this.m.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public boolean b(int i, int i2) {
        z();
        c();
        if (i >= 0) {
            return a(this.u.d, null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean b(MenuItem menuItem) {
        if (this.m == null) {
            return d;
        }
        for (int i = 0; i < this.m.size(); i += K) {
            Fragment fragment = (Fragment) this.m.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return d;
    }

    public boolean b(String str, int i) {
        z();
        c();
        return a(this.u.d, str, -1, i);
    }

    public void c(int i) {
        synchronized (this) {
            this.q.set(i, null);
            if (this.r == null) {
                this.r = new ArrayList();
            }
            if (b) {
                Log.v(c, "Freeing back stack index " + i);
            }
            this.r.add(Integer.valueOf(i));
        }
    }

    void c(Fragment fragment) {
        a(fragment, this.t, 0, 0, d);
    }

    public void c(Fragment fragment, int i, int i2) {
        if (b) {
            Log.v(c, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = d;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.x = true;
            }
            fragment.onHiddenChanged(d);
        }
    }

    public boolean c() {
        return j();
    }

    public void d() {
        a(new W(this), (boolean) d);
    }

    void d(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.n == null || this.n.size() <= 0) {
                if (this.l == null) {
                    this.l = new ArrayList();
                }
                fragment.setIndex(this.l.size(), this.w);
                this.l.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.n.remove(this.n.size() - 1)).intValue(), this.w);
                this.l.set(fragment.mIndex, fragment);
            }
            if (b) {
                Log.v(c, "Allocated fragment index " + fragment);
            }
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (b) {
            Log.v(c, "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.m != null) {
                    if (b) {
                        Log.v(c, "remove from detach: " + fragment);
                    }
                    this.m.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.x = true;
                }
                fragment.mAdded = d;
                a(fragment, (int) K, i, i2, (boolean) d);
            }
        }
    }

    void e(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (b) {
                Log.v(c, "Freeing fragment index " + fragment);
            }
            this.l.set(fragment.mIndex, null);
            if (this.n == null) {
                this.n = new ArrayList();
            }
            this.n.add(Integer.valueOf(fragment.mIndex));
            this.u.a(fragment.mWho);
            fragment.initState();
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (b) {
            Log.v(c, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = d;
            if (!fragment.mAdded) {
                if (this.m == null) {
                    this.m = new ArrayList();
                }
                if (this.m.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (b) {
                    Log.v(c, "add from attach: " + fragment);
                }
                this.m.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.x = true;
                }
                a(fragment, this.t, i, i2, (boolean) d);
            }
        }
    }

    public boolean e() {
        z();
        c();
        return a(this.u.d, null, -1, 0);
    }

    public int f() {
        return this.o != null ? this.o.size() : 0;
    }

    void f(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.D == null) {
                this.D = new SparseArray();
            } else {
                this.D.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.D);
            if (this.D.size() > 0) {
                fragment.mSavedViewState = this.D;
                this.D = null;
            }
        }
    }

    Bundle g(Fragment fragment) {
        Bundle bundle;
        if (this.C == null) {
            this.C = new Bundle();
        }
        fragment.performSaveInstanceState(this.C);
        if (this.C.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.C;
            this.C = null;
        }
        if (fragment.mView != null) {
            f(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(g, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(h, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public List<Fragment> g() {
        return this.l;
    }

    public boolean h() {
        return this.z;
    }

    void i() {
        if (this.l != null) {
            for (int i = 0; i < this.l.size(); i += K) {
                Fragment fragment = (Fragment) this.l.get(i);
                if (fragment != null) {
                    b(fragment);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.k;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.u;
        r3 = r3.d;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.i;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.i;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.B;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.l;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.l;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.mLoaderManager;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.mLoaderManager;
        r0 = r0.a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.i;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.j;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.j;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.j = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.i;	 Catch:{ all -> 0x0097 }
        r4 = r6.j;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.i;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.u;	 Catch:{ all -> 0x0097 }
        r1 = r1.d;	 Catch:{ all -> 0x0097 }
        r4 = r6.E;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.k = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.j;
        r4 = r4[r1];
        r4.run();
        r4 = r6.j;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.k = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.B = r2;
        r6.i();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.U.j():boolean");
    }

    void k() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i += K) {
                ((T) this.s.get(i)).a();
            }
        }
    }

    ArrayList<Fragment> l() {
        ArrayList<Fragment> arrayList = null;
        if (this.l != null) {
            for (int i = 0; i < this.l.size(); i += K) {
                Fragment fragment = (Fragment) this.l.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (b) {
                        Log.v(c, "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m() {
        BackStackState[] backStackStateArr = null;
        j();
        if (d) {
            this.y = true;
        }
        if (this.l == null || this.l.size() <= 0) {
            return null;
        }
        int size = this.l.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.l.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.j != null) {
                    fragmentState.j = fragment.mSavedFragmentState;
                } else {
                    fragmentState.j = g(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, f, fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.j.putInt(e, fragment.mTargetRequestCode);
                        }
                    }
                }
                if (b) {
                    Log.v(c, "Saved state of " + fragment + ": " + fragmentState.j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i += K;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.m != null) {
                i = this.m.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2 += K) {
                        iArr[i2] = ((Fragment) this.m.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            a(new IllegalStateException("Failure saving state: active " + this.m.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (b) {
                            Log.v(c, "saveAllState: adding fragment #" + i2 + ": " + this.m.get(i2));
                        }
                    }
                    if (this.o != null) {
                        i = this.o.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2 += K) {
                                backStackStateArr[i2] = new BackStackState(this, (A) this.o.get(i2));
                                if (b) {
                                    Log.v(c, "saveAllState: adding back stack #" + i2 + ": " + this.o.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.a = fragmentStateArr;
                    fragmentManagerState.b = iArr;
                    fragmentManagerState.c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.o != null) {
                i = this.o.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2 += K) {
                        backStackStateArr[i2] = new BackStackState(this, (A) this.o.get(i2));
                        if (b) {
                            Log.v(c, "saveAllState: adding back stack #" + i2 + ": " + this.o.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            return fragmentManagerState;
        } else if (!b) {
            return null;
        } else {
            Log.v(c, "saveAllState: no fragments!");
            return null;
        }
    }

    public void n() {
        this.y = d;
    }

    public void o() {
        this.y = d;
        a((int) K, (boolean) d);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (!"fragment".equals(str)) {
            return view;
        }
        String attributeValue = attributeSet.getAttributeValue(view, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0015aa.a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(K, -1);
        String string2 = obtainStyledAttributes.getString(L);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.u, string)) {
            return view;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        if (resourceId != -1) {
            Fragment a = a(resourceId);
        } else {
            Object obj = view;
        }
        if (a == null && string2 != null) {
            a = a(string2);
        }
        if (a == null && id != -1) {
            a = a(id);
        }
        if (b) {
            Log.v(c, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.onInflate(this.u, attributeSet, instantiate.mSavedFragmentState);
            a(instantiate, true);
            fragment = instantiate;
        } else if (a.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.mInLayout = true;
            if (!a.mRetaining) {
                a.onInflate(this.u, attributeSet, a.mSavedFragmentState);
            }
            fragment = a;
        }
        if (this.t >= K || !fragment.mFromLayout) {
            c(fragment);
        } else {
            a(fragment, (int) K, 0, 0, d);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    public void p() {
        this.y = d;
        a((int) L, (boolean) d);
    }

    public void q() {
        this.y = d;
        a((int) N, (boolean) d);
    }

    public void r() {
        this.y = d;
        a((int) O, (boolean) d);
    }

    public void s() {
        a((int) N, (boolean) d);
    }

    public void t() {
        this.y = true;
        a((int) M, (boolean) d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.w != null) {
            f.a(this.w, stringBuilder);
        } else {
            f.a(this.u, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void u() {
        a((int) L, (boolean) d);
    }

    public void v() {
        a((int) K, (boolean) d);
    }

    public void w() {
        this.z = true;
        j();
        a(0, (boolean) d);
        this.u = null;
        this.v = null;
        this.w = null;
    }

    public void x() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i += K) {
                Fragment fragment = (Fragment) this.m.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    Factory y() {
        return this;
    }
}
