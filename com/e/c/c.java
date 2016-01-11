package com.e.c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import com.e.a.C1035b;
import java.util.WeakHashMap;

public abstract class c {
    private static final WeakHashMap<View, c> a = new WeakHashMap(0);

    public static c a(View view) {
        c cVar = (c) a.get(view);
        if (cVar == null) {
            int intValue = Integer.valueOf(VERSION.SDK).intValue();
            cVar = intValue >= 14 ? new i(view) : intValue >= 11 ? new d(view) : new k(view);
            a.put(view, cVar);
        }
        return cVar;
    }

    public abstract long a();

    public abstract c a(float f);

    public abstract c a(long j);

    public abstract c a(Interpolator interpolator);

    public abstract c a(C1035b c1035b);

    public abstract long b();

    public abstract c b(float f);

    public abstract c b(long j);

    public abstract c c(float f);

    public abstract void c();

    public abstract c d(float f);

    public abstract c e(float f);

    public abstract c f(float f);

    public abstract c g(float f);

    public abstract c h(float f);

    public abstract c i(float f);

    public abstract c j(float f);

    public abstract c k(float f);

    public abstract c l(float f);

    public abstract c m(float f);

    public abstract c n(float f);

    public abstract c o(float f);

    public abstract c p(float f);

    public abstract c q(float f);

    public abstract c r(float f);

    public abstract c s(float f);

    public abstract void start();

    public abstract c t(float f);
}
