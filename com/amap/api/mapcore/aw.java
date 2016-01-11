package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.C0151az;
import android.view.View;
import com.xiaomi.e.a;

class aw extends View {
    private String a = a.f;
    private int b = 0;
    private AMapDelegateImpGLSurfaceView c;
    private Paint d;
    private Paint e;
    private Rect f;

    public aw(Context context) {
        super(context);
    }

    public aw(Context context, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        super(context);
        this.c = aMapDelegateImpGLSurfaceView;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(C0151az.s);
        this.d.setStrokeWidth(2.0f * n.a);
        this.d.setStyle(Style.STROKE);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setColor(C0151az.s);
        this.e.setTextSize(20.0f * n.a);
    }

    public void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    protected void onDraw(Canvas canvas) {
        if (!this.a.equals(a.f) && this.b != 0) {
            Point D = this.c.D();
            if (D != null) {
                this.e.getTextBounds(this.a, 0, this.a.length(), this.f);
                int width = D.x + this.b > this.c.getWidth() + -10 ? (this.c.getWidth() - 10) - ((this.b + this.f.width()) / 2) : D.x + ((this.b - this.f.width()) / 2);
                int height = (D.y - this.f.height()) + 5;
                canvas.drawText(this.a, (float) width, (float) height, this.e);
                int width2 = width - ((this.b - this.f.width()) / 2);
                int height2 = height + (this.f.height() - 5);
                canvas.drawLine((float) width2, (float) (height2 - 2), (float) width2, (float) (height2 + 2), this.d);
                canvas.drawLine((float) width2, (float) height2, (float) (this.b + width2), (float) height2, this.d);
                canvas.drawLine((float) (this.b + width2), (float) (height2 - 2), (float) (this.b + width2), (float) (height2 + 2), this.d);
            }
        }
    }
}
