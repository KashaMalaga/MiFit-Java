package b.a;

import com.d.a.a.h;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cO extends cY {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final C0371de h = new C0371de();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    public cO(C0375do c0375do) {
        this(c0375do, false, true);
    }

    public cO(C0375do c0375do, boolean z, boolean z2) {
        super(c0375do);
        this.c = false;
        this.d = true;
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    public ByteBuffer A() {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    public void a() {
    }

    public void a(byte b) {
        this.i[0] = b;
        this.g.b(this.i, 0, 1);
    }

    public void a(double d) {
        a(Double.doubleToLongBits(d));
    }

    public void a(int i) {
        this.k[0] = (byte) ((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE);
        this.k[1] = (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        this.k[2] = (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        this.k[3] = (byte) (i & HeartRateInfo.HR_EMPTY_VALUE);
        this.g.b(this.k, 0, 4);
    }

    public void a(long j) {
        this.l[0] = (byte) ((int) ((j >> 56) & 255));
        this.l[1] = (byte) ((int) ((j >> 48) & 255));
        this.l[2] = (byte) ((int) ((j >> 40) & 255));
        this.l[3] = (byte) ((int) ((j >> 32) & 255));
        this.l[4] = (byte) ((int) ((j >> 24) & 255));
        this.l[5] = (byte) ((int) ((j >> 16) & 255));
        this.l[6] = (byte) ((int) ((j >> 8) & 255));
        this.l[7] = (byte) ((int) (255 & j));
        this.g.b(this.l, 0, 8);
    }

    public void a(cT cTVar) {
        a(cTVar.b);
        a(cTVar.c);
    }

    public void a(cU cUVar) {
        a(cUVar.a);
        a(cUVar.b);
    }

    public void a(cV cVVar) {
        a(cVVar.a);
        a(cVVar.b);
        a(cVVar.c);
    }

    public void a(C0338cW c0338cW) {
        if (this.d) {
            a(b | c0338cW.b);
            a(c0338cW.a);
            a(c0338cW.c);
            return;
        }
        a(c0338cW.a);
        a(c0338cW.b);
        a(c0338cW.c);
    }

    public void a(C0370dd c0370dd) {
        a(c0370dd.a);
        a(c0370dd.b);
    }

    public void a(C0371de c0371de) {
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes(h.DEFAULT_CHARSET);
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void a(short s) {
        this.j[0] = (byte) ((s >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        this.j[1] = (byte) (s & HeartRateInfo.HR_EMPTY_VALUE);
        this.g.b(this.j, 0, 2);
    }

    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public String b(int i) {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    public void d() {
        a((byte) 0);
    }

    protected void d(int i) {
        if (i < 0) {
            throw new C0340cZ("Negative length: " + i);
        } else if (this.f) {
            this.e -= i;
            if (this.e < 0) {
                throw new C0340cZ("Message length exceeded: " + i);
            }
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public C0338cW h() {
        int w = w();
        if (w < 0) {
            if ((a & w) == b) {
                return new C0338cW(z(), (byte) (w & HeartRateInfo.HR_EMPTY_VALUE), w());
            }
            throw new C0340cZ(4, "Bad version in readMessageBegin");
        } else if (!this.c) {
            return new C0338cW(b(w), u(), w());
        } else {
            throw new C0340cZ(4, "Missing version in readMessageBegin, old client?");
        }
    }

    public void i() {
    }

    public C0371de j() {
        return h;
    }

    public void k() {
    }

    public cT l() {
        byte u = u();
        return new cT(a.f, u, u == (byte) 0 ? (short) 0 : v());
    }

    public void m() {
    }

    public cV n() {
        return new cV(u(), u(), w());
    }

    public void o() {
    }

    public cU p() {
        return new cU(u(), w());
    }

    public void q() {
    }

    public C0370dd r() {
        return new C0370dd(u(), w());
    }

    public void s() {
    }

    public boolean t() {
        return u() == (byte) 1;
    }

    public byte u() {
        if (this.g.h() >= 1) {
            byte b = this.g.f()[this.g.g()];
            this.g.a(1);
            return b;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    public short v() {
        int i = 0;
        byte[] bArr = this.n;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[i] & HeartRateInfo.HR_EMPTY_VALUE) << 8));
    }

    public int w() {
        int i = 0;
        byte[] bArr = this.o;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i + 3] & HeartRateInfo.HR_EMPTY_VALUE) | ((((bArr[i] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE) << 8));
    }

    public long x() {
        int i = 0;
        byte[] bArr = this.p;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return ((long) (bArr[i + 7] & HeartRateInfo.HR_EMPTY_VALUE)) | (((((((((long) (bArr[i] & HeartRateInfo.HR_EMPTY_VALUE)) << 56) | (((long) (bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE)) << 48)) | (((long) (bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE)) << 40)) | (((long) (bArr[i + 3] & HeartRateInfo.HR_EMPTY_VALUE)) << 32)) | (((long) (bArr[i + 4] & HeartRateInfo.HR_EMPTY_VALUE)) << 24)) | (((long) (bArr[i + 5] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[i + 6] & HeartRateInfo.HR_EMPTY_VALUE)) << 8));
    }

    public double y() {
        return Double.longBitsToDouble(x());
    }

    public String z() {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), w, h.DEFAULT_CHARSET);
            this.g.a(w);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("JVM DOES NOT SUPPORT UTF-8");
        }
    }
}
