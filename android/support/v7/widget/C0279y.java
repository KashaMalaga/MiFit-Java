package android.support.v7.widget;

import android.util.Log;
import android.view.View;
import java.util.List;

class C0279y {
    static final String a = "LinearLayoutManager#LayoutState";
    static final int b = -1;
    static final int c = 1;
    static final int d = Integer.MIN_VALUE;
    static final int e = -1;
    static final int f = 1;
    static final int g = Integer.MIN_VALUE;
    boolean h = true;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o = 0;
    boolean p = false;
    List<aj> q = null;

    C0279y() {
    }

    private View b() {
        aj ajVar;
        int size = this.q.size();
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        aj ajVar2 = null;
        while (i2 < size) {
            int i3;
            aj ajVar3;
            ajVar = (aj) this.q.get(i2);
            if (this.p || !ajVar.r()) {
                int d = (ajVar.d() - this.k) * this.l;
                if (d < 0) {
                    i3 = i;
                    ajVar3 = ajVar2;
                } else if (d >= i) {
                    i3 = i;
                    ajVar3 = ajVar2;
                } else if (d == 0) {
                    break;
                } else {
                    ajVar3 = ajVar;
                    i3 = d;
                }
            } else {
                i3 = i;
                ajVar3 = ajVar2;
            }
            i2 += f;
            ajVar2 = ajVar3;
            i = i3;
        }
        ajVar = ajVar2;
        if (ajVar == null) {
            return null;
        }
        this.k = ajVar.d() + this.l;
        return ajVar.a;
    }

    View a(aa aaVar) {
        if (this.q != null) {
            return b();
        }
        View c = aaVar.c(this.k);
        this.k += this.l;
        return c;
    }

    void a() {
        Log.d(a, "avail:" + this.j + ", ind:" + this.k + ", dir:" + this.l + ", offset:" + this.i + ", layoutDir:" + this.m);
    }

    boolean a(ag agVar) {
        return this.k >= 0 && this.k < agVar.h();
    }
}
