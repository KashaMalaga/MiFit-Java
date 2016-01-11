package com.c.b.d.c;

import com.c.b.f;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.nio.charset.Charset;

final class h {
    int a;
    private final String b;
    private l c;
    private f d;
    private f e;
    private final StringBuilder f;
    private int g;
    private k h;
    private int i;

    h(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        int i = 0;
        int length = bytes.length;
        while (i < length) {
            char c = (char) (bytes[i] & HeartRateInfo.HR_EMPTY_VALUE);
            if (c != '?' || str.charAt(i) == '?') {
                stringBuilder.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.b = stringBuilder.toString();
        this.c = l.FORCE_NONE;
        this.f = new StringBuilder(str.length());
        this.g = -1;
    }

    private int m() {
        return this.b.length() - this.i;
    }

    public String a() {
        return this.b;
    }

    public void a(char c) {
        this.f.append(c);
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(l lVar) {
        this.c = lVar;
    }

    public void a(f fVar, f fVar2) {
        this.d = fVar;
        this.e = fVar2;
    }

    public void a(String str) {
        this.f.append(str);
    }

    public char b() {
        return this.b.charAt(this.a);
    }

    public void b(int i) {
        this.g = i;
    }

    public char c() {
        return this.b.charAt(this.a);
    }

    public void c(int i) {
        if (this.h == null || i > this.h.i()) {
            this.h = k.a(i, this.c, this.d, this.e, true);
        }
    }

    public StringBuilder d() {
        return this.f;
    }

    public int e() {
        return this.f.length();
    }

    public int f() {
        return this.g;
    }

    public void g() {
        this.g = -1;
    }

    public boolean h() {
        return this.a < m();
    }

    public int i() {
        return m() - this.a;
    }

    public k j() {
        return this.h;
    }

    public void k() {
        c(e());
    }

    public void l() {
        this.h = null;
    }
}
