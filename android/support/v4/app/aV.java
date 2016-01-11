package android.support.v4.app;

import android.app.PendingIntent;

public class aV extends bs {
    static final bt a = new aW();
    private final String[] b;
    private final C0041bR c;
    private final PendingIntent d;
    private final PendingIntent e;
    private final String[] f;
    private final long g;

    aV(String[] strArr, C0041bR c0041bR, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
        this.b = strArr;
        this.c = c0041bR;
        this.e = pendingIntent2;
        this.d = pendingIntent;
        this.f = strArr2;
        this.g = j;
    }

    String[] a() {
        return this.b;
    }

    C0041bR b() {
        return this.c;
    }

    PendingIntent c() {
        return this.d;
    }

    PendingIntent d() {
        return this.e;
    }

    String[] e() {
        return this.f;
    }

    String f() {
        return this.f.length > 0 ? this.f[0] : null;
    }

    long g() {
        return this.g;
    }

    /* synthetic */ ca h() {
        return b();
    }
}
