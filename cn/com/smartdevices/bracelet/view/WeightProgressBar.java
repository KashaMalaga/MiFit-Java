package cn.com.smartdevices.bracelet.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;

public class WeightProgressBar extends View {
    private Paint a;
    private float b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private float i;

    public WeightProgressBar(Context context) {
        this(context, null);
    }

    public WeightProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = 0.0f;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 150.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.WeightProgressBar);
        this.b = obtainStyledAttributes.getDimension(0, BitmapDescriptorFactory.HUE_ORANGE);
        this.c = obtainStyledAttributes.getColor(1, -1);
        this.e = obtainStyledAttributes.getColor(3, -10919831);
        this.d = obtainStyledAttributes.getColor(2, -12827569);
        this.f = obtainStyledAttributes.getColor(4, -8476672);
        this.g = (float) obtainStyledAttributes.getInteger(5, a.ap);
        this.h = obtainStyledAttributes.getFloat(6, 0.0f);
        this.i = obtainStyledAttributes.getFloat(6, 0.0f);
        obtainStyledAttributes.recycle();
        this.a = new Paint();
        this.a.setColor(this.e);
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth(this.b);
        this.a.setAntiAlias(true);
    }

    private void a() {
        invalidate();
    }

    public void a(float f) {
        this.h = f;
        a();
    }

    public void a(int i) {
        this.f = i;
        a();
    }

    public void b(float f) {
        this.i = f;
        a();
    }

    public void b(int i) {
        this.e = i;
        a();
    }

    public void c(float f) {
        this.g = f;
        a();
    }

    public void c(int i) {
        this.c = i;
        a();
    }

    public void d(float f) {
        this.b = f;
        a();
    }

    public void d(int i) {
        this.d = i;
        a();
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.d);
        int width = getWidth() / 2;
        int i = (int) (((float) width) - (this.b / 2.0f));
        RectF rectF = new RectF((float) (width - i), (float) (width - i), (float) (width + i), (float) (width + i));
        this.a.setColor(this.e);
        this.a.setStrokeWidth(this.b);
        canvas.drawArc(rectF, 135.0f, BitmapDescriptorFactory.HUE_VIOLET, false, this.a);
        float f = (this.h * BitmapDescriptorFactory.HUE_VIOLET) / this.g;
        this.a.setColor(this.f);
        this.a.setStrokeWidth(this.b);
        canvas.drawArc(rectF, 135.0f, f, false, this.a);
        if (this.i > 0.0f) {
            float f2 = (this.i * BitmapDescriptorFactory.HUE_VIOLET) / this.g;
            this.a.setColor(this.c);
            this.a.setStrokeWidth(this.b + 1.0f);
            canvas.drawArc(rectF, 135.0f + f2, 1.0f, false, this.a);
        }
    }
}
