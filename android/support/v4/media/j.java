package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

class j implements Callback {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return h.a(i) ? this.a.b.a(i, keyEvent) : false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return h.a(i) ? this.a.b.b(i, keyEvent) : false;
    }
}
