package cn.com.smartdevices.bracelet.tag.a;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.aj;
import cn.com.smartdevices.bracelet.C0596r;

class f extends Handler {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        C0596r.b(c.a, "EventHandler|command:" + i);
        switch (i) {
            case aj.I /*4097*/:
                this.a.l();
                return;
            case 4098:
                this.a.m();
                return;
            case aj.K /*4099*/:
                this.a.quit();
                return;
            case 4101:
                this.a.o();
                return;
            case 4102:
                this.a.n();
                return;
            case 4104:
                this.a.e();
                return;
            default:
                return;
        }
    }
}
