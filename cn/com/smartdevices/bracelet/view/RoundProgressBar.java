package cn.com.smartdevices.bracelet.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.e.a.a;
import android.util.AttributeSet;
import android.view.View;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.t;

public class RoundProgressBar extends View {
    public static final int a = 0;
    public static final int b = 1;
    private Paint c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private int o;
    private Bitmap p;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = a;
        this.l = a;
        this.o = -1;
        this.p = null;
        this.c = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.RoundProgressBar);
        this.d = obtainStyledAttributes.getColor(a, a.c);
        this.e = obtainStyledAttributes.getColor(b, -16711936);
        this.f = obtainStyledAttributes.getColor(3, -16711936);
        this.g = obtainStyledAttributes.getDimension(4, 15.0f);
        this.h = obtainStyledAttributes.getDimension(2, 5.0f);
        this.i = obtainStyledAttributes.getInteger(5, 100);
        this.m = obtainStyledAttributes.getBoolean(6, true);
        this.n = obtainStyledAttributes.getInt(7, a);
        this.o = obtainStyledAttributes.getResourceId(8, -1);
        if (this.o != -1) {
            this.p = BitmapFactory.decodeResource(getResources(), this.o);
        }
        obtainStyledAttributes.recycle();
    }

    public synchronized int a() {
        return this.i;
    }

    public void a(float f) {
        this.g = f;
    }

    public synchronized void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.i = i;
    }

    public synchronized int b() {
        return this.j;
    }

    @SuppressLint({"NewApi"})
    public synchronized void b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.i) {
            this.j = this.i;
        }
        if (i <= this.i) {
            this.j = i;
            postInvalidateOnAnimation();
        }
    }

    public int c() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public float d() {
        return this.g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = (int) (((float) width) - (this.h / 2.0f));
        this.c.setColor(this.d);
        this.c.setStyle(Style.STROKE);
        this.c.setStrokeWidth(this.h);
        this.c.setAntiAlias(true);
        canvas.drawCircle((float) width, (float) width, (float) i, this.c);
        this.c.setStrokeWidth(0.0f);
        this.c.setColor(this.f);
        this.c.setTextSize(this.g);
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((((float) this.j) / ((float) this.i)) * CropOverlayView.a);
        float measureText = this.c.measureText(i2 + "%");
        if (this.m && i2 != 0 && this.n == 0) {
            canvas.drawText(i2 + "%", ((float) width) - (measureText / 2.0f), ((float) width) + (this.g / 2.0f), this.c);
        }
        if (this.p != null) {
            canvas.drawBitmap(this.p, (float) (width - (this.p.getWidth() / 2)), (float) (width - (this.p.getHeight() / 2)), null);
        }
        this.c.setStrokeWidth(this.h);
        this.c.setColor(this.e);
        RectF rectF = new RectF((float) (width - i), (float) (width - i), (float) (width + i), (float) (width + i));
        switch (this.n) {
            case a /*0*/:
                this.c.setStyle(Style.STROKE);
                canvas.drawArc(rectF, -90.0f, 360.0f * (((float) this.j) / ((float) this.i)), false, this.c);
                return;
            case b /*1*/:
                this.c.setStyle(Style.FILL_AND_STROKE);
                if (this.j != 0) {
                    canvas.drawArc(rectF, -90.0f, 360.0f * (((float) this.j) / ((float) this.i)), true, this.c);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
