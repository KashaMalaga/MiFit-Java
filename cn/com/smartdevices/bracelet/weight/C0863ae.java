package cn.com.smartdevices.bracelet.weight;

import android.app.DialogFragment;
import android.content.Intent;
import cn.com.smartdevices.bracelet.eventbus.EventWeightTargetUpdated;
import cn.com.smartdevices.bracelet.weight.goal.a;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.huami.android.view.e;
import de.greenrobot.event.EventBus;

class C0863ae implements e {
    final /* synthetic */ WeightGoalSetActivity a;

    C0863ae(WeightGoalSetActivity weightGoalSetActivity) {
        this.a = weightGoalSetActivity;
    }

    public void a(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }

    public void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        a.a().b(this.a.s);
        this.a.p.targetWeight = GroundOverlayOptions.NO_DIMENSION;
        J.a().d(this.a.p);
        Intent intent = new Intent();
        intent.putExtra(WeightGoalSetActivity.b, -1);
        this.a.setResult(WeightGoalSetActivity.d, intent);
        this.a.finish();
        EventBus.getDefault().post(new EventWeightTargetUpdated(this.a.s));
    }
}
