package com.c.b;

public final class d extends r {
    private static final d b = new d();

    private d() {
    }

    private d(Throwable th) {
        super(th);
    }

    public static d a() {
        return a ? new d() : b;
    }

    public static d a(Throwable th) {
        return a ? new d(th) : b;
    }
}
