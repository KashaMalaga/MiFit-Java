package cn.com.smartdevices.bracelet.weight.goal;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ae;

class b implements ae {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a() {
        C0596r.e("WeightGoalManager", "\u670d\u52a1\u5668\u540c\u6b65\u5931\u8d25");
    }

    public void a(WeightGoal weightGoal) {
        C0596r.e("WeightGoalManager", "\u670d\u52a1\u5668\u66f4\u65b0\u6210\u529f\uff0c\u672c\u5730\u72b6\u6001\u4f4d\u7f6e\u4e3aSYNCED");
        weightGoal.synced = WeightGoal.WEIGHTGOAL_SYNCED;
        weightGoal.save();
    }
}
