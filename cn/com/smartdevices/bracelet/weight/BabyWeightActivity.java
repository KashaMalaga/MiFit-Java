package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.C0811k;
import cn.com.smartdevices.bracelet.ui.C0812l;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weight.family.WeightChooseUserActivity;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.util.List;

public class BabyWeightActivity extends SystemBarTintActivity {
    private static final float C = 1.0f;
    private static final int D = 1638;
    private static final int E = 1911;
    private static final int F = 1365;
    public static boolean a = false;
    public static boolean b = false;
    private static final String n = "BabyWeightActivity";
    private static final int w = 291;
    private static final int x = 564;
    private e A;
    private e B;
    int c = -1;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private RelativeLayout k;
    private RelativeLayout l;
    private boolean m = false;
    private Context o;
    private boolean p = false;
    private float q;
    private float r;
    private boolean s = false;
    private int t;
    private float u = 0.0f;
    private boolean v = false;
    private Handler y = new C0870h(this);
    private float z = 0.0f;

    private void a() {
        this.d = (TextView) findViewById(l.home_back);
        this.d.setOnClickListener(new C0858a(this));
        this.e = (TextView) findViewById(l.baby_weight_title);
        this.f = (TextView) findViewById(l.baby_weight_content);
        this.g = (TextView) findViewById(l.baby_weight_value);
        this.h = (TextView) findViewById(l.baby_weight_value_unit);
        this.k = (RelativeLayout) findViewById(l.baby_weight_img_layout);
        this.i = (ImageView) findViewById(l.baby_weight_img_body);
        this.j = (ImageView) findViewById(l.baby_weight_img_scale);
        this.l = (RelativeLayout) findViewById(l.baby_weight_no_scale_view);
        b();
    }

    private void a(e eVar) {
        C0401a.a(this.o, C0401a.hu);
        DialogFragment c0811k = new C0811k();
        Bundle bundle = new Bundle();
        bundle.putString(C0812l.b, getString(r.baby_weight_too_small_weight));
        bundle.putString(C0812l.d, getString(r.give_up));
        bundle.putString(C0812l.c, getString(r.confirm));
        c0811k.setArguments(bundle);
        c0811k.setOpClickListener(new C0869g(this, eVar));
        c.showPanel((Activity) this, c0811k);
    }

    private void b() {
        if (!this.v) {
            this.v = true;
            C0596r.e(n, "isAdultWeighting " + a + " isAdultWithBabyWeighting " + b);
            if (this.m) {
                C0401a.a(this.o, C0401a.hp);
                this.v = false;
                this.e.setText(getString(r.dynamic_title_weight_not_nearby));
                this.f.setText(getString(r.baby_weight_scale_not_nearby_content));
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            if (a) {
                C0401a.a(this.o, C0401a.hr);
                this.v = false;
                this.i.setBackgroundResource(k.baby_weight_adult);
                this.e.setText(getString(r.baby_weight_adult_weight_title));
                this.f.setText(getString(r.baby_weight_adult_weight_content));
            } else if (b) {
                C0401a.a(this.o, C0401a.hq);
                this.u = this.i.getX();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.u, 0.0f - this.u});
                ofFloat.addUpdateListener(new C0864b(this));
                ofFloat.addListener(new C0865c(this));
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.setDuration(700);
                ofFloat.start();
                this.e.setText(getString(r.baby_weight_baby_weight_title));
                this.f.setText(getString(r.baby_weight_baby_weight_content));
            }
            this.v = false;
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.h.setText(aA.a(this.o, this.t));
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    private void b(e eVar) {
        C0596r.e(n, "matchAndSaveAdultData weightadvdata " + eVar.n());
        new P().a = eVar;
        this.z = eVar.j();
        if (eVar.f() && eVar.d()) {
            this.z = 0.0f;
        }
        this.y.sendEmptyMessage(w);
        if (eVar.f() && !eVar.d()) {
            a = false;
            b = true;
            C0596r.e(n, "adult weight " + eVar.j());
            this.A = eVar;
            this.q = eVar.j();
            this.z = 0.0f;
            this.y.sendEmptyMessage(x);
        }
    }

    private void c() {
        DialogFragment c0812l = new C0812l();
        Bundle bundle = new Bundle();
        bundle.putString(C0812l.a, getString(r.baby_weight_warning_title));
        bundle.putString(C0812l.b, getString(r.baby_weight_warning_content));
        bundle.putString(C0812l.d, getString(r.gotit));
        bundle.putString(C0812l.c, a.f);
        c0812l.setArguments(bundle);
        c0812l.a(new C0867e(this));
        c0812l.setOpClickListener(new C0868f(this));
        c.showPanel((Activity) this, c0812l);
        this.p = true;
    }

    private void c(e eVar) {
        C0596r.e(n, "matchAndSaveBabyData weightadvdata " + eVar.toString());
        new P().a = eVar;
        this.z = eVar.j();
        if (eVar.f() && eVar.d()) {
            this.z = 0.0f;
        }
        this.y.sendEmptyMessage(w);
        if (eVar.f() && !eVar.d()) {
            if (eVar.j() != this.q) {
                this.s = true;
                this.B = eVar;
                C0596r.e(n, "adult with baby weight " + eVar.j());
                this.r = eVar.j();
                float abs = Math.abs(aA.c(this.r - this.q));
                e eVar2 = this.A.j() > this.B.j() ? this.A : this.B;
                C0596r.e(n, "baby weight " + abs);
                eVar2.b(abs);
                d(eVar2);
                if (aA.a(abs, this.t) < C) {
                    a(eVar2);
                } else {
                    e(eVar2);
                }
                a = false;
                b = false;
                return;
            }
            C0596r.e(n, "value of withbaby is the same as adult");
            this.z = 0.0f;
            this.y.sendEmptyMessage(w);
        }
    }

    private void d(e eVar) {
        C0596r.e(n, "go to weight report page " + eVar.toString());
        List a = aA.a(eVar);
        UserInfo userInfo = new UserInfo();
        userInfo.uid = 0;
        userInfo.name = getString(r.visitor);
        if (a != null && a.size() == 1) {
            userInfo = (UserInfo) a.get(0);
        }
        if (ah.a().b(eVar.e()) == null) {
            WeightInfo weightInfo = new WeightInfo(aA.a(eVar.j(), eVar.h()), userInfo.uid, eVar.e());
            weightInfo.deviceid = eVar.a();
            weightInfo.synced = -1;
            weightInfo.type = 2;
            ah.a().a(weightInfo);
            C0596r.e(n, "before wData timestamp " + eVar.e());
            eVar.a(this.B.e() + 1);
            weightInfo = new WeightInfo(aA.a(eVar.j(), eVar.h()), userInfo.uid, eVar.e());
            weightInfo.deviceid = eVar.a();
            weightInfo.synced = 0;
            weightInfo.type = 2;
            ah.a().a(weightInfo);
            C0891z.a(this.o).b(userInfo, eVar);
            EventBus.getDefault().post(new EventWeightChanged(true, userInfo.uid));
            return;
        }
        C0596r.d(n, "the data exist in database!!!");
    }

    private void e(e eVar) {
        int i = 0;
        C0596r.e(n, "go to weight report page " + eVar.toString());
        List a = aA.a(eVar);
        C0596r.e(n, "after wData.getTimestamp " + eVar.e());
        if (a.size() == 1) {
            C0596r.e("MATCHED_USERS", "match 1 user");
            Intent intent = new Intent(this.o, WeightReportActivity.class);
            intent.putExtra(UserInfo.USERINFO_KEY, J.a().a(((UserInfo) a.get(0)).uid) == null ? a.f : J.a().a(((UserInfo) a.get(0)).uid).toJsonString());
            intent.putExtra(e.d, eVar.n());
            startActivityForResult(intent, D);
            setResult(-1);
            finish();
            return;
        }
        boolean z;
        for (UserInfo userInfo : J.a().e()) {
            if (Birthday.fromStr(userInfo.birthday).getAge() <= 3) {
                z = true;
                break;
            }
        }
        z = false;
        if (a.size() != 0 || r0) {
            int[] iArr = new int[a.size()];
            while (i < a.size()) {
                iArr[i] = ((UserInfo) a.get(i)).uid;
                i++;
            }
            Intent intent2 = new Intent(this.o, WeightChooseUserActivity.class);
            intent2.putExtra("FROM_BABY_WEIGHT", true);
            intent2.putExtra(e.d, eVar.n());
            intent2.putExtra("USER_LIST", iArr);
            startActivityForResult(intent2, E);
            return;
        }
        f(eVar);
    }

    private void f(e eVar) {
        DialogFragment c0811k = new C0811k();
        Bundle bundle = new Bundle();
        bundle.putString(C0812l.b, getString(r.generate_baby_weight_content, new Object[]{eVar.j() + aA.a(this.o, eVar.h())}));
        bundle.putString(C0812l.d, getString(r.give_up));
        bundle.putString(C0812l.c, getString(r.confirm));
        c0811k.setArguments(bundle);
        c0811k.setOpClickListener(new C0871i(this, eVar));
        c.showPanel((Activity) this, c0811k);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C0596r.e("ACT_RESULT", "receive activity result " + i + " " + i2);
        super.onActivityResult(i, i2, intent);
        if (i == D) {
            if (i2 == -1 || i2 == 0) {
                finish();
            }
        } else if (i == E) {
            if (i2 == -1) {
                finish();
            }
        } else if (i == F && i2 == -1) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_baby_weight);
        this.o = this;
        this.t = Keeper.readPersonInfo().getWeightUnit();
        EventBus.getDefault().register(this);
        if (getIntent() != null) {
            this.m = getIntent().getBooleanExtra("CONNECTION_FAIL", false);
        }
        C0596r.e(n, "need reminder " + Keeper.getNeedBabyWeightRemind());
        if (Keeper.getNeedBabyWeightRemind()) {
            c();
        }
        this.s = false;
        a = true;
        b = false;
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventScaleStatus eventScaleStatus) {
        C0596r.e(n, "event scale status " + eventScaleStatus.status);
        if (eventScaleStatus.status == -1 || this.c != eventScaleStatus.status) {
            if (eventScaleStatus.status == EventScaleStatus.SCALE_FOUNDED) {
                this.m = false;
            } else {
                this.m = true;
            }
            b();
            this.c = eventScaleStatus.status;
        }
    }

    public void onEventBackgroundThread(e eVar) {
        if (!this.p && !this.s) {
            this.t = eVar.h();
            if (a) {
                if (eVar != null) {
                    b(eVar);
                }
            } else if (b && eVar != null) {
                c(eVar);
            }
        }
    }

    protected void onPause() {
        super.onPause();
        a = false;
        b = false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
        a = false;
        b = false;
        finish();
    }
}
