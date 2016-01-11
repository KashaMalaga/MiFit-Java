package cn.com.smartdevices.bracelet;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class G extends Handler {
    final /* synthetic */ F a;

    G(F f) {
        this.a = f;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                F.h = false;
                new K(this.a, this.a.i).a();
                return;
            case l.a /*1*/:
                F.h = true;
                new J(this.a, this.a.i).b(message.getData().getStringArrayList("failed_datas"));
                return;
            default:
                return;
        }
    }
}
