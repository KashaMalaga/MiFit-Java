package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

class C0200x implements C0199w {
    C0200x() {
    }

    public int a(int i, int i2) {
        return -8388609 & i;
    }

    public void a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        Gravity.apply(i, i2, i3, rect, i4, i5, rect2);
    }

    public void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2);
    }

    public void a(int i, Rect rect, Rect rect2, int i2) {
        Gravity.applyDisplay(i, rect, rect2);
    }
}
