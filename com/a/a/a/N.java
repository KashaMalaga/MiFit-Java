package com.a.a.a;

import android.util.Log;
import com.xiaomi.e.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.TreeMap;

public class N {
    private static final short P = C0895d.a(C0895d.F);
    private static final short Q = C0895d.a(C0895d.G);
    private static final short R = C0895d.a(C0895d.ap);
    private static final short S = C0895d.a(C0895d.H);
    private static final short T = C0895d.a(C0895d.I);
    private static final short U = C0895d.a(C0895d.l);
    private static final short V = C0895d.a(C0895d.p);
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 4;
    public static final int j = 8;
    public static final int k = 16;
    public static final int l = 32;
    protected static final int m = 1165519206;
    protected static final short n = (short) 0;
    protected static final short o = (short) 18761;
    protected static final short p = (short) 19789;
    protected static final short q = (short) 42;
    protected static final int r = 12;
    protected static final int s = 2;
    protected static final int t = 8;
    private static final boolean u = false;
    private static final String v = "ExifParser";
    private static final Charset w = Charset.forName("US-ASCII");
    private int A = a;
    private int B;
    private S C;
    private Q D;
    private int E;
    private S F;
    private S G;
    private boolean H;
    private boolean I = u;
    private int J;
    private int K = a;
    private byte[] L;
    private int M;
    private int N;
    private final C0895d O;
    private final TreeMap<Integer, Object> W = new TreeMap();
    private final C0893b x;
    private final int y;
    private int z = a;

    private N(InputStream inputStream, int i, C0895d c0895d) {
        if (inputStream == null) {
            throw new IOException("Null argument inputStream to ExifParser");
        }
        this.O = c0895d;
        this.I = a(inputStream);
        this.x = new C0893b(inputStream);
        this.y = i;
        if (this.I) {
            u();
            long f = this.x.f();
            if (f > 2147483647L) {
                throw new J("Invalid offset " + f);
            }
            this.M = (int) f;
            this.B = a;
            if (b((int) a) || s()) {
                a((int) a, f);
                if (f != 8) {
                    this.L = new byte[(((int) f) - 8)];
                    a(this.L);
                }
            }
        }
    }

    protected static N a(InputStream inputStream, int i, C0895d c0895d) {
        return new N(inputStream, i, c0895d);
    }

    protected static N a(InputStream inputStream, C0895d c0895d) {
        return new N(inputStream, 63, c0895d);
    }

    private void a(int i, long j) {
        this.W.put(Integer.valueOf((int) j), new P(i, b(i)));
    }

    private void a(long j) {
        this.W.put(Integer.valueOf((int) j), new Q(d));
    }

    private boolean a(int i, int i2) {
        int i3 = this.O.l().get(i2);
        return i3 == 0 ? u : C0895d.n(i3, i);
    }

    private boolean a(InputStream inputStream) {
        C0893b c0893b = new C0893b(inputStream);
        if (c0893b.c() != (short) -40) {
            throw new J("Invalid JPEG format");
        }
        short c = c0893b.c();
        while (c != (short) -39 && !V.a(c)) {
            int d = c0893b.d();
            if (c == (short) -31 && d >= t) {
                int e = c0893b.e();
                short c2 = c0893b.c();
                d -= 6;
                if (e == m && c2 == (short) 0) {
                    this.N = c0893b.a();
                    this.J = d;
                    this.K = this.N + this.J;
                    return true;
                }
            }
            if (d < s || ((long) (d - 2)) != c0893b.skip((long) (d - 2))) {
                Log.w(v, "Invalid JPEG format.");
                return u;
            }
            c = c0893b.c();
        }
        return u;
    }

    private void b(int i, long j) {
        this.W.put(Integer.valueOf((int) j), new Q(i, i));
    }

    private boolean b(int i) {
        switch (i) {
            case a /*0*/:
                return (this.y & g) == 0 ? u : true;
            case g /*1*/:
                return (this.y & s) == 0 ? u : true;
            case s /*2*/:
                return (this.y & i) == 0 ? u : true;
            case d /*3*/:
                return (this.y & k) == 0 ? u : true;
            case i /*4*/:
                return (this.y & t) == 0 ? u : true;
            default:
                return u;
        }
    }

    private void c(int i) {
        this.x.b((long) i);
        while (!this.W.isEmpty() && ((Integer) this.W.firstKey()).intValue() < i) {
            this.W.pollFirstEntry();
        }
    }

    private void c(S s) {
        int i = a;
        if (s.e() != 0) {
            short b = s.b();
            int a = s.a();
            if (b == P && a(a, C0895d.F)) {
                if (b((int) s) || b((int) d)) {
                    a((int) s, s.f(a));
                }
            } else if (b == Q && a(a, C0895d.G)) {
                if (b((int) i)) {
                    a((int) i, s.f(a));
                }
            } else if (b == R && a(a, C0895d.ap)) {
                if (b((int) d)) {
                    a((int) d, s.f(a));
                }
            } else if (b == S && a(a, C0895d.H)) {
                if (r()) {
                    a(s.f(a));
                }
            } else if (b == T && a(a, C0895d.I)) {
                if (r()) {
                    this.G = s;
                }
            } else if (b == U && a(a, C0895d.l)) {
                if (!r()) {
                    return;
                }
                if (s.f()) {
                    while (i < s.e()) {
                        if (s.c() == (short) 3) {
                            b(i, s.f(i));
                        } else {
                            b(i, s.f(i));
                        }
                        i += g;
                    }
                    return;
                }
                this.W.put(Integer.valueOf(s.p()), new O(s, u));
            } else if (b == V && a(a, C0895d.p) && r() && s.f()) {
                this.F = s;
            }
        }
    }

    private boolean r() {
        return (this.y & l) != 0 ? true : u;
    }

    private boolean s() {
        switch (this.B) {
            case a /*0*/:
                return (b((int) s) || b((int) i) || b((int) d) || b((int) g)) ? true : u;
            case g /*1*/:
                return r();
            case s /*2*/:
                return b((int) d);
            default:
                return u;
        }
    }

    private S t() {
        boolean z = true;
        short c = this.x.c();
        short c2 = this.x.c();
        long f = this.x.f();
        if (f > 2147483647L) {
            throw new J("Number of component is larger then Integer.MAX_VALUE");
        } else if (S.a(c2)) {
            int i = (int) f;
            int i2 = this.B;
            if (((int) f) == 0) {
                z = u;
            }
            S s = new S(c, c2, i, i2, z);
            int d = s.d();
            if (d > i) {
                long f2 = this.x.f();
                if (f2 > 2147483647L) {
                    throw new J("offset is larger then Integer.MAX_VALUE");
                } else if (f2 >= ((long) this.M) || c2 != (short) 7) {
                    s.h((int) f2);
                    return s;
                } else {
                    byte[] bArr = new byte[((int) f)];
                    System.arraycopy(this.L, ((int) f2) - 8, bArr, a, (int) f);
                    s.a(bArr);
                    return s;
                }
            }
            boolean q = s.q();
            s.a((boolean) u);
            b(s);
            s.a(q);
            this.x.skip((long) (4 - d));
            s.h(this.x.a() - 4);
            return s;
        } else {
            String str = v;
            Object[] objArr = new Object[s];
            objArr[a] = Short.valueOf(c);
            objArr[g] = Short.valueOf(c2);
            Log.w(str, String.format("Tag %04x: Invalid data type %d", objArr));
            this.x.skip(4);
            return null;
        }
    }

    private void u() {
        short c = this.x.c();
        if (o == c) {
            this.x.a(ByteOrder.LITTLE_ENDIAN);
        } else if (p == c) {
            this.x.a(ByteOrder.BIG_ENDIAN);
        } else {
            throw new J("Invalid TIFF header");
        }
        if (this.x.c() != q) {
            throw new J("Invalid TIFF header");
        }
    }

    protected int a() {
        if (!this.I) {
            return f;
        }
        int a = this.x.a();
        int i = (this.z + s) + (this.A * r);
        if (a < i) {
            this.C = t();
            if (this.C == null) {
                return a();
            }
            if (!this.H) {
                return g;
            }
            c(this.C);
            return g;
        }
        if (a == i) {
            if (this.B == 0) {
                long m = m();
                if ((b((int) g) || r()) && m != 0) {
                    a((int) g, m);
                }
            } else {
                int intValue = this.W.size() > 0 ? ((Integer) this.W.firstEntry().getKey()).intValue() - this.x.a() : i;
                if (intValue < i) {
                    Log.w(v, "Invalid size of link to next IFD: " + intValue);
                } else {
                    long m2 = m();
                    if (m2 != 0) {
                        Log.w(v, "Invalid link to next IFD: " + m2);
                    }
                }
            }
        }
        while (this.W.size() != 0) {
            Entry pollFirstEntry = this.W.pollFirstEntry();
            Object value = pollFirstEntry.getValue();
            try {
                c(((Integer) pollFirstEntry.getKey()).intValue());
                if (value instanceof P) {
                    this.B = ((P) value).a;
                    this.A = this.x.d();
                    this.z = ((Integer) pollFirstEntry.getKey()).intValue();
                    if (((this.A * r) + this.z) + s > this.J) {
                        Log.w(v, "Invalid size of IFD " + this.B);
                        return f;
                    }
                    this.H = s();
                    if (((P) value).b) {
                        return a;
                    }
                    b();
                } else if (value instanceof Q) {
                    this.D = (Q) value;
                    return this.D.b;
                } else {
                    O o = (O) value;
                    this.C = o.a;
                    if (this.C.c() != (short) 7) {
                        b(this.C);
                        c(this.C);
                    }
                    if (o.b) {
                        return s;
                    }
                }
            } catch (IOException e) {
                Log.w(v, "Failed to skip to data at: " + pollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be broken.");
            }
        }
        return f;
    }

    protected int a(byte[] bArr) {
        return this.x.read(bArr);
    }

    protected int a(byte[] bArr, int i, int i2) {
        return this.x.read(bArr, i, i2);
    }

    protected String a(int i) {
        return a(i, w);
    }

    protected String a(int i, Charset charset) {
        return i > 0 ? this.x.a(i, charset) : a.f;
    }

    protected void a(S s) {
        if (s.p() >= this.x.a()) {
            this.W.put(Integer.valueOf(s.p()), new O(s, true));
        }
    }

    protected void b() {
        int i = (this.A * r) + (this.z + s);
        int a = this.x.a();
        if (a <= i) {
            if (this.H) {
                while (a < i) {
                    this.C = t();
                    a += r;
                    if (this.C != null) {
                        c(this.C);
                    }
                }
            } else {
                c(i);
            }
            long m = m();
            if (this.B != 0) {
                return;
            }
            if ((b((int) g) || r()) && m > 0) {
                a((int) g, m);
            }
        }
    }

    protected void b(S s) {
        int i = a;
        short c = s.c();
        if (c == (short) 2 || c == (short) 7 || c == (short) 1) {
            int e = s.e();
            if (this.W.size() > 0 && ((Integer) this.W.firstEntry().getKey()).intValue() < e + this.x.a()) {
                Object value = this.W.firstEntry().getValue();
                if (value instanceof Q) {
                    Log.w(v, "Thumbnail overlaps value for tag: \n" + s.toString());
                    Log.w(v, "Invalid thumbnail offset: " + this.W.pollFirstEntry().getKey());
                } else {
                    if (value instanceof P) {
                        Log.w(v, "Ifd " + ((P) value).a + " overlaps value for tag: \n" + s.toString());
                    } else if (value instanceof O) {
                        Log.w(v, "Tag value for tag: \n" + ((O) value).a.toString() + " overlaps value for tag: \n" + s.toString());
                    }
                    int intValue = ((Integer) this.W.firstEntry().getKey()).intValue() - this.x.a();
                    Log.w(v, "Invalid size of tag: \n" + s.toString() + " setting count to: " + intValue);
                    s.c(intValue);
                }
            }
        }
        int[] iArr;
        switch (s.c()) {
            case g /*1*/:
            case kankan.wheel.widget.a.bc /*7*/:
                byte[] bArr = new byte[s.e()];
                a(bArr);
                s.a(bArr);
                return;
            case s /*2*/:
                s.a(a(s.e()));
                return;
            case d /*3*/:
                iArr = new int[s.e()];
                e = iArr.length;
                while (i < e) {
                    iArr[i] = l();
                    i += g;
                }
                s.a(iArr);
                return;
            case i /*4*/:
                long[] jArr = new long[s.e()];
                e = jArr.length;
                while (i < e) {
                    jArr[i] = m();
                    i += g;
                }
                s.a(jArr);
                return;
            case f /*5*/:
                X[] xArr = new X[s.e()];
                e = xArr.length;
                while (i < e) {
                    xArr[i] = n();
                    i += g;
                }
                s.a(xArr);
                return;
            case kankan.wheel.widget.a.bo /*9*/:
                iArr = new int[s.e()];
                e = iArr.length;
                while (i < e) {
                    iArr[i] = o();
                    i += g;
                }
                s.a(iArr);
                return;
            case kankan.wheel.widget.a.bd /*10*/:
                X[] xArr2 = new X[s.e()];
                int length = xArr2.length;
                for (intValue = a; intValue < length; intValue += g) {
                    xArr2[intValue] = p();
                }
                s.a(xArr2);
                return;
            default:
                return;
        }
    }

    protected S c() {
        return this.C;
    }

    protected int d() {
        return this.A;
    }

    protected int e() {
        return this.B;
    }

    protected int f() {
        return this.D.a;
    }

    protected int g() {
        return this.E;
    }

    protected int h() {
        return this.F == null ? a : (int) this.F.f(a);
    }

    protected int i() {
        return this.G == null ? a : (int) this.G.f(a);
    }

    protected int j() {
        return this.K;
    }

    protected int k() {
        return this.N;
    }

    protected int l() {
        return this.x.c() & android.support.v4.e.a.a.a;
    }

    protected long m() {
        return ((long) o()) & 4294967295L;
    }

    protected X n() {
        return new X(m(), m());
    }

    protected int o() {
        return this.x.e();
    }

    protected X p() {
        return new X((long) o(), (long) o());
    }

    protected ByteOrder q() {
        return this.x.b();
    }
}
