package cn.com.smartdevices.bracelet.ui;

import a.a.a.C0002K;
import cn.com.smartdevices.bracelet.C0596r;

class fl implements C0002K {
    final /* synthetic */ UnlockScreenHelperActivity a;

    fl(UnlockScreenHelperActivity unlockScreenHelperActivity) {
        this.a = unlockScreenHelperActivity;
    }

    public void a(byte b) {
        C0596r.d("unlockscreen", "onUnlocked state = " + b);
    }
}
