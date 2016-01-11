package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class aO {
    private final int a;
    private final CharSequence b;
    private final PendingIntent c;
    private final Bundle d;
    private ArrayList<C0041bR> e;

    public aO(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i, charSequence, pendingIntent, new Bundle());
    }

    private aO(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.a = i;
        this.b = aT.f(charSequence);
        this.c = pendingIntent;
        this.d = bundle;
    }

    public aO(aM aMVar) {
        this(aMVar.a, aMVar.b, aMVar.c, new Bundle(aMVar.e));
    }

    public Bundle a() {
        return this.d;
    }

    public aO a(Bundle bundle) {
        if (bundle != null) {
            this.d.putAll(bundle);
        }
        return this;
    }

    public aO a(aP aPVar) {
        aPVar.a(this);
        return this;
    }

    public aO a(C0041bR c0041bR) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(c0041bR);
        return this;
    }

    public aM b() {
        return new aM(this.a, this.b, this.c, this.d, this.e != null ? (C0041bR[]) this.e.toArray(new C0041bR[this.e.size()]) : null);
    }
}
