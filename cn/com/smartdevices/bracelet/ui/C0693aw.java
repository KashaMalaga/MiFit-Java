package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.support.v7.widget.af;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import com.huami.android.view.c;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.UserSleepModify;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.HashMap;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

public class C0693aw extends c implements kankan.wheel.widget.c, e {
    private static final String a = "Dynamic.Detail.SleepModify";
    private TextView b;
    private TextView c;
    private WheelView d;
    private WheelView e;
    private SportDay f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    private int a() {
        return this.d.f() + this.h;
    }

    private int a(int i, int i2) {
        return i < 0 ? (((i + 24) * 60) + i2) - 1440 : (i * 60) + i2;
    }

    private void a(int i) {
        a(i, false);
    }

    private void a(int i, boolean z) {
        this.d.a(i - this.h, z);
    }

    private void a(View view) {
        this.b = (TextView) view.findViewById(l.modify_sleep_title);
        this.c = (TextView) view.findViewById(l.modify_sleep_today_yesterday);
        this.d = (WheelView) view.findViewById(l.modify_sleep_time_hour);
        this.e = (WheelView) view.findViewById(l.modify_sleep_time_minute);
        Bundle arguments = getArguments();
        this.f = (SportDay) arguments.getSerializable(C0681ak.d);
        this.g = arguments.getInt(C0681ak.e);
        this.h = arguments.getInt(C0681ak.f);
        this.i = arguments.getInt(C0681ak.g);
        this.j = arguments.getInt(C0681ak.h);
        this.k = arguments.getInt(C0681ak.i);
        this.l = arguments.getInt(C0681ak.j);
        this.m = arguments.getInt(C0681ak.k);
        switch (this.g) {
            case kankan.wheel.widget.l.a /*1*/:
                this.b.setText(r.dynamic_detail_modify_sleep_start_time);
                break;
            case a.bp /*16*/:
                this.b.setText(r.dynamic_detail_modify_sleep_end_time);
                break;
        }
        if (this.j >= 0) {
            this.c.setText(r.date_today);
        } else {
            this.c.setText(r.date_yesterday);
        }
        f c0763dl = new C0763dl(getActivity(), this.h, this.i, this.d, getResources().getColor(g.bg_color_blue), getResources().getColor(g.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        c0763dl.a(9);
        this.d.a(5).e(h.wheel_custom_val_white_1).a(getString(r.hour_1), g.bg_color_blue, 18.0f).a(c0763dl);
        a(this.j);
        this.d.a((kankan.wheel.widget.c) this);
        this.d.a((e) this);
        this.e.a(5).e(h.wheel_custom_val_white_1).a(getString(r.minute), g.bg_color_blue, 18.0f).a(new C0763dl(getActivity(), 0, 59, this.e, getResources().getColor(g.bg_color_blue), getResources().getColor(g.main_ui_content_color), a.bm, true, 46, 24, 21, 21, 1));
        b(this.k);
        this.e.a((kankan.wheel.widget.c) this);
        this.e.a((e) this);
    }

    private void a(DaySportData daySportData) {
        if (daySportData != null) {
            SleepInfo sleepInfo = daySportData.getSleepInfo();
            if (sleepInfo == null) {
                sleepInfo = new SleepInfo();
            }
            cn.com.smartdevices.bracelet.chart.util.r a = ChartData.a();
            a.e(sleepInfo.getSleepCount());
            a.f(sleepInfo.getNonRemCount());
            a.a(sleepInfo.getStartDate());
            a.b(sleepInfo.getStopDate());
        }
    }

    private int b() {
        return this.e.f() % 60;
    }

    private void b(int i) {
        b(i, false);
    }

    private void b(int i, boolean z) {
        this.e.b(i, z);
    }

    private int[] c(int i) {
        int[] iArr = new int[2];
        if (i < 0) {
            iArr[0] = ((i + 1) / 60) - 1;
            iArr[1] = i % 60;
            if (iArr[1] != 0) {
                iArr[1] = iArr[1] + 60;
            }
        } else {
            iArr[0] = i / 60;
            iArr[1] = i % 60;
        }
        return iArr;
    }

    public void a(WheelView wheelView) {
    }

    public void a(WheelView wheelView, int i, int i2) {
        if (wheelView != this.d) {
            return;
        }
        if (a() >= 0) {
            this.c.setText(r.date_today);
        } else {
            this.c.setText(r.date_yesterday);
        }
    }

    public void b(WheelView wheelView) {
        int a = a();
        int a2 = a(a, b());
        C0596r.e(a, "Selection Time : " + a + a.ci + String.format("%02d", new Object[]{Integer.valueOf(r1)}) + " , " + a2);
        int[] iArr = null;
        if (this.l > af.a && a2 <= this.l) {
            iArr = c(this.l + 1);
            Log.w(a, "Selection Time Is Before : " + iArr[0] + a.ci + String.format("%02d", new Object[]{Integer.valueOf(iArr[1])}));
        } else if (this.m > af.a && a2 >= this.m) {
            iArr = c(this.m - 1);
            Log.w(a, "Selection Time Is After : " + iArr[0] + a.ci + String.format("%02d", new Object[]{Integer.valueOf(iArr[1])}));
        }
        Calendar instance = Calendar.getInstance();
        int i = (instance.get(11) * 60) + instance.get(12);
        if (a2 > i && this.f.equals(instance)) {
            iArr = c(i);
            Log.w(a, "Selection Time Is After : " + iArr[0] + a.ci + String.format("%02d", new Object[]{Integer.valueOf(iArr[1])}));
        }
        if (iArr != null) {
            a(iArr[0], true);
            b(iArr[1], true);
        }
    }

    protected int inflateLayout() {
        return n.fragment_dynamic_detail_sleep_modify;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(getView());
    }

    protected void onEmptyAreaClicked() {
        super.onEmptyAreaClicked();
        Object obj = null;
        if (this.g == 1) {
            obj = C0401a.dt;
        } else if (this.g == 16) {
            obj = C0401a.du;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C0681ak.e, obj);
        hashMap.put("Confirm", "False");
        C0401a.a(getActivity(), C0401a.ds, hashMap);
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        Object obj = null;
        if (this.g == 1) {
            obj = C0401a.dt;
        } else if (this.g == 16) {
            obj = C0401a.du;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C0681ak.e, obj);
        hashMap.put("Confirm", "False");
        C0401a.a(getActivity(), C0401a.ds, hashMap);
    }

    public void onPause() {
        super.onPause();
        String str = "PageDynamicDetailModifySleep";
        if (this.g == 1) {
            str = C0401a.c;
        } else if (this.g == 16) {
            str = C0401a.d;
        }
        C0401a.b(str);
    }

    public void onResume() {
        super.onResume();
        String str = "PageDynamicDetailModifySleep";
        if (this.g == 1) {
            str = C0401a.c;
        } else if (this.g == 16) {
            str = C0401a.d;
        }
        C0401a.a(str);
    }

    protected void onRightButtonClicked() {
        int a = a();
        int b = b();
        if (!(a == this.j && b == this.k)) {
            int a2 = a(a, b);
            C0596r.e(a, "Sleep Time Modified : " + a + a.ci + String.format("%02d", new Object[]{Integer.valueOf(b)}) + " , " + a2 + " , " + this.g + " , " + this.f);
            UserSleepModify a3 = ChartData.a().a(this.f);
            switch (this.g) {
                case kankan.wheel.widget.l.a /*1*/:
                    a3.sleepStart = a2;
                    break;
                case a.bp /*16*/:
                    a3.sleepEnd = a2;
                    break;
            }
            ChartData.a().a(this.f, a3);
            C0591m a4 = C0591m.a();
            DaySportData g = a4.g(this.f);
            if (g != null) {
                g.setNeedSync(true);
                g.setNeedPostProcess(true);
            }
            a4.o();
            a4.p();
            a(g);
            EventBus.getDefault().post(new EventDynamicDetailSleepUserModified());
            Object obj = null;
            if (this.g == 1) {
                obj = C0401a.dt;
            } else if (this.g == 16) {
                obj = C0401a.du;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(C0681ak.e, obj);
            hashMap.put("Confirm", "True");
            C0401a.a(getActivity(), C0401a.ds, hashMap);
        }
        dismiss();
    }
}
