package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.a.b;
import com.huami.android.widget.share.p;

class D implements p {
    final /* synthetic */ GPSResultActivity a;

    D(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    public void a(int i) {
        C0596r.e("GPSResultActivity", "share onCancel:" + i);
    }

    public void a(int i, int i2, String str) {
        C0596r.e("GPSResultActivity", "share shareType:" + i + " errorCode:" + i2);
    }

    public void b(int i) {
        C0596r.e("GPSResultActivity", "share success -->" + i);
        b.s(this.a);
    }
}
