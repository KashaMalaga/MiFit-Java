package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.profile.a.g;
import com.xiaomi.hm.health.bt.profile.a.i;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;

public class l extends C {
    private i a = null;
    private int b = 0;

    public l(i iVar, int i, d dVar) {
        super(dVar);
        this.a = iVar;
        this.b = i;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        if (this.a != null) {
            int i;
            boolean a = this.q.a((byte) 0, this.a.b);
            C0596r.d(p, "setGoal goals=" + this.a.b + ",ret=" + a);
            ArrayList arrayList = this.a.c;
            int i2 = 0;
            int i3 = a;
            while (i2 < arrayList.size()) {
                AlarmClockItem alarmClockItem = (AlarmClockItem) arrayList.get(i2);
                boolean a2 = i3 & this.q.a((byte) i2, (byte) (alarmClockItem.isEnabled() ? 1 : 0), alarmClockItem.getCalendar(), (byte) alarmClockItem.getDuration(), (byte) alarmClockItem.getCoded());
                C0596r.d(p, "Set alarm at: " + i2 + ", alarm=" + alarmClockItem.toJson() + ",ret=" + a2);
                alarmClockItem.setUpdate(false);
                i2++;
                boolean z = a2;
            }
            h j_ = this.q.j_();
            if (j_ == null || !j_.b()) {
                i = this.a.d;
                byte b = (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
                byte b2 = (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
                byte b3 = (byte) (i & HeartRateInfo.HR_EMPTY_VALUE);
                i = this.q.a(b, b2, b3, (byte) 0) & i3;
                C0596r.d(p, "setColorTheme r=" + b + ",g=" + b2 + ",b=" + b3 + ",ret=" + i);
            } else {
                C0596r.d(p, "1A not set color theme!!!");
                i = i3;
            }
            if (j_ != null && j_.a()) {
                byte a3 = this.a.h ? com.xiaomi.hm.health.bt.profile.a.h.OPEN.a() : com.xiaomi.hm.health.bt.profile.a.h.CLOSE.a();
                i &= this.q.a(g.SLEEP.a(), a3);
                C0596r.d(p, "set sleep assist " + a3 + ",ret=" + i);
            }
            a = i & this.q.c(this.a.f);
            C0596r.d(p, "setWearLocation location=" + this.a.f + ",ret=" + a);
            a &= this.q.d(this.a.g);
            C0596r.d(p, "_enableConnectedBroadcast enableAdv=" + this.a.g + ",ret=" + a);
            if (this.b > 0) {
                a &= this.q.c(this.b);
                C0596r.d(p, "writeBaseSteps steps=" + this.b + ",ret=" + a);
            } else {
                C0596r.d(p, "writeBaseSteps : no basesteps!");
            }
            if (dVar != null) {
                dVar.c(Boolean.valueOf(a));
            }
        } else if (dVar != null) {
            dVar.c(Boolean.valueOf(false));
        }
    }
}
