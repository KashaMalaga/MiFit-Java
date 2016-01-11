package cn.com.smartdevices.bracelet.gps.services;

import android.graphics.Path;
import android.support.v7.widget.af;
import java.util.ArrayList;
import java.util.List;

final class C0449h {
    private int a = Integer.MAX_VALUE;
    private int b = Integer.MAX_VALUE;
    private int c = af.a;
    private int d = af.a;
    private List<Path> e = null;

    private C0449h() {
    }

    private int a(int i, boolean z) {
        return z ? Math.max(0, Y.c() + i) + Y.b() : i - Y.a();
    }

    public static C0449h a(List<C0454m> list) {
        Path path = null;
        C0449h c0449h = new C0449h();
        for (C0454m a : list) {
            c0449h.a(a);
        }
        List arrayList = new ArrayList();
        Path path2 = null;
        for (C0454m a2 : list) {
            if (path2 == null) {
                path = new Path();
                path.moveTo((float) (a2.c() - c0449h.a), (float) (a2.d() - c0449h.b));
                arrayList.add(path);
                path2 = a2;
            } else {
                path.lineTo((float) (a2.c() - c0449h.a), (float) (a2.d() - c0449h.b));
            }
        }
        c0449h.e = arrayList;
        return c0449h;
    }

    private void a(C0454m c0454m) {
        if (this.a >= c0454m.c()) {
            this.a = a(c0454m.c(), false);
        }
        if (this.b >= c0454m.d()) {
            this.b = a(c0454m.d(), false);
        }
        if (this.c <= c0454m.c()) {
            this.c = a(c0454m.c(), true);
        }
        if (this.d <= c0454m.d()) {
            this.d = a(c0454m.d(), true);
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.clear();
        }
    }

    public int b() {
        return this.d - this.b;
    }

    public int[] c() {
        int i = this.c - this.a;
        int i2 = this.d - this.b;
        return new int[]{i, i2};
    }

    public int d() {
        return this.c - this.a;
    }
}
