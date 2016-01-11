package com.f.a.b;

import com.f.a.b.d.d;

/* synthetic */ class k {
    static final /* synthetic */ int[] a = new int[d.values().length];

    static {
        try {
            a[d.HTTP.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[d.HTTPS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
