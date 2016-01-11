package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import java.lang.ref.WeakReference;

final class J extends Handler {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private WeakReference<GPSResultActivity> d = null;

    public J(GPSResultActivity gPSResultActivity) {
        this.d = new WeakReference(gPSResultActivity);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void dispatchMessage(Message message) {
        GPSResultActivity gPSResultActivity = (GPSResultActivity) this.d.get();
        if (gPSResultActivity != null) {
            switch (message.what) {
                case a /*1*/:
                    C0596r.g("GPSResultActivity", "CONTOUR_TRACK_LOADED");
                    gPSResultActivity.a(new Bundle());
                    if (message.obj != null && (message.obj instanceof String)) {
                        gPSResultActivity.p = (String) message.obj;
                        gPSResultActivity.d(gPSResultActivity.p);
                        return;
                    }
                    return;
                case b /*2*/:
                    if (gPSResultActivity.w != null) {
                        gPSResultActivity.w.setVisibility(8);
                    }
                    if (gPSResultActivity.y != null) {
                        gPSResultActivity.y.setClickable(true);
                    }
                    if (gPSResultActivity.V != null) {
                        gPSResultActivity.V.setClickable(true);
                        return;
                    }
                    return;
                case c /*3*/:
                    gPSResultActivity.k();
                    return;
                default:
                    return;
            }
        }
    }
}
