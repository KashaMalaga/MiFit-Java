package com.g.a.c;

import java.util.Locale;

enum d extends b {
    d(String str, int i, int i2) {
        super(str, i, i2);
    }

    public String toString() {
        return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.c)});
    }
}
