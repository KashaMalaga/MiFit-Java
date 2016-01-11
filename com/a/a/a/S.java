package com.a.a.a;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class S {
    public static final short a = (short) 1;
    public static final short b = (short) 2;
    public static final short c = (short) 3;
    public static final short d = (short) 4;
    public static final short e = (short) 5;
    public static final short f = (short) 7;
    public static final short g = (short) 9;
    public static final short h = (short) 10;
    static final int i = 0;
    private static Charset j = Charset.forName("US-ASCII");
    private static final int[] k = new int[11];
    private static final int l = 65535;
    private static final long m = 4294967295L;
    private static final long n = 2147483647L;
    private static final long o = -2147483648L;
    private static final SimpleDateFormat w = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private final short p;
    private final short q;
    private boolean r;
    private int s;
    private int t;
    private Object u = null;
    private int v;

    static {
        k[1] = 1;
        k[2] = 1;
        k[3] = 2;
        k[4] = 4;
        k[5] = 8;
        k[7] = 1;
        k[9] = 4;
        k[10] = 8;
    }

    S(short s, short s2, int i, int i2, boolean z) {
        this.p = s;
        this.q = s2;
        this.s = i;
        this.r = z;
        this.t = i2;
    }

    public static boolean a(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static boolean a(short s) {
        return s == a || s == b || s == c || s == d || s == e || s == f || s == g || s == h;
    }

    public static int b(short s) {
        return k[s];
    }

    private boolean b(int[] iArr) {
        int length = iArr.length;
        for (int i = i; i < length; i++) {
            int i2 = iArr[i];
            if (i2 > l || i2 < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean b(long[] jArr) {
        int length = jArr.length;
        for (int i = i; i < length; i++) {
            long j = jArr[i];
            if (j < 0 || j > m) {
                return true;
            }
        }
        return false;
    }

    private boolean b(X[] xArr) {
        int length = xArr.length;
        for (int i = i; i < length; i++) {
            X x = xArr[i];
            if (x.a() < 0 || x.b() < 0 || x.a() > m || x.b() > m) {
                return true;
            }
        }
        return false;
    }

    private static String c(short s) {
        switch (s) {
            case l.a /*1*/:
                return "UNSIGNED_BYTE";
            case a.k /*2*/:
                return "ASCII";
            case a.l /*3*/:
                return "UNSIGNED_SHORT";
            case a.aQ /*4*/:
                return "UNSIGNED_LONG";
            case a.X /*5*/:
                return "UNSIGNED_RATIONAL";
            case a.bc /*7*/:
                return "UNDEFINED";
            case a.bo /*9*/:
                return "LONG";
            case a.bd /*10*/:
                return "RATIONAL";
            default:
                return com.xiaomi.e.a.f;
        }
    }

    private boolean c(int[] iArr) {
        int length = iArr.length;
        for (int i = i; i < length; i++) {
            if (iArr[i] < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean c(X[] xArr) {
        int length = xArr.length;
        for (int i = i; i < length; i++) {
            X x = xArr[i];
            if (x.a() < o || x.b() < o || x.a() > n || x.b() > n) {
                return true;
            }
        }
        return false;
    }

    private boolean i(int i) {
        return this.r && this.s != i;
    }

    public int a() {
        return this.t;
    }

    protected void a(boolean z) {
        this.r = z;
    }

    public boolean a(byte b) {
        return a(new byte[]{b});
    }

    public boolean a(long j) {
        return a(new long[]{j});
    }

    public boolean a(X x) {
        return a(new X[]{x});
    }

    public boolean a(Object obj) {
        int i = i;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Short) {
            return d(((Short) obj).shortValue() & l);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        if (obj instanceof int[]) {
            return a((int[]) obj);
        }
        if (obj instanceof long[]) {
            return a((long[]) obj);
        }
        if (obj instanceof X) {
            return a((X) obj);
        }
        if (obj instanceof X[]) {
            return a((X[]) obj);
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj);
        }
        if (obj instanceof Integer) {
            return d(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return a(((Long) obj).longValue());
        }
        if (obj instanceof Byte) {
            return a(((Byte) obj).byteValue());
        }
        int[] iArr;
        int i2;
        if (obj instanceof Short[]) {
            Short[] shArr = (Short[]) obj;
            iArr = new int[shArr.length];
            for (i2 = i; i2 < shArr.length; i2++) {
                iArr[i2] = shArr[i2] == null ? i : shArr[i2].shortValue() & l;
            }
            return a(iArr);
        } else if (obj instanceof Integer[]) {
            Integer[] numArr = (Integer[]) obj;
            iArr = new int[numArr.length];
            for (i2 = i; i2 < numArr.length; i2++) {
                iArr[i2] = numArr[i2] == null ? i : numArr[i2].intValue();
            }
            return a(iArr);
        } else if (obj instanceof Long[]) {
            Long[] lArr = (Long[]) obj;
            long[] jArr = new long[lArr.length];
            while (i < lArr.length) {
                jArr[i] = lArr[i] == null ? 0 : lArr[i].longValue();
                i++;
            }
            return a(jArr);
        } else if (!(obj instanceof Byte[])) {
            return false;
        } else {
            Byte[] bArr = (Byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            for (i2 = i; i2 < bArr.length; i2++) {
                bArr2[i2] = bArr[i2] == null ? (byte) 0 : bArr[i2].byteValue();
            }
            return a(bArr2);
        }
    }

    public boolean a(String str) {
        if (this.q != b && this.q != f) {
            return false;
        }
        Object bytes = str.getBytes(j);
        if (bytes.length > 0) {
            if (!(bytes[bytes.length - 1] == (byte) 0 || this.q == f)) {
                bytes = Arrays.copyOf(bytes, bytes.length + 1);
            }
        } else if (this.q == b && this.s == 1) {
            bytes = new byte[1];
        }
        int length = bytes.length;
        if (i(length)) {
            return false;
        }
        this.s = length;
        this.u = bytes;
        return true;
    }

    public boolean a(byte[] bArr) {
        return a(bArr, i, bArr.length);
    }

    public boolean a(byte[] bArr, int i, int i2) {
        if (i(i2)) {
            return false;
        }
        if (this.q != a && this.q != f) {
            return false;
        }
        this.u = new byte[i2];
        System.arraycopy(bArr, i, this.u, i, i2);
        this.s = i2;
        return true;
    }

    public boolean a(int[] iArr) {
        int i = i;
        if (i(iArr.length)) {
            return false;
        }
        if (this.q != c && this.q != g && this.q != d) {
            return false;
        }
        if (this.q == c && b(iArr)) {
            return false;
        }
        if (this.q == d && c(iArr)) {
            return false;
        }
        Object obj = new long[iArr.length];
        while (i < iArr.length) {
            obj[i] = (long) iArr[i];
            i++;
        }
        this.u = obj;
        this.s = iArr.length;
        return true;
    }

    public boolean a(long[] jArr) {
        if (i(jArr.length) || this.q != d || b(jArr)) {
            return false;
        }
        this.u = jArr;
        this.s = jArr.length;
        return true;
    }

    public boolean a(X[] xArr) {
        if (i(xArr.length)) {
            return false;
        }
        if (this.q != e && this.q != h) {
            return false;
        }
        if (this.q == e && b(xArr)) {
            return false;
        }
        if (this.q == h && c(xArr)) {
            return false;
        }
        this.u = xArr;
        this.s = xArr.length;
        return true;
    }

    public byte b(byte b) {
        byte[] h = h();
        return (h == null || h.length < 1) ? b : h[i];
    }

    public X b(X x) {
        X[] i = i();
        return (i == null || i.length < 1) ? x : i[i];
    }

    public String b(String str) {
        String g = g();
        return g == null ? str : g;
    }

    public short b() {
        return this.p;
    }

    protected void b(int i) {
        this.t = i;
    }

    protected void b(byte[] bArr) {
        b(bArr, i, bArr.length);
    }

    protected void b(byte[] bArr, int i, int i2) {
        if (this.q == f || this.q == a) {
            Object obj = this.u;
            if (i2 > this.s) {
                i2 = this.s;
            }
            System.arraycopy(obj, i, bArr, i, i2);
            return;
        }
        throw new IllegalArgumentException("Cannot get BYTE value from " + c(this.q));
    }

    public boolean b(long j) {
        boolean a;
        synchronized (w) {
            a = a(w.format(new Date(j)));
        }
        return a;
    }

    public X c(long j) {
        return b(new X(j, 1));
    }

    public short c() {
        return this.q;
    }

    protected void c(int i) {
        this.s = i;
    }

    public int d() {
        return e() * b(c());
    }

    public long d(long j) {
        long[] k = k();
        return (k == null || k.length < 1) ? j : k[i];
    }

    public boolean d(int i) {
        return a(new int[]{i});
    }

    public int e() {
        return this.s;
    }

    public int e(int i) {
        int[] j = j();
        return (j == null || j.length < 1) ? i : j[i];
    }

    public long e(long j) {
        long[] k = k();
        if (k != null && k.length >= 1) {
            return k[i];
        }
        byte[] h = h();
        if (h != null && h.length >= 1) {
            return (long) h[i];
        }
        X[] i = i();
        return (i == null || i.length < 1 || i[i].b() == 0) ? j : (long) i[i].c();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof S)) {
            return false;
        }
        S s = (S) obj;
        return (s.p == this.p && s.s == this.s && s.q == this.q) ? this.u != null ? s.u != null ? this.u instanceof long[] ? s.u instanceof long[] ? Arrays.equals((long[]) this.u, (long[]) s.u) : false : this.u instanceof X[] ? s.u instanceof X[] ? Arrays.equals((X[]) this.u, (X[]) s.u) : false : this.u instanceof byte[] ? s.u instanceof byte[] ? Arrays.equals((byte[]) this.u, (byte[]) s.u) : false : this.u.equals(s.u) : false : s.u == null : false;
    }

    protected long f(int i) {
        if (this.u instanceof long[]) {
            return ((long[]) this.u)[i];
        }
        if (this.u instanceof byte[]) {
            return (long) ((byte[]) this.u)[i];
        }
        throw new IllegalArgumentException("Cannot get integer value from " + c(this.q));
    }

    public boolean f() {
        return this.u != null;
    }

    protected X g(int i) {
        if (this.q == h || this.q == e) {
            return ((X[]) this.u)[i];
        }
        throw new IllegalArgumentException("Cannot get RATIONAL value from " + c(this.q));
    }

    public String g() {
        return this.u == null ? null : this.u instanceof String ? (String) this.u : this.u instanceof byte[] ? new String((byte[]) this.u, j) : null;
    }

    protected void h(int i) {
        this.v = i;
    }

    public byte[] h() {
        return this.u instanceof byte[] ? (byte[]) this.u : null;
    }

    public X[] i() {
        return this.u instanceof X[] ? (X[]) this.u : null;
    }

    public int[] j() {
        if (this.u == null || !(this.u instanceof long[])) {
            return null;
        }
        long[] jArr = (long[]) this.u;
        int[] iArr = new int[jArr.length];
        for (int i = i; i < jArr.length; i++) {
            iArr[i] = (int) jArr[i];
        }
        return iArr;
    }

    public long[] k() {
        return this.u instanceof long[] ? (long[]) this.u : null;
    }

    public Object l() {
        return this.u;
    }

    public String m() {
        if (this.u == null) {
            return com.xiaomi.e.a.f;
        }
        if (this.u instanceof byte[]) {
            return this.q == b ? new String((byte[]) this.u, j) : Arrays.toString((byte[]) this.u);
        } else {
            if (this.u instanceof long[]) {
                return ((long[]) this.u).length == 1 ? String.valueOf(((long[]) this.u)[i]) : Arrays.toString((long[]) this.u);
            } else {
                if (!(this.u instanceof Object[])) {
                    return this.u.toString();
                }
                if (((Object[]) this.u).length != 1) {
                    return Arrays.toString((Object[]) this.u);
                }
                Object obj = ((Object[]) this.u)[i];
                return obj == null ? com.xiaomi.e.a.f : obj.toString();
            }
        }
    }

    protected String n() {
        if (this.q == b) {
            return new String((byte[]) this.u, j);
        }
        throw new IllegalArgumentException("Cannot get ASCII value from " + c(this.q));
    }

    protected byte[] o() {
        return (byte[]) this.u;
    }

    protected int p() {
        return this.v;
    }

    protected boolean q() {
        return this.r;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(String.format("tag id: %04X\n", new Object[]{Short.valueOf(this.p)}))).append("ifd id: ").append(this.t).append("\ntype: ").append(c(this.q)).append("\ncount: ").append(this.s).append("\noffset: ").append(this.v).append("\nvalue: ").append(m()).append("\n").toString();
    }
}
