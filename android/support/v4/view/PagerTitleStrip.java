package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.af;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements bv {
    private static final String f = "PagerTitleStrip";
    private static final int[] o = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] p = new int[]{16843660};
    private static final float q = 0.6f;
    private static final int r = 16;
    private static final C0135aj t;
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    int e;
    private int g;
    private float h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final C0134ai m;
    private WeakReference<ae> n;
    private int s;

    static {
        if (VERSION.SDK_INT >= 14) {
            t = new C0137al();
        } else {
            t = new C0136ak();
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.g = -1;
        this.h = GroundOverlayOptions.NO_DIMENSION;
        this.m = new C0134ai();
        View textView = new TextView(context);
        this.b = textView;
        addView(textView);
        textView = new TextView(context);
        this.c = textView;
        addView(textView);
        textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.b.setTextAppearance(context, resourceId);
            this.c.setTextAppearance(context, resourceId);
            this.d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(dimensionPixelSize);
            this.c.setTextColor(dimensionPixelSize);
            this.d.setTextColor(dimensionPixelSize);
        }
        this.j = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.e = this.c.getTextColors().getDefaultColor();
        a((float) q);
        this.b.setEllipsize(TruncateAt.END);
        this.c.setEllipsize(TruncateAt.END);
        this.d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, p);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            a(this.b);
            a(this.c);
            a(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.i = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void a(TextView textView) {
        t.a(textView);
    }

    public void a(float f) {
        this.s = ((int) (255.0f * f)) & HeartRateInfo.HR_EMPTY_VALUE;
        int i = (this.s << 24) | (this.e & C0151az.r);
        this.b.setTextColor(i);
        this.d.setTextColor(i);
    }

    public void a(int i, float f) {
        this.b.setTextSize(i, f);
        this.c.setTextSize(i, f);
        this.d.setTextSize(i, f);
    }

    void a(int i, float f, boolean z) {
        if (i != this.g) {
            a(i, this.a.b());
        } else if (!z && f == this.h) {
            return;
        }
        this.l = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.b.getBaseline();
        measuredWidth2 = this.c.getBaseline();
        int baseline = this.d.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        int measuredHeight = this.d.getMeasuredHeight() + baseline;
        max = Math.max(Math.max(this.b.getMeasuredHeight() + i2, this.c.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.j & 112) {
            case r /*16*/:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case a.h /*80*/:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.c.layout(i4, measuredWidth2, i3, this.c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.i) - measuredWidth);
        this.b.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.b.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.i + i3);
        this.d.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.d.getMeasuredHeight() + i2);
        this.h = f;
        this.l = false;
    }

    void a(int i, ae aeVar) {
        CharSequence charSequence = null;
        int b = aeVar != null ? aeVar.b() : 0;
        this.k = true;
        CharSequence c = (i < 1 || aeVar == null) ? null : aeVar.c(i - 1);
        this.b.setText(c);
        TextView textView = this.c;
        c = (aeVar == null || i >= b) ? null : aeVar.c(i);
        textView.setText(c);
        if (i + 1 < b && aeVar != null) {
            charSequence = aeVar.c(i + 1);
        }
        this.d.setText(charSequence);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        b = MeasureSpec.makeMeasureSpec((int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f), af.a);
        height = MeasureSpec.makeMeasureSpec(height, af.a);
        this.b.measure(b, height);
        this.c.measure(b, height);
        this.d.measure(b, height);
        this.g = i;
        if (!this.l) {
            a(i, this.h, false);
        }
        this.k = false;
    }

    void a(ae aeVar, ae aeVar2) {
        if (aeVar != null) {
            aeVar.b(this.m);
            this.n = null;
        }
        if (aeVar2 != null) {
            aeVar2.a(this.m);
            this.n = new WeakReference(aeVar2);
        }
        if (this.a != null) {
            this.g = -1;
            this.h = GroundOverlayOptions.NO_DIMENSION;
            a(this.a.c(), aeVar2);
            requestLayout();
        }
    }

    int c() {
        Drawable background = getBackground();
        return background != null ? background.getIntrinsicHeight() : 0;
    }

    public void c(int i) {
        this.i = i;
        requestLayout();
    }

    public int d() {
        return this.i;
    }

    public void d(int i) {
        this.e = i;
        this.c.setTextColor(i);
        int i2 = (this.s << 24) | (this.e & C0151az.r);
        this.b.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    public void e(int i) {
        this.j = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            ae b = viewPager.b();
            viewPager.b(this.m);
            viewPager.a(this.m);
            this.a = viewPager;
            a(this.n != null ? (ae) this.n.get() : null, b);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            a(this.a.b(), null);
            this.a.b(null);
            this.a.a(null);
            this.a = null;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.a != null) {
            if (this.h >= 0.0f) {
                f = this.h;
            }
            a(this.g, f, true);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        mode = c();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) size) * 0.8f), af.a);
        i3 = MeasureSpec.makeMeasureSpec(i3, af.a);
        this.b.measure(makeMeasureSpec, i3);
        this.c.measure(makeMeasureSpec, i3);
        this.d.measure(makeMeasureSpec, i3);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(mode, this.c.getMeasuredHeight() + paddingTop));
        }
    }

    public void requestLayout() {
        if (!this.k) {
            super.requestLayout();
        }
    }
}
