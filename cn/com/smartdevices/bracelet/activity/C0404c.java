package cn.com.smartdevices.bracelet.activity;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.R;

class C0404c extends Handler {
    final /* synthetic */ LoginActivity a;

    C0404c(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                Utils.a(this.a.p, (int) R.string.wait);
                return;
            case EventScaleStatus.SCALE_FOUNDED /*257*/:
                this.a.a(this.a.q);
                return;
            default:
                return;
        }
    }
}
