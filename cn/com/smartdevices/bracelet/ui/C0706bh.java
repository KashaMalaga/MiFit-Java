package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.r;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.c;

class C0706bh implements c {
    final /* synthetic */ C0705bg a;

    C0706bh(C0705bg c0705bg) {
        this.a = c0705bg;
    }

    public void a(WheelView wheelView, int i, int i2) {
        int i3 = i2 + 3;
        this.a.c.setText(this.a.getString(r.incoming_call_notify_tips, new Object[]{Integer.valueOf(i3)}));
    }
}
