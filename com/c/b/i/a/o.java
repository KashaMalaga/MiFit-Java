package com.c.b.i.a;

public enum o {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final o[] e = null;
    private final int f;

    static {
        e = new o[]{M, L, H, Q};
    }

    private o(int i) {
        this.f = i;
    }

    public static o a(int i) {
        if (i >= 0 && i < e.length) {
            return e[i];
        }
        throw new IllegalArgumentException();
    }

    public int a() {
        return this.f;
    }
}
