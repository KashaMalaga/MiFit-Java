package cn.com.smartdevices.bracelet.weibo;

import android.os.Handler;
import android.os.Message;
import com.huami.android.view.b;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0855b extends Handler {
    final /* synthetic */ BindHealthActivity a;

    C0855b(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.a(((Integer) message.obj).intValue());
                return;
            case a.k /*2*/:
                b.a(this.a, this.a.getString(message.arg1), 1).show();
                return;
            case a.l /*3*/:
                int i = message.arg1;
                if (i == 0) {
                    this.a.g.setClickable(true);
                }
                if (i == 1) {
                    this.a.g.setClickable(false);
                    return;
                }
                return;
            case a.aQ /*4*/:
                b.a(this.a, (String) message.obj, 1).show();
                return;
            default:
                return;
        }
    }
}
