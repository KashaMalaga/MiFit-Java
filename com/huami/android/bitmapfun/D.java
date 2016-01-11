package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

@SuppressLint({"NewApi"})
public class D extends BitmapDrawable {
    static final String a = "CountingBitmapDrawable";
    private int b = 0;
    private int c = 0;
    private boolean d;

    public D(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    private synchronized void a() {
        if (this.b <= 0 && this.c <= 0 && this.d && b()) {
            getBitmap().recycle();
        }
    }

    private synchronized boolean b() {
        boolean z;
        Bitmap bitmap = getBitmap();
        z = (bitmap == null || bitmap.isRecycled()) ? false : true;
        return z;
    }

    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                this.c++;
                this.d = true;
            } else {
                this.c--;
            }
        }
        a();
    }

    public void b(boolean z) {
        synchronized (this) {
            if (z) {
                this.b++;
            } else {
                this.b--;
            }
        }
        a();
    }
}
