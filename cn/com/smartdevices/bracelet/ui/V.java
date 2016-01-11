package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0594p;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;

class V implements C0594p {
    final /* synthetic */ DailySportReportActivity a;

    V(DailySportReportActivity dailySportReportActivity) {
        this.a = dailySportReportActivity;
    }

    public void a(UserTotalSportData userTotalSportData) {
        this.a.h = userTotalSportData;
        this.a.e();
    }
}
