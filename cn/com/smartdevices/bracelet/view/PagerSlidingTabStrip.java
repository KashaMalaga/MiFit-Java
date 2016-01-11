package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bz;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.t;
import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] b = new int[]{16842901, 16842904};
    private int A;
    private int B;
    private int C;
    private Locale D;
    public bz a;
    private LayoutParams c;
    private LayoutParams d;
    private final C0847u e;
    private LinearLayout f;
    private ViewPager g;
    private int h;
    private int i;
    private float j;
    private Paint k;
    private Paint l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Typeface z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0848v();
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

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new C0847u();
        this.i = 0;
        this.j = 0.0f;
        this.m = -10066330;
        this.n = 436207616;
        this.o = 436207616;
        this.p = false;
        this.q = true;
        this.r = 52;
        this.s = 8;
        this.t = 2;
        this.u = 12;
        this.v = 24;
        this.w = 1;
        this.x = 12;
        this.y = -10066330;
        this.z = null;
        this.A = 1;
        this.B = 0;
        this.C = k.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f = new LinearLayout(context);
        this.f.setOrientation(0);
        this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.r = (int) TypedValue.applyDimension(1, (float) this.r, displayMetrics);
        this.s = (int) TypedValue.applyDimension(1, (float) this.s, displayMetrics);
        this.t = (int) TypedValue.applyDimension(1, (float) this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, (float) this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, (float) this.v, displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, (float) this.w, displayMetrics);
        this.x = (int) TypedValue.applyDimension(2, (float) this.x, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
        this.x = obtainStyledAttributes.getDimensionPixelSize(0, this.x);
        this.y = obtainStyledAttributes.getColor(1, this.y);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.PagerSlidingTabStrip);
        this.m = obtainStyledAttributes.getColor(0, this.m);
        this.n = obtainStyledAttributes.getColor(1, this.n);
        this.o = obtainStyledAttributes.getColor(2, this.o);
        this.s = obtainStyledAttributes.getDimensionPixelSize(3, this.s);
        this.t = obtainStyledAttributes.getDimensionPixelSize(4, this.t);
        this.u = obtainStyledAttributes.getDimensionPixelSize(5, this.u);
        this.v = obtainStyledAttributes.getDimensionPixelSize(6, this.v);
        this.C = obtainStyledAttributes.getResourceId(8, this.C);
        this.p = obtainStyledAttributes.getBoolean(9, this.p);
        this.r = obtainStyledAttributes.getDimensionPixelSize(7, this.r);
        this.q = obtainStyledAttributes.getBoolean(10, this.q);
        obtainStyledAttributes.recycle();
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setStyle(Style.FILL);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setStrokeWidth((float) this.w);
        this.c = new LayoutParams(-2, -1);
        this.d = new LayoutParams(0, -1, 1.0f);
        if (this.D == null) {
            this.D = getResources().getConfiguration().locale;
        }
    }

    private void a(int i, int i2) {
        View imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new C0845s(this, i));
        view.setPadding(this.v, 0, this.v, 0);
        this.f.addView(view, i, this.p ? this.d : this.c);
    }

    private void a(int i, String str) {
        View textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        a(i, textView);
    }

    private void b(int i, int i2) {
        if (this.h != 0) {
            int left = this.f.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.r;
            }
            if (left != this.B) {
                this.B = left;
                scrollTo(left, 0);
            }
        }
    }

    private void o() {
        for (int i = 0; i < this.h; i++) {
            View childAt = this.f.getChildAt(i);
            childAt.setBackgroundResource(this.C);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.x);
                textView.setTypeface(this.z, this.A);
                textView.setTextColor(this.y);
                if (this.q) {
                    if (VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.D));
                    }
                }
            }
        }
    }

    public void a() {
        this.f.removeAllViews();
        this.h = this.g.b().b();
        for (int i = 0; i < this.h; i++) {
            if (this.g.b() instanceof C0846t) {
                a(i, ((C0846t) this.g.b()).a(i));
            } else {
                a(i, this.g.b().c(i).toString());
            }
        }
        o();
        getViewTreeObserver().addOnGlobalLayoutListener(new C0844r(this));
    }

    public void a(int i) {
        this.m = i;
        invalidate();
    }

    public void a(Typeface typeface, int i) {
        this.z = typeface;
        this.A = i;
        o();
    }

    public void a(ViewPager viewPager) {
        this.g = viewPager;
        if (viewPager.b() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.a(this.e);
        a();
    }

    public void a(bz bzVar) {
        this.a = bzVar;
    }

    public void a(boolean z) {
        this.p = z;
        requestLayout();
    }

    public int b() {
        return this.m;
    }

    public void b(int i) {
        this.m = getResources().getColor(i);
        invalidate();
    }

    public void b(boolean z) {
        this.q = z;
    }

    public int c() {
        return this.s;
    }

    public void c(int i) {
        this.s = i;
        invalidate();
    }

    public int d() {
        return this.n;
    }

    public void d(int i) {
        this.n = i;
        invalidate();
    }

    public int e() {
        return this.o;
    }

    public void e(int i) {
        this.n = getResources().getColor(i);
        invalidate();
    }

    public int f() {
        return this.t;
    }

    public void f(int i) {
        this.o = i;
        invalidate();
    }

    public int g() {
        return this.u;
    }

    public void g(int i) {
        this.o = getResources().getColor(i);
        invalidate();
    }

    public int h() {
        return this.r;
    }

    public void h(int i) {
        this.t = i;
        invalidate();
    }

    public void i(int i) {
        this.u = i;
        invalidate();
    }

    public boolean i() {
        return this.p;
    }

    public void j(int i) {
        this.r = i;
        invalidate();
    }

    public boolean j() {
        return this.q;
    }

    public int k() {
        return this.x;
    }

    public void k(int i) {
        this.x = i;
        o();
    }

    public int l() {
        return this.y;
    }

    public void l(int i) {
        this.y = i;
        o();
    }

    public int m() {
        return this.C;
    }

    public void m(int i) {
        this.y = getResources().getColor(i);
        o();
    }

    public int n() {
        return this.v;
    }

    public void n(int i) {
        this.C = i;
    }

    public void o(int i) {
        this.v = i;
        o();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.h != 0) {
            int height = getHeight();
            this.k.setColor(this.m);
            View childAt = this.f.getChildAt(this.i);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.j > 0.0f && this.i < this.h - 1) {
                childAt = this.f.getChildAt(this.i + 1);
                float left2 = (float) childAt.getLeft();
                left = (left * (1.0f - this.j)) + (left2 * this.j);
                right = (((float) childAt.getRight()) * this.j) + ((1.0f - this.j) * right);
            }
            canvas.drawRect(left, (float) (height - this.s), right, (float) height, this.k);
            this.k.setColor(this.n);
            canvas.drawRect(0.0f, (float) (height - this.t), (float) this.f.getWidth(), (float) height, this.k);
            this.l.setColor(this.o);
            for (int i = 0; i < this.h - 1; i++) {
                childAt = this.f.getChildAt(i);
                canvas.drawLine((float) childAt.getRight(), (float) this.u, (float) childAt.getRight(), (float) (height - this.u), this.l);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.i = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i;
        return savedState;
    }
}
