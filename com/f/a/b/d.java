package com.f.a.b;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.f.a.b.a.e;
import com.f.a.b.g.a;

public final class d {
    private final int a;
    private final int b;
    private final int c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final e j;
    private final Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final a o;
    private final a p;
    private final com.f.a.b.c.a q;
    private final Handler r;
    private final boolean s;

    private d(f fVar) {
        this.a = fVar.a;
        this.b = fVar.b;
        this.c = fVar.c;
        this.d = fVar.d;
        this.e = fVar.e;
        this.f = fVar.f;
        this.g = fVar.g;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = fVar.k;
        this.l = fVar.l;
        this.m = fVar.m;
        this.n = fVar.n;
        this.o = fVar.o;
        this.p = fVar.p;
        this.q = fVar.q;
        this.r = fVar.r;
        this.s = fVar.s;
    }

    public static d t() {
        return new f().d();
    }

    public Drawable a(Resources resources) {
        return this.a != 0 ? resources.getDrawable(this.a) : this.d;
    }

    public boolean a() {
        return (this.d == null && this.a == 0) ? false : true;
    }

    public Drawable b(Resources resources) {
        return this.b != 0 ? resources.getDrawable(this.b) : this.e;
    }

    public boolean b() {
        return (this.e == null && this.b == 0) ? false : true;
    }

    public Drawable c(Resources resources) {
        return this.c != 0 ? resources.getDrawable(this.c) : this.f;
    }

    public boolean c() {
        return (this.f == null && this.c == 0) ? false : true;
    }

    public boolean d() {
        return this.o != null;
    }

    public boolean e() {
        return this.p != null;
    }

    public boolean f() {
        return this.l > 0;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public e j() {
        return this.j;
    }

    public Options k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public Object n() {
        return this.n;
    }

    public a o() {
        return this.o;
    }

    public a p() {
        return this.p;
    }

    public com.f.a.b.c.a q() {
        return this.q;
    }

    public Handler r() {
        return this.r;
    }

    boolean s() {
        return this.s;
    }
}
