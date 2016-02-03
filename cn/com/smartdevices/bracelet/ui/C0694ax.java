package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.a;
import cn.com.smartdevices.bracelet.chart.util.p;
import cn.com.smartdevices.bracelet.chart.util.r;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.datasource.RtStep;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventLoadDataComplete;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdateUnit;
import cn.com.smartdevices.bracelet.eventbus.EventWeightLowBattery;
import cn.com.smartdevices.bracelet.eventbus.EventWeightTargetUpdated;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.ui.widget.CirclePageIndicator;
import cn.com.smartdevices.bracelet.view.DynamicView;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import cn.com.smartdevices.bracelet.weight.am;
import cn.com.smartdevices.bracelet.weight.family.WeightChooseUserActivity;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class C0694ax extends Fragment implements e {
    public static final int a = 0;
    public static final int b = 1;
    public static Handler c = null;
    private static final String d = "DynamicFragment";
    private static final String e = "weight_overload_fragment";
    private Boolean A = Boolean.valueOf(false);
    private int B = a;
    private boolean C = false;
    private boolean D;
    private boolean E;
    private boolean F;
    private P G = new P();
    private P H = new P();
    private int I = c.MILI.b();
    private int J = c.MILI.b();
    private boolean K;
    private final int f = 4114;
    private final int g = 4115;
    private final int h = 4116;
    private final int i = 4117;
    private final C0591m j = C0591m.a();
    private int k = -1;
    private FragmentManager l;
    private ViewPager m;
    private cn.com.smartdevices.bracelet.ui.widget.c n;
    private aE o;
    private TextView p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String v = null;
    private String w = null;
    private ValueAnimator x;
    private ValueAnimator y;
    private int z = a;

    private ValueAnimator a(int i, int i2) {
        p aAVar = new aA(this);
        View[] viewArr = new View[b];
        viewArr[a] = this.m;
        return (ValueAnimator) a.a(i, i2, aAVar, viewArr);
    }

    public static C0694ax a() {
        C0694ax c0694ax = new C0694ax();
        c0694ax.setArguments(new Bundle());
        return c0694ax;
    }

    private void a(Message message) {
        if (this.G != null) {
            int i = this.G.c;
            int i2 = message.arg1;
            boolean z = message.arg2 == b;
            C0596r.e(d, "Weight CurrentShownUID " + i + ", Changed : " + i2);
            if (i == i2 || z) {
                c(i2);
                b(true);
            }
        }
    }

    private void a(r rVar) {
        C0596r.e(d, "Update Dynamic Tip!!");
        String str = com.xiaomi.e.a.f;
        str = com.xiaomi.e.a.f;
        Calendar instance = Calendar.getInstance();
        C0596r.e(d, "CurrentTime : " + DateFormat.format("yyyy-MM-dd hh:mm:ss", instance));
        Calendar instance2 = Calendar.getInstance();
        long readSyncTime = Keeper.readSyncTime(this.I);
        if (readSyncTime == -1) {
            instance2.add(6, -1);
        } else {
            instance2.setTimeInMillis(readSyncTime);
        }
        C0596r.e(d, "LastSyncTime : " + DateFormat.format("yyyy-MM-dd hh:mm:ss", instance2));
        str = ((Utils.b(instance2, instance) > 0 || instance2.get(11) < 5) && instance.get(11) >= 5) ? getString(R.string.dynamic_tip_sleep_unsynced) : !rVar.m() ? getString(R.string.dynamic_tip_unweared) : getString(R.string.dynamic_sleep_tip);
        rVar.b(str);
        instance2 = Calendar.getInstance();
        readSyncTime = Keeper.readRealtimeStepsTimestamp(this.I);
        if (readSyncTime == -1) {
            instance2.add(6, -1);
        } else {
            instance2.setTimeInMillis(readSyncTime);
        }
        C0596r.e(d, "LastSyncRealStepTime : " + DateFormat.format("yyyy-MM-dd hh:mm:ss", instance2));
        if (Utils.b(instance2, instance) > 0) {
            str = getString(R.string.dynamic_tip_step_unsynced);
        } else {
            long timeInMillis = (long) ((int) ((instance.getTimeInMillis() - instance2.getTimeInMillis()) / d.g));
            if (timeInMillis < 2) {
                str = getString(R.string.dynamic_step_tip);
            } else if (timeInMillis >= 60) {
                r3 = new Object[b];
                r3[a] = Long.valueOf(timeInMillis / 60);
                str = getString(R.string.dynamic_tip_step_sync_time_hour, r3);
            } else {
                r3 = new Object[b];
                r3[a] = Long.valueOf(timeInMillis);
                str = getString(R.string.dynamic_tip_step_sync_time_min, r3);
            }
        }
        rVar.a(str);
    }

    private void a(com.xiaomi.hm.health.bt.profile.Weight.e eVar, List<UserInfo> list) {
        if (getActivity().getFragmentManager().findFragmentByTag(e) == null && Utils.c(getActivity())) {
            int[] iArr = new int[list.size()];
            for (int i = a; i < list.size(); i += b) {
                iArr[i] = ((UserInfo) list.get(i)).uid;
            }
            Intent intent = new Intent(getActivity(), WeightChooseUserActivity.class);
            intent.putExtra(com.xiaomi.hm.health.bt.profile.Weight.e.d, eVar.n());
            intent.putExtra("USER_LIST", iArr);
            getActivity().startActivity(intent);
            C0401a.a(getActivity().getApplicationContext(), C0401a.fQ);
        }
    }

    private void a(String str, String str2) {
    }

    private int b(int i, boolean z) {
        if (this.D && this.E && this.F) {
            switch (i) {
                case b /*1*/:
                    this.m.a((int) b, z);
                    break;
                case kankan.wheel.widget.a.bp /*16*/:
                    this.m.a((int) a, z);
                    break;
                case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                    this.m.a(2, z);
                    break;
            }
            ((View) this.n).setAlpha(CropOverlayView.a);
        } else if (this.D && this.E) {
            switch (i) {
                case b /*1*/:
                    this.m.a((int) b, z);
                    break;
                case kankan.wheel.widget.a.bp /*16*/:
                    this.m.a((int) a, z);
                    break;
                default:
                    i = b;
                    break;
            }
            ((View) this.n).setAlpha(CropOverlayView.a);
        } else if (this.E && this.F) {
            switch (i) {
                case b /*1*/:
                    this.m.a((int) a, z);
                    break;
                case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                    this.m.a((int) b, z);
                    break;
                default:
                    i = b;
                    break;
            }
            ((View) this.n).setAlpha(CropOverlayView.a);
        } else {
            if (this.E) {
                i = b;
            } else if (this.F) {
                i = PersonInfo.INCOMING_CALL_DISABLE_BIT;
            }
            ((View) this.n).setAlpha(0.0f);
        }
        return i;
    }

    private void b(boolean z) {
        boolean z2 = true;
        if (getActivity() != null) {
            r a = ChartData.a();
            a.a(this.k, this.I);
            a.y();
            if (this.F) {
                int age;
                int i = Keeper.readPersonInfo().miliConfig.weightUnit;
                com.xiaomi.hm.health.bt.profile.Weight.e eVar = this.G.a;
                if (!DeviceSource.hasBindWeight()) {
                    int h = eVar.h();
                    float j = eVar.j();
                    eVar.a(i);
                    eVar.b(aA.c(j, h, i));
                } else if (eVar.h() != i) {
                    PersonInfo readPersonInfo = Keeper.readPersonInfo();
                    readPersonInfo.miliConfig.weightUnit = eVar.h();
                    Keeper.keepPersonInfo(readPersonInfo);
                    Utils.a(getActivity(), readPersonInfo);
                }
                a.c(aA.a(getActivity(), eVar.h()));
                a.a(eVar.j());
                a.b(aA.a(eVar.j(), eVar.h()));
                a.d(eVar.i());
                if (this.G.c == -1) {
                    age = Keeper.readPersonInfo().getAge();
                    i = Keeper.readPersonInfo().gender;
                } else {
                    UserInfo a2 = J.a().a(this.G.c);
                    if (a2 != null) {
                        age = Birthday.fromStr(a2.birthday).getAge();
                        i = a2.gender;
                    } else {
                        age = 20;
                        i = b;
                    }
                }
                a.i(age);
                a.j(i);
                a.d(this.G.b);
                a.c(this.G.d);
                if (this.G.a.f()) {
                    a.g(this.G.c);
                    Keeper.keepWeightCurrentUserAsync(this.G.c);
                }
                a.a(this.G);
                C0596r.e(d, "update UI " + this.G.a.toString() + "  " + this.G.c + " " + this.G.b);
            }
            a(a);
            aE aEVar = this.o;
            if (z) {
                z2 = false;
            }
            aEVar.a(z2);
        }
    }

    private void c(int i) {
        C0596r.e(d, "uid " + i);
        if (i == -1) {
            h();
        }
        if (i == 0 || J.a().a(i) == null) {
            d((int) a);
        } else {
            i(i);
        }
    }

    private void d(int i) {
        com.xiaomi.hm.health.bt.profile.Weight.e eVar = this.G.a;
        WeightInfo e = ah.a().e(i);
        float f = 0.0f;
        if (e != null) {
            f = e.weight;
            eVar.a(e.timestamp);
            this.G.e = false;
        } else {
            this.G.e = true;
        }
        eVar.b(aA.b(f, eVar.h()));
        eVar.a((float) GroundOverlayOptions.NO_DIMENSION);
        this.G.b = getString(R.string.visitor);
        this.G.d = GroundOverlayOptions.NO_DIMENSION;
        this.G.c = i;
        this.H = this.G;
    }

    private int e(int i) {
        return b(i, false);
    }

    private void f(int i) {
        C0596r.e(d, "LastMode : " + this.z + " , ToMode : " + i);
        this.z = i;
        ChartData.a().h(this.z);
        MainUIActivity mainUIActivity = (MainUIActivity) getActivity();
        DynamicView f;
        switch (this.z) {
            case b /*1*/:
                mainUIActivity.c(this.z);
                mainUIActivity.d((int) R.drawable.btn_statistic);
                C0401a.a(getActivity(), C0401a.cH, ChartData.KEY_MODE, C0401a.cS);
                this.p.setVisibility(a);
                this.p.setText(this.w);
                f = this.o.f(b);
                if (f != null) {
                    f.c(true);
                    return;
                }
                return;
            case kankan.wheel.widget.a.bp /*16*/:
                mainUIActivity.c(this.z);
                mainUIActivity.d((int) R.drawable.btn_statistic);
                this.p.setVisibility(8);
                C0401a.a(getActivity(), C0401a.cH, ChartData.KEY_MODE, C0401a.cT);
                return;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                mainUIActivity.c(this.z);
                mainUIActivity.d((int) R.drawable.btn_statistic_weight);
                C0401a.a(getActivity(), C0401a.cH, ChartData.KEY_MODE, C0401a.cU);
                this.p.setText(this.v);
                if (DeviceSource.hasBindWeight()) {
                    this.p.setVisibility(4);
                } else {
                    this.p.setVisibility(a);
                }
                f = this.o.f(PersonInfo.INCOMING_CALL_DISABLE_BIT);
                if (f != null) {
                    f.c().b(0.0f);
                    f.b((float) GroundOverlayOptions.NO_DIMENSION);
                    f.c(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void g(int i) {
        int h = h(i);
        this.m.setBackgroundColor(h);
        ((MainUIActivity) getActivity()).applyStatusBarTint(h);
    }

    private int h(int i) {
        C0596r.e(d, "Update Background Mode : " + i + ", HasBindDevices : " + DeviceSource.hasBindDevice());
        int i2 = this.t;
        if (!DeviceSource.hasBindDevice(getActivity())) {
            return i2;
        }
        switch (i) {
            case b /*1*/:
                return DeviceSource.hasBindStepDevice(getActivity()) ? this.r : i2;
            case kankan.wheel.widget.a.bp /*16*/:
                return DeviceSource.hasBindBracelet() ? this.q : i2;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                return DeviceSource.hasBindWeight() ? this.s : i2;
            default:
                return i2;
        }
    }

    private void h() {
        com.xiaomi.hm.health.bt.profile.Weight.e eVar = new com.xiaomi.hm.health.bt.profile.Weight.e();
        int i = Keeper.readPersonInfo().miliConfig.weightUnit;
        eVar.a(i);
        eVar.a(true);
        WeightInfo e = ah.a().e(-1);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        float f = 0.0f;
        if (e != null) {
            C0596r.e(d, "Self latest info is not null " + e.toString());
            f = e.weight;
            eVar.a(e.timestamp);
            this.G.e = false;
        } else {
            C0596r.e(d, "Self latest info is null ");
            this.G.e = true;
        }
        eVar.b(aA.b(f, i));
        eVar.a(aA.a(readPersonInfo.height, Birthday.fromStr(readPersonInfo.birthday).getAge(), f));
        this.G.a = eVar;
        this.G.b = readPersonInfo.nickname;
        this.G.d = readPersonInfo.targetWeight;
        this.G.c = -1;
        this.H = this.G;
    }

    private int i() {
        return e((int) b);
    }

    private void i(int i) {
        C0596r.e(d, "update latest user weight info " + i);
        UserInfo a = J.a().a(i);
        if (a != null) {
            com.xiaomi.hm.health.bt.profile.Weight.e eVar = this.G.a;
            WeightInfo e = ah.a().e(i);
            float f = 0.0f;
            if (e != null) {
                C0596r.e(d, "weightAdvData " + this.G.a.toString() + " timestampe " + this.G.a.e());
                C0596r.e(d, "latestInfo " + e.toString());
                f = e.weight;
                eVar.a(e.timestamp);
                this.G.e = false;
            } else {
                this.G.e = true;
            }
            eVar.b(aA.b(f, eVar.h()));
            eVar.a(aA.a(a.height, Birthday.fromStr(a.birthday).getAge(), f));
            this.G.b = a.name;
            this.G.d = a.targetWeight;
            this.G.c = i;
            this.H = this.G;
        }
    }

    private void j() {
        this.x = null;
        this.y = null;
        if (!DeviceSource.hasBindDevice(getActivity())) {
            return;
        }
        if (this.D && this.E && this.F) {
            this.x = a(h(16), h((int) b));
            this.y = a(h((int) b), h((int) PersonInfo.INCOMING_CALL_DISABLE_BIT));
        } else if (this.D && this.E) {
            this.x = a(h(16), h((int) b));
        } else if (this.E && this.F) {
            this.x = a(h((int) b), h((int) PersonInfo.INCOMING_CALL_DISABLE_BIT));
        }
    }

    private void k() {
        c = new aB(this);
    }

    private void l() {
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        if (fragmentManager.findFragmentByTag(e) == null) {
            new am().show(fragmentManager.beginTransaction(), e);
        }
    }

    private void m() {
        this.v = getResources().getString(R.string.record_weight);
        this.w = getResources().getString(R.string.go_running);
        if (this.z == b) {
            this.p.setText(this.w);
        } else if (this.z == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.p.setText(this.v);
        }
    }

    private void n() {
    }

    public void a(float f) {
        if (getActivity() != null) {
            this.p.setTranslationY((((float) (-this.B)) * (1.0f - f)) * 2.13f);
            this.o.a(f);
        }
    }

    public void a(int i) {
        C0596r.e(cn.com.smartdevices.bracelet.relation.db.a.c, "process:" + i);
        if (i >= 0) {
            Keeper.keepRealtimeStepsTimestamp(System.currentTimeMillis(), this.I);
            Keeper.keepRealtimeSteps(i, this.I);
            if (DeviceSource.hasBindBracelet()) {
                SwitchOperator readSwitchOperator = Keeper.readSwitchOperator();
                if (readSwitchOperator.isValidBaseSteps()) {
                    i += readSwitchOperator.steps;
                }
            }
            Message message = new Message();
            message.arg1 = i;
            message.what = 4115;
            if (c != null) {
                c.sendMessage(message);
            }
        }
    }

    public void a(int i, boolean z) {
        Message message = new Message();
        message.what = 4117;
        message.arg1 = i;
        message.arg2 = z ? b : a;
        c.sendMessage(message);
    }

    public void a(cn.com.smartdevices.bracelet.ui.widget.c cVar) {
        if (getActivity() != null) {
            this.o.a(cVar);
        }
    }

    public void a(Boolean bool) {
        if (getActivity() != null) {
            this.o.b(bool.booleanValue());
        }
    }

    public void a(boolean z) {
        if (ChartData.a().t() != 0) {
            Message message = new Message();
            message.what = 4117;
            message.arg1 = ChartData.a().t();
            message.arg2 = z ? b : a;
            c.sendMessage(message);
        }
    }

    public void b() {
        if (this.m == null) {
            this.A = Boolean.valueOf(true);
            return;
        }
        this.m.getHeight();
        this.m.getLayoutParams().height = (int) Utils.b(372.0f, getActivity());
        this.m.requestLayout();
    }

    public void b(int i) {
        g(e(i));
        f(i);
        j();
    }

    public TextView c() {
        return this.p;
    }

    public void d() {
        C0596r.e(d, "Has Bind Sensor-hub : " + DeviceSource.hasBindSensorHub() + ", Bind Weight : " + DeviceSource.hasBindWeight());
        this.D = !DeviceSource.hasBindSensorHub();
        FragmentTransaction beginTransaction = this.l.beginTransaction();
        Iterator it = this.o.d.iterator();
        while (it.hasNext()) {
            beginTransaction.remove((Fragment) it.next());
        }
        beginTransaction.commit();
        this.l.executePendingTransactions();
        this.o.d();
        this.o.c();
        this.n.i();
        a(this.n);
        ((View) this.n).setTranslationY(0.0f);
        e();
    }

    public void e() {
        b((int) b);
    }

    public P f() {
        return this.G;
    }

    public P g() {
        return this.H;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m();
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.C = false;
        k();
        EventBus.getDefault().registerSticky(this);
        Resources resources = getActivity().getResources();
        this.q = resources.getColor(R.color.bg_mode_sleep);
        this.r = resources.getColor(R.color.bg_mode_step);
        this.s = resources.getColor(R.color.bg_mode_weight);
        this.t = resources.getColor(R.color.bg_mode_unbind);
        this.I = this.j.r();
        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(point);
        this.u = point.x;
        C0596r.e(d, "Has Bind Sensor-hub : " + DeviceSource.hasBindSensorHub() + ", Bind Weight : " + DeviceSource.hasBindWeight() + ",mDeviceType = " + this.I);
        if (!DeviceSource.hasBindSensorHub()) {
            z = true;
        }
        this.D = z;
        this.E = true;
        if (b.h().l.a.booleanValue()) {
            this.F = true;
            this.G.a.a(Keeper.readPersonInfo().miliConfig.weightUnit);
            this.G.a.a(true);
            c(Keeper.readWeightCurrentUser(-1));
        }
    }

    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_dynamic, viewGroup, false);
        this.m = (ViewPager) inflate.findViewById(R.id.view_pager);
        this.n = (cn.com.smartdevices.bracelet.ui.widget.c) inflate.findViewById(R.id.indicator);
        this.p = (TextView) inflate.findViewById(R.id.shortcut);
        this.p.setOnClickListener(new C0695ay(this));
        this.B = (int) Utils.b(106.0f, getActivity());
        this.v = getResources().getString(R.string.record_weight);
        this.w = getResources().getString(R.string.go_running);
        if (VERSION.SDK_INT < 17) {
            this.l = getFragmentManager();
        } else {
            this.l = getChildFragmentManager();
        }
        this.o = new aE(this, this.l);
        this.m.a(this.o);
        this.m.b(3);
        this.n.a(this.m);
        this.n.a(new C0696az(this));
        e();
        if (this.A.booleanValue()) {
            b();
        }
        a(this.n);
        if (t.a()) {
            ((CirclePageIndicator) this.n).b(t.a(getActivity(), 2.3f));
        }
        return inflate;
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        if (c != null) {
            c.removeCallbacksAndMessages(null);
            c = null;
        }
    }

    public void onEvent(EventGoalsUpdated eventGoalsUpdated) {
        C0596r.e(d, "onGoalsSettingChanged");
        if (isAdded()) {
            C0596r.e(d, "Dynamic Update : Goal Changed.");
            b(true);
        }
    }

    public void onEvent(EventLoadDataComplete eventLoadDataComplete) {
        C0596r.e(d, "onLoadDataComplete");
        if (isAdded()) {
            C0596r.e(d, "Dynamic Update : Data Loaded,Animation");
            b(false);
        }
    }

    public void onEvent(EventPersonInfoUpdateUnit eventPersonInfoUpdateUnit) {
        if (isAdded()) {
            this.o.a(true);
        }
    }

    public void onEvent(EventWeightLowBattery eventWeightLowBattery) {
        C0596r.d(d, "Weight Scale Battery Low!!");
        if (this.F && !this.K) {
            c.post(new aC(this));
        }
    }

    public void onEvent(EventWeightTargetUpdated eventWeightTargetUpdated) {
        C0596r.e(d, "onWeightTargetUpdated!!");
        if (isAdded()) {
            C0596r.e(d, "Dynamic Update : Weight Target Updated.");
            UserInfo a = J.a().a(this.G.c);
            if (a != null) {
                this.G.d = a.targetWeight;
            }
            b(true);
        }
    }

    public void onEvent(P p) {
        Message message = new Message();
        message.what = 4116;
        message.obj = p;
        c.sendMessage(message);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(d, "onBleStatusChanged:" + hwConnStatus);
        if (hwConnStatus.k()) {
            RtStep.enableRtSteps(getActivity(), this.I, !this.C, this);
        }
    }

    public void onEvent(HwSyncDataStatus hwSyncDataStatus) {
        if (hwSyncDataStatus.d() && isAdded()) {
            C0596r.e(d, "Dynamic Update : Data Synced.");
            RtStep.enableRtSteps(getActivity(), this.I, !this.C, this);
            b(true);
        }
    }

    public void onPause() {
        super.onPause();
        this.C = true;
        C0401a.d(getActivity(), C0401a.cH);
        C0401a.b(C0401a.a);
        RtStep.enableRtSteps(getActivity(), this.I, false, this);
    }

    public void onResume() {
        super.onResume();
        this.C = false;
        this.I = this.j.r();
        if (this.J != this.I) {
            this.J = this.I;
            this.k = Keeper.readRealtimeSteps(this.I);
        }
        C0596r.e(d, "Dynamic Update : OnResume. mDeviceType = " + this.I + ",mRtSteps= " + this.k);
        b(true);
        RtStep.enableRtSteps(getActivity(), this.I, true, this);
        C0401a.a(C0401a.a);
        C0401a.c(getActivity(), C0401a.cH);
    }

    public void onStop() {
        super.onStop();
        C0596r.e(d, "onStop................");
        this.C = true;
    }
}
