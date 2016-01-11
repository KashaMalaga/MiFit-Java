package com.xiaomi.hm.health.bt.model;

import com.c.a.C0993k;
import java.util.Calendar;

public class AlarmClockItem {
    public static final int ALARM_CUSTOM = -1;
    public static final int ALARM_EVERY_DAY = ((((((ALARM_MON | ALARM_TUE) | ALARM_WED) | ALARM_THU) | ALARM_FRI) | ALARM_SAT) | ALARM_SUN);
    public static int ALARM_FRI = 16;
    public static int ALARM_MON = 1;
    public static final int ALARM_MON_2_FRI = ((((ALARM_MON | ALARM_TUE) | ALARM_WED) | ALARM_THU) | ALARM_FRI);
    public static final int ALARM_MON_2_SAT = (((((ALARM_MON | ALARM_TUE) | ALARM_WED) | ALARM_THU) | ALARM_FRI) | ALARM_SAT);
    public static int ALARM_ONCE = 0;
    public static int ALARM_SAT = 32;
    public static int ALARM_SUN = 64;
    public static int ALARM_THU = 8;
    public static int ALARM_TUE = 2;
    public static int ALARM_WED = 4;
    public static int MAX_COUNT = 3;
    public static int[] WEEK_MASK = new int[]{ALARM_MON, ALARM_TUE, ALARM_WED, ALARM_THU, ALARM_FRI, ALARM_SAT, ALARM_SUN};
    public Calendar calendar;
    private boolean enabled = true;
    private boolean isUpdate = false;
    private int mDays = 0;
    public int mSmartWakeupDuration = 0;

    public AlarmClockItem() {
        setCalendar(Calendar.getInstance());
        set(ALARM_MON_2_FRI, 8, 0, false);
    }

    public static AlarmClockItem fromJson(String str) {
        return (AlarmClockItem) new C0993k().a(str, AlarmClockItem.class);
    }

    public Calendar getCalendar() {
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
            this.calendar.set(11, 8);
            this.calendar.set(12, 0);
            setDuration(0);
            setDays(0);
            setUpdate(false);
        }
        return this.calendar;
    }

    public int getCoded() {
        return this.mDays;
    }

    public int getDays() {
        return this.mDays;
    }

    public int getDuration() {
        return this.mSmartWakeupDuration;
    }

    public int getHour() {
        return getCalendar().get(11);
    }

    public int getMinute() {
        return getCalendar().get(12);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isSmartWakeup() {
        return getDuration() > 0;
    }

    public boolean isUpdate() {
        return this.isUpdate;
    }

    public void set(int i, int i2, int i3, boolean z) {
        this.mDays = i;
        getCalendar().set(11, i2);
        getCalendar().set(12, i3);
        this.enabled = z;
    }

    public void set(int i, int i2, boolean z) {
        set(this.mDays, i, i2, z);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setDays(int i) {
        this.mDays = i;
    }

    public void setDuration(int i) {
        this.mSmartWakeupDuration = i;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setUpdate(boolean z) {
        this.isUpdate = z;
    }

    public String toJson() {
        return new C0993k().b((Object) this);
    }
}
