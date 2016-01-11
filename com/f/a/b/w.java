package com.f.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.f.a.b.a.g;
import com.f.a.c.f;

final class w implements Runnable {
    private static final String a = "PostProcess image before displaying [%s]";
    private final o b;
    private final Bitmap c;
    private final q d;
    private final Handler e;

    public w(o oVar, Bitmap bitmap, q qVar, Handler handler) {
        this.b = oVar;
        this.c = bitmap;
        this.d = qVar;
        this.e = handler;
    }

    public void run() {
        f.a(a, this.d.b);
        r.a(new c(this.d.e.p().a(this.c), this.d, this.b, g.MEMORY_CACHE), this.d.e.s(), this.e, this.b);
    }
}
