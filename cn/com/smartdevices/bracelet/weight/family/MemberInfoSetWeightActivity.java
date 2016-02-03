package cn.com.smartdevices.bracelet.weight.family;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.weight.G;
import cn.com.smartdevices.bracelet.weight.I;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import de.greenrobot.event.EventBus;

@SuppressLint({"NewApi"})
public class MemberInfoSetWeightActivity extends MemberInfoBaseActivity implements OnClickListener, I {
    public static boolean h = false;
    private static final String i = "MemberInfoSetWeightActivity";
    private LinePieChartView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private TextView n;
    private View o = null;
    private Context p = this;
    private boolean q = false;
    private boolean r = false;
    private Handler s = new e(this);
    private float t = 0.0f;
    private boolean u = false;
    private long v = 0;

    private void a(e eVar) {
        C0596r.e("isManualSetWeight", this.q + a.f);
        C0596r.e(i, "weightadvdata " + eVar.toString());
        P p = new P();
        p.a = eVar;
        this.t = eVar.j();
        if (eVar.f() && eVar.d()) {
            this.t = 0.0f;
        }
        this.s.sendEmptyMessage(123);
        if (eVar.f() && !eVar.d()) {
            h = false;
            C0401a.a(this.p, C0401a.gk, C0401a.gm);
            UserInfo userInfo = new UserInfo();
            userInfo.name = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_NAME);
            String currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_GENDER);
            if (currentUserInfoByTag.isEmpty()) {
                userInfo.gender = 1;
            } else {
                userInfo.gender = Integer.parseInt(currentUserInfoByTag);
            }
            userInfo.birthday = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_BIRTH);
            currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_HEIGHT);
            if (currentUserInfoByTag.isEmpty()) {
                userInfo.height = 100;
            } else {
                userInfo.height = Integer.parseInt(currentUserInfoByTag);
            }
            userInfo.weight = aA.c(this.t, p.a.h(), 0);
            eVar.a(aA.a(userInfo.height, Birthday.fromStr(userInfo.birthday).getAge(), userInfo.weight));
            new f(this, userInfo, eVar).execute(new Void[0]);
        }
    }

    private void e() {
        this.k = (TextView) findViewById(R.id.search_devices_title);
        this.l = (TextView) findViewById(R.id.search_devices_info);
        this.k.setText(R.string.find_weight_scale_info);
        this.l.setText(a.f);
        this.m = (ImageView) findViewById(R.id.search_devices_mili_icon);
        this.m.setImageResource(R.drawable.mi_logo);
        this.j = (LinePieChartView) findViewById(R.id.searching_pie_chart);
        LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
        layoutParams.width = (int) getResources().getDimension(R.dimen.draw_weight_icon_w);
        layoutParams.height = (int) getResources().getDimension(R.dimen.draw_weight_icon_w);
        this.j.a(4);
        this.j.d_();
        findViewById(R.id.search_single_frame).setBackgroundColor(getResources().getColor(R.color.bg_mode_weight));
        this.n = (TextView) findViewById(R.id.search_devices_weight_value);
        this.o = findViewById(R.id.right_button);
        this.o.setOnClickListener(this);
        if (!DeviceSource.hasBindWeight()) {
            this.o.performClick();
        }
    }

    public void a() {
        C0596r.e(i, "onWeightSelectCancel");
        this.q = false;
    }

    public void a(float f) {
        C0596r.e(i, "onWeightSelect " + f);
        e eVar = new e();
        eVar.b(aA.b(f, Keeper.readPersonInfo().miliConfig.weightUnit));
        eVar.a(Keeper.readPersonInfo().miliConfig.weightUnit);
        eVar.a(true);
        eVar.b(false);
        if (0 == this.v) {
            this.v = System.currentTimeMillis();
        }
        eVar.a(this.v);
        eVar.c(f);
        String currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_BIRTH);
        String currentUserInfoByTag2 = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_HEIGHT);
        int i = 100;
        if (!currentUserInfoByTag2.isEmpty()) {
            i = Integer.parseInt(currentUserInfoByTag2);
        }
        eVar.a(aA.a(i, Birthday.fromStr(currentUserInfoByTag).getAge(), f));
        a(eVar);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_devices_exit:
                setResult(-1);
                finish();
                return;
            case R.id.left_button:
                C0596r.e(i, "click left btn");
                return;
            case R.id.right_button:
                C0401a.a(this.p, C0401a.gk, C0401a.gl);
                c.showPanel((Activity) this.p, G.a(this.r ? 8.0f : BitmapDescriptorFactory.HUE_YELLOW).getClass());
                this.q = true;
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.member_set_weight_layout);
        this.r = getIntent().getBooleanExtra("FROM_BABY_WEIGHT", false);
        e();
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventBackgroundThread(e eVar) {
        C0596r.e(i, "onEvent WeightAdvData:" + eVar);
        if (h && !this.q && eVar != null) {
            a(eVar);
        }
    }

    protected void onPause() {
        super.onPause();
        h = false;
    }

    protected void onResume() {
        super.onResume();
        h = true;
        this.v = 0;
    }
}
