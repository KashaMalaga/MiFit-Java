package com.xiaomi.mistatistic.sdk.a;

import java.io.OutputStream;

final class g extends OutputStream {
    private OutputStream a;
    private b b;
    private d c;
    private int d = 0;

    public g(b bVar, OutputStream outputStream) {
        this.a = outputStream;
        this.b = bVar;
    }

    public g(d dVar, OutputStream outputStream) {
        this.a = outputStream;
        this.c = dVar;
    }

    private void a(Exception exception) {
        if (this.b != null) {
            this.b.a(exception);
        }
        if (this.c != null) {
            this.c.a(exception);
        }
    }

    public int a() {
        return this.d;
    }

    public void close() {
        try {
            this.a.close();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void flush() {
        try {
            this.a.flush();
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void write(int i) {
        try {
            this.a.write(i);
            this.d++;
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void write(byte[] bArr) {
        try {
            this.a.write(bArr);
            this.d += bArr.length;
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.a.write(bArr, i, i2);
            this.d += i2;
        } catch (Exception e) {
            a(e);
            throw e;
        }
    }
}
