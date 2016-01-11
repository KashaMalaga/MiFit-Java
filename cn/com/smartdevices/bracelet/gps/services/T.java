package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.TimerTask;

class T extends TimerTask {
    final /* synthetic */ R a;

    T(R r) {
        this.a = r;
    }

    public void run() {
        if (!this.a.q || this.a.h == null) {
            C0596r.e("SStep", "MStepTask mIsRtffstepNotSupported:" + this.a.q);
            return;
        }
        this.a.h.h();
        if (this.a.n != null && this.a.a != null) {
            this.a.a.postDelayed(this.a.n, 1000);
        }
    }
}
