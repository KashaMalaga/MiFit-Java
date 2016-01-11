package com.f.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.f.a.b.a.i;
import com.f.a.c.f;
import java.lang.reflect.Field;

public class b extends d {
    public b(ImageView imageView) {
        super(imageView);
    }

    public b(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue > 0 && intValue < Integer.MAX_VALUE) {
                return intValue;
            }
        } catch (Throwable e) {
            f.a(e);
        }
        return 0;
    }

    public int a() {
        int a = super.a();
        if (a <= 0) {
            Object obj = (ImageView) this.c.get();
            if (obj != null) {
                return a(obj, "mMaxWidth");
            }
        }
        return a;
    }

    protected void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    protected void a(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
    }

    public int b() {
        int b = super.b();
        if (b <= 0) {
            Object obj = (ImageView) this.c.get();
            if (obj != null) {
                return a(obj, "mMaxHeight");
            }
        }
        return b;
    }

    public i c() {
        ImageView imageView = (ImageView) this.c.get();
        return imageView != null ? i.a(imageView) : super.c();
    }

    public /* synthetic */ View d() {
        return g();
    }

    public ImageView g() {
        return (ImageView) super.d();
    }
}
