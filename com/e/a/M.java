package com.e.a;

import android.util.Log;
import com.e.b.a;
import com.e.b.d;
import java.lang.reflect.InvocationTargetException;

class M extends L {
    C1048n h;
    float i;
    private a j;

    public M(d dVar, C1048n c1048n) {
        super(dVar);
        this.d = Float.TYPE;
        this.e = c1048n;
        this.h = (C1048n) this.e;
        if (dVar instanceof a) {
            this.j = (a) this.b;
        }
    }

    public M(d dVar, float... fArr) {
        super(dVar);
        a(fArr);
        if (dVar instanceof a) {
            this.j = (a) this.b;
        }
    }

    public M(String str, C1048n c1048n) {
        super(str);
        this.d = Float.TYPE;
        this.e = c1048n;
        this.h = (C1048n) this.e;
    }

    public M(String str, float... fArr) {
        super(str);
        a(fArr);
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

    public void a(float... fArr) {
        super.a(fArr);
        this.h = (C1048n) this.e;
    }

    Object d() {
        return Float.valueOf(this.i);
    }

    void d(Object obj) {
        if (this.j != null) {
            this.j.a(obj, this.i);
        } else if (this.b != null) {
            this.b.a(obj, Float.valueOf(this.i));
        } else if (this.c != null) {
            try {
                this.g[0] = Float.valueOf(this.i);
                this.c.invoke(obj, this.g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public M e() {
        M m = (M) super.a();
        m.h = (C1048n) m.e;
        return m;
    }
}
