package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class C0026am extends EpicenterCallback {
    final /* synthetic */ Rect a;

    C0026am(Rect rect) {
        this.a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
