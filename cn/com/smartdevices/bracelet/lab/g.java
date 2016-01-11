package cn.com.smartdevices.bracelet.lab;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.profile.a.o;

final class g extends Handler {
    static final int a = 1;
    final /* synthetic */ f b;

    public g(f fVar, Looper looper) {
        this.b = fVar;
        super(looper);
    }

    public void a() {
        removeMessages(a);
    }

    public void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case a /*1*/:
                if (message.arg1 != a) {
                    z = false;
                }
                if (z && this.b.e == null) {
                    this.b.e = new o(a.a());
                }
                if (this.b.e != null) {
                    this.b.e.a(z, this.b.a);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
