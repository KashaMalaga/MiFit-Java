package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.config.b;

class bU implements Runnable {
    final /* synthetic */ bS a;

    bU(bS bSVar) {
        this.a = bSVar;
    }

    public void run() {
        b.a(this.a.a.getApplicationContext());
    }
}
