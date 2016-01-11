package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

@SuppressLint({"NewApi"})
class A extends BitmapDrawable {
    private final WeakReference<B> a;

    public A(Resources resources, Bitmap bitmap, B b) {
        super(resources, bitmap);
        this.a = new WeakReference(b);
    }

    public B a() {
        return (B) this.a.get();
    }
}
