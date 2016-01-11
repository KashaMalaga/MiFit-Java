package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.DynamicManager;

class C0729ce implements Runnable {
    final /* synthetic */ MainUIActivity a;

    C0729ce(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void run() {
        DynamicManager.getInstance().analysisDynamic(this.a.E, true);
        this.a.runOnUiThread(new C0730cf(this));
    }
}
