package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0594p;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;

class cP implements C0594p {
    final /* synthetic */ cL a;

    cP(cL cLVar) {
        this.a = cLVar;
    }

    public void a(UserTotalSportData userTotalSportData) {
        C0596r.e("PersonInfoFragment", "returnSportData");
        this.a.u.totalSportData = userTotalSportData;
        Keeper.keepPersonInfo(this.a.u);
        this.a.r();
    }
}
