package com.huami.android.bitmapfun;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.l.i;
import com.activeandroid.b;
import java.lang.ref.SoftReference;

class t extends i<String, BitmapDrawable> {
    final /* synthetic */ s a;

    t(s sVar, int i) {
        this.a = sVar;
        super(i);
    }

    protected int a(String str, BitmapDrawable bitmapDrawable) {
        int a = s.a(bitmapDrawable) / b.a;
        return a == 0 ? 1 : a;
    }

    protected void a(boolean z, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        if (D.class.isInstance(bitmapDrawable)) {
            ((D) bitmapDrawable).b(false);
        } else if (E.c()) {
            this.a.o.add(new SoftReference(bitmapDrawable.getBitmap()));
        }
    }

    protected /* synthetic */ int b(Object obj, Object obj2) {
        return a((String) obj, (BitmapDrawable) obj2);
    }
}
