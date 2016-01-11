package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;

class a extends d {
    a() {
        super(null, null);
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        a(f, f2, rect, f4);
    }

    void a(float f, float f2, Rect rect, float f3) {
        float a = com.edmodo.cropper.cropwindow.a.a.LEFT.a();
        float a2 = com.edmodo.cropper.cropwindow.a.a.TOP.a();
        a = f - ((a + com.edmodo.cropper.cropwindow.a.a.RIGHT.a()) / 2.0f);
        a2 = f2 - ((a2 + com.edmodo.cropper.cropwindow.a.a.BOTTOM.a()) / 2.0f);
        com.edmodo.cropper.cropwindow.a.a.LEFT.b(a);
        com.edmodo.cropper.cropwindow.a.a.TOP.b(a2);
        com.edmodo.cropper.cropwindow.a.a.RIGHT.b(a);
        com.edmodo.cropper.cropwindow.a.a.BOTTOM.b(a2);
        if (com.edmodo.cropper.cropwindow.a.a.LEFT.a(rect, f3)) {
            com.edmodo.cropper.cropwindow.a.a.RIGHT.b(com.edmodo.cropper.cropwindow.a.a.LEFT.a(rect));
        } else if (com.edmodo.cropper.cropwindow.a.a.RIGHT.a(rect, f3)) {
            com.edmodo.cropper.cropwindow.a.a.LEFT.b(com.edmodo.cropper.cropwindow.a.a.RIGHT.a(rect));
        }
        if (com.edmodo.cropper.cropwindow.a.a.TOP.a(rect, f3)) {
            com.edmodo.cropper.cropwindow.a.a.BOTTOM.b(com.edmodo.cropper.cropwindow.a.a.TOP.a(rect));
        } else if (com.edmodo.cropper.cropwindow.a.a.BOTTOM.a(rect, f3)) {
            com.edmodo.cropper.cropwindow.a.a.TOP.b(com.edmodo.cropper.cropwindow.a.a.BOTTOM.a(rect));
        }
    }
}
