package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class C0193q {
    private final C0194r a;

    public C0193q(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C0193q(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.a = new C0197u(context, onGestureListener, handler);
        } else {
            this.a = new C0195s(context, onGestureListener, handler);
        }
    }

    public void a(OnDoubleTapListener onDoubleTapListener) {
        this.a.a(onDoubleTapListener);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public boolean a() {
        return this.a.a();
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
