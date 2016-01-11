package com.f.a.a.a.a.a;

import com.d.a.a.C1012a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class i implements Closeable {
    private static final byte a = (byte) 13;
    private static final byte b = (byte) 10;
    private final InputStream c;
    private final Charset d;
    private byte[] e;
    private int f;
    private int g;

    public i(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(k.a)) {
            this.c = inputStream;
            this.d = charset;
            this.e = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public i(InputStream inputStream, Charset charset) {
        this(inputStream, C1012a.e, charset);
    }

    private void b() {
        int read = this.c.read(this.e, 0, this.e.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f = 0;
        this.g = read;
    }

    public String a() {
        String str;
        synchronized (this.c) {
            if (this.e == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f >= this.g) {
                b();
            }
            int i2 = this.f;
            while (i2 != this.g) {
                if (this.e[i2] == b) {
                    int i3 = (i2 == this.f || this.e[i2 - 1] != a) ? i2 : i2 - 1;
                    str = new String(this.e, this.f, i3 - this.f, this.d.name());
                    this.f = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream jVar = new j(this, (this.g - this.f) + 80);
            loop1:
            while (true) {
                jVar.write(this.e, this.f, this.g - this.f);
                this.g = -1;
                b();
                i = this.f;
                while (i != this.g) {
                    if (this.e[i] == b) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f) {
                jVar.write(this.e, this.f, i - this.f);
            }
            this.f = i + 1;
            str = jVar.toString();
        }
        return str;
    }

    public void close() {
        synchronized (this.c) {
            if (this.e != null) {
                this.e = null;
                this.c.close();
            }
        }
    }
}
