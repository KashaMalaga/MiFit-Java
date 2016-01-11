package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v4.c.a;
import android.support.v4.view.C0198v;

class m extends j {
    m(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        C0198v.a(i, i2, i3, rect, rect2, 0);
    }

    public void a(boolean z) {
        if (this.a != null) {
            a.a(this.a, z);
            invalidateSelf();
        }
    }

    public boolean d() {
        return this.a != null && a.a(this.a);
    }
}
