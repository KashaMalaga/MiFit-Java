package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;

class C0747cw implements Runnable {
    final /* synthetic */ C0745cu a;

    C0747cw(C0745cu c0745cu) {
        this.a = c0745cu;
    }

    public void run() {
        if (b.h().n.a.booleanValue()) {
            Utils.a(false);
        }
    }
}
