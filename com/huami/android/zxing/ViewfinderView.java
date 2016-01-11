package com.huami.android.zxing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.view.C0151az;
import android.util.AttributeSet;
import android.view.View;
import com.huami.android.a.d;
import com.huami.android.a.e;
import com.huami.android.a.l;
import com.huami.android.zxing.a.g;

public final class ViewfinderView extends View {
    private static final long c = 15;
    private static final int d = 10;
    Shader a = null;
    Rect b = new Rect(0, 0, 0, 0);
    private int e = 0;
    private int f = 0;
    private String g = null;
    private String h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private final Paint m;
    private int n = 2147483637;
    private g o;
    private final Paint p;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.l = resources.getDimensionPixelSize(e.border_width);
        this.k = resources.getDimensionPixelSize(e.border_length);
        this.e = resources.getDimensionPixelSize(e.scan_font_size);
        this.f = resources.getDimensionPixelSize(e.scan_font_top_margin);
        this.g = resources.getString(l.scan_label);
        this.i = resources.getDimensionPixelSize(e.title_top_margin);
        this.j = resources.getColor(d.viewfinder_mask);
        this.p = new Paint(1);
        this.m = new Paint(1);
    }

    public void a() {
        invalidate();
    }

    public void a(g gVar) {
        this.o = gVar;
    }

    public void a(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.h = str;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.o != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect e = this.o.e();
            Rect f = this.o.f();
            if (e != null && f != null) {
                e.width();
                int i = e.left;
                int i2 = e.top;
                int i3 = e.bottom;
                int i4 = e.right;
                this.p.setColor(this.j);
                canvas.drawRect(0.0f, 0.0f, (float) measuredWidth, (float) i2, this.p);
                canvas.drawRect(0.0f, (float) i2, (float) i, (float) (i3 + 1), this.p);
                canvas.drawRect((float) (i4 + 1), (float) i2, (float) measuredWidth, (float) (i3 + 1), this.p);
                canvas.drawRect(0.0f, (float) (i3 + 1), (float) measuredWidth, (float) measuredHeight, this.p);
                this.p.setColor(-1);
                canvas.drawRect((float) i, (float) i2, (float) (this.k + i), (float) (this.l + i2), this.p);
                canvas.drawRect((float) (i4 - this.k), (float) i2, (float) i4, (float) (this.l + i2), this.p);
                canvas.drawRect((float) i, (float) (i3 - this.l), (float) (this.k + i), (float) i3, this.p);
                canvas.drawRect((float) (i4 - this.k), (float) (i3 - this.l), (float) i4, (float) i3, this.p);
                canvas.drawRect((float) i, (float) i2, (float) (this.l + i), (float) (this.k + i2), this.p);
                canvas.drawRect((float) i, (float) (i3 - this.k), (float) (this.l + i), (float) i3, this.p);
                canvas.drawRect((float) (i4 - this.l), (float) i2, (float) i4, (float) (this.k + i2), this.p);
                canvas.drawRect((float) (i4 - this.l), (float) (i3 - this.k), (float) i4, (float) i3, this.p);
                this.p.setColor(C0151az.s);
                int i5 = i + this.l;
                i4 -= this.l;
                int i6 = i2 + this.l;
                i2 = i3 - this.l;
                int i7 = (i2 - i6) / 4;
                this.n += d;
                if (this.n >= i2) {
                    this.n = i6 - i7;
                }
                i7 += this.n;
                int i8 = i7 > i2 ? i2 : i7;
                this.b.left = i5;
                this.b.bottom = i8;
                this.b.right = i4;
                if (this.n < i6) {
                    this.b.top = i6;
                } else {
                    this.b.top = this.n;
                }
                this.a = new LinearGradient((float) i5, (float) this.n, (float) i5, (float) i8, new int[]{Color.argb(17, 33, 172, 249), Color.argb(85, 33, 172, 249)}, null, TileMode.REPEAT);
                this.m.setShader(this.a);
                canvas.drawRect(this.b, this.m);
                canvas.restore();
                this.p.setColor(-1);
                this.p.setTextSize((float) this.e);
                String[] split = this.g.split("\n");
                if (split != null && split.length != 0) {
                    float f2 = (float) (this.f + i2);
                    i8 = split.length;
                    int i9 = 0;
                    while (i9 < i8) {
                        float f3;
                        String str = split[i9];
                        if (str == null) {
                            f3 = f2;
                        } else {
                            i7 = (measuredWidth - ((int) this.p.measureText(str))) / 2;
                            if (i7 <= 0) {
                                i7 = i5;
                            }
                            f2 += this.p.descent() - this.p.ascent();
                            canvas.drawText(str, (float) i7, f2, this.p);
                            f3 = f2;
                        }
                        i9++;
                        f2 = f3;
                    }
                    if (this.h != null) {
                        i7 = (measuredWidth - ((int) this.p.measureText(this.h))) / 2;
                        if (i7 <= 0) {
                            i7 = i5;
                        }
                        canvas.drawText(this.h, (float) i7, (float) this.i, this.p);
                    }
                    postInvalidateDelayed(c, i5, i6, i4, i2);
                }
            }
        }
    }
}
