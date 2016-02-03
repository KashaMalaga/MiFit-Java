package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.u;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;

public class HealthGoalsActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String a = "HealthGoalsActivity";
    private static final int b = 1000;
    private PersonInfo c;
    private WheelView d;
    private TextView e;
    private RelativeLayout f;
    private Button g;

    private void a() {
        this.f = (RelativeLayout) findViewById(R.id.other_tips_layout);
        this.d = (WheelView) findViewById(R.id.person_info_goal_picker);
        this.d.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.step), R.color.main_ui_content_color, 12, BitmapDescriptorFactory.HUE_YELLOW, a.bj).a(new C0763dl(this, 2, 30, this.d, getResources().getColor(R.color.main_ui_title_color), getResources().getColor(R.color.main_ui_content_color_light), getResources().getColor(R.color.main_ui_content_color_light_2), false, 50, 48, 45, 45, b));
        this.e = (TextView) findViewById(R.id.bracelet_title_info);
        if (this.c.age < 17) {
            this.e.setText(R.string.person_info_goal_info_young);
            if (this.c.getDaySportGoalSteps() < 0) {
                this.c.setDaySportGoals(a.bT);
            }
        } else {
            this.e.setText(R.string.person_info_goal_info);
            if (this.c.getDaySportGoalSteps() < 0) {
                this.c.setDaySportGoals(a.bS);
            }
        }
        int daySportGoalSteps = (this.c.getDaySportGoalSteps() - 2000) / b;
        C0596r.e(a, "curitem:" + daySportGoalSteps);
        this.d.c(daySportGoalSteps);
        findViewById(R.id.cancel).setOnClickListener(this);
        this.g = (Button) findViewById(R.id.confirm);
        this.g.setOnClickListener(this);
        this.f.setVisibility(4);
        this.g.setVisibility(0);
        C0596r.e(a, "hasbindbracelet " + DeviceSource.hasBindBracelet());
        C0596r.e(a, "isMiliConnected " + com.xiaomi.hm.health.bt.bleservice.a.c());
        if (DeviceSource.hasBindBracelet() && !com.xiaomi.hm.health.bt.bleservice.a.c()) {
            this.f.setVisibility(0);
            this.g.setVisibility(4);
        }
    }

    private void b() {
        int f = (this.d.f() * b) + a.bZ;
        if (this.c.getDaySportGoalSteps() == f) {
            setResult(-1);
            finish();
            return;
        }
        this.c.setDaySportGoals(f);
        C0596r.e(a, "goalStep = " + this.c.getDaySportGoalSteps());
        if (DeviceSource.hasBindBracelet()) {
            new u(this.c.getDaySportGoalSteps(), new aZ(this)).f();
        }
        Keeper.keepPersonInfo(this.c);
        a(this.c);
        C0596r.e(a, "sync goal to mili ok.");
        EventBus.getDefault().post(new EventGoalsUpdated());
        Intent intent = new Intent();
        intent.putExtra(a.ct, f);
        setResult(-1, intent);
        finish();
    }

    public void a(PersonInfo personInfo) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(getApplicationContext());
        personInfo.uid = f.uid;
        l.a(f, personInfo, new C0699ba(this, personInfo));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm:
                b();
                return;
            case R.id.cancel:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.health_goal_activity);
        this.c = Keeper.readPersonInfo();
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        C0401a.a((Context) this, C0401a.dL, this.c.getDaySportGoalSteps());
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        if (hwConnStatus.k()) {
            this.f.setVisibility(4);
            this.g.setVisibility(0);
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(4);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    protected void onPause() {
        super.onResume();
        C0401a.b(C0401a.Q);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.Q);
        C0401a.a((Activity) this);
    }
}
