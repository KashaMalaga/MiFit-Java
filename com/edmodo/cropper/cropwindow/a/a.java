package com.edmodo.cropper.cropwindow.a;

import android.graphics.Rect;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import kankan.wheel.widget.l;

public enum a {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;
    
    public static final int e = 60;
    private float f;

    private static float a(float f, Rect rect, float f2, float f3) {
        float f4 = Float.POSITIVE_INFINITY;
        if (f - ((float) rect.left) < f2) {
            return (float) rect.left;
        }
        float a = f >= RIGHT.a() - BitmapDescriptorFactory.HUE_YELLOW ? RIGHT.a() - BitmapDescriptorFactory.HUE_YELLOW : Float.POSITIVE_INFINITY;
        if ((RIGHT.a() - f) / f3 <= BitmapDescriptorFactory.HUE_YELLOW) {
            f4 = RIGHT.a() - (BitmapDescriptorFactory.HUE_YELLOW * f3);
        }
        return Math.min(f, Math.min(a, f4));
    }

    private boolean a(float f, float f2, float f3, float f4, Rect rect) {
        return f < ((float) rect.top) || f2 < ((float) rect.left) || f3 > ((float) rect.bottom) || f4 > ((float) rect.right);
    }

    public static float b() {
        return RIGHT.a() - LEFT.a();
    }

    private static float b(float f, Rect rect, float f2, float f3) {
        float f4 = Float.NEGATIVE_INFINITY;
        if (((float) rect.right) - f < f2) {
            return (float) rect.right;
        }
        float a = f <= LEFT.a() + BitmapDescriptorFactory.HUE_YELLOW ? LEFT.a() + BitmapDescriptorFactory.HUE_YELLOW : Float.NEGATIVE_INFINITY;
        if ((f - LEFT.a()) / f3 <= BitmapDescriptorFactory.HUE_YELLOW) {
            f4 = LEFT.a() + (BitmapDescriptorFactory.HUE_YELLOW * f3);
        }
        return Math.max(f, Math.max(a, f4));
    }

    public static float c() {
        return BOTTOM.a() - TOP.a();
    }

    private static float c(float f, Rect rect, float f2, float f3) {
        float f4 = Float.POSITIVE_INFINITY;
        if (f - ((float) rect.top) < f2) {
            return (float) rect.top;
        }
        float a = f >= BOTTOM.a() - BitmapDescriptorFactory.HUE_YELLOW ? BOTTOM.a() - BitmapDescriptorFactory.HUE_YELLOW : Float.POSITIVE_INFINITY;
        if ((BOTTOM.a() - f) * f3 <= BitmapDescriptorFactory.HUE_YELLOW) {
            f4 = BOTTOM.a() - (BitmapDescriptorFactory.HUE_YELLOW / f3);
        }
        return Math.min(f, Math.min(a, f4));
    }

    private static float d(float f, Rect rect, float f2, float f3) {
        float f4 = Float.NEGATIVE_INFINITY;
        if (((float) rect.bottom) - f < f2) {
            return (float) rect.bottom;
        }
        float a = f <= TOP.a() + BitmapDescriptorFactory.HUE_YELLOW ? TOP.a() + BitmapDescriptorFactory.HUE_YELLOW : Float.NEGATIVE_INFINITY;
        if ((f - TOP.a()) * f3 <= BitmapDescriptorFactory.HUE_YELLOW) {
            f4 = TOP.a() + (BitmapDescriptorFactory.HUE_YELLOW / f3);
        }
        return Math.max(f, Math.max(f4, a));
    }

    public float a() {
        return this.f;
    }

    public float a(Rect rect) {
        float f = this.f;
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                this.f = (float) rect.left;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                this.f = (float) rect.top;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                this.f = (float) rect.right;
                break;
            case kankan.wheel.widget.a.aQ /*4*/:
                this.f = (float) rect.bottom;
                break;
        }
        return this.f - f;
    }

    public void a(float f) {
        this.f = f;
    }

    public void a(float f, float f2, Rect rect, float f3, float f4) {
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                this.f = a(f, rect, f3, f4);
                return;
            case kankan.wheel.widget.a.k /*2*/:
                this.f = c(f2, rect, f3, f4);
                return;
            case kankan.wheel.widget.a.l /*3*/:
                this.f = b(f, rect, f3, f4);
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                this.f = d(f2, rect, f3, f4);
                return;
            default:
                return;
        }
    }

    public void a(View view) {
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                this.f = 0.0f;
                return;
            case kankan.wheel.widget.a.k /*2*/:
                this.f = 0.0f;
                return;
            case kankan.wheel.widget.a.l /*3*/:
                this.f = (float) view.getWidth();
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                this.f = (float) view.getHeight();
                return;
            default:
                return;
        }
    }

    public boolean a(Rect rect, float f) {
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                return this.f - ((float) rect.left) < f;
            case kankan.wheel.widget.a.k /*2*/:
                return this.f - ((float) rect.top) < f;
            case kankan.wheel.widget.a.l /*3*/:
                return ((float) rect.right) - this.f < f;
            case kankan.wheel.widget.a.aQ /*4*/:
                return ((float) rect.bottom) - this.f < f;
            default:
                return false;
        }
    }

    public boolean a(a aVar, Rect rect, float f) {
        float b = aVar.b(rect);
        float f2;
        float a;
        float a2;
        float f3;
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                if (aVar.equals(TOP)) {
                    f2 = (float) rect.top;
                    a = BOTTOM.a() - b;
                    a2 = RIGHT.a();
                    return a(f2, com.edmodo.cropper.a.a.b(f2, a2, a, f), a, a2, rect);
                } else if (aVar.equals(BOTTOM)) {
                    a = (float) rect.bottom;
                    f2 = TOP.a() - b;
                    a2 = RIGHT.a();
                    return a(f2, com.edmodo.cropper.a.a.b(f2, a2, a, f), a, a2, rect);
                }
                break;
            case kankan.wheel.widget.a.k /*2*/:
                if (aVar.equals(LEFT)) {
                    f3 = (float) rect.left;
                    a2 = RIGHT.a() - b;
                    a = BOTTOM.a();
                    return a(com.edmodo.cropper.a.a.c(f3, a2, a, f), f3, a, a2, rect);
                } else if (aVar.equals(RIGHT)) {
                    a2 = (float) rect.right;
                    f3 = LEFT.a() - b;
                    a = BOTTOM.a();
                    return a(com.edmodo.cropper.a.a.c(f3, a2, a, f), f3, a, a2, rect);
                }
                break;
            case kankan.wheel.widget.a.l /*3*/:
                if (aVar.equals(TOP)) {
                    f2 = (float) rect.top;
                    a = BOTTOM.a() - b;
                    f3 = LEFT.a();
                    return a(f2, f3, a, com.edmodo.cropper.a.a.d(f3, f2, a, f), rect);
                } else if (aVar.equals(BOTTOM)) {
                    a = (float) rect.bottom;
                    f2 = TOP.a() - b;
                    f3 = LEFT.a();
                    return a(f2, f3, a, com.edmodo.cropper.a.a.d(f3, f2, a, f), rect);
                }
                break;
            case kankan.wheel.widget.a.aQ /*4*/:
                if (aVar.equals(LEFT)) {
                    f3 = (float) rect.left;
                    a2 = RIGHT.a() - b;
                    f2 = TOP.a();
                    return a(f2, f3, com.edmodo.cropper.a.a.e(f3, f2, a2, f), a2, rect);
                } else if (aVar.equals(RIGHT)) {
                    a2 = (float) rect.right;
                    f3 = LEFT.a() - b;
                    f2 = TOP.a();
                    return a(f2, f3, com.edmodo.cropper.a.a.e(f3, f2, a2, f), a2, rect);
                }
                break;
        }
        return true;
    }

    public float b(Rect rect) {
        float f;
        float f2 = this.f;
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                f = (float) rect.left;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                f = (float) rect.top;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                f = (float) rect.right;
                break;
            case kankan.wheel.widget.a.aQ /*4*/:
                f = (float) rect.bottom;
                break;
            default:
                f = f2;
                break;
        }
        return f - f2;
    }

    public void b(float f) {
        this.f += f;
    }

    public void c(float f) {
        float a = LEFT.a();
        float a2 = TOP.a();
        float a3 = RIGHT.a();
        float a4 = BOTTOM.a();
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                this.f = com.edmodo.cropper.a.a.b(a2, a3, a4, f);
                return;
            case kankan.wheel.widget.a.k /*2*/:
                this.f = com.edmodo.cropper.a.a.c(a, a3, a4, f);
                return;
            case kankan.wheel.widget.a.l /*3*/:
                this.f = com.edmodo.cropper.a.a.d(a, a2, a4, f);
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                this.f = com.edmodo.cropper.a.a.e(a, a2, a3, f);
                return;
            default:
                return;
        }
    }

    public boolean c(Rect rect) {
        switch (b.a[ordinal()]) {
            case l.a /*1*/:
                return ((double) (this.f - ((float) rect.left))) < 0.0d;
            case kankan.wheel.widget.a.k /*2*/:
                return ((double) (this.f - ((float) rect.top))) < 0.0d;
            case kankan.wheel.widget.a.l /*3*/:
                return ((double) (((float) rect.right) - this.f)) < 0.0d;
            case kankan.wheel.widget.a.aQ /*4*/:
                return ((double) (((float) rect.bottom) - this.f)) < 0.0d;
            default:
                return false;
        }
    }
}
