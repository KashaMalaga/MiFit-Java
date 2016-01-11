package com.c.b.a.c;

import com.c.b.c.a;

final class f extends h {
    private final short b;
    private final short c;

    f(h hVar, int i, int i2) {
        super(hVar);
        this.b = (short) i;
        this.c = (short) i2;
    }

    void a(a aVar, byte[] bArr) {
        aVar.c(this.b, this.c);
    }

    public String toString() {
        return '<' + Integer.toBinaryString(((this.b & ((1 << this.c) - 1)) | (1 << this.c)) | (1 << this.c)).substring(1) + '>';
    }
}
