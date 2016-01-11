package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import java.util.HashSet;
import java.util.List;

public class J {
    private J() {
    }

    public static boolean a(Context context) {
        if (!b.h().t.a.booleanValue()) {
            C0596r.d(B.a, "isNeedToSyncDataToServer !Config.getInstance().SHOES.ENABLE");
            return false;
        } else if (context == null) {
            throw new IllegalArgumentException();
        } else {
            List g = t.g(context);
            if (g != null && g.size() > 0) {
                return true;
            }
            g = t.c(context);
            return g != null && g.size() > 0;
        }
    }

    public static boolean a(Context context, c cVar) {
        if (context != null) {
            return (!cn.com.smartdevices.bracelet.shoes.sync.c.c.f(context) || cVar == null || cVar.e()) ? false : SyncShoesDataService.a(context, cVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static boolean a(Context context, c cVar, int i) {
        if (context != null) {
            return !cn.com.smartdevices.bracelet.shoes.sync.c.c.f(context) ? false : SyncShoesDataService.a(context, cVar, i, null);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static boolean a(Context context, c cVar, HashSet<String> hashSet) {
        if (context != null) {
            return !cn.com.smartdevices.bracelet.shoes.sync.c.c.f(context) ? false : SyncShoesDataService.a(context, cVar, -1, hashSet);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean a(Context context, e eVar) {
        if (context != null) {
            return !cn.com.smartdevices.bracelet.shoes.sync.c.c.f(context) ? false : SyncShoesDataService.a(context, eVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean b(Context context) {
        if (!b.h().t.a.booleanValue()) {
            C0596r.d(B.a, "syncAllShoesDataToServerSynced !Config.getInstance().SHOES.ENABLE");
            return true;
        } else if (context != null) {
            return !cn.com.smartdevices.bracelet.shoes.sync.c.c.f(context) ? false : SyncShoesDataService.b(context);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean c(Context context) {
        if (b.h().t.a.booleanValue()) {
            return a(context, null, null);
        }
        C0596r.d(B.a, "syncTwoWayDataASynced !Config.getInstance().SHOES.ENABLE");
        return true;
    }

    public static boolean d(Context context) {
        boolean a = F.a(context);
        if (!a) {
            C0596r.e(B.a, "Failed to syncPartner from Manual");
        }
        return a;
    }
}
