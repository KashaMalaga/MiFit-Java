package cn.com.smartdevices.bracelet.lab.ui;

import com.tencent.connect.common.Constants;

class C0589y implements Runnable {
    final /* synthetic */ C0588x a;

    C0589y(C0588x c0588x) {
        this.a = c0588x;
    }

    public void run() {
        this.a.a.j.setText(Constants.VIA_RESULT_SUCCESS);
    }
}
