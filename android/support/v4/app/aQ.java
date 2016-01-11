package android.support.v4.app;

import android.os.Bundle;

public final class aQ implements aP {
    private static final String a = "android.wearable.EXTENSIONS";
    private static final String b = "flags";
    private static final String c = "inProgressLabel";
    private static final String d = "confirmLabel";
    private static final String e = "cancelLabel";
    private static final int f = 1;
    private static final int g = 1;
    private int h = g;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;

    public aQ(aM aMVar) {
        Bundle bundle = aMVar.d().getBundle(a);
        if (bundle != null) {
            this.h = bundle.getInt(b, g);
            this.i = bundle.getCharSequence(c);
            this.j = bundle.getCharSequence(d);
            this.k = bundle.getCharSequence(e);
        }
    }

    private void a(int i, boolean z) {
        if (z) {
            this.h |= i;
        } else {
            this.h &= i ^ -1;
        }
    }

    public aO a(aO aOVar) {
        Bundle bundle = new Bundle();
        if (this.h != g) {
            bundle.putInt(b, this.h);
        }
        if (this.i != null) {
            bundle.putCharSequence(c, this.i);
        }
        if (this.j != null) {
            bundle.putCharSequence(d, this.j);
        }
        if (this.k != null) {
            bundle.putCharSequence(e, this.k);
        }
        aOVar.a().putBundle(a, bundle);
        return aOVar;
    }

    public aQ a() {
        aQ aQVar = new aQ();
        aQVar.h = this.h;
        aQVar.i = this.i;
        aQVar.j = this.j;
        aQVar.k = this.k;
        return aQVar;
    }

    public aQ a(CharSequence charSequence) {
        this.i = charSequence;
        return this;
    }

    public aQ a(boolean z) {
        a(g, z);
        return this;
    }

    public aQ b(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    public boolean b() {
        return (this.h & g) != 0;
    }

    public aQ c(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    public CharSequence c() {
        return this.i;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public CharSequence d() {
        return this.j;
    }

    public CharSequence e() {
        return this.k;
    }
}
