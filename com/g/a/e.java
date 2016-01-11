package com.g.a;

import java.util.Locale;

enum e extends C1060b {
    e(String str, int i, int i2) {
        super(str, i, i2);
    }

    public String toString() {
        return String.format(Locale.US, "Unknown:%d", new Object[]{Integer.valueOf(this.d)});
    }
}
