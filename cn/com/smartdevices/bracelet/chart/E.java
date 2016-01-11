package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.GroundOverlayOptions;

public class E extends c {
    public int a;

    public E(Context context) {
        super(context);
    }

    public void a(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        a(canvas, this.j, f, f2, f3, f4, f5);
    }

    protected void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5) {
        if (this.e || rectF.height() != 0.0f) {
            float f6;
            float f7;
            float f8;
            float f9;
            Paint paint;
            if (f2 == GroundOverlayOptions.NO_DIMENSION) {
                f6 = 0.0f;
                f7 = 0.0f;
                f8 = f5;
                f9 = f3;
            } else {
                f9 = rectF.height();
                f8 = rectF.height() * (((float) this.a) / ((float) this.b));
                f7 = f4;
                f6 = f2;
            }
            if (f3 == GroundOverlayOptions.NO_DIMENSION) {
                f9 = rectF.height();
                f8 = rectF.height() * (((float) this.a) / ((float) this.b));
            } else if (f3 == -2.0f) {
                f6 = rectF.height();
                f7 = (((float) this.a) / ((float) this.b)) * rectF.height();
                f9 = 0.0f;
                f8 = 0.0f;
            } else {
                f6 = rectF.height();
                f7 = rectF.height() * (((float) this.a) / ((float) this.b));
            }
            f6 += (f9 - f6) * f;
            float f10 = f7 + ((f8 - f7) * f);
            float width = rectF.width();
            f7 = (rectF.width() / 2.0f) + rectF.left;
            f9 = rectF.bottom;
            float f11 = rectF.bottom - f6;
            this.o.c.setStrokeWidth(width);
            A a = (A) v();
            if (this.a < 0 || this.b <= 0) {
                paint = null;
            } else {
                Paint paint2 = new Paint();
                paint2.setStrokeWidth(width);
                paint = paint2;
            }
            int i = 0;
            int i2 = 0;
            if (a.S == 16) {
                i = a.U;
                i2 = a.V;
            } else if (a.S == 1) {
                i = a.Y;
                i2 = a.Z;
            } else if (a.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                i = -6042459;
                i2 = -9384843;
            }
            float f12 = a.M;
            float n = a.N;
            int y;
            if (rectF.right < f12 || rectF.left > n) {
                int i3;
                int x = a.ab;
                int x2 = a.ab;
                int y2 = a.X;
                y = a.X;
                if (f2 > GroundOverlayOptions.NO_DIMENSION) {
                    x = a.aa;
                    y2 = a.W;
                    i3 = i;
                } else {
                    i3 = i2;
                }
                if (f3 > GroundOverlayOptions.NO_DIMENSION) {
                    y = a.aa;
                    i2 = i;
                    i = a.W;
                } else {
                    i = y;
                    y = x2;
                }
                if (i3 != i2) {
                    i2 = t.a(i3, i2, f);
                }
                this.o.c.setColor(i2);
                if (paint != null) {
                    if (a.S == 16) {
                        paint.setColor(y2 == i ? i : t.a(y2, i, f));
                    } else if (a.S == 1) {
                        paint.setColor(x == y ? y : t.a(x, y, f));
                    }
                }
            } else {
                float f13 = 0.0f;
                if (rectF.left < f12) {
                    f13 = f12 - rectF.left;
                } else if (rectF.right > n) {
                    f13 = rectF.right - n;
                }
                f12 = rectF.width() / 2.0f;
                if (f13 >= f12) {
                    i = a.ab;
                    y = i2;
                    i2 = a.X;
                } else if (f13 == 0.0f) {
                    y = a.aa;
                    i2 = a.W;
                    int i4 = y;
                    y = i;
                    i = i4;
                } else {
                    f12 = f13 / f12;
                    y = t.a(i, i2, f12);
                    i = t.a(a.aa, a.ab, f12);
                    i2 = t.a(a.W, a.X, f12);
                }
                this.o.c.setColor(y);
                if (paint != null) {
                    if (a.S == 16) {
                        paint.setColor(i2);
                    } else if (a.S == 1) {
                        paint.setColor(i);
                    }
                }
            }
            canvas.drawLine(f7, f9, f7, f11, this.o.c);
            if (paint != null) {
                canvas.drawLine(f7, f9, f7, rectF.bottom - f10, paint);
            }
        }
    }
}
