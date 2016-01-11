package android.support.v4.media;

import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class n implements OnWindowFocusChangeListener {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.a.d();
        } else {
            this.a.j();
        }
    }
}
