package com.a.a.a;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class C0894c {
    private static final String a = "ExifData";
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private final T[] e = new T[5];
    private byte[] f;
    private final ArrayList<byte[]> g = new ArrayList();
    private final ByteOrder h;

    static {
        r0 = new byte[8];
        b = r0;
        r0 = new byte[8];
        c = r0;
        r0 = new byte[8];
        r0[0] = (byte) 85;
        r0[1] = (byte) 78;
        r0[2] = (byte) 73;
        r0[3] = (byte) 67;
        r0[4] = (byte) 79;
        r0[5] = (byte) 68;
        r0[6] = (byte) 69;
        d = r0;
    }

    C0894c(ByteOrder byteOrder) {
        this.h = byteOrder;
    }

    protected S a(S s) {
        return s != null ? a(s, s.a()) : null;
    }

    protected S a(S s, int i) {
        return (s == null || !S.a(i)) ? null : c(i).a(s);
    }

    protected S a(short s, int i) {
        T t = this.e[i];
        return t == null ? null : t.a(s);
    }

    protected List<S> a(short s) {
        List arrayList = new ArrayList();
        for (T t : this.e) {
            if (t != null) {
                S a = t.a(s);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        return arrayList.size() == 0 ? null : arrayList;
    }

    protected void a(int i, byte[] bArr) {
        if (i < this.g.size()) {
            this.g.set(i, bArr);
            return;
        }
        for (int size = this.g.size(); size < i; size++) {
            this.g.add(null);
        }
        this.g.add(bArr);
    }

    protected void a(T t) {
        this.e[t.c()] = t;
    }

    protected void a(byte[] bArr) {
        this.f = bArr;
    }

    protected byte[] a() {
        return this.f;
    }

    protected byte[] a(int i) {
        return (byte[]) this.g.get(i);
    }

    protected T b(int i) {
        return S.a(i) ? this.e[i] : null;
    }

    protected void b(short s, int i) {
        T t = this.e[i];
        if (t != null) {
            t.c(s);
        }
    }

    protected boolean b() {
        return this.f != null;
    }

    protected int c() {
        return this.g.size();
    }

    protected T c(int i) {
        T t = this.e[i];
        if (t != null) {
            return t;
        }
        t = new T(i);
        this.e[i] = t;
        return t;
    }

    protected List<S> d(int i) {
        T t = this.e[i];
        if (t == null) {
            return null;
        }
        S[] b = t.b();
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(b.length);
        for (Object add : b) {
            arrayList.add(add);
        }
        return arrayList.size() != 0 ? arrayList : null;
    }

    protected boolean d() {
        return this.g.size() != 0;
    }

    protected ByteOrder e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0894c)) {
            return false;
        }
        C0894c c0894c = (C0894c) obj;
        if (c0894c.h != this.h || c0894c.g.size() != this.g.size() || !Arrays.equals(c0894c.f, this.f)) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (!Arrays.equals((byte[]) c0894c.g.get(i), (byte[]) this.g.get(i))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < 5; i2++) {
            T b = c0894c.b(i2);
            T b2 = b(i2);
            if (b != b2 && b != null && !b.equals(b2)) {
                return false;
            }
        }
        return true;
    }

    protected void f() {
        this.f = null;
        this.g.clear();
    }

    protected void g() {
        f();
        this.e[1] = null;
    }

    protected String h() {
        T t = this.e[0];
        if (t == null) {
            return null;
        }
        S a = t.a(C0895d.a(C0895d.ag));
        if (a == null || a.e() < 8) {
            return null;
        }
        byte[] bArr = new byte[a.e()];
        a.b(bArr);
        Object obj = new byte[8];
        System.arraycopy(bArr, 0, obj, 0, 8);
        try {
            return Arrays.equals(obj, b) ? new String(bArr, 8, bArr.length - 8, "US-ASCII") : Arrays.equals(obj, c) ? new String(bArr, 8, bArr.length - 8, "EUC-JP") : Arrays.equals(obj, d) ? new String(bArr, 8, bArr.length - 8, "UTF-16") : null;
        } catch (UnsupportedEncodingException e) {
            Log.w(a, "Failed to decode the user comment");
            return null;
        }
    }

    protected List<S> i() {
        List arrayList = new ArrayList();
        for (T t : this.e) {
            if (t != null) {
                S[] b = t.b();
                if (b != null) {
                    for (Object add : b) {
                        arrayList.add(add);
                    }
                }
            }
        }
        return arrayList.size() == 0 ? null : arrayList;
    }
}
