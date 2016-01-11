package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.c;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

class C0883u implements c {
    final /* synthetic */ C0882t a;

    C0883u(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView, int i, int i2) {
        if (this.a.isAdded()) {
            this.a.d.a(5).e(h.wheel_custom_val_white_1).a(this.a.getString(r.day_ri), (float) aA.h).a(new C0763dl(this.a.getActivity(), 1, this.a.a(this.a.m, i2 + 1), this.a.d, this.a.getResources().getColor(g.highlight), this.a.getResources().getColor(g.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1)).a(true);
            C0596r.e("SettingDateFragment", "cur day " + this.a.l + " max day " + this.a.a(this.a.m, i2 + 1));
            if (this.a.l > this.a.a(this.a.m, i2 + 1)) {
                this.a.d.c(this.a.a(this.a.m, i2 + 1) - 1);
            } else {
                this.a.d.c(this.a.l - 1);
            }
            C0596r.e("SettingDateFragment", "oldValue " + i + " newValue " + i2);
            this.a.k = i2 + 1;
            this.a.a();
        }
    }
}
