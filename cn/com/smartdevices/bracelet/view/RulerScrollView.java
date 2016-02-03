package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class RulerScrollView extends HorizontalScrollView {
    private static final String a = "RulerScrollView";
    private static final float b = 2.6f;
    private static Handler q = new Handler();
    private GestureDetector c;
    private LayoutInflater d;
    private int e = 0;
    private int f = 100;
    private LinearLayout g;
    private int h;
    private float i;
    private int j;
    private float k;
    private View l;
    private int m = h.k;
    private TextView n;
    private TextView o;
    private int p = 0;
    private SimpleOnGestureListener r = new A(this);

    public RulerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new GestureDetector(context, this.r);
        this.d = LayoutInflater.from(context);
        this.d.inflate(R.layout.ruler_scroller, this);
        this.g = (LinearLayout) findViewById(R.id.ruler_content);
    }

    public RulerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private float a(int i, int i2) {
        float abs = (float) (Math.abs((((((double) i) + 0.5d) * ((double) this.m)) - ((double) i2)) - ((double) (((float) this.j) / 2.0f))) / ((double) (((float) this.m) * 2.0f)));
        return ((double) (1.0f - abs)) > 1.0E-6d ? abs : 1.0f;
    }

    private void b(int i) {
        this.k = (float) Math.round((((((float) i) / this.i) + ((float) this.e)) + ((((float) this.j) / 2.0f) / this.i)) - b);
        this.n.setText(((int) this.k) + a.f);
    }

    private void c(int i) {
        int i2 = (int) ((((float) i) + (((float) this.j) / 2.0f)) / ((float) this.m));
        View childAt = this.g.getChildAt(i2);
        if (childAt != null) {
            childAt.findViewById(R.id.ruler_txt).setAlpha(0.1f);
        }
        if (i2 > 0) {
            childAt = this.g.getChildAt(i2 - 1);
            float a = a(i2 - 1, i);
            if (childAt != null) {
                childAt.findViewById(R.id.ruler_txt).setAlpha(a);
            }
        }
        if (i2 < this.g.getChildCount() - 1) {
            childAt = this.g.getChildAt(i2 + 1);
            float a2 = a(i2 + 1, i);
            if (childAt != null) {
                childAt.findViewById(R.id.ruler_txt).setAlpha(a2);
            }
        }
    }

    private void d() {
        C0596r.e(a, "adjust left from:" + this.p);
        this.p = (int) (this.i * (((this.k - ((float) this.e)) + b) - (((float) (this.j / 2)) / this.i)));
        C0596r.e(a, "adjust left to:" + this.p);
        smoothScrollTo(a(), 0);
        smoothScrollTo(this.p, 0);
        invalidate();
    }

    public int a() {
        return this.p;
    }

    public void a(int i) {
        this.p = i;
        scrollTo(i, 0);
    }

    public void a(int i, int i2, String str) {
        this.e = i;
        this.f = i2;
        this.o.setText(str);
    }

    public void a(View view) {
        this.l = view;
        this.n = (TextView) this.l.findViewById(R.id.ruler_indicator_txt);
        this.o = (TextView) this.l.findViewById(R.id.ruler_indicator_unit);
    }

    public void addView(View view) {
        this.g.addView(view);
    }

    public float b() {
        return this.k;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b(i);
        c(i);
        this.p = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
        }
        if (!this.c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            d();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        this.h = this.g.getWidth();
        this.j = getWidth();
        this.i = ((float) this.h) / ((float) (this.f - this.e));
        View childAt = this.g.getChildAt(0);
        if (childAt != null) {
            this.m = childAt.getWidth();
        }
        b(this.p);
        c(this.p);
        scrollTo(this.p, 0);
    }
}
