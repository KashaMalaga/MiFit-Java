package com.f.a.b;

import android.content.Context;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.f.a.a.a.b;
import com.f.a.a.a.b.a;
import com.f.a.b.a.h;
import com.f.a.b.b.d;
import com.f.a.b.d.c;
import com.f.a.c.f;
import com.f.a.c.g;
import java.util.concurrent.Executor;

public class l {
    public static final int a = 3;
    public static final int b = 4;
    public static final h c = h.FIFO;
    private static final String d = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
    private static final String e = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
    private static final String f = "memoryCache() and memoryCacheSize() calls overlap each other";
    private static final String g = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
    private a A = null;
    private c B = null;
    private d C;
    private d D = null;
    private boolean E = false;
    private Context h;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private com.f.a.b.g.a m = null;
    private Executor n = null;
    private Executor o = null;
    private boolean p = false;
    private boolean q = false;
    private int r = a;
    private int s = b;
    private boolean t = false;
    private h u = c;
    private int v = 0;
    private long w = 0;
    private int x = 0;
    private com.f.a.a.b.c y = null;
    private b z = null;

    public l(Context context) {
        this.h = context.getApplicationContext();
    }

    private void d() {
        if (this.n == null) {
            this.n = a.a(this.r, this.s, this.u);
        } else {
            this.p = true;
        }
        if (this.o == null) {
            this.o = a.a(this.r, this.s, this.u);
        } else {
            this.q = true;
        }
        if (this.z == null) {
            if (this.A == null) {
                this.A = a.b();
            }
            this.z = a.a(this.h, this.A, this.w, this.x);
        }
        if (this.y == null) {
            this.y = a.a(this.v);
        }
        if (this.t) {
            this.y = new com.f.a.a.b.a.b(this.y, g.a());
        }
        if (this.B == null) {
            this.B = a.a(this.h);
        }
        if (this.C == null) {
            this.C = a.a(this.E);
        }
        if (this.D == null) {
            this.D = d.t();
        }
    }

    public l a() {
        this.t = true;
        return this;
    }

    public l a(int i) {
        if (!(this.n == null && this.o == null)) {
            f.c(g, new Object[0]);
        }
        this.r = i;
        return this;
    }

    public l a(int i, int i2) {
        this.i = i;
        this.j = i2;
        return this;
    }

    @Deprecated
    public l a(int i, int i2, com.f.a.b.g.a aVar) {
        return b(i, i2, aVar);
    }

    @Deprecated
    public l a(a aVar) {
        return b(aVar);
    }

    @Deprecated
    public l a(b bVar) {
        return b(bVar);
    }

    public l a(com.f.a.a.b.c cVar) {
        if (this.v != 0) {
            f.c(f, new Object[0]);
        }
        this.y = cVar;
        return this;
    }

    public l a(h hVar) {
        if (!(this.n == null && this.o == null)) {
            f.c(g, new Object[0]);
        }
        this.u = hVar;
        return this;
    }

    public l a(d dVar) {
        this.C = dVar;
        return this;
    }

    public l a(c cVar) {
        this.B = cVar;
        return this;
    }

    public l a(d dVar) {
        this.D = dVar;
        return this;
    }

    public l a(Executor executor) {
        if (!(this.r == a && this.s == b && this.u == c)) {
            f.c(g, new Object[0]);
        }
        this.n = executor;
        return this;
    }

    public l b() {
        this.E = true;
        return this;
    }

    public l b(int i) {
        if (!(this.n == null && this.o == null)) {
            f.c(g, new Object[0]);
        }
        if (i < 1) {
            this.s = 1;
        } else if (i > 10) {
            this.s = 10;
        } else {
            this.s = i;
        }
        return this;
    }

    public l b(int i, int i2, com.f.a.b.g.a aVar) {
        this.k = i;
        this.l = i2;
        this.m = aVar;
        return this;
    }

    public l b(a aVar) {
        if (this.z != null) {
            f.c(e, new Object[0]);
        }
        this.A = aVar;
        return this;
    }

    public l b(b bVar) {
        if (this.w > 0 || this.x > 0) {
            f.c(d, new Object[0]);
        }
        if (this.A != null) {
            f.c(e, new Object[0]);
        }
        this.z = bVar;
        return this;
    }

    public l b(Executor executor) {
        if (!(this.r == a && this.s == b && this.u == c)) {
            f.c(g, new Object[0]);
        }
        this.o = executor;
        return this;
    }

    public j c() {
        d();
        return new j();
    }

    public l c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }
        if (this.y != null) {
            f.c(f, new Object[0]);
        }
        this.v = i;
        return this;
    }

    public l d(int i) {
        if (i <= 0 || i >= 100) {
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }
        if (this.y != null) {
            f.c(f, new Object[0]);
        }
        this.v = (int) (((float) Runtime.getRuntime().maxMemory()) * (((float) i) / CropOverlayView.a));
        return this;
    }

    @Deprecated
    public l e(int i) {
        return f(i);
    }

    public l f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }
        if (this.z != null) {
            f.c(d, new Object[0]);
        }
        this.w = (long) i;
        return this;
    }

    @Deprecated
    public l g(int i) {
        return h(i);
    }

    public l h(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }
        if (this.z != null) {
            f.c(d, new Object[0]);
        }
        this.x = i;
        return this;
    }
}
