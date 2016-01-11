package com.c.a;

import com.c.a.b.C0970a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class C0985c {
    private final Field a;

    public C0985c(Field field) {
        C0970a.a((Object) field);
        this.a = field;
    }

    public Class<?> a() {
        return this.a.getDeclaringClass();
    }

    Object a(Object obj) {
        return this.a.get(obj);
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return this.a.getAnnotation(cls);
    }

    public boolean a(int i) {
        return (this.a.getModifiers() & i) != 0;
    }

    public String b() {
        return this.a.getName();
    }

    public Type c() {
        return this.a.getGenericType();
    }

    public Class<?> d() {
        return this.a.getType();
    }

    public Collection<Annotation> e() {
        return Arrays.asList(this.a.getAnnotations());
    }

    boolean f() {
        return this.a.isSynthetic();
    }
}
