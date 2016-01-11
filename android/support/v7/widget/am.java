package android.support.v7.widget;

import android.view.View;

class am {
    am() {
    }

    static int a(ag agVar, D d, View view, View view2, W w, boolean z) {
        if (w.y() == 0 || agVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(w.e(view) - w.e(view2)) + 1;
        }
        return Math.min(d.f(), d.b(view2) - d.a(view));
    }

    static int a(ag agVar, D d, View view, View view2, W w, boolean z, boolean z2) {
        if (w.y() == 0 || agVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (agVar.h() - Math.max(w.e(view), w.e(view2))) - 1) : Math.max(0, Math.min(w.e(view), w.e(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(d.b(view2) - d.a(view))) / ((float) (Math.abs(w.e(view) - w.e(view2)) + 1)))) + ((float) (d.c() - d.a(view))));
    }

    static int b(ag agVar, D d, View view, View view2, W w, boolean z) {
        if (w.y() == 0 || agVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return agVar.h();
        }
        return (int) ((((float) (d.b(view2) - d.a(view))) / ((float) (Math.abs(w.e(view) - w.e(view2)) + 1))) * ((float) agVar.h()));
    }
}
