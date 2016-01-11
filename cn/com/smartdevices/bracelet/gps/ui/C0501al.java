package cn.com.smartdevices.bracelet.gps.ui;

import android.os.IBinder.DeathRecipient;
import cn.com.smartdevices.bracelet.C0596r;

class C0501al implements DeathRecipient {
    final /* synthetic */ C0500ak a;

    C0501al(C0500ak c0500ak) {
        this.a = c0500ak;
    }

    public void binderDied() {
        C0596r.e("UI", "binderDied");
        this.a.i = null;
    }
}
