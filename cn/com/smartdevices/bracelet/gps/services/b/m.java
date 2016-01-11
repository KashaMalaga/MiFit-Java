package cn.com.smartdevices.bracelet.gps.services.b;

import android.annotation.SuppressLint;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.xiaomi.channel.b.v;

public final class m {
    @SuppressLint({"NewApi"})
    public static void a(Service service) {
        if (service == null) {
            throw new IllegalArgumentException();
        }
        ((NotificationManager) service.getApplicationContext().getSystemService("notification")).cancel(n.a);
        service.stopForeground(true);
    }

    @SuppressLint({"NewApi"})
    public static boolean b(Service service) {
        if (service == null) {
            throw new IllegalArgumentException();
        }
        Context applicationContext = service.getApplicationContext();
        try {
            Intent intent = new Intent(new Intent(applicationContext, Class.forName("cn.com.smartdevices.bracelet.gps.ui.GPSMainActivity")));
            intent.setFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(applicationContext, 0, intent, 134217728);
            Resources resources = applicationContext.getResources();
            int identifier = resources.getIdentifier("running_backgroud_notification", "string", applicationContext.getPackageName());
            if (identifier <= 0) {
                return false;
            }
            int identifier2 = resources.getIdentifier(v.v, "string", applicationContext.getPackageName());
            if (identifier <= 0) {
                return false;
            }
            int identifier3 = resources.getIdentifier("app_icon_small", "drawable", applicationContext.getPackageName());
            if (identifier <= 0) {
                return false;
            }
            service.startForeground(n.a, new Builder(applicationContext).setContentIntent(activity).setContentText(applicationContext.getString(identifier)).setContentTitle(applicationContext.getString(identifier2)).setOngoing(true).setSmallIcon(identifier3).setWhen(System.currentTimeMillis()).build());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
