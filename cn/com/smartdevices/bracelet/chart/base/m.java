package cn.com.smartdevices.bracelet.chart.base;

import android.os.Handler;
import android.os.Message;

class m extends Handler {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void handleMessage(Message message) {
        this.a.g.computeScrollOffset();
        int currX = this.a.g.getCurrX();
        int b = this.a.h - currX;
        this.a.h = currX;
        if (b != 0) {
            this.a.d.a(b);
        }
        b = this.a.g.getCurrY();
        int d = this.a.j - b;
        this.a.j = b;
        if (d != 0) {
            this.a.d.b(d);
        }
        if (this.a.m && Math.abs(currX - this.a.g.getFinalX()) < 1) {
            this.a.g.getFinalX();
            this.a.g.forceFinished(true);
        }
        if (!this.a.m && Math.abs(b - this.a.g.getFinalY()) < 1) {
            this.a.g.getFinalY();
            this.a.g.forceFinished(true);
        }
        if (!this.a.g.isFinished()) {
            this.a.n.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.a.d();
        } else {
            this.a.a();
        }
    }
}
