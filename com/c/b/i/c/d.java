package com.c.b.i.c;

import com.c.b.i.a.q;

/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[q.values().length];

    static {
        try {
            a[q.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[q.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[q.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[q.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
