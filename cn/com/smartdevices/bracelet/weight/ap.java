package cn.com.smartdevices.bracelet.weight;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.huami.android.view.e;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;

class ap implements e {
    final /* synthetic */ c a;
    final /* synthetic */ WeightReportActivity b;

    ap(WeightReportActivity weightReportActivity, c cVar) {
        this.b = weightReportActivity;
        this.a = cVar;
    }

    public void a(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }

    public void b(DialogFragment dialogFragment) {
        this.a.dismiss();
    }

    public void c(DialogFragment dialogFragment) {
        this.a.dismiss();
        C0596r.e("WeightReportActivity", "del and del");
        C0596r.e("WeightReportActivity", "weightadvdata " + this.b.n.e());
        this.b.setResult(-1);
        C0596r.e("WeightReportActivity", "nowInfo.uid " + this.b.m.uid);
        C0596r.e("WeightReportActivity", "fromUID " + this.b.p);
        WeightInfo b = ah.a().b(this.b.n.e());
        if (b == null) {
            b.a(this.b.b, this.b.getString(r.can_not_del_last_weight_info), 0).show();
            return;
        }
        aA.a(b);
        EventBus.getDefault().post(new EventWeightChanged(b.uid));
        this.b.finish();
    }
}
