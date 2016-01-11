package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Bitmap;

class bn implements by {
    final /* synthetic */ WatermarkActivity a;

    bn(WatermarkActivity watermarkActivity) {
        this.a = watermarkActivity;
    }

    public void a(Bitmap bitmap) {
        this.a.runOnUiThread(new bo(this, bitmap));
    }
}
