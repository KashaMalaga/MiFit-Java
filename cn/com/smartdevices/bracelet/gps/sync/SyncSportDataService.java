package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SyncSportDataService extends C0468b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final int d = 0;
    private static final int e = 4;
    private static final int f = 6;
    private static final int g = 7;
    private static final int h = 5;
    private static final int i = 8;
    private static final int j = 9;
    private P k = null;
    private L l = null;

    public SyncSportDataService() {
        super(SyncSportDataService.class.getName());
    }

    static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        context.startService(b(context, (int) j));
        return true;
    }

    static boolean a(Context context, int i) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        } else if (b.h().g.ENABLE_RUNNING.booleanValue()) {
            return (a & C0485s.b(context, e)) & F.a(context, (int) e, null);
        } else {
            C0596r.d("Sync", "syncDataToServerInternal !Config.getInstance().RUNNER.ENABLE");
            return true;
        }
    }

    static boolean a(Context context, int i, ArrayList<Long> arrayList) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent b = b(context, (int) i);
        b.putExtra(C0483q.a, arrayList);
        context.startService(b);
        return true;
    }

    static boolean a(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent b = b(context, (int) f);
        b.putExtra(C0483q.a, j);
        context.startService(b);
        return true;
    }

    private static Intent b(Context context, int i) {
        Intent intent = new Intent();
        intent.setClass(context, SyncSportDataService.class);
        intent.putExtra(SocialConstants.PARAM_TYPE, i);
        return intent;
    }

    static boolean b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        context.startService(b(context, (int) d));
        return true;
    }

    static boolean b(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent b = b(context, (int) g);
        b.putExtra(C0483q.a, j);
        context.startService(b);
        return true;
    }

    void a(Context context, String str) {
        boolean a = C0485s.a(context, (int) e);
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        dataSyncObject.b = bundle;
        dataSyncObject.a = str;
        bundle.putBoolean(C0483q.g, a);
        this.l.c(dataSyncObject);
    }

    void a(Context context, String str, long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            this.l.b(null);
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        String b = new k(instance).b();
        instance.setTimeInMillis(j2 * 1000);
        String b2 = new k(instance).b();
        C0596r.e("Sync", "syncSummaryInRangeSynced fromDate = " + b + ",toDate = " + b2 + ",ID = " + str);
        this.l.a(str, F.a(context, e, b, b2), j, j2);
    }

    public void a(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(SocialConstants.PARAM_TYPE, -1);
            C0596r.e("Sync", "onHandleIntent command = " + intExtra);
            if (intExtra != -1) {
                Context application = getApplication();
                Bundle bundleExtra;
                long longExtra;
                switch (intExtra) {
                    case d /*0*/:
                        bundleExtra = intent.getBundleExtra(SyncShoesDataService.a);
                        C0596r.e("Sync", "COMMAND_TWO_WAY_SYNC_DATA bundle = " + bundleExtra);
                        if (bundleExtra != null) {
                            String stringExtra = intent.getStringExtra(SyncShoesDataService.d);
                            C0485s.b(application, e, new O(this, stringExtra));
                            b(application, stringExtra, bundleExtra.getLong(C0483q.e), bundleExtra.getLong(C0483q.f));
                            a(application, stringExtra);
                            return;
                        }
                        C0485s.b(application, e, new O(this, Constants.VIA_RESULT_SUCCESS));
                        a(application, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                        return;
                    case e /*4*/:
                        bundleExtra = intent.getBundleExtra(SyncShoesDataService.a);
                        if (bundleExtra != null) {
                            a(application, intent.getStringExtra(SyncShoesDataService.d), bundleExtra.getLong(C0483q.e), bundleExtra.getLong(C0483q.f));
                            return;
                        }
                        return;
                    case h /*5*/:
                        d f = p.f(application);
                        if (f != null && !f.o()) {
                            C0485s.c(application, e);
                            return;
                        }
                        return;
                    case f /*6*/:
                        longExtra = intent.getLongExtra(C0483q.a, -1);
                        if (longExtra > 0) {
                            w.b(application, (int) e, longExtra);
                            return;
                        }
                        return;
                    case g /*7*/:
                        longExtra = intent.getLongExtra(C0483q.a, -1);
                        C0596r.e("Sync", "COMMAND_SYNC_TO_SERVER_TARGET_TRACK_INFO trackId = " + longExtra);
                        if (longExtra > 0) {
                            C0485s.a(application, (int) e, longExtra);
                            return;
                        }
                        return;
                    case i /*8*/:
                        List list = (List) intent.getSerializableExtra(C0483q.a);
                        if (list != null) {
                            F.a(application, (int) e, list);
                            return;
                        }
                        return;
                    case j /*9*/:
                        intent.getLongExtra(C0483q.a, -1);
                        if (intent.getBundleExtra(SyncShoesDataService.a) != null) {
                            a(application, intent.getStringExtra(SyncShoesDataService.d));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public Binder b(Intent intent) {
        super.onBind(intent);
        if (this.k == null) {
            this.k = new P();
        }
        return this.k;
    }

    void b(Context context, String str, long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            this.l.b(null);
            return;
        }
        C0596r.e("Sync", "syncTrackDiffSynced fromSecondTime = " + j + ",toSecondTime = " + j2 + ",ID = " + str);
        List a = F.a(context, j, j2, e, -1);
        if (a == null || a.size() > 0) {
            List a2 = p.a(context, j, j2, (int) e);
            if (a2 == null) {
                this.l.b(null);
                return;
            }
            boolean z;
            C0474g a3 = C0474g.a(a, a2);
            boolean z2 = true;
            int size = a3.b.size();
            if (size > 0) {
                z2 = a & p.a(context, a3.b);
                C0596r.e("Sync", "syncTrackDiffSynced removeTrackIdData isSucceeded = " + z2);
            }
            int size2 = a3.a.size();
            if (size2 > 0) {
                int i = d;
                z = z2;
                while (i < size2) {
                    z &= F.a(context, a3.a.subList(i, i + 20 >= size2 ? size2 : i + 20), (int) e).a;
                    i += 20;
                }
            } else {
                z = z2;
            }
            L l = this.l;
            boolean z3 = size2 > 0 || size > 0;
            l.a(str, j, j2, z, z3);
            C0596r.e("Sync", "syncTrackDiffSynced syncSummaryFromServerBatch isSucceeded = " + z);
            return;
        }
        this.l.b(null);
    }

    public /* synthetic */ IBinder onBind(Intent intent) {
        return b(intent);
    }

    public void onCreate() {
        super.onCreate();
        a(true);
        this.l = new L();
        C0596r.e("Sync", "onCreate");
    }

    public void onDestroy() {
        if (this.l != null) {
            this.l.a();
        }
        super.onDestroy();
        C0596r.e("Sync", "onDestroy");
    }

    public /* bridge */ /* synthetic */ void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
