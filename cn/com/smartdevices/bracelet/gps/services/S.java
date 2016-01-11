package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.TimerTask;

class S extends TimerTask {
    final /* synthetic */ R a;

    S(R r) {
        this.a = r;
    }

    public void run() {
        if (!this.a.d()) {
            C0596r.d("SStepM", "forceToGetStep INVALID_VALUE hwstatus :" + this.a.o);
        } else if (this.a.m != null && this.a.a != null) {
            this.a.a.post(this.a.m);
        }
    }
}
