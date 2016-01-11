package com.f.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.f.a.b.a.i;
import com.f.a.c.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class d implements a {
    public static final String a = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    public static final String b = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    protected Reference<View> c;
    protected boolean d;

    public d(View view) {
        this(view, true);
    }

    public d(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.c = new WeakReference(view);
        this.d = z;
    }

    public int a() {
        View view = (View) this.c.get();
        if (view == null) {
            return 0;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        int width = (!this.d || layoutParams == null || layoutParams.width == -2) ? 0 : view.getWidth();
        return (width > 0 || layoutParams == null) ? width : layoutParams.width;
    }

    protected abstract void a(Bitmap bitmap, View view);

    protected abstract void a(Drawable drawable, View view);

    public boolean a(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = (View) this.c.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        }
        f.c(b, new Object[0]);
        return false;
    }

    public boolean a(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = (View) this.c.get();
            if (view != null) {
                a(drawable, view);
                return true;
            }
        }
        f.c(a, new Object[0]);
        return false;
    }

    public int b() {
        View view = (View) this.c.get();
        if (view == null) {
            return 0;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        int height = (!this.d || layoutParams == null || layoutParams.height == -2) ? 0 : view.getHeight();
        return (height > 0 || layoutParams == null) ? height : layoutParams.height;
    }

    public i c() {
        return i.CROP;
    }

    public View d() {
        return (View) this.c.get();
    }

    public boolean e() {
        return this.c.get() == null;
    }

    public int f() {
        View view = (View) this.c.get();
        return view == null ? super.hashCode() : view.hashCode();
    }
}
