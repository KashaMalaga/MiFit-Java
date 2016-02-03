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
import com.xiaomi.hm.health.R;
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
        this.e.setText(this.b.getDaySportGoalSteps() + getString(R.string.step_per_day));
        C0596r.e(a, "mPersonInfo.targetWeight " + this.b.targetWeight + " after change " + aA.b(this.b.targetWeight, this.b.getWeightUnit()));
        if (b.h().l.a.booleanValue()) {
            if (this.b.targetWeight > 0.0f) {
                this.f.setText(aA.c(aA.b(this.b.targetWeight, this.b.getWeightUnit()), 1) + aA.a((Context) this, this.b.miliConfig.weightUnit));
            } else {
                this.f.setText(R.string.not_set);
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
        findViewById(R.id.my_page_person_info).setOnClickListener(this);
        this.g = (ImageView) findViewById(R.id.my_page_avater);
        this.i = (TextView) findViewById(R.id.my_page_person_name);
        this.c = (TextView) findViewById(R.id.my_page_person_total_dist);
        View findViewById = findViewById(R.id.menu_lab_factory);
        bH.a(findViewById, R.id.menu_lab_factory_new_sign, "LAB");
        if (!this.d.e.ENABLE.booleanValue()) {
            findViewById.setVisibility(8);
            findViewById(R.id.split_line_lab).setVisibility(8);
        }
        this.e = (TextView) findViewById(R.id.device_set_goal_text);
        findViewById(R.id.device_set_goal).setOnClickListener(this);
        findViewById = findViewById(R.id.info_weight_goal);
        View findViewById2 = findViewById(R.id.info_weight_goal_split);
        View findViewById3 = findViewById(R.id.info_weight_goal_split);
        this.j = findViewById(R.id.menu_family);
        if (b.h().l.a.booleanValue()) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            this.f = (TextView) findViewById(R.id.info_weight_goal_value);
            findViewById(R.id.info_weight_goal).setOnClickListener(this);
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            this.j.setVisibility(8);
            findViewById3.setVisibility(8);
        }
        findViewById(R.id.info_unit_set).setOnClickListener(this);
        findViewById(R.id.my_page_about_area).setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    private void c() {
        C0591m.a().a(new cC(this));
    }

    private void d() {
        String[] a = ChartData.a((Context) this, this.b.getTotalDistance(), 1);
        if (this.b.getTotalDistance() > 0) {
            this.c.setText(getString(R.string.total_distance_format, new Object[]{a[0] + a[1]}));
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
            case R.id.device_set_goal:
                intent.setClass(this, HealthGoalsActivity.class);
                break;
            case R.id.my_page_person_info:
                intent.setClass(this, PersonInfoActivity.class);
                break;
            case R.id.menu_family:
                intent.setClass(this, WeightFamilyMemberActivity.class);
                C0401a.a(this.h, C0401a.ge);
                break;
            case R.id.info_weight_goal:
                intent.setClass(this.h, WeightGoalSetActivity.class);
                intent.putExtra(WeightGoalSetActivity.a, -1);
                startActivityForResult(intent, k);
                return;
            case R.id.info_unit_set:
                intent.setClass(this, PersonInfoSettingUnitActivity.class);
                break;
            case R.id.my_page_about_area:
                intent.setClass(this, SettingAboutActivity.class);
                break;
        }
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.my_page_activity);
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
