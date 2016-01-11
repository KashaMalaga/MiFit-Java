package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0563k;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0890y;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdateUnit;
import cn.com.smartdevices.bracelet.lab.sync.i;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.view.O;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.c.a.C0993k;
import com.huami.android.view.c;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.hm.health.bt.a.w;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.p;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Executors;
import kankan.wheel.widget.a;

public class cL extends p implements OnClickListener {
    private static final String Q = "TAG_FOR_SLIDINGPANEL";
    public static final int b = 17;
    public static final int c = 18;
    public static final String d = "person_info_json";
    private static final long e = 1000;
    private static final String g = "PersonInfoFragment";
    private static final int h = 19;
    private static final int i = 20;
    private ImageButton A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private Bitmap F;
    private View G;
    private TextView H;
    private Birthday I;
    private View J;
    private TextView K;
    private SlidingUpPanelLayout L;
    private View M;
    private TextView N;
    private LinearLayout O;
    private LinearLayout P;
    private int R;
    private final PanelSlideListener S = new cS(this);
    private Handler f;
    private TextView j;
    private TextView k;
    private View l;
    private TextView m;
    private View n;
    private TextView o;
    private View p;
    private TextView q;
    private View r;
    private View s;
    private final b t = b.h();
    private PersonInfo u = null;
    private View v;
    private ImageButton w;
    private TextView x;
    private TextView y;
    private TextView z;

    private float a(float f) {
        return (f < 0.0f || ((double) f) >= 0.3d) ? (((double) f) < 0.3d || f >= 1.0f) ? 0.0f : 0.0f : 1.0f - (3.3333333f * f);
    }

    private void a(View view) {
        this.R = getResources().getDimensionPixelSize(j.person_page_scroll_parallax);
        this.j = (TextView) view.findViewById(l.info_gender_value);
        this.l = view.findViewById(l.info_gender);
        this.l.setOnClickListener(this);
        this.m = (TextView) view.findViewById(l.info_height_value);
        this.n = view.findViewById(l.info_height);
        this.n.setOnClickListener(this);
        this.o = (TextView) view.findViewById(l.info_weight_value);
        this.p = view.findViewById(l.info_weight);
        this.p.setOnClickListener(this);
        this.q = (TextView) view.findViewById(l.info_age_value);
        this.r = view.findViewById(l.info_age_area);
        this.r.setOnClickListener(this);
        this.s = view.findViewById(l.info_unit_set);
        this.s.setOnClickListener(this);
        this.k = (TextView) view.findViewById(l.info_unit_value);
        this.K = (TextView) view.findViewById(l.device_set_goal_text);
        this.J = view.findViewById(l.device_set_goal);
        this.J.setOnClickListener(this);
        this.M = view.findViewById(l.info_weight_goal);
        this.M.setOnClickListener(this);
        if (!b.h().l.a.booleanValue()) {
            this.M.setVisibility(8);
        }
        this.N = (TextView) view.findViewById(l.info_weight_goal_value);
        view.findViewById(l.mili_exit_login).setOnClickListener(this);
        this.v = view.findViewById(l.person_info_user_info_area);
        this.G = view.findViewById(l.person_info_edit_area);
        if (Keeper.readPersonInfo().uid == this.u.uid) {
            this.G.setVisibility(0);
        } else {
            this.G.setVisibility(8);
        }
        this.L = (SlidingUpPanelLayout) view.findViewById(l.fragment_setting_sliding_layout);
        this.L.setEnableDragViewTouchEvents(true);
        this.L.setPanelSlideListener(this.S);
        h();
        i();
    }

    private void a(PersonInfo personInfo) {
        int i;
        int i2 = 0;
        if (personInfo.height < 40 || personInfo.height > a.an) {
            personInfo.height = a.aC;
            i = 0;
        } else {
            i = 1;
        }
        if (personInfo.weight < 3.0f || personInfo.weight > ((float) (aA.c(getActivity()) + 1))) {
            personInfo.weight = BitmapDescriptorFactory.HUE_YELLOW;
            i = 0;
        }
        if (personInfo.gender < 0) {
            personInfo.gender = 1;
        } else {
            i2 = i;
        }
        if (i2 == 0) {
            Keeper.keepPersonInfo(personInfo);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I = Birthday.fromStr(str);
        }
        if (this.I == null || !this.I.isValid()) {
            int age = this.u.getAge();
            if (age > 0) {
                int i = Calendar.getInstance().get(1);
                this.u.setVersion(1);
                String str2 = (i - age) + WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                C0596r.e(g, "update age " + age + "to birth:" + str2);
                this.u.setBirthday(str2);
                Keeper.keepPersonInfo(this.u);
                onEvent(new EventPersonInfoUpdate());
                this.I = Birthday.fromStr(str2);
            }
            C0596r.e(g, "updated birthday  = " + this.I);
            return;
        }
        C0596r.e(g, "cur birthday  = " + this.I);
        this.u.setAge(this.I.getAge());
        Keeper.keepPersonInfo(this.u);
    }

    public static Fragment c() {
        Fragment cLVar = new cL();
        Bundle bundle = new Bundle();
        Object readPersonInfo = Keeper.readPersonInfo();
        if (readPersonInfo != null) {
            bundle.putString(d, new C0993k().b(readPersonInfo));
        }
        cLVar.setArguments(bundle);
        return cLVar;
    }

    private void e() {
        C0596r.b(g, "exit login now!");
        if (getActivity() == null) {
            C0596r.d(g, "exit login now! but the context is null!");
            return;
        }
        Utils.a(getActivity(), (int) r.mili_exit_login_info_exiting, false);
        cn.com.smartdevices.bracelet.j.l.d(cn.com.smartdevices.bracelet.e.a.f(getActivity()), cn.com.smartdevices.bracelet.e.a.d(getActivity()), new cM(this));
        f();
    }

    private void f() {
        cn.com.smartdevices.bracelet.j.l.g(cn.com.smartdevices.bracelet.e.a.f(getActivity()), new cN(this));
    }

    private void g() {
        C0591m.a().a(new cP(this));
    }

    private void h() {
        fg a = new fe(getActivity()).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = getResources().getDimensionPixelSize(j.person_fragment_panel);
            C0596r.e(g, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.L.setPanelHeight(dimensionPixelSize - e);
        }
    }

    private void i() {
        this.w = (ImageButton) this.v.findViewById(l.person_page_icon);
        this.w.setOnClickListener(this);
        this.x = (TextView) this.v.findViewById(l.person_page_nickname);
        this.x.setOnClickListener(this);
        this.y = (TextView) this.v.findViewById(l.person_page_signiture);
        this.z = (TextView) this.v.findViewById(l.person_page_location);
        this.z.setOnClickListener(this);
        this.A = (ImageButton) this.v.findViewById(l.edit_member_name);
        this.A.setOnClickListener(this);
        this.D = (TextView) this.v.findViewById(l.person_page_uid);
        this.B = (TextView) this.v.findViewById(l.person_page_odo);
        this.C = (TextView) this.v.findViewById(l.person_page_odo_title);
        this.E = (TextView) this.v.findViewById(l.person_page_ave_steps);
        this.H = (TextView) this.v.findViewById(l.person_page_weared_days);
        this.O = (LinearLayout) this.v.findViewById(l.person_page_header_center_area);
        this.P = (LinearLayout) this.v.findViewById(l.person_info_static_layout_id);
        if (DeviceSource.hasBindBracelet() || !b.h().l.a.booleanValue()) {
            this.P.setVisibility(0);
        } else {
            this.P.setVisibility(8);
        }
    }

    private void j() {
        DialogFragment cAVar = new cA();
        Bundle bundle = new Bundle();
        if (DeviceSource.hasBindBracelet()) {
            bundle.putInt(Constant.aR, 0);
        } else {
            bundle.putInt(Constant.aR, 2);
        }
        cAVar.setArguments(bundle);
        cAVar.setOpClickListener(new cQ(this));
        c.showPanel(getActivity(), cAVar);
    }

    private void k() {
        if (B.a().f()) {
            B.a().a(Keeper.readBraceletBtInfo().b);
        }
        SwitchOperator readSwitchOperator = Keeper.readSwitchOperator();
        boolean readShowedUserAgreement = Keeper.readShowedUserAgreement();
        Editor edit = Keeper.getSharedPref().edit();
        edit.clear();
        edit.commit();
        Keeper.keepSwitchOperator(readSwitchOperator);
        Keeper.keepShowedUserAgreement(readShowedUserAgreement);
        C0563k.a().b().deleteAll();
        C0563k.a().c().deleteAll();
        C0591m.a().b();
        cn.com.smartdevices.bracelet.gps.a.a(getActivity());
        cn.com.smartdevices.bracelet.shoes.a.b(getActivity());
        cn.com.smartdevices.bracelet.weight.goal.a.a().b();
        J.a().b();
        ah.a().b();
        Keeper.keepScaleSyncedUserInfosFromServer(false);
        Keeper.keepScaleSyncedWeightInfosFromServer(false);
        Keeper.setHeartRateDataFromServer(false);
        Keeper.keepWeightCurrentUserAsync(-1);
        if (this.t.c.d.booleanValue()) {
            QQLogin.getInstance(getActivity().getApplicationContext()).clean(false);
            QQHealth.getInstance(getActivity().getApplicationContext()).clean(false);
        }
    }

    private void l() {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), LoginActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    private void m() {
        if (getActivity() != null) {
            new cU().executeOnExecutor(Executors.newScheduledThreadPool(1), new Void[0]);
        }
    }

    private void n() {
        if (DeviceSource.hasBindBracelet()) {
            new w(Utils.a(this.u), new cR(this)).f();
        } else {
            C0596r.e(g, "Has not bind band!");
        }
    }

    private void o() {
        Utils.a(this.u, this.w);
    }

    private void p() {
        this.K.setText(this.u.getDaySportGoalSteps() + getString(r.step_per_day));
    }

    private void q() {
        o();
        r();
    }

    private void r() {
        if (getActivity() != null) {
            this.x.setText(this.u.nickname);
            this.y.setText(this.u.personSignature);
            this.D.setText(String.valueOf(this.u.uid));
            if (this.u.totalSportData != null && this.u.totalSportData.isValid()) {
                C0596r.e(g, "update sport data = " + this.u.totalSportData);
                this.B.setText(ChartData.a(getActivity(), this.u.getTotalDistance(), 1)[0]);
                this.E.setText(com.xiaomi.e.a.f + this.u.totalSportData.iAverageSteps);
                this.H.setText(this.u.totalSportData.iTotalwearingdays + com.xiaomi.e.a.f);
            }
            if (this.u.uid == Keeper.readPersonInfo().uid || this.u.totalSportData.iTotalwearingdays > 0) {
                this.P.setVisibility(0);
            } else {
                this.P.setVisibility(8);
            }
        }
    }

    private void s() {
        C0596r.e(g, "update UI: " + this.u.totalSportData + ", " + this.u);
        C0596r.e(g, "updateUI mpersoninfo weight " + this.u.weight);
        a(this.u);
        if (getActivity() == null) {
            C0596r.a(g, "getActivity is null");
            return;
        }
        this.j.setText(this.u.gender == 1 ? getString(r.male) : getString(r.female));
        t();
        WeightInfo a = ah.a().a(-1, 0);
        C0596r.e("PERSON_WEIGHT", "person info .weight " + this.u.weight);
        float b = aA.b(this.u.weight, this.u.miliConfig.weightUnit);
        if (a != null) {
            b = aA.b(a.weight, this.u.miliConfig.weightUnit);
        }
        this.o.setText(aA.c(b, 1) + aA.a(getActivity().getApplicationContext(), this.u.miliConfig.weightUnit));
        this.I = Birthday.fromStr(this.u.getBirthday());
        if (this.I != null) {
            this.q.setText(this.I.toString());
        }
        if (this.u.targetWeight > 0.0f) {
            this.N.setText(((int) aA.b(this.u.targetWeight, this.u.miliConfig.weightUnit)) + aA.a(getActivity().getApplicationContext(), this.u.miliConfig.weightUnit));
        } else {
            this.N.setText(com.xiaomi.e.a.f);
        }
        q();
    }

    private void t() {
        this.B.setText(ChartData.a(getActivity(), this.u.getTotalDistance(), 1)[0]);
        this.C.setText(getString(r.odo, new Object[]{r0[1]}));
        this.k.setText(this.u.getUnit() == 0 ? getString(r.unit_metric) : getString(r.unit_british));
        this.m.setText(u());
    }

    private String u() {
        int i = this.u.height;
        int a = C0890y.a(i);
        if (this.u.getUnit() == 0) {
            return i + getString(r.cm);
        }
        String quantityString = getResources().getQuantityString(p.numberFoot, a / 12, new Object[]{Integer.valueOf(a / 12)});
        return quantityString + " " + getResources().getQuantityString(p.numberInch, a % 12, new Object[]{Integer.valueOf(a % 12)});
    }

    private void v() {
        DialogFragment cBVar = new cB();
        c.showPanel(getActivity(), cBVar);
        cBVar.setOpClickListener(new cT(this));
    }

    private void w() {
        Utils.c(getActivity(), 1);
        k();
        com.xiaomi.hm.health.bt.bleservice.a.b();
        com.xiaomi.hm.health.bt.bleservice.a.h();
        if (b.h().d.a.booleanValue() && getActivity() != null) {
            h.a(getActivity()).b();
        }
        y();
    }

    private void x() {
        com.huami.android.view.b.a(getActivity(), (int) r.logout_failed_retry, 0).show();
    }

    private void y() {
        ((NotificationManager) getActivity().getSystemService("notification")).cancelAll();
    }

    protected boolean b() {
        return true;
    }

    public boolean d() {
        ArrayList a = C0591m.a().a(new C0595q());
        boolean z = (a == null || a.size() == 0) && ah.a().f().isEmpty() && ah.a().d().isEmpty() && !i.a(getActivity()) && !cn.com.smartdevices.bracelet.shoes.sync.J.a(getActivity());
        C0596r.d(g, "checkDataNeedSync:" + (!z));
        return !z;
    }

    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == b && intent != null) {
            this.u.avatarPath = intent.getStringExtra(CropImageActivity.a);
            q();
            this.u.setNeedSyncServer(1);
            Keeper.keepPersonInfo(this.u);
            C0596r.e(g, "onActivityResult requst_code =" + i);
            EventBus.getDefault().post(new EventPersonInfoUpdate(EventPersonInfoUpdate.UPDATE_AVATAR));
        } else if (i == c && intent != null && intent.getExtras() != null) {
            this.F = (Bitmap) intent.getExtras().get(com.xiaomi.channel.gamesdk.b.b);
            if (this.F != null) {
                try {
                    String str = Utils.j(getActivity().getApplicationContext()) + "/bracelet_icon.jpg";
                    OutputStream fileOutputStream = new FileOutputStream(str);
                    this.F.compress(CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                    this.u.avatarPath = str;
                    this.w.setBackground(new BitmapDrawable(getResources(), O.a(this.F)));
                    this.F.recycle();
                    this.F = null;
                    this.u.setNeedSyncServer(1);
                    Keeper.keepPersonInfo(this.u);
                    C0596r.e(g, "onActivityResult requst_code =" + i + " task photo post evnetbus");
                    EventBus.getDefault().post(new EventPersonInfoUpdate(EventPersonInfoUpdate.UPDATE_AVATAR));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (i == h) {
            if (intent != null && intent.getExtras() != null) {
                this.u.setDaySportGoals(intent.getExtras().getInt(a.ct, this.u.getDaySportGoalSteps()));
                q();
            }
        } else if (i != i) {
        } else {
            if (WeightGoalSetActivity.c == i2) {
                EventBus.getDefault().post(new EventPersonInfoUpdate());
            } else if (WeightGoalSetActivity.d == i2) {
                float floatExtra = intent.getFloatExtra(WeightGoalSetActivity.b, 0.0f);
                this.u.targetWeight = aA.a(floatExtra, Keeper.readPersonInfo().miliConfig.weightUnit);
                EventBus.getDefault().post(new EventPersonInfoUpdate());
            }
        }
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case l.info_nick_name /*2131297076*/:
                c.showPanel(getActivity(), C0758dg.a(-1).getClass());
                return;
            case l.info_person_signature /*2131297077*/:
                c.showPanel(getActivity(), C0759dh.class);
                return;
            case l.info_gender /*2131297129*/:
                c.showPanel(getActivity(), C0754dc.a(-1).getClass());
                return;
            case l.info_age_area /*2131297131*/:
                c.showPanel(getActivity(), C0752da.a(-1).getClass());
                return;
            case l.info_height /*2131297133*/:
                c.showPanel(getActivity(), C0755dd.a(-1).getClass());
                return;
            case l.info_weight /*2131297260*/:
                if (b.h().l.a.booleanValue()) {
                    intent = new Intent(getActivity(), StatisticActivity.class);
                    intent.putExtra(ChartData.KEY_MODE, PersonInfo.INCOMING_CALL_DISABLE_BIT);
                    intent.putExtra("FROM_PERSONINFO_FRAGMENT", true);
                    getActivity().startActivity(intent);
                    return;
                }
                c.showPanel(getActivity(), C0760di.a(-1).getClass());
                return;
            case l.device_set_goal /*2131297347*/:
                startActivityForResult(new Intent(getActivity(), HealthGoalsActivity.class), h);
                return;
            case l.edit_member_name /*2131297355*/:
            case l.person_page_nickname /*2131297394*/:
                c.showPanel(getActivity(), C0758dg.a(-1).getClass());
                return;
            case l.info_weight_goal /*2131297381*/:
                intent = new Intent(getActivity(), WeightGoalSetActivity.class);
                intent.putExtra(WeightGoalSetActivity.a, -1);
                getActivity().startActivityForResult(intent, i);
                return;
            case l.info_unit_set /*2131297384*/:
                startActivity(new Intent(getActivity(), PersonInfoSettingUnitActivity.class));
                return;
            case l.mili_exit_login /*2131297391*/:
                if (Utils.l(getActivity())) {
                    j();
                    return;
                }
                com.huami.android.view.b.a(getActivity(), (int) r.no_network_connection, 0).show();
                a();
                return;
            case l.person_page_icon /*2131297393*/:
                c.showPanel(getActivity(), dC.class);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PersonInfo personInfo = (PersonInfo) new C0993k().a(getArguments().getString(d), PersonInfo.class);
        C0596r.e(g, "thisperson=" + personInfo);
        this.u = personInfo;
        EventBus.getDefault().register(this);
        this.f = new Handler();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0596r.e(g, "onCreateView");
        View inflate = layoutInflater.inflate(n.person_info_fragment, null);
        a(inflate);
        g();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventPersonInfoUpdate eventPersonInfoUpdate) {
        this.u = Keeper.readPersonInfo();
        C0596r.e(g, "update ... ui " + this.u);
        if (!EventPersonInfoUpdate.UPDATE_AVATAR.equals(eventPersonInfoUpdate.type)) {
            s();
            n();
        }
        Utils.a(getActivity(), this.u);
    }

    public void onEvent(EventPersonInfoUpdateUnit eventPersonInfoUpdateUnit) {
        this.u = Keeper.readPersonInfo();
        t();
        Utils.a(getActivity(), this.u);
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.f);
    }

    public void onResume() {
        super.onResume();
        p();
        b(this.u.getBirthday());
        if (this.u.getNeedSyncServer() != 0) {
            onEvent(new EventPersonInfoUpdate());
        } else {
            s();
        }
        C0401a.a(C0401a.f);
    }
}
