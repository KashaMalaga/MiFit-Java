package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.config.f;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.lab.ui.SportFactoryMainActivity;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.family.WeightFamilyMemberActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;

public class MyPageActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String a = "MyPageActiv";
    private static final int k = 20;
    private PersonInfo b;
    private TextView c;
    private b d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private Context h = this;
    private TextView i;
    private View j;

    private void a() {
        Utils.a(this.b, this.g);
        this.i.setText(this.b.getNickname());
        this.e.setText(this.b.getDaySportGoalSteps() + getString(r.step_per_day));
        C0596r.e(a, "mPersonInfo.targetWeight " + this.b.targetWeight + " after change " + aA.b(this.b.targetWeight, this.b.getWeightUnit()));
        if (b.h().l.a.booleanValue()) {
            if (this.b.targetWeight > 0.0f) {
                this.f.setText(aA.c(aA.b(this.b.targetWeight, this.b.getWeightUnit()), 1) + aA.a((Context) this, this.b.miliConfig.weightUnit));
            } else {
                this.f.setText(r.not_set);
            }
        }
        d();
    }

    private void a(Context context, Class<?> cls, String str) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
        C0401a.a((Context) this, C0401a.dg, str);
    }

    private void b() {
        findViewById(l.my_page_person_info).setOnClickListener(this);
        this.g = (ImageView) findViewById(l.my_page_avater);
        this.i = (TextView) findViewById(l.my_page_person_name);
        this.c = (TextView) findViewById(l.my_page_person_total_dist);
        View findViewById = findViewById(l.menu_lab_factory);
        bH.a(findViewById, l.menu_lab_factory_new_sign, "LAB");
        if (!this.d.e.ENABLE.booleanValue()) {
            findViewById.setVisibility(8);
            findViewById(l.split_line_lab).setVisibility(8);
        }
        this.e = (TextView) findViewById(l.device_set_goal_text);
        findViewById(l.device_set_goal).setOnClickListener(this);
        findViewById = findViewById(l.info_weight_goal);
        View findViewById2 = findViewById(l.info_weight_goal_split);
        View findViewById3 = findViewById(l.info_weight_goal_split);
        this.j = findViewById(l.menu_family);
        if (b.h().l.a.booleanValue()) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            this.f = (TextView) findViewById(l.info_weight_goal_value);
            findViewById(l.info_weight_goal).setOnClickListener(this);
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            this.j.setVisibility(8);
            findViewById3.setVisibility(8);
        }
        findViewById(l.info_unit_set).setOnClickListener(this);
        findViewById(l.my_page_about_area).setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    private void c() {
        C0591m.a().a(new cC(this));
    }

    private void d() {
        String[] a = ChartData.a((Context) this, this.b.getTotalDistance(), 1);
        if (this.b.getTotalDistance() > 0) {
            this.c.setText(getString(r.total_distance_format, new Object[]{a[0] + a[1]}));
            return;
        }
        this.c.setText("--");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (k != i) {
            return;
        }
        if (WeightGoalSetActivity.c == i2) {
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        } else if (WeightGoalSetActivity.d == i2) {
            float floatExtra = intent.getFloatExtra(WeightGoalSetActivity.b, 0.0f);
            this.b.targetWeight = aA.a(floatExtra, Keeper.readPersonInfo().miliConfig.weightUnit);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case l.device_set_goal /*2131297347*/:
                intent.setClass(this, HealthGoalsActivity.class);
                break;
            case l.my_page_person_info /*2131297372*/:
                intent.setClass(this, PersonInfoActivity.class);
                break;
            case l.menu_family /*2131297376*/:
                intent.setClass(this, WeightFamilyMemberActivity.class);
                C0401a.a(this.h, C0401a.ge);
                break;
            case l.info_weight_goal /*2131297381*/:
                intent.setClass(this.h, WeightGoalSetActivity.class);
                intent.putExtra(WeightGoalSetActivity.a, -1);
                startActivityForResult(intent, k);
                return;
            case l.info_unit_set /*2131297384*/:
                intent.setClass(this, PersonInfoSettingUnitActivity.class);
                break;
            case l.my_page_about_area /*2131297386*/:
                intent.setClass(this, SettingAboutActivity.class);
                break;
        }
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.my_page_activity);
        this.d = b.h();
        this.b = Keeper.readPersonInfo();
        b();
        c();
    }

    public void onItemLabClick(View view) {
        Keeper.keepFeatureVisited(f.e);
        b.h().o.getClass();
        String str = a.f;
        if (!f.e.equals(str)) {
            Keeper.keepFeatureVisited(str);
        }
        a(this, SportFactoryMainActivity.class, C0401a.do);
    }

    protected void onResume() {
        super.onResume();
        this.b = Keeper.readPersonInfo();
        a();
    }
}
