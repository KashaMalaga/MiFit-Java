package android.support.v4.app;

import android.graphics.Bitmap;

public class C0013aR extends bj {
    Bitmap a;
    Bitmap b;
    boolean c;

    public C0013aR(aT aTVar) {
        a(aTVar);
    }

    public C0013aR a(Bitmap bitmap) {
        this.a = bitmap;
        return this;
    }

    public C0013aR a(CharSequence charSequence) {
        this.e = aT.f(charSequence);
        return this;
    }

    public C0013aR b(Bitmap bitmap) {
        this.b = bitmap;
        this.c = true;
        return this;
    }

    public C0013aR b(CharSequence charSequence) {
        this.f = aT.f(charSequence);
        this.g = true;
        return this;
    }
}
