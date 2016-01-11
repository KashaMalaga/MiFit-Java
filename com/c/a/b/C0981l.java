package com.c.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class C0981l implements E<T> {
    final /* synthetic */ Constructor a;
    final /* synthetic */ C0975f b;

    C0981l(C0975f c0975f, Constructor constructor) {
        this.b = c0975f;
        this.a = constructor;
    }

    public T a() {
        try {
            return this.a.newInstance(null);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
