package android.support.v4.app;

import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;

public class aX {
    private final List<String> a = new ArrayList();
    private final String b;
    private C0041bR c;
    private PendingIntent d;
    private PendingIntent e;
    private long f;

    public aX(String str) {
        this.b = str;
    }

    public aV a() {
        return new aV((String[]) this.a.toArray(new String[this.a.size()]), this.c, this.e, this.d, new String[]{this.b}, this.f);
    }

    public aX a(long j) {
        this.f = j;
        return this;
    }

    public aX a(PendingIntent pendingIntent) {
        this.d = pendingIntent;
        return this;
    }

    public aX a(PendingIntent pendingIntent, C0041bR c0041bR) {
        this.c = c0041bR;
        this.e = pendingIntent;
        return this;
    }

    public aX a(String str) {
        this.a.add(str);
        return this;
    }
}
