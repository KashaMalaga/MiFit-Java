package cn.com.smartdevices.bracelet.lab.ui;

import cn.com.smartdevices.bracelet.shoes.sync.C0632i;
import java.util.TimerTask;

class aq extends TimerTask {
    final /* synthetic */ StepsCountActivity a;

    aq(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void run() {
        C0632i.a(this.a, -1);
    }
}
