package com.g.a.c;

import android.text.TextUtils;
import com.g.a.p;

public class a {
    private e a;
    private String b = com.xiaomi.e.a.f;
    private String c = com.xiaomi.e.a.f;
    private String d;
    private b e;

    public a(e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            r.b(p.e, "parameter is not valid");
            return;
        }
        this.a = eVar;
        this.b = str;
    }

    public String a() {
        return this.c;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(String str) {
        this.c = str;
    }

    public e b() {
        return this.a;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public b e() {
        return this.e;
    }

    public boolean f() {
        return (this.a == null || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public String toString() {
        return "UMPlatformData [meida=" + this.a + ", usid=" + this.b + ", weiboId=" + this.c + ", name=" + this.d + ", gender=" + this.e + "]";
    }
}
