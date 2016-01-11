package com.a.a.a;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class W extends FilterOutputStream {
    private final ByteBuffer a = ByteBuffer.allocate(4);

    public W(OutputStream outputStream) {
        super(outputStream);
    }

    public W a(int i) {
        this.a.rewind();
        this.a.putInt(i);
        this.out.write(this.a.array());
        return this;
    }

    public W a(X x) {
        a((int) x.a());
        a((int) x.b());
        return this;
    }

    public W a(ByteOrder byteOrder) {
        this.a.order(byteOrder);
        return this;
    }

    public W a(short s) {
        this.a.rewind();
        this.a.putShort(s);
        this.out.write(this.a.array(), 0, 2);
        return this;
    }
}
