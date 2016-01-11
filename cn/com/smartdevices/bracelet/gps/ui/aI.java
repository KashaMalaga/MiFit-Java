package cn.com.smartdevices.bracelet.gps.ui;

import com.huami.android.widget.share.l;

class aI implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ aH b;

    aI(aH aHVar, l lVar) {
        this.b = aHVar;
        this.a = lVar;
    }

    public void run() {
        this.b.h.a(this.a);
    }
}
