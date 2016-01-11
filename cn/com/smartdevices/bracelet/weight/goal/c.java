package cn.com.smartdevices.bracelet.weight.goal;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ac;

class c implements ac {
    final /* synthetic */ WeightGoal a;
    final /* synthetic */ a b;

    c(a aVar, WeightGoal weightGoal) {
        this.b = aVar;
        this.a = weightGoal;
    }

    public void a() {
        C0596r.e("WeightGoalManager", "\u670d\u52a1\u5668\u5220\u9664\u6210\u529f\u672c\u5730\u5220\u9664");
        this.a.delete();
    }

    public void b() {
        C0596r.e("WeightGoalManager", "\u670d\u52a1\u5668\u5220\u9664\u5931\u8d25");
    }
}
