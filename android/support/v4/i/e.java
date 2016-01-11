package android.support.v4.i;

import android.content.Context;
import android.net.Uri;

class e extends a {
    private Context b;
    private Uri c;

    e(a aVar, Context context, Uri uri) {
        super(aVar);
        this.b = context;
        this.c = uri;
    }

    public Uri a() {
        return this.c;
    }

    public a a(String str) {
        throw new UnsupportedOperationException();
    }

    public a a(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public String b() {
        return b.b(this.b, this.c);
    }

    public String c() {
        return b.c(this.b, this.c);
    }

    public boolean c(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean e() {
        return b.d(this.b, this.c);
    }

    public boolean f() {
        return b.e(this.b, this.c);
    }

    public long g() {
        return b.f(this.b, this.c);
    }

    public long h() {
        return b.g(this.b, this.c);
    }

    public boolean i() {
        return b.h(this.b, this.c);
    }

    public boolean j() {
        return b.i(this.b, this.c);
    }

    public boolean k() {
        return b.j(this.b, this.c);
    }

    public boolean l() {
        return b.k(this.b, this.c);
    }

    public a[] m() {
        throw new UnsupportedOperationException();
    }
}
