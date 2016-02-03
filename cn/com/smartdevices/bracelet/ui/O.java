package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.a;

class O extends Handler {
    final /* synthetic */ BindWeixinActivityNew a;

    O(BindWeixinActivityNew bindWeixinActivityNew) {
        this.a = bindWeixinActivityNew;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.a();
                return;
            case a.k /*2*/:
                b.a(this.a, (int) R.string.bind_weixin_failed, 0).show();
                this.a.g();
                return;
            case a.l /*3*/:
                this.a.g();
                return;
            default:
                return;
        }
    }
}
