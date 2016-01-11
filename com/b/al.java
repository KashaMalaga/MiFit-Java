package com.b;

import b.a.C0374dh;
import com.d.a.a.C1012a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class al implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public al(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(an.a)) {
            this.a = inputStream;
            this.b = charset;
            this.c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public al(InputStream inputStream, Charset charset) {
        this(inputStream, C1012a.e, charset);
    }

    private void b() {
        int read = this.a.read(this.c, 0, this.c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    public String a() {
        String str;
        synchronized (this.a) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.d >= this.e) {
                b();
            }
            int i2 = this.d;
            while (i2 != this.e) {
                if (this.c[i2] == (byte) 10) {
                    int i3 = (i2 == this.d || this.c[i2 - 1] != C0374dh.k) ? i2 : i2 - 1;
                    str = new String(this.c, this.d, i3 - this.d, this.b.name());
                    this.d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream amVar = new am(this, (this.e - this.d) + 80);
            loop1:
            while (true) {
                amVar.write(this.c, this.d, this.e - this.d);
                this.e = -1;
                b();
                i = this.d;
                while (i != this.e) {
                    if (this.c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.d) {
                amVar.write(this.c, this.d, i - this.d);
            }
            this.d = i + 1;
            str = amVar.toString();
        }
        return str;
    }

    public void close() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }
}
