package com.f.a.a.a.a.a;

import b.a.C0374dh;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

class j extends ByteArrayOutputStream {
    final /* synthetic */ i a;

    j(i iVar, int i) {
        this.a = iVar;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != C0374dh.k) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.a.d.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
