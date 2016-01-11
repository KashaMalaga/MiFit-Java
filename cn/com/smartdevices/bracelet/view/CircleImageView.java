package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.xiaomi.hm.health.t;

public class CircleImageView extends ImageView {
    private static final ScaleType a = ScaleType.CENTER_CROP;
    private static final Config b = Config.ARGB_8888;
    private static final int c = 2;
    private static final int d = 0;
    private static final int e = -16777216;
    private final RectF f;
    private final RectF g;
    private final Matrix h;
    private final Paint i;
    private final Paint j;
    private int k;
    private int l;
    private Bitmap m;
    private BitmapShader n;
    private int o;
    private int p;
    private float q;
    private float r;
    private boolean s;
    private boolean t;
    private PaintFlagsDrawFilter u;

    public CircleImageView(Context context) {
        super(context);
        this.f = new RectF();
        this.g = new RectF();
        this.h = new Matrix();
        this.i = new Paint();
        this.j = new Paint();
        this.k = e;
        this.l = d;
        c();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new RectF();
        this.g = new RectF();
        this.h = new Matrix();
        this.i = new Paint();
        this.j = new Paint();
        this.k = e;
        this.l = d;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.CircleImageView, i, d);
        this.l = obtainStyledAttributes.getDimensionPixelSize(d, d);
        this.k = obtainStyledAttributes.getColor(1, e);
        obtainStyledAttributes.recycle();
        c();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(c, c, b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(d, d, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void c() {
        super.setScaleType(a);
        this.u = new PaintFlagsDrawFilter(d, 3);
        this.s = true;
        if (this.t) {
            d();
            this.t = false;
        }
    }

    private void d() {
        if (!this.s) {
            this.t = true;
        } else if (this.m != null) {
            this.n = new BitmapShader(this.m, TileMode.CLAMP, TileMode.CLAMP);
            this.i.setAntiAlias(true);
            this.i.setShader(this.n);
            this.j.setStyle(Style.STROKE);
            this.j.setAntiAlias(true);
            this.j.setColor(this.k);
            this.j.setStrokeWidth((float) this.l);
            this.p = this.m.getHeight();
            this.o = this.m.getWidth();
            this.g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.r = Math.min((this.g.height() - ((float) this.l)) / 2.0f, (this.g.width() - ((float) this.l)) / 2.0f);
            this.f.set((float) this.l, (float) this.l, this.g.width() - ((float) this.l), this.g.height() - ((float) this.l));
            this.q = Math.min(this.f.height() / 2.0f, this.f.width() / 2.0f);
            e();
            invalidate();
        }
    }

    private void e() {
        float height;
        float width;
        float f = 0.0f;
        this.h.set(null);
        if (((float) this.o) * this.f.height() > this.f.width() * ((float) this.p)) {
            height = this.f.height() / ((float) this.p);
            width = (this.f.width() - (((float) this.o) * height)) * 0.5f;
        } else {
            height = this.f.width() / ((float) this.o);
            width = 0.0f;
            f = (this.f.height() - (((float) this.p) * height)) * 0.5f;
        }
        this.h.setScale(height, height);
        this.h.postTranslate((float) (((int) (width + 0.5f)) + this.l), (float) (((int) (f + 0.5f)) + this.l));
        this.n.setLocalMatrix(this.h);
    }

    public int a() {
        return this.k;
    }

    public void a(int i) {
        if (i != this.k) {
            this.k = i;
            this.j.setColor(this.k);
            invalidate();
        }
    }

    public int b() {
        return this.l;
    }

    public void b(int i) {
        if (i != this.l) {
            this.l = i;
            d();
        }
    }

    public ScaleType getScaleType() {
        return a;
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.setDrawFilter(this.u);
            canvas.drawCircle((float) (getWidth() / c), (float) (getHeight() / c), this.q, this.i);
            if (this.l != 0) {
                canvas.drawCircle((float) (getWidth() / c), (float) (getHeight() / c), this.r, this.j);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.m = bitmap;
        d();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.m = a(drawable);
        d();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.m = a(getDrawable());
        d();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.m = a(getDrawable());
        d();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }
}
