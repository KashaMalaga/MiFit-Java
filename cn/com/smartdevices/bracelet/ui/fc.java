package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.g.h;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.Date;

class fc extends eZ {
    private String A;
    private String B;
    private String C;
    final /* synthetic */ StatisticFragment v;
    private String w;
    private String x;
    private String y;
    private String z;

    public fc(StatisticFragment statisticFragment) {
        this.v = statisticFragment;
        super(statisticFragment);
        this.w = statisticFragment.getString(r.date_this_week);
        this.x = statisticFragment.getString(r.date_last_week);
        this.y = statisticFragment.getString(r.date_from_to);
        this.z = statisticFragment.getString(r.date_from_to_short);
        this.A = statisticFragment.getString(r.date_month_day);
        this.B = statisticFragment.getString(r.date_year_month_day);
        this.C = statisticFragment.getString(r.date_month_day_short);
    }

    protected L a(int i) {
        SportDay addWeek = this.v.v.addWeek(i);
        C0596r.e("Statistic.Main", "Load Week : " + a(addWeek));
        SportDay weekStartDay = addWeek.getWeekStartDay();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < 7) {
            Summary summary;
            int i10;
            SportDay addDay = weekStartDay.addDay(i9);
            C0596r.e("Statistic.Main", "Load Day : " + addDay);
            String key = addDay.getKey();
            if (this.v.X.containsKey(key)) {
                summary = (Summary) this.v.X.get(key);
            } else {
                summary = this.v.t.a(this.v.aF, addDay);
                this.v.X.put(key, summary);
            }
            if (summary != null) {
                if (summary.getSteps() > 0) {
                    i2 += summary.getSteps();
                    i6++;
                }
                if (summary.getSleep() > 0) {
                    i3 += summary.getSleep();
                    i4 += summary.getSleepDeepTime();
                    i7++;
                }
            }
            if (this.v.r == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                WeightInfo b = this.v.A.b(this.v.E, addDay.getCalendar());
                if (b != null) {
                    i10 = (int) (b.weight + ((float) i5));
                    i8++;
                    i9++;
                    i5 = i10;
                }
            }
            i10 = i5;
            i9++;
            i5 = i10;
        }
        L a = a(i2, 0, i3, i4, (float) i5, i6, i7, i8);
        a.f = b(addWeek);
        return a;
    }

    protected ShareData a(SportDay sportDay, int i) {
        String string;
        ShareData shareData = new ShareData();
        if (i == 16) {
            a(this.v.s, shareData, sportDay);
            string = this.v.getString(r.week);
            if (sportDay.offsetWeek(this.v.u) == 0) {
                string = this.w;
            }
            shareData.title = string + this.v.getString(r.share_sleep_title_average);
        } else if (i == 1) {
            shareData.setType(7);
            string = this.v.getString(r.one_week);
            if (sportDay.offsetWeek(this.v.u) == 0) {
                string = this.w;
            }
            shareData.title = string + this.v.getString(r.share_step_walk);
            shareData.content = a.f + this.a;
            shareData.description = Utils.a(this.v.getActivity(), this.b, this.c, this.v.getResources().getStringArray(f.weeks)[this.v.az.getWeek()], this.v.aA, this.g);
            shareData.contentUnit = this.v.getString(r.unit_step);
            Bundle bundle = new Bundle();
            bundle.putInt(cn.com.smartdevices.bracelet.j.f.ax, TimeType.WEEK.ordinal());
            bundle.putInt(l.c, c.MILI.b());
            bundle.putInt(cn.com.smartdevices.bracelet.j.f.aw, this.a);
            shareData.mExtraData = bundle;
            shareData.ranking = new h().a(this.v.getActivity(), this.a);
        }
        SportDay weekStartDay = sportDay.getWeekStartDay();
        SportDay addDay = weekStartDay.addDay(6);
        if (sportDay.offsetWeek(this.v.u) == 0) {
            addDay = this.v.u;
        }
        if (weekStartDay.before(this.v.x)) {
            weekStartDay = this.v.x;
        } else if (addDay.after(this.v.y)) {
            addDay = this.v.y;
        }
        String format = String.format(this.C, new Object[]{Integer.valueOf(weekStartDay.mon + 1), Integer.valueOf(weekStartDay.day)});
        string = String.format(this.C, new Object[]{Integer.valueOf(addDay.mon + 1), Integer.valueOf(addDay.day)});
        shareData.time = String.format(this.z, new Object[]{format, string});
        return shareData;
    }

    protected String a(SportDay sportDay) {
        if (sportDay.offsetWeek(this.v.u) == 0) {
            return this.w;
        }
        if (sportDay.offsetWeek(this.v.u) == -1) {
            return this.x;
        }
        SportDay weekStartDay = sportDay.getWeekStartDay();
        SportDay addDay = weekStartDay.addDay(6);
        if (weekStartDay.before(this.v.x)) {
            weekStartDay = this.v.x;
        } else if (addDay.after(this.v.y)) {
            addDay = this.v.y;
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.A);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(this.B);
        date.setTime(weekStartDay.getCalendar().getTimeInMillis());
        String format = (weekStartDay.mon + 1 == 1 && weekStartDay.calendar.get(3) == 1) ? simpleDateFormat2.format(date) : simpleDateFormat.format(date);
        date.setTime(addDay.getCalendar().getTimeInMillis());
        String format2 = (addDay.mon + 1 == 1 && addDay.calendar.get(3) == 1) ? simpleDateFormat2.format(date) : simpleDateFormat.format(date);
        return String.format(this.y, new Object[]{format, format2});
    }

    protected String b(SportDay sportDay) {
        if (sportDay.offsetWeek(this.v.u) == 0) {
            return this.w;
        }
        if (sportDay.offsetWeek(this.v.u) == -1) {
            return this.x;
        }
        SportDay weekStartDay = sportDay.getWeekStartDay();
        SportDay addDay = weekStartDay.addDay(6);
        if (weekStartDay.before(this.v.x)) {
            weekStartDay = this.v.x;
        } else if (addDay.after(this.v.y)) {
            addDay = this.v.y;
        }
        String format = String.format(this.C, new Object[]{Integer.valueOf(weekStartDay.mon + 1), Integer.valueOf(weekStartDay.day)});
        String format2 = String.format(this.C, new Object[]{Integer.valueOf(addDay.mon + 1), Integer.valueOf(addDay.day)});
        return String.format(this.z, new Object[]{format, format2});
    }

    protected boolean b(int i) {
        if (i <= 0 && i >= this.v.x.offsetWeek(this.v.v)) {
            return true;
        }
        C0596r.g("Statistic.Main", "Has data False : " + i);
        return false;
    }

    protected void c(int i) {
        SportDay addWeek = this.v.v.addWeek(i);
        SportDay weekStartDay = addWeek.getWeekStartDay();
        C0596r.e("Statistic.Main", "To Week : " + a(addWeek));
        this.v.I = i;
        if (this.v.J == Integer.MAX_VALUE) {
            this.v.J = i;
        }
        if (this.v.J == i) {
            this.v.w = this.v.z;
        } else {
            this.v.w = weekStartDay;
            if (this.v.w.before(this.v.x)) {
                this.v.w = this.v.x;
            }
        }
        this.v.a(addWeek);
        a();
        for (int i2 = 0; i2 < 7; i2++) {
            SportDay addDay = weekStartDay.addDay(i2);
            C0596r.e("Statistic.Main", "Load Day : " + addDay);
            c(addDay);
        }
        a((View) this.v.am.get(16));
        b((View) this.v.an.get(16));
    }
}
