package android.support.v4.app;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class aU implements C0014aY {
    private static final String a = "CarExtender";
    private static final String b = "android.car.EXTENSIONS";
    private static final String c = "large_icon";
    private static final String d = "car_conversation";
    private static final String e = "app_color";
    private Bitmap f;
    private aV g;
    private int h = 0;

    public aU(Notification notification) {
        if (VERSION.SDK_INT >= 21) {
            Bundle bundle = aK.a(notification) == null ? null : aK.a(notification).getBundle(b);
            if (bundle != null) {
                this.f = (Bitmap) bundle.getParcelable(c);
                this.h = bundle.getInt(e, 0);
                this.g = (aV) aK.ai.a(bundle.getBundle(d), aV.a, C0041bR.c);
            }
        }
    }

    public int a() {
        return this.h;
    }

    public aT a(aT aTVar) {
        if (VERSION.SDK_INT >= 21) {
            Bundle bundle = new Bundle();
            if (this.f != null) {
                bundle.putParcelable(c, this.f);
            }
            if (this.h != 0) {
                bundle.putInt(e, this.h);
            }
            if (this.g != null) {
                bundle.putBundle(d, aK.ai.a(this.g));
            }
            aTVar.a().putBundle(b, bundle);
        }
        return aTVar;
    }

    public aU a(int i) {
        this.h = i;
        return this;
    }

    public aU a(Bitmap bitmap) {
        this.f = bitmap;
        return this;
    }

    public aU a(aV aVVar) {
        this.g = aVVar;
        return this;
    }

    public Bitmap b() {
        return this.f;
    }

    public aV c() {
        return this.g;
    }
}
