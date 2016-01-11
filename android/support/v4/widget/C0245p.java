package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0125a;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

class C0245p extends C0125a {
    final /* synthetic */ DrawerLayout b;
    private final Rect c = new Rect();

    C0245p(DrawerLayout drawerLayout) {
        this.b = drawerLayout;
    }

    private void a(C0113o c0113o, C0113o c0113o2) {
        Rect rect = this.c;
        c0113o2.a(rect);
        c0113o.b(rect);
        c0113o2.c(rect);
        c0113o.d(rect);
        c0113o.e(c0113o2.l());
        c0113o.a(c0113o2.t());
        c0113o.b(c0113o2.u());
        c0113o.d(c0113o2.w());
        c0113o.j(c0113o2.q());
        c0113o.h(c0113o2.o());
        c0113o.c(c0113o2.j());
        c0113o.d(c0113o2.k());
        c0113o.f(c0113o2.m());
        c0113o.g(c0113o2.n());
        c0113o.i(c0113o2.p());
        c0113o.d(c0113o2.e());
    }

    private void a(C0113o c0113o, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.n(childAt)) {
                c0113o.c(childAt);
            }
        }
    }

    public void a(View view, C0113o c0113o) {
        if (DrawerLayout.q) {
            super.a(view, c0113o);
        } else {
            C0113o a = C0113o.a(c0113o);
            super.a(view, a);
            c0113o.b(view);
            ViewParent k = C0151az.k(view);
            if (k instanceof View) {
                c0113o.d((View) k);
            }
            a(c0113o, a);
            a.x();
            a(c0113o, (ViewGroup) view);
        }
        c0113o.b(DrawerLayout.class.getName());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return (DrawerLayout.q || DrawerLayout.n(view)) ? super.a(viewGroup, view, accessibilityEvent) : false;
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.b(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.b.h();
        if (a != null) {
            CharSequence d = this.b.d(this.b.e(a));
            if (d != null) {
                text.add(d);
            }
        }
        return true;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
}
