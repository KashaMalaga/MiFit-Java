package com.f.a.a.a.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class d {
    final /* synthetic */ a a;
    private final f b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private d(a aVar, f fVar) {
        this.a = aVar;
        this.b = fVar;
        this.c = fVar.d ? null : new boolean[aVar.t];
    }

    public InputStream a(int i) {
        synchronized (this.a) {
            if (this.b.e != this) {
                throw new IllegalStateException();
            } else if (this.b.d) {
                try {
                    InputStream fileInputStream = new FileInputStream(this.b.a(i));
                    return fileInputStream;
                } catch (FileNotFoundException e) {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public void a() {
        if (this.d) {
            this.a.a(this, false);
            this.a.c(this.b.b);
        } else {
            this.a.a(this, true);
        }
        this.e = true;
    }

    public void a(int i, String str) {
        Closeable outputStreamWriter;
        Throwable th;
        try {
            outputStreamWriter = new OutputStreamWriter(c(i), k.b);
            try {
                outputStreamWriter.write(str);
                k.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                k.a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
            k.a(outputStreamWriter);
            throw th;
        }
    }

    public String b(int i) {
        InputStream a = a(i);
        return a != null ? a.b(a) : null;
    }

    public void b() {
        this.a.a(this, false);
    }

    public OutputStream c(int i) {
        OutputStream i2;
        synchronized (this.a) {
            File b;
            OutputStream fileOutputStream;
            if (this.b.e != this) {
                throw new IllegalStateException();
            }
            if (!this.b.d) {
                this.c[i] = true;
            }
            b = this.b.b(i);
            try {
                fileOutputStream = new FileOutputStream(b);
            } catch (FileNotFoundException e) {
                this.a.m.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e2) {
                    i2 = a.B;
                }
            }
            i2 = new e(this, fileOutputStream, null);
        }
        return i2;
    }

    public void c() {
        if (!this.e) {
            try {
                b();
            } catch (IOException e) {
            }
        }
    }
}
