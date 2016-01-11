package com.xiaomi.hm.health.bt.a;

import android.util.Pair;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.Calendar;

public class s extends C {
    public s(d dVar) {
        super(dVar);
    }

    public void a(d dVar) {
        if (dVar != null) {
            try {
                dVar.c();
            } catch (Exception e) {
                C0596r.d(p, "BleSetDateTimeTask exception:" + e.getMessage());
                return;
            }
        }
        boolean a = this.q.a(Calendar.getInstance());
        if (a) {
            Pair I = this.q.I();
            C0596r.b(p, "new time:" + ((Calendar) I.first).getTime().toString() + ",old time:" + ((Calendar) I.second).getTime().toString());
        }
        if (dVar != null) {
            dVar.c(Boolean.valueOf(a));
        }
    }
}
