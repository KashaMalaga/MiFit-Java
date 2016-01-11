package cn.com.smartdevices.bracelet.ui;

class eJ implements Runnable {
    final /* synthetic */ StatisticFragment a;

    eJ(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void run() {
        this.a.b.e();
        this.a.b.d(0);
    }
}
