package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.C0151az;
import android.view.View;
import com.amap.api.mapcore.n.a;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.s;
import com.amap.api.mapcore.util.u;
import java.io.InputStream;

class bc extends View {
    Rect a = new Rect();
    int b = 10;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Paint g = new Paint();
    private boolean h = false;
    private int i = 0;
    private AMapDelegateImpGLSurfaceView j;
    private int k = 0;

    public bc(Context context) {
        super(context);
    }

    public bc(Context context, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        super(context);
        this.j = aMapDelegateImpGLSurfaceView;
        try {
            InputStream open = n.d == a.ALIBABA ? s.a(context).open("apl.data") : s.a(context).open("ap.data");
            this.e = BitmapFactory.decodeStream(open);
            this.c = u.a(this.e, n.a);
            open.close();
            open = n.d == a.ALIBABA ? s.a(context).open("apl1.data") : s.a(context).open("ap1.data");
            this.f = BitmapFactory.decodeStream(open);
            this.d = u.a(this.f, n.a);
            open.close();
            this.i = this.d.getHeight();
        } catch (Throwable th) {
            az.a(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
        this.g.setAntiAlias(true);
        this.g.setColor(C0151az.s);
        this.g.setStyle(Style.STROKE);
    }

    public void a() {
        try {
            if (this.c != null) {
                this.c.recycle();
            }
            if (this.d != null) {
                this.d.recycle();
            }
            this.c = null;
            this.d = null;
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
            this.g = null;
        } catch (Throwable th) {
            az.a(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(boolean z) {
        this.h = z;
        if (z) {
            this.g.setColor(-1);
        } else {
            this.g.setColor(C0151az.s);
        }
        invalidate();
    }

    public Bitmap b() {
        return this.h ? this.d : this.c;
    }

    public Point c() {
        return new Point(this.b, (getHeight() - this.i) - 10);
    }

    public void onDraw(Canvas canvas) {
        try {
            if (this.d != null) {
                this.g.getTextBounds("V2.4.1", 0, "V2.4.1".length(), this.a);
                int width = (this.d.getWidth() + 3) + this.a.width();
                if (this.k == 1) {
                    this.b = (this.j.getWidth() - width) / 2;
                } else if (this.k == 2) {
                    this.b = (this.j.getWidth() - width) - 10;
                } else {
                    this.b = 10;
                }
                if (n.d == a.ALIBABA) {
                    canvas.drawBitmap(b(), (float) (this.b + 15), (float) ((getHeight() - this.i) - 8), this.g);
                    canvas.drawText("V2.4.1", (float) ((this.d.getWidth() + this.b) - 4), (float) (getHeight() - 16), this.g);
                    return;
                }
                canvas.drawBitmap(b(), (float) this.b, (float) ((getHeight() - this.i) - 8), this.g);
                canvas.drawText("V2.4.1", (float) ((this.d.getWidth() + this.b) + 3), (float) (getHeight() - 12), this.g);
            }
        } catch (Throwable th) {
            az.a(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
