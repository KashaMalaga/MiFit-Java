package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class s extends d {
    final /* synthetic */ HeartRateMainActivity a;

    s(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void a(Object obj) {
        C0596r.d("HeartRateMainActivity", "close manual measure heartrate cmd:" + ((Boolean) obj).booleanValue());
    }
}
