package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class bH implements bG {
    bH() {
    }

    public int a() {
        return 1;
    }

    public void a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(i);
    }

    public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(i, notification);
    }
}
