package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.C0151az;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.weight.C0873k;

public class WeightTableView extends View {
    private static final String a = "WeightTableView";
    private int A;
    private String[][] b;
    private Paint c;
    private Paint d;
    private Paint e;
    private float f;
    private Context g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int[] t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private int z;

    public WeightTableView(Context context) {
        this(context, null);
    }

    public WeightTableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = 23.3f;
        this.v = 26.7f;
        this.w = 23.3f;
        this.x = 28.3f;
        this.y = 36.6f;
        this.g = context;
        this.c = new Paint();
        this.c.setColor(C0151az.s);
        this.d = new Paint();
        this.d.setColor(C0151az.s);
        this.d.setTextSize((float) Utils.a(10.0f, this.g));
        this.d.setAntiAlias(true);
        this.e = new Paint();
        a();
        b();
    }

    private int a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.z = size;
        if (mode == 1073741824) {
            return size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        return mode == af.a ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private void a() {
        this.h = Color.parseColor("#b6b9bd");
        this.i = Color.parseColor("#15b9d2");
        this.j = Color.parseColor("#14b9af");
        this.k = Color.parseColor("#14ba89");
        this.l = Color.parseColor("#13ba46");
        this.m = Color.parseColor("#8eb536");
        this.n = Color.parseColor("#c8b129");
        this.o = Color.parseColor("#faad19");
        this.p = Color.parseColor("#f2f2f3");
        this.q = Color.parseColor("#f8f8f8");
        this.r = Color.parseColor("#898989");
        this.s = Color.parseColor("#555555");
        this.t = new int[]{this.h, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o};
    }

    private int b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.A = size;
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        return mode == af.a ? Math.min(paddingTop, size) : paddingTop;
    }

    private void b() {
        this.u = Utils.b(this.u, this.g);
        this.v = Utils.b(this.v, this.g);
        this.w = Utils.b(this.w, this.g);
        this.x = Utils.b(this.x, this.g);
        this.y = Utils.b(this.y, this.g);
        this.b = C0873k.a().a;
    }

    public void a(String[][] strArr) {
        this.b = strArr;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = this.b.length;
        int length2 = this.b[0].length;
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            while (i2 < length2) {
                float f;
                float f2;
                float f3;
                float f4;
                if (i == 0) {
                    this.e.setColor(this.t[i2]);
                } else if (i2 == 0) {
                    this.e.setColor(this.q);
                } else if (i % 2 == 0) {
                    this.e.setColor(this.p);
                } else {
                    this.e.setColor(this.q);
                }
                if (i == 0) {
                    this.d.setColor(-1);
                } else if (i2 == 0 || i2 == 1) {
                    this.d.setColor(this.r);
                } else {
                    this.d.setColor(this.s);
                }
                C0596r.e(a, "mBgColorPaint " + this.e.getColor());
                if (i == 0) {
                    if (i2 == 0 || i2 == 1) {
                        f = (((float) i2) * this.v) + this.u;
                        f2 = (((float) i) * this.w) + this.u;
                        f3 = (((float) (i2 + 1)) * this.v) + this.u;
                        f4 = (((float) (i + 1)) * this.w) + this.u;
                        canvas.drawRect(f, f2, f3, f4, this.e);
                        canvas.drawLine(f, f2, f + this.v, f2, this.c);
                        canvas.drawLine(f, f2, f, f2 + this.w, this.c);
                    } else {
                        f = (2.0f * (this.v - this.y)) + (this.u + (((float) i2) * this.y));
                        f2 = (((float) i) * this.w) + this.u;
                        f3 = (2.0f * (this.v - this.y)) + (this.u + (((float) (i2 + 1)) * this.y));
                        f4 = (((float) (i + 1)) * this.w) + this.u;
                        canvas.drawRect(f, f2, f3, f4, this.e);
                        canvas.drawLine(f, f2, f + this.y, f2, this.c);
                        canvas.drawLine(f, f2, f, f2 + this.w, this.c);
                    }
                } else if (i2 == 0 || i2 == 1) {
                    f = (((float) i2) * this.v) + this.u;
                    f2 = (this.w - this.x) + (this.u + (((float) i) * this.x));
                    f3 = (((float) (i2 + 1)) * this.v) + this.u;
                    f4 = (this.w - this.x) + (this.u + (((float) (i + 1)) * this.x));
                    canvas.drawRect(f, f2, f3, f4, this.e);
                    canvas.drawLine(f, f2, f + this.v, f2, this.c);
                    canvas.drawLine(f, f2, f, f2 + this.x, this.c);
                } else {
                    f = (2.0f * (this.v - this.y)) + (this.u + (((float) i2) * this.y));
                    f2 = (this.w - this.x) + (this.u + (((float) i) * this.x));
                    f3 = (2.0f * (this.v - this.y)) + (this.u + (((float) (i2 + 1)) * this.y));
                    f4 = (this.w - this.x) + (this.u + (((float) (i + 1)) * this.x));
                    canvas.drawRect(f, f2, f3, f4, this.e);
                    canvas.drawLine(f, f2, f + this.y, f2, this.c);
                    canvas.drawLine(f, f2, f, f2 + this.x, this.c);
                }
                canvas.drawText(this.b[i][i2], ((f + f3) / 2.0f) - (this.d.measureText(this.b[i][i2]) / 2.0f), (f2 + f4) / 2.0f, this.d);
                i2++;
            }
        }
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f + this.u, this.w + (this.u + (((float) (length - 1)) * this.x)), (2.0f * this.v) + (this.u + (((float) (length2 - 2)) * this.y)), this.w + (this.u + (((float) (length - 1)) * this.x)), this.c);
        canvas2 = canvas;
        canvas2.drawLine((2.0f * this.v) + (this.u + (((float) (length2 - 2)) * this.y)), 0.0f + this.u, (2.0f * this.v) + (this.u + (((float) (length2 - 2)) * this.y)), this.w + (this.u + (((float) (length - 1)) * this.x)), this.c);
    }

    protected void onMeasure(int i, int i2) {
        b(i2);
        int a = a(i);
        this.f = (((float) this.z) - (this.u * 2.0f)) / ((float) this.b[0].length);
        setMeasuredDimension(a, (int) ((this.w + (this.x * ((float) (this.b.length - 1)))) + (this.u * 2.0f)));
        C0596r.e(a, "onMeasure width " + this.z + " and heght " + this.A);
    }
}
