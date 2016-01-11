package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class p extends d {
    final /* synthetic */ HeartRateMainActivity a;

    p(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void a(Object obj) {
        C0596r.d("HeartRateMainActivity", "Manual measure heartrate cmd:" + ((Boolean) obj).booleanValue());
    }
}
