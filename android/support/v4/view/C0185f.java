package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.L;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0185f implements C0184m {
    final /* synthetic */ C0125a a;
    final /* synthetic */ C0183e b;

    C0185f(C0183e c0183e, C0125a c0125a) {
        this.b = c0183e;
        this.a = c0125a;
    }

    public Object a(View view) {
        L a = this.a.a(view);
        return a != null ? a.a() : null;
    }

    public void a(View view, int i) {
        this.a.a(view, i);
    }

    public void a(View view, Object obj) {
        this.a.a(view, new C0113o(obj));
    }

    public boolean a(View view, int i, Bundle bundle) {
        return this.a.a(view, i, bundle);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.b(view, accessibilityEvent);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(viewGroup, view, accessibilityEvent);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.a(view, accessibilityEvent);
    }
}
