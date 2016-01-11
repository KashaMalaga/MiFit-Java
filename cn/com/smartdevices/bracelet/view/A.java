package cn.com.smartdevices.bracelet.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import cn.com.smartdevices.bracelet.C0596r;

class A extends SimpleOnGestureListener {
    final /* synthetic */ RulerScrollView a;

    A(RulerScrollView rulerScrollView) {
        this.a = rulerScrollView;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        super.onFling(motionEvent, motionEvent2, f, f2);
        this.a.fling((int) f);
        C0596r.e("RulerScrollView", "fling end, vX:" + f);
        RulerScrollView.q.postDelayed(new B(this), 500);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }
}
