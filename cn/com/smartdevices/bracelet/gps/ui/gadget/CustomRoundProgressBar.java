package cn.com.smartdevices.bracelet.gps.ui.gadget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.C0151az;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.p;

public class CustomRoundProgressBar extends View {
    private float a = 345.0f;
    private RectF b = null;
    private int c = 0;
    private Paint d = null;
    private RectF e = null;
    private int f = 0;
    private int g = C0151az.s;
    private Paint h = null;
    private float i = 0.0f;
    private float j = 345.0f;
    private int k = 36557;
    private Paint l = null;
    private float m = 3.0f;
    private float n = 0.0f;
    private String o = a.f;
    private int p = -4539718;
    private Paint q = null;
    private float r = 45.0f;
    private int s = 100;
    private float t = 10.0f;
    private int u = 872415231;
    private Paint v = null;
    private int w = 0;
    private int x = 0;

    public CustomRoundProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, p.CustomRoundProgressBar, 0, 0);
        this.c = obtainStyledAttributes.getColor(p.CustomRoundProgressBar_RoundProgressBarBackgroundColor, this.c);
        this.k = obtainStyledAttributes.getColor(p.CustomRoundProgressBar_RoundProgressBarStrockColor, this.k);
        this.f = obtainStyledAttributes.getInt(p.CustomRoundProgressBar_RoundProgressBarProgress, this.f);
        this.g = obtainStyledAttributes.getColor(p.CustomRoundProgressBar_RoundProgressBarProgressColor, this.g);
        this.i = obtainStyledAttributes.getDimension(p.CustomRoundProgressBar_RoundProgressBarProgressWidth, this.i);
        this.s = obtainStyledAttributes.getInt(p.CustomRoundProgressBar_RoundProgressBarTotal, this.s);
        this.m = obtainStyledAttributes.getDimension(p.CustomRoundProgressBar_RoundProgressBarStrockWidth, this.m);
        this.j = obtainStyledAttributes.getDimension(p.CustomRoundProgressBar_RoundProgressBarRadius, this.j);
        String string = obtainStyledAttributes.getString(p.CustomRoundProgressBar_RoundProgressBarText);
        if (string == null) {
            string = a.f;
        }
        this.o = string;
        this.r = obtainStyledAttributes.getDimension(p.CustomRoundProgressBar_RoundProgressBarTextSize, this.r);
        this.p = obtainStyledAttributes.getColor(p.CustomRoundProgressBar_RoundProgressBarTextColor, this.p);
        this.u = obtainStyledAttributes.getColor(p.CustomRoundProgressBar_RoundProgressBarProgressBgColor, this.u);
        this.t = obtainStyledAttributes.getDimension(p.CustomRoundProgressBar_RoundProgressBarProgressBgWidth, this.t);
        obtainStyledAttributes.recycle();
        j();
        i();
    }

    private void i() {
        this.d.setColor(this.c);
        this.l.setColor(this.k);
        this.l.setStrokeWidth(this.m);
        this.h.setColor(this.g);
        this.h.setStrokeWidth(this.i);
        this.q.setColor(this.p);
        this.q.setTextSize(this.r);
        this.n = (((float) this.f) / ((float) this.s)) * 360.0f;
        this.v.setStrokeWidth(this.t);
        this.v.setColor(this.u);
    }

    private void j() {
        this.d = new Paint();
        this.d.setStyle(Style.FILL);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setStyle(Style.STROKE);
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setStyle(Style.STROKE);
        this.q = new Paint();
        this.q.setTextAlign(Align.CENTER);
        this.v = new Paint();
        this.v.setAntiAlias(true);
        this.v.setStyle(Style.STROKE);
    }

    public int a() {
        return this.c;
    }

    public void a(float f) {
        this.t = f;
        invalidate();
    }

    public void a(int i) {
        this.f = i;
        invalidate();
    }

    public int b() {
        return this.f;
    }

    public void b(float f) {
        this.i = f;
        invalidate();
    }

    public void b(int i) {
        this.u = i;
        invalidate();
    }

    public int c() {
        return this.u;
    }

    public void c(float f) {
        this.m = f;
        invalidate();
    }

    public void c(int i) {
        this.g = i;
        invalidate();
    }

    public float d() {
        return this.t;
    }

    public void d(int i) {
        this.k = i;
        invalidate();
    }

    public int e() {
        return this.g;
    }

    public float f() {
        return this.i;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.m;
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        i();
        canvas.drawOval(this.e, this.d);
        if (this.f == 0) {
            canvas.drawCircle((float) this.w, (float) this.x, this.a, this.l);
        } else {
            canvas.drawCircle((float) this.w, (float) this.x, this.a, this.v);
            canvas.drawArc(this.b, -90.0f, this.n, false, this.h);
        }
        String[] split = this.o.split("\n");
        if (split != null && split.length != 0) {
            float ascent = (((float) this.x) - ((this.q.ascent() + this.q.descent()) / 2.0f)) - ((((float) (split.length - 1)) * (this.q.descent() - this.q.ascent())) / 2.0f);
            int length = split.length;
            while (i < length) {
                String str = split[i];
                if (str != null) {
                    canvas.drawText(str, (float) this.w, ascent, this.q);
                    ascent += this.q.descent() - this.q.ascent();
                }
                i++;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int max = (int) ((this.j * 2.0f) + Math.max(this.i, this.m));
        setMeasuredDimension(resolveSize((getPaddingLeft() + getPaddingRight()) + max, i), resolveSize(max + (getPaddingTop() + getPaddingBottom()), i2));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float max = Math.max(this.i, this.m);
        this.a = Math.min((((float) ((i - getPaddingLeft()) - getPaddingRight())) - max) / 2.0f, (((float) ((i2 - getPaddingTop()) - getPaddingBottom())) - max) / 2.0f);
        this.w = i / 2;
        this.x = i2 / 2;
        this.e = new RectF(((float) this.w) - this.a, ((float) this.x) - this.a, ((float) this.w) + this.a, ((float) this.x) + this.a);
        this.b = new RectF(((float) this.w) - this.a, ((float) this.x) - this.a, ((float) this.w) + this.a, ((float) this.x) + this.a);
    }

    public void setBackgroundColor(int i) {
        this.c = i;
        invalidate();
    }
}
