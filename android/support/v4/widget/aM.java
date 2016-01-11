package android.support.v4.widget;

import android.support.v4.view.C0151az;
import android.view.View;

class aM implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    aM(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    public void run() {
        if (this.a.getParent() == this.b) {
            C0151az.a(this.a, 0, null);
            this.b.g(this.a);
        }
        this.b.y.remove(this);
    }
}
