package cn.com.smartdevices.bracelet.ui;

import a.a.a.G;
import cn.com.smartdevices.bracelet.C0596r;

class fk implements G {
    final /* synthetic */ UnlockScreenHelperActivity a;

    fk(UnlockScreenHelperActivity unlockScreenHelperActivity) {
        this.a = unlockScreenHelperActivity;
    }

    public void a(int i) {
        C0596r.d("unlockscreen", "onState state = " + i);
        if (i == 4) {
            this.a.x.a(this.a.H);
        }
    }
}
