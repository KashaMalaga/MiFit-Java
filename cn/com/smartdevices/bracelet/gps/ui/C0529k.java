package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.services.az;
import com.xiaomi.hm.health.b.a.n;
import java.lang.ref.WeakReference;

final class C0529k extends Handler {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 11;
    static final int e = 1;
    static final int f = 7;
    static final int g = 4;
    static final int h = 5;
    static final int i = 3;
    static final int j = 6;
    private WeakReference<GPSMainActivity> k = null;

    C0529k(GPSMainActivity gPSMainActivity) {
        this.k = new WeakReference(gPSMainActivity);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        GPSMainActivity gPSMainActivity = (GPSMainActivity) this.k.get();
        if (gPSMainActivity != null) {
            switch (message.what) {
                case e /*1*/:
                    gPSMainActivity.b((az) message.obj);
                    return;
                case c /*2*/:
                    gPSMainActivity.b(message.arg1);
                    return;
                case i /*3*/:
                    break;
                case g /*4*/:
                    gPSMainActivity.m();
                    return;
                case h /*5*/:
                    gPSMainActivity.g.setMyLocationType(c);
                    return;
                case j /*6*/:
                    gPSMainActivity.a(true, true);
                    return;
                case f /*7*/:
                    if (message.obj != null) {
                        gPSMainActivity.b(((Long) message.obj).longValue() / 1000);
                        return;
                    }
                    return;
                case d /*11*/:
                    gPSMainActivity.d(message.arg1, message.arg2);
                    break;
                default:
                    return;
            }
            if (gPSMainActivity.j == null) {
                return;
            }
            if (message.arg1 == 0) {
                gPSMainActivity.j.setVisibility(8);
            } else if (e == message.arg1) {
                gPSMainActivity.j.setVisibility(a);
                gPSMainActivity.j.setText(n.running_sport_state_sr_tips);
            }
        }
    }
}
