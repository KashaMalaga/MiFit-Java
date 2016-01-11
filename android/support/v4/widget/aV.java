package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.C0151az;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.WeightedLatLng;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import kankan.wheel.widget.a;

final class aV {
    private static final int a = -1291845632;
    private static final int b = Integer.MIN_VALUE;
    private static final int c = 1291845632;
    private static final int d = 436207616;
    private static final int e = 2000;
    private static final int f = 1000;
    private static final Interpolator g = C0236e.a();
    private final Paint h = new Paint();
    private final RectF i = new RectF();
    private float j;
    private long k;
    private long l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private View r;
    private Rect s = new Rect();

    public aV(View view) {
        this.r = view;
        this.n = a;
        this.o = b;
        this.p = c;
        this.q = d;
    }

    private void a(Canvas canvas, float f, float f2, int i, float f3) {
        this.h.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        float interpolation = g.getInterpolation(f3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, f, this.h);
        canvas.restore();
    }

    private void a(Canvas canvas, int i, int i2) {
        this.h.setColor(this.n);
        canvas.drawCircle((float) i, (float) i2, ((float) i) * this.j, this.h);
    }

    void a(float f) {
        this.j = f;
        this.k = 0;
        C0151az.a(this.r, this.s.left, this.s.top, this.s.right, this.s.bottom);
    }

    void a(int i, int i2, int i3, int i4) {
        this.n = i;
        this.o = i2;
        this.p = i3;
        this.q = i4;
    }

    void a(Canvas canvas) {
        int width = this.s.width();
        int height = this.s.height();
        int i = width / 2;
        int i2 = height / 2;
        int save = canvas.save();
        canvas.clipRect(this.s);
        if (this.m || this.l > 0) {
            Canvas canvas2;
            int i3;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = (currentAnimationTimeMillis - this.k) / 2000;
            float f = ((float) ((currentAnimationTimeMillis - this.k) % 2000)) / 20.0f;
            Object obj;
            if (this.m) {
                obj = null;
            } else if (currentAnimationTimeMillis - this.l >= 1000) {
                this.l = 0;
                return;
            } else {
                float f2 = (float) (width / 2);
                float interpolation = g.getInterpolation((((float) ((currentAnimationTimeMillis - this.l) % 1000)) / 10.0f) / CropOverlayView.a) * f2;
                this.i.set(((float) i) - interpolation, 0.0f, interpolation + ((float) i), (float) height);
                canvas.saveLayerAlpha(this.i, 0, 0);
                obj = 1;
            }
            if (j == 0) {
                canvas.drawColor(this.n);
            } else if (f >= 0.0f && f < a.bi) {
                canvas.drawColor(this.q);
            } else if (f >= a.bi && f < 50.0f) {
                canvas.drawColor(this.n);
            } else if (f < 50.0f || f >= 75.0f) {
                canvas.drawColor(this.p);
            } else {
                canvas.drawColor(this.o);
            }
            if (f >= 0.0f && f <= a.bi) {
                canvas2 = canvas;
                a(canvas2, (float) i, (float) i2, this.n, ((a.bi + f) * 2.0f) / CropOverlayView.a);
            }
            if (f >= 0.0f && f <= 50.0f) {
                canvas2 = canvas;
                a(canvas2, (float) i, (float) i2, this.o, (2.0f * f) / CropOverlayView.a);
            }
            if (f >= a.bi && f <= 75.0f) {
                canvas2 = canvas;
                a(canvas2, (float) i, (float) i2, this.p, ((f - a.bi) * 2.0f) / CropOverlayView.a);
            }
            if (f >= 50.0f && f <= CropOverlayView.a) {
                canvas2 = canvas;
                a(canvas2, (float) i, (float) i2, this.q, ((f - 50.0f) * 2.0f) / CropOverlayView.a);
            }
            if (f >= 75.0f && f <= CropOverlayView.a) {
                canvas2 = canvas;
                a(canvas2, (float) i, (float) i2, this.n, ((f - 75.0f) * 2.0f) / CropOverlayView.a);
            }
            if (this.j <= 0.0f || r9 == null) {
                i3 = save;
            } else {
                canvas.restoreToCount(save);
                i3 = canvas.save();
                canvas.clipRect(this.s);
                a(canvas, i, i2);
            }
            C0151az.a(this.r, this.s.left, this.s.top, this.s.right, this.s.bottom);
            save = i3;
        } else if (this.j > 0.0f && ((double) this.j) <= WeightedLatLng.DEFAULT_INTENSITY) {
            a(canvas, i, i2);
        }
        canvas.restoreToCount(save);
    }

    boolean a() {
        return this.m || this.l > 0;
    }

    void b(int i, int i2, int i3, int i4) {
        this.s.left = i;
        this.s.top = i2;
        this.s.right = i3;
        this.s.bottom = i4;
    }

    void start() {
        if (!this.m) {
            this.j = 0.0f;
            this.k = AnimationUtils.currentAnimationTimeMillis();
            this.m = true;
            this.r.postInvalidate();
        }
    }

    void stop() {
        if (this.m) {
            this.j = 0.0f;
            this.l = AnimationUtils.currentAnimationTimeMillis();
            this.m = false;
            this.r.postInvalidate();
        }
    }
}
