package cn.com.smartdevices.bracelet.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.Y;
import android.support.v4.view.aZ;
import android.support.v4.view.bz;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class TitlePageIndicator extends View implements c {
    private static final float a = 0.25f;
    private static final float b = 0.05f;
    private static final String c = "";
    private static final int v = -1;
    private Set A;
    private ViewPager d;
    private bz e;
    private int f;
    private float g;
    private int h;
    private final Paint i;
    private boolean j;
    private int k;
    private int l;
    private Path m;
    private final Rect n;
    private final Paint o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private int w;
    private float x;
    private int y;
    private boolean z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new e();
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

    public TitlePageIndicator(Context context) {
        this(context, null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiTitlePageIndicatorStyle);
    }

    @SuppressLint({"NewApi"})
    public TitlePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = v;
        this.i = new Paint();
        this.m = new Path();
        this.n = new Rect();
        this.o = new Paint();
        this.x = GroundOverlayOptions.NO_DIMENSION;
        this.y = v;
        this.A = new HashSet();
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_title_indicator_footer_color);
            float dimension = resources.getDimension(R.dimen.default_title_indicator_footer_indicator_height);
            float dimension2 = resources.getDimension(R.dimen.default_title_indicator_footer_padding);
            int color2 = resources.getColor(R.color.default_title_indicator_selected_color);
            boolean z = resources.getBoolean(R.bool.default_title_indicator_selected_bold);
            int color3 = resources.getColor(R.color.default_title_indicator_text_color);
            float dimension3 = resources.getDimension(R.dimen.default_title_indicator_text_size);
            float dimension4 = resources.getDimension(R.dimen.default_title_indicator_title_padding);
            float dimension5 = resources.getDimension(R.dimen.default_title_indicator_top_padding);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.TitlePageIndicator, i, 0);
            this.p = obtainStyledAttributes.getDimension(7, dimension);
            this.q = obtainStyledAttributes.getDimension(9, dimension2);
            this.u = obtainStyledAttributes.getDimension(12, dimension5);
            this.r = obtainStyledAttributes.getDimension(11, dimension4);
            this.l = obtainStyledAttributes.getColor(3, color2);
            this.k = obtainStyledAttributes.getColor(1, color3);
            this.j = obtainStyledAttributes.getBoolean(10, z);
            this.s = obtainStyledAttributes.getDimension(13, 0.0f);
            this.t = obtainStyledAttributes.getDimension(14, 0.0f);
            dimension5 = obtainStyledAttributes.getDimension(0, dimension3);
            color = obtainStyledAttributes.getColor(5, color);
            this.i.setTextSize(dimension5);
            this.i.setAntiAlias(true);
            this.o.setStyle(Style.FILL_AND_STROKE);
            this.o.setColor(color);
            Drawable drawable = obtainStyledAttributes.getDrawable(2);
            if (drawable != null) {
                setBackground(drawable);
            }
            obtainStyledAttributes.recycle();
            this.w = aZ.a(ViewConfiguration.get(context));
        }
    }

    private Rect a(int i, Paint paint) {
        Rect rect = new Rect();
        CharSequence f = f(i);
        rect.right = (int) paint.measureText(f, 0, f.length());
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    private ArrayList<Rect> a(Paint paint) {
        ArrayList<Rect> arrayList = new ArrayList();
        int b = this.d.b().b();
        int width = ((getWidth() - ((int) this.s)) - ((int) this.t)) / b;
        for (int i = 0; i < b; i++) {
            Rect a = a(i, paint);
            int i2 = a.right - a.left;
            int i3 = a.bottom - a.top;
            a.left = (((int) this.s) + ((width - i2) / 2)) + (i * width);
            a.right = i2 + a.left;
            a.top = 0;
            a.bottom = i3;
            arrayList.add(a);
        }
        return arrayList;
    }

    private CharSequence f(int i) {
        CharSequence c = this.d.b().c(i);
        return c == null ? c : c;
    }

    public void a() {
        this.A.clear();
    }

    public void a(float f) {
        this.p = f;
        invalidate();
    }

    public void a(int i) {
        if (this.h == 0) {
            this.f = i;
            invalidate();
        }
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void a(int i, float f, int i2) {
        this.f = i;
        this.g = f;
        invalidate();
        if (this.e != null) {
            this.e.a(i, f, i2);
        }
    }

    public void a(Typeface typeface) {
        this.i.setTypeface(typeface);
        invalidate();
    }

    public void a(ViewPager viewPager) {
        if (this.d != viewPager) {
            if (this.d != null) {
                this.d.a(null);
            }
            if (viewPager.b() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.d = viewPager;
            this.d.a((bz) this);
            invalidate();
        }
    }

    public void a(ViewPager viewPager, int i) {
        a(viewPager);
        g(i);
    }

    public void a(bz bzVar) {
        this.e = bzVar;
    }

    public void a(Integer num) {
        this.A.add(num);
    }

    public void a(boolean z) {
        this.j = z;
        invalidate();
    }

    public float b() {
        return this.p;
    }

    public void b(float f) {
        this.i.setTextSize(f);
        invalidate();
    }

    public void b(int i) {
        this.h = i;
        if (this.e != null) {
            this.e.b(i);
        }
    }

    public void b(Integer num) {
        this.A.remove(num);
    }

    public int c() {
        return this.l;
    }

    public void c(float f) {
        this.r = f;
        invalidate();
    }

    public void c(int i) {
        this.o.setColor(i);
        invalidate();
    }

    public void d(float f) {
        this.u = f;
        invalidate();
    }

    public void d(int i) {
        this.l = i;
        invalidate();
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public void e(int i) {
        this.i.setColor(i);
        this.k = i;
        invalidate();
    }

    public float f() {
        return this.i.getTextSize();
    }

    public float g() {
        return this.r;
    }

    public void g(int i) {
        if (this.d == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.d.a(i);
        this.f = i;
        invalidate();
    }

    public float h() {
        return this.u;
    }

    public void i() {
        invalidate();
    }

    public Typeface j() {
        return this.i.getTypeface();
    }

    public int k() {
        return this.d == null ? 0 : this.d.b().b();
    }

    public int l() {
        return 0;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d != null) {
            int b = this.d.b().b();
            if (b != 0) {
                if (this.f == v && this.d != null) {
                    this.f = this.d.c();
                }
                ArrayList a = a(this.i);
                int size = a.size();
                if (this.f >= size) {
                    g(size + v);
                    return;
                }
                int i;
                float f;
                int left = getLeft();
                int width = getWidth();
                int height = getHeight();
                int i2 = left + width;
                int i3 = this.f;
                if (((double) this.g) <= 0.5d) {
                    i = i3;
                    f = this.g;
                } else {
                    i = i3 + 1;
                    f = 1.0f - this.g;
                }
                Object obj = f <= a ? 1 : null;
                Object obj2 = f <= b ? 1 : null;
                float f2 = (a - f) / a;
                int i4 = this.k >>> 24;
                int i5 = 0;
                while (i5 < b) {
                    Rect rect = (Rect) a.get(i5);
                    if ((rect.left > left && rect.left < i2) || (rect.right > left && rect.right < i2)) {
                        Rect rect2;
                        Object obj3 = i5 == i ? 1 : null;
                        CharSequence f3 = f(i5);
                        Paint paint = this.i;
                        boolean z = (obj3 == null || obj2 == null || !this.j) ? false : true;
                        paint.setFakeBoldText(z);
                        this.i.setColor(this.k);
                        if (!(obj3 == null || obj == null)) {
                            this.i.setAlpha(i4 - ((int) (((float) i4) * f2)));
                        }
                        if (i5 < size + v) {
                            rect2 = (Rect) a.get(i5 + 1);
                            if (((float) rect.right) + this.r > ((float) rect2.left)) {
                                int i6 = rect.right - rect.left;
                                rect.left = (int) (((float) (rect2.left - i6)) - this.r);
                                rect.right = rect.left + i6;
                            }
                        }
                        canvas.drawText(f3, 0, f3.length(), (float) rect.left, this.u + ((float) rect.bottom), this.i);
                        if (!(obj3 == null || obj == null)) {
                            this.i.setColor(this.l);
                            this.i.setAlpha((int) (((float) (this.l >>> 24)) * f2));
                            canvas.drawText(f3, 0, f3.length(), (float) rect.left, this.u + ((float) rect.bottom), this.i);
                        }
                        if (this.A.contains(Integer.valueOf(i5))) {
                            rect2 = a(i5, this.i);
                            i3 = rect2.right - rect2.left;
                            width = rect2.bottom - rect2.top;
                            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.badge), (float) ((i3 + rect.left) + 5), (float) (rect.top + (rect.height() / 2)), null);
                        }
                    }
                    i5++;
                }
                float f4 = this.p;
                f = ((((float) getWidth()) - this.s) - this.t) / (1.0f * ((float) b));
                f = (f / 2.0f) + (this.s + ((((float) this.f) + this.g) * f));
                this.m.reset();
                this.m.moveTo(f, ((float) height) - f4);
                this.m.lineTo(f + f4, (float) height);
                this.m.lineTo(f - f4, (float) height);
                this.m.close();
                canvas.drawPath(this.m, this.o);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        float size;
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            size = (float) MeasureSpec.getSize(i2);
        } else {
            this.n.setEmpty();
            this.n.bottom = (int) (this.i.descent() - this.i.ascent());
            size = ((((float) (this.n.bottom - this.n.top)) + this.q) + this.u) + this.p;
        }
        setMeasuredDimension(size2, (int) size);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.d == null || this.d.b().b() == 0) {
            return false;
        }
        int b;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case a.i /*0*/:
                this.y = Y.b(motionEvent, 0);
                this.x = motionEvent.getX();
                return true;
            case l.a /*1*/:
            case a.l /*3*/:
                if (!this.z) {
                    ArrayList a = a(this.i);
                    int size = a.size();
                    int x = (int) motionEvent.getX();
                    int i = 0;
                    while (i < size) {
                        Rect rect = (Rect) a.get(i);
                        if (x <= rect.left || x >= rect.right) {
                            i++;
                        } else {
                            this.d.a(i);
                        }
                    }
                }
                this.z = false;
                this.y = v;
                if (!this.d.j()) {
                    return true;
                }
                this.d.i();
                return true;
            case a.k /*2*/:
                float c = Y.c(motionEvent, Y.a(motionEvent, this.y));
                float f = c - this.x;
                if (!this.z && Math.abs(f) > ((float) this.w)) {
                    this.z = true;
                }
                if (!this.z) {
                    return true;
                }
                this.x = c;
                if (!this.d.j() && !this.d.h()) {
                    return true;
                }
                this.d.b(f);
                return true;
            case a.X /*5*/:
                b = Y.b(motionEvent);
                this.x = Y.c(motionEvent, b);
                this.y = Y.b(motionEvent, b);
                return true;
            case a.bt /*6*/:
                b = Y.b(motionEvent);
                if (Y.b(motionEvent, b) == this.y) {
                    this.y = Y.b(motionEvent, b == 0 ? 1 : 0);
                }
                this.x = Y.c(motionEvent, Y.a(motionEvent, this.y));
                return true;
            default:
                return true;
        }
    }
}
