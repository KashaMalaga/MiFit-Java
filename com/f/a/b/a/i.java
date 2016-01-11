package com.f.a.b.a;

import android.widget.ImageView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum i {
    FIT_INSIDE,
    CROP;

    public static i a(ImageView imageView) {
        switch (j.a[imageView.getScaleType().ordinal()]) {
            case l.a /*1*/:
            case a.k /*2*/:
            case a.l /*3*/:
            case a.aQ /*4*/:
            case a.X /*5*/:
                return FIT_INSIDE;
            default:
                return CROP;
        }
    }
}
