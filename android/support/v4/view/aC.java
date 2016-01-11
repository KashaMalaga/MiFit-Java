package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.L;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

class aC implements aP {
    WeakHashMap<View, bK> a = null;
    private Method b;
    private Method c;
    private boolean d;

    aC() {
    }

    private void b() {
        try {
            this.b = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            this.c = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (Throwable e) {
            Log.e(aS.a, "Couldn't find method", e);
        }
        this.d = true;
    }

    public float A(View view) {
        return 0.0f;
    }

    public float B(View view) {
        return 0.0f;
    }

    public float C(View view) {
        return 0.0f;
    }

    public float D(View view) {
        return 0.0f;
    }

    public float E(View view) {
        return 0.0f;
    }

    public float F(View view) {
        return 0.0f;
    }

    public float G(View view) {
        return 0.0f;
    }

    public int H(View view) {
        return 0;
    }

    public int I(View view) {
        return 0;
    }

    public bK J(View view) {
        return new bK(view);
    }

    public float K(View view) {
        return 0.0f;
    }

    public float L(View view) {
        return 0.0f;
    }

    public int M(View view) {
        return 0;
    }

    public boolean N(View view) {
        return false;
    }

    public void O(View view) {
    }

    public int a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    long a() {
        return 10;
    }

    public String a(View view) {
        return null;
    }

    public void a(View view, float f) {
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void a(View view, int i, Paint paint) {
    }

    public void a(View view, Paint paint) {
    }

    public void a(View view, C0113o c0113o) {
    }

    public void a(View view, C0125a c0125a) {
    }

    public void a(View view, C0130ad c0130ad) {
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    public void a(View view, String str) {
    }

    public void a(View view, boolean z) {
    }

    public void a(ViewGroup viewGroup, boolean z) {
    }

    public boolean a(View view, int i) {
        return false;
    }

    public boolean a(View view, int i, Bundle bundle) {
        return false;
    }

    public void b(View view) {
    }

    public void b(View view, float f) {
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
    }

    public boolean b(View view, int i) {
        return false;
    }

    public float c(View view) {
        return 0.0f;
    }

    public void c(View view, float f) {
    }

    public void c(View view, int i) {
    }

    public float d(View view) {
        return 0.0f;
    }

    public void d(View view, float f) {
    }

    public void d(View view, int i) {
    }

    public int e(View view) {
        return 2;
    }

    public void e(View view, float f) {
    }

    public void e(View view, int i) {
    }

    public void f(View view, float f) {
    }

    public void f(View view, int i) {
    }

    public boolean f(View view) {
        return false;
    }

    public void g(View view, float f) {
    }

    public void g(View view, int i) {
    }

    public boolean g(View view) {
        return false;
    }

    public void h(View view) {
        view.invalidate();
    }

    public void h(View view, float f) {
    }

    public int i(View view) {
        return 0;
    }

    public void i(View view, float f) {
    }

    public L j(View view) {
        return null;
    }

    public void j(View view, float f) {
    }

    public float k(View view) {
        return 1.0f;
    }

    public void k(View view, float f) {
    }

    public int l(View view) {
        return 0;
    }

    public void l(View view, float f) {
    }

    public int m(View view) {
        return 0;
    }

    public void m(View view, float f) {
    }

    public int n(View view) {
        return 0;
    }

    public void n(View view, float f) {
    }

    public ViewParent o(View view) {
        return view.getParent();
    }

    public boolean p(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int q(View view) {
        return view.getMeasuredWidth();
    }

    public int r(View view) {
        return view.getMeasuredHeight();
    }

    public int s(View view) {
        return 0;
    }

    public int t(View view) {
        return 0;
    }

    public int u(View view) {
        return view.getPaddingLeft();
    }

    public int v(View view) {
        return view.getPaddingRight();
    }

    public void w(View view) {
        if (!this.d) {
            b();
        }
        if (this.b != null) {
            try {
                this.b.invoke(view, new Object[0]);
                return;
            } catch (Throwable e) {
                Log.d(aS.a, "Error calling dispatchStartTemporaryDetach", e);
                return;
            }
        }
        view.onStartTemporaryDetach();
    }

    public void x(View view) {
        if (!this.d) {
            b();
        }
        if (this.c != null) {
            try {
                this.c.invoke(view, new Object[0]);
                return;
            } catch (Throwable e) {
                Log.d(aS.a, "Error calling dispatchFinishTemporaryDetach", e);
                return;
            }
        }
        view.onFinishTemporaryDetach();
    }

    public float y(View view) {
        return 0.0f;
    }

    public float z(View view) {
        return 0.0f;
    }
}
