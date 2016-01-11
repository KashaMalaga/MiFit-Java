package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import com.huami.android.view.b;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;
import kankan.wheel.widget.i;
import kankan.wheel.widget.l;

class J extends Handler {
    final /* synthetic */ BindWeixinActivity a;

    J(BindWeixinActivity bindWeixinActivity) {
        this.a = bindWeixinActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.e();
                return;
            case l.a /*1*/:
                this.a.f();
                return;
            case a.k /*2*/:
                b.a(this.a, (int) r.bind_weixin_failed, 0).show();
                this.a.i();
                return;
            case a.l /*3*/:
                this.a.g();
                this.a.i();
                return;
            case a.aQ /*4*/:
                b.a(this.a, this.a.getString(r.bind_weixin_save) + this.a.getString(i.app_name), 0).show();
                this.a.a(1);
                this.a.l.setEnabled(false);
                return;
            case a.X /*5*/:
                this.a.a();
                this.a.l.setEnabled(true);
                return;
            default:
                return;
        }
    }
}
