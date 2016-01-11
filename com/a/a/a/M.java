package com.a.a.a;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import kankan.wheel.widget.a;

class M extends FilterOutputStream {
    private static final String a = "ExifOutputStream";
    private static final boolean b = false;
    private static final int c = 65536;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 1165519206;
    private static final short h = (short) 42;
    private static final short i = (short) 19789;
    private static final short j = (short) 18761;
    private static final short k = (short) 12;
    private static final short l = (short) 8;
    private static final int m = 65535;
    private C0894c n;
    private int o = d;
    private int p;
    private int q;
    private final byte[] r = new byte[e];
    private final ByteBuffer s = ByteBuffer.allocate(4);
    private final C0895d t;

    protected M(OutputStream outputStream, C0895d c0895d) {
        super(new BufferedOutputStream(outputStream, c));
        this.t = c0895d;
    }

    private int a(int i, byte[] bArr, int i2, int i3) {
        int position = i - this.s.position();
        if (i3 > position) {
            i3 = position;
        }
        this.s.put(bArr, i2, i3);
        return i3;
    }

    private int a(T t, int i) {
        int d = i + (((t.d() * 12) + f) + 4);
        S[] b = t.b();
        int length = b.length;
        int i2 = d;
        for (d = d; d < length; d += e) {
            S s = b[d];
            if (s.d() > 4) {
                s.h(i2);
                i2 += s.d();
            }
        }
        return i2;
    }

    static void a(S s, W w) {
        int i = d;
        int e;
        switch (s.c()) {
            case e /*1*/:
            case a.bc /*7*/:
                byte[] bArr = new byte[s.e()];
                s.b(bArr);
                w.write(bArr);
                return;
            case f /*2*/:
                byte[] o = s.o();
                if (o.length == s.e()) {
                    o[o.length - 1] = (byte) 0;
                    w.write(o);
                    return;
                }
                w.write(o);
                w.write(d);
                return;
            case a.l /*3*/:
                e = s.e();
                while (i < e) {
                    w.a((short) ((int) s.f(i)));
                    i += e;
                }
                return;
            case a.aQ /*4*/:
            case a.bo /*9*/:
                e = s.e();
                while (i < e) {
                    w.a((int) s.f(i));
                    i += e;
                }
                return;
            case a.X /*5*/:
            case a.bd /*10*/:
                e = s.e();
                while (i < e) {
                    w.a(s.g(i));
                    i += e;
                }
                return;
            default:
                return;
        }
    }

    private void a(T t, W w) {
        int i;
        int i2 = d;
        S[] b = t.b();
        w.a((short) b.length);
        int length = b.length;
        for (int i3 = d; i3 < length; i3 += e) {
            S s = b[i3];
            w.a(s.b());
            w.a(s.c());
            w.a(s.e());
            if (s.d() > 4) {
                w.a(s.p());
            } else {
                a(s, w);
                int d = 4 - s.d();
                for (i = d; i < d; i += e) {
                    w.write(d);
                }
            }
        }
        w.a(t.e());
        i = b.length;
        while (i2 < i) {
            S s2 = b[i2];
            if (s2.d() > 4) {
                a(s2, w);
            }
            i2 += e;
        }
    }

    private void a(W w) {
        if (this.n.b()) {
            w.write(this.n.a());
        } else if (this.n.d()) {
            for (int i = d; i < this.n.c(); i += e) {
                w.write(this.n.a(i));
            }
        }
    }

    private ArrayList<S> b(C0894c c0894c) {
        ArrayList<S> arrayList = new ArrayList();
        for (S s : c0894c.i()) {
            if (s.l() == null && !C0895d.b(s.b())) {
                c0894c.b(s.b(), s.a());
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    private void b() {
        if (this.n != null) {
            ArrayList b = b(this.n);
            c();
            int d = d();
            if (d + 8 > m) {
                throw new IOException("Exif header is too large (>64Kb)");
            }
            W w = new W(this.out);
            w.a(ByteOrder.BIG_ENDIAN);
            w.a((short) -31);
            w.a((short) (d + 8));
            w.a((int) g);
            w.a((short) 0);
            if (this.n.e() == ByteOrder.BIG_ENDIAN) {
                w.a((short) i);
            } else {
                w.a((short) j);
            }
            w.a(this.n.e());
            w.a((short) h);
            w.a(8);
            b(w);
            a(w);
            Iterator it = b.iterator();
            while (it.hasNext()) {
                this.n.a((S) it.next());
            }
        }
    }

    private void b(W w) {
        a(this.n.b(d), w);
        a(this.n.b(f), w);
        T b = this.n.b(3);
        if (b != null) {
            a(b, w);
        }
        b = this.n.b(4);
        if (b != null) {
            a(b, w);
        }
        if (this.n.b(e) != null) {
            a(this.n.b(e), w);
        }
    }

    private void c() {
        T b = this.n.b(d);
        if (b == null) {
            b = new T(d);
            this.n.a(b);
        }
        S s = this.t.s(C0895d.F);
        if (s == null) {
            throw new IOException("No definition for crucial exif tag: " + C0895d.F);
        }
        S s2;
        b.a(s);
        T b2 = this.n.b(f);
        if (b2 == null) {
            b2 = new T(f);
            this.n.a(b2);
        }
        if (this.n.b(4) != null) {
            s2 = this.t.s(C0895d.G);
            if (s2 == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.G);
            }
            b.a(s2);
        }
        if (this.n.b(3) != null) {
            S s3 = this.t.s(C0895d.ap);
            if (s3 == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.ap);
            }
            b2.a(s3);
        }
        b = this.n.b(e);
        if (this.n.b()) {
            if (b == null) {
                b = new T(e);
                this.n.a(b);
            }
            s = this.t.s(C0895d.H);
            if (s == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.H);
            }
            b.a(s);
            s = this.t.s(C0895d.I);
            if (s == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.I);
            }
            s.d(this.n.a().length);
            b.a(s);
            b.c(C0895d.a(C0895d.l));
            b.c(C0895d.a(C0895d.p));
        } else if (this.n.d()) {
            if (b == null) {
                b = new T(e);
                this.n.a(b);
            }
            int c = this.n.c();
            s2 = this.t.s(C0895d.l);
            if (s2 == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.l);
            }
            S s4 = this.t.s(C0895d.p);
            if (s4 == null) {
                throw new IOException("No definition for crucial exif tag: " + C0895d.p);
            }
            long[] jArr = new long[c];
            for (c = d; c < this.n.c(); c += e) {
                jArr[c] = (long) this.n.a(c).length;
            }
            s4.a(jArr);
            b.a(s2);
            b.a(s4);
            b.c(C0895d.a(C0895d.H));
            b.c(C0895d.a(C0895d.I));
        } else if (b != null) {
            b.c(C0895d.a(C0895d.l));
            b.c(C0895d.a(C0895d.p));
            b.c(C0895d.a(C0895d.H));
            b.c(C0895d.a(C0895d.I));
        }
    }

    private int d() {
        T b = this.n.b(d);
        int a = a(b, 8);
        b.a(C0895d.a(C0895d.F)).d(a);
        T b2 = this.n.b(f);
        a = a(b2, a);
        T b3 = this.n.b(3);
        if (b3 != null) {
            b2.a(C0895d.a(C0895d.ap)).d(a);
            a = a(b3, a);
        }
        b2 = this.n.b(4);
        if (b2 != null) {
            b.a(C0895d.a(C0895d.G)).d(a);
            a = a(b2, a);
        }
        b2 = this.n.b(e);
        if (b2 != null) {
            b.a(a);
            a = a(b2, a);
        }
        if (this.n.b()) {
            b2.a(C0895d.a(C0895d.H)).d(a);
            return this.n.a().length + a;
        } else if (!this.n.d()) {
            return a;
        } else {
            long[] jArr = new long[this.n.c()];
            int i = a;
            for (a = d; a < this.n.c(); a += e) {
                jArr[a] = (long) i;
                i += this.n.a(a).length;
            }
            b2.a(C0895d.a(C0895d.l)).a(jArr);
            return i;
        }
    }

    protected C0894c a() {
        return this.n;
    }

    protected void a(C0894c c0894c) {
        this.n = c0894c;
    }

    public void write(int i) {
        this.r[d] = (byte) (i & HeartRateInfo.HR_EMPTY_VALUE);
        write(this.r);
    }

    public void write(byte[] bArr) {
        write(bArr, d, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            if ((this.p > 0 || this.q > 0 || this.o != f) && i2 > 0) {
                int i3;
                if (this.p > 0) {
                    i3 = i2 > this.p ? this.p : i2;
                    i2 -= i3;
                    this.p -= i3;
                    i += i3;
                }
                if (this.q > 0) {
                    i3 = i2 > this.q ? this.q : i2;
                    this.out.write(bArr, i, i3);
                    i2 -= i3;
                    this.q -= i3;
                    i += i3;
                }
                if (i2 != 0) {
                    switch (this.o) {
                        case d /*0*/:
                            i3 = a(f, bArr, i, i2);
                            i += i3;
                            i2 -= i3;
                            if (this.s.position() >= f) {
                                this.s.rewind();
                                if (this.s.getShort() == (short) -40) {
                                    this.out.write(this.s.array(), d, f);
                                    this.o = e;
                                    this.s.rewind();
                                    b();
                                    break;
                                }
                                throw new IOException("Not a valid jpeg image, cannot write exif");
                            }
                            return;
                        case e /*1*/:
                            i3 = a(4, bArr, i, i2);
                            i += i3;
                            i2 -= i3;
                            if (this.s.position() == f && this.s.getShort() == (short) -39) {
                                this.out.write(this.s.array(), d, f);
                                this.s.rewind();
                            }
                            if (this.s.position() >= 4) {
                                this.s.rewind();
                                short s = this.s.getShort();
                                if (s == (short) -31) {
                                    this.p = (this.s.getShort() & m) - 2;
                                    this.o = f;
                                } else if (V.a(s)) {
                                    this.out.write(this.s.array(), d, 4);
                                    this.o = f;
                                } else {
                                    this.out.write(this.s.array(), d, 4);
                                    this.q = (this.s.getShort() & m) - 2;
                                }
                                this.s.rewind();
                                break;
                            }
                            return;
                        default:
                            break;
                    }
                }
                return;
            } else if (i2 > 0) {
                this.out.write(bArr, i, i2);
                return;
            } else {
                return;
            }
        }
    }
}
