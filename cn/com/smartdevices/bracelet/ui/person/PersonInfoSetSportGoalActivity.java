package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

public class PersonInfoSetSportGoalActivity extends PersonInfoBaseActivity implements OnClickListener {
    public static final int c = 1000;
    private static final String d = "PersonInfoSetSportGoalActivity";
    private WheelView e;
    private TextView f;

    private void a(boolean z) {
        if (z) {
            setResult(-1);
            finish();
            C0401a.a(this.b, C0409b.R, C0410c.l, this.a.getDaySportGoalSteps() + a.f);
            Intent intent = new Intent();
            intent.setClass(this, MainUIActivity.class);
            intent.putExtra(Constant.aL, true);
            startActivity(intent);
            return;
        }
        b.a((Context) this, "\u540c\u6b65\u5230\u670d\u52a1\u5668\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\uff01", 0).show();
    }

    private void d() {
        this.a.setDaySportGoals((this.e.f() * c) + kankan.wheel.widget.a.bZ);
        C0596r.e(d, "goalStep = " + this.a.getDaySportGoalSteps());
    }

    public void a(PersonInfo personInfo) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(getApplicationContext());
        personInfo.uid = f.uid;
        l.a(f, personInfo, new f(this, personInfo));
    }

    public void b() {
        d();
        C0596r.e(d, "onCancel");
        super.b();
    }

    public void c() {
        d();
        C0596r.e(d, "onNext");
        super.c();
        this.a.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a);
        a(this.a);
        a(true);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_person_info_set_sport_goal);
        a();
        this.e = (WheelView) findViewById(com.xiaomi.hm.health.l.person_info_goal_picker);
        this.e.a(5).e(h.wheel_custom_val_dark_0).a(getString(r.step), g.content_color, 12, BitmapDescriptorFactory.HUE_YELLOW, kankan.wheel.widget.a.bj).a(new C0763dl(this, 2, 30, this.e, getResources().getColor(g.title_color), getResources().getColor(g.content_color), getResources().getColor(g.content_color_darker), false, 50, 48, 45, 45, c));
        this.f = (TextView) findViewById(com.xiaomi.hm.health.l.bracelet_title_info);
        if (this.a.age < 17) {
            this.f.setText(r.person_info_goal_info_young);
            if (this.a.getDaySportGoalSteps() < 0) {
                this.a.setDaySportGoals(kankan.wheel.widget.a.bT);
            }
        } else {
            this.f.setText(r.person_info_goal_info);
            if (this.a.getDaySportGoalSteps() < 0) {
                this.a.setDaySportGoals(kankan.wheel.widget.a.bS);
            }
        }
        int daySportGoalSteps = (this.a.getDaySportGoalSteps() - 2000) / c;
        C0596r.e(d, "curitem:" + daySportGoalSteps);
        this.e.c(daySportGoalSteps);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.E);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.E);
        C0401a.a((Activity) this);
    }
}
