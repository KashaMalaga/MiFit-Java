package com.huami.android.bitmapfun;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class o {
    final /* synthetic */ m a;
    private final q b;
    private boolean c;

    private o(m mVar, q qVar) {
        this.a = mVar;
        this.b = qVar;
    }

    public InputStream a(int i) {
        InputStream fileInputStream;
        synchronized (this.a) {
            if (this.b.e != this) {
                throw new IllegalStateException();
            } else if (this.b.d) {
                fileInputStream = new FileInputStream(this.b.a(i));
            } else {
                fileInputStream = null;
            }
        }
        return fileInputStream;
    }

    public void a() {
        if (this.c) {
            this.a.a(this, false);
            this.a.c(this.b.b);
            return;
        }
        this.a.a(this, true);
    }

    public void a(int i, String str) {
        Closeable outputStreamWriter;
        Throwable th;
        try {
            outputStreamWriter = new OutputStreamWriter(c(i), m.j);
            try {
                outputStreamWriter.write(str);
                m.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                m.a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
            m.a(outputStreamWriter);
            throw th;
        }
    }

    public String b(int i) {
        InputStream a = a(i);
        return a != null ? m.c(a) : null;
    }

    public void b() {
        this.a.a(this, false);
    }

    public OutputStream c(int i) {
        OutputStream pVar;
        synchronized (this.a) {
            if (this.b.e != this) {
                throw new IllegalStateException();
            }
            pVar = new p(this, new FileOutputStream(this.b.b(i)), null);
        }
        return pVar;
    }
}
