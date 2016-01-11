package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.d;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.t;
import java.util.ArrayList;
import java.util.Iterator;

public class RippleBackground extends RelativeLayout {
    private static final int a = 6;
    private static final int b = 4000;
    private static final float c = 6.0f;
    private static final int d = 0;
    private static final boolean e = true;
    private static final int f = 4;
    private static final float g = 55.0f;
    private static final float h = 243.3f;
    private static final float i = 288.3f;
    private ArrayList<C0852z> A = new ArrayList();
    private String B = "RippleBackground";
    private boolean j;
    private int k;
    private float l;
    private float m;
    private int n;
    private int o;
    private int p;
    private float q;
    private int r;
    private float s;
    private float t;
    private int u;
    private Paint v;
    private boolean w = false;
    private AnimatorSet x;
    private ArrayList<Animator> y;
    private LayoutParams z;

    public RippleBackground(Context context) {
        super(context);
    }

    public RippleBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public RippleBackground(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            if (attributeSet == null) {
                throw new IllegalArgumentException("Attributes should be provided to this view,");
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.RippleBackground);
            this.j = obtainStyledAttributes.getBoolean(d, e);
            if (this.j) {
                this.k = obtainStyledAttributes.getColor(1, getResources().getColor(i.rippelColor));
                this.l = obtainStyledAttributes.getDimension(2, 4.0f);
                this.m = obtainStyledAttributes.getDimension(5, g);
                this.n = obtainStyledAttributes.getInt(a, b);
                this.o = obtainStyledAttributes.getInt(7, a);
                this.q = obtainStyledAttributes.getFloat(8, c);
                this.r = obtainStyledAttributes.getInt(9, d);
                this.s = obtainStyledAttributes.getDimension(3, h);
                this.t = obtainStyledAttributes.getDimension(f, i);
                C0596r.e(this.B, "cx : " + this.s + "; cy: " + this.t);
                obtainStyledAttributes.recycle();
                this.p = this.n / this.o;
                this.u = (int) (((double) this.m) * Math.pow(1.35d, (double) this.o));
                this.v = new Paint();
                this.v.setAntiAlias(e);
                if (this.r == 0) {
                    this.l = 4.0f;
                    this.v.setStyle(Style.FILL);
                } else {
                    this.v.setStyle(Style.STROKE);
                }
                this.v.setColor(this.k);
                this.z = new LayoutParams(1080, 1920);
                this.z.addRule(13);
                this.x = new AnimatorSet();
                this.x.setInterpolator(new AccelerateDecelerateInterpolator());
                this.y = new ArrayList();
                for (int i = d; i < this.o; i++) {
                    View c0852z = new C0852z(this, getContext());
                    addView(c0852z, this.z);
                    this.A.add(c0852z);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.m, (float) this.u});
                    ofFloat.setDuration((long) this.n);
                    ofFloat.addUpdateListener(new C0851y(this, c0852z));
                    ofFloat.setRepeatMode(1);
                    ofFloat.setStartDelay((long) (this.p * i));
                    ofFloat.setRepeatCount(-1);
                    this.y.add(ofFloat);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(c0852z, "Alpha", new float[]{d.b, 0.0f});
                    ofFloat2.setRepeatCount(-1);
                    ofFloat2.setRepeatMode(1);
                    ofFloat2.setStartDelay((long) (this.p * i));
                    ofFloat2.setDuration((long) this.n);
                    this.y.add(ofFloat2);
                }
                this.x.playTogether(this.y);
            }
        }
    }

    public void a() {
        if (this.j && !e()) {
            Iterator it = this.A.iterator();
            while (it.hasNext()) {
                ((C0852z) it.next()).setVisibility(d);
            }
            this.x.start();
            this.w = e;
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b() {
        if (e()) {
            this.x.end();
            this.w = false;
        }
    }

    public void c() {
        if (e()) {
            this.x.pause();
            this.w = false;
        }
    }

    public void d() {
        if (!e()) {
            this.x.resume();
            this.w = e;
        }
    }

    public boolean e() {
        return this.w;
    }
}
