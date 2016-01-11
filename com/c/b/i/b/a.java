package com.c.b.i.b;

import com.c.b.u;

public final class a extends u {
    private final float a;

    a(float f, float f2, float f3) {
        super(f, f2);
        this.a = f3;
    }

    boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.a);
        return abs <= 1.0f || abs <= this.a;
    }

    a b(float f, float f2, float f3) {
        return new a((a() + f2) / 2.0f, (b() + f) / 2.0f, (this.a + f3) / 2.0f);
    }
}
