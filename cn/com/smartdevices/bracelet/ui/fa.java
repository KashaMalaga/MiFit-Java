package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.ShareData.TimeType;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.Date;

class fa extends eZ {
    private String A;
    private String B;
    final /* synthetic */ StatisticFragment v;
    private String[] w;
    private String x;
    private String y;
    private String z;

    public fa(StatisticFragment statisticFragment) {
        this.v = statisticFragment;
        super(statisticFragment);
        this.w = statisticFragment.getResources().getStringArray(f.weeks);
        this.x = statisticFragment.getString(r.date_today);
        this.y = statisticFragment.getString(r.date_yesterday);
        this.z = statisticFragment.getString(r.date_month_day);
        this.A = statisticFragment.getString(r.date_year_month_day);
        this.B = statisticFragment.getString(r.date_month_day_short);
    }

    protected L a(int i) {
        int i2 = 0;
        L l = new L();
        if (this.v.r == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            WeightInfo weightInfo = (WeightInfo) this.v.Y.get(-i);
            if (weightInfo == null) {
                weightInfo = this.v.A.a(this.v.E, -i);
                this.v.Y.put(-i, weightInfo);
            }
            if (weightInfo != null) {
                C0596r.e("Statistic.Main", "Load WeightInfo : " + weightInfo);
                l.e = weightInfo.weight;
                l.f = StatisticFragment.a(weightInfo.timestamp);
            }
        } else {
            Summary summary;
            SportDay addDay = this.v.v.addDay(i);
            C0596r.e("Statistic.Main", "Load Day : " + addDay);
            String key = addDay.getKey();
            if (this.v.X.containsKey(key)) {
                summary = (Summary) this.v.X.get(key);
            } else {
                Summary a = this.v.t.a(this.v.aF, addDay);
                this.v.X.put(key, a);
                summary = a;
            }
            if (summary != null) {
                int steps = summary.getSteps();
                int sleep = summary.getSleep();
                int sleepDeepTime = summary.getSleepDeepTime();
                if (steps < 0) {
                    steps = 0;
                }
                l.a = steps;
                l.c = sleep < 0 ? 0 : sleep;
                if (sleepDeepTime >= 0) {
                    i2 = sleepDeepTime;
                }
                l.d = i2;
            }
            l.f = b(addDay);
        }
        return l;
    }

    protected ShareData a(SportDay sportDay, int i) {
        ShareData shareData = new ShareData();
        if (i == 16) {
            a(this.v.s, shareData, sportDay);
            if (sportDay.equals(this.v.u)) {
                shareData.title = this.v.getString(r.share_sleep_title);
            } else {
                shareData.title = this.v.getString(r.share_sleep_title_daily);
            }
        } else if (i == 1) {
            Utils.a(this.v.getActivity(), this.a, this.b, this.g, this.c, this.v.w, shareData);
            shareData.time = Utils.d(this.v.w);
            if (shareData.mExtraData == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(cn.com.smartdevices.bracelet.j.f.ax, TimeType.DAY.ordinal());
                bundle.putInt(l.c, c.MILI.b());
                bundle.putInt(cn.com.smartdevices.bracelet.j.f.aw, this.a);
                bundle.putString(g.a, sportDay.toString());
                shareData.mExtraData = bundle;
            }
            shareData.ranking = a.f;
        }
        return shareData;
    }

    protected String a(SportDay sportDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (sportDay.equals(this.v.u)) {
            return this.x;
        }
        if (sportDay.offsetDay(this.v.u) == -1 && !this.v.aB) {
            return this.y;
        }
        if (sportDay.mon + 1 == 1 && sportDay.day == 1) {
            simpleDateFormat.applyPattern(this.A);
        } else {
            simpleDateFormat.applyPattern(this.z);
        }
        return simpleDateFormat.format(new Date(sportDay.getCalendar().getTimeInMillis()));
    }

    protected String b(SportDay sportDay) {
        boolean equals = sportDay.equals(this.v.u);
        int i = sportDay.offsetDay(this.v.u) == -1 ? 1 : 0;
        int i2 = this.v.aB ? 6 : 0;
        int i3 = sportDay.getWeek() == i2 ? 1 : 0;
        int i4 = (sportDay.mon + 1 == 1 && sportDay.day == 1) ? 1 : 0;
        if (equals) {
            return this.x;
        }
        if (i3 != 0 && i4 == 0) {
            return this.w[i2];
        }
        if (i != 0 && !this.v.aB && i4 == 0) {
            return this.y;
        }
        String format = String.format(this.B, new Object[]{Integer.valueOf(sportDay.mon + 1), Integer.valueOf(sportDay.day)});
        return i4 != 0 ? sportDay.year + "/" + format : format;
    }

    protected void b(View view) {
        TextView textView = (TextView) view.findViewById(com.xiaomi.hm.health.l.info_step);
        View findViewById = view.findViewById(com.xiaomi.hm.health.l.info_step_distance);
        View findViewById2 = view.findViewById(com.xiaomi.hm.health.l.info_step_calorie);
        View findViewById3 = view.findViewById(com.xiaomi.hm.health.l.info_step_walk_distance);
        View findViewById4 = view.findViewById(com.xiaomi.hm.health.l.info_step_walk_duration);
        View findViewById5 = view.findViewById(com.xiaomi.hm.health.l.info_step_walk_calorie);
        View findViewById6 = view.findViewById(com.xiaomi.hm.health.l.info_step_run_distance);
        View findViewById7 = view.findViewById(com.xiaomi.hm.health.l.info_step_run_duration);
        View findViewById8 = view.findViewById(com.xiaomi.hm.health.l.info_step_run_calorie);
        textView.setText(ChartData.a((long) this.a));
        String[] a = ChartData.a(this.v.getActivity(), this.b);
        ChartData.a(findViewById, a[0], a[1]);
        ChartData.a(findViewById2, ChartData.a((long) this.c), this.v.getString(r.unit_calorie));
        if ((this.v.aC & 2) > 0) {
            a = ChartData.a(this.v.getActivity(), this.d);
            ChartData.a(findViewById3, a[0], a[1]);
            ChartData.a(findViewById4, this.e, this.v.getActivity());
            ChartData.a(findViewById5, ChartData.a((long) this.f), this.v.getString(r.unit_calorie));
            a = ChartData.a(this.v.getActivity(), this.g);
            ChartData.a(findViewById6, a[0], a[1]);
            ChartData.a(findViewById7, this.h, this.v.getActivity());
            ChartData.a(findViewById8, ChartData.a((long) this.i), this.v.getString(r.unit_calorie));
        }
    }

    protected boolean b(int i) {
        if (this.v.r == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            if (i <= 0 && i > (-this.v.C)) {
                return true;
            }
            C0596r.g("Statistic.Main", "Has data False : " + i);
            return false;
        } else if (i <= 0 && i >= this.v.x.offsetDay(this.v.v)) {
            return true;
        } else {
            C0596r.g("Statistic.Main", "Has data False : " + i);
            return false;
        }
    }

    protected void c(int i) {
        a();
        if (this.v.r == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.v.K = i;
            this.v.F;
            this.v.F = (WeightInfo) this.v.Y.get(-i);
            if (this.v.F != null) {
                a(this.v.F);
                c((View) this.v.ao.get(1));
                return;
            }
            return;
        }
        SportDay addDay = this.v.v.addDay(i);
        C0596r.e("Statistic.Main", "To Day : " + addDay);
        this.v.w = addDay;
        this.v.a(addDay);
        c(addDay);
        a((View) this.v.am.get(1));
        b((View) this.v.an.get(1));
        if (this.v.aH) {
            C0401a.a(this.v.getActivity(), C0409b.by);
        }
    }
}
