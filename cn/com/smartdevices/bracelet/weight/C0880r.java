package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import kankan.wheel.widget.a;

class C0880r implements E {
    final /* synthetic */ RecordWeightActivity a;

    C0880r(RecordWeightActivity recordWeightActivity) {
        this.a = recordWeightActivity;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (Utils.y(this.a.a)) {
            this.a.d.setText(i + "-" + this.a.m.format((long) i2) + "-" + this.a.m.format((long) i3) + " " + this.a.m.format((long) i4) + a.ci + this.a.m.format((long) i5));
        } else if (i4 >= 12) {
            this.a.d.setText(i + "-" + this.a.m.format((long) i2) + "-" + this.a.m.format((long) i3) + " " + this.a.m.format((long) (i4 - 12)) + a.ci + this.a.m.format((long) i5) + " " + this.a.getString(r.pm));
        } else {
            this.a.d.setText(i + "-" + this.a.m.format((long) i2) + "-" + this.a.m.format((long) i3) + " " + this.a.m.format((long) i4) + a.ci + this.a.m.format((long) i5) + " " + this.a.getString(r.am));
        }
        String str = i + "-" + this.a.m.format((long) i2) + "-" + this.a.m.format((long) i3) + " " + this.a.m.format((long) i4) + a.ci + this.a.m.format((long) i5) + ":00";
        Date date = new Date();
        try {
            this.a.l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() + com.xiaomi.e.a.f;
            C0596r.e("RecordWeightActivity", "timestr " + this.a.l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
