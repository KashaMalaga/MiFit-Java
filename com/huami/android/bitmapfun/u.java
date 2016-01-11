package com.huami.android.bitmapfun;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import java.io.File;

public class u {
    public int a = 5120;
    public int b = 10485760;
    public File c;
    public CompressFormat d = s.d;
    public int e = 70;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;

    public u(Context context, String str) {
        this.c = s.a(context, str);
    }

    public void a(float f) {
        if (f < 0.01f || f > 0.8f) {
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
        }
        this.a = Math.round((((float) Runtime.getRuntime().maxMemory()) * f) / 1024.0f);
    }
}
