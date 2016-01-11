package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class C0525g extends d {
    final /* synthetic */ GPSMainActivity a;

    C0525g(GPSMainActivity gPSMainActivity) {
        this.a = gPSMainActivity;
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.d("GPSMainActivity", "stop realtime hr:" + obj);
    }
}
