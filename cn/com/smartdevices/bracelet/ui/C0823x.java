package cn.com.smartdevices.bracelet.ui;

import android.os.Looper;
import cn.com.smartdevices.bracelet.C0591m;
import com.xiaomi.hm.health.dataprocess.SportDay;

class C0823x implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ BaseSCActivity c;

    C0823x(BaseSCActivity baseSCActivity, int i, int i2) {
        this.c = baseSCActivity;
        this.a = i;
        this.b = i2;
    }

    public void run() {
        Looper.prepare();
        C0591m a = C0591m.a();
        a.i(new SportDay());
        a.a(this.a, this.b);
        if (this.c.u != null) {
            this.c.u.sendEmptyMessage(4098);
        }
    }
}
