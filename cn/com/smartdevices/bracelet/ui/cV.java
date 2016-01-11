package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

class cV implements Runnable {
    final /* synthetic */ Boolean a;
    final /* synthetic */ cU b;

    cV(cU cUVar, Boolean bool) {
        this.b = cUVar;
        this.a = bool;
    }

    public void run() {
        Utils.a(this.b.a.getActivity());
        if (this.a.booleanValue()) {
            this.b.a.e();
        } else {
            this.b.a.v();
        }
    }
}
