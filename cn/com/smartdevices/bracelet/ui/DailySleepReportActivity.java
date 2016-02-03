package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.huami.android.widget.share.l;
import com.huami.android.widget.share.q;
import com.huami.android.widget.share.s;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailySleepReportActivity extends SystemBarTintActivity implements s {
    private static final String s = "DailySleepReportActivity";
    private Context a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private TextView q;
    private TextView r;
    private q t;

    private void a() {
        if (findViewById(R.id.share_pane_container) != null) {
            this.t = new q();
            Bundle bundle = new Bundle();
            bundle.putBoolean(v.e, true);
            this.t.setArguments(bundle);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(R.id.share_pane_container, this.t);
            this.t.a((s) this);
            beginTransaction.commit();
        }
    }

    private void a(SleepInfo sleepInfo) {
        int sleepCount = sleepInfo.getSleepCount();
        int nonRemCount = sleepInfo.getNonRemCount();
        String[] e = f.e(sleepCount);
        CharSequence string = this.a.getString(R.string.unit_hour);
        CharSequence string2 = this.a.getString(R.string.unit_min_short);
        if (e[0].equals(Constants.VIA_RESULT_SUCCESS)) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.e.setText(e[1]);
            this.g.setText(string2);
        } else {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.d.setText(e[0]);
            this.f.setText(string);
            this.e.setText(e[1]);
            this.g.setText(string2);
        }
        e = f.e(nonRemCount);
        if (e[0].equals(Constants.VIA_RESULT_SUCCESS)) {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setText(e[1]);
            this.n.setText(string2);
        } else {
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setText(e[0]);
            this.m.setText(string);
            this.l.setText(e[1]);
            this.n.setText(string2);
        }
        CharSequence startDateStr = sleepInfo.getStartDateStr();
        CharSequence stopDateStr = sleepInfo.getStopDateStr();
        this.i.setText(startDateStr);
        this.j.setText(stopDateStr);
    }

    private void c() {
        this.b = (ImageView) findViewById(R.id.avatar_icon);
        this.c = (TextView) findViewById(R.id.user_name);
        this.h = (TextView) findViewById(R.id.ranking_tv);
        this.i = (TextView) findViewById(R.id.start_sleep_time_tv);
        this.j = (TextView) findViewById(R.id.sleep_rise_tv);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_sleep_total);
        this.d = (TextView) relativeLayout.findViewById(R.id.sleep_hour);
        this.e = (TextView) relativeLayout.findViewById(R.id.sleep_min);
        this.f = (TextView) relativeLayout.findViewById(R.id.sleep_hour_unit);
        this.g = (TextView) relativeLayout.findViewById(R.id.sleep_min_unit);
        relativeLayout = (RelativeLayout) findViewById(R.id.layout_sleep_deep);
        this.k = (TextView) relativeLayout.findViewById(R.id.sleep_hour);
        this.l = (TextView) relativeLayout.findViewById(R.id.sleep_min);
        this.m = (TextView) relativeLayout.findViewById(R.id.sleep_hour_unit);
        this.n = (TextView) relativeLayout.findViewById(R.id.sleep_min_unit);
        this.o = findViewById(R.id.share_logo);
        this.p = findViewById(R.id.contentLayout);
        this.q = (TextView) findViewById(R.id.share_title);
        this.r = (TextView) findViewById(R.id.share_from_mi_band_txt);
    }

    private void d() {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        Utils.a(readPersonInfo, this.b);
        this.c.setText(readPersonInfo.getNickname());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(getString(R.string.date_month_day));
        this.r.setText(getString(R.string.app_name) + " " + simpleDateFormat.format(new Date()));
        e();
    }

    private void e() {
        DaySportData g = C0591m.a().g(new SportDay());
        if (g == null) {
            C0596r.d(s, "sportDay is null");
            return;
        }
        C0596r.d(s, "sportDay = " + g);
        if (g != null) {
            SleepInfo sleepInfo = g.getSleepInfo();
            if (sleepInfo != null) {
                a(sleepInfo);
            }
        }
    }

    private l f() {
        l lVar = new l();
        lVar.a = getString(R.string.share_to_title);
        lVar.b = getString(R.string.share_to_topic);
        lVar.e = Utils.a(this.p, (Context) this);
        lVar.c = getString(R.string.share_to_content_step);
        return lVar;
    }

    public void b() {
        runOnUiThread(new S(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_sleep_report);
        this.a = this;
        c();
        a();
        d();
    }
}
