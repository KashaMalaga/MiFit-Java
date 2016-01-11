package com.xiaomi.market.sdk;

import java.io.OutputStream;

public abstract class n extends OutputStream {
    protected OutputStream b;
    final /* synthetic */ h c;

    public n(h hVar, OutputStream outputStream) {
        this.c = hVar;
        if (outputStream == null) {
            throw new IllegalArgumentException("outputstream is null");
        }
        this.b = outputStream;
    }

    public abstract void a();

    public void close() {
        this.b.close();
    }

    public void flush() {
        this.b.flush();
    }

    public void write(int i) {
        this.b.write(i);
    }

    public void write(byte[] bArr) {
        this.b.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }
}
