package android.support.v4.app;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class N extends Handler {
    final /* synthetic */ FragmentActivity a;

    N(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                if (this.a.i) {
                    this.a.a(false);
                    return;
                }
                return;
            case a.k /*2*/:
                this.a.d();
                this.a.e.j();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
