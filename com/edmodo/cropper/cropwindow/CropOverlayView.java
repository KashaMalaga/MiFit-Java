package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.edmodo.cropper.a.b;
import com.edmodo.cropper.a.e;
import com.edmodo.cropper.cropwindow.a.a;
import com.edmodo.cropper.cropwindow.b.c;

public class CropOverlayView extends View {
    public static final float a = 100.0f;
    private static final int b = 6;
    private static final float c = e.b();
    private static final float d = e.c();
    private static final float e = ((c / 2.0f) - (d / 2.0f));
    private static final float f = ((c / 2.0f) + e);
    private static final float g = 20.0f;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = -1342177280;
    private static final int l = 1;
    private static final int m = 2;
    private static final String n = "CropOverlayView";
    private float A = (((float) this.y) / ((float) this.z));
    private int B;
    private boolean C = false;
    private float D;
    private float E;
    private float F;
    private int G;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Rect s;
    private float t;
    private float u;
    private Pair<Float, Float> v;
    private c w;
    private boolean x = false;
    private int y = l;
    private int z = l;

    public CropOverlayView(Context context) {
        super(context);
        a(context);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(float f, float f2) {
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        this.w = b.a(f, f2, a, a2, a3, a4, this.t);
        if (this.w != null) {
            this.v = b.a(this.w, f, f2, a, a2, a3, a4);
            invalidate();
        }
    }

    private void a(Context context) {
        this.G = l;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.t = b.a(context);
        this.u = TypedValue.applyDimension(l, 6.0f, displayMetrics);
        this.o = e.a(context);
        this.p = e.a();
        this.r = e.b(context);
        this.q = e.c(context);
        this.E = -TypedValue.applyDimension(l, e, displayMetrics);
        this.D = -this.E;
        this.F = TypedValue.applyDimension(l, g, displayMetrics);
        this.B = l;
    }

    private void a(Canvas canvas) {
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        float b = a.b() / 3.0f;
        float f = a + b;
        canvas.drawLine(f, a2, f, a4, this.p);
        f = a3 - b;
        canvas.drawLine(f, a2, f, a4, this.p);
        float c = a.c() / 3.0f;
        b = a2 + c;
        canvas.drawLine(a, b, a3, b, this.p);
        b = a4 - c;
        canvas.drawLine(a, b, a3, b, this.p);
    }

    private void a(Canvas canvas, Rect rect) {
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        canvas.save();
        setLayerType(l, null);
        canvas.clipRect(new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
        if (this.G == l) {
            Path path = new Path();
            path.addCircle(a + ((a3 - a) / 2.0f), ((a4 - a2) / 2.0f) + a2, ((a4 - a2) / 2.0f) - this.o.getStrokeWidth(), Direction.CW);
            canvas.clipPath(path, Op.DIFFERENCE);
        } else if (this.G == m) {
            canvas.clipRect(a, a2, a3, a4, Op.DIFFERENCE);
        }
        canvas.drawColor(k);
        canvas.restore();
    }

    private void b(float f, float f2) {
        if (this.w != null) {
            float floatValue = f + ((Float) this.v.first).floatValue();
            float floatValue2 = f2 + ((Float) this.v.second).floatValue();
            if (this.x) {
                this.w.a(floatValue, floatValue2, this.A, this.s, this.u);
            } else {
                this.w.a(floatValue, floatValue2, this.s, this.u);
            }
            invalidate();
        }
    }

    private void b(Canvas canvas) {
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        canvas.drawLine(a - this.E, a2 - this.D, a - this.E, a2 + this.F, this.q);
        canvas.drawLine(a, a2 - this.E, a + this.F, a2 - this.E, this.q);
        canvas.drawLine(a3 + this.E, a2 - this.D, a3 + this.E, a2 + this.F, this.q);
        canvas.drawLine(a3, a2 - this.E, a3 - this.F, a2 - this.E, this.q);
        canvas.drawLine(a - this.E, a4 + this.D, a - this.E, a4 - this.F, this.q);
        canvas.drawLine(a, a4 + this.E, a + this.F, a4 + this.E, this.q);
        canvas.drawLine(a3 + this.E, a4 + this.D, a3 + this.E, a4 - this.F, this.q);
        canvas.drawLine(a3, a4 + this.E, a3 - this.F, a4 + this.E, this.q);
    }

    private void b(Rect rect) {
        if ((rect.right - rect.left) * (rect.bottom - rect.top) > 0) {
            if (!this.C) {
                this.C = true;
            }
            float width;
            float height;
            if (!this.x) {
                width = ((float) rect.width()) * 0.1f;
                height = ((float) rect.height()) * 0.1f;
                a.LEFT.a(((float) rect.left) + width);
                a.TOP.a(((float) rect.top) + height);
                a.RIGHT.a(((float) rect.right) - width);
                a.BOTTOM.a(((float) rect.bottom) - height);
            } else if (com.edmodo.cropper.a.a.a(rect) > this.A) {
                a.TOP.a((float) rect.top);
                a.BOTTOM.a((float) rect.bottom);
                width = ((float) getWidth()) / 2.0f;
                height = Math.max(BitmapDescriptorFactory.HUE_YELLOW, com.edmodo.cropper.a.a.a(a.TOP.a(), a.BOTTOM.a(), this.A));
                if (height == BitmapDescriptorFactory.HUE_YELLOW) {
                    this.A = BitmapDescriptorFactory.HUE_YELLOW / (a.BOTTOM.a() - a.TOP.a());
                }
                height /= 2.0f;
                a.LEFT.a(width - height);
                a.RIGHT.a(width + height);
            } else {
                a.LEFT.a((float) rect.left);
                a.RIGHT.a((float) rect.right);
                width = ((float) getHeight()) / 2.0f;
                height = Math.max(BitmapDescriptorFactory.HUE_YELLOW, com.edmodo.cropper.a.a.b(a.LEFT.a(), a.RIGHT.a(), this.A));
                if (height == BitmapDescriptorFactory.HUE_YELLOW) {
                    this.A = (a.RIGHT.a() - a.LEFT.a()) / BitmapDescriptorFactory.HUE_YELLOW;
                }
                height /= 2.0f;
                a.TOP.a(width - height);
                a.BOTTOM.a(width + height);
            }
        }
    }

    public static boolean b() {
        return Math.abs(a.LEFT.a() - a.RIGHT.a()) >= a && Math.abs(a.TOP.a() - a.BOTTOM.a()) >= a;
    }

    private void c() {
        if (this.w != null) {
            this.w = null;
            invalidate();
        }
    }

    public void a() {
        if (this.C) {
            b(this.s);
            invalidate();
        }
    }

    public void a(int i) {
        if (i < 0 || i > m) {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        this.B = i;
        if (this.C) {
            b(this.s);
            invalidate();
        }
    }

    public void a(int i, boolean z, int i2, int i3) {
        if (i < 0 || i > m) {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        this.B = i;
        this.x = z;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.y = i2;
        this.A = ((float) this.y) / ((float) this.z);
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.z = i3;
        this.A = ((float) this.y) / ((float) this.z);
    }

    public void a(Rect rect) {
        this.s = rect;
        b(this.s);
    }

    public void a(boolean z) {
        this.x = z;
        if (this.C) {
            b(this.s);
            invalidate();
        }
    }

    public void b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.y = i;
        this.A = ((float) this.y) / ((float) this.z);
        if (this.C) {
            b(this.s);
            invalidate();
        }
    }

    public void c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.z = i;
        this.A = ((float) this.y) / ((float) this.z);
        if (this.C) {
            b(this.s);
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float a = a.LEFT.a();
        float a2 = a.TOP.a();
        float a3 = a.RIGHT.a();
        float a4 = a.BOTTOM.a();
        a(canvas, this.s);
        if (b()) {
            if (this.B == m) {
                a(canvas);
            } else if (this.B == l) {
                if (this.w != null) {
                    a(canvas);
                }
            } else if (this.B == 0) {
            }
        }
        if (this.G == m) {
            canvas.drawRect(a, a2, a3, a4, this.o);
        } else {
            canvas.drawCircle(((a3 - a) / 2.0f) + a, ((a4 - a2) / 2.0f) + a2, ((a4 - a2) / 2.0f) - this.o.getStrokeWidth(), this.o);
        }
        b(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        b(this.s);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case h /*0*/:
                a(motionEvent.getX(), motionEvent.getY());
                return true;
            case l /*1*/:
            case kankan.wheel.widget.a.l /*3*/:
                getParent().requestDisallowInterceptTouchEvent(false);
                c();
                return true;
            case m /*2*/:
                b(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }
}
