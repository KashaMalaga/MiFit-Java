package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.a.a;
import com.edmodo.cropper.cropwindow.a.c;

abstract class d {
    private static final float a = 1.0f;
    private a b;
    private a c;
    private c d = new c(this.b, this.c);

    d(a aVar, a aVar2) {
        this.b = aVar;
        this.c = aVar2;
    }

    private float a(float f, float f2) {
        float a = this.c == a.LEFT ? f : a.LEFT.a();
        float a2 = this.b == a.TOP ? f2 : a.TOP.a();
        if (this.c != a.RIGHT) {
            f = a.RIGHT.a();
        }
        if (this.b != a.BOTTOM) {
            f2 = a.BOTTOM.a();
        }
        return com.edmodo.cropper.a.a.a(a, a2, f, f2);
    }

    c a() {
        return this.d;
    }

    c a(float f, float f2, float f3) {
        if (a(f, f2) > f3) {
            this.d.a = this.c;
            this.d.b = this.b;
        } else {
            this.d.a = this.b;
            this.d.b = this.c;
        }
        return this.d;
    }

    abstract void a(float f, float f2, float f3, Rect rect, float f4);

    void a(float f, float f2, Rect rect, float f3) {
        c a = a();
        a aVar = a.a;
        a aVar2 = a.b;
        if (aVar != null) {
            aVar.a(f, f2, rect, f3, (float) a);
        }
        if (aVar2 != null) {
            aVar2.a(f, f2, rect, f3, (float) a);
        }
    }
}
