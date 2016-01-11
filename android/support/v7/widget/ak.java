package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0125a;
import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ak extends C0125a {
    final RecyclerView b;
    final C0125a c = new al(this);

    public ak(RecyclerView recyclerView) {
        this.b = recyclerView;
    }

    public void a(View view, C0113o c0113o) {
        super.a(view, c0113o);
        c0113o.b(RecyclerView.class.getName());
        if (this.b.e() != null) {
            this.b.e().a(c0113o);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : this.b.e() != null ? this.b.e().a(i, bundle) : false;
    }

    C0125a b() {
        return this.c;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.e() != null) {
                recyclerView.e().a(accessibilityEvent);
            }
        }
    }
}
