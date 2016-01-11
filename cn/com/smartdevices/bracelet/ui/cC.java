package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0594p;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;

class cC implements C0594p {
    final /* synthetic */ MyPageActivity a;

    cC(MyPageActivity myPageActivity) {
        this.a = myPageActivity;
    }

    public void a(UserTotalSportData userTotalSportData) {
        C0596r.e("MyPageActiv", "returnSportData");
        this.a.b.totalSportData = userTotalSportData;
        Keeper.keepPersonInfo(this.a.b);
        this.a.d();
    }
}
