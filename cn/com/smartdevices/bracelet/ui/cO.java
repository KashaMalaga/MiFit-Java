package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

class cO implements Runnable {
    final /* synthetic */ cN a;

    cO(cN cNVar) {
        this.a = cNVar;
    }

    public void run() {
        this.a.a.w();
        Utils.a(this.a.a.getActivity());
        this.a.a.l();
    }
}
