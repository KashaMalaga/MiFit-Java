package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;

public class PagerTabStrip extends PagerTitleStrip {
    private static final String f = "PagerTabStrip";
    private static final int g = 3;
    private static final int h = 6;
    private static final int i = 16;
    private static final int j = 32;
    private static final int k = 64;
    private static final int l = 1;
    private static final int m = 32;
    private float A;
    private float B;
    private int C;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final Paint t;
    private final Rect u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new Paint();
        this.u = new Rect();
        this.v = HeartRateInfo.HR_EMPTY_VALUE;
        this.w = false;
        this.x = false;
        this.n = this.e;
        this.t.setColor(this.n);
        float f = context.getResources().getDisplayMetrics().density;
        this.o = (int) ((3.0f * f) + 0.5f);
        this.p = (int) ((6.0f * f) + 0.5f);
        this.q = (int) (64.0f * f);
        this.s = (int) ((16.0f * f) + 0.5f);
        this.y = (int) ((1.0f * f) + 0.5f);
        this.r = (int) ((f * 32.0f) + 0.5f);
        this.C = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        c(d());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new C0131af(this));
        this.d.setFocusable(true);
        this.d.setOnClickListener(new C0132ag(this));
        if (getBackground() == null) {
            this.w = true;
        }
    }

    public int a() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
        this.t.setColor(this.n);
        invalidate();
    }

    void a(int i, float f, boolean z) {
        Rect rect = this.u;
        int height = getHeight();
        int i2 = height - this.o;
        rect.set(this.c.getLeft() - this.s, i2, this.c.getRight() + this.s, height);
        super.a(i, f, z);
        this.v = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.s, i2, this.c.getRight() + this.s, height);
        invalidate(rect);
    }

    public void a(boolean z) {
        this.w = z;
        this.x = true;
        invalidate();
    }

    public void b(int i) {
        a(getContext().getResources().getColor(i));
    }

    public boolean b() {
        return this.w;
    }

    int c() {
        return Math.max(super.c(), this.r);
    }

    public void c(int i) {
        if (i < this.q) {
            i = this.q;
        }
        super.c(i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.s;
        int right = this.c.getRight() + this.s;
        int i = height - this.o;
        this.t.setColor((this.v << 24) | (this.n & C0151az.r));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.t);
        if (this.w) {
            this.t.setColor(C0151az.s | (this.n & C0151az.r));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.y), (float) (getWidth() - getPaddingRight()), (float) height, this.t);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.z) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case a.i /*0*/:
                this.A = x;
                this.B = y;
                this.z = false;
                break;
            case l /*1*/:
                if (x >= ((float) (this.c.getLeft() - this.s))) {
                    if (x > ((float) (this.c.getRight() + this.s))) {
                        this.a.a(this.a.c() + l);
                        break;
                    }
                }
                this.a.a(this.a.c() - 1);
                break;
                break;
            case a.k /*2*/:
                if (Math.abs(x - this.A) > ((float) this.C) || Math.abs(y - this.B) > ((float) this.C)) {
                    this.z = true;
                    break;
                }
        }
        return true;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.x) {
            this.w = (C0151az.s & i) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.x) {
            this.w = drawable == null;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.x) {
            this.w = i == 0;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.p) {
            i4 = this.p;
        }
        super.setPadding(i, i2, i3, i4);
    }
}
