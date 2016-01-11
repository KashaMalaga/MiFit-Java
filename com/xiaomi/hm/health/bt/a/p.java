package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import java.util.ArrayList;
import java.util.Calendar;

public class p extends C {
    private ArrayList<AlarmClockItem> a = null;

    public p(ArrayList<AlarmClockItem> arrayList, d dVar) {
        super(dVar);
        this.a = arrayList;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        for (int i = 0; i < this.a.size(); i++) {
            AlarmClockItem alarmClockItem = (AlarmClockItem) this.a.get(i);
            C0596r.e(p, "BleSetAlarmClockTask:" + alarmClockItem.toJson());
            int coded = alarmClockItem.getCoded();
            if (alarmClockItem.calendar == null) {
                alarmClockItem.calendar = Calendar.getInstance();
            }
            C0596r.e(p, "Set alarm at: " + i + ", " + alarmClockItem.getCalendar());
            C0596r.b(p, "Set alarm at: " + i + ", " + alarmClockItem.toJson());
            this.q.a((byte) i, (byte) (alarmClockItem.isEnabled() ? 1 : 0), alarmClockItem.calendar, (byte) alarmClockItem.getDuration(), (byte) coded);
            alarmClockItem.setUpdate(false);
        }
        if (dVar != null) {
            dVar.c(Boolean.valueOf(true));
        }
    }
}
