package android.support.v4.view;

import android.view.View;

class C0157bZ {
    C0157bZ() {
    }

    public static void a(View view, cd cdVar) {
        view.animate().setUpdateListener(new ca(cdVar, view));
    }
}
