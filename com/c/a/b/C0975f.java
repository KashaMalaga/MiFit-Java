package com.c.a.b;

import com.c.a.c.a;
import com.c.a.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class C0975f {
    private final Map<Type, s<?>> a;

    public C0975f(Map<Type, s<?>> map) {
        this.a = map;
    }

    private <T> E<T> a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0981l(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> E<T> a(Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C0982m(this) : EnumSet.class.isAssignableFrom(cls) ? new C0983n(this, type) : Set.class.isAssignableFrom(cls) ? new C0984o(this) : Queue.class.isAssignableFrom(cls) ? new p(this) : new q(this) : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new r(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new C0978i(this) : new C0977h(this) : null;
    }

    private <T> E<T> b(Type type, Class<? super T> cls) {
        return new C0979j(this, cls, type);
    }

    public <T> E<T> a(a<T> aVar) {
        Type type = aVar.getType();
        Class rawType = aVar.getRawType();
        s sVar = (s) this.a.get(type);
        if (sVar != null) {
            return new C0976g(this, sVar, type);
        }
        sVar = (s) this.a.get(rawType);
        if (sVar != null) {
            return new C0980k(this, sVar, type);
        }
        E<T> a = a(rawType);
        if (a != null) {
            return a;
        }
        a = a(type, rawType);
        return a == null ? b(type, rawType) : a;
    }

    public String toString() {
        return this.a.toString();
    }
}
