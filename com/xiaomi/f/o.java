package com.xiaomi.f;

import com.xiaomi.channel.a.c.a;
import java.util.Map;

public class o implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    private String b;
    private String c;
    private int d;
    private boolean e = l.c;
    private boolean f = true;
    private String g;
    private q h;

    public o(Map<String, Integer> map, int i, String str, q qVar) {
        a(map, i, str, qVar);
    }

    private void a(Map<String, Integer> map, int i, String str, q qVar) {
        this.c = d();
        this.d = i;
        this.b = str;
        this.h = qVar;
    }

    public static final String d() {
        return a.e ? a : a.a() ? "sandbox.xmpush.xiaomi.com" : a.b() ? "10.237.12.17" : a.b ? "58.68.235.106" : "app.chat.xiaomi.net";
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.d;
    }

    public String h() {
        return this.c;
    }

    public boolean i() {
        return this.e;
    }
}
