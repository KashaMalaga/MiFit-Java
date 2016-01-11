package com.huami.android.bitmapfun;

import java.io.Closeable;
import java.io.InputStream;

public final class r implements Closeable {
    final /* synthetic */ m a;
    private final String b;
    private final long c;
    private final InputStream[] d;

    private r(m mVar, String str, long j, InputStream[] inputStreamArr) {
        this.a = mVar;
        this.b = str;
        this.c = j;
        this.d = inputStreamArr;
    }

    public o a() {
        return this.a.a(this.b, this.c);
    }

    public InputStream a(int i) {
        return this.d[i];
    }

    public String b(int i) {
        return m.c(a(i));
    }

    public void close() {
        for (Closeable a : this.d) {
            m.a(a);
        }
    }
}
