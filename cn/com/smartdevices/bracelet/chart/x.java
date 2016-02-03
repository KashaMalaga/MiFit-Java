package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class x extends q {
    private static final String g = "LinePieChart";
    private static final float h = 1.33f;
    private static final float i = 16.33f;
    private SweepGradient A;
    private boolean B;
    private int C;
    private Bitmap D;
    private Bitmap E;
    private Paint F;
    private Paint G;
    private float H;
    private Paint I;
    private Paint J;
    private RectF K;
    private boolean L;
    private int M;
    private int N = h.E;
    private final int x;
    private int y = 0;
    private final Paint z;

    public x(Context context) {
        super(context);
        this.D = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.ic_small_mili)).getBitmap();
        this.F = new Paint(1);
        this.G = new Paint(1);
        this.F.setColor(Color.parseColor("#e8edf3"));
        this.F.setStrokeWidth(this.p * h);
        this.F.setStyle(Style.STROKE);
        this.G.setColor(Color.parseColor("#33e8edf3"));
        this.G.setStrokeWidth(this.p * h);
        this.G.setStyle(Style.STROKE);
        this.H = i * this.p;
        this.I = new Paint(1);
        this.I.setColor(Color.parseColor("#4Cffffff"));
        this.I.setStrokeWidth(4.0f);
        this.I.setStyle(Style.STROKE);
        this.J = new Paint(1);
        this.J.setColor(Color.parseColor("#BBffffff"));
        this.J.setStrokeWidth(4.0f);
        this.J.setStyle(Style.STROKE);
        this.z = new Paint(1);
        this.z.setStrokeWidth(4.0f);
        this.z.setStyle(Style.STROKE);
        this.x = context.getResources().getDimensionPixelSize(R.dimen.draw_weight_icon_round);
    }

    private void a(Canvas canvas, RectF rectF) {
        canvas.drawArc(rectF, -90.0f, (((float) this.M) / ((float) this.N)) * 360.0f, false, this.J);
        canvas.drawArc(rectF, -90.0f, 360.0f, false, this.I);
    }

    private void b(Canvas canvas, RectF rectF) {
        canvas.drawRoundRect(rectF, (float) this.x, (float) this.x, this.I);
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        Path path = new Path();
        float f = (((float) this.M) / ((float) this.N)) * 360.0f;
        float width = rectF.width() / 2.0f;
        float f2 = (float) this.x;
        float f3 = width - f2;
        float atan = (float) ((Math.atan((double) (f3 / width)) / 6.283185307179586d) * 360.0d);
        float tan = (float) (Math.tan(Math.toRadians((double) f)) * ((double) width));
        path.setLastPoint(centerX, rectF.top);
        if (f < atan) {
            path.rLineTo(tan, 0.0f);
        } else {
            path.rLineTo(f3, 0.0f);
        }
        RectF rectF2 = new RectF(rectF);
        rectF2.set(centerX - f2, centerY - f2, centerX + f2, f2 + centerY);
        rectF2.offset(f3, -f3);
        if (f < 90.0f - atan && f >= atan) {
            path.addArc(rectF2, -90.0f, ((f - atan) / (90.0f - (2.0f * atan))) * 90.0f);
        } else if (f > 90.0f - atan) {
            path.addArc(rectF2, -90.0f, 90.0f);
        }
        if (f >= 90.0f - atan && f < 90.0f) {
            f2 = f3 - (((float) Math.tan(Math.toRadians((double) (90.0f - f)))) * width);
            path.moveTo(centerX + width, centerY - f3);
            path.rLineTo(0.0f, f2);
        } else if (f > 90.0f) {
            path.moveTo(centerX + width, centerY - f3);
            path.rLineTo(0.0f, f3);
        }
        f2 = 90.0f + atan;
        float f4 = BitmapDescriptorFactory.HUE_CYAN - atan;
        if (f > 90.0f && f < 90.0f + atan) {
            path.rLineTo(0.0f, (float) (Math.tan(Math.toRadians((double) (f - 90.0f))) * ((double) width)));
        } else if (f >= 90.0f + atan) {
            path.rLineTo(0.0f, f3);
        }
        if (f > f2 && f < f4) {
            f2 = f - 90.0f;
            rectF2.offset(0.0f, 2.0f * f3);
            path.addArc(rectF2, 0.0f, ((f2 - atan) / (90.0f - (2.0f * atan))) * 90.0f);
        } else if (f > f4) {
            rectF2.offset(0.0f, 2.0f * f3);
            path.addArc(rectF2, 0.0f, 90.0f);
        }
        if (f >= f4 && f < BitmapDescriptorFactory.HUE_CYAN) {
            f2 = f3 - (((float) Math.tan(Math.toRadians((double) (90.0f - (f - 90.0f))))) * width);
            path.moveTo(centerX + f3, centerY + width);
            path.rLineTo(-f2, 0.0f);
        } else if (f >= BitmapDescriptorFactory.HUE_CYAN) {
            path.moveTo(centerX + f3, centerY + width);
            path.rLineTo(-f3, 0.0f);
        }
        f2 = BitmapDescriptorFactory.HUE_CYAN + atan;
        f4 = BitmapDescriptorFactory.HUE_VIOLET - atan;
        if (f > BitmapDescriptorFactory.HUE_CYAN && f < f2) {
            path.rLineTo(-((float) (Math.tan(Math.toRadians((double) (f - BitmapDescriptorFactory.HUE_CYAN))) * ((double) width))), 0.0f);
        } else if (f >= f2) {
            path.rLineTo(-f3, 0.0f);
        }
        if (f >= f2 && f < f4) {
            f2 = f - BitmapDescriptorFactory.HUE_CYAN;
            rectF2.offset((-f3) * 2.0f, 0.0f);
            path.addArc(rectF2, 90.0f, ((f2 - atan) / (90.0f - (2.0f * atan))) * 90.0f);
        } else if (f > f4) {
            rectF2.offset((-f3) * 2.0f, 0.0f);
            path.addArc(rectF2, 90.0f, 90.0f);
        }
        if (f >= f4 && f < BitmapDescriptorFactory.HUE_VIOLET) {
            f2 = f3 - (((float) Math.tan(Math.toRadians((double) (90.0f - (f - BitmapDescriptorFactory.HUE_CYAN))))) * width);
            path.moveTo(centerX - width, centerY + f3);
            path.rLineTo(0.0f, -f2);
        } else if (f >= BitmapDescriptorFactory.HUE_VIOLET) {
            path.moveTo(centerX - width, centerY + f3);
            path.rLineTo(0.0f, -f3);
        }
        f4 = BitmapDescriptorFactory.HUE_VIOLET + atan;
        float f5 = (90.0f + BitmapDescriptorFactory.HUE_VIOLET) - atan;
        if (f > BitmapDescriptorFactory.HUE_VIOLET && f < f4) {
            path.rLineTo(0.0f, -((float) (Math.tan(Math.toRadians((double) (f - BitmapDescriptorFactory.HUE_VIOLET))) * ((double) width))));
        } else if (f >= f4) {
            path.rLineTo(0.0f, -f3);
        }
        if (f >= f4 && f < f5) {
            f4 = f - BitmapDescriptorFactory.HUE_VIOLET;
            rectF2.offset(0.0f, (-f3) * 2.0f);
            path.addArc(rectF2, BitmapDescriptorFactory.HUE_CYAN, ((f4 - atan) / (90.0f - (atan * 2.0f))) * 90.0f);
        } else if (f > f5) {
            rectF2.offset(0.0f, (-f3) * 2.0f);
            path.addArc(rectF2, BitmapDescriptorFactory.HUE_CYAN, 90.0f);
        }
        if (f >= f5 && f < 360.0f) {
            f = f3 - (((float) Math.tan(Math.toRadians((double) (90.0f - (f - BitmapDescriptorFactory.HUE_VIOLET))))) * width);
            path.moveTo(centerX - f3, centerY - width);
            path.rLineTo(f, 0.0f);
        } else if (f >= 360.0f) {
            path.moveTo(centerX - f3, centerY - width);
            path.rLineTo(f3, 0.0f);
        }
        canvas.drawPath(path, this.J);
    }

    public void a() {
        this.B = true;
        this.L = false;
    }

    public void a(int i) {
        this.C = i;
        this.L = false;
    }

    public void a(Bitmap bitmap) {
        this.E = bitmap;
    }

    protected void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5) {
        float strokeWidth = (f3 - (this.I.getStrokeWidth() / 2.0f)) - this.H;
        RectF rectF2 = new RectF(f - strokeWidth, f2 - strokeWidth, f + strokeWidth, strokeWidth + f2);
        if (!this.L) {
            if (this.B) {
                this.A = new SweepGradient(f, f2, new int[]{1157627903, -1}, null);
                this.z.setShader(this.A);
            }
            this.L = true;
        }
        if (this.B) {
            strokeWidth = this.e * 360.0f;
            Matrix matrix = new Matrix();
            matrix.setRotate(strokeWidth, f, f2);
            this.A.setLocalMatrix(matrix);
        }
        switch (this.C) {
            case a.i /*0*/:
                if (!this.B) {
                    this.y = 0;
                    canvas.drawArc(rectF2, (float) ((this.y / 2) + 270), (float) (360 - this.y), false, this.I);
                    break;
                }
                canvas.drawArc(rectF2, BitmapDescriptorFactory.HUE_VIOLET, 360.0f, false, this.z);
                break;
            case l.a /*1*/:
                float f6 = 1.0f - f4;
                t.a(canvas, this.K.centerX(), this.K.centerY(), this.q, this.D, null);
                this.y = 18;
                canvas.drawArc(rectF2, (float) ((this.y / 2) + 270), (float) (360 - this.y), false, this.I);
                canvas.drawArc(rectF2, (float) ((this.y / 2) + 270), ((float) (360 - this.y)) * f6, false, this.J);
                break;
            case a.k /*2*/:
                if (this.B) {
                    canvas.drawArc(rectF2, BitmapDescriptorFactory.HUE_VIOLET, 360.0f, false, this.z);
                    break;
                }
                break;
            case a.l /*3*/:
                canvas.drawRoundRect(rectF2, (float) this.x, (float) this.x, this.I);
                break;
            case a.aQ /*4*/:
                canvas.drawRoundRect(rectF2, (float) this.x, (float) this.x, this.z);
                break;
            case a.X /*5*/:
                b(canvas, rectF2);
                break;
            case a.bt /*6*/:
                a(canvas, rectF2);
                break;
        }
        if (this.E != null) {
            canvas.drawBitmap(this.E, f - ((float) (this.E.getWidth() / 2)), f2 - ((float) (this.E.getHeight() / 2)), null);
        }
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        this.K = new RectF();
        this.K.left = rectF.centerX() - (15.5f * this.p);
        this.K.top = rectF.top + (2.0f * this.p);
        this.K.right = this.K.left + (this.p * 31.0f);
        this.K.bottom = this.K.top + (this.p * 31.0f);
        C0596r.e(g, "onRectChanged:" + rectF);
    }

    public void b() {
        C0596r.e(g, "dismissLoading.");
        this.B = false;
        this.L = false;
    }

    public void b(int i) {
        this.N = i;
    }

    public int c() {
        return this.N;
    }

    public void c(int i) {
        this.M = i;
    }

    public int d() {
        return this.M;
    }
}
