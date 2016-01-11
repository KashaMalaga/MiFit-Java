package com.c.a.b;

import com.c.a.x;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class C0983n implements E<T> {
    final /* synthetic */ Type a;
    final /* synthetic */ C0975f b;

    C0983n(C0975f c0975f, Type type) {
        this.b = c0975f;
        this.a = type;
    }

    public T a() {
        if (this.a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            throw new x("Invalid EnumSet type: " + this.a.toString());
        }
        throw new x("Invalid EnumSet type: " + this.a.toString());
    }
}
