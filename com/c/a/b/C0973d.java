package com.c.a.b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class C0973d implements Serializable, ParameterizedType {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final Type b;
    private final Type[] c;

    public C0973d(Type type, Type type2, Type... typeArr) {
        boolean z = true;
        int i = 0;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z2 = type != null || cls.getEnclosingClass() == null;
            C0970a.a(z2);
            if (type != null && cls.getEnclosingClass() == null) {
                z = false;
            }
            C0970a.a(z);
        }
        this.a = type == null ? null : C0971b.d(type);
        this.b = C0971b.d(type2);
        this.c = (Type[]) typeArr.clone();
        while (i < this.c.length) {
            C0970a.a(this.c[i]);
            C0971b.i(this.c[i]);
            this.c[i] = C0971b.d(this.c[i]);
            i++;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && C0971b.a((Type) this, (ParameterizedType) obj);
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    public Type getOwnerType() {
        return this.a;
    }

    public Type getRawType() {
        return this.b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ C0971b.b(this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((this.c.length + 1) * 30);
        stringBuilder.append(C0971b.f(this.b));
        if (this.c.length == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<").append(C0971b.f(this.c[0]));
        for (int i = 1; i < this.c.length; i++) {
            stringBuilder.append(", ").append(C0971b.f(this.c[i]));
        }
        return stringBuilder.append(">").toString();
    }
}
