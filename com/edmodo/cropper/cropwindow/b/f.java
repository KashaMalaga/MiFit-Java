package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.a.a;

class f extends d {
    private a a;

    f(a aVar) {
        super(null, aVar);
        this.a = aVar;
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        this.a.a(f, f2, rect, f4, f3);
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        a = (com.edmodo.cropper.a.a.b(a, a3, f3) - (a4 - a2)) / 2.0f;
        a2 -= a;
        a += a4;
        a.TOP.a(a2);
        a.BOTTOM.a(a);
        if (a.TOP.a(rect, f4) && !this.a.a(a.TOP, rect, f3)) {
            a.BOTTOM.b(-a.TOP.a(rect));
            this.a.c(f3);
        }
        if (a.BOTTOM.a(rect, f4) && !this.a.a(a.BOTTOM, rect, f3)) {
            a.TOP.b(-a.BOTTOM.a(rect));
            this.a.c(f3);
        }
    }
}
