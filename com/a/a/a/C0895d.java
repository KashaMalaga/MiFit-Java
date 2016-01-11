package com.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.support.v4.e.a.a;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.C0113o;
import android.util.SparseIntArray;
import com.activeandroid.b;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class C0895d {
    public static final int A = C0895d.a((int) bt, (short) 529);
    public static final int B = C0895d.a((int) bt, (short) 530);
    public static final int C = C0895d.a((int) bt, (short) 531);
    public static final int D = C0895d.a((int) bt, (short) 532);
    public static final int E = C0895d.a((int) bt, (short) -32104);
    public static final int F = C0895d.a((int) bt, (short) -30871);
    public static final int G = C0895d.a((int) bt, (short) -30683);
    public static final int H = C0895d.a(1, (short) 513);
    public static final int I = C0895d.a(1, (short) 514);
    public static final int J = C0895d.a(2, (short) -32102);
    public static final int K = C0895d.a(2, (short) -32099);
    public static final int L = C0895d.a(2, (short) -30686);
    public static final int M = C0895d.a(2, (short) -30684);
    public static final int N = C0895d.a(2, (short) -30681);
    public static final int O = C0895d.a(2, (short) -30680);
    public static final int P = C0895d.a(2, (short) -28672);
    public static final int Q = C0895d.a(2, (short) -28669);
    public static final int R = C0895d.a(2, (short) -28668);
    public static final int S = C0895d.a(2, (short) -28415);
    public static final int T = C0895d.a(2, (short) -28414);
    public static final int U = C0895d.a(2, (short) -28159);
    public static final int V = C0895d.a(2, (short) -28158);
    public static final int W = C0895d.a(2, (short) -28157);
    public static final int X = C0895d.a(2, (short) -28156);
    public static final int Y = C0895d.a(2, (short) -28155);
    public static final int Z = C0895d.a(2, (short) -28154);
    public static final int a = -1;
    public static final int aA = C0895d.a(2, (short) -23806);
    public static final int aB = C0895d.a(2, (short) -23551);
    public static final int aC = C0895d.a(2, (short) -23550);
    public static final int aD = C0895d.a(2, (short) -23549);
    public static final int aE = C0895d.a(2, (short) -23548);
    public static final int aF = C0895d.a(2, (short) -23547);
    public static final int aG = C0895d.a(2, (short) -23546);
    public static final int aH = C0895d.a(2, (short) -23545);
    public static final int aI = C0895d.a(2, (short) -23544);
    public static final int aJ = C0895d.a(2, (short) -23543);
    public static final int aK = C0895d.a(2, (short) -23542);
    public static final int aL = C0895d.a(2, (short) -23541);
    public static final int aM = C0895d.a(2, (short) -23540);
    public static final int aN = C0895d.a(2, (short) -23520);
    public static final int aO = C0895d.a(4, (short) 0);
    public static final int aP = C0895d.a(4, (short) 1);
    public static final int aQ = C0895d.a(4, (short) 2);
    public static final int aR = C0895d.a(4, (short) 3);
    public static final int aS = C0895d.a(4, (short) 4);
    public static final int aT = C0895d.a(4, (short) 5);
    public static final int aU = C0895d.a(4, (short) 6);
    public static final int aV = C0895d.a(4, (short) 7);
    public static final int aW = C0895d.a(4, (short) 8);
    public static final int aX = C0895d.a(4, (short) 9);
    public static final int aY = C0895d.a(4, (short) 10);
    public static final int aZ = C0895d.a(4, (short) 11);
    public static final int aa = C0895d.a(2, (short) -28153);
    public static final int ab = C0895d.a(2, (short) -28152);
    public static final int ac = C0895d.a(2, (short) -28151);
    public static final int ad = C0895d.a(2, (short) -28150);
    public static final int ae = C0895d.a(2, (short) -28140);
    public static final int af = C0895d.a(2, (short) -28036);
    public static final int ag = C0895d.a(2, (short) -28026);
    public static final int ah = C0895d.a(2, (short) -28016);
    public static final int ai = C0895d.a(2, (short) -28015);
    public static final int aj = C0895d.a(2, (short) -28014);
    public static final int ak = C0895d.a(2, (short) -24576);
    public static final int al = C0895d.a(2, (short) -24575);
    public static final int am = C0895d.a(2, (short) -24574);
    public static final int an = C0895d.a(2, (short) -24573);
    public static final int ao = C0895d.a(2, (short) -24572);
    public static final int ap = C0895d.a(2, (short) -24571);
    public static final int aq = C0895d.a(2, (short) -24053);
    public static final int ar = C0895d.a(2, (short) -24052);
    public static final int as = C0895d.a(2, (short) -24050);
    public static final int at = C0895d.a(2, (short) -24049);
    public static final int au = C0895d.a(2, (short) -24048);
    public static final int av = C0895d.a(2, (short) -24044);
    public static final int aw = C0895d.a(2, (short) -24043);
    public static final int ax = C0895d.a(2, (short) -24041);
    public static final int ay = C0895d.a(2, (short) -23808);
    public static final int az = C0895d.a(2, (short) -23807);
    public static final int b = -1;
    private static final String bA = "yyyy:MM:dd kk:mm:ss";
    public static final int ba = C0895d.a(4, (short) 12);
    public static final int bb = C0895d.a(4, (short) 13);
    public static final int bc = C0895d.a(4, (short) 14);
    public static final int bd = C0895d.a(4, (short) 15);
    public static final int be = C0895d.a(4, (short) 16);
    public static final int bf = C0895d.a(4, (short) 17);
    public static final int bg = C0895d.a(4, (short) 18);
    public static final int bh = C0895d.a(4, (short) 19);
    public static final int bi = C0895d.a(4, (short) 20);
    public static final int bj = C0895d.a(4, (short) 21);
    public static final int bk = C0895d.a(4, (short) 22);
    public static final int bl = C0895d.a(4, (short) 23);
    public static final int bm = C0895d.a(4, (short) 24);
    public static final int bn = C0895d.a(4, (short) 25);
    public static final int bo = C0895d.a(4, (short) 26);
    public static final int bp = C0895d.a(4, (short) 27);
    public static final int bq = C0895d.a(4, (short) 28);
    public static final int br = C0895d.a(4, (short) 29);
    public static final int bs = C0895d.a(4, (short) 30);
    public static final int bt = C0895d.a(3, (short) 1);
    protected static HashSet<Short> bu = new HashSet(bw);
    public static final ByteOrder bv = ByteOrder.BIG_ENDIAN;
    private static HashSet<Short> bw = new HashSet();
    private static final String bx = "Argument is null";
    private static final String bz = "yyyy:MM:dd";
    public static final int c = 0;
    public static final int d = C0895d.a((int) bt, (short) 256);
    public static final int e = C0895d.a((int) bt, (short) 257);
    public static final int f = C0895d.a((int) bt, (short) 258);
    public static final int g = C0895d.a((int) bt, (short) 259);
    public static final int h = C0895d.a((int) bt, (short) 262);
    public static final int i = C0895d.a((int) bt, (short) 270);
    public static final int j = C0895d.a((int) bt, (short) 271);
    public static final int k = C0895d.a((int) bt, (short) 272);
    public static final int l = C0895d.a((int) bt, (short) 273);
    public static final int m = C0895d.a((int) bt, (short) 274);
    public static final int n = C0895d.a((int) bt, (short) 277);
    public static final int o = C0895d.a((int) bt, (short) 278);
    public static final int p = C0895d.a((int) bt, (short) 279);
    public static final int q = C0895d.a((int) bt, (short) 282);
    public static final int r = C0895d.a((int) bt, (short) 283);
    public static final int s = C0895d.a((int) bt, (short) 284);
    public static final int t = C0895d.a((int) bt, (short) 296);
    public static final int u = C0895d.a((int) bt, (short) 301);
    public static final int v = C0895d.a((int) bt, (short) 305);
    public static final int w = C0895d.a((int) bt, (short) 306);
    public static final int x = C0895d.a((int) bt, (short) 315);
    public static final int y = C0895d.a((int) bt, (short) 318);
    public static final int z = C0895d.a((int) bt, (short) 319);
    private final DateFormat bB = new SimpleDateFormat(bA);
    private final DateFormat bC = new SimpleDateFormat(bz);
    private final Calendar bD = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray bE = null;
    private C0894c by = new C0894c(bv);

    static {
        bw.add(Short.valueOf(C0895d.a(G)));
        bw.add(Short.valueOf(C0895d.a(F)));
        bw.add(Short.valueOf(C0895d.a(H)));
        bw.add(Short.valueOf(C0895d.a(ap)));
        bw.add(Short.valueOf(C0895d.a(l)));
        bu.add(Short.valueOf(C0895d.a((int) b)));
        bu.add(Short.valueOf(C0895d.a(I)));
        bu.add(Short.valueOf(C0895d.a(p)));
    }

    public C0895d() {
        this.bC.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static double a(X[] xArr, String str) {
        try {
            double c = (xArr[bt].c() + (xArr[1].c() / 60.0d)) + (xArr[2].c() / 3600.0d);
            return (str.equals(C0907p.b) || str.equals(C0908q.b)) ? -c : c;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int a(int i, short s) {
        return (a.a & s) | (i << 16);
    }

    protected static int a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return bt;
        }
        int[] a = T.a();
        int i = bt;
        for (int i2 = bt; i2 < 5; i2++) {
            int length = iArr.length;
            for (int i3 = bt; i3 < length; i3++) {
                if (a[i2] == iArr[i3]) {
                    i |= 1 << i2;
                    break;
                }
            }
        }
        return i;
    }

    public static short a(int i) {
        return (short) i;
    }

    protected static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    private static X[] a(double d) {
        double abs = Math.abs(d);
        abs = (abs - ((double) ((int) abs))) * 60.0d;
        int i = (int) ((abs - ((double) ((int) abs))) * 6000.0d);
        return new X[]{new X((long) r2, 1), new X((long) r3, 1), new X((long) i, 100)};
    }

    public static int b(int i) {
        return i >>> 16;
    }

    private void b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[b.a];
        int read = inputStream.read(bArr, bt, b.a);
        while (read != b) {
            outputStream.write(bArr, bt, read);
            read = inputStream.read(bArr, bt, b.a);
        }
    }

    protected static boolean b(short s) {
        return bw.contains(Short.valueOf(s));
    }

    public static int d(short s) {
        switch (s) {
            case kankan.wheel.widget.a.l /*3*/:
                return cn.com.smartdevices.bracelet.gps.c.a.i;
            case kankan.wheel.widget.a.bt /*6*/:
                return 90;
            case kankan.wheel.widget.a.ba /*8*/:
                return 270;
            default:
                return bt;
        }
    }

    private void m() {
        int[] iArr = new int[2];
        iArr[1] = 1;
        int a = C0895d.a(iArr) << 24;
        this.bE.put(j, a | C0113o.r);
        this.bE.put(d, (a | C0099a.l) | 1);
        this.bE.put(e, (a | C0099a.l) | 1);
        this.bE.put(f, (a | 196608) | 3);
        this.bE.put(g, (a | 196608) | 1);
        this.bE.put(h, (a | 196608) | 1);
        this.bE.put(m, (a | 196608) | 1);
        this.bE.put(n, (a | 196608) | 1);
        this.bE.put(s, (a | 196608) | 1);
        this.bE.put(B, (a | 196608) | 2);
        this.bE.put(C, (a | 196608) | 1);
        this.bE.put(q, (a | 327680) | 1);
        this.bE.put(r, (a | 327680) | 1);
        this.bE.put(t, (a | 196608) | 1);
        this.bE.put(l, a | C0099a.l);
        this.bE.put(o, (a | C0099a.l) | 1);
        this.bE.put(p, a | C0099a.l);
        this.bE.put(u, (a | 196608) | 768);
        this.bE.put(y, (a | 327680) | 2);
        this.bE.put(z, (a | 327680) | 6);
        this.bE.put(A, (a | 327680) | 3);
        this.bE.put(D, (a | 327680) | 6);
        this.bE.put(w, (a | C0113o.r) | 20);
        this.bE.put(i, a | C0113o.r);
        this.bE.put(j, a | C0113o.r);
        this.bE.put(k, a | C0113o.r);
        this.bE.put(v, a | C0113o.r);
        this.bE.put(x, a | C0113o.r);
        this.bE.put(E, a | C0113o.r);
        this.bE.put(F, (a | C0099a.l) | 1);
        this.bE.put(G, (a | C0099a.l) | 1);
        a = C0895d.a(new int[]{1}) << 24;
        this.bE.put(H, (a | C0099a.l) | 1);
        this.bE.put(I, (a | C0099a.l) | 1);
        a = C0895d.a(new int[]{2}) << 24;
        this.bE.put(P, (a | 458752) | 4);
        this.bE.put(ak, (a | 458752) | 4);
        this.bE.put(al, (a | 196608) | 1);
        this.bE.put(S, (a | 458752) | 4);
        this.bE.put(T, (a | 327680) | 1);
        this.bE.put(am, (a | C0099a.l) | 1);
        this.bE.put(an, (a | C0099a.l) | 1);
        this.bE.put(af, a | 458752);
        this.bE.put(ag, a | 458752);
        this.bE.put(ao, (a | C0113o.r) | 13);
        this.bE.put(Q, (a | C0113o.r) | 20);
        this.bE.put(R, (a | C0113o.r) | 20);
        this.bE.put(ah, a | C0113o.r);
        this.bE.put(ai, a | C0113o.r);
        this.bE.put(aj, a | C0113o.r);
        this.bE.put(aN, (a | C0113o.r) | 33);
        this.bE.put(J, (a | 327680) | 1);
        this.bE.put(K, (a | 327680) | 1);
        this.bE.put(L, (a | 196608) | 1);
        this.bE.put(M, a | C0113o.r);
        this.bE.put(N, a | 196608);
        this.bE.put(O, a | 458752);
        this.bE.put(U, (655360 | a) | 1);
        this.bE.put(V, (a | 327680) | 1);
        this.bE.put(W, (655360 | a) | 1);
        this.bE.put(X, (655360 | a) | 1);
        this.bE.put(Y, (a | 327680) | 1);
        this.bE.put(Z, (a | 327680) | 1);
        this.bE.put(aa, (a | 196608) | 1);
        this.bE.put(ab, (a | 196608) | 1);
        this.bE.put(ac, (a | 196608) | 1);
        this.bE.put(ad, (a | 327680) | 1);
        this.bE.put(ae, a | 196608);
        this.bE.put(aq, (a | 327680) | 1);
        this.bE.put(ar, a | 458752);
        this.bE.put(as, (a | 327680) | 1);
        this.bE.put(at, (a | 327680) | 1);
        this.bE.put(au, (a | 196608) | 1);
        this.bE.put(av, (a | 196608) | 2);
        this.bE.put(aw, (a | 327680) | 1);
        this.bE.put(ax, (a | 196608) | 1);
        this.bE.put(ay, (a | 458752) | 1);
        this.bE.put(az, (a | 458752) | 1);
        this.bE.put(aA, a | 458752);
        this.bE.put(aB, (a | 196608) | 1);
        this.bE.put(aC, (a | 196608) | 1);
        this.bE.put(aD, (a | 196608) | 1);
        this.bE.put(aE, (a | 327680) | 1);
        this.bE.put(aF, (a | 196608) | 1);
        this.bE.put(aG, (a | 196608) | 1);
        this.bE.put(aH, (a | 327680) | 1);
        this.bE.put(aI, (a | 196608) | 1);
        this.bE.put(aJ, (a | 196608) | 1);
        this.bE.put(aK, (a | 196608) | 1);
        this.bE.put(aL, a | 458752);
        this.bE.put(aM, (a | 196608) | 1);
        this.bE.put(ap, (a | C0099a.l) | 1);
        a = C0895d.a(new int[]{4}) << 24;
        this.bE.put(aO, (C0113o.q | a) | 4);
        this.bE.put(aP, (a | C0113o.r) | 2);
        this.bE.put(aR, (a | C0113o.r) | 2);
        this.bE.put(aQ, (655360 | a) | 3);
        this.bE.put(aS, (655360 | a) | 3);
        this.bE.put(aT, (C0113o.q | a) | 1);
        this.bE.put(aU, (a | 327680) | 1);
        this.bE.put(aV, (a | 327680) | 3);
        this.bE.put(aW, a | C0113o.r);
        this.bE.put(aX, (a | C0113o.r) | 2);
        this.bE.put(aY, (a | C0113o.r) | 2);
        this.bE.put(aZ, (a | 327680) | 1);
        this.bE.put(ba, (a | C0113o.r) | 2);
        this.bE.put(bb, (a | 327680) | 1);
        this.bE.put(bc, (a | C0113o.r) | 2);
        this.bE.put(bd, (a | 327680) | 1);
        this.bE.put(be, (a | C0113o.r) | 2);
        this.bE.put(bf, (a | 327680) | 1);
        this.bE.put(bg, a | C0113o.r);
        this.bE.put(bh, (a | C0113o.r) | 2);
        this.bE.put(bi, (a | 327680) | 1);
        this.bE.put(bl, (a | C0113o.r) | 2);
        this.bE.put(bm, (a | 327680) | 1);
        this.bE.put(bn, (a | C0113o.r) | 2);
        this.bE.put(bo, (a | 327680) | 1);
        this.bE.put(bp, a | 458752);
        this.bE.put(bq, a | 458752);
        this.bE.put(br, (a | C0113o.r) | 11);
        this.bE.put(bs, (a | 196608) | 11);
        this.bE.put(bt, (C0895d.a(new int[]{3}) << 24) | C0113o.r);
    }

    protected static boolean n(int i, int i2) {
        int[] a = T.a();
        int w = C0895d.w(i);
        int i3 = bt;
        while (i3 < a.length) {
            if (i2 == a[i3] && ((w >> i3) & 1) == 1) {
                return true;
            }
            i3++;
        }
        return false;
    }

    public static short v(int i) {
        int i2 = i % cn.com.smartdevices.bracelet.gps.c.a.e;
        if (i2 < 0) {
            i2 += cn.com.smartdevices.bracelet.gps.c.a.e;
        }
        return i2 < 90 ? (short) 1 : i2 < cn.com.smartdevices.bracelet.gps.c.a.i ? (short) 6 : i2 < 270 ? (short) 3 : (short) 8;
    }

    protected static int w(int i) {
        return i >>> 24;
    }

    protected static int[] x(int i) {
        int i2;
        int w = C0895d.w(i);
        int[] a = T.a();
        ArrayList arrayList = new ArrayList();
        for (i2 = bt; i2 < 5; i2++) {
            if (((w >> i2) & 1) == 1) {
                arrayList.add(Integer.valueOf(a[i2]));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        i2 = bt;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            iArr[i2] = ((Integer) it.next()).intValue();
            i2 = i3;
        }
        return iArr;
    }

    protected static short y(int i) {
        return (short) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
    }

    protected static int z(int i) {
        return a.a & i;
    }

    protected int a(short s, int i) {
        return l().get(C0895d.a(i, s));
    }

    public int a(short s, int i, short s2, short s3, int[] iArr) {
        if (bu.contains(Short.valueOf(s))) {
            return b;
        }
        if (!S.a(s2) || !S.a(i)) {
            return b;
        }
        int a = C0895d.a(i, s);
        if (a == b) {
            return b;
        }
        int i2;
        int[] c = c(s);
        SparseIntArray l = l();
        int length = iArr.length;
        Object obj = bt;
        for (i2 = bt; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i == i3) {
                obj = 1;
            }
            if (!S.a(i3)) {
                return b;
            }
        }
        if (obj == null) {
            return b;
        }
        i2 = C0895d.a(iArr);
        if (c != null) {
            length = c.length;
            for (int i4 = bt; i4 < length; i4++) {
                if ((C0895d.w(l.get(c[i4])) & i2) != 0) {
                    return b;
                }
            }
        }
        l().put(a, ((i2 << 24) | (s2 << 16)) | s3);
        return a;
    }

    protected int a(short s, short s2, int i, int i2) {
        int[] c = c(s);
        if (c == null) {
            return b;
        }
        SparseIntArray l = l();
        int length = c.length;
        for (int i3 = bt; i3 < length; i3++) {
            int i4 = c[i3];
            int i5 = l.get(i4);
            short y = C0895d.y(i5);
            int z = C0895d.z(i5);
            int[] x = C0895d.x(i5);
            Object obj = null;
            int length2 = x.length;
            for (int i6 = bt; i6 < length2; i6++) {
                if (x[i6] == i2) {
                    obj = 1;
                    break;
                }
            }
            if (obj != null && s2 == y && (i == z || z == 0)) {
                return i4;
            }
        }
        return b;
    }

    public S a(int i, int i2) {
        return !S.a(i2) ? null : this.by.a(C0895d.a(i), i2);
    }

    public S a(int i, int i2, Object obj) {
        int i3 = l().get(i);
        if (i3 == 0 || obj == null) {
            return null;
        }
        short y = C0895d.y(i3);
        int z = C0895d.z(i3);
        boolean z2 = z != 0;
        if (!C0895d.n(i3, i2)) {
            return null;
        }
        S s = new S(C0895d.a(i), y, z, i2, z2);
        return !s.a(obj) ? null : s;
    }

    public S a(int i, Object obj) {
        return a(i, C0895d.b(i), obj);
    }

    public S a(S s) {
        return this.by.a(s);
    }

    public OutputStream a(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException(bx);
        }
        OutputStream m = new M(outputStream, this);
        m.a(this.by);
        return m;
    }

    public List<S> a(short s) {
        return this.by.a(s);
    }

    public void a() {
        this.by = new C0894c(bv);
    }

    public void a(Bitmap bitmap, OutputStream outputStream) {
        if (bitmap == null || outputStream == null) {
            throw new IllegalArgumentException(bx);
        }
        OutputStream a = a(outputStream);
        bitmap.compress(CompressFormat.JPEG, 90, a);
        a.flush();
    }

    public void a(Bitmap bitmap, String str) {
        if (bitmap == null || str == null) {
            throw new IllegalArgumentException(bx);
        }
        Closeable closeable = null;
        try {
            closeable = b(str);
            bitmap.compress(CompressFormat.JPEG, 90, closeable);
            closeable.flush();
            closeable.close();
        } catch (IOException e) {
            C0895d.a(closeable);
            throw e;
        }
    }

    public void a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException(bx);
        }
        try {
            this.by = new R(this).a(inputStream);
        } catch (J e) {
            throw new IOException("Invalid exif format : " + e);
        }
    }

    public void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            throw new IllegalArgumentException(bx);
        }
        OutputStream a = a(outputStream);
        b(inputStream, a);
        a.flush();
    }

    public void a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException(bx);
        }
        Closeable closeable = null;
        try {
            closeable = b(str);
            b(inputStream, (OutputStream) closeable);
            closeable.flush();
            closeable.close();
        } catch (IOException e) {
            C0895d.a(closeable);
            throw e;
        }
    }

    public void a(String str) {
        Closeable bufferedInputStream;
        IOException e;
        if (str == null) {
            throw new IllegalArgumentException(bx);
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                a((InputStream) bufferedInputStream);
                bufferedInputStream.close();
            } catch (IOException e2) {
                e = e2;
                C0895d.a(bufferedInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            C0895d.a(bufferedInputStream);
            throw e;
        }
    }

    public void a(String str, String str2) {
        IOException e;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(bx);
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a((InputStream) fileInputStream, str2);
                fileInputStream.close();
            } catch (IOException e2) {
                e = e2;
                C0895d.a(fileInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            C0895d.a(fileInputStream);
            throw e;
        }
    }

    public void a(Collection<S> collection) {
        a();
        b((Collection) collection);
    }

    public void a(byte[] bArr) {
        a(new ByteArrayInputStream(bArr));
    }

    public void a(byte[] bArr, OutputStream outputStream) {
        if (bArr == null || outputStream == null) {
            throw new IllegalArgumentException(bx);
        }
        OutputStream a = a(outputStream);
        a.write(bArr, bt, bArr.length);
        a.flush();
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            throw new IllegalArgumentException(bx);
        }
        Closeable closeable = null;
        try {
            closeable = b(str);
            closeable.write(bArr, bt, bArr.length);
            closeable.flush();
            closeable.close();
        } catch (IOException e) {
            C0895d.a(closeable);
            throw e;
        }
    }

    public boolean a(double d, double d2) {
        S a = a(aQ, C0895d.a(d));
        S a2 = a(aS, C0895d.a(d2));
        S a3 = a(aP, d >= 0.0d ? C0910s.c : C0907p.b);
        S a4 = a(aR, d2 >= 0.0d ? C0908q.a : C0908q.b);
        if (a == null || a2 == null || a3 == null || a4 == null) {
            return false;
        }
        a(a);
        a(a2);
        a(a3);
        a(a4);
        return true;
    }

    public boolean a(int i, long j, TimeZone timeZone) {
        if (i != w && i != R && i != Q) {
            return false;
        }
        this.bB.setTimeZone(timeZone);
        S a = a(i, this.bB.format(Long.valueOf(j)));
        if (a == null) {
            return false;
        }
        a(a);
        return true;
    }

    public boolean a(long j) {
        S a = a(br, this.bC.format(Long.valueOf(j)));
        if (a == null) {
            return false;
        }
        a(a);
        this.bD.setTimeInMillis(j);
        a = a(aV, new X[]{new X((long) this.bD.get(11), 1), new X((long) this.bD.get(12), 1), new X((long) this.bD.get(13), 1)});
        if (a == null) {
            return false;
        }
        a(a);
        return true;
    }

    public boolean a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        return !bitmap.compress(CompressFormat.JPEG, 90, byteArrayOutputStream) ? false : b(byteArrayOutputStream.toByteArray());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r9, java.util.Collection<com.a.a.a.S> r10) {
        /*
        r8 = this;
        r6 = 0;
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r0.<init>(r9);	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r2 = com.a.a.a.N.a(r1, r8);	 Catch:{ J -> 0x0040 }
        r2 = r2.j();	 Catch:{ IOException -> 0x0049 }
        r4 = (long) r2;	 Catch:{ IOException -> 0x0049 }
        r1.close();	 Catch:{ IOException -> 0x0049 }
        r7 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r1 = "rw";
        r7.<init>(r0, r1);	 Catch:{ IOException -> 0x0064, all -> 0x0062 }
        r0 = r7.length();	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x004b;
    L_0x002b:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        r1 = "Filesize changed during operation";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        throw r0;	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
    L_0x0033:
        r0 = move-exception;
        r1 = r6;
        r6 = r7;
    L_0x0036:
        com.a.a.a.C0895d.a(r6);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003a:
        r0 = move-exception;
        r6 = r1;
    L_0x003c:
        com.a.a.a.C0895d.a(r6);
        throw r0;
    L_0x0040:
        r0 = move-exception;
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x0049 }
        r3 = "Invalid exif format : ";
        r2.<init>(r3, r0);	 Catch:{ IOException -> 0x0049 }
        throw r2;	 Catch:{ IOException -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        goto L_0x0036;
    L_0x004b:
        r0 = r7.getChannel();	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        r1 = java.nio.channels.FileChannel.MapMode.READ_WRITE;	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        r2 = 0;
        r0 = r0.map(r1, r2, r4);	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        r0 = r8.a(r0, r10);	 Catch:{ IOException -> 0x0033, all -> 0x0062 }
        com.a.a.a.C0895d.a(r6);
        r7.close();
        return r0;
    L_0x0062:
        r0 = move-exception;
        goto L_0x003c;
    L_0x0064:
        r0 = move-exception;
        r1 = r6;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.d.a(java.lang.String, java.util.Collection):boolean");
    }

    public boolean a(ByteBuffer byteBuffer, Collection<S> collection) {
        try {
            K k = new K(byteBuffer, this);
            for (S a : collection) {
                k.a(a);
            }
            return k.b();
        } catch (J e) {
            throw new IOException("Invalid exif format : " + e);
        }
    }

    protected int b(S s) {
        return a(s.b(), s.c(), s.e(), s.a());
    }

    public OutputStream b(String str) {
        if (str == null) {
            throw new IllegalArgumentException(bx);
        }
        try {
            return a(new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            C0895d.a(null);
            throw e;
        }
    }

    public Object b(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.l();
    }

    public List<S> b() {
        return this.by.i();
    }

    public void b(String str, Collection<S> collection) {
        FileInputStream fileInputStream;
        IOException e;
        Throwable th;
        if (!a(str, (Collection) collection)) {
            C0894c c0894c = this.by;
            this.by = new C0894c(bv);
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    b((InputStream) fileInputStream, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    a(toByteArray);
                    b((Collection) collection);
                    a(toByteArray, str);
                    fileInputStream.close();
                    this.by = c0894c;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C0895d.a((Closeable) fileInputStream);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream.close();
                        this.by = c0894c;
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                C0895d.a((Closeable) fileInputStream);
                throw e;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                fileInputStream.close();
                this.by = c0894c;
                throw th;
            }
        }
    }

    public void b(Collection<S> collection) {
        for (S a : collection) {
            a(a);
        }
    }

    public boolean b(int i, int i2, Object obj) {
        S a = a(i, i2);
        return a == null ? false : a.a(obj);
    }

    public boolean b(int i, Object obj) {
        return b(i, q(i), obj);
    }

    public boolean b(byte[] bArr) {
        this.by.f();
        this.by.a(bArr);
        return true;
    }

    public String c(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.g();
    }

    public List<S> c(int i) {
        return this.by.d(i);
    }

    public void c() {
        this.bE = null;
    }

    public void c(String str) {
        b(str, b());
    }

    protected int[] c(short s) {
        int[] a = T.a();
        int[] iArr = new int[a.length];
        SparseIntArray l = l();
        int length = a.length;
        int i = bt;
        int i2 = bt;
        while (i < length) {
            int i3;
            int a2 = C0895d.a(a[i], s);
            if (l.get(a2) != 0) {
                i3 = i2 + 1;
                iArr[i2] = a2;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2 == 0 ? null : Arrays.copyOfRange(iArr, bt, i2);
    }

    public Bitmap d() {
        if (this.by.b()) {
            byte[] a = this.by.a();
            return BitmapFactory.decodeByteArray(a, bt, a.length);
        }
        this.by.d();
        return null;
    }

    public S d(int i) {
        return a(i, q(i));
    }

    public Long d(int i, int i2) {
        long[] h = h(i, i2);
        return (h == null || h.length <= 0) ? null : new Long(h[bt]);
    }

    public Integer e(int i, int i2) {
        int[] i3 = i(i, i2);
        return (i3 == null || i3.length <= 0) ? null : new Integer(i3[bt]);
    }

    public Object e(int i) {
        return b(i, q(i));
    }

    public byte[] e() {
        if (this.by.b()) {
            return this.by.a();
        }
        this.by.d();
        return null;
    }

    public Byte f(int i, int i2) {
        byte[] j = j(i, i2);
        return (j == null || j.length <= 0) ? null : new Byte(j[bt]);
    }

    public String f(int i) {
        return c(i, q(i));
    }

    public byte[] f() {
        return this.by.a();
    }

    public X g(int i, int i2) {
        X[] k = k(i, i2);
        return (k == null || k.length == 0) ? null : new X(k[bt]);
    }

    public Long g(int i) {
        return d(i, q(i));
    }

    public boolean g() {
        return this.by.b();
    }

    public Integer h(int i) {
        return e(i, q(i));
    }

    public boolean h() {
        return this.by.b();
    }

    public long[] h(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.k();
    }

    public Byte i(int i) {
        return f(i, q(i));
    }

    public void i() {
        this.by.a(null);
    }

    public int[] i(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.j();
    }

    public X j(int i) {
        return g(i, q(i));
    }

    public String j() {
        return this.by.h();
    }

    public byte[] j(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.h();
    }

    public double[] k() {
        X[] n = n(aQ);
        String f = f(aP);
        X[] n2 = n(aS);
        String f2 = f(aR);
        if (n == null || n2 == null || f == null || f2 == null || n.length < 3 || n2.length < 3) {
            return null;
        }
        return new double[]{C0895d.a(n, f), C0895d.a(n2, f2)};
    }

    public long[] k(int i) {
        return h(i, q(i));
    }

    public X[] k(int i, int i2) {
        S a = a(i, i2);
        return a == null ? null : a.i();
    }

    public int l(int i, int i2) {
        S a = a(i, i2);
        return a == null ? bt : a.e();
    }

    protected SparseIntArray l() {
        if (this.bE == null) {
            this.bE = new SparseIntArray();
            m();
        }
        return this.bE;
    }

    public int[] l(int i) {
        return i(i, q(i));
    }

    public void m(int i, int i2) {
        this.by.b(C0895d.a(i), i2);
    }

    public byte[] m(int i) {
        return j(i, q(i));
    }

    public X[] n(int i) {
        return k(i, q(i));
    }

    public boolean o(int i) {
        int i2 = l().get(i);
        return (i2 == 0 || C0895d.z(i2) == 0) ? false : true;
    }

    public int p(int i) {
        int i2 = l().get(i);
        return i2 == 0 ? bt : C0895d.z(i2);
    }

    public int q(int i) {
        return l().get(i) == 0 ? b : C0895d.b(i);
    }

    public short r(int i) {
        int i2 = l().get(i);
        return i2 == 0 ? (short) -1 : C0895d.y(i2);
    }

    protected S s(int i) {
        int i2 = l().get(i);
        if (i2 == 0) {
            return null;
        }
        short y = C0895d.y(i2);
        int z = C0895d.z(i2);
        return new S(C0895d.a(i), y, z, C0895d.b(i), z != 0);
    }

    public void t(int i) {
        m(i, q(i));
    }

    public void u(int i) {
        l().delete(i);
    }
}
