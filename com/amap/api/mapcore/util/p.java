package com.amap.api.mapcore.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class p<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    private void a(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.b >= 0 && (!this.a.isEmpty() || this.b == 0)) {
                    if (this.b <= i) {
                        return;
                    }
                    Entry entry = null;
                    for (Entry entry2 : this.a.entrySet()) {
                    }
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.a.remove(key);
                    this.b -= c(key, value);
                    this.f++;
                }
            }
            a(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    private int c(K k, V v) {
        int a = a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int a(K k, V v) {
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.b(r5);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.b;	 Catch:{ all -> 0x0053 }
        r3 = r4.c(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.c;
        r4.a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.p.a(java.lang.Object):V");
    }

    public final void a() {
        a(-1);
    }

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected V b(K k) {
        return null;
    }

    public final V b(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.c);
        return put;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.g + this.h;
            if (i2 != 0) {
                i = (this.g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i)});
        }
        return format;
    }
}
