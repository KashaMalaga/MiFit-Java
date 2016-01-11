package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class k extends j {
    protected k(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    public void a(boolean z) {
        if (this.a != null) {
            this.a.setHasMipMap(z);
            invalidateSelf();
        }
    }

    public boolean d() {
        return this.a != null && this.a.hasMipMap();
    }

    public void getOutline(Outline outline) {
        f();
        outline.setRoundRect(this.b, g());
    }
}
