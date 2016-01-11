package com.f.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.f.a.a.a.b;
import com.f.a.a.b.c;
import com.f.a.b.a.h;
import com.f.a.b.b.d;
import com.f.a.b.g.a;
import com.f.a.c.f;
import java.util.concurrent.Executor;

public final class j {
    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final a f;
    final Executor g;
    final Executor h;
    final boolean i;
    final boolean j;
    final int k;
    final int l;
    final h m;
    final c n;
    final b o;
    final com.f.a.b.d.c p;
    final d q;
    final d r;
    final com.f.a.b.d.c s;
    final com.f.a.b.d.c t;

    private j(l lVar) {
        this.a = lVar.h.getResources();
        this.b = lVar.i;
        this.c = lVar.j;
        this.d = lVar.k;
        this.e = lVar.l;
        this.f = lVar.m;
        this.g = lVar.n;
        this.h = lVar.o;
        this.k = lVar.r;
        this.l = lVar.s;
        this.m = lVar.u;
        this.o = lVar.z;
        this.n = lVar.y;
        this.r = lVar.D;
        this.p = lVar.B;
        this.q = lVar.C;
        this.i = lVar.p;
        this.j = lVar.q;
        this.s = new m(this.p);
        this.t = new n(this.p);
        f.a(lVar.E);
    }

    public static j a(Context context) {
        return new l(context).c();
    }

    com.f.a.b.a.f a() {
        DisplayMetrics displayMetrics = this.a.getDisplayMetrics();
        int i = this.b;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.c;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new com.f.a.b.a.f(i, i2);
    }
}
