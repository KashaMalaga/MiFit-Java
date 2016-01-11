package com.g.a.c;

import java.util.Locale;

enum c extends b {
    c(String str, int i, int i2) {
        super(str, i, i2);
    }

    public String toString() {
        return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.c)});
    }
}
