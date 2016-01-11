package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.e.a;
import kankan.wheel.widget.l;

public class RadioRuler extends View {
    public static final int a = 1001;
    public static final int b = 1002;
    public static final int c = 1000;
    private static final float n = 84.0f;
    private static final float o = 1.0f;
    private static final float p = 110.0f;
    private static final float q = 83.5f;
    private static final float r = 500.0f;
    private static final float s = 495.0f;
    private static final float t = 1600.0f;
    private static final float u = 10.0f;
    private Bitmap d = null;
    private Bitmap e = null;
    private Bitmap f = null;
    private Bitmap g = null;
    private final int h = 15;
    private Paint i = null;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private final String m = "Ruler";
    private int v = c;
    private final int w = 405;
    private float x = 0.0f;
    private Scroller y = null;
    private C0850x z = null;

    public RadioRuler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new Scroller(context);
        setFocusable(true);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setColor(-1);
        this.i.setTextSize(15.0f);
        if (c == this.v) {
            a((int) a);
        }
    }

    private float a() {
        return this.v == b ? t : p;
    }

    private float b() {
        int abs = Math.abs((int) C0849w.c(this.j, 15.0f));
        switch (this.v) {
            case a /*1001*/:
                return C0849w.a(2.7f, C0849w.a(q, C0849w.b((float) abs, C0849w.c(o, u))));
            case b /*1002*/:
                return C0849w.a(27.0f, C0849w.a(s, C0849w.b((float) abs, C0849w.c(u, u))));
            default:
                return 0.0f;
        }
    }

    private void b(float f) {
        if (f < 0.0f && this.x > a()) {
            return;
        }
        if (this.j + f <= 0.0f) {
            this.j += f;
            this.k = this.j % BitmapDescriptorFactory.HUE_MAGENTA;
            if (this.k > 0.0f) {
                this.k -= BitmapDescriptorFactory.HUE_MAGENTA;
            } else if (this.k < -300.0f) {
                this.k += BitmapDescriptorFactory.HUE_MAGENTA;
            }
            invalidate();
            return;
        }
        this.j = 0.0f;
        this.k = 0.0f;
        invalidate();
    }

    private void b(Canvas canvas) {
        float f = 68.0f + this.j;
        int i = -1;
        while (f <= 800.0f) {
            i++;
            if (f < 0.0f) {
                f += 150.0f;
            } else {
                switch (this.v) {
                    case b /*1002*/:
                        this.x = r + (((float) i) * u);
                        break;
                    default:
                        this.x = n + (((float) i) * o);
                        break;
                }
                canvas.drawText(this.x + a.f, f, 15.0f, this.i);
                f += 150.0f;
            }
        }
    }

    private void c(float f) {
        this.y.startScroll((int) this.j, 0, (int) f, 0, 100);
        while (this.y.computeScrollOffset()) {
            this.j = (float) this.y.getCurrX();
            invalidate();
        }
    }

    public void a(float f) {
        float f2 = 0.0f;
        switch (this.v) {
            case a /*1001*/:
                f2 = (-(((f - q) / 0.1f) - 27.0f)) * 15.0f;
                break;
            case b /*1002*/:
                f2 = (-(((f - s) / o) - 27.0f)) * 15.0f;
                break;
        }
        c(f2 - this.j);
    }

    public void a(int i) {
        switch (i) {
            case b /*1002*/:
                this.v = b;
                return;
            default:
                this.v = a;
                return;
        }
    }

    public void a(int i, float f) {
        switch (i) {
            case a /*1001*/:
                this.v = a;
                this.j = (-(((f - q) / 0.1f) - 27.0f)) * 15.0f;
                return;
            case b /*1002*/:
                this.v = b;
                this.j = (-(((f - s) / o) - 27.0f)) * 15.0f;
                return;
            default:
                return;
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4) {
        this.d = bitmap;
        this.e = bitmap2;
        this.f = bitmap3;
        this.g = bitmap4;
    }

    public void a(Canvas canvas) {
        canvas.drawBitmap(this.e, 0.0f, 0.0f, null);
        C0596r.e("Ruler", "startview position is " + this.k);
        C0596r.e("Ruler", "scroll distance position is " + this.j);
        this.k = this.j % BitmapDescriptorFactory.HUE_MAGENTA;
        if (this.k < -100.0f) {
            canvas.drawBitmap(this.d, 900.0f + this.k, 20.0f, null);
        }
        canvas.drawBitmap(this.d, this.k, 20.0f, null);
        canvas.drawBitmap(this.d, this.k + BitmapDescriptorFactory.HUE_MAGENTA, 20.0f, null);
        canvas.drawBitmap(this.d, this.k + 600.0f, 20.0f, null);
        b(canvas);
        canvas.drawBitmap(this.g, 395.0f, 20.0f, null);
        canvas.drawBitmap(this.f, 0.0f, 0.0f, null);
    }

    public void a(C0850x c0850x) {
        this.z = c0850x;
    }

    protected void onDraw(Canvas canvas) {
        a(canvas);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(cn.com.smartdevices.bracelet.chart.util.a.d, 72);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.y == null || this.y.isFinished()) {
            switch (motionEvent.getAction()) {
                case kankan.wheel.widget.a.i /*0*/:
                    this.l = motionEvent.getX();
                    break;
                case l.a /*1*/:
                    c(-(this.j % 15.0f));
                    if (this.z != null) {
                        this.z.a(b());
                        break;
                    }
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    float x = motionEvent.getX() - this.l;
                    this.l = motionEvent.getX();
                    b(x);
                    if (this.z != null) {
                        this.z.a();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
