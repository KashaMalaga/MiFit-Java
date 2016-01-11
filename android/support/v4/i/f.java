package android.support.v4.i;

import android.content.Context;
import android.net.Uri;

class f extends a {
    private Context b;
    private Uri c;

    f(a aVar, Context context, Uri uri) {
        super(aVar);
        this.b = context;
        this.c = uri;
    }

    public Uri a() {
        return this.c;
    }

    public a a(String str) {
        Uri a = c.a(this.b, this.c, str);
        return a != null ? new f(this, this.b, a) : null;
    }

    public a a(String str, String str2) {
        Uri a = c.a(this.b, this.c, str, str2);
        return a != null ? new f(this, this.b, a) : null;
    }

    public String b() {
        return b.b(this.b, this.c);
    }

    public String c() {
        return b.c(this.b, this.c);
    }

    public boolean c(String str) {
        Uri b = c.b(this.b, this.c, str);
        if (b == null) {
            return false;
        }
        this.c = b;
        return true;
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
        Uri[] a = c.a(this.b, this.c);
        a[] aVarArr = new a[a.length];
        for (int i = 0; i < a.length; i++) {
            aVarArr[i] = new f(this, this.b, a[i]);
        }
        return aVarArr;
    }
}
