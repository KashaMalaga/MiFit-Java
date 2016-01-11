package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class C0197u implements C0194r {
    private final GestureDetector a;

    public C0197u(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.a = new GestureDetector(context, onGestureListener, handler);
    }

    public void a(OnDoubleTapListener onDoubleTapListener) {
        this.a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void a(boolean z) {
        this.a.setIsLongpressEnabled(z);
    }

    public boolean a() {
        return this.a.isLongpressEnabled();
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
