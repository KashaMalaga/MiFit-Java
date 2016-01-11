package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Bitmap;

class bk implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ bj b;

    bk(bj bjVar, Bitmap bitmap) {
        this.b = bjVar;
        this.a = bitmap;
    }

    public void run() {
        this.b.a.d.setImageBitmap(this.a);
    }
}
