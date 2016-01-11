package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.view.C0151az;

class fd implements Runnable {
    final /* synthetic */ SystemBarTintActivity a;

    fd(SystemBarTintActivity systemBarTintActivity) {
        this.a = systemBarTintActivity;
    }

    public void run() {
        int i = 0;
        if (!this.a.mDisableStatusBarTintAuto) {
            try {
                this.a.mContentView.buildDrawingCache();
                Bitmap drawingCache = this.a.mContentView.getDrawingCache();
                if (VERSION.SDK_INT <= 19) {
                    i = this.a.mSystemBarTintManager.a().b();
                }
                i = drawingCache.getPixel(0, i);
                this.a.mContentView.destroyDrawingCache();
                this.a.applyStatusBarTint(i);
            } catch (Exception e) {
                this.a.applyStatusBarTint(C0151az.s);
                e.printStackTrace();
            }
        }
    }
}
