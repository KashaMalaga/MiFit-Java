package kankan.wheel.widget;

import android.os.Handler;
import android.os.Message;

class n extends Handler {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public void handleMessage(Message message) {
        this.a.f.computeScrollOffset();
        int currY = this.a.f.getCurrY();
        int a = this.a.g - currY;
        this.a.g = currY;
        if (a != 0) {
            this.a.c.a(a);
        }
        if (Math.abs(currY - this.a.f.getFinalY()) < 1) {
            this.a.f.getFinalY();
            this.a.f.forceFinished(true);
        }
        if (!this.a.f.isFinished()) {
            this.a.m.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.a.d();
        } else {
            this.a.b();
        }
    }
}
