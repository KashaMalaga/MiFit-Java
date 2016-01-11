package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.C0125a;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.C0104f;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.L;
import android.support.v4.view.bF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.b;

public abstract class K extends C0125a {
    public static final int b = Integer.MIN_VALUE;
    private static final String c = View.class.getName();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final int[] g = new int[2];
    private final AccessibilityManager h;
    private final View i;
    private M j;
    private int k = b;
    private int l = b;

    public K(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
    }

    private boolean a(int i, Bundle bundle) {
        return C0151az.a(this.i, i, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (C0151az.g(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent == null ? false : !this.i.getLocalVisibleRect(this.f) ? false : rect.intersect(this.f);
    }

    private AccessibilityEvent b(int i, int i2) {
        switch (i) {
            case b.a /*-1*/:
                return c(i2);
            default:
                return c(i, i2);
        }
    }

    private void b(int i) {
        if (this.l != i) {
            int i2 = this.l;
            this.l = i;
            a(i, (int) C0113o.h);
            a(i2, (int) PersonInfo.INCOMING_CALL_DISABLE_BIT);
        }
    }

    private boolean b(int i, int i2, Bundle bundle) {
        switch (i) {
            case b.a /*-1*/:
                return a(i2, bundle);
            default:
                return c(i, i2, bundle);
        }
    }

    private AccessibilityEvent c(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        C0151az.b(this.i, obtain);
        return obtain;
    }

    private AccessibilityEvent c(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(c);
        a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setPackageName(this.i.getContext().getPackageName());
        C0099a.b(obtain).a(this.i, i);
        return obtain;
    }

    private boolean c(int i, int i2, Bundle bundle) {
        switch (i2) {
            case c.m /*64*/:
            case C0113o.h /*128*/:
                return d(i, i2, bundle);
            default:
                return a(i, i2, bundle);
        }
    }

    private C0113o d() {
        C0113o a = C0113o.a(this.i);
        C0151az.a(this.i, a);
        List linkedList = new LinkedList();
        a(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a.c(this.i, ((Integer) it.next()).intValue());
        }
        return a;
    }

    private C0113o d(int i) {
        switch (i) {
            case b.a /*-1*/:
                return d();
            default:
                return e(i);
        }
    }

    private boolean d(int i, int i2, Bundle bundle) {
        switch (i2) {
            case c.m /*64*/:
                return g(i);
            case C0113o.h /*128*/:
                return h(i);
            default:
                return false;
        }
    }

    private C0113o e(int i) {
        C0113o b = C0113o.b();
        b.j(true);
        b.b(c);
        a(i, b);
        if (b.v() == null && b.w() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b.a(this.e);
        if (this.e.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int e = b.e();
        if ((e & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((e & C0113o.h) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            b.a(this.i.getContext().getPackageName());
            b.b(this.i, i);
            b.d(this.i);
            if (this.k == i) {
                b.f(true);
                b.d((int) C0113o.h);
            } else {
                b.f(false);
                b.d(64);
            }
            if (a(this.e)) {
                b.e(true);
                b.b(this.e);
            }
            this.i.getLocationOnScreen(this.g);
            e = this.g[0];
            int i2 = this.g[1];
            this.d.set(this.e);
            this.d.offset(e, i2);
            b.d(this.d);
            return b;
        }
    }

    private boolean f(int i) {
        return this.k == i;
    }

    private boolean g(int i) {
        if (!this.h.isEnabled() || !C0104f.b(this.h) || f(i)) {
            return false;
        }
        this.k = i;
        this.i.invalidate();
        a(i, (int) WXMediaMessage.THUMB_LENGTH_LIMIT);
        return true;
    }

    private boolean h(int i) {
        if (!f(i)) {
            return false;
        }
        this.k = b;
        this.i.invalidate();
        a(i, (int) C0113o.q);
        return true;
    }

    protected abstract int a(float f, float f2);

    public L a(View view) {
        if (this.j == null) {
            this.j = new M();
        }
        return this.j;
    }

    public void a(int i) {
        a(i, (int) C0113o.l);
    }

    protected abstract void a(int i, C0113o c0113o);

    protected abstract void a(int i, AccessibilityEvent accessibilityEvent);

    protected abstract void a(List<Integer> list);

    public boolean a(int i, int i2) {
        if (i == b || !this.h.isEnabled()) {
            return false;
        }
        ViewParent parent = this.i.getParent();
        if (parent == null) {
            return false;
        }
        return bF.a(parent, this.i, b(i, i2));
    }

    protected abstract boolean a(int i, int i2, Bundle bundle);

    public boolean a(MotionEvent motionEvent) {
        boolean z = true;
        if (!this.h.isEnabled() || !C0104f.b(this.h)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case a.bc /*7*/:
            case a.bo /*9*/:
                int a = a(motionEvent.getX(), motionEvent.getY());
                b(a);
                if (a == b) {
                    z = false;
                }
                return z;
            case a.bd /*10*/:
                if (this.k == b) {
                    return false;
                }
                b(b);
                return true;
            default:
                return false;
        }
    }

    public void b() {
        a(-1);
    }

    public int c() {
        return this.k;
    }
}
