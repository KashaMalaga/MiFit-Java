package android.support.v4.media;

import android.view.ViewTreeObserver.OnWindowAttachListener;

class m implements OnWindowAttachListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void onWindowAttached() {
        this.a.c();
    }

    public void onWindowDetached() {
        this.a.k();
    }
}
