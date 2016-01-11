package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.e;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0714bp extends bF {
    final /* synthetic */ InstructionWeightActivity a;

    C0714bp(InstructionWeightActivity instructionWeightActivity, Activity activity) {
        this.a = instructionWeightActivity;
        super(activity);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                if (this.a.s == 4) {
                    C0596r.e(InstructionWeightActivity.O, " handle MESSAGE_MAGNIFY_-------ALPHA------_ANIM");
                    this.a.g();
                    return;
                }
                return;
            case a.k /*2*/:
                if (this.a.s == 4) {
                    C0596r.e(InstructionWeightActivity.O, " handle MESSAGE_MAGNIFY_-------SWIPE------_ANIM");
                    this.a.a(this.a.C, (int) e.instruction_weight_swipe);
                    return;
                }
                return;
            case a.l /*3*/:
                if (this.a.s == 4) {
                    C0596r.e(InstructionWeightActivity.O, " handle MESSAGE_WEIGHT_-----TRANSLATE-----_ANIM");
                    this.a.f();
                    return;
                }
                return;
            case a.aQ /*4*/:
                if (this.a.s == 2) {
                    C0596r.e(InstructionWeightActivity.O, " handle MESSAGE_MAGNIFY_-------BILnk------_ANIM");
                    this.a.z.setVisibility(0);
                    this.a.B.setVisibility(0);
                    this.a.a(this.a.z);
                    return;
                }
                return;
            case a.X /*5*/:
                if (this.a.s == 5) {
                    this.a.h();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
