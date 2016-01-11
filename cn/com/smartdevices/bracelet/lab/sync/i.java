package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.gps.sync.z;
import com.xiaomi.hm.health.bt.a.d;
import java.util.ArrayList;

public class i {
    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0591m a = C0591m.a();
        ArrayList a2 = a.a(new C0595q(1));
        if (a2 != null && a2.size() > 0) {
            return true;
        }
        ArrayList a3 = a.a(new C0595q(2));
        return (a3 == null || a3.size() <= 0) ? z.a(context) : true;
    }

    public static boolean a(Context context, d dVar) {
        if (context != null) {
            return !Utils.l(context) ? false : SyncLabSportService.c(context.getApplicationContext()) & z.b(context.getApplicationContext());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (Utils.l(context)) {
            SyncLabSportService.a(context.getApplicationContext());
        }
    }
}
