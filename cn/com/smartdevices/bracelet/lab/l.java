package cn.com.smartdevices.bracelet.lab;

import com.xiaomi.e.a;

public final class l {
    public static final String a = "LEFT_HAND";
    public static final String b = "RIGHT_HAND";
    public static final String c = "Reverse";
    public static final String d = "Front";
    private String e = a;
    private String f = c;
    private String g = a.f;
    private int h = 25;
    private String i = a.f;

    public l(String str) {
        this.i = str;
    }

    public l(String str, String str2, String str3) {
        this.f = str3;
        this.i = str;
        this.e = str2;
    }

    public l(String str, String str2, String str3, String str4, int i) {
        this.g = str4;
        this.f = str3;
        this.i = str;
        this.e = str2;
        this.h = i;
    }

    public String a() {
        return this.g;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.h;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.i;
    }
}
