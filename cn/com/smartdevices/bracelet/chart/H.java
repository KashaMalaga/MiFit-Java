package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.amap.api.maps.model.GroundOverlayOptions;

public class H extends c implements Comparable<H> {
    public H(Context context) {
        super(context);
    }

    public int a(H h) {
        return h.c - this.c;
    }

    public void a(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        a(canvas, this.j, f, f2, f3, f4, f5);
    }

    protected void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5) {
        if (this.e || rectF.height() != 0.0f) {
            int i;
            float h;
            float f6;
            A a = (A) v();
            float f7 = a.M;
            float n = a.N;
            if (rectF.right < f7 || rectF.left > n) {
                i = a.ad;
                h = a.ag;
            } else {
                f7 = rectF.left < f7 ? f7 - rectF.left : rectF.right > n ? rectF.right - n : 0.0f;
                n = rectF.width() / 2.0f;
                if (f7 >= n) {
                    i = a.ad;
                    h = a.ag;
                } else if (f7 == 0.0f) {
                    i = a.ac;
                    h = a.af;
                } else {
                    f6 = f7 / n;
                    i = t.a(a.ac, a.ad, f6);
                    h = a.af - ((a.af - a.ag) * f6);
                }
            }
            this.o.c.setColor(i);
            n = rectF.centerX();
            f6 = f2 == GroundOverlayOptions.NO_DIMENSION ? rectF.top : f2;
            f7 = f3 == GroundOverlayOptions.NO_DIMENSION ? rectF.top : f3;
            if (f2 == GroundOverlayOptions.NO_DIMENSION && f3 == GroundOverlayOptions.NO_DIMENSION) {
                f6 = this.p * 185.0f;
                f7 = rectF.top;
            }
            f7 = ((f7 - f6) * f) + f6;
            h *= this.p;
            h = (f2 != GroundOverlayOptions.NO_DIMENSION || f3 == GroundOverlayOptions.NO_DIMENSION) ? h * f : h * (1.0f - f);
            canvas.drawCircle(n, f7, h, this.o.c);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((H) obj);
    }
}
