package com.a.a.a;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class K {
    public static final String a = "ExifModifier";
    public static final boolean b = false;
    private final ByteBuffer c;
    private final C0894c d;
    private final List<L> e = new ArrayList();
    private final C0895d f;
    private int g;

    protected K(ByteBuffer byteBuffer, C0895d c0895d) {
        Throwable th;
        this.c = byteBuffer;
        this.g = byteBuffer.position();
        this.f = c0895d;
        Closeable c0892a;
        try {
            c0892a = new C0892a(byteBuffer);
            try {
                N a = N.a((InputStream) c0892a, this.f);
                this.d = new C0894c(a.q());
                this.g = a.k() + this.g;
                this.c.position(0);
                C0895d.a(c0892a);
            } catch (Throwable th2) {
                th = th2;
                C0895d.a(c0892a);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c0892a = null;
            C0895d.a(c0892a);
            throw th;
        }
    }

    private void a(S s, int i) {
        int i2 = 0;
        this.c.position(this.g + i);
        int e;
        switch (s.c()) {
            case l.a /*1*/:
            case a.bc /*7*/:
                byte[] bArr = new byte[s.e()];
                s.b(bArr);
                this.c.put(bArr);
                return;
            case a.k /*2*/:
                byte[] o = s.o();
                if (o.length == s.e()) {
                    o[o.length - 1] = (byte) 0;
                    this.c.put(o);
                    return;
                }
                this.c.put(o);
                this.c.put((byte) 0);
                return;
            case a.l /*3*/:
                e = s.e();
                while (i2 < e) {
                    this.c.putShort((short) ((int) s.f(i2)));
                    i2++;
                }
                return;
            case a.aQ /*4*/:
            case a.bo /*9*/:
                e = s.e();
                while (i2 < e) {
                    this.c.putInt((int) s.f(i2));
                    i2++;
                }
                return;
            case a.X /*5*/:
            case a.bd /*10*/:
                e = s.e();
                while (i2 < e) {
                    X g = s.g(i2);
                    this.c.putInt((int) g.a());
                    this.c.putInt((int) g.b());
                    i2++;
                }
                return;
            default:
                return;
        }
    }

    private void c() {
        this.c.order(a());
        for (L l : this.e) {
            a(l.b, l.a);
        }
    }

    protected ByteOrder a() {
        return this.d.e();
    }

    public void a(S s) {
        this.d.a(s);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean b() {
        /*
        r11 = this;
        r1 = 1;
        r0 = 0;
        r3 = 0;
        r2 = new com.a.a.a.a;	 Catch:{ all -> 0x00eb }
        r4 = r11.c;	 Catch:{ all -> 0x00eb }
        r2.<init>(r4);	 Catch:{ all -> 0x00eb }
        r3 = 5;
        r5 = new com.a.a.a.T[r3];	 Catch:{ all -> 0x008f }
        r3 = 0;
        r4 = r11.d;	 Catch:{ all -> 0x008f }
        r6 = 0;
        r4 = r4.b(r6);	 Catch:{ all -> 0x008f }
        r5[r3] = r4;	 Catch:{ all -> 0x008f }
        r3 = 1;
        r4 = r11.d;	 Catch:{ all -> 0x008f }
        r6 = 1;
        r4 = r4.b(r6);	 Catch:{ all -> 0x008f }
        r5[r3] = r4;	 Catch:{ all -> 0x008f }
        r3 = 2;
        r4 = r11.d;	 Catch:{ all -> 0x008f }
        r6 = 2;
        r4 = r4.b(r6);	 Catch:{ all -> 0x008f }
        r5[r3] = r4;	 Catch:{ all -> 0x008f }
        r3 = 3;
        r4 = r11.d;	 Catch:{ all -> 0x008f }
        r6 = 3;
        r4 = r4.b(r6);	 Catch:{ all -> 0x008f }
        r5[r3] = r4;	 Catch:{ all -> 0x008f }
        r3 = 4;
        r4 = r11.d;	 Catch:{ all -> 0x008f }
        r6 = 4;
        r4 = r4.b(r6);	 Catch:{ all -> 0x008f }
        r5[r3] = r4;	 Catch:{ all -> 0x008f }
        r3 = 0;
        r3 = r5[r3];	 Catch:{ all -> 0x008f }
        if (r3 == 0) goto L_0x00ee;
    L_0x0044:
        r3 = r1;
    L_0x0045:
        r4 = 1;
        r4 = r5[r4];	 Catch:{ all -> 0x008f }
        if (r4 == 0) goto L_0x004c;
    L_0x004a:
        r3 = r3 | 2;
    L_0x004c:
        r4 = 2;
        r4 = r5[r4];	 Catch:{ all -> 0x008f }
        if (r4 == 0) goto L_0x0053;
    L_0x0051:
        r3 = r3 | 4;
    L_0x0053:
        r4 = 4;
        r4 = r5[r4];	 Catch:{ all -> 0x008f }
        if (r4 == 0) goto L_0x005a;
    L_0x0058:
        r3 = r3 | 8;
    L_0x005a:
        r4 = 3;
        r4 = r5[r4];	 Catch:{ all -> 0x008f }
        if (r4 == 0) goto L_0x0061;
    L_0x005f:
        r3 = r3 | 16;
    L_0x0061:
        r4 = r11.f;	 Catch:{ all -> 0x008f }
        r6 = com.a.a.a.N.a(r2, r3, r4);	 Catch:{ all -> 0x008f }
        r4 = r6.a();	 Catch:{ all -> 0x008f }
        r3 = 0;
    L_0x006c:
        r7 = 5;
        if (r4 != r7) goto L_0x007b;
    L_0x006f:
        r4 = r5.length;	 Catch:{ all -> 0x008f }
        r3 = r0;
    L_0x0071:
        if (r3 < r4) goto L_0x00da;
    L_0x0073:
        r11.c();	 Catch:{ all -> 0x008f }
        com.a.a.a.C0895d.a(r2);
        r0 = r1;
    L_0x007a:
        return r0;
    L_0x007b:
        switch(r4) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0095;
            default: goto L_0x007e;
        };
    L_0x007e:
        r4 = r6.a();	 Catch:{ all -> 0x008f }
        goto L_0x006c;
    L_0x0083:
        r3 = r6.e();	 Catch:{ all -> 0x008f }
        r3 = r5[r3];	 Catch:{ all -> 0x008f }
        if (r3 != 0) goto L_0x007e;
    L_0x008b:
        r6.b();	 Catch:{ all -> 0x008f }
        goto L_0x007e;
    L_0x008f:
        r0 = move-exception;
        r1 = r2;
    L_0x0091:
        com.a.a.a.C0895d.a(r1);
        throw r0;
    L_0x0095:
        r4 = r6.c();	 Catch:{ all -> 0x008f }
        r7 = r4.b();	 Catch:{ all -> 0x008f }
        r7 = r3.a(r7);	 Catch:{ all -> 0x008f }
        if (r7 == 0) goto L_0x007e;
    L_0x00a3:
        r8 = r7.e();	 Catch:{ all -> 0x008f }
        r9 = r4.e();	 Catch:{ all -> 0x008f }
        if (r8 != r9) goto L_0x00b7;
    L_0x00ad:
        r8 = r7.c();	 Catch:{ all -> 0x008f }
        r9 = r4.c();	 Catch:{ all -> 0x008f }
        if (r8 == r9) goto L_0x00bb;
    L_0x00b7:
        com.a.a.a.C0895d.a(r2);
        goto L_0x007a;
    L_0x00bb:
        r8 = r11.e;	 Catch:{ all -> 0x008f }
        r9 = new com.a.a.a.L;	 Catch:{ all -> 0x008f }
        r10 = r4.p();	 Catch:{ all -> 0x008f }
        r9.<init>(r7, r10);	 Catch:{ all -> 0x008f }
        r8.add(r9);	 Catch:{ all -> 0x008f }
        r4 = r4.b();	 Catch:{ all -> 0x008f }
        r3.c(r4);	 Catch:{ all -> 0x008f }
        r4 = r3.d();	 Catch:{ all -> 0x008f }
        if (r4 != 0) goto L_0x007e;
    L_0x00d6:
        r6.b();	 Catch:{ all -> 0x008f }
        goto L_0x007e;
    L_0x00da:
        r6 = r5[r3];	 Catch:{ all -> 0x008f }
        if (r6 == 0) goto L_0x00e8;
    L_0x00de:
        r6 = r6.d();	 Catch:{ all -> 0x008f }
        if (r6 <= 0) goto L_0x00e8;
    L_0x00e4:
        com.a.a.a.C0895d.a(r2);
        goto L_0x007a;
    L_0x00e8:
        r3 = r3 + 1;
        goto L_0x0071;
    L_0x00eb:
        r0 = move-exception;
        r1 = r3;
        goto L_0x0091;
    L_0x00ee:
        r3 = r0;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.K.b():boolean");
    }
}
