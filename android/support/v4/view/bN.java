package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class bN implements Runnable {
    WeakReference<View> a;
    bK b;
    final /* synthetic */ bM c;

    private bN(bM bMVar, bK bKVar, View view) {
        this.c = bMVar;
        this.a = new WeakReference(view);
        this.b = bKVar;
    }

    public void run() {
        this.c.f(this.b, (View) this.a.get());
    }
}
