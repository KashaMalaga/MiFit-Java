package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class bP {
    bP() {
    }

    static void a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(str, i);
    }

    public static void a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }
}
