package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ad;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;

class j implements ad {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
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
