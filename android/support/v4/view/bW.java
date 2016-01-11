package android.support.v4.view;

import android.view.View;

class bW {
    bW() {
    }

    public static void a(View view) {
        view.animate().withLayer();
    }

    public static void a(View view, cb cbVar) {
        if (cbVar != null) {
            view.animate().setListener(new bX(cbVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void a(View view, Runnable runnable) {
        view.animate().withStartAction(runnable);
    }

    public static void b(View view, Runnable runnable) {
        view.animate().withEndAction(runnable);
    }
}
