package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.DynamicView;

class aC implements Runnable {
    final /* synthetic */ C0694ax a;

    aC(C0694ax c0694ax) {
        this.a = c0694ax;
    }

    public void run() {
        if (this.a.z != PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            int a = this.a.b((int) PersonInfo.INCOMING_CALL_DISABLE_BIT, true);
            if (this.a.z == 0) {
                this.a.f(a);
            }
        }
        DynamicView f = this.a.o.f(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        if (f != null) {
            f.a(true);
            this.a.K = true;
            f.postDelayed(new aD(this, f), 6000);
        }
    }
}
