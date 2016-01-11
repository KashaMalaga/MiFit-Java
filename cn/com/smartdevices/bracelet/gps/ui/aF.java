package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.a.b;
import com.huami.android.widget.share.p;

class aF implements p {
    final /* synthetic */ PaceDetailActivity a;

    aF(PaceDetailActivity paceDetailActivity) {
        this.a = paceDetailActivity;
    }

    public void a(int i) {
    }

    public void a(int i, int i2, String str) {
    }

    public void b(int i) {
        C0596r.e("PaceDetailActivity", "Share success:" + i);
        b.r(this.a);
    }
}
