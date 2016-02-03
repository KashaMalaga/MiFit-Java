package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aZ;
import android.support.v4.view.bz;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class CirclePageIndicator extends View implements c {
    private static final int a = -1;
    private float b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private ViewPager f;
    private bz g;
    private int h;
    private int i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private float o;
    private int p;
    private float q;
    private int r;
    private boolean s;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new b();
        int a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.q = GroundOverlayOptions.NO_DIMENSION;
        this.r = a;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.default_circle_indicator_fill_color);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
            boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.CirclePageIndicator, i, 0);
            this.m = obtainStyledAttributes.getBoolean(2, z);
            this.l = obtainStyledAttributes.getInt(0, integer);
            this.c.setStyle(Style.FILL);
            this.c.setColor(obtainStyledAttributes.getColor(5, color));
            this.d.setStyle(Style.STROKE);
            this.d.setColor(obtainStyledAttributes.getColor(8, color3));
            this.d.setStrokeWidth(obtainStyledAttributes.getDimension(3, dimension));
            this.e.setStyle(Style.FILL);
            this.e.setColor(obtainStyledAttributes.getColor(4, color2));
            this.b = obtainStyledAttributes.getDimension(6, dimension2);
            this.n = obtainStyledAttributes.getBoolean(7, z2);
            this.o = obtainStyledAttributes.getDimension(9, 12.0f);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.p = aZ.a(ViewConfiguration.get(context));
        }
    }

    private int h(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f == null) {
            return size;
        }
        int k = k();
        k = (int) (((((float) (k + a)) * this.o) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (k * 2)) * this.b))) + 1.0f);
        return mode == af.a ? Math.min(k, size) : k;
    }

    private int i(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.b) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == af.a ? Math.min(paddingTop, size) : paddingTop;
    }

    public void a(float f) {
        this.d.setStrokeWidth(f);
        invalidate();
    }

    public void a(int i) {
        if (this.n || this.k == 0) {
            this.h = i - l();
            this.i = i - l();
            invalidate();
        }
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public void a(int i, float f, int i2) {
        this.h = i - l();
        this.j = f;
        invalidate();
        if (this.g != null) {
            this.g.a(i, f, i2);
        }
    }

    public void a(ViewPager viewPager) {
        if (this.f != viewPager) {
            if (this.f != null) {
                this.f.a(null);
            }
            if (viewPager.b() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f = viewPager;
            this.f.a((bz) this);
            invalidate();
        }
    }

    public void a(ViewPager viewPager, int i) {
        a(viewPager);
        g(i);
    }

    public void a(bz bzVar) {
        this.g = bzVar;
    }

    public void a(boolean z) {
        this.m = z;
        invalidate();
    }

    public boolean a() {
        return this.m;
    }

    public int b() {
        return this.c.getColor();
    }

    public void b(float f) {
        this.b = f;
        invalidate();
    }

    public void b(int i) {
        this.k = i;
        if (this.g != null) {
            this.g.b(i);
        }
    }

    public void b(boolean z) {
        this.n = z;
        invalidate();
    }

    public int c() {
        return this.e.getColor();
    }

    public void c(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public int d() {
        return this.l;
    }

    public void d(int i) {
        this.e.setColor(i);
        invalidate();
    }

    public int e() {
        return this.d.getColor();
    }

    public void e(int i) {
        switch (i) {
            case a.i /*0*/:
            case l.a /*1*/:
                this.l = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public float f() {
        return this.d.getStrokeWidth();
    }

    public void f(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public float g() {
        return this.b;
    }

    public void g(int i) {
        if (this.f == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f.a(l() + i);
        this.h = i;
        invalidate();
    }

    public boolean h() {
        return this.n;
    }

    public void i() {
        invalidate();
    }

    public ViewPager j() {
        return this.f;
    }

    public int k() {
        return this.f == null ? 0 : this.f.b().b();
    }

    public int l() {
        return 0;
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        if (this.f != null) {
            int k = k();
            if (k != 0) {
                if (this.h < 0) {
                    g(0);
                }
                if (this.h >= k) {
                    g(k + a);
                    return;
                }
                int width;
                int paddingLeft;
                int paddingRight;
                int paddingTop;
                if (this.l == 0) {
                    width = getWidth();
                    paddingLeft = getPaddingLeft();
                    paddingRight = getPaddingRight();
                    paddingTop = getPaddingTop();
                } else {
                    width = getHeight();
                    paddingLeft = getPaddingTop();
                    paddingRight = getPaddingBottom();
                    paddingTop = getPaddingLeft();
                }
                float f = this.b + ((float) paddingTop);
                float f2 = ((float) paddingLeft) + this.b;
                if (this.m) {
                    f2 += ((float) (((width - paddingLeft) - paddingRight) - ((int) (((((float) (k * 2)) * this.b) + (((float) (k + a)) * this.o)) + 1.0f)))) / 2.0f;
                }
                float f3 = this.b;
                if (this.d.getStrokeWidth() > 0.0f) {
                    f3 -= this.d.getStrokeWidth() / 2.0f;
                }
                while (i < k) {
                    float f4;
                    float f5 = (((float) i) * (this.o + (this.b * 2.0f))) + f2;
                    if (this.l == 0) {
                        f4 = f5;
                        f5 = f;
                    } else {
                        f4 = f;
                    }
                    if (this.c.getAlpha() > 0) {
                        canvas.drawCircle(f4, f5, f3, this.c);
                    }
                    if (f3 != this.b) {
                        canvas.drawCircle(f4, f5, this.b, this.d);
                    }
                    i++;
                }
                f3 = ((float) (this.n ? this.i : this.h)) * (this.o + (this.b * 2.0f));
                if (!this.n) {
                    f3 += this.j * (this.o + (this.b * 2.0f));
                }
                if (this.l == 0) {
                    f2 += f3;
                } else {
                    float f6 = f2 + f3;
                    f2 = f;
                    f = f6;
                }
                canvas.drawCircle(f2, f, this.b, this.e);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.l == 0) {
            setMeasuredDimension(h(i), i(i2));
        } else {
            setMeasuredDimension(i(i), h(i2));
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.a;
        this.i = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.h;
        return savedState;
    }
}
