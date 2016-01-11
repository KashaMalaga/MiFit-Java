package cn.com.smartdevices.bracelet;

import android.content.Context;
import com.xiaomi.hm.health.bt.a.C1115b;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

final class E extends TimerTask {
    final /* synthetic */ WeakReference a;

    E(WeakReference weakReference) {
        this.a = weakReference;
    }

    public void run() {
        if (this.a.get() != null) {
            C0401a.a((Context) this.a.get(), C0401a.eJ);
        }
        PhoneStateReceiver.d = new C1115b((byte) 2, null);
        PhoneStateReceiver.d.g();
    }
}
