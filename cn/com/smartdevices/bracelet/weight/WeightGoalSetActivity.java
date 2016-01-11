package cn.com.smartdevices.bracelet.weight;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventWeightTargetUpdated;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weight.goal.WeightGoal;
import cn.com.smartdevices.bracelet.weight.goal.a;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.event.EventBus;

public class WeightGoalSetActivity extends SystemBarTintActivity implements OnClickListener, ag {
    public static final String a = "UID";
    public static final String b = "GOAL_WEIGHT";
    public static final int c = 272;
    public static final int d = 544;
    private static final String f = "WeightGoalSetActivity";
    float e = 0.0f;
    private Context g = this;
    private TextView h;
    private WeightGoalSetView i;
    private View j = null;
    private View k = null;
    private TextView l;
    private int m;
    private int n = 0;
    private int o;
    private UserInfo p;
    private int[] q = new int[3];
    private boolean r = false;
    private int s;

    private void a() {
        this.h = (TextView) findViewById(l.person_info_set_weight_info);
        this.i = (WeightGoalSetView) findViewById(l.weight_goal_seekbar);
        int age = Birthday.fromStr(this.p.birthday).getAge();
        this.i.b(0);
        int i = this.n;
        if (this.p.height < 100) {
            if (age < 7) {
                this.h.setText(getString(r.baby_weight_tips));
            } else {
                this.h.setText(getString(r.weight_goal_height_100));
            }
            this.i.a(aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit), aA.b(75.0f, Keeper.readPersonInfo().miliConfig.weightUnit));
            age = ((int) (aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit) + aA.b(75.0f, Keeper.readPersonInfo().miliConfig.weightUnit))) / 2;
        } else if (age >= 7 && age <= 18) {
            float a = aA.a(age, this.p.gender);
            float b = aA.b(age, this.p.gender);
            a = aA.a(a, ((float) this.p.height) / CropOverlayView.a, Keeper.readPersonInfo().miliConfig.weightUnit);
            b = aA.a(b, ((float) this.p.height) / CropOverlayView.a, Keeper.readPersonInfo().miliConfig.weightUnit);
            this.h.setText(getString(r.weight_less_than_tips, new Object[]{((int) (0.5f + a)) + aA.a(this.g, Keeper.readPersonInfo().miliConfig.weightUnit)}));
            this.i.a(aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit), a, b, aA.b((float) BitmapDescriptorFactory.HUE_GREEN, Keeper.readPersonInfo().miliConfig.weightUnit));
            age = ((int) (aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit) + a)) / 2;
        } else if (age < 7) {
            this.h.setText(getString(r.baby_weight_tips));
            this.i.a(aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit), aA.b(75.0f, Keeper.readPersonInfo().miliConfig.weightUnit));
            age = ((int) (aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit) + aA.b(75.0f, Keeper.readPersonInfo().miliConfig.weightUnit))) / 2;
        } else {
            this.h.setText(getString(r.set_goal_weight_tips, new Object[]{Integer.valueOf((int) (((float) this.m) + 0.5f)), Integer.valueOf((int) (((float) this.n) + 0.5f)), aA.a(this.g, Keeper.readPersonInfo().miliConfig.weightUnit)}));
            this.i.a(aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit), (float) this.m, (float) this.n, (float) this.o, aA.b((float) BitmapDescriptorFactory.HUE_GREEN, Keeper.readPersonInfo().miliConfig.weightUnit));
            age = (this.m + this.n) / 2;
        }
        if (this.p.targetWeight > 0.0f) {
            this.i.a(aA.c(aA.b(this.p.targetWeight, Keeper.readPersonInfo().miliConfig.weightUnit), 1));
        } else if (ah.a().b(this.p.uid) == 0) {
            this.i.a((float) age);
        } else {
            this.i.a(aA.c(aA.b(ah.a().a(this.p.uid, 0).weight, Keeper.readPersonInfo().miliConfig.weightUnit), 1));
        }
        this.i.a((ag) this);
        this.k = findViewById(l.right_button);
        this.k.setOnClickListener(this);
        this.j = findViewById(l.left_button);
        this.j.setOnClickListener(this);
        if (this.r) {
            ((TextView) this.j).setText(getString(r.cancel));
            ((TextView) this.k).setText(getString(r.set));
        } else {
            ((TextView) this.j).setText(getString(r.clear_weight_goal));
            ((TextView) this.k).setText(getString(r.reset_weight_goal));
        }
        this.l = (TextView) findViewById(l.home_back);
        this.l.setOnClickListener(this);
    }

    private void b(float f) {
        if (this.s == -1) {
            C0596r.e(f, "set goal succ");
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            readPersonInfo.targetWeight = aA.a(f, Keeper.readPersonInfo().miliConfig.weightUnit);
            a.a().a(new WeightGoal(this.g, -1, readPersonInfo.weight, readPersonInfo.targetWeight, readPersonInfo.height));
            C0596r.e(f, "onActivityResult " + readPersonInfo);
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
            return;
        }
        this.p.targetWeight = aA.a(f, Keeper.readPersonInfo().miliConfig.weightUnit);
        WeightGoal weightGoal = new WeightGoal(this.g, this.p.uid, this.p.weight, this.p.targetWeight, this.p.height);
        C0596r.e(f, "after save  the user is not the first time to set goal " + a.a().a(this.p.uid));
        a.a().a(weightGoal);
        J.a().d(this.p);
    }

    public void a(float f) {
        this.e = aA.c(f, 1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.home_back /*2131296313*/:
                finish();
                return;
            case l.left_button /*2131296944*/:
                if (this.r) {
                    finish();
                    return;
                }
                C0401a.a(this.g, C0401a.gj);
                String string = getString(r.no_need_weight_goal);
                DialogFragment afVar = new af();
                afVar.setOpClickListener(new C0863ae(this));
                Bundle bundle = new Bundle();
                bundle.putString("Msg", string);
                c.showPanel((Activity) this, afVar, bundle);
                return;
            case l.right_button /*2131296946*/:
                b(this.e);
                setResult(c, new Intent());
                finish();
                C0596r.e(f, "set value goal " + this.e);
                EventBus.getDefault().post(new EventWeightTargetUpdated(this.s));
                if (this.r) {
                    C0401a.a(this.g, C0401a.gh);
                    return;
                } else {
                    C0401a.a(this.g, C0401a.gi);
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            C0596r.e(f, "getIntent is not null");
            this.s = getIntent().getIntExtra(a, -1);
            this.p = J.a().a(this.s);
            C0596r.e(f, "mUserInfo is " + this.p);
            int i = 0;
            for (String str : aA.d(((float) this.p.height) / CropOverlayView.a, Birthday.fromStr(this.p.birthday).getAge(), Keeper.readPersonInfo().miliConfig.weightUnit).split(f.i)) {
                C0596r.e(f, "scale is " + str);
                this.q[i] = (int) Float.parseFloat(str);
                i++;
            }
            this.m = this.q[0];
            this.n = this.q[1];
            this.o = this.q[2];
        }
        if (this.p.targetWeight > 0.0f) {
            this.r = false;
        } else {
            this.r = true;
        }
        setContentView((int) n.activity_person_info_set_weightgoal);
        a();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aV);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aV);
        C0401a.a((Activity) this);
    }
}
