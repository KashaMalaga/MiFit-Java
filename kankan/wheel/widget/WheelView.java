package kankan.wheel.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.xiaomi.e.a;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.a.f;

public class WheelView extends View {
    private static final int[] c = new int[]{-15658735, 11184810, 11184810};
    private static final int d = 10;
    private static final int e = 10;
    private static final int f = 5;
    private static final String g = "WheelView";
    private float A = 50.0f;
    private float B = 80.0f;
    private DataSetObserver C = new r(this);
    boolean a = false;
    o b = new q(this);
    private int h = 0;
    private int i = f;
    private int j = 0;
    private Drawable k;
    private GradientDrawable l;
    private GradientDrawable m;
    private l n;
    private boolean o;
    private int p;
    private LinearLayout q;
    private int r;
    private f s;
    private k t = new k(this);
    private List<c> u = new LinkedList();
    private List<e> v = new LinkedList();
    private List<d> w = new LinkedList();
    private int x = h.wheel_custom_val_default;
    private Paint y;
    private String z = a.f;

    public WheelView(Context context) {
        super(context);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private int a(LinearLayout linearLayout) {
        if (!(linearLayout == null || linearLayout.getChildAt(0) == null)) {
            this.j = linearLayout.getChildAt(0).getMeasuredHeight();
        }
        return Math.max((this.j * this.i) - ((this.j * e) / 50), getSuggestedMinimumHeight());
    }

    private void a(Context context) {
        this.n = new l(getContext(), this.b);
        this.y = new Paint();
        a(new p(this));
    }

    private void a(Canvas canvas) {
        int j = (int) (1.5d * ((double) j()));
        this.l.setBounds(0, 0, getWidth(), j);
        this.l.draw(canvas);
        this.m.setBounds(0, getHeight() - j, getWidth(), getHeight());
        this.m.draw(canvas);
    }

    private void b(Canvas canvas) {
        canvas.save();
        canvas.translate(10.0f, (float) ((-(((this.h - this.r) * j()) + ((j() - getHeight()) / 2))) + this.p));
        this.q.draw(canvas);
        canvas.restore();
    }

    private int c(int i, int i2) {
        i();
        this.q.setLayoutParams(new LayoutParams(-2, -2));
        this.q.measure(MeasureSpec.makeMeasureSpec(i, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.q.getMeasuredWidth();
        if (i2 != 1073741824) {
            measuredWidth = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != af.a || i >= measuredWidth) {
                i = measuredWidth;
            }
        }
        this.q.measure(MeasureSpec.makeMeasureSpec(i - 20, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int j = (int) (((double) (j() / 2)) * 1.2d);
        this.k.setBounds(0, height - j, getWidth(), j + height);
        canvas.drawText(this.z, ((float) (getWidth() / 2)) + this.B, ((float) height) - this.A, this.y);
        this.k.draw(canvas);
    }

    private boolean c(int i, boolean z) {
        View h = h(i);
        if (h == null) {
            return false;
        }
        if (z) {
            this.q.addView(h, 0);
        } else {
            this.q.addView(h);
        }
        return true;
    }

    private void d(int i, int i2) {
        this.q.layout(0, 0, i - 20, i2);
    }

    private void f(int i) {
        this.p += i;
        int j = j();
        int i2 = this.p / j;
        int i3 = this.h - i2;
        int a = this.s.a();
        int i4 = this.p % j;
        if (Math.abs(i4) <= j / 2) {
            i4 = 0;
        }
        if (this.a && a > 0) {
            if (i4 > 0) {
                i4 = i3 - 1;
                i3 = i2 + 1;
            } else if (i4 < 0) {
                i4 = i3 + 1;
                i3 = i2 - 1;
            } else {
                i4 = i3;
                i3 = i2;
            }
            while (i4 < 0) {
                i4 += a;
            }
            i4 %= a;
        } else if (i3 < 0) {
            i3 = this.h;
            i4 = 0;
        } else if (i3 >= a) {
            i3 = (this.h - a) + 1;
            i4 = a - 1;
        } else if (i3 > 0 && i4 > 0) {
            i4 = i3 - 1;
            i3 = i2 + 1;
        } else if (i3 >= a - 1 || i4 >= 0) {
            i4 = i3;
            i3 = i2;
        } else {
            i4 = i3 + 1;
            i3 = i2 - 1;
        }
        i2 = this.p;
        if (i4 != this.h) {
            a(i4, false);
        } else {
            invalidate();
        }
        this.p = i2 - (i3 * j);
        if (this.p > getHeight()) {
            this.p = (this.p % getHeight()) + getHeight();
        }
    }

    private boolean g(int i) {
        return this.s != null && this.s.a() > 0 && (this.a || (i >= 0 && i < this.s.a()));
    }

    private View h(int i) {
        if (this.s == null || this.s.a() == 0) {
            return null;
        }
        int a = this.s.a();
        if (!g(i)) {
            return this.s.a(this.t.b(), this.q);
        }
        while (i < 0) {
            i += a;
        }
        return this.s.a(i % a, this.t.a(), this.q);
    }

    private void i() {
        if (this.k == null) {
            this.k = getContext().getResources().getDrawable(this.x);
        }
        if (this.l == null) {
            this.l = new GradientDrawable();
        }
        if (this.m == null) {
            this.m = new GradientDrawable();
        }
    }

    private int j() {
        if (this.j != 0) {
            return this.j;
        }
        if (this.q == null || this.q.getChildAt(0) == null) {
            return getHeight() / this.i;
        }
        this.j = this.q.getChildAt(0).getHeight();
        return this.j;
    }

    private b k() {
        if (j() == 0) {
            return null;
        }
        int i = this.h;
        int i2 = 1;
        while (j() * i2 < getHeight()) {
            i--;
            i2 += 2;
        }
        if (this.p != 0) {
            if (this.p > 0) {
                i--;
            }
            int j = this.p / j();
            i -= j;
            i2 = (int) (Math.asin((double) j) + ((double) (i2 + 1)));
        }
        return new b(i, i2);
    }

    private boolean l() {
        int a;
        boolean z;
        b k = k();
        if (this.q != null) {
            a = this.t.a(this.q, this.r, k);
            z = this.r != a;
            this.r = a;
        } else {
            n();
            z = true;
        }
        if (!z) {
            z = (this.r == k.a() && this.q.getChildCount() == k.c()) ? false : true;
        }
        if (this.r <= k.a() || this.r > k.b()) {
            this.r = k.a();
        } else {
            a = this.r - 1;
            while (a >= k.a() && c(a, true)) {
                this.r = a;
                a--;
            }
        }
        a = this.r;
        for (int childCount = this.q.getChildCount(); childCount < k.c(); childCount++) {
            if (!c(this.r + childCount, false) && this.q.getChildCount() == 0) {
                a++;
            }
        }
        this.r = a;
        return z;
    }

    private void m() {
        if (l()) {
            c(getWidth(), 1073741824);
            d(getWidth(), getHeight());
        }
    }

    private void n() {
        if (this.q == null) {
            this.q = new LinearLayout(getContext());
            this.q.setOrientation(1);
        }
    }

    private void o() {
        if (this.q != null) {
            this.t.a(this.q, this.r, new b());
        } else {
            n();
        }
        int i = this.i / 2;
        for (int i2 = this.h + i; i2 >= this.h - i; i2--) {
            if (c(i2, true)) {
                this.r = i2;
            }
        }
    }

    public int a() {
        return this.i;
    }

    public WheelView a(int i) {
        this.i = i;
        return this;
    }

    public WheelView a(String str) {
        this.z = str;
        return this;
    }

    public WheelView a(String str, float f) {
        return a(str, a.bk, e, f, a.bg);
    }

    public WheelView a(String str, int i, float f) {
        return a(str, i, e, f, a.bg);
    }

    public WheelView a(String str, int i, int i2, float f, float f2) {
        this.z = str;
        this.B = TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        this.A = TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        this.y.setTextSize(TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics()));
        this.y.setFakeBoldText(false);
        this.y.setAntiAlias(true);
        this.y.setColor(getResources().getColor(i));
        return this;
    }

    public WheelView a(f fVar) {
        if (this.s != null) {
            this.s.b(this.C);
        }
        this.s = fVar;
        if (this.s != null) {
            this.s.a(this.C);
        }
        b(true);
        return this;
    }

    protected void a(int i, int i2) {
        for (c a : this.u) {
            a.a(this, i, i2);
        }
    }

    public void a(int i, boolean z) {
        if (this.s != null && this.s.a() != 0) {
            int a = this.s.a();
            if (i < 0 || i >= a) {
                if (this.a) {
                    while (i < 0) {
                        i += a;
                    }
                    i %= a;
                } else {
                    return;
                }
            }
            if (i == this.h) {
                return;
            }
            if (z) {
                int i2 = i - this.h;
                if (this.a) {
                    a = (a + Math.min(i, this.h)) - Math.max(i, this.h);
                    if (a < Math.abs(i2)) {
                        if (i2 >= 0) {
                            a = -a;
                        }
                        b(a, 0);
                        return;
                    }
                }
                a = i2;
                b(a, 0);
                return;
            }
            this.p = 0;
            a = this.h;
            this.h = i;
            a(a, this.h);
            invalidate();
        }
    }

    public void a(Interpolator interpolator) {
        this.n.a(interpolator);
    }

    public void a(c cVar) {
        this.u.add(cVar);
    }

    public void a(d dVar) {
        this.w.add(dVar);
    }

    public void a(e eVar) {
        this.v.add(eVar);
    }

    public void a(boolean z) {
        this.a = z;
        b(false);
    }

    public WheelView b(int i, boolean z) {
        if (this.s.b()) {
            Log.i(g, "setCurrentItemLooped: " + i);
            i += this.s.c();
            Log.i(g, ", after add loopbase:" + i);
        }
        a(i, z);
        return this;
    }

    public f b() {
        return this.s;
    }

    protected void b(int i) {
        for (d a : this.w) {
            a.a(this, i);
        }
    }

    public void b(int i, int i2) {
        this.n.a((j() * i) - this.p, i2);
    }

    public void b(c cVar) {
        this.u.remove(cVar);
    }

    public void b(d dVar) {
        this.w.remove(dVar);
    }

    public void b(e eVar) {
        this.v.remove(eVar);
    }

    public void b(boolean z) {
        if (z) {
            this.t.c();
            if (this.q != null) {
                this.q.removeAllViews();
            }
            this.p = 0;
        } else if (this.q != null) {
            this.t.a(this.q, this.r, new b());
        }
        Log.i("Height", "invalidateWheel");
        invalidate();
    }

    public WheelView c(int i) {
        a(i, false);
        return this;
    }

    protected void c() {
        for (e a : this.v) {
            a.a(this);
        }
    }

    public WheelView d(int i) {
        return b(i, false);
    }

    protected void d() {
        for (e b : this.v) {
            b.b(this);
        }
    }

    public int e() {
        return this.h;
    }

    public WheelView e(int i) {
        this.x = i;
        if (this.k == null) {
            this.k = getContext().getResources().getDrawable(this.x);
        }
        invalidate();
        return this;
    }

    public int f() {
        return (this.s == null || !this.s.b()) ? this.h : this.h % this.s.d();
    }

    public boolean g() {
        return this.a;
    }

    public void h() {
        this.n.a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.s != null && this.s.a() > 0) {
            m();
            b(canvas);
            c(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        d(i3 - i, i4 - i2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        Log.i("Height", "onMeasure");
        o();
        size = c(size, mode);
        if (mode2 != 1073741824) {
            mode = a(this.q);
            size2 = mode2 == af.a ? Math.min(mode, size2) : mode;
        }
        setMeasuredDimension(size, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || b() == null) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case l.a /*1*/:
                if (!this.o) {
                    int y = ((int) motionEvent.getY()) - (getHeight() / 2);
                    y = (y > 0 ? y + (j() / 2) : y - (j() / 2)) / j();
                    if (y != 0 && g(this.h + y)) {
                        b(y + this.h);
                        break;
                    }
                }
                break;
            case a.k /*2*/:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return this.n.a(motionEvent);
    }
}
