package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService extends Service {
    private void a(int i, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (i2 < length) {
            if (!packagesForUid[i2].equals(str)) {
                i2++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }

    public abstract void a(String str);

    public abstract void a(String str, int i, String str2);

    public abstract void a(String str, int i, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        return (!intent.getAction().equals(bE.b) || VERSION.SDK_INT > 19) ? null : new bD();
    }
}
