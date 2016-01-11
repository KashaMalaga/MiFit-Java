package com.c.a.b;

import com.c.a.C0985c;
import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.a.c;
import com.c.a.a.d;
import com.c.a.b;
import com.c.a.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class s implements P, Cloneable {
    public static final s a = new s();
    private static final double b = -1.0d;
    private double c = b;
    private int d = 136;
    private boolean e = true;
    private boolean f;
    private List<b> g = Collections.emptyList();
    private List<b> h = Collections.emptyList();

    private boolean a(c cVar) {
        return cVar == null || cVar.a() <= this.c;
    }

    private boolean a(c cVar, d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.a() > this.c;
    }

    private boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Class rawType = aVar.getRawType();
        boolean a = a(rawType, true);
        boolean a2 = a(rawType, false);
        return (a || a2) ? new t(this, a2, a, c0993k, aVar) : null;
    }

    protected s a() {
        try {
            return (s) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public s a(double d) {
        s a = a();
        a.c = d;
        return a;
    }

    public s a(b bVar, boolean z, boolean z2) {
        s a = a();
        if (z) {
            a.g = new ArrayList(this.g);
            a.g.add(bVar);
        }
        if (z2) {
            a.h = new ArrayList(this.h);
            a.h.add(bVar);
        }
        return a;
    }

    public s a(int... iArr) {
        int i = 0;
        s a = a();
        a.d = 0;
        int length = iArr.length;
        while (i < length) {
            a.d = iArr[i] | a.d;
            i++;
        }
        return a;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.c != b && !a((c) cls.getAnnotation(c.class), (d) cls.getAnnotation(d.class))) {
            return true;
        }
        if (!this.e && b(cls)) {
            return true;
        }
        if (a((Class) cls)) {
            return true;
        }
        for (b a : z ? this.g : this.h) {
            if (a.a((Class) cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Field field, boolean z) {
        if ((this.d & field.getModifiers()) != 0) {
            return true;
        }
        if (this.c != b && !a((c) field.getAnnotation(c.class), (d) field.getAnnotation(d.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f) {
            com.c.a.a.a aVar = (com.c.a.a.a) field.getAnnotation(com.c.a.a.a.class);
            if (aVar == null || (z ? !aVar.a() : !aVar.b())) {
                return true;
            }
        }
        if (!this.e && b(field.getType())) {
            return true;
        }
        if (a(field.getType())) {
            return true;
        }
        List<b> list = z ? this.g : this.h;
        if (!list.isEmpty()) {
            C0985c c0985c = new C0985c(field);
            for (b a : list) {
                if (a.a(c0985c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public s b() {
        s a = a();
        a.e = false;
        return a;
    }

    public s c() {
        s a = a();
        a.f = true;
        return a;
    }

    protected /* synthetic */ Object clone() {
        return a();
    }
}
