package com.xiaomi.hm.health.bt.profile.a;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.hm.health.bt.a.z;
import kankan.wheel.widget.a;

class e extends Handler {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                new z(new f(this)).g();
                sendEmptyMessageDelayed(0, 15000);
                return;
            default:
                return;
        }
    }
}
