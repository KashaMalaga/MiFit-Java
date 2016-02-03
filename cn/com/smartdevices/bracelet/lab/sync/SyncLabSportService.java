package cn.com.smartdevices.bracelet.lab.sync;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;
import com.xiaomi.channel.relationservice.data.a;

public class SyncLabSportService extends IntentService {
    private static final int a = 0;
    private static final int b = 1;

    public SyncLabSportService() {
        super(SyncLabSportService.class.getName());
    }

    private static Intent a(Context context, int i) {
        Intent intent = new Intent();
        intent.setClass(context, SyncLabSportService.class);
        intent.putExtra(a.h, i);
        return intent;
    }

    static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        if (!e(context)) {
            b(context);
        }
        return true;
    }

    static boolean b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        context.startService(a(context, b));
        return true;
    }

    static boolean c(Context context) {
        if (context != null) {
            return d(context);
        }
        throw new IllegalArgumentException();
    }

    private static boolean d(Context context) {
        return (e.a(context, new C0595q(b)) & b) & e.a(context, new C0595q(2));
    }

    private static boolean e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        SyncedServerDataInfo readInfoFromPref = SyncedServerDataInfo.readInfoFromPref(b);
        SyncedServerDataInfo readInfoFromPref2 = SyncedServerDataInfo.readInfoFromPref(2);
        boolean isSucceededToSaved = readInfoFromPref.isSucceededToSaved();
        boolean isSucceededToSaved2 = readInfoFromPref2.isSucceededToSaved();
        if (isSucceededToSaved && isSucceededToSaved2) {
            C0596r.e("Sync", "isRopeDataSaved && isSkippingDataSaved");
            return false;
        }
        C0596r.e("Sync", "isRopeDataSaved = " + isSucceededToSaved + ",isSkippingDataSaved = " + isSucceededToSaved2);
        context.startService(a(context, a));
        return true;
    }

    public Binder a(Intent intent) {
        return null;
    }

    public /* synthetic */ IBinder onBind(Intent intent) {
        return a(intent);
    }

    public void onCreate() {
        super.onCreate();
        setIntentRedelivery(true);
        C0596r.e("Sync", "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        C0596r.e("Sync", "onDestroy");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(a.h, -1);
            C0596r.e("Sync", "onHandleIntent command = " + intExtra);
            if (intExtra != -1) {
                Context application = getApplication();
                switch (intExtra) {
                    case a /*0*/:
                        e.a(application);
                        return;
                    case b /*1*/:
                        C0596r.e("Sync", "syncToServerAllSportData  isSucceeded = " + d(application));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
