package com.xiaomi.mistatistic.sdk.c;

import com.xiaomi.mipush.sdk.f;

public class h extends b {
    private long b;
    private long c;
    private String d;

    public h(long j, long j2, String str) {
        this.b = j;
        this.c = j2;
        this.d = str;
    }

    public i a() {
        i iVar = new i();
        iVar.a = b();
        iVar.b = this.a;
        iVar.e = this.b + f.i + this.c;
        iVar.f = this.d;
        return iVar;
    }

    public String b() {
        return "mistat_session";
    }
}
