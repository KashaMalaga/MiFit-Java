package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventWifiConnected;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import com.huami.android.widget.share.q;
import com.huami.android.widget.share.s;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import kankan.wheel.widget.i;

public class DailySportReportActivity extends SystemBarTintActivity implements s {
    private static final String a = "DailySportReportActivity";
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private UserTotalSportData h;
    private PersonInfo i;
    private TextView j;
    private TextView k;
    private View l;
    private View m;
    private TextView n;
    private TextView o;
    private Context p;
    private q q;

    private void a() {
        Utils.a(this.i, this.b);
        this.c.setText(this.i.getNickname());
        DaySportData g = C0591m.a().g(new SportDay());
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null) {
                int stepsCount = stepsInfo.getStepsCount();
                this.d.setText(a.f + stepsCount);
                Utils.a(this.p, Utils.a(stepsCount, SportDay.getToday()), new U(this));
                this.f.setText(stepsInfo.getCalories() + a.f);
            }
        }
        e();
    }

    private void c() {
        this.m = findViewById(l.share_logo);
        this.l = findViewById(l.daily_sport_content_area);
        this.b = (ImageView) findViewById(l.daily_sport_avatar_icon);
        this.c = (TextView) findViewById(l.daily_sport_user_name);
        this.d = (TextView) findViewById(l.daily_steps_txt);
        this.e = (TextView) findViewById(l.daily_steps_rank_txt);
        this.e.setVisibility(4);
        this.f = (TextView) findViewById(l.daily_consume_calories_txt);
        this.g = (TextView) findViewById(l.daily_reach_goals_txt);
        this.k = (TextView) findViewById(l.daily_total_distance_title_txt);
        this.j = (TextView) findViewById(l.daily_total_distance_txt);
        this.n = (TextView) findViewById(l.share_from_mi_band_txt);
        this.o = (TextView) findViewById(l.share_title);
    }

    private void d() {
        C0591m.a().a(new V(this));
    }

    private void e() {
        C0596r.e(a, "udpateTotalInfo: " + this.h);
        if (this.h != null) {
            this.i.totalSportData = this.h;
            Keeper.keepPersonInfo(this.i);
        }
        UserTotalSportData totalSportData = this.i.getTotalSportData();
        if (totalSportData.isValid()) {
            ReportData reportData = totalSportData.getReportData();
            if (reportData != null) {
                this.g.setText(reportData.getContinueDays() + a.f);
            }
            ReportData weekReportData = totalSportData.getWeekReportData();
            Utils.b(weekReportData.getDistance());
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            float distance = (float) weekReportData.getDistance();
            float f = 0.0f;
            if (this.i.getUnit() == 1) {
                this.k.setText(r.week_total_distance_miles);
                f = ((float) Math.round(Utils.a(distance))) / Constant.aM;
                C0596r.e(a, "distanceBritish: " + f + ", distance = " + distance);
            } else if (this.i.getUnit() == 0) {
                this.k.setText(r.week_total_distance);
                f = distance / 1000.0f;
            }
            this.j.setText(decimalFormat.format((double) f) + a.f);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(getString(r.date_month_day));
        this.n.setText(getString(i.app_name) + " " + simpleDateFormat.format(new Date()));
    }

    private void f() {
        if (findViewById(l.share_pane_container) != null) {
            this.q = new q();
            Bundle bundle = new Bundle();
            bundle.putBoolean(v.e, true);
            this.q.setArguments(bundle);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(l.share_pane_container, this.q);
            this.q.a((s) this);
            beginTransaction.commit();
        }
    }

    private com.huami.android.widget.share.l g() {
        com.huami.android.widget.share.l lVar = new com.huami.android.widget.share.l();
        lVar.a = getString(r.share_to_title);
        lVar.b = getString(r.share_to_topic);
        lVar.e = Utils.a(this.l, (Context) this);
        lVar.c = getString(r.share_to_content_step);
        return lVar;
    }

    public void b() {
        runOnUiThread(new W(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.daily_sport_report);
        this.p = this;
        this.i = Keeper.readPersonInfo();
        c();
        f();
        a();
        new Handler().postDelayed(new T(this), 500);
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventWifiConnected eventWifiConnected) {
        C0596r.e(a, "wifi connected");
        a();
    }
}
