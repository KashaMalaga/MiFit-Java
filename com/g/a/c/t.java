package com.g.a.c;

import com.xiaomi.e.a;

public class t {
    private int a = -1;
    private String b = a.f;
    private String c = a.f;
    private Exception d = null;

    public t(int i) {
        this.a = i;
    }

    public t(int i, Exception exception) {
        this.a = i;
        this.d = exception;
    }

    public Exception a() {
        return this.d;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.a;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String toString() {
        return "status=" + this.a + "\r\n" + "msg:  " + this.b + "\r\n" + "data:  " + this.c;
    }
}
