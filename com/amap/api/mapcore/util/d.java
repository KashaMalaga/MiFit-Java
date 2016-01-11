package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.amap.api.maps.model.GroundOverlayOptions;

public abstract class d extends a {
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    private final float l;
    private float m;
    private float n;
    private float o;
    private float p;

    public d(Context context) {
        super(context);
        this.l = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float a(MotionEvent motionEvent, int i) {
        return i < motionEvent.getPointerCount() ? (motionEvent.getRawX() - motionEvent.getX()) + motionEvent.getX(i) : 0.0f;
    }

    protected static float b(MotionEvent motionEvent, int i) {
        return i < motionEvent.getPointerCount() ? (motionEvent.getRawY() - motionEvent.getY()) + motionEvent.getY(i) : 0.0f;
    }

    protected void b(MotionEvent motionEvent) {
        super.b(motionEvent);
        if (this.c != null) {
            MotionEvent motionEvent2 = this.c;
            this.o = GroundOverlayOptions.NO_DIMENSION;
            this.p = GroundOverlayOptions.NO_DIMENSION;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1) - y;
            this.h = x2 - x;
            this.i = y2;
            y2 = motionEvent.getX(0);
            x = motionEvent.getY(0);
            x = motionEvent.getY(1) - x;
            this.j = motionEvent.getX(1) - y2;
            this.k = x;
        }
    }

    public float c() {
        if (this.o == GroundOverlayOptions.NO_DIMENSION) {
            float f = this.j;
            float f2 = this.k;
            this.o = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.o;
    }

    protected boolean d(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.m = ((float) displayMetrics.widthPixels) - this.l;
        this.n = ((float) displayMetrics.heightPixels) - this.l;
        float f = this.l;
        float f2 = this.m;
        float f3 = this.n;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = a(motionEvent, 1);
        float b = b(motionEvent, 1);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2 = a < f || b < f || a > f2 || b > f3;
        return z || z2;
    }
}
