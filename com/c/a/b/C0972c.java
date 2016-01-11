package com.c.a.b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class C0972c implements Serializable, GenericArrayType {
    private static final long serialVersionUID = 0;
    private final Type a;

    public C0972c(Type type) {
        this.a = C0971b.d(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && C0971b.a((Type) this, (GenericArrayType) obj);
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return C0971b.f(this.a) + "[]";
    }
}
