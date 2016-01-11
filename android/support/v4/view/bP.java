package android.support.v4.view;

import android.view.View;

class bP implements cb {
    bK a;

    bP(bK bKVar) {
        this.a = bKVar;
    }

    public void a(View view) {
        if (this.a.g >= 0) {
            C0151az.a(view, 2, null);
        }
        if (this.a.e != null) {
            this.a.e.run();
        }
        Object tag = view.getTag(2113929216);
        cb cbVar = tag instanceof cb ? (cb) tag : null;
        if (cbVar != null) {
            cbVar.a(view);
        }
    }

    public void b(View view) {
        if (this.a.g >= 0) {
            C0151az.a(view, this.a.g, null);
            this.a.g = -1;
        }
        if (this.a.f != null) {
            this.a.f.run();
        }
        Object tag = view.getTag(2113929216);
        cb cbVar = tag instanceof cb ? (cb) tag : null;
        if (cbVar != null) {
            cbVar.b(view);
        }
    }

    public void c(View view) {
        Object tag = view.getTag(2113929216);
        cb cbVar = tag instanceof cb ? (cb) tag : null;
        if (cbVar != null) {
            cbVar.c(view);
        }
    }
}
