package com.c.a.b;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class C0974e implements Serializable, WildcardType {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final Type b;

    public C0974e(Type[] typeArr, Type[] typeArr2) {
        boolean z = true;
        C0970a.a(typeArr2.length <= 1);
        C0970a.a(typeArr.length == 1);
        if (typeArr2.length == 1) {
            C0970a.a(typeArr2[0]);
            C0971b.i(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                z = false;
            }
            C0970a.a(z);
            this.b = C0971b.d(typeArr2[0]);
            this.a = Object.class;
            return;
        }
        C0970a.a(typeArr[0]);
        C0971b.i(typeArr[0]);
        this.b = null;
        this.a = C0971b.d(typeArr[0]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && C0971b.a((Type) this, (WildcardType) obj);
    }

    public Type[] getLowerBounds() {
        if (this.b == null) {
            return C0971b.a;
        }
        return new Type[]{this.b};
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public int hashCode() {
        return (this.b != null ? this.b.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
    }

    public String toString() {
        return this.b != null ? "? super " + C0971b.f(this.b) : this.a == Object.class ? "?" : "? extends " + C0971b.f(this.a);
    }
}
