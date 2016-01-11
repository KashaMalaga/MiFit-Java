package com.xiaomi.channel.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class q {
    static final int a = 2097152;
    final int b = 356;
    final int c = 356;
    public String d;
    public long e = 2097152;
    private final Bitmap f;

    public q(Bitmap bitmap) {
        this.f = bitmap;
    }

    public Bitmap a() {
        if (this.f == null) {
            return null;
        }
        int width = this.f.getWidth();
        int height = this.f.getHeight();
        long j = (long) (width * height);
        if (j <= this.e) {
            return this.f;
        }
        double sqrt = Math.sqrt((double) (j / this.e));
        return w.a(this.f, (int) (((double) width) / sqrt), (int) (((double) height) / sqrt), Config.ARGB_8888);
    }

    public Bitmap b() {
        return this.f;
    }
}
