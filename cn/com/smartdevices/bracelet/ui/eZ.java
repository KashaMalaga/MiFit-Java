package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.r;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.shoes.model.i;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.Calendar;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

abstract class eZ {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected float p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    final /* synthetic */ StatisticFragment u;

    private eZ(StatisticFragment statisticFragment) {
        this.u = statisticFragment;
    }

    protected int a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(12) + (instance.get(11) * 60);
    }

    protected abstract L a(int i);

    protected L a(int i, int i2, int i3, int i4, float f, int i5, int i6, int i7) {
        L l = new L();
        if (i5 > 0) {
            l.a = i / i5;
        }
        if (i6 > 0) {
            l.c = i3 / i6;
            l.d = i4 / i6;
        }
        if (i7 > 0) {
            l.e = f / ((float) i7);
        }
        return l;
    }

    protected abstract ShareData a(SportDay sportDay, int i);

    protected abstract String a(SportDay sportDay);

    protected void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u.az = null;
        this.u.aA = 0;
    }

    protected void a(int i, ShareData shareData, SportDay sportDay) {
        shareData.setType(2);
        int i2 = R.string.share_sleep_description;
        switch (i) {
            case l.a /*1*/:
                shareData.setType(2);
                break;
            case a.bp /*16*/:
                shareData.setType(3);
                i2 = R.string.share_sleep_description_average;
                break;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                shareData.setType(4);
                i2 = R.string.share_sleep_description_average;
                break;
        }
        if (this.r == 0) {
            this.r = 1;
        }
        shareData.content = (this.j / this.s) + com.xiaomi.e.a.f;
        shareData.time = Utils.d(this.u.w);
        int i3 = this.k / this.s;
        int i4 = this.l / this.s;
        String a = f.a(this.m / this.s);
        String a2 = f.a(this.n / this.s);
        shareData.description = this.u.getString(i2, new Object[]{Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60), Integer.valueOf(i4 / 60), Integer.valueOf(i4 % 60), a, a2});
    }

    protected void a(View view) {
        View findViewById = view.findViewById(R.id.info_sleep);
        View findViewById2 = view.findViewById(R.id.info_sleep_deep);
        View findViewById3 = view.findViewById(R.id.info_sleep_shallow);
        TextView textView = (TextView) view.findViewById(R.id.info_sleep_time);
        TextView textView2 = (TextView) view.findViewById(R.id.info_sleep_rise_time);
        View findViewById4 = view.findViewById(R.id.info_sleep_wake);
        if (this.s == 0) {
            this.s = 1;
        }
        ChartData.a(findViewById, this.j / this.s, this.u.getActivity());
        ChartData.a(findViewById2, this.k / this.s, this.u.getActivity());
        ChartData.a(findViewById3, this.l / this.s, this.u.getActivity());
        int i = this.m / this.s;
        if (i < 0) {
            i += DaySportData.DAY_SPORT_LEN;
        }
        textView.setText(f.a(i));
        int i2 = this.n / this.s;
        if (i2 < 0) {
            i2 += DaySportData.DAY_SPORT_LEN;
        }
        textView2.setText(f.a(i2));
        ChartData.a(findViewById4, this.o / this.s, this.u.getActivity());
    }

    protected void a(WeightInfo weightInfo) {
        this.p += weightInfo.weight;
    }

    protected void a(Summary summary) {
        this.j += summary.getSleep();
        this.k += summary.getSleepDeepTime();
        this.l += summary.getSleepShallowTime();
        int a = Utils.a(summary);
        this.m += a;
        this.n = (a + Utils.b(summary)) + this.n;
        this.o += summary.getSleepWakeTime();
    }

    protected void a(SportDay sportDay, Summary summary, i iVar) {
        int c;
        int d;
        int i = 0;
        if (this.u.c() && sportDay.equals(this.u.u)) {
            r a = ChartData.a();
            c = a.c();
            d = a.d();
            i = a.f();
        } else {
            d = 0;
            c = 0;
        }
        if (c <= 0) {
            c = summary.getSteps();
            d = summary.getStepDistance();
            i = summary.getStepCalories();
        }
        this.a = c + this.a;
        this.b = d + this.b;
        this.c = i + this.c;
        this.d += summary.getStepWalkDistance();
        this.e += summary.getStepWalkDuration();
        this.f += summary.getStepWalkCalories();
        this.g += summary.getStepRunDistance();
        this.h += summary.getStepRunDuration();
        this.i += summary.getStepRunCalories();
    }

    protected abstract String b(SportDay sportDay);

    protected void b() {
        View view = (View) this.u.ao.get(this.u.s);
        View findViewById = view.findViewById(R.id.info_weight);
        TextView textView = (TextView) view.findViewById(R.id.info_weight_body_type);
        TextView textView2 = (TextView) view.findViewById(R.id.info_weight_bmi);
        ChartData.a(findViewById, "--", com.xiaomi.e.a.f);
        textView.setText("--");
        textView2.setText("--");
    }

    protected void b(View view) {
        TextView textView = (TextView) view.findViewById(R.id.info_step);
        View findViewById = view.findViewById(R.id.info_step_distance);
        View findViewById2 = view.findViewById(R.id.info_step_calorie);
        TextView textView2 = (TextView) view.findViewById(R.id.info_step_average);
        View findViewById3 = view.findViewById(R.id.info_step_distance_average);
        View findViewById4 = view.findViewById(R.id.info_step_calorie_average);
        View findViewById5 = view.findViewById(R.id.info_step_walk_distance_average);
        View findViewById6 = view.findViewById(R.id.info_step_walk_duration_average);
        View findViewById7 = view.findViewById(R.id.info_step_walk_calories_average);
        View findViewById8 = view.findViewById(R.id.info_step_run_distance_average);
        View findViewById9 = view.findViewById(R.id.info_step_run_duration_average);
        View findViewById10 = view.findViewById(R.id.info_step_run_calories_average);
        textView.setText(ChartData.a((long) this.a));
        String[] a = ChartData.a(this.u.getActivity(), this.b);
        ChartData.a(findViewById, a[0], a[1]);
        ChartData.a(findViewById2, ChartData.a((long) this.c), this.u.getString(R.string.unit_calorie));
        if (this.r == 0) {
            this.r = 1;
        }
        textView2.setText(ChartData.a((long) (this.a / this.r)));
        a = ChartData.a(this.u.getActivity(), this.b / this.r);
        ChartData.a(findViewById3, a[0], a[1]);
        ChartData.a(findViewById4, ChartData.a((long) (this.c / this.r)), this.u.getString(R.string.unit_calorie));
        if ((this.u.aC & 2) > 0) {
            a = ChartData.a(this.u.getActivity(), this.d / this.r);
            ChartData.a(findViewById5, a[0], a[1]);
            ChartData.a(findViewById6, this.e / this.r, this.u.getActivity());
            ChartData.a(findViewById7, ChartData.a((long) (this.f / this.r)), this.u.getString(R.string.unit_calorie));
            a = ChartData.a(this.u.getActivity(), this.g / this.r);
            ChartData.a(findViewById8, a[0], a[1]);
            ChartData.a(findViewById9, this.h / this.r, this.u.getActivity());
            ChartData.a(findViewById10, ChartData.a((long) (this.i / this.r)), this.u.getString(R.string.unit_calorie));
        }
    }

    protected abstract boolean b(int i);

    protected abstract void c(int i);

    protected void c(View view) {
        int age;
        float a;
        int i;
        CharSequence a2;
        View findViewById = view.findViewById(R.id.info_weight);
        TextView textView = (TextView) view.findViewById(R.id.info_weight_body_type);
        TextView textView2 = (TextView) view.findViewById(R.id.info_weight_bmi);
        if (this.t == 0) {
            this.t = 1;
        }
        float f = this.p / ((float) this.t);
        if (this.u.E == -1) {
            PersonInfo readPersonInfoBase = Keeper.readPersonInfoBase();
            age = Birthday.fromStr(readPersonInfoBase.birthday).getAge();
            a = aA.a(readPersonInfoBase.height, age, f);
            i = readPersonInfoBase.gender;
        } else {
            UserInfo a3 = this.u.B.a(this.u.E);
            age = Birthday.fromStr(a3.birthday).getAge();
            a = aA.a(a3.height, age, f);
            i = a3.gender;
        }
        CharSequence b = aA.b(a);
        String str = "--";
        if (f > 0.0f) {
            a2 = aA.a(this.u.getActivity(), a, age, i);
        } else {
            Object obj = str;
        }
        age = Keeper.readPersonInfo().miliConfig.weightUnit;
        ChartData.a(findViewById, String.valueOf(aA.c(aA.b(f, age))), aA.a(this.u.getActivity(), age));
        textView.setText(a2);
        textView2.setText(b);
    }

    protected void c(SportDay sportDay) {
        Summary summary = (Summary) this.u.X.get(sportDay.getKey());
        if (summary != null && !summary.isEmpty()) {
            if (summary.getSteps() > 0) {
                a(sportDay, summary, null);
                this.r++;
            }
            if (summary.getSleep() > 0) {
                a(summary);
                this.s++;
            }
            if (this.u.az == null) {
                this.u.az = sportDay;
                this.u.aA = summary.getSteps();
            } else if (this.u.aA < summary.getSteps()) {
                this.u.aA = summary.getSteps();
                this.u.az = sportDay;
                C0596r.e("Statistic.Main", "find a bigger steps: " + this.u.aA);
            }
        }
    }
}
