package cn.com.smartdevices.bracelet.weight.family;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;

class e extends Handler {
    final /* synthetic */ MemberInfoSetWeightActivity a;

    e(MemberInfoSetWeightActivity memberInfoSetWeightActivity) {
        this.a = memberInfoSetWeightActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 123) {
            this.a.n.setText(this.a.t + a.f);
            C0596r.e("MemberInfoSetWeightActivity", "mWeightText.setText " + this.a.t);
        }
    }
}
