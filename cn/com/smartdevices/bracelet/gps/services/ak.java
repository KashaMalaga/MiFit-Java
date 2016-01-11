package cn.com.smartdevices.bracelet.gps.services;

import android.os.Handler;

public class ak extends Handler {
    final /* synthetic */ StepProvider a;

    protected ak(StepProvider stepProvider) {
        this.a = stepProvider;
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }
}
