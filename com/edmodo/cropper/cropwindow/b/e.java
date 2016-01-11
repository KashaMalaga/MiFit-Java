package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.a.a;

class e extends d {
    private a a;

    e(a aVar) {
        super(aVar, null);
        this.a = aVar;
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        this.a.a(f, f2, rect, f4, f3);
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        a2 = (com.edmodo.cropper.a.a.a(a2, a.BOTTOM.a(), f3) - (a3 - a)) / 2.0f;
        a -= a2;
        a2 += a3;
        a.LEFT.a(a);
        a.RIGHT.a(a2);
        if (a.LEFT.a(rect, f4) && !this.a.a(a.LEFT, rect, f3)) {
            a.RIGHT.b(-a.LEFT.a(rect));
            this.a.c(f3);
        }
        if (a.RIGHT.a(rect, f4) && !this.a.a(a.RIGHT, rect, f3)) {
            a.LEFT.b(-a.RIGHT.a(rect));
            this.a.c(f3);
        }
    }
}
