package com.f.a.a.a.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class g implements Closeable {
    final /* synthetic */ a a;
    private final String b;
    private final long c;
    private File[] d;
    private final InputStream[] e;
    private final long[] f;

    private g(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
        this.a = aVar;
        this.b = str;
        this.c = j;
        this.d = fileArr;
        this.e = inputStreamArr;
        this.f = jArr;
    }

    public d a() {
        return this.a.a(this.b, this.c);
    }

    public File a(int i) {
        return this.d[i];
    }

    public InputStream b(int i) {
        return this.e[i];
    }

    public String c(int i) {
        return a.b(b(i));
    }

    public void close() {
        for (Closeable a : this.e) {
            k.a(a);
        }
    }

    public long d(int i) {
        return this.f[i];
    }
}
