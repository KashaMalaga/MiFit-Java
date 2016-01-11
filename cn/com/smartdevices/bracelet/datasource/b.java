package cn.com.smartdevices.bracelet.datasource;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import com.xiaomi.hm.health.bt.d.e;

class b {
    static C0639p a = null;

    b() {
    }

    static void a(Context context, boolean z, e eVar) {
        if (context != null) {
            C0596r.e("RtSteps", "Enable = " + z + ",profile = " + a);
            if (z) {
                if (a == null) {
                    a = new C0639p(context);
                    a.b(eVar);
                }
            } else if (a != null) {
                a.a(eVar);
                a.a();
                a = null;
            }
        }
    }
}
