package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.g.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;

class fb extends eZ {
    private String A;
    private String B;
    final /* synthetic */ StatisticFragment v;
    private final String w;
    private final String x;
    private String y;
    private String z;

    public fb(StatisticFragment statisticFragment) {
        this.v = statisticFragment;
        super(statisticFragment);
        this.y = statisticFragment.getString(R.string.date_this_month);
        this.z = statisticFragment.getString(R.string.date_last_month);
        this.A = statisticFragment.getString(R.string.date_month);
        this.B = statisticFragment.getString(R.string.date_year_month);
        this.w = statisticFragment.getString(R.string.date_month_day_short);
        this.x = statisticFragment.getString(R.string.date_from_to_short);
    }

    protected L a(int i) {
        SportDay addMonth = this.v.v.addMonth(i);
        C0596r.e("Statistic.Main", "Load Month : " + a(addMonth));
        SportDay monthStartDay = addMonth.getMonthStartDay();
        SportDay monthEndDay = addMonth.getMonthEndDay();
        C0596r.e("Statistic.Main", monthStartDay + "~" + monthEndDay);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < monthEndDay.day; i8++) {
            Summary summary;
            SportDay addDay = monthStartDay.addDay(i8);
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
                    i5++;
                }
                if (summary.getSleep() > 0) {
                    i3 += summary.getSleep();
                    i4 += summary.getSleepDeepTime();
                    i6++;
                }
            }
            if (this.v.r == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                WeightInfo b = this.v.A.b(this.v.E, addDay.getCalendar());
                if (b != null) {
                    f += b.weight;
                    i7++;
                }
            }
        }
        L a = a(i2, 0, i3, i4, f, i5, i6, i7);
        a.f = b(addMonth);
        return a;
    }

    protected ShareData a(SportDay sportDay, int i) {
        String str;
        String a;
        ShareData shareData = new ShareData();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (sportDay.offsetMonth(this.v.u) == 0) {
            str = this.y;
        } else {
            simpleDateFormat.applyPattern(this.A);
            str = this.v.getString(R.string.in) + simpleDateFormat.format(new Date(sportDay.getCalendar().getTimeInMillis()));
        }
        if (i == 16) {
            a(this.v.s, shareData, sportDay);
            shareData.title = str + ", " + this.v.getString(R.string.share_sleep_title_average);
        } else if (i == 1) {
            shareData.setType(6);
            a = Utils.a(this.v.getActivity(), this.a, this.b, this.c, Utils.d(this.v.az), this.v.aA, this.g);
            shareData.title = str + this.v.getString(R.string.share_step_walk);
            shareData.content = a.f + this.a;
            shareData.description = a;
            shareData.contentUnit = this.v.getString(R.string.unit_step);
            Bundle bundle = new Bundle();
            bundle.putInt(f.ax, TimeType.MONTH.ordinal());
            bundle.putInt(l.c, c.MILI.b());
            bundle.putInt(f.aw, this.a);
            shareData.mExtraData = bundle;
            shareData.ranking = new e().a(this.v.getActivity(), this.a);
        }
        SportDay monthStartDay = sportDay.getMonthStartDay();
        SportDay addDay = monthStartDay.addMonth(1).addDay(-1);
        if (sportDay.offsetMonth(this.v.u) == 0) {
            addDay = this.v.u;
        }
        if (monthStartDay.before(this.v.x)) {
            monthStartDay = this.v.x;
        } else if (addDay.after(this.v.y)) {
            addDay = this.v.y;
        }
        String format = String.format(this.w, new Object[]{Integer.valueOf(monthStartDay.mon + 1), Integer.valueOf(monthStartDay.day)});
        a = String.format(this.w, new Object[]{Integer.valueOf(addDay.mon + 1), Integer.valueOf(addDay.day)});
        shareData.time = String.format(this.x, new Object[]{format, a});
        return shareData;
    }

    protected String a(SportDay sportDay) {
        if (sportDay.offsetMonth(this.v.u) == 0) {
            return this.y;
        }
        if (sportDay.offsetMonth(this.v.u) == -1) {
            return this.z;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (sportDay.mon + 1 == 1) {
            simpleDateFormat.applyPattern(this.B);
            return simpleDateFormat.format(new Date(sportDay.getCalendar().getTimeInMillis()));
        }
        simpleDateFormat.applyPattern(this.A);
        return simpleDateFormat.format(new Date(sportDay.getCalendar().getTimeInMillis()));
    }

    protected String b(SportDay sportDay) {
        return a(sportDay);
    }

    protected boolean b(int i) {
        if (i <= 0 && i >= this.v.x.offsetMonth(this.v.v)) {
            return true;
        }
        C0596r.g("Statistic.Main", "Has data False : " + i);
        return false;
    }

    protected void c(int i) {
        SportDay addMonth = this.v.v.addMonth(i);
        SportDay monthStartDay = addMonth.getMonthStartDay();
        SportDay monthEndDay = addMonth.getMonthEndDay();
        C0596r.e("Statistic.Main", monthStartDay + "~" + monthEndDay);
        C0596r.e("Statistic.Main", "To Month : " + a(addMonth));
        this.v.I = i;
        if (this.v.J == Integer.MAX_VALUE) {
            this.v.J = i;
        }
        if (this.v.J == i) {
            this.v.w = this.v.z;
        } else {
            this.v.w = monthStartDay;
            if (this.v.w.before(this.v.x)) {
                this.v.w = this.v.x;
            }
        }
        this.v.a(addMonth);
        a();
        for (int i2 = 0; i2 < monthEndDay.day; i2++) {
            SportDay addDay = monthStartDay.addDay(i2);
            C0596r.e("Statistic.Main", "Load Day : " + addDay);
            c(addDay);
        }
        a((View) this.v.am.get(PersonInfo.INCOMING_CALL_DISABLE_BIT));
        b((View) this.v.an.get(PersonInfo.INCOMING_CALL_DISABLE_BIT));
    }
}
