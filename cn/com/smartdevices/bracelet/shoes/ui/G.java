package cn.com.smartdevices.bracelet.shoes.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.shoes.calibrate.a;
import cn.com.smartdevices.bracelet.shoes.calibrate.c;
import java.lang.ref.WeakReference;

final class G extends Handler {
    static final int a = 10;
    static final int b = 11;
    static final int c = 12;
    private WeakReference<ShoesCalibrateActivity> d = null;

    public G(ShoesCalibrateActivity shoesCalibrateActivity) {
        this.d = new WeakReference(shoesCalibrateActivity);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        ShoesCalibrateActivity shoesCalibrateActivity = (ShoesCalibrateActivity) this.d.get();
        if (shoesCalibrateActivity != null) {
            a c;
            switch (message.what) {
                case kankan.wheel.widget.a.l /*3*/:
                case kankan.wheel.widget.a.bt /*6*/:
                case kankan.wheel.widget.a.bc /*7*/:
                    shoesCalibrateActivity.a(false);
                    shoesCalibrateActivity.q();
                    return;
                case kankan.wheel.widget.a.X /*5*/:
                    shoesCalibrateActivity.d();
                    shoesCalibrateActivity.a(true);
                    shoesCalibrateActivity.r();
                    return;
                case a /*10*/:
                    shoesCalibrateActivity.l();
                    return;
                case b /*11*/:
                    c = shoesCalibrateActivity.i();
                    if (c != null) {
                        if (shoesCalibrateActivity.n()) {
                            shoesCalibrateActivity.b(false);
                            shoesCalibrateActivity.k();
                        }
                        c.a(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                case c /*12*/:
                    c = shoesCalibrateActivity.i();
                    if (c != null) {
                        c.a((c) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
