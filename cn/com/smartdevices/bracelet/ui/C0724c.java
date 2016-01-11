package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ag;

class C0724c implements ag {
    final /* synthetic */ AlarmActivity a;

    C0724c(AlarmActivity alarmActivity) {
        this.a = alarmActivity;
    }

    public void a() {
        C0596r.e("AlarmActivity", "sync alarm to server fail");
    }

    public void b() {
        C0596r.e("AlarmActivity", "sync alarm to server ok");
        this.a.r.clearNeedSyncServer();
        Keeper.keepPersonInfo(this.a.r);
    }
}
