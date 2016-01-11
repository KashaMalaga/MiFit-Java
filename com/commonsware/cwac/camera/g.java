package com.commonsware.cwac.camera;

import android.hardware.Camera.Size;
import java.util.Comparator;

class g implements Comparator<Size> {
    private g() {
    }

    public int a(Size size, Size size2) {
        int i = size.width * size.height;
        int i2 = size2.width * size2.height;
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Size) obj, (Size) obj2);
    }
}
