package com.c.b;

public final class h extends r {
    private static final h b = new h();

    private h() {
    }

    private h(Throwable th) {
        super(th);
    }

    public static h a() {
        return a ? new h() : b;
    }

    public static h a(Throwable th) {
        return a ? new h(th) : b;
    }
}
