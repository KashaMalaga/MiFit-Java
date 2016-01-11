package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class C0028ao extends EpicenterCallback {
    final /* synthetic */ C0030aq a;
    private Rect b;

    C0028ao(C0030aq c0030aq) {
        this.a = c0030aq;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.b == null && this.a.a != null) {
            this.b = C0025al.c(this.a.a);
        }
        return this.b;
    }
}
