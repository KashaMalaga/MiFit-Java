package com.xiaomi.c.a;

import java.net.URI;
import javax.net.ssl.SSLContext;

public final class Q {
    private final URI a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private SSLContext h;
    private Boolean i;

    private Q(URI uri, String str) {
        this.a = uri;
        this.b = str;
    }

    public static Q a(URI uri, String str) {
        if (uri == null) {
            throw new IllegalArgumentException("Connection manager URI must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("Target domain must not be null");
        } else {
            String scheme = uri.getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                return new Q(uri, str);
            }
            throw new IllegalArgumentException("Only 'http' and 'https' URI are allowed");
        }
    }

    public O a() {
        return new O(this.a, this.b, this.c, this.d == null ? "en" : this.d, this.e, this.f, this.f == null ? 0 : this.g, this.h, this.i == null ? false : this.i.booleanValue());
    }
}
