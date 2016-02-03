package com.xiaomi.hm.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.aj;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0113o;
import android.util.Log;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.channel.relationservice.data.b;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kankan.wheel.widget.a;

public class d extends Thread {
    private static final int O = 4096;
    private static final int U = 15;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = -1;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private Bitmap F;
    private Bitmap G;
    private byte[] H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private int M;
    private int N;
    private short[] P;
    private byte[] Q;
    private byte[] R;
    private byte[] S;
    private int T;
    private Queue<e> V;
    private final ReentrantLock W;
    private final Condition X;
    private final Condition Y;
    private int Z;
    private boolean aa;
    private ArrayList<e> ab;
    private int ac;
    private boolean ad;
    private a ae;
    private byte[] af;
    private boolean ag;
    private int ah;
    private Resources ai;
    private int aj;
    private String ak;
    private int[] al;
    private int[] am;
    public boolean e;
    public int f;
    public int g;
    private InputStream h;
    private InputStream i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    public d(a aVar) {
        this.e = false;
        this.m = b;
        this.H = new byte[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        this.I = a;
        this.J = a;
        this.K = a;
        this.L = false;
        this.M = a;
        this.V = new ArrayBlockingQueue(U);
        this.W = new ReentrantLock();
        this.X = this.W.newCondition();
        this.Y = this.W.newCondition();
        this.Z = a;
        this.aa = false;
        this.ab = new ArrayList(this.T);
        this.ac = a;
        this.ad = false;
        this.ae = null;
        this.af = null;
        this.ag = false;
        this.ah = a;
        this.ai = null;
        this.aj = a;
        this.ak = null;
        this.al = null;
        this.am = new int[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        this.ae = aVar;
    }

    public d(a aVar, boolean z) {
        this.e = false;
        this.m = b;
        this.H = new byte[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        this.I = a;
        this.J = a;
        this.K = a;
        this.L = false;
        this.M = a;
        this.V = new ArrayBlockingQueue(U);
        this.W = new ReentrantLock();
        this.X = this.W.newCondition();
        this.Y = this.W.newCondition();
        this.Z = a;
        this.aa = false;
        this.ab = new ArrayList(this.T);
        this.ac = a;
        this.ad = false;
        this.ae = null;
        this.af = null;
        this.ag = false;
        this.ah = a;
        this.ai = null;
        this.aj = a;
        this.ak = null;
        this.al = null;
        this.am = new int[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        this.ae = aVar;
        this.ag = z;
    }

    private void A() {
        do {
            u();
            if (this.H[a] == (byte) 1) {
                this.m = (this.H[b] & HeartRateInfo.HR_EMPTY_VALUE) | ((this.H[c] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
            }
            if (this.I <= 0) {
                return;
            }
        } while (!r());
    }

    private int B() {
        return t() | (t() << 8);
    }

    private void C() {
        this.K = this.J;
        this.B = this.x;
        this.C = this.y;
        this.D = this.z;
        this.E = this.A;
        this.G = this.F;
        this.s = this.r;
        this.J = a;
        this.L = false;
        this.M = a;
        this.o = null;
    }

    private void D() {
        do {
            u();
            if (this.I <= 0) {
                return;
            }
        } while (!r());
    }

    private int[] a(int i) {
        int read;
        int i2 = a;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            read = this.h.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            read = a;
        }
        if (read < i3) {
            this.j = b;
        } else {
            read = a;
            while (i2 < i) {
                i3 = read + b;
                int i4 = bArr[read] & HeartRateInfo.HR_EMPTY_VALUE;
                int i5 = i3 + b;
                int i6 = bArr[i3] & HeartRateInfo.HR_EMPTY_VALUE;
                read = i5 + b;
                i3 = i2 + b;
                this.am[i2] = (((i4 << 16) | C0151az.s) | (i6 << 8)) | (bArr[i5] & HeartRateInfo.HR_EMPTY_VALUE);
                i2 = i3;
            }
        }
        return this.am;
    }

    private void j() {
        this.h = new ByteArrayInputStream(this.af);
    }

    private void k() {
        this.h = this.ai.openRawResource(this.aj);
    }

    private void l() {
        try {
            this.h = new FileInputStream(this.ak);
        } catch (Exception e) {
            Log.e("open failed", e.toString());
        }
    }

    private void m() {
        if (this.h != null) {
            try {
                this.h.close();
            } catch (Exception e) {
            }
            this.h = null;
        }
        this.af = null;
        this.j = a;
        if (this.ab != null) {
            this.ab.clear();
            this.ab = null;
        }
        if (this.V != null) {
            this.V.clear();
            this.V = null;
        }
    }

    private void n() {
        try {
            int i;
            int i2;
            int i3;
            int i4;
            if (this.al == null) {
                this.al = new int[(this.f * this.g)];
            }
            if (this.K > 0) {
                if (this.K == 3) {
                    if (this.T - 2 <= 0) {
                        this.G = null;
                    }
                    this.G = null;
                }
                if (this.G != null) {
                    this.G.getPixels(this.al, a, this.f, a, a, this.f, this.g);
                    if (this.K == c) {
                        i = !this.L ? this.s : a;
                        for (i2 = a; i2 < this.E; i2 += b) {
                            i3 = ((this.C + i2) * this.f) + this.B;
                            i4 = this.D + i3;
                            while (i3 < i4) {
                                this.al[i3] = i;
                                i3 += b;
                            }
                        }
                    }
                }
            }
            i3 = 8;
            int i5 = a;
            i = a;
            i2 = b;
            while (i5 < this.A) {
                int i6;
                int i7;
                int i8;
                if (this.v) {
                    if (i >= this.A) {
                        i2 += b;
                        switch (i2) {
                            case c /*2*/:
                                i = 4;
                                break;
                            case a.l /*3*/:
                                i = c;
                                i3 = 4;
                                break;
                            case a.aQ /*4*/:
                                i = b;
                                i3 = c;
                                break;
                        }
                    }
                    i6 = i + i3;
                    i7 = i3;
                    i8 = i2;
                } else {
                    i6 = i;
                    i7 = i3;
                    i8 = i2;
                    i = i5;
                }
                i += this.y;
                if (i < this.g) {
                    i2 = i * this.f;
                    i3 = i2 + this.x;
                    i = this.z + i3;
                    i4 = this.f + i2 < i ? this.f + i2 : i;
                    i = this.z * i5;
                    i2 = i3;
                    while (i2 < i4) {
                        i3 = i + b;
                        i = this.p[this.S[i] & HeartRateInfo.HR_EMPTY_VALUE];
                        if (i != 0) {
                            this.al[i2] = i;
                        }
                        i2 += b;
                        i = i3;
                    }
                }
                i5 += b;
                i = i6;
                i3 = i7;
                i2 = i8;
            }
            this.F = Bitmap.createBitmap(this.al, this.f, this.g, Config.RGB_565);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (StackOverflowError e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            Log.e("GifView decode setpixel", e3.toString());
        }
    }

    private int o() {
        s();
        if (this.h != null) {
            x();
            if (!r()) {
                v();
                if (!this.aa && this.T < 0) {
                    this.j = b;
                    if (this.ae != null) {
                        this.ae.a(4);
                    }
                }
            }
            try {
                if (this.h != null) {
                    this.h.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.h = null;
            p();
        } else {
            this.j = c;
            if (this.ae != null) {
                this.ae.a(4);
            }
        }
        return this.j;
    }

    private void p() {
        if (this.ag && !this.ad) {
            if (this.T <= U) {
                try {
                    this.W.lockInterruptibly();
                    this.ad = true;
                    this.j = d;
                    if (this.ae != null) {
                        this.ae.a(c);
                    }
                    this.X.signal();
                } catch (Exception e) {
                } finally {
                    this.W.unlock();
                }
            } else if (this.ab != null) {
                this.ab.clear();
            }
            switch (this.ah) {
                case b /*1*/:
                    k();
                    break;
                case c /*2*/:
                    l();
                    break;
                case a.l /*3*/:
                    j();
                    break;
            }
            this.aa = true;
            if (!this.e) {
                o();
            }
        }
    }

    private void q() {
        int i;
        int i2 = this.z * this.A;
        if (this.S == null || this.S.length < i2) {
            this.S = new byte[i2];
        }
        if (this.P == null) {
            this.P = new short[O];
        }
        if (this.Q == null) {
            this.Q = new byte[O];
        }
        if (this.R == null) {
            this.R = new byte[aj.I];
        }
        int t = t();
        int i3 = b << t;
        int i4 = i3 + b;
        int i5 = i3 + c;
        int i6 = t + b;
        int i7 = (b << i6) + d;
        for (i = a; i < i3; i += b) {
            this.P[i] = (short) 0;
            this.Q[i] = (byte) i;
        }
        int i8 = a;
        int i9 = a;
        int i10 = a;
        int i11 = a;
        int i12 = a;
        int i13 = a;
        int i14 = a;
        int i15 = d;
        i = a;
        while (i12 < i2) {
            int i16;
            int i17;
            if (i9 == 0) {
                if (i14 >= i6) {
                    i16 = i11 & i7;
                    i11 >>= i6;
                    i14 -= i6;
                    if (i16 <= i5 && i16 != i4) {
                        if (i16 != i3) {
                            if (i15 != d) {
                                int i18;
                                if (i16 == i5) {
                                    i18 = i9 + b;
                                    this.R[i9] = (byte) i10;
                                    i10 = i15;
                                } else {
                                    i18 = i9;
                                    i10 = i16;
                                }
                                while (i10 > i3) {
                                    i9 = i18 + b;
                                    this.R[i18] = this.Q[i10];
                                    i10 = this.P[i10];
                                    i18 = i9;
                                }
                                i10 = this.Q[i10] & HeartRateInfo.HR_EMPTY_VALUE;
                                if (i5 >= O) {
                                    break;
                                }
                                i9 = i18 + b;
                                this.R[i18] = (byte) i10;
                                this.P[i5] = (short) i15;
                                this.Q[i5] = (byte) i10;
                                i15 = i5 + b;
                                if ((i15 & i7) == 0 && i15 < O) {
                                    i6 += b;
                                    i7 += i15;
                                }
                                i17 = i9;
                                i9 = i11;
                                i11 = i16;
                                i16 = i7;
                                i7 = i10;
                                i10 = i14;
                                i14 = i6;
                                i6 = i17;
                            } else {
                                i10 = i9 + b;
                                this.R[i9] = this.Q[i16];
                                i9 = i10;
                                i15 = i16;
                                i10 = i16;
                            }
                        } else {
                            i6 = t + b;
                            i7 = (b << i6) + d;
                            i5 = i3 + c;
                            i15 = d;
                        }
                    } else {
                        break;
                    }
                }
                if (i13 == 0) {
                    i13 = u();
                    if (i13 <= 0) {
                        break;
                    }
                    i = a;
                }
                i11 += (this.H[i] & HeartRateInfo.HR_EMPTY_VALUE) << i14;
                i14 += 8;
                i += b;
                i13 += d;
            } else {
                i16 = i7;
                i7 = i10;
                i10 = i14;
                i14 = i6;
                i6 = i9;
                i9 = i11;
                i11 = i15;
                i15 = i5;
            }
            i5 = i6 + d;
            i6 = i8 + b;
            this.S[i8] = this.R[i5];
            i12 += b;
            i8 = i6;
            i6 = i14;
            i14 = i10;
            i10 = i7;
            i7 = i16;
            i17 = i11;
            i11 = i9;
            i9 = i5;
            i5 = i15;
            i15 = i17;
        }
        for (i = i8; i < i2; i += b) {
            this.S[i] = (byte) 0;
        }
    }

    private boolean r() {
        return this.j != 0;
    }

    private void s() {
        this.j = a;
        if (!this.aa) {
            this.T = a;
        }
        this.n = null;
        this.o = null;
        this.Z = a;
    }

    private int t() {
        int i = a;
        try {
            i = this.h.read();
        } catch (Exception e) {
            this.j = b;
        }
        return i;
    }

    private int u() {
        this.I = t();
        int i = a;
        if (this.I > 0) {
            while (i < this.I) {
                try {
                    int read = this.h.read(this.H, i, this.I - i);
                    if (read == d) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.I) {
                this.j = b;
            }
        }
        return i;
    }

    private void v() {
        int i = a;
        while (i == 0 && !r() && !this.e) {
            switch (t()) {
                case a /*0*/:
                    break;
                case b.H /*33*/:
                    switch (t()) {
                        case 249:
                            w();
                            break;
                        case HeartRateInfo.HR_EMPTY_VALUE /*255*/:
                            u();
                            String str = com.xiaomi.e.a.f;
                            for (int i2 = a; i2 < 11; i2 += b) {
                                str = new StringBuilder(String.valueOf(str)).append((char) this.H[i2]).toString();
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                D();
                                break;
                            } else {
                                A();
                                break;
                            }
                        default:
                            D();
                            break;
                    }
                case 44:
                    y();
                    break;
                case 59:
                    i = b;
                    break;
                default:
                    this.j = b;
                    break;
            }
        }
    }

    private void w() {
        boolean z = true;
        t();
        int t = t();
        this.J = (t & 28) >> c;
        if (this.J == 0) {
            this.J = b;
        }
        if ((t & b) == 0) {
            z = false;
        }
        this.L = z;
        this.M = B() * 10;
        if (this.M == 0) {
            this.M = 100;
        }
        this.N = t();
        t();
    }

    private void x() {
        String str = com.xiaomi.e.a.f;
        for (int i = a; i < 6; i += b) {
            str = new StringBuilder(String.valueOf(str)).append((char) t()).toString();
        }
        if (str.startsWith("GIF")) {
            z();
            if (this.k && !r()) {
                this.n = a(this.l);
                this.r = this.n[this.q];
                return;
            }
            return;
        }
        this.j = b;
    }

    private void y() {
        int i = a;
        this.x = B();
        this.y = B();
        this.z = B();
        this.A = B();
        int t = t();
        this.u = (t & C0113o.h) != 0;
        this.v = (t & 64) != 0;
        this.w = c << (t & 7);
        if (this.u) {
            this.o = a(this.w);
            this.p = this.o;
        } else {
            this.p = this.n;
            if (this.q == this.N) {
                this.r = a;
            }
        }
        if (this.L && this.p != null && this.p.length > 0 && this.p.length > this.N) {
            int i2 = this.p[this.N];
            this.p[this.N] = a;
            i = i2;
        }
        if (this.p == null) {
            this.j = b;
        }
        if (!r()) {
            q();
            D();
            if (!r()) {
                if (!this.aa) {
                    this.T += b;
                }
                n();
                try {
                    this.W.lockInterruptibly();
                    while (this.V != null && this.V.size() >= U) {
                        try {
                            this.Y.await();
                        } catch (InterruptedException e) {
                            this.Y.signal();
                            if (this.L) {
                                this.p[this.N] = i;
                            }
                            C();
                        } finally {
                            this.W.unlock();
                        }
                    }
                    if (this.V != null) {
                        e eVar = new e(this.F, this.M);
                        this.V.add(eVar);
                        if (!this.aa) {
                            this.ab.add(eVar);
                        }
                        this.X.signal();
                        if (!this.aa && this.Z >= 0) {
                            this.Z += b;
                            if (this.Z >= U) {
                                this.ae.a(3);
                                this.Z = d;
                            } else if (this.Z == b) {
                                this.ae.a(b);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.L) {
                    this.p[this.N] = i;
                }
                C();
            }
        }
    }

    private void z() {
        this.f = B();
        this.g = B();
        int t = t();
        this.k = (t & C0113o.h) != 0;
        this.l = c << (t & 7);
        this.q = t();
        this.t = t();
    }

    public void a() {
        this.ag = true;
    }

    public void a(Resources resources, int i) {
        this.ai = resources;
        this.aj = i;
        k();
        this.ah = b;
    }

    public void a(String str) {
        this.ak = str;
        this.ah = c;
        l();
    }

    public void a(byte[] bArr) {
        this.af = bArr;
        j();
        this.ah = 3;
    }

    public InputStream b() {
        return this.i;
    }

    public int c() {
        return this.j;
    }

    public int d() {
        return (this.aa || this.j == d) ? this.T : d;
    }

    public void destroy() {
        this.e = true;
        m();
        this.ae = null;
    }

    public Bitmap e() {
        return g();
    }

    public int f() {
        return this.m;
    }

    public Bitmap g() {
        e h = h();
        return h == null ? null : h.a;
    }

    public com.xiaomi.hm.view.e h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r1 = 0;
        r2 = 0;
        r0 = r4.ad;
        if (r0 == 0) goto L_0x002c;
    L_0x0006:
        r0 = r4.V;
        r0 = r0.size();
        if (r0 != 0) goto L_0x002c;
    L_0x000e:
        r0 = r4.ac;
        r1 = r4.T;
        if (r0 < r1) goto L_0x001b;
    L_0x0014:
        r4.ac = r2;
        r0 = r4.ae;
        r0.a();
    L_0x001b:
        r0 = r4.ab;
        r1 = r4.ac;
        r0 = r0.get(r1);
        r0 = (com.xiaomi.hm.view.e) r0;
        r1 = r4.ac;
        r1 = r1 + 1;
        r4.ac = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        r0 = r4.W;	 Catch:{ Exception -> 0x007b, all -> 0x0083 }
        r0.lockInterruptibly();	 Catch:{ Exception -> 0x007b, all -> 0x0083 }
    L_0x0031:
        r0 = r4.ad;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        if (r0 != 0) goto L_0x003d;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
    L_0x0035:
        r0 = r4.V;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r0 = r0.size();	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
    L_0x003d:
        r0 = r4.V;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r0 = r0.poll();	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r0 = (com.xiaomi.hm.view.e) r0;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2 = r4.Y;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2.signal();	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2 = r4.ac;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r4.ac = r2;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2 = r4.aa;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        if (r2 == 0) goto L_0x0062;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
    L_0x0054:
        r2 = r4.ac;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r3 = r4.T;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        if (r2 < r3) goto L_0x0062;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
    L_0x005a:
        r2 = r4.ae;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2.a();	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r2 = 0;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r4.ac = r2;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
    L_0x0062:
        r1 = r4.W;
        r1.unlock();
        goto L_0x002b;
    L_0x0068:
        r0 = r4.X;	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        r0.await();	 Catch:{ Exception -> 0x006e, all -> 0x0083 }
        goto L_0x0031;
    L_0x006e:
        r0 = move-exception;
        r0 = r4.X;	 Catch:{ Exception -> 0x007b, all -> 0x0083 }
        r0.signal();	 Catch:{ Exception -> 0x007b, all -> 0x0083 }
        r0 = r4.W;
        r0.unlock();
        r0 = r1;
        goto L_0x002b;
    L_0x007b:
        r0 = move-exception;
        r0 = r4.W;
        r0.unlock();
        r0 = r1;
        goto L_0x002b;
    L_0x0083:
        r0 = move-exception;
        r1 = r4.W;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.hm.view.d.h():com.xiaomi.hm.view.e");
    }

    public e i() {
        return h();
    }

    public void run() {
        try {
            o();
        } catch (Exception e) {
            Log.e("GifView decode run", e.toString());
            e.printStackTrace();
        }
    }
}
