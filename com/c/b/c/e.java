package com.c.b.c;

import java.util.List;

public final class e {
    private final byte[] a;
    private final String b;
    private final List<byte[]> c;
    private final String d;
    private Integer e;
    private Integer f;
    private Object g;
    private final int h;
    private final int i;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.a = bArr;
        this.b = str;
        this.c = list;
        this.d = str2;
        this.h = i2;
        this.i = i;
    }

    public void a(Integer num) {
        this.e = num;
    }

    public void a(Object obj) {
        this.g = obj;
    }

    public byte[] a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void b(Integer num) {
        this.f = num;
    }

    public List<byte[]> c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public Integer e() {
        return this.e;
    }

    public Integer f() {
        return this.f;
    }

    public Object g() {
        return this.g;
    }

    public boolean h() {
        return this.h >= 0 && this.i >= 0;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }
}
