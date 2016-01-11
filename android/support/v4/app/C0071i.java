package android.support.v4.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0151az;
import com.amap.api.maps.model.GroundOverlayOptions;

class C0071i extends InsetDrawable implements Callback {
    final /* synthetic */ C0011a a;
    private final boolean b;
    private final Rect c;
    private float d;
    private float e;

    private C0071i(C0011a c0011a, Drawable drawable) {
        boolean z = false;
        this.a = c0011a;
        super(drawable, 0);
        if (VERSION.SDK_INT > 18) {
            z = true;
        }
        this.b = z;
        this.c = new Rect();
    }

    public float a() {
        return this.d;
    }

    public void a(float f) {
        this.d = f;
        invalidateSelf();
    }

    public void b(float f) {
        this.e = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        int i = 1;
        copyBounds(this.c);
        canvas.save();
        int i2 = C0151az.j(this.a.d.getWindow().getDecorView()) == 1 ? 1 : 0;
        if (i2 != 0) {
            i = -1;
        }
        int width = this.c.width();
        canvas.translate(((float) i) * (((-this.e) * ((float) width)) * this.d), 0.0f);
        if (!(i2 == 0 || this.b)) {
            canvas.translate((float) width, 0.0f);
            canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
}
