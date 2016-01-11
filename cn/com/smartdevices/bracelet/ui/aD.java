package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.view.DynamicView;

class aD implements Runnable {
    final /* synthetic */ DynamicView a;
    final /* synthetic */ aC b;

    aD(aC aCVar, DynamicView dynamicView) {
        this.b = aCVar;
        this.a = dynamicView;
    }

    public void run() {
        this.a.a(false);
        this.b.a.K = false;
    }
}
