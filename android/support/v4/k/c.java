package android.support.v4.k;

import java.util.Locale;

public final class c {
    private boolean a;
    private int b;
    private j c;

    public c() {
        b(a.c(Locale.getDefault()));
    }

    public c(Locale locale) {
        b(a.c(locale));
    }

    public c(boolean z) {
        b(z);
    }

    private void b(boolean z) {
        this.a = z;
        this.c = a.a;
        this.b = 2;
    }

    private static a c(boolean z) {
        return z ? a.m : a.l;
    }

    public a a() {
        return (this.b == 2 && this.c == a.a) ? c(this.a) : new a(this.a, this.b, this.c);
    }

    public c a(j jVar) {
        this.c = jVar;
        return this;
    }

    public c a(boolean z) {
        if (z) {
            this.b |= 2;
        } else {
            this.b &= -3;
        }
        return this;
    }
}
