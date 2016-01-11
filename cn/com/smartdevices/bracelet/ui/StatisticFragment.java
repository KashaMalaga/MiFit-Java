package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.E;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.chart.b.d;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.p;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.datasource.RtStep;
import cn.com.smartdevices.bracelet.eventbus.EventWeightWithUser;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserChanged;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserPicked;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedDevice;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedServer;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import cn.com.smartdevices.bracelet.view.WeightUserQuickPicker;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.RecordWeightActivity;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import kankan.wheel.widget.a;

public class StatisticFragment extends p implements OnClickListener, e {
    private static final String c = "Statistic.Main";
    private static final int d = 1;
    private static final int e = 16;
    private static final int f = 256;
    private static final int g = 11;
    private static final int h = 7;
    private static final int i = 5;
    private static final int j = 7;
    private static final int k = 15;
    private static final int l = 35;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 1;
    private static final int q = 16;
    private ah A;
    private J B;
    private int C;
    private WeightUserQuickPicker D;
    private int E;
    private WeightInfo F;
    private int G = j;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private c N;
    private eZ O;
    private SparseArray<eZ> P;
    private f Q;
    private SparseArray<d> R;
    private boolean S;
    private boolean T;
    private String U;
    private String V;
    private String W;
    private HashMap<String, Summary> X;
    private SparseArray<WeightInfo> Y;
    private View Z;
    private int aA;
    private boolean aB;
    private int aC = o;
    private C0639p aD = null;
    private boolean aE = false;
    private int aF = com.xiaomi.hm.health.bt.b.c.MILI.b();
    private String aG;
    private boolean aH;
    private TextView aa;
    private TextView ab;
    private View ac;
    private View ad;
    private StatisticChartView ae;
    private StatisticChartView af;
    private StatisticChartView ag;
    private ImageButton ah;
    private ImageButton ai = null;
    private ImageButton aj = null;
    private View ak;
    private View al;
    private SparseArray<View> am;
    private SparseArray<View> an;
    private SparseArray<View> ao;
    private View ap;
    private View aq;
    private int ar;
    private int as;
    private int at;
    private Animator au;
    private Animator av;
    private Animator aw;
    private boolean ax;
    private boolean ay;
    private SportDay az;
    public StatisticChartView b;
    private int r;
    private int s;
    private C0591m t;
    private SportDay u;
    private SportDay v;
    private SportDay w;
    private SportDay x;
    private SportDay y;
    private SportDay z;

    public class FadingEdgeScrollView extends ScrollView {
        public FadingEdgeScrollView(Context context) {
            super(context);
        }

        public FadingEdgeScrollView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FadingEdgeScrollView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        protected float getTopFadingEdgeStrength() {
            return 0.0f;
        }
    }

    private Animator a(int i, int i2, long j) {
        Animator b = this.b.b(j / 2, -2.0f, -2.0f);
        b.addListener(new eW(this, j));
        b.setInterpolator(new AccelerateInterpolator(a.bg));
        q.a(b);
        p eXVar = new eX(this);
        View[] viewArr = new View[n];
        viewArr[0] = this.Z;
        viewArr[p] = (View) this.b.getParent();
        q.b(cn.com.smartdevices.bracelet.chart.util.a.a(i, i2, eXVar, viewArr), (j / 3) * 2);
        b = q.a();
        b.addListener(new eK(this));
        return b;
    }

    private Animator a(StatisticChartView statisticChartView, StatisticChartView statisticChartView2, int i, int i2, int i3, int i4, int i5) {
        Animator b = cn.com.smartdevices.bracelet.chart.util.a.b((View) statisticChartView, ((float) i) / ((float) i2), 1.0f);
        Animator b2 = cn.com.smartdevices.bracelet.chart.util.a.b((View) statisticChartView2, 1.0f, ((float) i2) / ((float) i));
        Animator a = cn.com.smartdevices.bracelet.chart.util.a.a((View) statisticChartView2, 1.0f, 0.0f);
        q.a(b, (long) i5);
        q.b(b2, (long) i5);
        q.b(a, (long) i5);
        q.b(statisticChartView.a((long) i5, (float) i3, (float) i4));
        b = q.a();
        b.setInterpolator(new AccelerateDecelerateInterpolator());
        b.addListener(new eL(this, statisticChartView, statisticChartView2));
        return b;
    }

    protected static String a(long j) {
        String str = com.xiaomi.e.a.f;
        return DateFormat.format(cn.com.smartdevices.bracelet.f.f.a(Boolean.valueOf(a(-1, j)), j), j).toString();
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        View view = null;
        View view2 = i == q ? (View) this.am.get(i3) : i == p ? (View) this.an.get(i3) : i == f ? (View) this.ao.get(i3) : null;
        String str2 = com.xiaomi.e.a.f;
        if (i2 == q) {
            view = (View) this.am.get(i4);
            str = C0401a.cN;
        } else if (i2 == p) {
            view = (View) this.an.get(i4);
            str = C0401a.cM;
        } else if (i2 == f) {
            view = (View) this.ao.get(i4);
            str = str2;
        } else {
            str = str2;
        }
        switch (i4) {
            case p /*1*/:
                this.al.setEnabled(true);
                this.ak.setEnabled(false);
                C0401a.a(getActivity(), str, "Level", C0401a.cX);
                break;
            case q /*16*/:
                this.al.setEnabled(true);
                this.ak.setEnabled(true);
                C0401a.a(getActivity(), str, "Level", C0401a.cY);
                break;
            case f /*256*/:
                this.al.setEnabled(false);
                this.ak.setEnabled(true);
                C0401a.a(getActivity(), str, "Level", C0401a.cZ);
                break;
        }
        this.O = (eZ) this.P.get(i4);
        this.aq = view2;
        this.ap = view;
        a(this.b, this.Q, i4);
        a(this.b, i4);
    }

    private void a(int i, int i2, boolean z) {
        a(this.r, this.r, i, i2, z);
    }

    private void a(int i, f fVar, SparseArray<d> sparseArray) {
        cn.com.smartdevices.bracelet.chart.b.a aVar = new cn.com.smartdevices.bracelet.chart.b.a();
        aVar.a(fVar);
        sparseArray.put(i, aVar);
    }

    private void a(int i, boolean z) {
        int i2;
        int i3 = 0;
        if (i == q) {
            this.ah.setVisibility(0);
            this.ai.setVisibility(8);
            this.aj.setVisibility(8);
            this.ah.setImageResource(k.btn_dynamic_mode_step);
            i2 = this.as;
            i3 = i2;
            i2 = this.ar;
        } else if (i == p) {
            this.ah.setVisibility(0);
            this.ai.setVisibility(8);
            this.aj.setVisibility(8);
            this.ah.setImageResource(k.btn_dynamic_mode_sleep);
            i2 = this.ar;
            i3 = i2;
            i2 = this.as;
        } else if (i == f) {
            this.ah.setVisibility(8);
            this.aj.setVisibility(0);
            this.ah.setImageResource(k.btn_statistic_mode_weight_modify);
            i2 = this.as;
            i3 = i2;
            i2 = this.at;
        } else {
            i2 = 0;
        }
        if (z) {
            this.Z.setBackgroundColor(i2);
            ((View) this.b.getParent()).setBackgroundColor(i2);
            ((SystemBarTintActivity) getActivity()).applyStatusBarTint(i2);
            this.ae.a(i);
            if (this.af != null) {
                this.af.a(i);
            }
        } else {
            this.au = a(i3, i2, 650);
            this.au.start();
        }
        if (i != f) {
            a(this.w);
        }
    }

    private void a(long j, boolean z) {
        a(null, j, z);
    }

    private void a(View view) {
        this.Z = view.findViewById(l.header);
        this.aa = (TextView) view.findViewById(l.header_sync_tip);
        this.ab = (TextView) view.findViewById(l.header_sub_title);
        this.ac = view.findViewById(l.share);
        this.ac.setOnClickListener(this);
        this.ad = view.findViewById(l.add_member);
        this.ad.setOnClickListener(this);
        this.ae = (StatisticChartView) view.findViewById(l.statistic_chart);
        this.af = (StatisticChartView) view.findViewById(l.next_statistic_chart);
        this.ah = (ImageButton) view.findViewById(l.mode_switch);
        this.ah.setOnClickListener(this);
        this.ai = (ImageButton) view.findViewById(l.weight_report_edit_btn);
        this.ai.setOnClickListener(this);
        this.aj = (ImageButton) view.findViewById(l.weight_report_dele_btn);
        this.aj.setOnClickListener(this);
        this.al = view.findViewById(l.mode_statistic_zoom_in);
        this.ak = view.findViewById(l.mode_statistic_zoom_out);
        this.al.setOnClickListener(this);
        this.ak.setOnClickListener(this);
        if ((this.aC & p) == 0) {
            this.ah.setVisibility(8);
        }
        if (this.r == f) {
            View findViewById = view.findViewById(l.info_weight_layout);
            this.ao = new SparseArray(o);
            this.ao.put(p, findViewById);
            this.ao.put(q, findViewById);
            this.ao.put(f, findViewById);
            d();
            this.D = (WeightUserQuickPicker) view.findViewById(l.user_picker);
            this.D.setVisibility(0);
            this.D.setOnClickListener(new eP(this));
            this.D.a(new eQ(this));
            this.D.a(this.B.d());
            if (this.E != -1) {
                this.D.b(this.E);
            }
            this.aj.setVisibility(0);
            this.ah.setVisibility(8);
            if (this.C == 0) {
                this.aj.setEnabled(false);
                this.ai.setEnabled(false);
                return;
            } else if (ChartData.a().t() == -1 && this.C == p) {
                this.aj.setEnabled(false);
                this.ai.setEnabled(false);
                return;
            } else {
                this.aj.setEnabled(true);
                this.ai.setEnabled(true);
                return;
            }
        }
        this.aj.setVisibility(8);
        this.ai.setVisibility(8);
        this.ah.setVisibility(0);
        findViewById = view.findViewById(l.info_sleep_daily_layout);
        View findViewById2 = view.findViewById(l.info_sleep_weekly_layout);
        View findViewById3 = view.findViewById(l.info_sleep_monthly_layout);
        View findViewById4 = view.findViewById(l.info_step_daily_layout);
        View findViewById5 = view.findViewById(l.info_step_weekly_layout);
        View findViewById6 = view.findViewById(l.info_step_monthly_layout);
        this.am = new SparseArray(o);
        this.an = new SparseArray(o);
        this.am.put(p, findViewById);
        this.am.put(q, findViewById2);
        this.am.put(f, findViewById3);
        this.an.put(p, findViewById4);
        this.an.put(q, findViewById5);
        this.an.put(f, findViewById6);
        e();
    }

    private void a(View view, int i) {
        WeightInfo f = this.A.f(i);
        if (f != null) {
            this.ae.a(f.weight);
        }
        UserInfo a = this.B.a(i);
        if (a != null) {
            this.ae.b(a.targetWeight);
            b(a.name);
        }
    }

    private void a(StatisticChartView statisticChartView, int i) {
        switch (i) {
            case p /*1*/:
                if (this.r == f) {
                    statisticChartView.c(this.G);
                    return;
                } else {
                    statisticChartView.c((int) g);
                    return;
                }
            case q /*16*/:
                statisticChartView.c((int) j);
                return;
            case f /*256*/:
                statisticChartView.c((int) i);
                return;
            default:
                return;
        }
    }

    private void a(StatisticChartView statisticChartView, f fVar, int i) {
        d dVar = (d) this.R.get(i);
        dVar.a(fVar);
        statisticChartView.a(dVar);
    }

    private void a(WeightInfo weightInfo) {
        aA.a(weightInfo);
        u();
        EventBus eventBus = EventBus.getDefault();
        int[] iArr = new int[p];
        iArr[0] = weightInfo.uid;
        eventBus.post(new EventWeightChanged(iArr));
    }

    private void a(WeightInfo weightInfo, int i) {
        this.A.a(weightInfo, i);
        u();
        C0596r.e(c, "fromUID " + weightInfo.uid + " toUID " + i);
        C0596r.e(c, "timestamp " + weightInfo.timestamp);
        C0596r.e(c, "value in kg" + weightInfo.weight);
        C0596r.e(c, "toUser height " + J.a().a(i).height);
        UserInfo a = J.a().a(weightInfo.uid);
        UserInfo a2 = J.a().a(i);
        float a3 = aA.a(a.height, Birthday.fromStr(a.birthday).getAge(), weightInfo.weight);
        com.xiaomi.hm.health.bt.profile.Weight.e eVar = new com.xiaomi.hm.health.bt.profile.Weight.e();
        eVar.b(aA.c(aA.b(weightInfo.weight, Keeper.readPersonInfo().miliConfig.weightUnit), p));
        eVar.a(a3);
        eVar.a(Keeper.readPersonInfo().miliConfig.weightUnit);
        eVar.a(weightInfo.timestamp);
        C0891z.a(getActivity()).a(eVar, a2, aA.a(weightInfo.timestamp, weightInfo.uid));
        EventBus eventBus = EventBus.getDefault();
        int[] iArr = new int[n];
        iArr[0] = weightInfo.uid;
        iArr[p] = i;
        eventBus.post(new EventWeightChanged(iArr));
    }

    private void a(HwSyncDataStatus hwSyncDataStatus) {
        C0596r.e(c, "Current Sync Status : " + hwSyncDataStatus + ",type = " + hwSyncDataStatus.h());
        if (this.r != f && this.aF == hwSyncDataStatus.h().b()) {
            TextView textView;
            Object[] objArr;
            if (hwSyncDataStatus.b()) {
                textView = this.aa;
                objArr = new Object[p];
                objArr[0] = Integer.valueOf(0);
                textView.setText(getString(r.dynamic_tip_sync_progress, objArr));
            } else if (hwSyncDataStatus.c()) {
                textView = this.aa;
                objArr = new Object[p];
                objArr[0] = Integer.valueOf(hwSyncDataStatus.f());
                textView.setText(getString(r.dynamic_tip_sync_progress, objArr));
            } else {
                this.aa.setText(Utils.a(getActivity(), (int) r.dynamic_tip_sync_time, this.aF));
            }
        }
    }

    private void a(SportDay sportDay) {
        a(sportDay, 0, false);
    }

    private void a(SportDay sportDay, long j, boolean z) {
        String str = null;
        Object[] objArr;
        if (this.r == q) {
            if (this.O != null) {
                str = this.U;
                objArr = new Object[p];
                objArr[0] = this.O.a(sportDay);
                str = String.format(str, objArr);
            }
        } else if (this.r == p) {
            if (this.O != null) {
                str = this.V;
                objArr = new Object[p];
                objArr[0] = this.O.a(sportDay);
                str = String.format(str, objArr);
            }
        } else if (this.r == f && this.O != null) {
            CharSequence format = DateFormat.format(cn.com.smartdevices.bracelet.f.f.a(Boolean.valueOf(z), j), j);
            String str2 = this.W;
            Object[] objArr2 = new Object[p];
            objArr2[0] = format;
            str = String.format(str2, objArr2);
        }
        a(str);
        if ((this.s == p && sportDay.equals(this.u)) || ((this.s == q && sportDay.offsetWeek(this.u) == 0) || (this.s == f && sportDay.offsetMonth(this.u) == 0))) {
            ((View) this.aa.getParent()).setVisibility(0);
        } else {
            ((View) this.aa.getParent()).setVisibility(8);
        }
    }

    private void a(boolean z, int i) {
        this.S = true;
        d m = this.b.m();
        m.b();
        if (z) {
            m.c();
            this.b.e();
        }
        this.b.c(true);
        this.b.d(i);
        if (i != 0) {
            this.b.f(i);
        }
    }

    protected static boolean a(long j, long j2) {
        Calendar instance;
        Calendar instance2;
        if (j < 0) {
            instance = Calendar.getInstance();
            instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return instance.get(p) != instance2.get(p);
        } else {
            instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return instance.get(p) != instance2.get(p);
        }
    }

    private Animator b(StatisticChartView statisticChartView, StatisticChartView statisticChartView2, int i, int i2, int i3, int i4, int i5) {
        float f = ((float) i) / ((float) i2);
        Animator a = cn.com.smartdevices.bracelet.chart.util.a.a((View) statisticChartView, 0.0f, 1.0f);
        Animator b = cn.com.smartdevices.bracelet.chart.util.a.b((View) statisticChartView, f, 1.0f);
        Animator b2 = cn.com.smartdevices.bracelet.chart.util.a.b((View) statisticChartView2, 1.0f, ((float) i2) / ((float) i));
        q.a(b, (long) i5);
        q.b(a, (long) i5);
        q.b(b2, (long) i5);
        q.b(statisticChartView2.b((long) i5, (float) i3, (float) i4));
        b = q.a();
        b.setInterpolator(new AccelerateDecelerateInterpolator());
        b.addListener(new eM(this, statisticChartView, statisticChartView2));
        return b;
    }

    private void b(int i, boolean z) {
        a(this.r, this.r, i, i, z);
    }

    private void b(String str) {
        String str2 = this.W;
        Object[] objArr = new Object[p];
        objArr[0] = com.xiaomi.e.a.f;
        a(String.format(str2, objArr));
        this.ab.setText(str);
    }

    private void c(int i) {
        a(true, i);
    }

    private boolean c() {
        return this.aF != com.xiaomi.hm.health.bt.b.c.SHOES.b() && ChartData.a().x();
    }

    private void d() {
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.ao.get(p));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.ao.get(q));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.ao.get(f));
    }

    private void d(int i) {
    }

    private void e() {
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.am.get(p));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.am.get(q));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.am.get(f));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.an.get(p));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.an.get(q));
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.an.get(f));
    }

    private void e(int i) {
        Animator b = this.b.b(220, t.a(getActivity(), 185.0f), GroundOverlayOptions.NO_DIMENSION);
        b.setInterpolator(new AccelerateInterpolator());
        b.start();
        this.b.postDelayed(new eO(this, i), b.getDuration() + 50);
        EventBus.getDefault().post(new EventUserChanged(i));
    }

    private void f() {
        this.Q = g();
        this.R = new SparseArray(o);
        a((int) p, this.Q, this.R);
        a((int) q, this.Q, this.R);
        a((int) f, this.Q, this.R);
        int daySportGoalSteps = Keeper.readPersonInfo().getDaySportGoalSteps();
        this.ae.d(true);
        this.ae.e(daySportGoalSteps);
        this.ae.h();
        if (this.af != null) {
            this.af.d(true);
            this.af.e(daySportGoalSteps);
            this.af.h();
            this.af.setVisibility(4);
        }
        this.b = this.ae;
        this.P = new SparseArray(o);
        this.P.put(p, new fa(this));
        this.P.put(q, new fc(this));
        this.P.put(f, new fb(this));
    }

    private f g() {
        return new eR(this);
    }

    private void h() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.ap;
        for (i = o; i <= i; i += p) {
            if (this.s == p) {
                viewGroup.getChildAt(i).setVisibility(4);
            } else {
                viewGroup.getChildAt(i).setVisibility(8);
            }
        }
        for (i = 6; i <= 8; i += p) {
            viewGroup.getChildAt(i).setVisibility(8);
        }
    }

    private void i() {
        if (this.aD == null) {
            this.aD = new C0639p(getActivity());
        }
        this.aD.h();
        C0401a.a(getActivity(), C0409b.bz);
    }

    private void j() {
        DialogFragment eYVar = new eY();
        eYVar.setOpClickListener(new eT(this, eYVar));
        Bundle bundle = new Bundle();
        Object[] objArr = new Object[p];
        objArr[0] = DateFormat.format(cn.com.smartdevices.bracelet.f.f.a(Boolean.valueOf(true), this.F.timestamp), this.F.timestamp);
        bundle.putString("Msg", getString(r.weight_delete_confirm_msg, objArr));
        com.huami.android.view.c.showPanel(getActivity(), eYVar, bundle);
    }

    private void k() {
    }

    private void l() {
        Parcelable m = m();
        Intent intent = new Intent();
        intent.setClass(getActivity(), ShareActivity.class);
        intent.putExtra("share_data", m);
        getActivity().startActivity(intent);
        C0401a.a(getActivity(), C0401a.aZ, C0401a.cw);
    }

    private ShareData m() {
        return this.O.a(this.w, this.r);
    }

    private void n() {
        if (this.au != null && this.au.isStarted()) {
            return;
        }
        if (this.av == null || !this.av.isStarted()) {
            this.ae.d(false);
            this.af.d(false);
            String str = com.xiaomi.e.a.f;
            int i = this.r;
            if (i == q) {
                this.r = p;
                str = C0401a.cO;
            } else if (i == p) {
                this.r = q;
                str = C0401a.cP;
            }
            C0401a.c(str);
            a(this.r, false);
            a(i, this.r, this.s, this.s, false);
            cn.com.smartdevices.bracelet.chart.util.a.b((ViewGroup) this.aq, (ViewGroup) this.ap);
        }
    }

    private void o() {
        if (this.aH) {
            C0401a.a(getActivity(), C0409b.bA);
        }
        if (this.av != null && this.av.isStarted()) {
            return;
        }
        if (this.au != null && this.au.isStarted()) {
            return;
        }
        if (this.aw != null && this.aw.isStarted()) {
            return;
        }
        if (this.r != f) {
            this.N = this.b.a(this.r, this.I);
            if (this.N != null) {
                this.L = (int) this.N.m().height();
                int i = this.N.b;
                this.M = (int) ((((float) ((E) this.N).a) / ((float) i)) * ((float) this.L));
            } else {
                this.L = 0;
                this.M = 0;
            }
            C0596r.e(c, "BarItem Height : " + this.L);
            int i2 = this.s;
            if (this.s == f) {
                this.s = q;
                this.K = this.w.offsetWeek(this.v);
                C0596r.e(c, "Offset Week From Month : " + this.K);
                this.b = this.af;
                this.ag = this.ae;
            } else if (this.s == q) {
                this.s = p;
                this.K = this.w.offsetDay(this.v);
                C0596r.e(c, "Offset Day : " + this.K);
                this.b = this.ae;
                this.ag = this.af;
            }
            if (this.I != this.J) {
                this.z = this.w;
            }
            this.J = Integer.MAX_VALUE;
            a(i2, this.s, false);
            this.ae.d(false);
            this.af.d(false);
            this.b.e();
            this.b.d(this.K);
            this.b.f(this.K);
            this.ax = true;
            this.ay = true;
        } else if (!this.H && this.C != 0) {
            this.H = true;
            if (this.G == l) {
                this.G = k;
                this.al.setEnabled(true);
            } else if (this.G == k) {
                this.G = j;
                this.ak.setEnabled(false);
            }
            a(this.b, this.s);
            Animator b = this.b.b(220, t.a(getActivity(), 185.0f), GroundOverlayOptions.NO_DIMENSION);
            b.setInterpolator(new AccelerateInterpolator());
            b.start();
            this.b.postDelayed(new eU(this), b.getDuration() + 50);
        }
    }

    private void p() {
        if (this.aH) {
            C0401a.a(getActivity(), C0409b.bA);
        }
    }

    private void q() {
        if (this.aH) {
            C0401a.a(getActivity(), C0409b.bA);
        }
        if (this.av != null && this.av.isStarted()) {
            return;
        }
        if (this.au != null && this.au.isStarted()) {
            return;
        }
        if (this.aw != null && this.aw.isStarted()) {
            return;
        }
        if (this.r != f) {
            int i = this.s;
            if (this.s == p) {
                this.s = q;
                this.K = this.w.offsetWeek(this.v);
                C0596r.e(c, "Offset Week From Day : " + this.K);
                this.b = this.af;
                this.ag = this.ae;
            } else if (this.s == q) {
                this.s = f;
                this.K = this.w.offsetMonth(this.v);
                C0596r.e(c, "Offset Month : " + this.K);
                this.b = this.ae;
                this.ag = this.af;
            }
            this.I = Integer.MAX_VALUE;
            this.J = Integer.MAX_VALUE;
            this.z = this.w;
            a(i, this.s, false);
            this.ae.d(false);
            this.af.d(false);
            this.b.e();
            this.b.d(this.K);
            this.b.f(this.K);
            this.ax = true;
            this.ay = false;
        } else if (!this.H && this.C != 0) {
            this.H = true;
            if (this.G == j) {
                this.G = k;
                this.ak.setEnabled(true);
            } else if (this.G == k) {
                this.G = l;
                this.al.setEnabled(false);
            }
            a(this.b, this.s);
            Animator b = this.b.b(220, t.a(getActivity(), 185.0f), GroundOverlayOptions.NO_DIMENSION);
            b.setInterpolator(new AccelerateInterpolator());
            b.start();
            this.b.postDelayed(new eV(this), b.getDuration() + 50);
        }
    }

    private void r() {
        C0596r.e(c, "Current Index : " + this.I + " Last Index : " + this.J);
        C0596r.e(c, "Current Day : " + this.w + " Last Day : " + this.z);
    }

    private void s() {
        a(true, 0);
    }

    private void t() {
        this.X.clear();
        s();
    }

    private void u() {
        this.C = this.A.b(this.E);
        C0596r.e(c, "WeightItemsCount : " + this.C + ", WeightCurrentUserId : " + this.E);
        if (this.C == 0) {
            this.K = 0;
            this.b.c();
            this.O.b();
            this.aj.setEnabled(false);
            this.ai.setEnabled(false);
            this.H = false;
        } else {
            if (this.K < (-(this.C - 1))) {
                this.K = -(this.C - 1);
            }
            if (this.C == p) {
                WeightInfo f = this.A.f(this.E);
                if (f != null) {
                    this.ae.a(f.weight);
                }
            }
            if (this.E == -1 && this.C == p) {
                this.aj.setEnabled(false);
                this.ai.setEnabled(false);
            } else {
                this.aj.setEnabled(true);
                this.ai.setEnabled(true);
            }
        }
        this.Y.clear();
        c(this.K);
    }

    public void a(int i) {
        C0596r.e(c, "Realtime Steps Updated : " + i);
        if (i > -1) {
            Keeper.keepRealtimeStepsTimestamp(System.currentTimeMillis(), this.aF);
            Keeper.keepRealtimeSteps(i, this.aF);
            ChartData.a().a(i, this.aF);
            if (this.u != null && this.w != null && this.u.equals(this.w) && getActivity() != null) {
                getActivity().runOnUiThread(new eN(this));
            }
        }
    }

    protected boolean b() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.r == f) {
            ((ViewStub) getView().findViewById(l.chart_weight_layout)).inflate();
        } else {
            ((ViewStub) getView().findViewById(l.chart_stepsleep_layout)).inflate();
        }
        a(getView());
        f();
        this.S = true;
        this.T = true;
        a(this.r, true);
        b(this.s, true);
        cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) this.aq, (ViewGroup) this.ap);
        this.b.c(true);
        this.b.post(new eJ(this));
        if (this.r == f) {
            this.ac.setVisibility(4);
            this.ad.setVisibility(0);
            a(this.D, this.E);
        }
        this.aG = getActivity().getIntent().getStringExtra(StatisticActivity.EXTRA_SYNC_ACTION);
        if (!TextUtils.isEmpty(this.aG) && this.r == p) {
            this.ac.setVisibility(8);
            View findViewById = getView().findViewById(l.sync);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
            this.aH = true;
        }
        EventBus.getDefault().register(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("UserId", -1);
            C0596r.e(c, "Weight User Picked : " + intExtra);
            if (i == p && this.E != intExtra) {
                this.D.b(intExtra);
                e(intExtra);
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.share /*2131296541*/:
                l();
                return;
            case l.weight_report_dele_btn /*2131296856*/:
                j();
                return;
            case l.mode_switch /*2131296976*/:
                if (this.r != f) {
                    n();
                    return;
                }
                return;
            case l.add_member /*2131297232*/:
                Intent intent = new Intent(getActivity(), RecordWeightActivity.class);
                intent.putExtra(WeightGoalSetActivity.a, this.E);
                getActivity().startActivity(intent);
                C0401a.a(getActivity().getApplicationContext(), C0401a.gr, C0401a.gu);
                return;
            case l.sync /*2131297233*/:
                i();
                return;
            case l.mode_statistic_zoom_in /*2131297236*/:
                q();
                return;
            case l.weight_report_edit_btn /*2131297238*/:
                k();
                return;
            case l.mode_statistic_zoom_out /*2131297239*/:
                o();
                return;
            case l.user_picker /*2131297248*/:
                d((int) p);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getInt(ChartData.KEY_MODE, p);
            this.aE = arguments.getBoolean("FROM_PERSONINFO_FRAGMENT", false);
            this.aF = arguments.getInt(ChartData.KEY_SOURCE, com.xiaomi.hm.health.bt.b.c.VDEVICE.b());
            if (this.aF == com.xiaomi.hm.health.bt.b.c.VDEVICE.b()) {
                this.aF = C0591m.a().r();
            }
            C0596r.e(c, "Mode : " + this.r + ",DeviceType:" + this.aF);
            if (DeviceSource.hasBindSensorHub() && !C0591m.a().j()) {
                this.aC &= -2;
            }
        }
        this.s = p;
        this.t = C0591m.a();
        this.u = this.t.d(this.aF);
        this.v = this.t.c(this.aF);
        this.x = this.t.a(this.aF);
        this.y = this.t.b(this.aF);
        if (this.r == f) {
            this.A = ah.a();
            this.B = J.a();
            if (this.aE) {
                this.E = -1;
            } else {
                int t = ChartData.a().t();
                if (t != 0) {
                    i = t;
                }
                this.E = i;
            }
            this.C = this.A.b(this.E);
            this.x = this.A.i();
            this.y = this.A.j();
            this.v = this.y;
        }
        this.w = this.v;
        C0596r.e(c, "Today : " + this.u + " , StartDay : " + this.x + " , StopDay : " + this.y + " , CurrentDay : " + this.w);
        this.U = getString(r.dynamic_detail_sleep_title);
        this.V = getString(r.dynamic_detail_step_title);
        this.W = getString(r.dynamic_detail_weight_title);
        this.X = new HashMap();
        this.Y = new SparseArray();
        this.aB = Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString());
        SportDay.onLocaleChanged(this.aB);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_statistic, viewGroup, false);
        Resources resources = getActivity().getResources();
        this.ar = resources.getColor(i.bg_mode_sleep);
        this.as = resources.getColor(i.bg_mode_step);
        this.at = resources.getColor(i.bg_mode_weight);
        return inflate;
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        this.ae.i();
        if (this.af != null) {
            this.af.i();
        }
    }

    public void onEvent(EventWeightWithUser eventWeightWithUser) {
        int i = eventWeightWithUser.uid;
        if (this.E != i) {
            this.D.b(i);
            e(i);
            return;
        }
        u();
    }

    public void onEvent(EventUserPicked eventUserPicked) {
        C0596r.e(c, "EventWeightUserPicked " + eventUserPicked.uid + ", Action : " + eventUserPicked.action);
        int i = eventUserPicked.uid;
        switch (eventUserPicked.action) {
            case p /*1*/:
                a(this.F, i);
                return;
            case n /*2*/:
                if (this.E != i) {
                    this.D.b(i);
                    e(i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onEvent(EventWeightSyncedDevice eventWeightSyncedDevice) {
        C0596r.e(c, "EventWeightSyncedDevice : " + eventWeightSyncedDevice.forceUpdate + ", " + eventWeightSyncedDevice.uid);
        if (eventWeightSyncedDevice.forceUpdate || eventWeightSyncedDevice.uid == this.E) {
            u();
        }
    }

    public void onEvent(EventWeightSyncedServer eventWeightSyncedServer) {
        C0596r.e(c, "EventWeightSyncedServer : " + eventWeightSyncedServer.state);
        if (eventWeightSyncedServer.state == p) {
            u();
        }
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(c, "On BLE Status Changed : " + hwConnStatus + ",type = " + hwConnStatus.b());
        if (this.aF == hwConnStatus.b().b()) {
            if (this.aF == com.xiaomi.hm.health.bt.b.c.SHOES.b()) {
                if (hwConnStatus.e()) {
                    this.aa.setText(getString(r.shoes_connecting));
                } else if (hwConnStatus.f()) {
                    this.aa.setText(getString(r.shoes_alert_body_connect_failed));
                } else if (hwConnStatus.h()) {
                    this.aa.setText(getString(r.shoes_connect_failed));
                }
            } else if (hwConnStatus.k()) {
                C0596r.e(c, "Enable Realtime Steps : " + isVisible());
                if (c()) {
                    RtStep.enableRtSteps(getActivity(), this.aF, isVisible(), this);
                }
            }
        }
    }

    public void onEvent(HwSyncDataStatus hwSyncDataStatus) {
        C0596r.e(c, "On BLE Status Changed : " + hwSyncDataStatus + ",type = " + hwSyncDataStatus.h());
        if (this.aF == hwSyncDataStatus.h().b()) {
            if (hwSyncDataStatus.d() && isAdded()) {
                C0596r.e(c, "Enable Realtime Steps : " + isVisible());
                if (c()) {
                    RtStep.enableRtSteps(getActivity(), this.aF, isVisible(), this);
                }
            }
            if (isVisible() && this.r != f) {
                a(hwSyncDataStatus);
                if (hwSyncDataStatus.d() && hwSyncDataStatus.g()) {
                    t();
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        C0596r.e(c, "Enable Realtime Steps : false");
        if (c()) {
            RtStep.enableRtSteps(getActivity(), this.aF, false, this);
        }
        C0401a.b(C0401a.e);
    }

    public void onResume() {
        super.onResume();
        if (this.aF == com.xiaomi.hm.health.bt.b.c.SHOES.b()) {
            a(new HwSyncDataStatus(com.xiaomi.hm.health.bt.b.c.SHOES));
        } else {
            a(F.b);
        }
        C0596r.e(c, "Enable Realtime Steps : true");
        if (c()) {
            RtStep.enableRtSteps(getActivity(), this.aF, true, this);
        }
        C0401a.a(C0401a.e);
    }

    public void onStop() {
        super.onStop();
        if (this.aD != null) {
            this.aD.a();
            this.aD = null;
        }
    }
}
