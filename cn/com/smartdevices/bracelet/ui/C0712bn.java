package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0712bn implements Runnable {
    final /* synthetic */ C0711bm a;

    private C0712bn(C0711bm c0711bm) {
        this.a = c0711bm;
    }

    public void run() {
        C0596r.e("DDDD", "Gif End : " + this.a.e);
        if (this.a.getActivity() != null) {
            switch (this.a.e) {
                case l.a /*1*/:
                    this.a.c_.setText(this.a.getString(r.instruction_tip_2_2));
                    this.a.b_.c(k.intruction_2_2);
                    this.a.e = 2;
                    return;
                case a.k /*2*/:
                    this.a.c_.setText(this.a.getString(r.instruction_tip_2_3));
                    this.a.b_.c(k.intruction_2_3);
                    this.a.e = 3;
                    return;
                case a.l /*3*/:
                    this.a.c_.setText(this.a.getString(r.instruction_tip_2_4));
                    this.a.b_.c(k.intruction_2_4);
                    this.a.e = 4;
                    return;
                case a.aQ /*4*/:
                    this.a.c_.setText(this.a.getString(r.instruction_tip_2_5));
                    this.a.b_.c(k.intruction_2_5);
                    this.a.e = 5;
                    this.a.b_.postDelayed(new C0712bn(this.a), a.bX);
                    return;
                case a.X /*5*/:
                    this.a.c_.setText(this.a.getString(r.instruction_tip_2_1));
                    this.a.b_.c(k.intruction_2_1);
                    this.a.e = 1;
                    return;
                default:
                    return;
            }
        }
    }
}
