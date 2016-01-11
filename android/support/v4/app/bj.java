package android.support.v4.app;

import android.app.Notification;

public abstract class bj {
    aT d;
    CharSequence e;
    CharSequence f;
    boolean g = false;

    public Notification a() {
        return this.d != null ? this.d.c() : null;
    }

    public void a(aT aTVar) {
        if (this.d != aTVar) {
            this.d = aTVar;
            if (this.d != null) {
                this.d.a(this);
            }
        }
    }
}
