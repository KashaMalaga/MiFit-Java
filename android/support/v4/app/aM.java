package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public class aM extends bq {
    public static final br d = new aN();
    public int a;
    public CharSequence b;
    public PendingIntent c;
    private final Bundle e;
    private final C0041bR[] f;

    public aM(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i, charSequence, pendingIntent, new Bundle(), null);
    }

    private aM(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C0041bR[] c0041bRArr) {
        this.a = i;
        this.b = aT.f(charSequence);
        this.c = pendingIntent;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.e = bundle;
        this.f = c0041bRArr;
    }

    protected int a() {
        return this.a;
    }

    protected CharSequence b() {
        return this.b;
    }

    protected PendingIntent c() {
        return this.c;
    }

    public Bundle d() {
        return this.e;
    }

    public C0041bR[] e() {
        return this.f;
    }

    public /* synthetic */ ca[] f() {
        return e();
    }
}
