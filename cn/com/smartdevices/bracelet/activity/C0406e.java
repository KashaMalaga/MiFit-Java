package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ad;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;

class C0406e implements ad {
    final /* synthetic */ C0405d a;

    C0406e(C0405d c0405d) {
        this.a = c0405d;
    }

    public void a(WeightGoal weightGoal) {
        if (weightGoal != null) {
            C0596r.e(C0401a.cc, "LoginAvtivity " + weightGoal.toString());
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            readPersonInfo.targetWeight = weightGoal.goal;
            Keeper.keepPersonInfo(readPersonInfo);
            C0596r.e(C0401a.cc, "save goal " + readPersonInfo.targetWeight);
        }
    }
}
