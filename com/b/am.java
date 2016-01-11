package com.b;

import b.a.C0374dh;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

class am extends ByteArrayOutputStream {
    final /* synthetic */ al a;

    am(al alVar, int i) {
        this.a = alVar;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != C0374dh.k) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.a.b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
