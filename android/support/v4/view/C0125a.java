package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.L;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0125a {
    private static final C0152d b;
    private static final Object c = b.a();
    final Object a = b.a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            b = new C0183e();
        } else if (VERSION.SDK_INT >= 14) {
            b = new C0154b();
        } else {
            b = new C0153g();
        }
    }

    public L a(View view) {
        return b.a(c, view);
    }

    Object a() {
        return this.a;
    }

    public void a(View view, int i) {
        b.a(c, view, i);
    }

    public void a(View view, C0113o c0113o) {
        b.a(c, view, c0113o);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }
}
