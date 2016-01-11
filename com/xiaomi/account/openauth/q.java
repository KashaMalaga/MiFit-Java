package com.xiaomi.account.openauth;

import android.content.Context;

class q extends o<String> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ long d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ p h;

    q(p pVar, Context context, String str, long j, String str2, String str3, String str4) {
        this.h = pVar;
        this.a = context;
        this.b = str;
        this.d = j;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public void a() {
        try {
            this.c.set(C1068b.a(this.a, this.b, this.d, this.e, this.f, this.g));
        } catch (Throwable e) {
            this.c.setException(e);
        }
    }
}
