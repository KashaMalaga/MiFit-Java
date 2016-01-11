package com.c.a.b;

import java.lang.reflect.Type;

class C0979j implements E<T> {
    final /* synthetic */ Class a;
    final /* synthetic */ Type b;
    final /* synthetic */ C0975f c;
    private final K d = K.a();

    C0979j(C0975f c0975f, Class cls, Type type) {
        this.c = c0975f;
        this.a = cls;
        this.b = type;
    }

    public T a() {
        try {
            return this.d.a(this.a);
        } catch (Throwable e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
