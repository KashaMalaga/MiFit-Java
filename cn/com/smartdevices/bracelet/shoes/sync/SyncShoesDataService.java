package cn.com.smartdevices.bracelet.shoes.sync;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.a;
import cn.com.smartdevices.bracelet.shoes.data.b;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.huami.android.zxing.CaptureActivity;
import java.util.HashSet;

public class SyncShoesDataService extends IntentService {
    public static final String a = "bundle";
    public static final String b = "fromDate";
    public static final String c = "toDate";
    public static final String d = "id";
    public static final String e = "state";
    public static final String f = "dateset";
    private static final int g = 3;
    private static final int h = 5;
    private static final int i = 6;
    private static final int j = 7;
    private static final int k = 9;
    private static final String l = "command";

    public SyncShoesDataService() {
        super(SyncShoesDataService.class.getName());
    }

    private static Intent a(Context context, int i) {
        Intent intent = new Intent(context, SyncShoesDataService.class);
        intent.putExtra(l, i);
        return intent;
    }

    static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        context.startService(a(context, (int) g));
        return true;
    }

    static boolean a(Context context, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent a = a(context, (int) k);
        a.putExtra(d, cVar);
        context.startService(a);
        return true;
    }

    static boolean a(Context context, c cVar, int i, HashSet<String> hashSet) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent a = a(context, (int) j);
        a.putExtra(d, cVar);
        a.putExtra(e, i);
        if (hashSet != null && hashSet.size() > 0) {
            a.putExtra(f, hashSet);
        }
        context.startService(a);
        return true;
    }

    static boolean a(Context context, e eVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Intent a = a(context, (int) i);
        if (eVar != null) {
            a.putExtra(CaptureActivity.l, eVar);
        }
        context.startService(a);
        return true;
    }

    private static void b(Context context, c cVar) {
        Intent a = a(context, (int) h);
        a.putExtra(d, cVar);
        context.startService(a);
    }

    static boolean b(Context context) {
        if (context != null) {
            return I.a(context);
        }
        throw new IllegalArgumentException();
    }

    public Binder a(Intent intent) {
        C0596r.e(B.a, "onBind");
        return null;
    }

    public /* synthetic */ IBinder onBind(Intent intent) {
        return a(intent);
    }

    public void onCreate() {
        super.onCreate();
        setIntentRedelivery(true);
        cn.com.smartdevices.bracelet.shoes.b.c.b(this);
        C0596r.e(B.a, "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        C0596r.e(B.a, "onDestroy");
    }

    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(l, -1);
            C0596r.e(B.a, "onHandleIntent command = " + intExtra);
            if (intExtra != -1) {
                Context application = getApplication();
                c cVar;
                switch (intExtra) {
                    case g /*3*/:
                        C0596r.d(B.a, "COMMAND_SYNC_ALL_SHOES_DATA_TO_SERVER");
                        I.a(application);
                        return;
                    case h /*5*/:
                        cVar = (c) intent.getSerializableExtra(d);
                        C0596r.d(B.a, "COMMAND_SYNC_ALL_DATE_DATA_FROM_SERVER");
                        I.a(application, cVar);
                        return;
                    case i /*6*/:
                        P.a(application, (e) intent.getSerializableExtra(CaptureActivity.l));
                        return;
                    case j /*7*/:
                        cVar = (c) intent.getSerializableExtra(d);
                        if (cVar == null || cVar.e()) {
                            cVar = b.b(application, false);
                            C0596r.e(B.a, "COMMAND_TWO_WAY_SYNC_WITH_SERVER from DB address = " + cVar);
                        }
                        if (!a.b(application)) {
                            if (cVar == null || cVar.e()) {
                                cVar = x.a(application);
                            }
                            C0596r.d(B.a, "COMMAND_TWO_WAY_SYNC_WITH_SERVER from server indentity:" + cVar);
                            a.a(application, true);
                        }
                        c cVar2 = cVar;
                        if (!a.a(application, com.xiaomi.e.a.f)) {
                            b(application, null);
                        }
                        I.a(application, cVar2, intent.getIntExtra(e, -1), (HashSet) intent.getSerializableExtra(f));
                        return;
                    case k /*9*/:
                        cVar = (c) intent.getSerializableExtra(d);
                        C0596r.e(B.a, "COMMAND_SYNC_BIND_INFO_TO_SERVER indentity = " + cVar);
                        if (cVar != null && !cVar.e() && !cn.com.smartdevices.bracelet.shoes.c.d(application, cVar.b())) {
                            cn.com.smartdevices.bracelet.shoes.c.a(application, cVar.b(), v.a(application, cVar));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
