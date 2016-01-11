package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0773dv extends Handler {
    final /* synthetic */ SearchWeightScaleActivity a;

    C0773dv(SearchWeightScaleActivity searchWeightScaleActivity) {
        this.a = searchWeightScaleActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                Utils.a(this.a.v);
                this.a.setResult(-1);
                this.a.finish();
                C0401a.a(this.a.v, C0401a.fX);
                return;
            case a.k /*2*/:
            case a.X /*5*/:
                b.a(this.a.v, (int) r.bind_weight_fail, 1).show();
                Utils.a(this.a.v);
                this.a.i();
                C0401a.a(this.a.v, C0401a.fW);
                return;
            case a.l /*3*/:
                this.a.e();
                this.a.j();
                C0401a.a(this.a.v, C0401a.fV);
                return;
            default:
                return;
        }
    }
}
