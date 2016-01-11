package com.f.a.b.c;

import android.graphics.Bitmap;
import com.f.a.b.a.g;
import com.f.a.b.e.a;
import com.f.a.b.e.b;

public class c implements a {
    protected final int a;
    protected final int b;

    public c(int i) {
        this(i, 0);
    }

    public c(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public void a(Bitmap bitmap, a aVar, g gVar) {
        if (aVar instanceof b) {
            aVar.a(new d(bitmap, this.a, this.b));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
