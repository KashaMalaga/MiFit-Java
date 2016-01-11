package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

@SuppressLint({"NewApi"})
class B extends C1061a<Integer, Void, BitmapDrawable> {
    final /* synthetic */ z d;
    private final Object e;
    private final WeakReference<ImageView> f;

    public B(z zVar, Object obj, ImageView imageView) {
        this.d = zVar;
        this.e = obj;
        this.f = new WeakReference(imageView);
    }

    private ImageView g() {
        ImageView imageView = (ImageView) this.f.get();
        return this == z.c(imageView) ? imageView : null;
    }

    protected BitmapDrawable a(Integer... numArr) {
        int i = 1;
        if (numArr != null && numArr.length > 0) {
            i = numArr[0].intValue();
        }
        String valueOf = String.valueOf(this.e);
        synchronized (this.d.j) {
            while (this.d.f && !e()) {
                try {
                    this.d.j.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        Bitmap b = (this.d.c == null || e() || g() == null || this.d.i) ? null : this.d.c.b(valueOf);
        if (!(b != null || e() || g() == null || this.d.i)) {
            b = this.d.a(this.e, i);
        }
        if (b == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = E.c() ? new BitmapDrawable(this.d.g, b) : new D(this.d.g, b);
        if (this.d.c == null) {
            return bitmapDrawable;
        }
        this.d.c.a(valueOf, bitmapDrawable);
        return bitmapDrawable;
    }

    protected void a(BitmapDrawable bitmapDrawable) {
        if (e() || this.d.i) {
            Drawable drawable = null;
        }
        ImageView g = g();
        if (drawable != null && g != null) {
            this.d.a(g, drawable);
        }
    }

    protected void b(BitmapDrawable bitmapDrawable) {
        super.b((Object) bitmapDrawable);
        synchronized (this.d.j) {
            this.d.j.notifyAll();
        }
    }
}
