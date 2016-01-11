package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.h.g;
import java.util.ArrayList;
import java.util.List;

public class z {
    public static void a(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (g.f(context)) {
            SyncSportDataService.a(context.getApplicationContext(), j);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (b.h().g.ENABLE_RUNNING.booleanValue()) {
            d f = p.f(context);
            if (f != null && !f.o()) {
                return true;
            }
            List g = p.g(context, 4);
            if (g != null && g.size() > 0) {
                return true;
            }
            g = p.f(context, 4);
            if (g != null && g.size() > 0) {
                return true;
            }
            g = p.a(context, 4);
            return g != null && g.size() > 0;
        } else {
            C0596r.d("Sync", "isNeedSyncToServer !Config.getInstance().RUNNER.ENABLE");
            return false;
        }
    }

    public static boolean a(Context context, int i, ArrayList<Long> arrayList) {
        if (context != null && C0595q.a(i) && arrayList != null && arrayList.size() > 0) {
            return !g.f(context) ? false : SyncSportDataService.a(context.getApplicationContext(), i, arrayList);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void b(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (g.f(context)) {
            SyncSportDataService.b(context.getApplicationContext(), j);
        }
    }

    public static boolean b(Context context) {
        if (context != null) {
            return !g.f(context) ? false : SyncSportDataService.a(context.getApplicationContext(), 4);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean c(Context context) {
        if (!b.h().g.ENABLE_RUNNING.booleanValue()) {
            C0596r.d("Sync", "!Config.getInstance().RUNNER.ENABLE");
            return true;
        } else if (context != null) {
            return !g.f(context) ? false : SyncSportDataService.b(context.getApplicationContext());
        } else {
            throw new IllegalArgumentException();
        }
    }

    static boolean d(Context context) {
        if (context != null) {
            return !g.f(context) ? false : SyncSportDataService.a(context);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
