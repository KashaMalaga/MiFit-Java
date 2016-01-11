package cn.com.smartdevices.bracelet.h;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Keeper;
import com.xiaomi.hm.health.bt.model.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

class c implements Runnable {
    final /* synthetic */ F a;
    final /* synthetic */ a b;

    c(a aVar, F f) {
        this.b = aVar;
        this.a = f;
    }

    public void run() {
        if (this.a != null) {
            this.a.a();
        }
        C0596r.e("xxx", "in syncSensorHubData:" + new Date(this.b.k.c()).toString());
        LinkedList a = this.b.c.a(this.b.k.c(), Calendar.getInstance().getTimeInMillis());
        Object obj = null;
        b a2 = this.b.a(a);
        if (a2 != null) {
            List arrayList = new ArrayList();
            arrayList.add(a2);
            this.b.k.b(((g) a.getLast()).c());
            Keeper.keepSensorHubInfo(this.b.k);
            obj = arrayList;
        }
        if (this.a != null) {
            this.a.a(obj);
        }
    }
}
