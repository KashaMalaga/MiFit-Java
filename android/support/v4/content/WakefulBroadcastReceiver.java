package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;
import com.xiaomi.mistatistic.sdk.d;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String a = "android.support.content.wakelockid";
    private static final SparseArray<WakeLock> b = new SparseArray();
    private static int c = 1;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (b) {
            int i = c;
            c++;
            if (c <= 0) {
                c = 1;
            }
            intent.putExtra(a, i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(d.g);
            b.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra(a, 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (b) {
            WakeLock wakeLock = (WakeLock) b.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                b.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
