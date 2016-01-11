package com.f.a.b.c;

import android.graphics.Bitmap;
import com.f.a.b.a.g;
import com.f.a.b.e.a;
import com.f.a.b.e.b;

public class e extends c {
    public e(int i, int i2) {
        super(i, i2);
    }

    public void a(Bitmap bitmap, a aVar, g gVar) {
        if (aVar instanceof b) {
            aVar.a(new f(bitmap, this.a, this.b));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
