package cn.com.smartdevices.bracelet.ui;

import android.content.Context;

class dK implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ dE b;

    dK(dE dEVar, Context context) {
        this.b = dEVar;
        this.a = context;
    }

    public void run() {
        this.b.b(this.a);
    }
}
