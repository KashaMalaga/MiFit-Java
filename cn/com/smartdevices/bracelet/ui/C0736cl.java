package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.DynamicManager;

class C0736cl implements Runnable {
    final /* synthetic */ MainUIActivity a;

    C0736cl(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void run() {
        DynamicManager.getInstance().a(this.a.E);
        this.a.runOnUiThread(new C0737cm(this));
    }
}
