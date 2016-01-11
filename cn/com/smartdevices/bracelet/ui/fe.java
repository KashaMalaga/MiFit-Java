package cn.com.smartdevices.bracelet.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class fe {
    public static final int a = -1728053248;
    private static String b;
    private final fg c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private View h;
    private View i;

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                b = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                b = null;
            }
        }
    }

    @TargetApi(19)
    public fe(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.d = obtainStyledAttributes.getBoolean(0, false);
                this.e = obtainStyledAttributes.getBoolean(1, false);
                LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.d = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.e = true;
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.c = new fg(activity, this.d, this.e);
        if (!this.c.d()) {
            this.e = false;
        }
        if (this.d) {
            a(activity, viewGroup);
        }
        if (this.e) {
            b(activity, viewGroup);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.h = new View(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.c.b());
        layoutParams.gravity = 48;
        if (this.e && !this.c.a()) {
            layoutParams.rightMargin = this.c.f();
        }
        this.h.setLayoutParams(layoutParams);
        this.h.setBackgroundColor(a);
        this.h.setVisibility(8);
        viewGroup.addView(this.h);
    }

    private void b(Context context, ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams;
        this.i = new View(context);
        if (this.c.a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.c.e());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.c.f(), -1);
            layoutParams.gravity = 5;
        }
        this.i.setLayoutParams(layoutParams);
        this.i.setBackgroundColor(a);
        this.i.setVisibility(8);
        viewGroup.addView(this.i);
    }

    public fg a() {
        return this.c;
    }

    public void a(float f) {
        b(f);
        c(f);
    }

    public void a(int i) {
        c(i);
        e(i);
    }

    public void a(Drawable drawable) {
        b(drawable);
        c(drawable);
    }

    public void a(boolean z) {
        this.f = z;
        if (this.d) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    @TargetApi(11)
    public void b(float f) {
        if (this.d && VERSION.SDK_INT >= 11) {
            this.h.setAlpha(f);
        }
    }

    public void b(int i) {
        d(i);
        f(i);
    }

    public void b(Drawable drawable) {
        if (this.d) {
            this.h.setBackgroundDrawable(drawable);
        }
    }

    public void b(boolean z) {
        this.g = z;
        if (this.e) {
            this.i.setVisibility(z ? 0 : 8);
        }
    }

    public boolean b() {
        return this.f;
    }

    @TargetApi(11)
    public void c(float f) {
        if (this.e && VERSION.SDK_INT >= 11) {
            this.i.setAlpha(f);
        }
    }

    public void c(int i) {
        if (this.d) {
            this.h.setBackgroundColor(i);
        }
    }

    public void c(Drawable drawable) {
        if (this.e) {
            this.i.setBackgroundDrawable(drawable);
        }
    }

    public boolean c() {
        return this.g;
    }

    public void d(int i) {
        if (this.d) {
            this.h.setBackgroundResource(i);
        }
    }

    public void e(int i) {
        if (this.e) {
            this.i.setBackgroundColor(i);
        }
    }

    public void f(int i) {
        if (this.e) {
            this.i.setBackgroundResource(i);
        }
    }
}
