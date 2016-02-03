package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Date;
import kankan.wheel.widget.a;

class l implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ HeartRateMainActivity c;

    l(HeartRateMainActivity heartRateMainActivity, boolean z, boolean z2) {
        this.c = heartRateMainActivity;
        this.a = z;
        this.b = z2;
    }

    public void run() {
        this.c.r.loadUrl("about:blank");
        this.c.r.setVisibility(4);
        this.c.q.setVisibility(0);
        this.c.u.setVisibility(8);
        if (this.a && HeartRateInfo.isHRValueValid(this.c.s)) {
            C0401a.a(this.c.b, C0401a.ha);
            this.c.u.setVisibility(4);
            this.c.d.c(35200.0f);
            this.c.w.setVisibility(0);
            this.c.v.setText(R.string.this_measure);
            this.c.t.setText(String.valueOf(this.c.s));
            HeartRateItem heartRateItem = new HeartRateItem(this.c.s, 2, new Date().getTime() / 1000, this.c.b(this.c.s));
            if (this.c.i == null) {
                this.c.i = new ArrayList();
                this.c.z.a(this.c.i);
            }
            this.c.i.add(0, heartRateItem);
            this.c.z.notifyDataSetChanged();
            if (!this.c.y.a(heartRateItem)) {
                C0596r.d("HeartRateMainActivity", "insert item error!");
            }
            this.c.d.c_();
            return;
        }
        C0401a.a(this.c.b, C0401a.gZ);
        this.c.C = new v(this.c);
        this.c.l.schedule(this.c.C, 0, 10);
        if (!this.b) {
            this.c.d.c(0.0f);
            this.c.x.setVisibility(0);
            this.c.v.setText(R.string.pre_measure);
            this.c.m.postDelayed(new m(this), a.bX);
        }
    }
}
