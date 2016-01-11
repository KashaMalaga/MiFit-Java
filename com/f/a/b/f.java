package com.f.a.b;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.f.a.b.a.e;
import com.f.a.b.g.a;

public class f {
    private int a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private e j;
    private Options k;
    private int l;
    private boolean m;
    private Object n;
    private a o;
    private a p;
    private com.f.a.b.c.a q;
    private Handler r;
    private boolean s;

    public f() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = e.IN_SAMPLE_POWER_OF_2;
        this.k = new Options();
        this.l = 0;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = a.c();
        this.r = null;
        this.s = false;
        this.k.inPurgeable = true;
        this.k.inInputShareable = true;
    }

    public f a() {
        this.g = true;
        return this;
    }

    @Deprecated
    public f a(int i) {
        this.a = i;
        return this;
    }

    public f a(Config config) {
        if (config == null) {
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }
        this.k.inPreferredConfig = config;
        return this;
    }

    public f a(Options options) {
        if (options == null) {
            throw new IllegalArgumentException("decodingOptions can't be null");
        }
        this.k = options;
        return this;
    }

    public f a(Drawable drawable) {
        this.d = drawable;
        return this;
    }

    public f a(Handler handler) {
        this.r = handler;
        return this;
    }

    public f a(e eVar) {
        this.j = eVar;
        return this;
    }

    public f a(com.f.a.b.c.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("displayer can't be null");
        }
        this.q = aVar;
        return this;
    }

    public f a(d dVar) {
        this.a = dVar.a;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.o = dVar.o;
        this.p = dVar.p;
        this.q = dVar.q;
        this.r = dVar.r;
        this.s = dVar.s;
        return this;
    }

    public f a(a aVar) {
        this.o = aVar;
        return this;
    }

    public f a(Object obj) {
        this.n = obj;
        return this;
    }

    public f a(boolean z) {
        this.g = z;
        return this;
    }

    @Deprecated
    public f b() {
        this.h = true;
        return this;
    }

    public f b(int i) {
        this.a = i;
        return this;
    }

    public f b(Drawable drawable) {
        this.e = drawable;
        return this;
    }

    public f b(a aVar) {
        this.p = aVar;
        return this;
    }

    public f b(boolean z) {
        this.h = z;
        return this;
    }

    @Deprecated
    public f c() {
        return d(true);
    }

    public f c(int i) {
        this.b = i;
        return this;
    }

    public f c(Drawable drawable) {
        this.f = drawable;
        return this;
    }

    @Deprecated
    public f c(boolean z) {
        return d(z);
    }

    public d d() {
        return new d();
    }

    public f d(int i) {
        this.c = i;
        return this;
    }

    public f d(boolean z) {
        this.i = z;
        return this;
    }

    public f e(int i) {
        this.l = i;
        return this;
    }

    public f e(boolean z) {
        this.m = z;
        return this;
    }

    f f(boolean z) {
        this.s = z;
        return this;
    }
}
