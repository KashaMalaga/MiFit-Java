package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.account.openauth.h;

class am extends Handler {
    final /* synthetic */ StepsCountActivity a;

    am(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 4112:
                if (this.a.y > (this.a.p * h.E) + 250) {
                    StepsCountActivity.a.removeMessages(4112);
                    this.a.h.c_();
                    return;
                }
                this.a.h.c((float) this.a.y);
                StepsCountActivity.c(this.a, 100);
                Message obtain = Message.obtain();
                obtain.what = 4112;
                StepsCountActivity.a.sendMessageDelayed(obtain, 100);
                return;
            case 4115:
                this.a.k = message.arg1;
                this.a.c(this.a.k);
                return;
            default:
                return;
        }
    }
}
