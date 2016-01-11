package cn.com.smartdevices.bracelet.chart.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class n extends SimpleOnGestureListener {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.h = 0;
        this.a.j = 0;
        this.a.g.fling(this.a.h, this.a.j, (int) (-f), (int) (-f2), -5400, 5400, -5400, 5400);
        this.a.c(0);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }
}
