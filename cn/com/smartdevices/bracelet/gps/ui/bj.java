package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Bitmap;

class bj implements Runnable {
    final /* synthetic */ WatermarkActivity a;

    bj(WatermarkActivity watermarkActivity) {
        this.a = watermarkActivity;
    }

    public void run() {
        Bitmap e = this.a.i();
        if (e != null) {
            this.a.runOnUiThread(new bk(this, e));
        }
    }
}
