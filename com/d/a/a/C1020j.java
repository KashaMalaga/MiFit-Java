package com.d.a.a;

import java.io.UnsupportedEncodingException;

public class C1020j {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;

    private C1020j() {
    }

    public static byte[] a(String str, int i) {
        return C1020j.a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return C1020j.a(bArr, a, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        C1022l c1022l = new C1022l(i3, new byte[((i2 * 3) / d)]);
        if (!c1022l.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c1022l.b == c1022l.a.length) {
            return c1022l.a;
        } else {
            Object obj = new byte[c1022l.b];
            System.arraycopy(c1022l.a, a, obj, a, c1022l.b);
            return obj;
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(C1020j.c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String b(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(C1020j.c(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] c(byte[] bArr, int i) {
        return C1020j.c(bArr, a, bArr.length, i);
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        C1023m c1023m = new C1023m(i3, null);
        int i4 = (i2 / 3) * d;
        if (!c1023m.e) {
            switch (i2 % 3) {
                case a /*0*/:
                    break;
                case b /*1*/:
                    i4 += c;
                    break;
                case c /*2*/:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += d;
        }
        if (c1023m.f && i2 > 0) {
            i4 += (c1023m.g ? c : b) * (((i2 - 1) / 57) + b);
        }
        c1023m.a = new byte[i4];
        c1023m.a(bArr, i, i2, true);
        if (c1023m.b == i4) {
            return c1023m.a;
        }
        throw new AssertionError();
    }
}
