package com.xiaomi.c.a;

import java.net.URI;
import javax.net.ssl.SSLContext;

public final class O {
    private final URI a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final SSLContext h;
    private final boolean i;

    private O(URI uri, String str, String str2, String str3, String str4, String str5, int i, SSLContext sSLContext, boolean z) {
        this.a = uri;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = i;
        this.h = sSLContext;
        this.i = z;
    }

    public URI a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }
}
