package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

class fi implements Runnable {
    final /* synthetic */ UnBindActivity a;

    fi(UnBindActivity unBindActivity) {
        this.a = unBindActivity;
    }

    public void run() {
        Utils.a(this.a);
        this.a.setResult(-1);
        this.a.finish();
    }
}
