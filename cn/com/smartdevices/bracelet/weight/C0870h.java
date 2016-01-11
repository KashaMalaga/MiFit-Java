package cn.com.smartdevices.bracelet.weight;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;

class C0870h extends Handler {
    final /* synthetic */ BabyWeightActivity a;

    C0870h(BabyWeightActivity babyWeightActivity) {
        this.a = babyWeightActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 291) {
            this.a.g.setText(this.a.z + a.f);
            this.a.h.setText(aA.a(this.a.o, this.a.t));
            C0596r.e("BabyWeightActivity", "mWeightText.setText " + this.a.z);
        } else if (message.what == 564) {
            C0596r.e("BabyWeightActivity", "MESSAGE_UPDATE_VIEW");
            this.a.b();
        }
    }
}
