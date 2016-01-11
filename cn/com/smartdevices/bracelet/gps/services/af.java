package cn.com.smartdevices.bracelet.gps.services;

import java.util.TimerTask;

class af extends TimerTask {
    final /* synthetic */ ad a;

    af(ad adVar) {
        this.a = adVar;
    }

    public void run() {
        this.a.d();
        if (this.a.f != null && this.a.a != null) {
            this.a.a.postDelayed(this.a.f, 1000);
        }
    }
}
