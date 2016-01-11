package cn.com.smartdevices.bracelet.weight.goal;

import cn.com.smartdevices.bracelet.af;
import java.util.List;

class d implements af {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void a(List<WeightGoal> list) {
        if (list != null) {
            for (WeightGoal weightGoal : list) {
                weightGoal.synced = WeightGoal.WEIGHTGOAL_SYNCED;
                weightGoal.save();
            }
        }
    }
}
