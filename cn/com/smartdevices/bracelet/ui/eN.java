package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.chart.b.d;

class eN implements Runnable {
    final /* synthetic */ StatisticFragment a;

    eN(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void run() {
        ((d) this.a.R.get(this.a.s)).d(this.a.K);
    }
}
