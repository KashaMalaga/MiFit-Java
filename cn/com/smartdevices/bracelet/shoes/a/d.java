package cn.com.smartdevices.bracelet.shoes.a;

import com.xiaomi.e.a;

public final class d {
    private String a = a.f;
    private String b = a.f;
    private String c = a.f;

    public d(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "brand:" + this.a + ",mac:" + this.b + ",sn:" + this.c;
    }
}
