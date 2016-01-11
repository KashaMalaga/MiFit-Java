package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.view.ab;
import cn.com.smartdevices.bracelet.weight.UserInfo;

class eQ implements ab {
    final /* synthetic */ StatisticFragment a;

    eQ(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void a(View view, UserInfo userInfo, int i) {
        if (userInfo == null) {
            this.a.d(1);
        } else if (this.a.E != userInfo.uid && !this.a.H) {
            this.a.H = true;
            this.a.D.a(i);
            this.a.e(userInfo.uid);
        }
    }
}
