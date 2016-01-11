package cn.com.smartdevices.bracelet.lab.ui;

class ap implements Runnable {
    final /* synthetic */ StepsCountActivity a;

    ap(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void run() {
        this.a.g.setText(Integer.toString(Float.valueOf(this.a.f()).intValue()));
    }
}
