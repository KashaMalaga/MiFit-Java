package cn.com.smartdevices.bracelet.ui;

class aQ implements Runnable {
    final /* synthetic */ FwUpgradeActivity a;

    aQ(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void run() {
        if (this.a.u != null) {
            this.a.a(this.a.u.getCurrentUpgradeType());
        }
    }
}
