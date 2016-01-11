package com.f.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.f.a.b.a.f;
import com.f.a.b.a.g;
import com.f.a.b.a.i;
import com.f.a.b.b.d;
import com.f.a.b.d.c;
import com.f.a.b.e.a;
import com.f.a.b.f.b;
import com.f.a.c.e;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class r implements e, Runnable {
    private static final String f = "ImageLoader is paused. Waiting...  [%s]";
    private static final String g = ".. Resume loading [%s]";
    private static final String h = "Delay %d ms before loading...  [%s]";
    private static final String i = "Start display image task [%s]";
    private static final String j = "Image already is loading. Waiting... [%s]";
    private static final String k = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String l = "Load image from network [%s]";
    private static final String m = "Load image from disk cache [%s]";
    private static final String n = "Resize image in disk cache [%s]";
    private static final String o = "PreProcess image before caching in memory [%s]";
    private static final String p = "PostProcess image before displaying [%s]";
    private static final String q = "Cache image in memory [%s]";
    private static final String r = "Cache image on disk [%s]";
    private static final String s = "Process image before cache on disk [%s]";
    private static final String t = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String u = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String v = "Task was interrupted [%s]";
    private static final String w = "Pre-processor returned null [%s]";
    private static final String x = "Post-processor returned null [%s]";
    private static final String y = "Bitmap processor for disk cache returned null [%s]";
    private final q A;
    private final Handler B;
    private final j C;
    private final c D;
    private final c E;
    private final c F;
    private final d G;
    private final String H;
    private final f I;
    private final boolean J;
    private g K = g.NETWORK;
    final String a;
    final a b;
    final d c;
    final com.f.a.b.f.a d;
    final b e;
    private final o z;

    public r(o oVar, q qVar, Handler handler) {
        this.z = oVar;
        this.A = qVar;
        this.B = handler;
        this.C = oVar.a;
        this.D = this.C.p;
        this.E = this.C.s;
        this.F = this.C.t;
        this.G = this.C.q;
        this.a = qVar.a;
        this.H = qVar.b;
        this.b = qVar.c;
        this.I = qVar.d;
        this.c = qVar.e;
        this.d = qVar.f;
        this.e = qVar.g;
        this.J = this.c.s();
    }

    private Bitmap a(String str) {
        String str2 = str;
        return this.G.a(new com.f.a.b.b.e(this.H, str2, this.a, this.I, this.b.c(), h(), this.c));
    }

    private void a(com.f.a.b.a.c cVar, Throwable th) {
        if (!this.J && !p() && !j()) {
            a(new t(this, cVar, th), false, this.B, this.z);
        }
    }

    static void a(Runnable runnable, boolean z, Handler handler, o oVar) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            oVar.a(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean b() {
        AtomicBoolean c = this.z.c();
        if (c.get()) {
            synchronized (this.z.d()) {
                if (c.get()) {
                    com.f.a.c.f.a(f, this.H);
                    try {
                        this.z.d().wait();
                        com.f.a.c.f.a(g, this.H);
                    } catch (InterruptedException e) {
                        com.f.a.c.f.d(v, this.H);
                        return true;
                    }
                }
            }
        }
        return j();
    }

    private boolean b(int i, int i2) {
        File a = this.C.o.a(this.a);
        if (a != null && a.exists()) {
            Bitmap a2 = this.G.a(new com.f.a.b.b.e(this.H, com.f.a.b.d.d.FILE.b(a.getAbsolutePath()), this.a, new f(i, i2), i.FIT_INSIDE, h(), new f().a(this.c).a(com.f.a.b.a.e.IN_SAMPLE_INT).d()));
            if (!(a2 == null || this.C.f == null)) {
                com.f.a.c.f.a(s, this.H);
                a2 = this.C.f.a(a2);
                if (a2 == null) {
                    com.f.a.c.f.d(y, this.H);
                }
            }
            Bitmap bitmap = a2;
            if (bitmap != null) {
                boolean a3 = this.C.o.a(this.a, bitmap);
                bitmap.recycle();
                return a3;
            }
        }
        return false;
    }

    private boolean c() {
        if (!this.c.f()) {
            return false;
        }
        com.f.a.c.f.a(h, Integer.valueOf(this.c.l()), this.H);
        try {
            Thread.sleep((long) this.c.l());
            return j();
        } catch (InterruptedException e) {
            com.f.a.c.f.d(v, this.H);
            return true;
        }
    }

    private boolean c(int i, int i2) {
        if (this.J || p() || j()) {
            return false;
        }
        if (this.e != null) {
            a(new s(this, i, i2), false, this.B, this.z);
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap d() {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.C;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.o;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = r7.a;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.a(r2);	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        if (r0 == 0) goto L_0x00cf;
    L_0x000d:
        r2 = r0.exists();	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        if (r2 == 0) goto L_0x00cf;
    L_0x0013:
        r2 = "Load image from disk cache [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r4 = 0;
        r5 = r7.H;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r3[r4] = r5;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        com.f.a.c.f.a(r2, r3);	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = com.f.a.b.a.g.DISC_CACHE;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r7.K = r2;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r7.i();	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = com.f.a.b.d.d.FILE;	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.getAbsolutePath();	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r2.b(r0);	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r7.a(r0);	 Catch:{ IllegalStateException -> 0x0096, v -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
    L_0x0035:
        if (r0 == 0) goto L_0x0043;
    L_0x0037:
        r2 = r0.getWidth();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 <= 0) goto L_0x0043;
    L_0x003d:
        r2 = r0.getHeight();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 > 0) goto L_0x0095;
    L_0x0043:
        r2 = "Load image from network [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r4 = 0;
        r5 = r7.H;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3[r4] = r5;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        com.f.a.c.f.a(r2, r3);	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = com.f.a.b.a.g.NETWORK;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r7.K = r2;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = r7.a;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r7.c;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.i();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x005e:
        r3 = r7.e();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x0064:
        r3 = r7.C;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.o;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r4 = r7.a;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.a(r4);	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x0070:
        r2 = com.f.a.b.d.d.FILE;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.getAbsolutePath();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = r2.b(r3);	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
    L_0x007a:
        r7.i();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r0 = r7.a(r2);	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r0 == 0) goto L_0x008f;
    L_0x0083:
        r2 = r0.getWidth();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 <= 0) goto L_0x008f;
    L_0x0089:
        r2 = r0.getHeight();	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 > 0) goto L_0x0095;
    L_0x008f:
        r2 = com.f.a.b.a.c.DECODING_ERROR;	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = 0;
        r7.a(r2, r3);	 Catch:{ IllegalStateException -> 0x00cd, v -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
    L_0x0095:
        return r0;
    L_0x0096:
        r0 = move-exception;
        r0 = r1;
    L_0x0098:
        r2 = com.f.a.b.a.c.NETWORK_DENIED;
        r7.a(r2, r1);
        goto L_0x0095;
    L_0x009e:
        r0 = move-exception;
        throw r0;
    L_0x00a0:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00a4:
        com.f.a.c.f.a(r1);
        r2 = com.f.a.b.a.c.IO_ERROR;
        r7.a(r2, r1);
        goto L_0x0095;
    L_0x00ad:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00b1:
        com.f.a.c.f.a(r1);
        r2 = com.f.a.b.a.c.OUT_OF_MEMORY;
        r7.a(r2, r1);
        goto L_0x0095;
    L_0x00ba:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00be:
        com.f.a.c.f.a(r1);
        r2 = com.f.a.b.a.c.UNKNOWN;
        r7.a(r2, r1);
        goto L_0x0095;
    L_0x00c7:
        r1 = move-exception;
        goto L_0x00be;
    L_0x00c9:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x00cb:
        r1 = move-exception;
        goto L_0x00a4;
    L_0x00cd:
        r2 = move-exception;
        goto L_0x0098;
    L_0x00cf:
        r0 = r1;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.f.a.b.r.d():android.graphics.Bitmap");
    }

    private boolean e() {
        com.f.a.c.f.a(r, this.H);
        try {
            boolean f = f();
            if (!f) {
                return f;
            }
            int i = this.C.d;
            int i2 = this.C.e;
            if (i <= 0 && i2 <= 0) {
                return f;
            }
            com.f.a.c.f.a(n, this.H);
            b(i, i2);
            return f;
        } catch (Throwable e) {
            com.f.a.c.f.a(e);
            return false;
        }
    }

    private boolean f() {
        return this.C.o.a(this.a, h().a(this.a, this.c.n()), this);
    }

    private void g() {
        if (!this.J && !p()) {
            a(new u(this), false, this.B, this.z);
        }
    }

    private c h() {
        return this.z.e() ? this.E : this.z.f() ? this.F : this.D;
    }

    private void i() {
        k();
        m();
    }

    private boolean j() {
        return l() || n();
    }

    private void k() {
        if (l()) {
            throw new v(this);
        }
    }

    private boolean l() {
        if (!this.b.e()) {
            return false;
        }
        com.f.a.c.f.a(u, this.H);
        return true;
    }

    private void m() {
        if (n()) {
            throw new v(this);
        }
    }

    private boolean n() {
        if (!(!this.H.equals(this.z.a(this.b)))) {
            return false;
        }
        com.f.a.c.f.a(t, this.H);
        return true;
    }

    private void o() {
        if (p()) {
            throw new v(this);
        }
    }

    private boolean p() {
        if (!Thread.interrupted()) {
            return false;
        }
        com.f.a.c.f.a(v, this.H);
        return true;
    }

    String a() {
        return this.a;
    }

    public boolean a(int i, int i2) {
        return c(i, i2);
    }

    public void run() {
        if (!b() && !c()) {
            ReentrantLock reentrantLock = this.A.h;
            com.f.a.c.f.a(i, this.H);
            if (reentrantLock.isLocked()) {
                com.f.a.c.f.a(j, this.H);
            }
            reentrantLock.lock();
            try {
                i();
                Bitmap bitmap = (Bitmap) this.C.n.b(this.H);
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = d();
                    if (bitmap != null) {
                        i();
                        o();
                        if (this.c.d()) {
                            com.f.a.c.f.a(o, this.H);
                            bitmap = this.c.o().a(bitmap);
                            if (bitmap == null) {
                                com.f.a.c.f.d(w, this.H);
                            }
                        }
                        if (bitmap != null && this.c.h()) {
                            com.f.a.c.f.a(q, this.H);
                            this.C.n.a(this.H, bitmap);
                        }
                    } else {
                        return;
                    }
                }
                this.K = g.MEMORY_CACHE;
                com.f.a.c.f.a(k, this.H);
                if (bitmap != null && this.c.e()) {
                    com.f.a.c.f.a(p, this.H);
                    bitmap = this.c.p().a(bitmap);
                    if (bitmap == null) {
                        com.f.a.c.f.d(x, this.H);
                    }
                }
                i();
                o();
                reentrantLock.unlock();
                a(new c(bitmap, this.A, this.z, this.K), this.J, this.B, this.z);
            } catch (v e) {
                g();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
