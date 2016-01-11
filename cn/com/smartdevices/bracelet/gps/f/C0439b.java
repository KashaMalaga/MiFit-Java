package cn.com.smartdevices.bracelet.gps.f;

import android.os.IBinder.DeathRecipient;

class C0439b implements DeathRecipient {
    final /* synthetic */ C0438a a;

    C0439b(C0438a c0438a) {
        this.a = c0438a;
    }

    public void binderDied() {
        if (this.a.e != null) {
            this.a.e.a(f.SERVICE_DIED);
        }
    }
}
