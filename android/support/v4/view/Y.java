package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class Y {
    static final ab a;
    public static final int b = 255;
    public static final int c = 5;
    public static final int d = 6;
    public static final int e = 7;
    public static final int f = 8;
    public static final int g = 65280;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;

    static {
        if (VERSION.SDK_INT >= c) {
            a = new C0128aa();
        } else {
            a = new Z();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & b;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & g) >> h;
    }

    public static int b(MotionEvent motionEvent, int i) {
        return a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return a.c(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return a.a(motionEvent);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return a.d(motionEvent, i);
    }
}
