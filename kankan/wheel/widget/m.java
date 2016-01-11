package kankan.wheel.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class m extends SimpleOnGestureListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.g = 0;
        this.a.f.fling(0, this.a.g, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.a.a(0);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }
}
