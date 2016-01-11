package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.t;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.g;

public class WeightGoalSetView extends View implements OnGestureListener {
    public static final int f = 0;
    public static final int g = 1;
    private static Context h;
    private static int i = 50;
    private static int j = 4;
    private static int k = 50;
    private static int l = 25;
    private static int m = (i + j);
    private static int n = 60;
    private static int o = 25;
    private static int p = 40;
    private static int q = 30;
    private static int r = 30;
    private static int s = 15;
    private static final String y = WeightGoalSetView.class.getSimpleName();
    private ag A;
    private Handler B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private int J;
    private int K;
    private List<Float> L;
    private boolean M;
    private int[] N;
    Paint a;
    Paint b;
    Paint c;
    Paint d;
    Paint e;
    private int t;
    private int u;
    private int v;
    private int w;
    private GestureDetector x;
    private float z;

    public WeightGoalSetView(Context context) {
        this(context, null);
    }

    public WeightGoalSetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = f;
        this.u = f;
        this.v = f;
        this.w = f;
        this.z = GroundOverlayOptions.NO_DIMENSION;
        this.B = new Handler();
        this.J = f;
        this.L = new ArrayList();
        this.M = false;
        this.N = new int[]{getResources().getColor(g.light_color), getResources().getColor(g.normal_color), getResources().getColor(g.heavy_color), getResources().getColor(g.fat_color)};
        h = context;
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = new Paint();
        this.x = new GestureDetector(context, this);
        TypedArray obtainStyledAttributes = h.obtainStyledAttributes(attributeSet, t.WeightGoalSetView);
        this.D = obtainStyledAttributes.getColor(f, getResources().getColor(g.light_color));
        this.E = obtainStyledAttributes.getColor(g, getResources().getColor(g.normal_color));
        this.F = obtainStyledAttributes.getColor(2, getResources().getColor(g.heavy_color));
        this.G = obtainStyledAttributes.getColor(3, getResources().getColor(g.fat_color));
        this.H = obtainStyledAttributes.getColor(6, -1);
        this.C = Keeper.readPersonInfo().miliConfig.weightUnit;
        this.I = aA.a(h, this.C);
        C0596r.e(y, "weightUnit " + this.I);
        this.J = obtainStyledAttributes.getInteger(5, f);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        i = (int) Utils.b(16.6f, h);
        j = (int) Utils.b(1.3f, h);
        k = (int) Utils.b(16.6f, h);
        l = (int) Utils.b(8.3f, h);
        m = (int) Utils.b(18.0f, h);
        o = (int) Utils.b(9.0f, h);
        p = Utils.a(10.3f, h);
        q = Utils.a(10.0f, h);
        s = (int) Utils.b(4.0f, h);
        n = (int) Utils.b(13.3f, h);
    }

    private int b(float f) {
        float f2 = 0.0f;
        C0596r.e(y, "calDefaultStartX:" + f);
        if (f == 0.0f) {
            f = ((Float) this.L.get(this.L.size() / 2)).floatValue();
        }
        C0596r.e(y, "mDivideBlocks " + this.K);
        int i = f;
        float f3 = 0.0f;
        while (i < this.K) {
            C0596r.e(y, "scalelist.geti & scalelist.geti+1 " + this.L.get(i) + " " + this.L.get(i + g));
            if (f >= ((Float) this.L.get(i)).floatValue() && f < ((Float) this.L.get(i + g)).floatValue()) {
                f3 = f - ((Float) this.L.get(i)).floatValue();
                float floatValue = ((Float) this.L.get(i + g)).floatValue() - ((Float) this.L.get(i)).floatValue();
                C0596r.e(y, "scaleWeight " + f3 + " totalWeight " + floatValue + "scale/total " + (f3 / floatValue) + " i*i/block " + (((float) i) * (1.0f / ((float) this.K))));
                f3 = (((float) i) * (1.0f / ((float) this.K))) + (((f3 / floatValue) * 1.0f) / ((float) this.K));
            }
            i += g;
        }
        if (f >= ((Float) this.L.get(this.K)).floatValue()) {
            f2 = 1.0f;
        } else if (f >= ((Float) this.L.get(f)).floatValue()) {
            f2 = f3;
        }
        this.v = ((int) (((float) ((this.t - (m * 2)) - (n * 2))) * f2)) + (n + m);
        return this.v;
    }

    private void b() {
        if (this.J == 0) {
            if (this.v < m + n) {
                this.v = m + n;
            } else if (this.v > (this.t - m) - n) {
                this.v = (this.t - m) - n;
            }
        }
        C0596r.e(y, "onScroll onTouchX " + this.v);
        invalidate();
    }

    private int c(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.t = size;
        if (mode == 1073741824) {
            return size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        return mode == af.a ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int d(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.u = size;
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        return mode == af.a ? Math.min(paddingTop, size) : paddingTop;
    }

    public void a(float f) {
        C0596r.e(y, "from userinfo weight " + f);
        this.z = f;
    }

    public void a(int i) {
        this.C = i;
        invalidate();
    }

    public void a(ag agVar) {
        this.A = agVar;
    }

    public void a(float... fArr) {
        if (fArr.length <= g || fArr.length > 5) {
            C0596r.e(y, " scale length is invalid");
            this.K = 3;
            this.L.clear();
            this.L.add(Float.valueOf(0.0f));
            this.L.add(Float.valueOf(50.0f));
            this.L.add(Float.valueOf(CropOverlayView.a));
            this.L.add(Float.valueOf(BitmapDescriptorFactory.HUE_MAGENTA));
        } else {
            C0596r.e(y, " scale length " + fArr.length);
            this.K = fArr.length - 1;
            this.L.clear();
            for (int i = f; i < fArr.length; i += g) {
                this.L.add(Float.valueOf(fArr[i]));
            }
        }
        invalidate();
    }

    public void b(int i) {
        this.J = i;
        invalidate();
    }

    public boolean onDown(MotionEvent motionEvent) {
        C0596r.e(y, "onDown getX " + motionEvent.getX());
        this.v = (int) motionEvent.getX();
        b();
        return true;
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int i2 = f;
        super.onDraw(canvas);
        int i3 = (this.t - (m * 2)) - (n * 2);
        if (this.K == 4) {
            this.a.setColor(this.N[f]);
        } else {
            this.a.setColor(this.N[g]);
        }
        canvas.drawCircle((float) (n + m), (float) (((this.u - k) / 2) + l), (float) l, this.a);
        if (this.K == 4) {
            this.a.setColor(this.N[this.K - 1]);
        } else {
            this.a.setColor(this.N[this.K]);
        }
        canvas.drawCircle((float) ((n + m) + i3), (float) (((this.u - k) / 2) + l), (float) l, this.a);
        for (int i4 = f; i4 < this.K; i4 += g) {
            if (this.K == 4) {
                this.a.setColor(this.N[i4]);
            } else {
                this.a.setColor(this.N[i4 + g]);
            }
            canvas.drawRect((((float) i3) * (((float) i4) / ((float) this.K))) + ((float) (n + m)), (float) ((this.u - k) / 2), (((float) i3) * (((float) (i4 + g)) / ((float) this.K))) + ((float) (n + m)), (float) ((this.u + k) / 2), this.a);
        }
        if (this.J == 0) {
            this.c.setColor(getResources().getColor(g.text_color_black));
        } else {
            this.c.setColor(getResources().getColor(g.weight_report_white_60));
        }
        this.c.setTextSize((float) p);
        this.c.setAntiAlias(true);
        if (this.J == 0) {
            int i5 = ((i + j) - (k / 2)) + j;
            for (int i6 = f; i6 < this.K - 1; i6 += g) {
                canvas.drawText(((int) (((Float) this.L.get(i6 + g)).floatValue() + 0.0f)) + a.f, (((float) (n + m)) + (((float) i3) * (((float) (i6 + g)) / ((float) this.K)))) - ((float) (((int) this.c.measureText(((int) (((Float) this.L.get(i6 + g)).floatValue() + 0.0f)) + a.f)) / 2)), (float) (((this.u / 2) + i) + i5), this.c);
            }
        } else if (this.J == g) {
            for (i = f; i < this.K - 1; i += g) {
                canvas.drawText(this.L.get(i + g) + a.f, (((float) (n + m)) + (((float) i3) * (((float) (i + g)) / ((float) this.K)))) - ((float) (((int) this.c.measureText(this.L.get(i + g) + a.f)) / 2)), (float) (((this.u / 2) + i) + 5), this.c);
            }
        }
        this.d.setColor(-1);
        this.d.setTextSize((float) Utils.a(11.6f, h));
        for (i = f; i < this.K; i += g) {
            if (this.K == 4) {
                canvas.drawText(getResources().getStringArray(f.weight_body_figures)[i], (((float) (n + m)) + (((float) i3) * (((float) i) / ((float) this.K)))) + (((((float) i3) / ((float) this.K)) - this.d.measureText(getResources().getStringArray(f.weight_body_figures)[i])) / 2.0f), ((float) (this.u / 2)) + Utils.b(4.0f, h), this.d);
            } else if (this.K != g) {
                canvas.drawText(getResources().getStringArray(f.weight_body_figures_for_child)[i + g], (((float) (n + m)) + (((float) i3) * (((float) i) / ((float) this.K)))) + (((((float) i3) / ((float) this.K)) - this.d.measureText(getResources().getStringArray(f.weight_body_figures)[i])) / 2.0f), ((float) (this.u / 2)) + Utils.b(4.0f, h), this.d);
            }
        }
        if (this.v == 0) {
            b(this.z);
        } else {
            C0596r.e(y, "onTouchX is not 0 " + this.v);
        }
        this.b.setColor(-1);
        if (this.J == g) {
            i = f;
            while (i < this.K) {
                if (((float) this.v) < ((float) m) + (((float) i3) * (((float) i) / ((float) this.K))) || this.v >= m + (((i + g) * i3) / this.K)) {
                    if (this.v == m + i3) {
                        if (this.K == 4) {
                            this.b.setColor(this.N[this.K - 1]);
                        } else {
                            this.b.setColor(this.N[this.K]);
                        }
                    }
                } else if (this.K == 4) {
                    this.b.setColor(this.N[i]);
                } else {
                    this.b.setColor(this.N[i + g]);
                }
                i += g;
            }
            Path path = new Path();
            path.reset();
            path.moveTo((float) this.v, (float) ((this.u - k) / 2));
            path.lineTo((float) (this.v + o), (float) (((this.u - k) / 2) - o));
            path.lineTo((float) (this.v - o), (float) (((this.u - k) / 2) - o));
            path.close();
            canvas.drawPath(path, this.b);
        } else if (this.J == 0) {
            this.b.setAntiAlias(true);
            canvas.drawCircle((float) this.v, (float) this.w, (float) (i + j), this.b);
            C0596r.e(y, "onTouchx " + this.v);
            C0596r.e(y, "raw " + n + m + i3);
            C0596r.e(y, "is == " + (this.v == (n + m) + i3));
            i = f;
            while (i < this.K) {
                if (((float) this.v) < ((float) (n + m)) + (((float) i3) * (((float) i) / ((float) this.K))) || ((float) this.v) >= ((float) (n + m)) + (((float) i3) * (((float) (i + g)) / ((float) this.K)))) {
                    if (this.v == (n + m) + i3) {
                        if (this.K == 4) {
                            this.b.setColor(this.N[this.K - 1]);
                        } else {
                            this.b.setColor(this.N[this.K]);
                        }
                    }
                } else if (this.K == 4) {
                    this.b.setColor(this.N[i]);
                } else {
                    this.b.setColor(this.N[i + g]);
                }
                i += g;
            }
            canvas.drawCircle((float) this.v, (float) this.w, (float) i, this.b);
        }
        this.d.reset();
        this.d.setColor(this.H);
        this.d.setAntiAlias(true);
        if (this.J == 0) {
            q = Utils.a(16.0f, h);
        } else if (this.J == g) {
            q = Utils.a(16.0f, h);
        }
        this.d.setTextSize((float) q);
        this.e.reset();
        this.e.setColor(this.H);
        this.e.setAntiAlias(true);
        this.e.setTextSize((float) r);
        float f = ((float) ((this.v - m) - n)) / ((float) i3);
        C0596r.e(y, "onTouch " + this.v + " bgVisibleWidth is " + i3 + " percent is " + f);
        C0596r.e(y, "percent in int " + Float.floatToIntBits(f));
        C0596r.e(y, "1.0f in int " + Float.floatToIntBits(1.0f));
        C0596r.e(y, "is == " + (Float.floatToIntBits(f) == Float.floatToIntBits(1.0f)));
        float f2 = 0.0f;
        while (i2 < this.K) {
            if (f >= ((float) i2) / ((float) this.K) && f < ((float) (i2 + g)) / ((float) this.K)) {
                f2 = (((((Float) this.L.get(i2 + g)).floatValue() - ((Float) this.L.get(i2)).floatValue()) * (f - (((float) i2) / ((float) this.K)))) * ((float) this.K)) + ((Float) this.L.get(i2)).floatValue();
            } else if (Float.floatToIntBits(f) == Float.floatToIntBits(1.0f)) {
                f2 = ((Float) this.L.get(this.K)).floatValue();
            }
            i2 += g;
        }
        f2 = ((float) Math.round(f2 * 10.0f)) / 10.0f;
        if (this.A != null) {
            this.A.a((float) ((int) f2));
        }
        if (this.J == g) {
            canvas.drawText(this.z + a.f, ((float) this.v) - (this.d.measureText(this.z + a.f) / 2.0f), ((float) ((((this.u / 2) - i) - j) - s)) - Utils.b(3.3f, h), this.d);
            return;
        }
        C0596r.e(y, "weight caculated from onTouchX  is " + f2 + " initWeight is " + this.z);
        if (this.M) {
            canvas.drawText(((int) f2) + a.f, ((float) this.v) - (this.d.measureText(((int) f2) + a.f) / 2.0f), ((float) ((((this.u / 2) - i) - j) - s)) - Utils.b(6.6f, h), this.d);
            canvas.drawText(this.I, ((this.d.measureText(((int) f2) + a.f) / 2.0f) + ((float) this.v)) + Utils.b(3.3f, h), ((float) ((((this.u / 2) - i) - j) - s)) - Utils.b(6.6f, h), this.e);
            return;
        }
        canvas.drawText(this.z + a.f, ((float) this.v) - (this.d.measureText(this.z + a.f) / 2.0f), ((float) ((((this.u / 2) - i) - j) - s)) - Utils.b(6.6f, h), this.d);
        canvas.drawText(this.I + a.f, (((float) this.v) + (this.d.measureText(this.z + a.f) / 2.0f)) + Utils.b(3.3f, h), ((float) ((((this.u / 2) - i) - j) - s)) - Utils.b(6.6f, h), this.e);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C0596r.e(y, "onFling");
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(c(i), d(i2));
        C0596r.e(y, "onMeasure width " + this.t + " and heght " + this.u);
        this.w = this.u / 2;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.v = (int) motionEvent2.getX();
        b();
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        C0596r.e(y, "onSingleTapUp e.getX " + motionEvent.getX());
        this.v = (int) motionEvent.getX();
        b();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.M = true;
        return this.J == 0 ? this.x.onTouchEvent(motionEvent) : true;
    }
}
