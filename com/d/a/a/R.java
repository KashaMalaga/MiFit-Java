package com.d.a.a;

import java.io.InputStream;

public class R {
    public final InputStream a;
    public final String b;
    public final String c;
    public final boolean d;

    public R(InputStream inputStream, String str, String str2, boolean z) {
        this.a = inputStream;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    static R a(InputStream inputStream, String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = O.a;
        }
        return new R(inputStream, str, str2, z);
    }
}
