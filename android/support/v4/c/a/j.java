package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public abstract class j extends Drawable {
    private static final int d = 6;
    Bitmap a;
    final Rect b = new Rect();
    final RectF c = new RectF();
    private int e = 160;
    private int f = 119;
    private Paint g = new Paint(d);
    private BitmapShader h;
    private float i;
    private boolean j = true;
    private int k;
    private int l;

    j(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.e = resources.getDisplayMetrics().densityDpi;
        }
        this.a = bitmap;
        if (this.a != null) {
            h();
            this.h = new BitmapShader(this.a, TileMode.CLAMP, TileMode.CLAMP);
            return;
        }
        this.l = -1;
        this.k = -1;
    }

    private static boolean b(float f) {
        return Float.compare(f, 0.0f) > 0;
    }

    private void h() {
        this.k = this.a.getScaledWidth(this.e);
        this.l = this.a.getScaledHeight(this.e);
    }

    public final Paint a() {
        return this.g;
    }

    public void a(float f) {
        if (b(f)) {
            this.g.setShader(this.h);
        } else {
            this.g.setShader(null);
        }
        this.i = f;
    }

    public void a(int i) {
        if (this.e != i) {
            if (i == 0) {
                i = 160;
            }
            this.e = i;
            if (this.a != null) {
                h();
            }
            invalidateSelf();
        }
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void a(Canvas canvas) {
        a(canvas.getDensity());
    }

    public void a(DisplayMetrics displayMetrics) {
        a(displayMetrics.densityDpi);
    }

    public void a(boolean z) {
        throw new UnsupportedOperationException();
    }

    public final Bitmap b() {
        return this.a;
    }

    public void b(int i) {
        if (this.f != i) {
            this.f = i;
            this.j = true;
            invalidateSelf();
        }
    }

    public void b(boolean z) {
        this.g.setAntiAlias(z);
        invalidateSelf();
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        throw new UnsupportedOperationException();
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            f();
            Paint paint = this.g;
            if (paint.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.b, paint);
            } else {
                canvas.drawRoundRect(this.c, this.i, this.i, paint);
            }
        }
    }

    public boolean e() {
        return this.g.isAntiAlias();
    }

    void f() {
        if (this.j) {
            a(this.f, this.k, this.l, getBounds(), this.b);
            this.c.set(this.b);
            this.j = false;
        }
    }

    public float g() {
        return this.i;
    }

    public int getAlpha() {
        return this.g.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.g.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.l;
    }

    public int getIntrinsicWidth() {
        return this.k;
    }

    public int getOpacity() {
        if (this.f != 119) {
            return -3;
        }
        Bitmap bitmap = this.a;
        return (bitmap == null || bitmap.hasAlpha() || this.g.getAlpha() < HeartRateInfo.HR_EMPTY_VALUE || b(this.i)) ? -3 : -1;
    }

    public void setAlpha(int i) {
        if (i != this.g.getAlpha()) {
            this.g.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.g.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.g.setFilterBitmap(z);
        invalidateSelf();
    }
}
