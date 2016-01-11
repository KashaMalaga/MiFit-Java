package com.f.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.f.a.b.a.f;
import com.f.a.b.a.i;
import com.f.a.b.e.b;
import com.f.a.b.e.c;
import com.f.a.b.f.a;
import com.f.a.b.f.d;

public class g {
    public static final String a = g.class.getSimpleName();
    static final String b = "Initialize ImageLoader with configuration";
    static final String c = "Destroy ImageLoader";
    static final String d = "Load image from memory cache [%s]";
    private static final String e = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static final String f = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    private static final String g = "ImageLoader must be init with configuration before using";
    private static final String h = "ImageLoader configuration can not be initialized with null";
    private static volatile g l;
    private j i;
    private o j;
    private final a k = new d();

    protected g() {
    }

    private static Handler a(d dVar) {
        Handler r = dVar.r();
        return dVar.s() ? null : (r == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : r;
    }

    public static g a() {
        if (l == null) {
            synchronized (g.class) {
                if (l == null) {
                    l = new g();
                }
            }
        }
        return l;
    }

    private void l() {
        if (this.i == null) {
            throw new IllegalStateException(g);
        }
    }

    public Bitmap a(String str) {
        return a(str, null, null);
    }

    public Bitmap a(String str, f fVar) {
        return a(str, fVar, null);
    }

    public Bitmap a(String str, f fVar, d dVar) {
        if (dVar == null) {
            dVar = this.i.r;
        }
        d d = new f().a(dVar).f(true).d();
        a iVar = new i();
        a(str, fVar, d, iVar);
        return iVar.a();
    }

    public Bitmap a(String str, d dVar) {
        return a(str, null, dVar);
    }

    public String a(ImageView imageView) {
        return this.j.a(new b(imageView));
    }

    public String a(com.f.a.b.e.a aVar) {
        return this.j.a(aVar);
    }

    public synchronized void a(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException(h);
        } else if (this.i == null) {
            com.f.a.c.f.a(b, new Object[0]);
            this.j = new o(jVar);
            this.i = jVar;
        } else {
            com.f.a.c.f.c(e, new Object[0]);
        }
    }

    public void a(String str, ImageView imageView) {
        a(str, new b(imageView), null, null, null);
    }

    public void a(String str, ImageView imageView, d dVar) {
        a(str, new b(imageView), dVar, null, null);
    }

    public void a(String str, ImageView imageView, d dVar, a aVar) {
        a(str, imageView, dVar, aVar, null);
    }

    public void a(String str, ImageView imageView, d dVar, a aVar, com.f.a.b.f.b bVar) {
        a(str, new b(imageView), dVar, aVar, bVar);
    }

    public void a(String str, ImageView imageView, a aVar) {
        a(str, new b(imageView), null, aVar, null);
    }

    public void a(String str, f fVar, d dVar, a aVar) {
        a(str, fVar, dVar, aVar, null);
    }

    public void a(String str, f fVar, d dVar, a aVar, com.f.a.b.f.b bVar) {
        l();
        if (fVar == null) {
            fVar = this.i.a();
        }
        a(str, new c(str, fVar, i.CROP), dVar == null ? this.i.r : dVar, aVar, bVar);
    }

    public void a(String str, f fVar, a aVar) {
        a(str, fVar, null, aVar, null);
    }

    public void a(String str, d dVar, a aVar) {
        a(str, null, dVar, aVar, null);
    }

    public void a(String str, com.f.a.b.e.a aVar) {
        a(str, aVar, null, null, null);
    }

    public void a(String str, com.f.a.b.e.a aVar, d dVar) {
        a(str, aVar, dVar, null, null);
    }

    public void a(String str, com.f.a.b.e.a aVar, d dVar, a aVar2) {
        a(str, aVar, dVar, aVar2, null);
    }

    public void a(String str, com.f.a.b.e.a aVar, d dVar, a aVar2, com.f.a.b.f.b bVar) {
        l();
        if (aVar == null) {
            throw new IllegalArgumentException(f);
        }
        a aVar3 = aVar2 == null ? this.k : aVar2;
        d dVar2 = dVar == null ? this.i.r : dVar;
        if (TextUtils.isEmpty(str)) {
            this.j.b(aVar);
            aVar3.a(str, aVar.d());
            if (dVar2.b()) {
                aVar.a(dVar2.b(this.i.a));
            } else {
                aVar.a(null);
            }
            aVar3.a(str, aVar.d(), null);
            return;
        }
        f a = com.f.a.c.b.a(aVar, this.i.a());
        String a2 = com.f.a.c.g.a(str, a);
        this.j.a(aVar, a2);
        aVar3.a(str, aVar.d());
        Bitmap bitmap = (Bitmap) this.i.n.b(a2);
        if (bitmap == null || bitmap.isRecycled()) {
            if (dVar2.a()) {
                aVar.a(dVar2.a(this.i.a));
            } else if (dVar2.g()) {
                aVar.a(null);
            }
            r rVar = new r(this.j, new q(str, aVar, a, a2, dVar2, aVar3, bVar, this.j.a(str)), a(dVar2));
            if (dVar2.s()) {
                rVar.run();
                return;
            } else {
                this.j.a(rVar);
                return;
            }
        }
        com.f.a.c.f.a(d, a2);
        if (dVar2.e()) {
            w wVar = new w(this.j, bitmap, new q(str, aVar, a, a2, dVar2, aVar3, bVar, this.j.a(str)), a(dVar2));
            if (dVar2.s()) {
                wVar.run();
                return;
            } else {
                this.j.a(wVar);
                return;
            }
        }
        dVar2.q().a(bitmap, aVar, com.f.a.b.a.g.MEMORY_CACHE);
        aVar3.a(str, aVar.d(), bitmap);
    }

    public void a(String str, com.f.a.b.e.a aVar, a aVar2) {
        a(str, aVar, null, aVar2, null);
    }

    public void a(String str, a aVar) {
        a(str, null, null, aVar, null);
    }

    public void a(boolean z) {
        this.j.a(z);
    }

    public void b(ImageView imageView) {
        this.j.b(new b(imageView));
    }

    public void b(com.f.a.b.e.a aVar) {
        this.j.b(aVar);
    }

    public void b(boolean z) {
        this.j.b(z);
    }

    public boolean b() {
        return this.i != null;
    }

    public com.f.a.a.b.c c() {
        l();
        return this.i.n;
    }

    public void d() {
        l();
        this.i.n.b();
    }

    @Deprecated
    public com.f.a.a.a.b e() {
        return f();
    }

    public com.f.a.a.a.b f() {
        l();
        return this.i.o;
    }

    @Deprecated
    public void g() {
        h();
    }

    public void h() {
        l();
        this.i.o.c();
    }

    public void i() {
        this.j.a();
    }

    public void j() {
        this.j.b();
    }

    public void k() {
        if (this.i != null) {
            com.f.a.c.f.a(c, new Object[0]);
        }
        stop();
        this.i.o.b();
        this.j = null;
        this.i = null;
    }

    public void stop() {
        this.j.stop();
    }
}
