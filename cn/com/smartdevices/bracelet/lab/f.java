package cn.com.smartdevices.bracelet.lab;

import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.bt.profile.a.o;

class f {
    final /* synthetic */ d a;
    private j b = null;
    private volatile Looper c = null;
    private volatile g d = null;
    private o e = null;

    public f(d dVar) {
        this.a = dVar;
        c();
    }

    private void c() {
        this.d = new g(this, Looper.getMainLooper());
    }

    public void a() {
        if (this.d != null) {
            this.d.a();
        }
        if (this.c != null) {
            this.c.quit();
        }
    }

    public void a(boolean z) {
        int i = 1;
        this.b = a.a();
        if (this.b == null || !this.b.u()) {
            C0596r.e("Lab", "BraceletOpState.OFFLINE !mProfile.isConnected");
            this.a.b = 0;
        } else {
            this.a.b = 1;
        }
        if (this.a.b == 0) {
            this.a.b(0);
            return;
        }
        Message obtainMessage = this.d.obtainMessage();
        obtainMessage.what = 1;
        if (!z) {
            i = 0;
        }
        obtainMessage.arg1 = i;
        this.d.sendMessage(obtainMessage);
    }

    public int b() {
        return this.a.b;
    }
}
