package cn.com.smartdevices.bracelet.ui;

class eO implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ StatisticFragment b;

    eO(StatisticFragment statisticFragment, int i) {
        this.b = statisticFragment;
        this.a = i;
    }

    public void run() {
        this.b.E = this.a;
        this.b.F = null;
        this.b.K = 0;
        this.b.a(this.b.D, this.b.E);
        this.b.u();
    }
}
