package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.edmodo.cropper.a.d;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.a.a;

public class CropImageView extends FrameLayout {
    public static final int a = 1;
    public static final boolean b = false;
    public static final int c = 1;
    public static final int d = 1;
    private static final Rect e = new Rect();
    private static final int f = 0;
    private static final String g = "DEGREES_ROTATED";
    private static final String h = "CropImageView";
    private ImageView i;
    private CropOverlayView j;
    private Bitmap k;
    private int l = f;
    private int m;
    private int n;
    private int o = d;
    private boolean p = b;
    private int q = d;
    private int r = d;
    private int s = f;

    public CropImageView(Context context) {
        super(context);
        a(context);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.CropImageView, f, f);
        try {
            this.o = obtainStyledAttributes.getInteger(f.CropImageView_guidelines, d);
            this.p = obtainStyledAttributes.getBoolean(f.CropImageView_fixAspectRatio, b);
            this.q = obtainStyledAttributes.getInteger(f.CropImageView_aspectRatioX, d);
            this.r = obtainStyledAttributes.getInteger(f.CropImageView_aspectRatioY, d);
            this.s = obtainStyledAttributes.getResourceId(f.CropImageView_imageResource, f);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    private static int a(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == af.a ? Math.min(i3, i2) : i3;
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.crop_image_view, this, true);
        this.i = (ImageView) inflate.findViewById(c.ImageView_image);
        a(this.s);
        this.j = (CropOverlayView) inflate.findViewById(c.CropOverlayView);
        this.j.a(this.o, this.p, this.q, this.r);
    }

    public int a() {
        return this.s;
    }

    public Bitmap a(int i, int i2) {
        if (this.k == null) {
            return null;
        }
        Rect a = d.a(this.k, this.i);
        float width = ((float) this.k.getWidth()) / ((float) a.width());
        float height = ((float) this.k.getHeight()) / ((float) a.height());
        float a2 = a.LEFT.a() - ((float) a.left);
        float a3 = a.TOP.a() - ((float) a.top);
        a2 *= width;
        float f = a3 * height;
        float b = a.b() * width;
        float c = a.c() * height;
        Log.i(h, ", actualCropWidth=" + b + ", actualCropHeight=" + c);
        if (b < CropOverlayView.a || c < CropOverlayView.a) {
            return this.k;
        }
        Matrix matrix = new Matrix();
        if (((float) i) < b || ((float) i2) < c) {
            a3 = ((float) i) / b;
            width = ((float) i2) / c;
            Log.i(h, "scaleWidth = " + a3 + ", scaleHeight=" + width);
            matrix.postScale(a3, width);
        }
        return Bitmap.createBitmap(this.k, (int) a2, (int) f, (int) b, (int) c, matrix, b);
    }

    public void a(int i) {
        if (i != 0) {
            a(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    public void a(Bitmap bitmap) {
        this.k = bitmap;
        this.i.setImageBitmap(this.k);
        if (this.j != null) {
            this.j.a();
        }
    }

    public void a(Bitmap bitmap, ExifInterface exifInterface) {
        if (bitmap != null) {
            if (exifInterface == null) {
                a(bitmap);
                return;
            }
            int i;
            Matrix matrix = new Matrix();
            switch (exifInterface.getAttributeInt("Orientation", d)) {
                case kankan.wheel.widget.a.l /*3*/:
                    i = cn.com.smartdevices.bracelet.gps.c.a.i;
                    break;
                case kankan.wheel.widget.a.bt /*6*/:
                    i = 90;
                    break;
                case kankan.wheel.widget.a.ba /*8*/:
                    i = 270;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i == -1) {
                a(bitmap);
                return;
            }
            matrix.postRotate((float) i);
            a(Bitmap.createBitmap(bitmap, f, f, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
            bitmap.recycle();
        }
    }

    public void a(boolean z) {
        this.j.a(z);
    }

    public RectF b() {
        Rect a = d.a(this.k, this.i);
        float width = ((float) this.k.getWidth()) / ((float) a.width());
        float height = ((float) this.k.getHeight()) / ((float) a.height());
        float a2 = a.LEFT.a() - ((float) a.left);
        float a3 = a.TOP.a() - ((float) a.top);
        a2 *= width;
        a3 *= height;
        return new RectF(Math.max(0.0f, a2), Math.max(0.0f, a3), Math.min((float) this.k.getWidth(), (width * a.b()) + a2), Math.min((float) this.k.getHeight(), (height * a.c()) + a3));
    }

    public void b(int i) {
        this.j.a(i);
    }

    public void b(int i, int i2) {
        this.q = i;
        this.j.b(this.q);
        this.r = i2;
        this.j.c(this.r);
    }

    public void c(int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        this.k = Bitmap.createBitmap(this.k, f, f, this.k.getWidth(), this.k.getHeight(), matrix, true);
        a(this.k);
        this.l += i;
        this.l %= cn.com.smartdevices.bracelet.gps.c.a.e;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.m > 0 && this.n > 0) {
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = this.m;
            layoutParams.height = this.n;
            setLayoutParams(layoutParams);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (this.k != null) {
            int width;
            int height;
            super.onMeasure(i, i2);
            if (size2 == 0) {
                size2 = this.k.getHeight();
            }
            double d = Double.POSITIVE_INFINITY;
            double d2 = Double.POSITIVE_INFINITY;
            if (size < this.k.getWidth()) {
                d = ((double) size) / ((double) this.k.getWidth());
            }
            if (size2 < this.k.getHeight()) {
                d2 = ((double) size2) / ((double) this.k.getHeight());
            }
            if (d == Double.POSITIVE_INFINITY && d2 == Double.POSITIVE_INFINITY) {
                width = this.k.getWidth();
                height = this.k.getHeight();
            } else if (d <= d2) {
                height = (int) (d * ((double) this.k.getHeight()));
                width = size;
            } else {
                width = (int) (((double) this.k.getWidth()) * d2);
                height = size2;
            }
            width = a(mode, size, width);
            size2 = a(mode2, size2, height);
            this.m = width;
            this.n = size2;
            this.j.a(d.a(this.k.getWidth(), this.k.getHeight(), this.m, this.n));
            setMeasuredDimension(this.m, this.n);
            return;
        }
        this.j.a(e);
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.k != null) {
                this.l = bundle.getInt(g);
                int i = this.l;
                c(this.l);
                this.l = i;
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(g, this.l);
        return bundle;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.k != null) {
            this.j.a(d.a(this.k, this));
            return;
        }
        this.j.a(e);
    }
}
