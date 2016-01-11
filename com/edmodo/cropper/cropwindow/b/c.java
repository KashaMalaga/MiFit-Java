package com.edmodo.cropper.cropwindow.b;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.a.a;

public enum c {
    TOP_LEFT(new b(a.TOP, a.LEFT)),
    TOP_RIGHT(new b(a.TOP, a.RIGHT)),
    BOTTOM_LEFT(new b(a.BOTTOM, a.LEFT)),
    BOTTOM_RIGHT(new b(a.BOTTOM, a.RIGHT)),
    LEFT(new f(a.LEFT)),
    TOP(new e(a.TOP)),
    RIGHT(new f(a.RIGHT)),
    BOTTOM(new e(a.BOTTOM)),
    CENTER(new a());
    
    private d j;

    private c(d dVar) {
        this.j = dVar;
    }

    public void a(float f, float f2, float f3, Rect rect, float f4) {
        this.j.a(f, f2, f3, rect, f4);
    }

    public void a(float f, float f2, Rect rect, float f3) {
        this.j.a(f, f2, rect, f3);
    }
}
