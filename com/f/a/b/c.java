package com.f.a.b;

import android.graphics.Bitmap;
import com.f.a.b.a.g;
import com.f.a.b.e.a;
import com.f.a.c.f;

final class c implements Runnable {
    private static final String a = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    private static final String b = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String c = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private final Bitmap d;
    private final String e;
    private final a f;
    private final String g;
    private final com.f.a.b.c.a h;
    private final com.f.a.b.f.a i;
    private final o j;
    private final g k;

    public c(Bitmap bitmap, q qVar, o oVar, g gVar) {
        this.d = bitmap;
        this.e = qVar.a;
        this.f = qVar.c;
        this.g = qVar.b;
        this.h = qVar.e.q();
        this.i = qVar.f;
        this.j = oVar;
        this.k = gVar;
    }

    private boolean a() {
        return !this.g.equals(this.j.a(this.f));
    }

    public void run() {
        if (this.f.e()) {
            f.a(c, this.g);
            this.i.b(this.e, this.f.d());
        } else if (a()) {
            f.a(b, this.g);
            this.i.b(this.e, this.f.d());
        } else {
            f.a(a, this.k, this.g);
            this.h.a(this.d, this.f, this.k);
            this.j.b(this.f);
            this.i.a(this.e, this.f.d(), this.d);
        }
    }
}
