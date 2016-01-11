package com.xiaomi.account.openauth;

import android.os.Bundle;
import com.xiaomi.channel.gamesdk.b;

class n {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
    }

    private static n b(Bundle bundle) {
        return new n(l.d(bundle, h.I, h.aa), l.f(bundle, h.L, h.ae), l.d(bundle, h.M, h.aj), l.d(bundle, h.N, h.ak), l.d(bundle, h.O, h.ab), l.d(bundle, h.J, h.ac), l.d(bundle, h.K, h.ad), l.d(bundle, b.a, h.an));
    }

    public String toString() {
        return "accessToken=" + this.a + ",expiresIn=" + this.b + ",scope=" + this.c + ",state=" + this.d + ",tokenType=" + this.e + ",macKey=" + this.f + ",macAlogorithm=" + this.g + ",code=" + this.h;
    }
}
