package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0623s;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.eventbus.EventNotifyStatusClosed;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.lua.ScrollSlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.ScrollSlidingUpPanelLayout.LayoutParams;
import cn.com.smartdevices.bracelet.lua.ScrollSlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.notification.NotificationSettingActivity;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.huami.android.view.c;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.C1115b;
import com.xiaomi.hm.health.bt.a.j;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.f;
import com.xiaomi.hm.health.bt.profile.a.d;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import kankan.wheel.widget.g;

public class C0784ee extends p implements OnClickListener, OnLongClickListener {
    public static final String b = "REF_MILI_NAME";
    public static final long c = 500;
    private static final String d = "SettingFragment";
    private static final int e = 256;
    private static final int f = 257;
    private static final int g = 100;
    private static final long h = 10;
    private static final int i = 75;
    private String A;
    private TextView B;
    private ScrollSlidingUpPanelLayout C;
    private RotateAnimation D;
    private float E;
    private Switch F = null;
    private View G;
    private boolean H;
    private int I;
    private TextView J;
    private TextView K;
    private TextView L = null;
    private TextView M = null;
    private View N = null;
    private TextView O = null;
    private b P = b.h();
    private Switch Q;
    private Switch R;
    private Switch S = null;
    private String T = a.f;
    private boolean U = false;
    private TextView V;
    private ScrollView W;
    private Switch X;
    private BraceletBtInfo Y;
    private d Z = null;
    private PanelSlideListener aa = new C0786eg(this);
    private f j = null;
    private PersonInfo k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o = null;
    private TextView p;
    private TextView q;
    private TextView r;
    private View s;
    private View t;
    private LinePieChartView u;
    private Animator v;
    private TextView w;
    private TextView x;
    private View y;
    private ImageView z;

    private long a(int i) {
        return (long) (100 - i);
    }

    private void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.u.setRotationX(90.0f - (f * 90.0f));
            this.u.setAlpha(f);
            float f2 = (-this.E) * (1.0f - f);
            this.G.setTranslationY(f2);
            this.q.setAlpha(f);
            this.q.setTranslationY(f2);
            this.r.setAlpha(f);
        }
    }

    private void a(View view) {
        this.C = (ScrollSlidingUpPanelLayout) view.findViewById(l.fragment_setting_sliding_layout);
        this.C.setOverlayed(true);
        this.C.setEnableDragViewTouchEvents(true);
        this.C.setPanelSlideListener(this.aa);
        this.W = (ScrollView) view.findViewById(l.myScrollView);
        d();
        this.m = (TextView) view.findViewById(l.device_firmware_version_text);
        this.n = (TextView) view.findViewById(l.device_heartrate_firmware_version_text);
        this.l = (TextView) view.findViewById(l.device_set_goal_text);
        this.o = (TextView) view.findViewById(l.mili_rebind_tips);
        this.B = (TextView) view.findViewById(l.mili_rebind_tips_in_mask);
        this.N = view.findViewById(l.device_find_bracelet);
        this.N.setOnClickListener(this);
        this.O = (TextView) view.findViewById(l.device_find_bracelet_tv);
        view.findViewById(l.device_set_goal).setOnClickListener(this);
        view.findViewById(l.device_unbind).setOnClickListener(this);
        View findViewById = view.findViewById(l.device_light_color);
        findViewById.setOnClickListener(this);
        View findViewById2 = view.findViewById(l.device_wear_hand);
        findViewById2.setOnClickListener(this);
        view.findViewById(l.device_weixin_enter_ll).setOnClickListener(this);
        view.findViewById(l.device_qq_health).setOnClickListener(this);
        View findViewById3 = view.findViewById(l.device_firmware_version);
        findViewById3.setOnClickListener(this);
        View findViewById4 = view.findViewById(l.notification_setting);
        findViewById4.setOnClickListener(this);
        View findViewById5 = view.findViewById(l.incoming_call_notify);
        findViewById5.setOnClickListener(this);
        View findViewById6 = view.findViewById(l.alarm_notify);
        findViewById6.setOnClickListener(this);
        View findViewById7 = view.findViewById(l.sms_notify);
        findViewById7.setOnClickListener(this);
        View findViewById8 = view.findViewById(l.item_heart);
        if (!this.U) {
            findViewById6.setVisibility(8);
            findViewById7.setVisibility(8);
            view.findViewById(l.alarm_notify_split).setVisibility(8);
            view.findViewById(l.sms_notify_split).setVisibility(8);
            view.findViewById(l.other_tv).setVisibility(8);
            view.findViewById(l.other_split).setVisibility(8);
            view.findViewById(l.notify_setting_tv).setVisibility(8);
            view.findViewById(l.notify_setting_split).setVisibility(8);
        }
        View findViewById9 = view.findViewById(l.vibrate_notify);
        findViewById9.setOnClickListener(this);
        View findViewById10 = view.findViewById(l.setting_daily_sport_notify);
        findViewById10.setOnClickListener(this);
        view.findViewById(l.device_unbind_in_mask).setOnClickListener(this);
        View findViewById11 = view.findViewById(l.device_unlock_screen);
        findViewById11.setOnClickListener(this);
        View findViewById12 = view.findViewById(l.sleep_assist_contaier);
        findViewById12.setOnClickListener(this);
        if (!C0623s.b(getActivity())) {
            view.findViewById(l.device_unlock_split).setVisibility(8);
            findViewById11.setVisibility(8);
        }
        this.V = (TextView) view.findViewById(l.device_unlock_screen_text);
        g();
        this.p = (TextView) view.findViewById(l.device_battery_percent_text);
        this.y = view.findViewById(l.device_battery_percent_mark);
        this.q = (TextView) view.findViewById(l.device_battery_day_text);
        this.r = (TextView) view.findViewById(l.device_battery_low_text);
        this.z = (ImageView) view.findViewById(l.device_battery_center_img);
        this.G = view.findViewById(l.device_battery_area);
        if (!this.P.w.booleanValue()) {
            ((TextView) view.findViewById(l.device_battery_battery_txt)).setText(a.f);
        }
        this.s = view.findViewById(l.mask_view);
        this.t = view.findViewById(l.mili_top_bar);
        this.u = (LinePieChartView) view.findViewById(l.battery_pie_chart);
        this.u.a(1);
        this.w = (TextView) view.findViewById(l.device_light_color_txt);
        this.x = (TextView) view.findViewById(l.device_wear_hand_text);
        this.E = TypedValue.applyDimension(1, 75.0f, getResources().getDisplayMetrics());
        if (this.k.getInComingCallTime() >= HeartRateInfo.HR_EMPTY_VALUE || !(this.k.isInComingCallEnabled() || this.k.getInComingCallTime() == 2)) {
            this.k.setInComingCallTime(2);
            this.k.disableInComingCallTime();
            Keeper.keepPersonInfo(this.k);
        }
        this.J = (TextView) view.findViewById(l.notification_available);
        this.K = (TextView) view.findViewById(l.incoming_call_notify_text);
        this.L = (TextView) view.findViewById(l.alarm_notify_text);
        this.M = (TextView) view.findViewById(l.sms_notify_text);
        this.F = (Switch) view.findViewById(l.vibrate_notify_switch);
        this.F.setChecked(this.k.getMiliVibrate());
        this.F.setOnCheckedChangeListener(new C0787eh(this));
        this.X = (Switch) view.findViewById(l.sleep_assist_switch);
        this.X.setChecked(this.k.getMiliSleepAssist());
        this.X.setOnCheckedChangeListener(new C0788ei(this));
        this.Q = (Switch) view.findViewById(l.setting_daily_sport_notify_switch);
        this.Q.setChecked(this.k.getMiliConfig().getDailySportNofity().equals(C0401a.fG));
        this.Q.setOnCheckedChangeListener(new C0790ek(this));
        if (this.Y.a != 4) {
            findViewById8.setVisibility(8);
            view.findViewById(l.setting_realtime_hr_ll).setVisibility(8);
            view.findViewById(l.view_fill).setVisibility(8);
            findViewById12.setVisibility(8);
        }
        if (this.Y.a != 0) {
            findViewById.setVisibility(8);
            view.findViewById(l.margin_light_color).setVisibility(8);
        }
        View findViewById13 = view.findViewById(l.setting_daily_sleep_notify);
        findViewById13.setOnClickListener(this);
        if (t.a()) {
            this.q.setTextSize(14.0f);
            this.O.setTextSize(13.5f);
            ((TextView) findViewById.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById2.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById11.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById4.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById5.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById9.findViewById(l.item_title)).setTextSize(13.5f);
            this.o.setTextSize(13.5f);
            ((TextView) findViewById3.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById8.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById10.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById13.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById7.findViewById(l.item_title)).setTextSize(13.5f);
            ((TextView) findViewById12.findViewById(l.item_title)).setTextSize(13.5f);
            this.w.setTextSize(11.0f);
            this.x.setTextSize(11.0f);
            this.J.setTextSize(11.0f);
            this.K.setTextSize(11.0f);
            ((TextView) view.findViewById(l.vibrate_notify_text)).setTextSize(11.0f);
            ((TextView) view.findViewById(l.sleep_assist_info)).setTextSize(11.0f);
            this.m.setTextSize(11.0f);
            this.n.setTextSize(11.0f);
        }
        this.R = (Switch) view.findViewById(l.setting_daily_sleep_notify_switch);
        this.R.setChecked(this.k.getMiliConfig().getDailySleepNofity());
        this.R.setOnCheckedChangeListener(new C0791el(this));
        view.findViewById(l.setting_realtime_hr_ll).setOnClickListener(this);
        this.S = (Switch) view.findViewById(l.setting_realtime_hr_switch);
        this.S.setChecked(Keeper.readEnableRtHeartrate());
        this.S.setOnCheckedChangeListener(new C0792em(this));
    }

    private void a(TextView textView) {
        if (QQLogin.getInstance(getActivity().getApplicationContext()).isLoginValid()) {
            textView.setText(r.state_binded);
        } else {
            textView.setText(r.state_unbinded);
        }
    }

    private void a(boolean z) {
        new j(new C0785ef(this, z)).g();
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b(boolean z) {
        if (z) {
            this.N.setEnabled(true);
            this.O.setTextColor(getResources().getColor(g.main_ui_title_color));
            return;
        }
        this.N.setEnabled(false);
        this.O.setTextColor(getResources().getColor(g.disabled_text_color));
    }

    private Animator c(int i) {
        q.a(cn.com.smartdevices.bracelet.chart.util.a.c(g, i, this.p));
        q.b(this.u.a(), c);
        return q.a();
    }

    public static C0784ee c() {
        C0784ee c0784ee = new C0784ee();
        c0784ee.setArguments(new Bundle());
        return c0784ee;
    }

    private void c(boolean z) {
        C0596r.e(d, "updateLeftBattery mBatteryInfo =" + this.j + ", isVisible=" + isVisible() + ", showAnimation = " + z);
        if (this.j != null && getActivity() != null) {
            switch (this.j.d) {
                case kankan.wheel.widget.a.i /*0*/:
                case kankan.wheel.widget.l.a /*1*/:
                case kankan.wheel.widget.a.aQ /*4*/:
                    int i;
                    b(true);
                    this.u.b();
                    this.u.a(1);
                    if (this.j.a <= 10) {
                        this.r.setVisibility(0);
                    } else {
                        this.r.setVisibility(8);
                    }
                    if (this.j.b.get(1) == kankan.wheel.widget.a.bZ) {
                        Calendar firstUseDate = this.k.getFirstUseDate();
                        if (firstUseDate == null) {
                            firstUseDate = Calendar.getInstance();
                            this.k.setFirstUseDate(Calendar.getInstance());
                            this.k.setNeedSyncServer(2);
                            Keeper.keepPersonInfo(this.k);
                            Utils.a(getActivity(), this.k);
                        }
                        i = ((Calendar.getInstance().get(1) * 365) + Calendar.getInstance().get(6)) - (firstUseDate.get(6) + (firstUseDate.get(1) * 365));
                        if (i == 0) {
                            this.A = getResources().getString(r.first_use_days_today_format);
                        } else {
                            this.A = String.format(getResources().getText(r.first_use_remain_days_format).toString(), new Object[]{Integer.valueOf(i)});
                        }
                        if (i == 1) {
                            this.A = this.A.replace(cn.com.smartdevices.bracelet.j.f.as, "day");
                        }
                    } else {
                        i = ((Calendar.getInstance().get(1) * 365) + Calendar.getInstance().get(6)) - ((this.j.b.get(1) * 365) + this.j.b.get(6));
                        if (i == 0) {
                            this.A = getResources().getString(r.remain_days_today_format);
                        } else {
                            this.A = String.format(getResources().getText(r.remain_days_format).toString(), new Object[]{Integer.valueOf(i)});
                        }
                        if (i == 1) {
                            this.A = this.A.replace(cn.com.smartdevices.bracelet.j.f.as, "day");
                        }
                        if (this.k.getFirstUseDate() != null) {
                            this.k.setFirstUseDate(null);
                            this.k.setNeedSyncServer(2);
                            Keeper.keepPersonInfo(this.k);
                            Utils.a(getActivity(), this.k);
                        }
                    }
                    if (i < 0 || i >= 120) {
                        this.q.setText(a.f);
                    } else {
                        this.q.setText(this.A);
                    }
                    if (this.v != null && this.v.isStarted()) {
                        this.v.end();
                    }
                    if (z) {
                        this.v = c(this.j.a);
                        this.u.postDelayed(new C0795ep(this), 350);
                    } else {
                        this.u.a(100);
                        this.u.b(a(this.j.a));
                        this.p.setText(this.j.a + a.f);
                    }
                    this.z.setVisibility(8);
                    this.p.setVisibility(0);
                    this.y.setVisibility(0);
                    return;
                case kankan.wheel.widget.a.k /*2*/:
                    this.u.a(2);
                    this.u.c((long) h);
                    this.q.setText(r.battery_charging);
                    this.z.setImageResource(k.searching_mili_icon);
                    this.z.setVisibility(0);
                    this.p.setVisibility(8);
                    this.y.setVisibility(8);
                    this.r.setVisibility(8);
                    b(false);
                    return;
                case kankan.wheel.widget.a.l /*3*/:
                    this.u.b();
                    this.u.a(100);
                    this.u.b(a((int) g));
                    this.u.a(1);
                    this.q.setText(r.battery_charge_full);
                    this.z.setVisibility(8);
                    this.p.setText("100");
                    this.p.setVisibility(0);
                    this.y.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        fg a = new fe(getActivity()).a();
        if (a.d()) {
            int e = a.e();
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.xiaomi.hm.health.j.main_ui_panel_height);
            C0596r.e(d, "SlidingPanel SystemBarH : " + e + ", OriginalPanelH : " + dimensionPixelSize);
            this.C.setPanelHeight(dimensionPixelSize - e);
            dimensionPixelSize = getResources().getDimensionPixelSize(com.xiaomi.hm.health.j.main_ui_dragview_height);
            C0596r.e(d, "SlidingPanel ScrollViewH : " + dimensionPixelSize);
            this.W.setLayoutParams(new LayoutParams(-1, dimensionPixelSize - e));
        }
    }

    private void e() {
        boolean z = true;
        if (com.xiaomi.hm.health.bt.bleservice.a.c()) {
            l();
            this.j = f();
            if (this.j != null) {
                c(true);
                z = false;
            }
            a(z);
        }
    }

    private f f() {
        f e = com.xiaomi.hm.health.bt.bleservice.a.e();
        if (e != null) {
            this.j = e;
            C0596r.e(d, "getCachedBatteryInfo = " + this.j);
        }
        return this.j;
    }

    private void g() {
        if (C0623s.a(getActivity())) {
            this.V.setVisibility(4);
        } else if (Utils.o(getActivity())) {
            this.V.setText(r.state_open);
        } else {
            this.V.setText(r.state_close);
        }
    }

    private void h() {
        if (!a(this.D)) {
            int i = this.I + 1;
            this.I = i;
            if (i >= 3) {
                this.I = h.d;
                com.huami.android.view.b.a(getActivity(), (int) r.find_bracelet_warning, 1).show();
            }
            new C1115b((byte) 3, null).g();
            this.z.setVisibility(0);
            this.D.reset();
            this.z.startAnimation(this.D);
        }
    }

    private void i() {
        this.D = new RotateAnimation(-5.0f, 5.0f, 0, Utils.b(16.0f, getActivity()), 0, Utils.b(33.0f, getActivity()));
        this.D.setAnimationListener(new C0794eo(this));
        this.D.setDuration(50);
        this.D.setRepeatCount(20);
        this.D.setInterpolator(new AccelerateDecelerateInterpolator());
        this.D.setRepeatMode(2);
    }

    private void j() {
        startActivityForResult(new Intent(getActivity(), UnBindActivity.class), f);
    }

    private void k() {
        startActivity(new Intent(getActivity(), SearchSingleBraceletActivity.class));
    }

    private void l() {
        C0596r.e(d, "enableUI");
        this.s.setVisibility(4);
        this.o.setVisibility(0);
        Activity activity = getActivity();
        if (activity != null) {
            if (activity instanceof SettingContainerActivity) {
                ((SettingContainerActivity) activity).a();
            } else if (activity instanceof SettingActivity) {
                ((SettingActivity) activity).a();
            }
        }
        this.p.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(4);
    }

    private void m() {
        this.s.setVisibility(0);
        this.o.setVisibility(4);
        Activity activity = getActivity();
        if (activity != null) {
            if (activity instanceof SettingContainerActivity) {
                ((SettingContainerActivity) activity).a();
            } else if (activity instanceof SettingActivity) {
                ((SettingActivity) activity).a();
            }
        }
        this.q.setText(r.bracelet_not_connected_bat_unknown);
        this.p.setVisibility(4);
        this.y.setVisibility(4);
        this.u.b();
        this.z.setImageResource(k.wrong_mark);
        this.z.setVisibility(0);
        this.u.a(100);
        this.u.b(100);
        this.u.a(0);
        this.u.a(false);
        if (Utils.e()) {
            this.B.setText(r.unbind);
        } else {
            this.B.setText(r.bind_new_mili);
        }
    }

    private void n() {
        s();
        t();
        r();
        q();
        o();
        p();
        g();
    }

    private void o() {
        if (cn.com.smartdevices.bracelet.notification.h.a(getActivity()).f()) {
            this.J.setText(getString(r.state_open));
        } else {
            this.J.setText(getString(r.state_close));
        }
    }

    private void p() {
        int i = 3;
        B a = B.a();
        if (!this.U) {
            if (this.k.isInComingCallEnabled()) {
                this.K.setText(getString(r.incoming_call_notify_tips, new Object[]{Integer.valueOf(this.k.getInComingCallTime())}));
            } else {
                this.K.setText(getString(r.state_close));
            }
            C0596r.e(d, "inComingCallTime = " + this.k.getInComingCallTime() + ", enabled = " + this.k.isInComingCallEnabled());
        } else if (a.c(this.T)) {
            int e = a.e(this.T);
            if (e >= 3) {
                i = e;
            }
            this.K.setText(getString(r.incoming_call_notify_tips, new Object[]{Integer.valueOf(i)}));
        } else {
            this.K.setText(getString(r.state_close));
        }
        if (this.U) {
            if (a.b(this.T)) {
                this.L.setText(r.state_open);
            } else {
                this.L.setText(r.state_close);
            }
            if (a.d(this.T)) {
                this.M.setText(r.state_open);
            } else {
                this.M.setText(r.state_close);
            }
        }
    }

    private void q() {
        if (MiliConfig.LEFT_HAND.equals(this.k.getMiliWearHand())) {
            this.x.setText(r.left_hand);
        } else if (MiliConfig.RIGHT_HAND.equals(this.k.getMiliWearHand())) {
            this.x.setText(r.right_hand);
        } else {
            this.x.setText(r.body);
        }
    }

    private void r() {
        if (MiliConfig.BLUE.equals(this.k.getMiliColor())) {
            this.w.setText(r.blue);
        } else if (MiliConfig.ORANGE.equals(this.k.getMiliColor())) {
            this.w.setText(r.orange);
        } else if (MiliConfig.GREEN.equals(this.k.getMiliColor())) {
            this.w.setText(r.green);
        } else if (MiliConfig.RED.equals(this.k.getMiliColor())) {
            this.w.setText(r.red);
        }
    }

    private void s() {
        this.l.setText(this.k.getDaySportGoalSteps() + getString(r.step_per_day));
    }

    private void t() {
        com.xiaomi.hm.health.bt.model.h f = com.xiaomi.hm.health.bt.bleservice.a.f();
        if (f != null) {
            this.m.setText(f.k());
            this.n.setText(f.p());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(d, "onActivityResult: " + i + " result:" + i2);
        if (i == e && i2 == -1) {
            this.k = Keeper.readPersonInfo();
            s();
        } else if (i == f && i2 == -1) {
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (activity instanceof SettingContainerActivity) {
                ((SettingContainerActivity) activity).b();
            } else if (activity instanceof SettingActivity) {
                ((SettingActivity) activity).b();
            }
        }
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case l.device_set_goal /*2131297347*/:
                startActivityForResult(new Intent(getActivity(), HealthGoalsActivity.class), e);
                return;
            case l.device_find_bracelet /*2131297465*/:
                h();
                C0401a.a(getActivity(), C0401a.dK);
                return;
            case l.device_light_color /*2131297467*/:
                c.showPanel(getActivity(), cY.class);
                return;
            case l.device_wear_hand /*2131297471*/:
                c.showPanel(getActivity(), C0762dk.class);
                return;
            case l.device_unlock_screen /*2131297473*/:
                intent = new Intent();
                intent.setClass(getActivity(), UnlockScreenHelperActivity.class);
                getActivity().startActivity(intent);
                return;
            case l.notification_setting /*2131297478*/:
                startActivity(new Intent(getActivity(), NotificationSettingActivity.class));
                return;
            case l.incoming_call_notify /*2131297480*/:
                startActivity(this.U ? new Intent(getActivity(), SettingMiuiSupportIncallActivity.class) : new Intent(getActivity(), SettingInComingCallActivity.class));
                return;
            case l.sleep_assist_contaier /*2131297482*/:
                this.X.toggle();
                return;
            case l.alarm_notify /*2131297485*/:
                intent = new Intent(getActivity(), SettingPhoneNotifyActivity.class);
                intent.putExtra(SettingPhoneNotifyActivity.a, 1);
                startActivity(intent);
                return;
            case l.sms_notify /*2131297488*/:
                intent = new Intent(getActivity(), SettingPhoneNotifyActivity.class);
                intent.putExtra(SettingPhoneNotifyActivity.a, 2);
                startActivity(intent);
                return;
            case l.vibrate_notify /*2131297493*/:
                this.F.toggle();
                return;
            case l.setting_daily_sport_notify /*2131297496*/:
                this.Q.toggle();
                return;
            case l.setting_daily_sleep_notify /*2131297499*/:
                this.R.toggle();
                return;
            case l.setting_realtime_hr_ll /*2131297502*/:
                this.S.toggle();
                return;
            case l.device_qq_health /*2131297505*/:
                startActivity(new Intent(getActivity(), BindQQHealthActivity.class));
                return;
            case l.device_weixin_enter_ll /*2131297507*/:
                startActivity(Utils.p(getActivity()) ? new Intent(getActivity(), BindWeixinActivityNew.class) : new Intent(getActivity(), BindWeixinActivity.class));
                return;
            case l.device_unbind /*2131297509*/:
                j();
                return;
            case l.device_firmware_version /*2131297511*/:
                BraceletBtInfo readBraceletBtInfo = Keeper.readBraceletBtInfo();
                com.huami.android.view.b.a(getActivity(), getActivity().getString(r.bracelet_info_mac_address, new Object[]{readBraceletBtInfo.c, readBraceletBtInfo.b}), 1).show();
                return;
            case l.device_unbind_in_mask /*2131297516*/:
                if (Utils.e()) {
                    j();
                    return;
                } else {
                    k();
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.Y = Keeper.readBraceletBtInfo();
        this.Z = new d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.setting_fragment, viewGroup, false);
        this.k = Keeper.readPersonInfo();
        this.T = Keeper.readBraceletBtInfo().b;
        this.U = B.a().f();
        a(inflate);
        i();
        this.H = true;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (this.k.isInComingCallEnabled()) {
            C0401a.a(getActivity(), C0401a.dO, C0401a.fG);
            C0401a.a(getActivity(), C0401a.dP, this.k.getInComingCallTime());
            return;
        }
        C0401a.a(getActivity(), C0401a.dO, C0401a.fH);
    }

    public void onDestroyView() {
        super.onDestroyView();
        C0596r.e(d, "onDestroyView");
    }

    public void onEvent(EventNotifyStatusClosed eventNotifyStatusClosed) {
        C0596r.d(d, "EventNotifyStatusClosed");
        B a = B.a();
        boolean c = a.c(this.T);
        boolean b = a.b(this.T);
        boolean d = a.d(this.T);
        if (!c && !b && !d) {
            a.a(this.T);
        }
    }

    public void onEvent(EventPersonInfoUpdate eventPersonInfoUpdate) {
        this.k = Keeper.readPersonInfo();
        Utils.a(getActivity(), this.k);
    }

    public void onEvent(EventSettingFragmentUpdate eventSettingFragmentUpdate) {
        this.k = Keeper.readPersonInfo();
        n();
        C0596r.d(d, "EventSettingFragmentUpdate onEvent...");
        com.activeandroid.d.b.e(d, "EventSettingFragmentUpdate onEvent...");
        Utils.a(getActivity(), this.k);
    }

    public void onEvent(HwBatteryStatus hwBatteryStatus) {
        C0596r.e(d, "EventBatteryStatus onEvent: status = " + hwBatteryStatus.e + ", charges =" + hwBatteryStatus.f);
        a(false);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        Activity activity;
        if (hwConnStatus.k()) {
            C0596r.e(d, "connect success");
            l();
            activity = getActivity();
            if (activity != null) {
                ((SystemBarTintActivity) activity).applyStatusBarTintAuto();
            }
            if (this.j == null) {
                a(true);
                return;
            } else {
                c(false);
                return;
            }
        }
        m();
        activity = getActivity();
        if (activity != null) {
            ((SystemBarTintActivity) activity).applyStatusBarTintAuto();
        }
    }

    public boolean onLongClick(View view) {
        view.getId();
        return true;
    }

    public void onPause() {
        super.onPause();
        if (a(this.D)) {
            this.z.clearAnimation();
            this.z.setVisibility(4);
        }
        C0401a.b(C0401a.N);
    }

    public void onResume() {
        super.onResume();
        C0596r.e(d, "onResume");
        n();
        if (this.H) {
            e();
            this.H = false;
        }
        if (!com.xiaomi.hm.health.bt.bleservice.a.c()) {
            m();
        }
        if (isHidden()) {
            this.k = Keeper.readPersonInfo();
        } else {
            this.k = Keeper.readPersonInfo();
        }
        if (this.k.getNeedSyncServer() != 0) {
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        }
        C0401a.a(C0401a.N);
        View view = (View) getView().findViewById(l.device_qq_health).getParent();
        if (this.P.c.d.booleanValue()) {
            a((TextView) getView().findViewById(l.bind_qq_heath_state));
        } else {
            view.setVisibility(8);
        }
    }
}
