package com.huami.android.zxing.a;

import android.hardware.Camera.Size;
import java.util.Comparator;

final class f implements Comparator<Size> {
    f() {
    }

    public int a(Size size, Size size2) {
        int i = size.height * size.width;
        int i2 = size2.height * size2.width;
        return i2 < i ? -1 : i2 > i ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Size) obj, (Size) obj2);
    }
}
