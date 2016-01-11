package b.a;

import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.xiaomi.e.a;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kankan.wheel.widget.l;

public class C0337cQ extends cY {
    private static final C0371de d = new C0371de(a.f);
    private static final cT e = new cT(a.f, (byte) 0, (short) 0);
    private static final byte[] f = new byte[16];
    private static final byte h = (byte) -126;
    private static final byte i = (byte) 1;
    private static final byte j = (byte) 31;
    private static final byte k = (byte) -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private C0354co m;
    private short n;
    private cT o;
    private Boolean p;
    private final long q;
    private byte[] r;

    static {
        f[0] = (byte) 0;
        f[2] = i;
        f[3] = (byte) 3;
        f[6] = (byte) 4;
        f[8] = (byte) 5;
        f[10] = (byte) 6;
        f[4] = (byte) 7;
        f[11] = (byte) 8;
        f[15] = (byte) 9;
        f[14] = (byte) 10;
        f[13] = C0374dh.i;
        f[12] = C0374dh.j;
    }

    public C0337cQ(C0375do c0375do) {
        this(c0375do, -1);
    }

    public C0337cQ(C0375do c0375do, long j) {
        super(c0375do);
        this.m = new C0354co(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[l];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j;
    }

    private int E() {
        int i = 0;
        int i2;
        if (this.g.h() >= l) {
            byte[] f = this.g.f();
            int g = this.g.g();
            i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = f[g + i];
                i3 |= (b & h.j) << i2;
                if ((b & C0113o.h) != C0113o.h) {
                    this.g.a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            i2 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & h.j) << i;
                if ((u & C0113o.h) != C0113o.h) {
                    return i2;
                }
                i += 7;
            }
        }
    }

    private long F() {
        long j = null;
        long j2 = 0;
        if (this.g.h() >= 10) {
            int i;
            byte[] f = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            while (true) {
                byte b = f[g + i];
                j2 |= ((long) (b & h.j)) << j3;
                if ((b & C0113o.h) != C0113o.h) {
                    break;
                }
                j3 += 7;
                i++;
            }
            this.g.a(i + 1);
        } else {
            while (true) {
                byte u = u();
                j2 |= ((long) (u & h.j)) << j;
                if ((u & C0113o.h) != C0113o.h) {
                    break;
                }
                j += 7;
            }
        }
        return j2;
    }

    private long a(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[l]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    private void a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + l] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 7] = (byte) ((int) ((j >> 56) & 255));
    }

    private void a(cT cTVar, byte b) {
        if (b == (byte) -1) {
            b = e(cTVar.b);
        }
        if (cTVar.c <= this.n || cTVar.c - this.n > 15) {
            b(b);
            a(cTVar.c);
        } else {
            d(((cTVar.c - this.n) << 4) | b);
        }
        this.n = cTVar.c;
    }

    private void a(byte[] bArr, int i, int i2) {
        b(i2);
        this.g.b(bArr, i, i2);
    }

    private void b(byte b) {
        this.r[0] = b;
        this.g.b(this.r);
    }

    private void b(int i) {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.a[i2] = (byte) ((i & h.j) | C0113o.h);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.a[i2] = (byte) i;
        this.g.b(this.a, 0, i4);
    }

    private void b(long j) {
        int i = 0;
        while ((-128 & j) != 0) {
            int i2 = i + 1;
            this.b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.b[i] = (byte) ((int) j);
        this.g.b(this.b, 0, i3);
    }

    private int c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private long c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private boolean c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    private byte d(byte b) {
        switch ((byte) (b & 15)) {
            case kankan.wheel.widget.a.i /*0*/:
                return (byte) 0;
            case l.a /*1*/:
            case kankan.wheel.widget.a.k /*2*/:
                return (byte) 2;
            case kankan.wheel.widget.a.l /*3*/:
                return (byte) 3;
            case kankan.wheel.widget.a.aQ /*4*/:
                return (byte) 6;
            case l /*5*/:
                return (byte) 8;
            case kankan.wheel.widget.a.bt /*6*/:
                return (byte) 10;
            case kankan.wheel.widget.a.bc /*7*/:
                return (byte) 4;
            case kankan.wheel.widget.a.ba /*8*/:
                return C0374dh.i;
            case kankan.wheel.widget.a.bo /*9*/:
                return C0374dh.m;
            case kankan.wheel.widget.a.bd /*10*/:
                return C0374dh.l;
            case kankan.wheel.widget.a.aW /*11*/:
                return C0374dh.k;
            case kankan.wheel.widget.a.be /*12*/:
                return C0374dh.j;
            default:
                throw new C0340cZ("don't know what type: " + ((byte) (b & 15)));
        }
    }

    private long d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private void d(int i) {
        b((byte) i);
    }

    private byte e(byte b) {
        return f[b];
    }

    private byte[] e(int i) {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.g.d(bArr, 0, i);
        return bArr;
    }

    private void f(int i) {
        if (i < 0) {
            throw new C0340cZ("Negative length: " + i);
        } else if (this.q != -1 && ((long) i) > this.q) {
            throw new C0340cZ("Length exceeded max allowed: " + i);
        }
    }

    private int g(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public ByteBuffer A() {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    public void a() {
    }

    public void a(byte b) {
        b(b);
    }

    protected void a(byte b, int i) {
        if (i <= 14) {
            d((i << 4) | e(b));
            return;
        }
        d(e(b) | RunningReminderInfo.b);
        b(i);
    }

    public void a(double d) {
        byte[] bArr = new byte[8];
        a(Double.doubleToLongBits(d), bArr, 0);
        this.g.b(bArr);
    }

    public void a(int i) {
        b(c(i));
    }

    public void a(long j) {
        b(c(j));
    }

    public void a(cT cTVar) {
        if (cTVar.b == (byte) 2) {
            this.o = cTVar;
        } else {
            a(cTVar, (byte) -1);
        }
    }

    public void a(cU cUVar) {
        a(cUVar.a, cUVar.b);
    }

    public void a(cV cVVar) {
        if (cVVar.c == 0) {
            d(0);
            return;
        }
        b(cVVar.c);
        d((e(cVVar.a) << 4) | e(cVVar.b));
    }

    public void a(C0338cW c0338cW) {
        b((byte) h);
        d(((c0338cW.b << l) & -32) | 1);
        b(c0338cW.c);
        a(c0338cW.a);
    }

    public void a(C0370dd c0370dd) {
        a(c0370dd.a, c0370dd.b);
    }

    public void a(C0371de c0371de) {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes(com.d.a.a.h.DEFAULT_CHARSET);
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("UTF-8 not supported!");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    public void a(short s) {
        b(c((int) s));
    }

    public void a(boolean z) {
        byte b = i;
        if (this.o != null) {
            cT cTVar = this.o;
            if (!z) {
                b = (byte) 2;
            }
            a(cTVar, b);
            this.o = null;
            return;
        }
        if (!z) {
            b = (byte) 2;
        }
        b(b);
    }

    public void b() {
        this.n = this.m.a();
    }

    public void c() {
    }

    public void d() {
        b((byte) 0);
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public C0338cW h() {
        byte u = u();
        if (u != h) {
            throw new C0340cZ("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        u = u();
        byte b = (byte) (u & 31);
        if (b != i) {
            throw new C0340cZ("Expected version 1 but got " + b);
        }
        return new C0338cW(z(), (byte) ((u >> l) & 3), E());
    }

    public void i() {
    }

    public C0371de j() {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    public void k() {
        this.n = this.m.a();
    }

    public cT l() {
        byte u = u();
        if (u == (byte) 0) {
            return e;
        }
        short s = (short) ((u & RunningReminderInfo.b) >> 4);
        cT cTVar = new cT(a.f, d((byte) (u & 15)), s == (short) 0 ? v() : (short) (s + this.n));
        if (c(u)) {
            this.p = ((byte) (u & 15)) == i ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = cTVar.c;
        return cTVar;
    }

    public void m() {
    }

    public cV n() {
        int E = E();
        int u = E == 0 ? 0 : u();
        return new cV(d((byte) (u >> 4)), d((byte) (u & 15)), E);
    }

    public void o() {
    }

    public cU p() {
        byte u = u();
        int i = (u >> 4) & 15;
        if (i == 15) {
            i = E();
        }
        return new cU(d(u), i);
    }

    public void q() {
    }

    public C0370dd r() {
        return new C0370dd(p());
    }

    public void s() {
    }

    public boolean t() {
        if (this.p == null) {
            return u() == i;
        } else {
            boolean booleanValue = this.p.booleanValue();
            this.p = null;
            return booleanValue;
        }
    }

    public byte u() {
        if (this.g.h() > 0) {
            byte b = this.g.f()[this.g.g()];
            this.g.a(1);
            return b;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    public short v() {
        return (short) g(E());
    }

    public int w() {
        return g(E());
    }

    public long x() {
        return d(F());
    }

    public double y() {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    public String z() {
        int E = E();
        f(E);
        if (E == 0) {
            return a.f;
        }
        try {
            if (this.g.h() < E) {
                return new String(e(E), com.d.a.a.h.DEFAULT_CHARSET);
            }
            String str = new String(this.g.f(), this.g.g(), E, com.d.a.a.h.DEFAULT_CHARSET);
            this.g.a(E);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("UTF-8 not supported!");
        }
    }
}
