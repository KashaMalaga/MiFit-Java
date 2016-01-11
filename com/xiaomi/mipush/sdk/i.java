package com.xiaomi.mipush.sdk;

import java.util.List;

public class i implements k {
    private static final long serialVersionUID = 1;
    private String a;
    private long b;
    private String c;
    private List<String> d;
    private String e;

    public String a() {
        return this.a;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<String> list) {
        this.d = list;
    }

    public List<String> b() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    public long c() {
        return this.b;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "command={" + this.a + "}, resultCode={" + this.b + "}, reason={" + this.c + "}, category={" + this.e + "}, commandArguments={" + this.d + "}";
    }
}
