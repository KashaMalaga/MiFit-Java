package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.af;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.C0420j;
import cn.com.smartdevices.bracelet.chart.C0422l;
import cn.com.smartdevices.bracelet.chart.C0423m;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.b.d;
import cn.com.smartdevices.bracelet.chart.n;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.p;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.chart.util.r;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.RtStep;
import cn.com.smartdevices.bracelet.datasource.a;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.shoes.model.i;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.dataprocess.ActiveItem;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StageSleep;
import com.xiaomi.hm.health.dataprocess.StageSteps;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.dataprocess.UserSleepModify;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class C0681ak extends p implements OnClickListener, e {
    private static int ae = 0;
    private static int af = 0;
    public static final int b = 1;
    public static final int c = 16;
    public static final String d = "CurrentDay";
    public static final String e = "Type";
    public static final String f = "MinHour";
    public static final String g = "MaxHour";
    public static final String h = "CurrentHour";
    public static final String i = "CurrentMinute";
    public static final String j = "LimitStart";
    public static final String k = "LimitEnd";
    public static Handler l = null;
    private static final String m = "Dynamic.Detail";
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 4;
    private static final int q = 8;
    private static final int r = 13;
    private View A;
    private DynamicDetailChartView B;
    private TextView C;
    private View D;
    private View E;
    private View F;
    private View G;
    private GestureDetector H;
    private a I = C0591m.a();
    private SportDay J = new SportDay();
    private SportDay K = new SportDay();
    private SportDay L = new SportDay();
    private SportDay M = new SportDay();
    private int N;
    private int O;
    private String P;
    private String Q;
    private int R;
    private int S;
    private Animator T;
    private Animator U;
    private Animator V;
    private boolean W;
    private String X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ag = r;
    private b ah = b.h();
    private View s;
    private TextView t;
    private View u;
    private ImageButton v;
    private View w;
    private View x;
    private View y;
    private View z;

    private static int a(Calendar calendar) {
        return -((((24 - calendar.get(11)) - 1) * 60) + (60 - calendar.get(12)));
    }

    private Animator a(float f, float f2, View view) {
        Animator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        Animator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.0f, 1.0f});
        Animator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.0f, 1.0f});
        q.a(ofFloat);
        q.b(ofFloat2);
        q.b(ofFloat3);
        ofFloat = q.a();
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    private Animator a(int i, int i2, View view, View view2, int i3, long j, boolean z) {
        q.a(this.B.a(), j);
        if (!z) {
            p c0688ar = new C0688ar(this);
            View[] viewArr = new View[o];
            viewArr[0] = this.s;
            viewArr[n] = this.B;
            q.b(cn.com.smartdevices.bracelet.chart.util.a.a(i, i2, c0688ar, viewArr), j / 2);
        }
        Animator a = q.a();
        a.addListener(new C0689as(this));
        return a;
    }

    public static C0420j a(a aVar, SportDay sportDay, int i) {
        C0420j c0420j = new C0420j();
        aVar.i(sportDay);
        DaySportData g = aVar.g(sportDay);
        if (g != null) {
            ArrayList stageSteps;
            List arrayList;
            Iterator it;
            if (i == n) {
                StepsInfo stepsInfo = g.getStepsInfo();
                if (stepsInfo == null) {
                    stepsInfo = new StepsInfo();
                }
                stageSteps = stepsInfo.getStageSteps();
                arrayList = new ArrayList();
                it = stageSteps.iterator();
                while (it.hasNext()) {
                    StageSteps stageSteps2 = (StageSteps) it.next();
                    if (stageSteps2.steps != 0) {
                        n nVar = new n();
                        nVar.a = stageSteps2.time;
                        nVar.b = stageSteps2.steps;
                        arrayList.add(nVar);
                    }
                }
                c0420j.d = arrayList;
            } else if (i == c) {
                SleepInfo sleepInfo = g.getSleepInfo();
                if (sleepInfo == null) {
                    sleepInfo = new SleepInfo();
                }
                C0681ak.a(sportDay, g);
                stageSteps = sleepInfo.getStageSleep();
                arrayList = new ArrayList();
                it = stageSteps.iterator();
                while (it.hasNext()) {
                    StageSleep stageSleep = (StageSleep) it.next();
                    C0422l c0422l = new C0422l();
                    c0422l.f = stageSleep.start - 1440;
                    c0422l.g = (stageSleep.stop - stageSleep.start) + n;
                    switch (stageSleep.mode) {
                        case p /*4*/:
                            c0422l.e = o;
                            break;
                        case kankan.wheel.widget.a.X /*5*/:
                            c0422l.e = 3;
                            break;
                        case kankan.wheel.widget.a.bc /*7*/:
                            c0422l.e = n;
                            break;
                        case kankan.wheel.widget.a.ar /*100*/:
                            c0422l.e = p;
                            break;
                        default:
                            break;
                    }
                    arrayList.add(c0422l);
                }
                c0420j.c = arrayList;
            }
        }
        return c0420j;
    }

    private static C0420j a(DaySportData daySportData, int i) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i2 = -1;
        n nVar = null;
        Iterator it = daySportData.getAnalysisData().iterator();
        int i3 = -1;
        C0422l c0422l = null;
        while (it.hasNext()) {
            C0422l c0422l2;
            int i4;
            n nVar2;
            int i5;
            SportData sportData = (SportData) it.next();
            int sportMode = sportData.getSportMode();
            int step = sportData.getStep();
            int timeIndex = sportData.getTimeIndex();
            if (i3 != sportMode || timeIndex == 1439) {
                if (c0422l != null) {
                    c0422l.g = timeIndex - c0422l.f;
                    c0422l2 = null;
                } else {
                    c0422l2 = c0422l;
                }
                if (sportMode == p || sportMode == 5 || sportMode == 7 || sportMode == 100) {
                    c0422l2 = new C0422l();
                    arrayList.add(c0422l2);
                    c0422l2.f = timeIndex;
                    c0422l2.g = n;
                    switch (sportMode) {
                        case p /*4*/:
                            c0422l2.e = o;
                            i4 = sportMode;
                            break;
                        case kankan.wheel.widget.a.X /*5*/:
                            c0422l2.e = 3;
                            i4 = sportMode;
                            break;
                        case kankan.wheel.widget.a.bc /*7*/:
                            c0422l2.e = n;
                            i4 = sportMode;
                            break;
                        case kankan.wheel.widget.a.ar /*100*/:
                            c0422l2.e = p;
                            i4 = sportMode;
                            break;
                    }
                }
                i4 = sportMode;
            } else {
                i4 = i3;
                c0422l2 = c0422l;
            }
            if (!(sportMode == p || sportMode == 5 || step <= 0)) {
                int i6 = timeIndex / 60;
                if (i6 != i2) {
                    nVar2 = new n();
                    arrayList2.add(nVar2);
                    nVar2.a = i6;
                    nVar2.b = step;
                    i5 = i6;
                    c0422l = c0422l2;
                    i2 = i5;
                    nVar = nVar2;
                    i3 = i4;
                } else {
                    nVar.b += step;
                }
            }
            nVar2 = nVar;
            i5 = i2;
            c0422l = c0422l2;
            i2 = i5;
            nVar = nVar2;
            i3 = i4;
        }
        C0420j c0420j = new C0420j();
        if (i == c) {
            c0420j.c = arrayList;
        } else if (i == n) {
            c0420j.d = arrayList2;
        }
        return c0420j;
    }

    private ActiveItem a(StepsInfo stepsInfo, int i) {
        ArrayList activeList = stepsInfo.getActiveList();
        if (activeList != null) {
            Iterator it = activeList.iterator();
            while (it.hasNext()) {
                ActiveItem activeItem = (ActiveItem) it.next();
                if (activeItem.getKey() == i) {
                    return activeItem;
                }
            }
        }
        return null;
    }

    private static List<C0422l> a(List<C0422l> list, int i, int i2) {
        Collections.sort(list, new C0423m());
        List<C0422l> arrayList = new ArrayList();
        C0422l c0422l = null;
        for (C0422l c0422l2 : list) {
            C0422l c0422l22;
            C0596r.e(m, "Sleep : " + c0422l22.f + " , " + c0422l22.g + " , " + c0422l22.e);
            if (c0422l22.f >= i) {
                int i3;
                C0422l c0422l3;
                if (c0422l != null) {
                    i3 = c0422l.f + c0422l.g;
                    if (i3 == c0422l22.f && c0422l.e == c0422l22.e) {
                        c0422l3 = new C0422l();
                        c0422l3.f = c0422l.f;
                        c0422l3.g = (c0422l22.f + c0422l22.g) - c0422l.f;
                        c0422l3.e = c0422l22.e;
                        C0596r.e(m, "Sleep Merge : " + c0422l3.f + " , " + c0422l3.g + " , " + c0422l3.e);
                        arrayList.remove(c0422l);
                        arrayList.add(c0422l3);
                        c0422l22 = c0422l3;
                    } else {
                        if (i3 != c0422l22.f && i3 > i && i3 < i2) {
                            c0422l = new C0422l();
                            c0422l.f = i3;
                            c0422l.g = c0422l22.f - i3;
                            c0422l.e = n;
                            C0596r.e(m, "Sleep Active : " + c0422l.f + " , " + c0422l.g + " , " + c0422l.e);
                            arrayList.add(c0422l);
                        }
                        arrayList.add(c0422l22);
                    }
                } else {
                    i3 = c0422l22.f + c0422l22.g;
                    if (c0422l22.f > i && i3 < i2) {
                        c0422l3 = new C0422l();
                        c0422l3.f = i;
                        c0422l3.g = c0422l22.f - i;
                        c0422l3.e = n;
                        C0596r.e(m, "Sleep Active : " + c0422l3.f + " , " + c0422l3.g + " , " + c0422l3.e);
                        arrayList.add(c0422l3);
                    }
                    arrayList.add(c0422l22);
                }
                c0422l = c0422l22;
            }
        }
        return arrayList;
    }

    private void a(int i, SportDay sportDay) {
        Date startDate;
        int i2;
        int i3;
        int i4;
        int i5;
        Date date = null;
        int i6 = 23;
        C0596r.e(m, "Show Modify Sleep Time : " + i);
        DaySportData g = this.I.g(sportDay);
        SleepInfo sleepInfo = g != null ? g.getSleepInfo() : null;
        SleepInfo sleepInfo2 = sleepInfo == null ? new SleepInfo() : sleepInfo;
        switch (i) {
            case n /*1*/:
                startDate = sleepInfo2.getStartDate();
                date = sleepInfo2.getStopDate();
                break;
            case c /*16*/:
                startDate = sleepInfo2.getStopDate();
                date = sleepInfo2.getStartDate();
                break;
            default:
                startDate = null;
                break;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(startDate);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        int a = sportDay.addDay(-1).equals(instance) ? C0681ak.a(instance) : C0681ak.b(instance);
        int a2 = sportDay.addDay(-1).equals(instance2) ? C0681ak.a(instance2) : C0681ak.b(instance2);
        if (a < 0) {
            i2 = ((a + n) / 60) - 1;
            a %= 60;
            if (a != 0) {
                i3 = a + 60;
                i4 = i2;
            } else {
                i3 = a;
                i4 = i2;
            }
        } else {
            i3 = a % 60;
            i4 = a / 60;
        }
        int i7 = i4 - 6;
        a = i4 + 6;
        if (i7 < -24) {
            i7 = -24;
        }
        if (a > 23) {
            a = 23;
        }
        UserSleepModify a3 = ChartData.a().a(sportDay);
        int i8 = 0;
        i2 = 0;
        switch (i) {
            case n /*1*/:
                i8 = a3.sleepStart;
                i2 = a3.sleepEnd;
                i5 = af.a;
                break;
            case c /*16*/:
                i8 = a3.sleepEnd;
                i2 = a3.sleepStart;
                i5 = a2;
                a2 = af.a;
                break;
            default:
                a2 = af.a;
                i5 = af.a;
                break;
        }
        if (sleepInfo2.getHasSleep() || r3 != af.a) {
            i6 = a;
            a = i7;
        } else if (i2 == af.a) {
            a2 = af.a;
            i5 = af.a;
            a = -24;
        } else {
            a = -24;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(d, sportDay);
        bundle.putInt(e, i);
        bundle.putInt(f, a);
        bundle.putInt(g, i6);
        bundle.putInt(h, i4);
        bundle.putInt(i, i3);
        bundle.putInt(j, i5);
        bundle.putInt(k, a2);
        c.showPanel(getActivity(), C0693aw.class, bundle);
    }

    private void a(int i, boolean z) {
        View view;
        int i2;
        int i3;
        int i4;
        View view2 = null;
        if (i == c) {
            b(R.string.dynamic_detail_sleep_title_yesterday);
            this.v.setImageResource(R.drawable.btn_dynamic_mode_step);
            view = this.x;
            view2 = this.w;
            i2 = this.S;
            i3 = this.R;
            e();
            i4 = cn.com.smartdevices.bracelet.chart.util.a.g;
        } else if (i == n) {
            if ((this.ag & o) == 0) {
                d(this.O);
            }
            this.v.setImageResource(R.drawable.btn_dynamic_mode_sleep);
            view = this.w;
            view2 = this.x;
            i2 = this.R;
            i3 = this.S;
            if ((this.ag & o) > 0) {
                view2 = this.y;
                i4 = cn.com.smartdevices.bracelet.chart.util.a.h;
            } else {
                i4 = cn.com.smartdevices.bracelet.chart.util.a.h;
            }
        } else {
            i4 = 0;
            view = null;
            i3 = 0;
            i2 = 0;
        }
        this.B.a(i);
        int a = (int) (160.0f * t.a(getActivity()));
        if (z) {
            this.s.setBackgroundColor(i3);
            this.B.setBackgroundColor(i3);
            ((SystemBarTintActivity) getActivity()).applyStatusBarTint(i3);
            cn.com.smartdevices.bracelet.chart.util.a.a((ViewGroup) view, (ViewGroup) view2);
            if ((this.ag & p) == 0) {
                b(view2);
            }
        } else {
            view.setVisibility(0);
            view2.setVisibility(0);
            cn.com.smartdevices.bracelet.chart.util.a.b((ViewGroup) view, (ViewGroup) view2);
        }
        this.T = a(i2, i3, view, view2, a, (long) i4, z);
    }

    private void a(View view) {
        this.s = view.findViewById(R.id.header);
        this.t = (TextView) view.findViewById(R.id.header_sync_tip);
        this.u = view.findViewById(R.id.share);
        this.u.setOnClickListener(this);
        this.v = (ImageButton) view.findViewById(R.id.mode_switch);
        this.v.setOnClickListener(this);
        this.w = view.findViewById(R.id.info_sleep_layout);
        this.x = view.findViewById(R.id.info_step_layout);
        this.z = view.findViewById(R.id.float_sleep_info);
        this.A = view.findViewById(R.id.float_step_info);
        this.B = (DynamicDetailChartView) view.findViewById(R.id.day_active_chart);
        this.C = (TextView) view.findViewById(R.id.data_state_tip);
        this.D = view.findViewById(R.id.modify_sleep_start);
        this.E = view.findViewById(R.id.modify_sleep_end);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F = view.findViewById(R.id.btn_prev);
        this.G = view.findViewById(R.id.btn_next);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H = new GestureDetector(getActivity(), new C0684an(this));
        d aVar = new cn.com.smartdevices.bracelet.chart.b.a();
        aVar.a(f());
        this.B.a(aVar);
        this.B.d(true);
        if ((this.ag & q) == 0) {
            this.B.d(false);
        }
        if ((this.ag & n) == 0) {
            ((View) this.v.getParent()).setVisibility(q);
        }
        if ((this.ag & o) > 0) {
            this.y = ((ViewStub) view.findViewById(R.id.info_step_piece_layout)).inflate();
            this.x.setVisibility(q);
            this.w.setVisibility(q);
            ((View) this.y.getParent()).setVisibility(0);
        }
        if (this.O == com.xiaomi.hm.health.bt.b.c.SENSORHUB.b()) {
            this.v.setVisibility(q);
            view.findViewById(R.id.layout_prev_next).setVisibility(0);
            view.findViewById(R.id.header_sync_tip_split).setVisibility(q);
            this.t.setVisibility(q);
        }
        this.B.h();
        if (((this.ag & p) == 0 || t.a()) && (this.ag & n) == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.B.getLayoutParams();
            marginLayoutParams.height = getResources().getDimensionPixelSize(R.dimen.dynamic_detail_piece_chart_height);
            this.B.setLayoutParams(marginLayoutParams);
            View view2 = (View) this.y.getParent();
            MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view2.getLayoutParams();
            marginLayoutParams2.height = getResources().getDimensionPixelSize(R.dimen.dynamic_detail_info_min_height);
            view2.setLayoutParams(marginLayoutParams2);
        }
    }

    private void a(View view, View view2) {
        int a = (int) (BitmapDescriptorFactory.HUE_ORANGE * t.a(getActivity()));
        Rect rect = new Rect();
        view2.getHitRect(rect);
        rect.left -= a;
        rect.top -= a;
        rect.right += a;
        rect.bottom = a + rect.bottom;
        view.setTouchDelegate(new TouchDelegate(rect, view2));
    }

    private void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        viewGroup.setVisibility(p);
        viewGroup2.setVisibility(0);
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(80);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation = new TranslateAnimation(n, 0.0f, n, 0.0f, n, GroundOverlayOptions.NO_DIMENSION, n, 0.0f);
        alphaAnimation.setDuration(100);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(alphaAnimation);
        viewGroup2.setLayoutAnimation(new LayoutAnimationController(animationSet, 0.7f));
        viewGroup2.requestLayout();
    }

    private void a(cn.com.smartdevices.bracelet.chart.base.c cVar, int i, View view) {
        TextView textView = (TextView) view.findViewById(R.id.float_sleep_type);
        TextView textView2 = (TextView) view.findViewById(R.id.float_sleep_start_time);
        TextView textView3 = (TextView) view.findViewById(R.id.float_sleep_end_time);
        CharSequence a = f.a(cVar.c);
        CharSequence a2 = f.a(cVar.c + cVar.d);
        view.findViewById(R.id.float_sleep_extra).setVisibility(0);
        switch (cVar.b) {
            case n /*1*/:
                if (cVar.c != ae) {
                    if (cVar.c + cVar.d != af) {
                        textView.setText(R.string.dynamic_sleep_active);
                        break;
                    } else {
                        textView.setText(R.string.dynamic_sleep_active_end);
                        break;
                    }
                }
                textView.setText(R.string.dynamic_sleep_active_start);
                break;
            case o /*2*/:
                textView.setText(R.string.dynamic_sleep_shallow);
                break;
            case kankan.wheel.widget.a.l /*3*/:
                textView.setText(R.string.dynamic_sleep_deep);
                break;
            case p /*4*/:
                view.findViewById(R.id.float_sleep_extra).setVisibility(q);
                textView.setText(R.string.no_wear_user_modified);
                break;
        }
        textView2.setText(a);
        textView3.setText(a2);
    }

    private void a(HwSyncDataStatus hwSyncDataStatus) {
        C0596r.e(m, "Current Sync Status : " + hwSyncDataStatus);
        TextView textView;
        Object[] objArr;
        if (hwSyncDataStatus.b()) {
            textView = this.t;
            objArr = new Object[n];
            objArr[0] = Integer.valueOf(0);
            textView.setText(getString(R.string.dynamic_tip_sync_progress, objArr));
        } else if (hwSyncDataStatus.c()) {
            textView = this.t;
            objArr = new Object[n];
            objArr[0] = Integer.valueOf(hwSyncDataStatus.f());
            textView.setText(getString(R.string.dynamic_tip_sync_progress, objArr));
        } else {
            this.t.setText(Utils.a(getActivity(), (int) R.string.dynamic_tip_sync_time));
        }
    }

    private void a(ActiveItem activeItem, View view) {
        TextView textView = (TextView) view.findViewById(R.id.info_step);
        View findViewById = view.findViewById(R.id.info_step_distance);
        View findViewById2 = view.findViewById(R.id.info_step_calorie);
        View findViewById3 = view.findViewById(R.id.info_step_walk_distance);
        View findViewById4 = view.findViewById(R.id.info_step_walk_duration);
        View findViewById5 = view.findViewById(R.id.info_step_walk_calorie);
        View findViewById6 = view.findViewById(R.id.info_step_run_distance);
        View findViewById7 = view.findViewById(R.id.info_step_run_duration);
        View findViewById8 = view.findViewById(R.id.info_step_run_calorie);
        textView.setText(ChartData.a((long) activeItem.getSteps()));
        String[] a = ChartData.a(getActivity(), activeItem.getDistance());
        ChartData.a(findViewById, a[0], a[n]);
        ChartData.a(findViewById2, ChartData.a((long) activeItem.getCalories()), getString(R.string.unit_calorie));
        if ((this.ag & p) > 0) {
            a = ChartData.a(getActivity(), activeItem.getWalkDistance());
            ChartData.a(findViewById3, a[0], a[n]);
            ChartData.a(findViewById4, activeItem.getActiveTime() - activeItem.getRuntime(), getActivity());
            ChartData.a(findViewById5, ChartData.a((long) activeItem.getWalkCalories()), getString(R.string.unit_calorie));
            a = ChartData.a(getActivity(), activeItem.getRunDistance());
            ChartData.a(findViewById6, a[0], a[n]);
            ChartData.a(findViewById7, activeItem.getRuntime(), getActivity());
            ChartData.a(findViewById8, ChartData.a((long) activeItem.getRunCalories()), getString(R.string.unit_calorie));
        }
        int start = activeItem.getStart();
        int stop = activeItem.getStop();
        Object[] objArr = new Object[n];
        Object[] objArr2 = new Object[o];
        objArr2[0] = f.a(start);
        objArr2[n] = f.a(stop);
        objArr[0] = getString(R.string.date_from_to, objArr2);
        a(getString(R.string.dynamic_detail_step_title, objArr));
    }

    private void a(SleepInfo sleepInfo, int i, int i2, View view) {
        View findViewById = view.findViewById(R.id.info_sleep);
        View findViewById2 = view.findViewById(R.id.info_sleep_deep);
        View findViewById3 = view.findViewById(R.id.info_sleep_shallow);
        TextView textView = (TextView) view.findViewById(R.id.info_sleep_time);
        TextView textView2 = (TextView) view.findViewById(R.id.info_sleep_rise_time);
        View findViewById4 = view.findViewById(R.id.info_sleep_wake);
        ChartData.a(findViewById, sleepInfo.getSleepCount(), getActivity());
        ChartData.a(findViewById2, sleepInfo.getNonRemCount(), getActivity());
        ChartData.a(findViewById3, sleepInfo.getRemCount(), getActivity());
        textView.setText(f.a(i));
        textView2.setText(f.a(i2));
        ChartData.a(findViewById4, sleepInfo.getAwakeCount(), getActivity());
    }

    private void a(SportDay sportDay) {
        if (sportDay.equals(this.J)) {
            d(this.O);
        } else {
            a(Utils.d(sportDay));
        }
    }

    private static void a(SportDay sportDay, DaySportData daySportData) {
        SleepInfo sleepInfo = daySportData.getSleepInfo();
        if (sleepInfo == null) {
            sleepInfo = new SleepInfo();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(sleepInfo.getStartOnBedDate());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(sleepInfo.getStopOnBedDate());
        if (sportDay.addDay(-1).equals(instance)) {
            ae = C0681ak.a(instance);
        } else {
            ae = C0681ak.b(instance);
        }
        if (sportDay.addDay(-1).equals(instance2)) {
            af = C0681ak.a(instance2);
        } else {
            af = C0681ak.b(instance2);
        }
    }

    private void a(StageSteps stageSteps, int i, View view) {
        TextView textView = (TextView) view.findViewById(R.id.float_step);
        TextView textView2 = (TextView) view.findViewById(R.id.float_step_time_hour);
        textView2 = (TextView) view.findViewById(R.id.float_step_time_min);
        textView2 = (TextView) view.findViewById(R.id.info_step_time_unit_hour);
        textView2 = (TextView) view.findViewById(R.id.float_step_distance);
        TextView textView3 = (TextView) view.findViewById(R.id.info_step_distance_unit);
        ((TextView) view.findViewById(R.id.float_time)).setText(f.a(i));
        textView.setText(ChartData.a((long) stageSteps.steps));
        String[] a = ChartData.a(getActivity(), stageSteps.distance);
        textView2.setText(a[0]);
        textView3.setText(a[n]);
    }

    private void a(StepsInfo stepsInfo, i iVar, View view) {
        int c;
        int d;
        int f;
        TextView textView = (TextView) view.findViewById(R.id.info_step);
        View findViewById = view.findViewById(R.id.info_step_distance);
        View findViewById2 = view.findViewById(R.id.info_step_calorie);
        View findViewById3 = view.findViewById(R.id.info_step_walk_distance);
        View findViewById4 = view.findViewById(R.id.info_step_walk_duration);
        View findViewById5 = view.findViewById(R.id.info_step_walk_calorie);
        View findViewById6 = view.findViewById(R.id.info_step_run_distance);
        View findViewById7 = view.findViewById(R.id.info_step_run_duration);
        View findViewById8 = view.findViewById(R.id.info_step_run_calorie);
        if (ChartData.a().x()) {
            r a = ChartData.a();
            c = a.c();
            d = a.d();
            f = a.f();
        } else {
            c = stepsInfo.getStepsCount();
            d = stepsInfo.getDistance();
            f = stepsInfo.getCalories();
        }
        textView.setText(ChartData.a((long) c));
        String[] a2 = ChartData.a(getActivity(), d);
        ChartData.a(findViewById, a2[0], a2[n]);
        ChartData.a(findViewById2, ChartData.a((long) f), getString(R.string.unit_calorie));
        if ((this.ag & p) > 0) {
            a2 = ChartData.a(getActivity(), stepsInfo.getWalkDistance());
            ChartData.a(findViewById3, a2[0], a2[n]);
            ChartData.a(findViewById4, stepsInfo.getStepsTimeCount(), getActivity());
            ChartData.a(findViewById5, ChartData.a((long) stepsInfo.getWalkCalories()), getString(R.string.unit_calorie));
            a2 = ChartData.a(getActivity(), stepsInfo.getRunDistance());
            ChartData.a(findViewById6, a2[0], a2[n]);
            ChartData.a(findViewById7, stepsInfo.getRunTimeCount(), getActivity());
            ChartData.a(findViewById8, ChartData.a((long) stepsInfo.getRunCalories()), getString(R.string.unit_calorie));
        }
    }

    private String[] a(Context context, int i) {
        String[] strArr = new String[o];
        strArr[0] = i < 100 ? String.valueOf(i) : String.valueOf((long) i);
        return strArr;
    }

    private static int b(Calendar calendar) {
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    @Deprecated
    public static C0420j b(a aVar, SportDay sportDay, int i) {
        aVar.i(sportDay);
        DaySportData g = aVar.g(sportDay);
        C0420j c0420j = new C0420j();
        if (g == null) {
            return c0420j;
        }
        C0420j a = C0681ak.a(g, i);
        if (i == c) {
            C0681ak.a(sportDay, g);
            aVar.i(sportDay.addDay(-1));
            DaySportData g2 = aVar.g(sportDay.addDay(-1));
            if (g2 != null) {
                C0420j a2 = C0681ak.a(g2, i);
                for (C0422l c0422l : a2.c) {
                    c0422l.f -= 1440;
                }
                a.c.addAll(a2.c);
            }
            a.c = C0681ak.a(a.c, ae, af);
        }
        return a;
    }

    private String b(SportDay sportDay) {
        return (sportDay.mon + n) + "." + sportDay.day;
    }

    private void b(View view) {
        int i = 6;
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 3; i2 <= 6; i2 += n) {
            viewGroup.getChildAt(i2).setVisibility(p);
        }
        while (i <= q) {
            viewGroup.getChildAt(i).setVisibility(q);
            i += n;
        }
    }

    private Animator c(View view) {
        Animator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        Animator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 0.0f});
        Animator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 0.0f});
        q.a(ofFloat);
        q.b(ofFloat2);
        q.b(ofFloat3);
        ofFloat = q.a();
        ofFloat.setDuration(200);
        ofFloat.setStartDelay(600);
        ofFloat.setInterpolator(new AccelerateInterpolator(2.0f));
        ofFloat.addListener(new C0690at(this, view));
        return ofFloat;
    }

    private void d(int i) {
        if (i == com.xiaomi.hm.health.bt.b.c.SENSORHUB.b()) {
            b(R.string.action_pop_sensorhub);
        } else {
            b(R.string.dynamic_detail_step_title_today);
        }
    }

    private void e() {
        View view = (View) this.D.getParent().getParent();
        view.post(new C0685ao(this, view));
        view = (View) this.E.getParent().getParent();
        view.post(new C0686ap(this, view));
    }

    private void e(int i) {
        Parcelable f = f(i);
        if (f != null) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), ShareActivity.class);
            intent.putExtra("share_data", f);
            getActivity().startActivity(intent);
        }
    }

    private cn.com.smartdevices.bracelet.chart.b.f f() {
        return new C0687aq(this);
    }

    private ShareData f(int i) {
        if (this.K == null) {
            this.K = this.I.m();
        }
        SportDay sportDay = this.K;
        DaySportData g = this.I.g(sportDay);
        ShareData shareData;
        if (i == c) {
            r a = ChartData.a();
            int h = a.h();
            shareData = new ShareData(o);
            shareData.title = getString(R.string.share_sleep_title);
            shareData.content = h + com.xiaomi.e.a.f;
            shareData.time = Utils.d(sportDay);
            h = a.h() - a.i();
            Date j = a.j();
            Date k = a.k();
            if (j == null || k == null) {
                return null;
            }
            shareData.description = getString(R.string.share_sleep_description, new Object[]{Integer.valueOf(r3 / 60), Integer.valueOf(r3 % 60), Integer.valueOf(h / 60), Integer.valueOf(h % 60), f.a(j), f.a(k)});
            C0596r.e(m, "sleepsd: " + shareData.description);
            return shareData;
        } else if (i != n) {
            return null;
        } else {
            ShareData shareData2 = new ShareData();
            if (ChartData.n.equals(this.Q)) {
                shareData2.setType(9);
                String string = getString(R.string.walked);
                switch (this.ab) {
                    case kankan.wheel.widget.a.i /*0*/:
                        string = getString(R.string.walked);
                        break;
                    case n /*1*/:
                        string = getString(R.string.walked);
                        break;
                    case o /*2*/:
                        string = getString(R.string.runed);
                        break;
                }
                Object[] objArr = new Object[n];
                Object[] objArr2 = new Object[o];
                objArr2[0] = f.a(this.Z);
                objArr2[n] = f.a(this.aa);
                objArr[0] = getString(R.string.date_from_to, objArr2);
                shareData2.title = getString(R.string.dynamic_detail_step_share_title, objArr);
                shareData2.content = this.ac + com.xiaomi.e.a.f;
                shareData2.contentUnit = getString(R.string.unit_step);
                String[] a2 = ChartData.a(getActivity(), this.ad);
                String str = string + a2[0] + a2[n] + "\n";
                if (this.ah.w.booleanValue()) {
                    string = string + a2[0] + a2[n] + ", ";
                    this.X = this.X.replaceFirst("Burn", "burn");
                } else {
                    string = str;
                }
                shareData2.description = string + this.X;
                shareData = shareData2;
            } else {
                StepsInfo stepsInfo = (g == null || g.getStepsInfo() == null) ? new StepsInfo() : g.getStepsInfo();
                ShareData shareData3 = new ShareData(n);
                Utils.a(getActivity(), stepsInfo, shareData3);
                shareData = shareData3;
            }
            shareData.time = Utils.d(sportDay);
            return shareData;
        }
    }

    private void g() {
        if (this.T == null || !this.T.isStarted()) {
            this.B.d(false);
            this.z.setVisibility(p);
            this.A.setVisibility(p);
            this.W = false;
            String str = com.xiaomi.e.a.f;
            if (this.N == c) {
                this.N = n;
                str = C0401a.cK;
            } else if (this.N == n) {
                this.N = c;
                str = C0401a.cL;
            }
            C0401a.c(str);
            a(this.N, false);
            l.sendEmptyMessage(0);
        }
    }

    private boolean g(int i) {
        return i != com.xiaomi.hm.health.bt.b.c.SHOES.b() && ChartData.a().x();
    }

    private void h() {
        if (this.N == c) {
            C0401a.a(getActivity(), C0401a.cR, C0401a.cT);
        } else if (this.N == n) {
            C0401a.a(getActivity(), C0401a.cR, C0401a.cS);
        }
    }

    private void i() {
        DialogFragment c0692av = new C0692av();
        c0692av.setOpClickListener(new C0683am(this, c0692av));
        c.showPanel(getActivity(), c0692av);
    }

    protected String a(int i, int i2) {
        String str = com.xiaomi.e.a.f;
        return (i == 0 && i2 == 0) ? "00:00" : i2 < 10 ? i + ":0" + i2 : i + kankan.wheel.widget.a.ci + i2;
    }

    public void a(int i) {
        C0596r.e(m, "Realtime Steps Updated : " + i);
        if (i > -1) {
            Keeper.keepRealtimeStepsTimestamp(System.currentTimeMillis(), this.O);
            Keeper.keepRealtimeSteps(i, this.O);
            ChartData.a().a(i, this.O);
            if (getActivity() != null) {
                getActivity().runOnUiThread(new C0691au(this));
            }
        }
    }

    protected boolean b() {
        return true;
    }

    protected String[] c(int i) {
        int i2 = i / 60;
        int i3 = i % 60;
        String[] strArr = new String[o];
        if (i2 > 0) {
            strArr[0] = String.valueOf(i2);
        }
        strArr[n] = String.valueOf(i3);
        return strArr;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(getView());
        l = new C0682al(this);
        this.B.c(true);
        a(this.N, true);
        l.sendEmptyMessage(0);
        EventBus.getDefault().register(this);
        if (this.O == com.xiaomi.hm.health.bt.b.c.SENSORHUB.b() && Keeper.readShowSensorHubTip()) {
            i();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                e(this.N);
                C0401a.a(getActivity(), C0401a.aZ, C0401a.cu);
                return;
            case R.id.mode_switch:
                g();
                return;
            case R.id.btn_prev:
                if (!this.K.equals(this.L)) {
                    this.K = this.K.addDay(-1);
                    l.sendEmptyMessage(n);
                    return;
                }
                return;
            case R.id.btn_next:
                if (!this.K.equals(this.M)) {
                    this.K = this.K.addDay(n);
                    l.sendEmptyMessage(n);
                    return;
                }
                return;
            case R.id.modify_sleep_start:
                a((int) n, this.K);
                return;
            case R.id.modify_sleep_end:
                a((int) c, this.K);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.N = arguments.getInt(ChartData.KEY_MODE);
            this.O = arguments.getInt(ChartData.KEY_SOURCE, com.xiaomi.hm.health.bt.b.c.MILI.b());
            if (this.O == com.xiaomi.hm.health.bt.b.c.SENSORHUB.b()) {
                this.I = cn.com.smartdevices.bracelet.h.a.a();
            } else {
                this.O = C0591m.a().r();
            }
            C0596r.e(m, "Mode : " + this.N + ", Source:" + this.O);
            this.P = arguments.getString(ChartData.h);
            this.Q = arguments.getString(ChartData.i);
            this.X = arguments.getString(ChartData.j);
            this.Y = arguments.getInt(ChartData.k);
            if (this.N == n && ChartData.n.equals(this.Q)) {
                this.ag &= -2;
                this.ag |= o;
                this.ag &= -9;
            }
            if (ChartData.o.equals(this.Q)) {
                e(this.N);
                getActivity().finish();
                C0401a.a(getActivity(), C0401a.aZ, C0401a.ct);
                return;
            }
            String str = com.xiaomi.e.a.f;
            if (this.N == n) {
                str = C0401a.cI;
            } else if (this.N == c) {
                str = C0401a.cJ;
            }
            if (C0401a.cV.equals(this.P)) {
                C0401a.a(getActivity(), str, ChartData.h, C0401a.cV);
            } else {
                C0401a.a(getActivity(), str, ChartData.h, C0401a.cW);
            }
        }
        Resources resources = getActivity().getResources();
        this.R = resources.getColor(R.color.bg_mode_sleep);
        this.S = resources.getColor(R.color.bg_mode_step);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_dynamic_detail, viewGroup, false);
    }

    public void onDestroy() {
        l = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        if (this.B != null) {
            this.B.i();
        }
    }

    public void onEvent(EventDynamicDetailSleepUserModified eventDynamicDetailSleepUserModified) {
        C0596r.e(m, "User Modified : Reload!!");
        l.sendEmptyMessage(0);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(m, "On BLE Status Changed : " + hwConnStatus);
        if (hwConnStatus.k()) {
            C0596r.e(m, "Enable Realtime Steps : " + isVisible());
            if (g(hwConnStatus.b().b())) {
                RtStep.enableRtSteps(getActivity(), this.O, isVisible(), this);
            }
        }
    }

    public void onEvent(HwSyncDataStatus hwSyncDataStatus) {
        C0596r.e(m, "On BLE Status Changed : " + hwSyncDataStatus);
        if (hwSyncDataStatus.d() && isAdded()) {
            C0596r.e(m, "Enable Realtime Steps : " + isVisible());
            if (ChartData.a().x()) {
                RtStep.enableRtSteps(getActivity(), this.O, isVisible(), this);
            }
        }
        if (isVisible()) {
            a(hwSyncDataStatus);
            if (hwSyncDataStatus.d() && hwSyncDataStatus.g()) {
                l.sendEmptyMessage(0);
            }
        }
    }

    public void onPause() {
        super.onPause();
        C0596r.e(m, "Enable Realtime Steps : false");
        if (ChartData.a().x()) {
            RtStep.enableRtSteps(getActivity(), this.O, false, this);
        }
        C0401a.b(C0401a.b);
    }

    public void onResume() {
        super.onResume();
        a(F.b);
        C0596r.e(m, "Enable Realtime Steps : true");
        if (ChartData.a().x()) {
            RtStep.enableRtSteps(getActivity(), this.O, true, this);
        }
        C0401a.a(C0401a.b);
    }

    public void onStop() {
        super.onStop();
        if (this.V != null && this.V.isStarted()) {
            this.V.end();
        }
    }
}
