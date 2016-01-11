package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Bitmap;

class bo implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ bn b;

    bo(bn bnVar, Bitmap bitmap) {
        this.b = bnVar;
        this.a = bitmap;
    }

    public void run() {
        this.b.a.m();
        this.b.a.c.setImageBitmap(this.a);
    }
}
