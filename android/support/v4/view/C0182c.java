package android.support.v4.view;

import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0182c implements C0181j {
    final /* synthetic */ C0125a a;
    final /* synthetic */ C0154b b;

    C0182c(C0154b c0154b, C0125a c0125a) {
        this.b = c0154b;
        this.a = c0125a;
    }

    public void a(View view, int i) {
        this.a.a(view, i);
    }

    public void a(View view, Object obj) {
        this.a.a(view, new C0113o(obj));
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
