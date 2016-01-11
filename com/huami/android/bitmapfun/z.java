package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.R;
import android.widget.ImageView;
import java.util.concurrent.Executor;

@SuppressLint({"NewApi"})
public abstract class z {
    private static final String a = "ImageWorker";
    private static final int b = 200;
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private s c;
    private u d;
    private Bitmap e;
    protected boolean f = false;
    protected Resources g;
    private boolean h = true;
    private boolean i = false;
    private final Object j = new Object();

    protected z(Context context) {
        this.g = context.getResources();
    }

    public static void a(ImageView imageView) {
        B c = c(imageView);
        if (c != null) {
            c.a(true);
        }
    }

    private void a(ImageView imageView, Drawable drawable) {
        if (this.h) {
            Drawable[] drawableArr = new Drawable[m];
            drawableArr[k] = new ColorDrawable(17170445);
            drawableArr[l] = drawable;
            Drawable transitionDrawable = new TransitionDrawable(drawableArr);
            imageView.setBackgroundDrawable(new BitmapDrawable(this.g, this.e));
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(b);
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public static boolean b(Object obj, ImageView imageView) {
        B c = c(imageView);
        if (c == null) {
            return true;
        }
        Object a = c.e;
        if (a != null && a.equals(obj)) {
            return false;
        }
        c.a(true);
        return true;
    }

    private static B c(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof A) {
                return ((A) drawable).a();
            }
        }
        return null;
    }

    protected abstract Bitmap a(Object obj);

    protected abstract Bitmap a(Object obj, int i);

    protected void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public void a(FragmentManager fragmentManager, u uVar) {
        this.d = uVar;
        this.c = s.a(fragmentManager, this.d);
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(l);
        c.c(objArr);
    }

    public void a(Bitmap bitmap) {
        this.e = bitmap;
    }

    public void a(FragmentActivity fragmentActivity, String str) {
        this.d = new u(fragmentActivity, str);
        this.c = s.a(fragmentActivity.i(), this.d);
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(l);
        c.c(objArr);
    }

    public void a(R r, u uVar) {
        this.d = uVar;
        this.c = s.a(r, this.d);
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(l);
        c.c(objArr);
    }

    public void a(Object obj, ImageView imageView) {
        if (obj != null) {
            Drawable drawable = null;
            if (this.c != null) {
                drawable = this.c.a(String.valueOf(obj));
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else if (b(obj, imageView)) {
                B b = new B(this, obj, imageView);
                imageView.setImageDrawable(new A(this.g, this.e, b));
                b.a(C1061a.c, (Object[]) new Integer[k]);
            }
        }
    }

    public void a(String str, ImageView imageView) {
        if (str != null) {
            Drawable drawable = null;
            if (this.c != null) {
                drawable = this.c.a(String.valueOf(str));
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else if (b(str, imageView)) {
                B b = new B(this, str, imageView);
                imageView.setImageDrawable(new A(this.g, this.e, b));
                Executor executor = C1061a.c;
                Integer[] numArr = new Integer[l];
                numArr[k] = Integer.valueOf(m);
                b.a(executor, (Object[]) numArr);
            }
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    protected void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public void b(int i) {
        this.e = BitmapFactory.decodeResource(this.g, i);
    }

    public void b(boolean z) {
        this.i = z;
        c(false);
    }

    protected void c() {
        if (this.c != null) {
            this.c.c();
        }
    }

    public void c(boolean z) {
        synchronized (this.j) {
            this.f = z;
            if (!this.f) {
                this.j.notifyAll();
            }
        }
    }

    protected void d() {
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
    }

    protected s f() {
        return this.c;
    }

    public void g() {
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(k);
        c.c(objArr);
    }

    public void h() {
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(m);
        c.c(objArr);
    }

    public void i() {
        C c = new C(this);
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(n);
        c.c(objArr);
    }
}
