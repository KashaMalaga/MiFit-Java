package com.xiaomi.hm.health.dataprocess;

import com.xiaomi.account.openauth.h;
import com.xiaomi.mistatistic.sdk.d;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class SportDay implements Serializable {
    private static final int ISO_FIRST_DAY_OF_WEEK = 2;
    private static final int ISO_MINIMAL_DAYS_IN_FIRST_WEEK = 4;
    private static final int US_FIRST_DAY_OF_WEEK = 1;
    private static final int US_MINIMAL_DAYS_IN_FIRST_WEEK = 1;
    private static int sFirstDayOfWeek = 0;
    private static boolean sIsEnglish = Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString());
    private static int sMinimalDaysInFirstWeek = 0;
    private static final long serialVersionUID = 1;
    public Calendar calendar;
    public int day;
    public int mon;
    public int year;

    static {
        sFirstDayOfWeek = ISO_FIRST_DAY_OF_WEEK;
        sMinimalDaysInFirstWeek = ISO_MINIMAL_DAYS_IN_FIRST_WEEK;
        if (sIsEnglish) {
            sFirstDayOfWeek = US_MINIMAL_DAYS_IN_FIRST_WEEK;
            sMinimalDaysInFirstWeek = US_MINIMAL_DAYS_IN_FIRST_WEEK;
        }
    }

    public SportDay() {
        this(Calendar.getInstance());
    }

    public SportDay(int i, int i2, int i3) {
        this.year = i;
        this.mon = i2;
        this.day = i3;
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.setFirstDayOfWeek(sFirstDayOfWeek);
        instance.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+" + (((instance.get(15) / h.E) / 60) / 60)));
        this.calendar = instance;
    }

    public SportDay(SportDay sportDay) {
        this(sportDay.year, sportDay.mon, sportDay.day);
    }

    public SportDay(Calendar calendar) {
        this.year = calendar.get(US_MINIMAL_DAYS_IN_FIRST_WEEK);
        this.mon = calendar.get(ISO_FIRST_DAY_OF_WEEK);
        this.day = calendar.get(5);
        calendar.setFirstDayOfWeek(sFirstDayOfWeek);
        calendar.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+" + (((calendar.get(15) / h.E) / 60) / 60)));
        this.calendar = calendar;
    }

    public static SportDay fromString(String str) {
        try {
            String[] split = str.split("-");
            return new SportDay(Integer.parseInt(split[0]), Integer.parseInt(split[US_MINIMAL_DAYS_IN_FIRST_WEEK]) - 1, Integer.parseInt(split[ISO_FIRST_DAY_OF_WEEK]));
        } catch (Exception e) {
            return new SportDay();
        }
    }

    public static SportDay getToday() {
        return new SportDay();
    }

    public static void onLocaleChanged(boolean z) {
        if (z != sIsEnglish) {
            sIsEnglish = z;
            if (sIsEnglish) {
                sFirstDayOfWeek = US_MINIMAL_DAYS_IN_FIRST_WEEK;
                sMinimalDaysInFirstWeek = US_MINIMAL_DAYS_IN_FIRST_WEEK;
                return;
            }
            sFirstDayOfWeek = ISO_FIRST_DAY_OF_WEEK;
            sMinimalDaysInFirstWeek = ISO_MINIMAL_DAYS_IN_FIRST_WEEK;
        }
    }

    public static Calendar toCalenday(String str) {
        Calendar instance = Calendar.getInstance();
        try {
            String[] split = str.split("-");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[US_MINIMAL_DAYS_IN_FIRST_WEEK]) - 1;
            int parseInt3 = Integer.parseInt(split[ISO_FIRST_DAY_OF_WEEK]);
            instance.clear();
            instance.set(parseInt, parseInt2, parseInt3);
        } catch (Exception e) {
        }
        return instance;
    }

    public SportDay addDay(int i) {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.add(6, i);
        return new SportDay(instance);
    }

    public SportDay addMonth(int i) {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.add(ISO_FIRST_DAY_OF_WEEK, i);
        return new SportDay(instance);
    }

    public SportDay addWeek(int i) {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.add(3, i);
        return new SportDay(instance);
    }

    public SportDay addYear(int i) {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.add(US_MINIMAL_DAYS_IN_FIRST_WEEK, i);
        return new SportDay(instance);
    }

    public boolean after(SportDay sportDay) {
        if (this.year > sportDay.year) {
            return true;
        }
        if (this.year == sportDay.year) {
            if (this.mon > sportDay.mon) {
                return true;
            }
            if (this.mon == sportDay.mon && this.day > sportDay.day) {
                return true;
            }
        }
        return false;
    }

    public boolean before(SportDay sportDay) {
        if (this.year < sportDay.year) {
            return true;
        }
        if (this.year == sportDay.year) {
            if (this.mon < sportDay.mon) {
                return true;
            }
            if (this.mon == sportDay.mon && this.day < sportDay.day) {
                return true;
            }
        }
        return false;
    }

    public int compare(SportDay sportDay) {
        return this.year > sportDay.year ? US_MINIMAL_DAYS_IN_FIRST_WEEK : this.year < sportDay.year ? -1 : this.mon <= sportDay.mon ? this.mon < sportDay.mon ? -1 : this.day <= sportDay.day ? this.day < sportDay.day ? -1 : 0 : US_MINIMAL_DAYS_IN_FIRST_WEEK : US_MINIMAL_DAYS_IN_FIRST_WEEK;
    }

    public boolean equals(int i, int i2, int i3) {
        return this.day == i3 && this.mon == i2 && this.year == i;
    }

    public boolean equals(SportDay sportDay) {
        return this.day == sportDay.day && this.mon == sportDay.mon && this.year == sportDay.year;
    }

    public boolean equals(Calendar calendar) {
        return equals(calendar.get(US_MINIMAL_DAYS_IN_FIRST_WEEK), calendar.get(ISO_FIRST_DAY_OF_WEEK), calendar.get(5));
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public String getKey() {
        return toString();
    }

    public SportDay getMonthEndDay() {
        SportDay monthStartDay = getMonthStartDay();
        SportDay sportDay = null;
        for (int i = US_MINIMAL_DAYS_IN_FIRST_WEEK; i <= ISO_MINIMAL_DAYS_IN_FIRST_WEEK; i += US_MINIMAL_DAYS_IN_FIRST_WEEK) {
            sportDay = monthStartDay.addDay(31 - i);
            if (sportDay.year == this.year && sportDay.mon == this.mon) {
                break;
            }
        }
        return sportDay;
    }

    public SportDay getMonthStartDay() {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        instance.set(5, US_MINIMAL_DAYS_IN_FIRST_WEEK);
        return new SportDay(instance);
    }

    public SportDay getPreDay() {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day - 1);
        return new SportDay(instance);
    }

    public long getTimestamp() {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(this.year, this.mon, this.day);
        return instance.getTimeInMillis();
    }

    public int getWeek() {
        int i = this.calendar.get(7);
        return i == US_MINIMAL_DAYS_IN_FIRST_WEEK ? 6 : i - 2;
    }

    public SportDay getWeekStartDay() {
        Calendar instance = Calendar.getInstance();
        instance.set(this.year, this.mon, this.day);
        int i = instance.get(7) - sFirstDayOfWeek;
        if (i < 0) {
            i += 7;
        }
        instance.add(6, -i);
        return new SportDay(instance);
    }

    public boolean isToday() {
        return offsetDay(new SportDay()) == 0;
    }

    public boolean isYesterday() {
        return offsetDay(new SportDay()) == -1;
    }

    public int offsetDay(SportDay sportDay) {
        Calendar calendar = this.calendar;
        Calendar calendar2 = sportDay.calendar;
        if (this.year == sportDay.year) {
            return calendar.get(6) - calendar2.get(6);
        }
        calendar = (Calendar) calendar.clone();
        calendar2 = (Calendar) calendar2.clone();
        calendar.clear(11);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar2.clear(11);
        calendar2.clear(12);
        calendar2.clear(13);
        calendar2.clear(14);
        return (int) ((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / d.h);
    }

    public int offsetMonth(SportDay sportDay) {
        return this.year == sportDay.year ? this.mon - sportDay.mon : ((this.year - sportDay.year) * 12) + (this.mon - sportDay.mon);
    }

    public int offsetWeek(SportDay sportDay) {
        Calendar calendar = this.calendar;
        Calendar calendar2 = sportDay.calendar;
        return (this.year != sportDay.year || calendar.get(3) < calendar.get(ISO_MINIMAL_DAYS_IN_FIRST_WEEK) || calendar2.get(3) < calendar2.get(ISO_MINIMAL_DAYS_IN_FIRST_WEEK)) ? getWeekStartDay().offsetDay(sportDay.getWeekStartDay()) / 7 : calendar.get(3) - calendar2.get(3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.year).append("-");
        if (this.mon + US_MINIMAL_DAYS_IN_FIRST_WEEK < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.mon + US_MINIMAL_DAYS_IN_FIRST_WEEK).append("-");
        if (this.day < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.day);
        return stringBuilder.toString();
    }
}
