package cn.com.smartdevices.bracelet.lab.ui.view;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;

final class c extends Handler {
    public static final int a = 2;
    public static final int b = 1;
    public static final int c = 3;
    public static final int d = 4;
    final /* synthetic */ LabCircleView e;

    private c(LabCircleView labCircleView) {
        this.e = labCircleView;
    }

    public void a() {
        removeMessages(b);
        removeMessages(a);
        removeMessages(c);
        removeMessages(d);
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case b /*1*/:
                if (this.e.e == null) {
                    if (message.arg1 >= d) {
                        this.e.e = this.e.a(1.0f, this.e.b.a()).setDuration(2000);
                    } else {
                        this.e.e = this.e.a(1.0f, this.e.b.a()).setDuration(1000);
                    }
                    this.e.e.start();
                    return;
                }
                return;
            case a /*2*/:
                if (this.e.d == null) {
                    this.e.g.removeMessages(a);
                    this.e.b.a(90);
                    this.e.d = this.e.b(1.0f).setDuration(a.bX);
                    this.e.d.start();
                    return;
                }
                return;
            case c /*3*/:
                this.e.e = null;
                return;
            case d /*4*/:
                this.e.d = null;
                return;
            default:
                return;
        }
    }
}
