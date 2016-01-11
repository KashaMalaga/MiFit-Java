package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;

class j extends i {
    private final Object a;

    public j(Object obj) {
        this.a = obj;
    }

    public void a() {
        o.a(this.a);
    }

    public void a(long j) {
        o.a(this.a, j);
    }

    public void a(RatingCompat ratingCompat) {
        o.a(this.a, ratingCompat != null ? ratingCompat.g() : null);
    }

    public void b() {
        o.b(this.a);
    }

    public void c() {
        o.c(this.a);
    }

    public void d() {
        o.e(this.a);
    }

    public void e() {
        o.d(this.a);
    }

    public void f() {
        o.f(this.a);
    }

    public void stop() {
        o.stop(this.a);
    }
}
