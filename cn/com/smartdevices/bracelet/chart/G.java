package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class G extends D {
    final /* synthetic */ A b;
    private Path x = new Path();
    private Paint y = new Paint(1);

    public G(A a, Context context) {
        this.b = a;
        super(a, context);
        this.y.setStyle(Style.STROKE);
        this.y.setStrokeWidth(a.ag * this.p);
        this.y.setColor(a.ad);
    }

    private void a(Canvas canvas, Paint paint, PointF[] pointFArr, PointF[] pointFArr2) {
        int i = 0;
        float[] fArr = new float[(pointFArr.length * 2)];
        int i2 = 0;
        for (PointF pointF : pointFArr) {
            fArr[i2] = pointF.x;
            i2++;
            fArr[i2] = pointF.y;
            i2++;
        }
        paint.setColor(-16711936);
        canvas.drawPoints(fArr, paint);
        float[] fArr2 = new float[(pointFArr2.length * 2)];
        int length = pointFArr2.length;
        int i3 = 0;
        while (i < length) {
            PointF pointF2 = pointFArr2[i];
            fArr2[i3] = pointF2.x;
            i3++;
            fArr2[i3] = pointF2.y;
            i3++;
            i++;
        }
        canvas.drawPoints(fArr2, paint);
    }

    private void a(Canvas canvas, Path path, Paint paint, PointF[] pointFArr) {
        int i = 0;
        PointF pointF = pointFArr[0];
        path.moveTo(pointF.x, pointF.y);
        while (i < pointFArr.length - 2) {
            pointF = pointFArr[i];
            PointF pointF2 = pointFArr[i + 1];
            path.quadTo(pointF.x, pointF.y, (pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
            i++;
        }
        PointF pointF3 = pointFArr[pointFArr.length - 2];
        pointF = pointFArr[pointFArr.length - 1];
        path.quadTo(pointF3.x, pointF3.y, pointF.x, pointF.y);
        paint.setColor(-16711681);
        canvas.drawPath(path, paint);
    }

    private void a(Canvas canvas, Path path, RectF rectF, Paint paint) {
        float[] fArr;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int centerX = (int) rectF.centerX();
        int i = (int) length;
        int i2 = 0;
        while (i2 <= i && ((float) i2) <= length && ((float) i) <= length) {
            int i3 = i2 + ((i - i2) >> 1);
            fArr = new float[2];
            pathMeasure.getPosTan((float) i3, fArr, null);
            if (centerX == ((int) fArr[0])) {
                break;
            } else if (((float) centerX) > fArr[0]) {
                i = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        fArr = null;
        if (fArr != null) {
            canvas.drawLine(rectF.centerX(), rectF.bottom, rectF.centerX(), fArr[1], paint);
        }
    }

    private float[] a(float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        float[] fArr3 = new float[length];
        float f = 2.0f;
        fArr2[0] = fArr[0] / 2.0f;
        int i = 1;
        while (i < length) {
            fArr3[i] = 1.0f / f;
            float f2 = (i < length + -1 ? 4.0f : 3.5f) - fArr3[i];
            fArr2[i] = (fArr[i] - fArr2[i - 1]) / f2;
            i++;
            f = f2;
        }
        for (int i2 = 1; i2 < length; i2++) {
            int i3 = (length - i2) - 1;
            fArr2[i3] = fArr2[i3] - (fArr3[length - i2] * fArr2[length - i2]);
        }
        return fArr2;
    }

    private PointF[][] a(PointF[] pointFArr, PointF[] pointFArr2, PointF[] pointFArr3) {
        if (pointFArr == null) {
            throw new IllegalArgumentException("knots");
        }
        int length = pointFArr.length - 1;
        if (length < 1) {
            throw new IllegalArgumentException("At least two knot points required");
        } else if (length == 1) {
            PointF[] pointFArr4 = new PointF[]{new PointF()};
            pointFArr4[0].x = ((2.0f * pointFArr[0].x) + pointFArr[1].x) / 3.0f;
            pointFArr4[0].x = ((2.0f * pointFArr[0].y) + pointFArr[1].y) / 3.0f;
            PointF[] pointFArr5 = new PointF[]{new PointF()};
            pointFArr5[0].x = (2.0f * pointFArr4[0].x) - pointFArr[0].x;
            pointFArr5[0].y = (2.0f * pointFArr4[0].y) - pointFArr[0].y;
            r0 = (PointF[][]) Array.newInstance(PointF.class, new int[]{2, 1});
            r0[0] = pointFArr4;
            r0[1] = pointFArr5;
            return r0;
        } else {
            int i;
            float[] fArr = new float[length];
            for (i = 1; i < length - 1; i++) {
                fArr[i] = (4.0f * pointFArr[i].x) + (2.0f * pointFArr[i + 1].x);
            }
            fArr[0] = pointFArr[0].x + (2.0f * pointFArr[1].x);
            fArr[length - 1] = ((8.0f * pointFArr[length - 1].x) + pointFArr[length].x) / 2.0f;
            float[] a = a(fArr);
            for (i = 1; i < length - 1; i++) {
                fArr[i] = (4.0f * pointFArr[i].y) + (2.0f * pointFArr[i + 1].y);
            }
            fArr[0] = pointFArr[0].y + (2.0f * pointFArr[1].y);
            fArr[length - 1] = ((8.0f * pointFArr[length - 1].y) + pointFArr[length].y) / 2.0f;
            fArr = a(fArr);
            PointF[] pointFArr6 = new PointF[length];
            PointF[] pointFArr7 = new PointF[length];
            for (i = 0; i < length; i++) {
                pointFArr6[i] = new PointF(a[i], fArr[i]);
                if (i < length - 1) {
                    pointFArr7[i] = new PointF((2.0f * pointFArr[i + 1].x) - a[i + 1], (2.0f * pointFArr[i + 1].y) - fArr[i + 1]);
                } else {
                    pointFArr7[i] = new PointF((pointFArr[length].x + a[length - 1]) / 2.0f, (pointFArr[length].y + fArr[length - 1]) / 2.0f);
                }
            }
            r0 = (PointF[][]) Array.newInstance(PointF.class, new int[]{2, length});
            r0[0] = pointFArr6;
            r0[1] = pointFArr7;
            return r0;
        }
    }

    private void b(Canvas canvas, Path path, Paint paint, PointF[] pointFArr) {
        PointF[][] a = a(pointFArr, null, null);
        PointF[] pointFArr2 = a[0];
        PointF[] pointFArr3 = a[1];
        PointF pointF = pointFArr[0];
        path.moveTo(pointF.x, pointF.y);
        for (int i = 0; i < pointFArr.length - 1; i++) {
            PointF pointF2 = pointFArr2[i];
            PointF pointF3 = pointFArr3[i];
            PointF pointF4 = pointFArr[i + 1];
            path.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
        }
        canvas.drawPath(path, paint);
    }

    public void a(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        synchronized (this.s) {
            this.x.rewind();
            List<c> arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (int i = 0; i < this.s.size(); i++) {
                c cVar = (c) this.s.get(i);
                if (cVar.e) {
                    RectF m = cVar.m();
                    float centerX = m.centerX();
                    float f6 = f2 == GroundOverlayOptions.NO_DIMENSION ? m.top : f2;
                    float f7 = f3 == GroundOverlayOptions.NO_DIMENSION ? m.top : f3;
                    if (f2 == GroundOverlayOptions.NO_DIMENSION && f3 == GroundOverlayOptions.NO_DIMENSION) {
                        f6 = this.p * 185.0f;
                        f7 = m.top;
                    }
                    arrayList2.add(new PointF(centerX, ((f7 - f6) * f) + f6));
                    arrayList.add(cVar);
                }
            }
            if (arrayList2.size() > 2) {
                b(canvas, this.x, this.y, (PointF[]) arrayList2.toArray(new PointF[arrayList2.size()]));
            } else if (arrayList2.size() == 2 && this.s.size() == 2) {
                PointF pointF = (PointF) arrayList2.get(0);
                this.x.moveTo(pointF.x, pointF.y);
                pointF = (PointF) arrayList2.get(1);
                this.x.lineTo(pointF.x, pointF.y);
                canvas.drawPath(this.x, this.y);
            }
            for (c cVar2 : arrayList) {
                ((H) cVar2).a(canvas, f, f2, f3, f4, f5);
            }
        }
    }

    protected boolean a(c cVar) {
        int i = this.b.f.g;
        return cVar.c >= ((i - this.b.L) + -1) + -2 && cVar.c <= ((i + this.b.L) + 1) + 2;
    }

    protected float b(RectF rectF, c cVar) {
        return (((float) (cVar.b - this.e)) / ((float) (this.d - this.e))) * ((rectF.height() - this.l) - this.n);
    }

    public void e() {
        int j = this.b.D;
        int k = this.b.E;
        int i = j;
        j = k;
        for (c cVar : this.s) {
            if (a(cVar)) {
                if (cVar.b > i) {
                    int i2 = (((cVar.b - i) / 30) + 1) * 30;
                    i += i2;
                    j -= i2;
                }
                if (cVar.b < j) {
                    k = (((j - cVar.b) / 30) + 1) * 30;
                    i += k;
                    k = j - k;
                    j = i;
                    i = j;
                    j = k;
                }
            }
            k = j;
            j = i;
            i = j;
            j = k;
        }
        if (i != this.d) {
            this.b.I = GroundOverlayOptions.NO_DIMENSION;
            this.b.ah = null;
            i(i);
            a(true);
        }
        if (j != this.e) {
            this.b.I = GroundOverlayOptions.NO_DIMENSION;
            this.b.ah = null;
            j(j);
            a(true);
        }
        super.e();
    }
}
