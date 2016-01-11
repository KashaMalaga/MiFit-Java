package com.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class S {
    final /* synthetic */ R a;
    private final U b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private S(R r, U u) {
        this.a = r;
        this.b = u;
        this.c = u.d ? null : new boolean[r.i];
    }

    public OutputStream a(int i) {
        if (i < 0 || i >= this.a.i) {
            throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.a.i);
        }
        OutputStream b;
        synchronized (this.a) {
            File b2;
            OutputStream fileOutputStream;
            if (this.b.e != this) {
                throw new IllegalStateException();
            }
            if (!this.b.d) {
                this.c[i] = true;
            }
            b2 = this.b.b(i);
            try {
                fileOutputStream = new FileOutputStream(b2);
            } catch (FileNotFoundException e) {
                this.a.c.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException e2) {
                    b = R.p;
                }
            }
            b = new T(this, fileOutputStream, null);
        }
        return b;
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

    public void b() {
        this.a.a(this, false);
    }
}
