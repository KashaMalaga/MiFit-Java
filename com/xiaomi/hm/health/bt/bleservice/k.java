package com.xiaomi.hm.health.bt.bleservice;

import android.content.Context;
import android.content.Intent;

class k implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;
    final /* synthetic */ j c;

    k(j jVar, Context context, Intent intent) {
        this.c = jVar;
        this.a = context;
        this.b = intent;
    }

    public void run() {
        this.c.a.a(this.a, this.b);
    }
}
