package com.b;

import java.io.Closeable;
import java.io.InputStream;

public final class V implements Closeable {
    final /* synthetic */ R a;
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;

    private V(R r, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
        this.a = r;
        this.b = str;
        this.c = j;
        this.d = inputStreamArr;
        this.e = jArr;
    }

    public InputStream a(int i) {
        return this.d[i];
    }

    public void close() {
        for (Closeable a : this.d) {
            an.a(a);
        }
    }
}
