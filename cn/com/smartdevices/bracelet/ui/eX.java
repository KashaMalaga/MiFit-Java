package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import cn.com.smartdevices.bracelet.chart.util.p;

class eX implements p {
    final /* synthetic */ StatisticFragment a;

    eX(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void a(int i) {
        Activity activity = this.a.getActivity();
        if (activity != null) {
            ((SystemBarTintActivity) activity).applyStatusBarTint(i);
        }
    }
}
