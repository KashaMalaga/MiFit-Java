package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class t extends ContentObserver {
    final /* synthetic */ s a;

    public t(s sVar) {
        this.a = sVar;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.a.D();
    }
}
