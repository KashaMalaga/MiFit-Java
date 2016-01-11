package com.c.b;

public abstract class r extends Exception {
    protected static final boolean a = (System.getProperty("surefire.test.class.path") != null);

    r() {
    }

    r(Throwable th) {
        super(th);
    }

    public final Throwable fillInStackTrace() {
        return null;
    }
}
