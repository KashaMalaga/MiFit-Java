package android.support.v4.view;

import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class aG extends aF {
    static Field b;
    static boolean c = false;

    aG() {
    }

    public bK J(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        bK bKVar = (bK) this.a.get(view);
        if (bKVar != null) {
            return bKVar;
        }
        bKVar = new bK(view);
        this.a.put(view, bKVar);
        return bKVar;
    }

    public void a(View view, C0113o c0113o) {
        aV.b(view, c0113o.a());
    }

    public void a(View view, C0125a c0125a) {
        aV.a(view, c0125a.a());
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        aV.a(view, accessibilityEvent);
    }

    public boolean a(View view, int i) {
        return aV.a(view, i);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        aV.b(view, accessibilityEvent);
    }

    public boolean b(View view, int i) {
        return aV.b(view, i);
    }

    public boolean f(View view) {
        boolean z = true;
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            if (b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }
}
