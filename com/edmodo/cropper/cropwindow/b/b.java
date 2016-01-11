package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.a.a;
import com.edmodo.cropper.cropwindow.a.c;

class b extends d {
    b(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        c a = a(f, f2, f3);
        a aVar = a.a;
        a aVar2 = a.b;
        aVar.a(f, f2, rect, f4, f3);
        aVar2.c(f3);
        if (aVar2.a(rect, f4)) {
            aVar2.a(rect);
            aVar.c(f3);
        }
    }
}
