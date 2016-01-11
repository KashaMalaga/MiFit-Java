package cn.com.smartdevices.bracelet.ui;

import android.text.Html;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.g.d;
import com.xiaomi.hm.health.r;

class U implements d {
    final /* synthetic */ DailySportReportActivity a;

    U(DailySportReportActivity dailySportReportActivity) {
        this.a = dailySportReportActivity;
    }

    public void a(double d) {
        if (d >= 0.0d) {
            this.a.e.setText(Html.fromHtml(Utils.a(this.a, d)));
            this.a.e.setVisibility(0);
            return;
        }
        this.a.e.setTextSize(1, 13.0f);
        this.a.e.setText(r.connect_to_retrive);
        this.a.e.setVisibility(8);
    }
}
