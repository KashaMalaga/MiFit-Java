package cn.com.smartdevices.bracelet.lab.ui;

import com.xiaomi.e.a;

class C0585u implements Runnable {
    final /* synthetic */ LabFactoryTestActivity a;

    C0585u(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void run() {
        this.a.j.setText(String.valueOf(this.a.w) + ((this.a.x ? " C" : a.f) + (cn.com.smartdevices.bracelet.lab.a.a.a ? " E" : a.f)));
    }
}
