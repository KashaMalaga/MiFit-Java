package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0891z;
import com.xiaomi.hm.health.bt.d.c;

class C0821v implements c {
    final /* synthetic */ BaseSCActivity a;

    C0821v(BaseSCActivity baseSCActivity) {
        this.a = baseSCActivity;
    }

    public void a(int i) {
        C0891z.a(this.a.x).b(i);
        this.a.u.sendEmptyMessage(4103);
    }
}
