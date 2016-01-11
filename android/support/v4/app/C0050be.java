package android.support.v4.app;

import android.app.Notification;
import android.support.v4.view.a.C0113o;

class C0050be extends C0045bd {
    C0050be() {
    }

    public Notification a(aT aTVar) {
        Notification notification = aTVar.B;
        notification.setLatestEventInfo(aTVar.a, aTVar.b, aTVar.c, aTVar.d);
        notification = C0060bv.a(notification, aTVar.a, aTVar.b, aTVar.c, aTVar.d, aTVar.e);
        if (aTVar.j > 0) {
            notification.flags |= C0113o.h;
        }
        return notification;
    }
}
