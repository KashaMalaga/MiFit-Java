package com.d.a.a;

import com.activeandroid.b;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class C1025o extends FilterOutputStream {
    private static byte[] e = new byte[0];
    private final C1021k a;
    private final int b;
    private byte[] c;
    private int d;

    public C1025o(OutputStream outputStream, int i) {
        this(outputStream, i, true);
    }

    public C1025o(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.c = null;
        this.d = 0;
        this.b = i;
        if (z) {
            this.a = new C1023m(i, null);
        } else {
            this.a = new C1022l(i, null);
        }
    }

    private void a() {
        if (this.d > 0) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
    }

    private void a(byte[] bArr, int i, int i2, boolean z) {
        this.a.a = a(this.a.a, this.a.a(i2));
        if (this.a.a(bArr, i, i2, z)) {
            this.out.write(this.a.a, 0, this.a.b);
            return;
        }
        throw new C1024n("bad base-64");
    }

    private byte[] a(byte[] bArr, int i) {
        return (bArr == null || bArr.length < i) ? new byte[i] : bArr;
    }

    public void close() {
        IOException iOException = null;
        try {
            a();
            a(e, 0, 0, true);
        } catch (IOException e) {
            IOException e2;
            iOException = e2;
        }
        try {
            if ((this.b & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
            e2 = iOException;
        } catch (IOException e3) {
            e2 = e3;
            if (iOException == null) {
                e2 = iOException;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public void write(int i) {
        if (this.c == null) {
            this.c = new byte[b.a];
        }
        if (this.d >= this.c.length) {
            a(this.c, 0, this.d, false);
            this.d = 0;
        }
        byte[] bArr = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            a();
            a(bArr, i, i2, false);
        }
    }
}
