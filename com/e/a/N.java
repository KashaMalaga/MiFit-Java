package com.e.a;

import android.util.Log;
import com.e.b.b;
import com.e.b.d;
import java.lang.reflect.InvocationTargetException;

class N extends L {
    C1050p h;
    int i;
    private b j;

    public N(d dVar, C1050p c1050p) {
        super(dVar);
        this.d = Integer.TYPE;
        this.e = c1050p;
        this.h = (C1050p) this.e;
        if (dVar instanceof b) {
            this.j = (b) this.b;
        }
    }

    public N(d dVar, int... iArr) {
        super(dVar);
        a(iArr);
        if (dVar instanceof b) {
            this.j = (b) this.b;
        }
    }

    public N(String str, C1050p c1050p) {
        super(str);
        this.d = Integer.TYPE;
        this.e = c1050p;
        this.h = (C1050p) this.e;
    }

    public N(String str, int... iArr) {
        super(str);
        a(iArr);
    }

    public /* synthetic */ L a() {
        return e();
    }

    void a(float f) {
        this.i = this.h.b(f);
    }

    void a(Class cls) {
        if (this.b == null) {
            super.a(cls);
        }
    }

    public void a(int... iArr) {
        super.a(iArr);
        this.h = (C1050p) this.e;
    }

    Object d() {
        return Integer.valueOf(this.i);
    }

    void d(Object obj) {
        if (this.j != null) {
            this.j.a(obj, this.i);
        } else if (this.b != null) {
            this.b.a(obj, Integer.valueOf(this.i));
        } else if (this.c != null) {
            try {
                this.g[0] = Integer.valueOf(this.i);
                this.c.invoke(obj, this.g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public N e() {
        N n = (N) super.a();
        n.h = (C1050p) n.e;
        return n;
    }
}
