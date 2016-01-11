package cn.com.smartdevices.bracelet.notification;

import android.service.notification.NotificationListenerService;
import android.service.notification.NotificationListenerService.RankingMap;
import android.service.notification.StatusBarNotification;
import cn.com.smartdevices.bracelet.C0596r;

public class NotificationAccessService extends NotificationListenerService {
    private static final String a = "NotificationService";

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onListenerConnected() {
        C0596r.d(a, "MiSport-Notifi Listener Connected!!");
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        h.a(this, statusBarNotification);
    }

    public void onNotificationPosted(StatusBarNotification statusBarNotification, RankingMap rankingMap) {
        h.a(this, statusBarNotification);
    }

    public void onNotificationRankingUpdate(RankingMap rankingMap) {
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        h.a(statusBarNotification);
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification, RankingMap rankingMap) {
        h.a(statusBarNotification);
    }
}
