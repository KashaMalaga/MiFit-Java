package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

class C0242l extends ContentObserver {
    final /* synthetic */ C0206j a;

    public C0242l(C0206j c0206j) {
        this.a = c0206j;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.a.c();
    }
}
