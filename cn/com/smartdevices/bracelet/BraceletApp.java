package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.a.C0099a;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.crashreport.CrashReportingApplication;
import cn.com.smartdevices.bracelet.honor.MedalManager;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.push.h;
import com.activeandroid.c;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;

public class BraceletApp extends CrashReportingApplication {
    private static final String k = "BraceletApp";
    private static Context l;
    private MedalManager m;
    private h n;

    public static Context a() {
        return l;
    }

    public String b() {
        return getString(r.report_email);
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putString(CrashReportingApplication.h, getString(r.crash_report_email_subject, new Object[]{d(), e()}));
        bundle.putString(CrashReportingApplication.i, getString(r.crash_report_email_text));
        bundle.putString(CrashReportingApplication.f, getString(r.crash_report_dialog_title));
        bundle.putString(CrashReportingApplication.g, getString(r.crash_report_dialog_text));
        bundle.putString(CrashReportingApplication.c, getString(r.crash_report_btn_report));
        bundle.putString(CrashReportingApplication.b, getString(r.crash_report_btn_exit));
        bundle.putString(CrashReportingApplication.d, a.f);
        bundle.putInt(CrashReportingApplication.e, k.app_icon);
        return bundle;
    }

    public void onCreate() {
        boolean z = true;
        super.onCreate();
        b.c(getApplicationContext());
        l = this;
        Keeper.init(this);
        Keeper.setEnterAppTrace(2);
        Keeper.setActiveHistory(2);
        registerActivityLifecycleCallbacks(new C0437g(this));
        A.a((Context) this);
        long j = cn.com.smartdevices.bracelet.e.a.f(this).uid;
        if (j < 0) {
            C0596r.d(k, "not login uid:" + j);
        } else if (j <= Constant.aU) {
            e.t = false;
        } else if (j <= Constant.aT) {
            e.t = true;
        } else {
            C0596r.d(k, "invalid uid:" + j);
        }
        C0596r.d(k, "BasicServerDef.USE_HOST_OVERSEAS:" + e.t);
        String readApkVersion = Keeper.readApkVersion();
        if (readApkVersion == null || !readApkVersion.equals(Utils.b(getApplicationContext()))) {
            Keeper.setServiceUpdateTime(0);
        } else {
            z = false;
        }
        try {
            String[] split = readApkVersion.split(kankan.wheel.widget.a.ci);
            if (split == null || Integer.valueOf(split[0]).intValue() <= 1549) {
                C0596r.a();
            }
        } catch (Exception e) {
        }
        cn.com.smartdevices.bracelet.config.b.a((Context) this, z);
        Utils.z(getApplicationContext());
        cn.com.smartdevices.bracelet.a.a.d();
        cn.com.smartdevices.bracelet.config.b h = cn.com.smartdevices.bracelet.config.b.h();
        if (h.q.a.booleanValue()) {
            this.m = MedalManager.a();
        }
        C0596r.a(h.k.d.booleanValue(), h.k.e.booleanValue());
        C0562j.b();
        C0591m.a((Context) this);
        C0563k.a(this);
        C0596r.g(k, "Init DB!!");
        com.activeandroid.a.a(new com.activeandroid.e(this).a((int) C0099a.n).b(c.b).a(), cn.com.smartdevices.bracelet.config.b.x);
        C0544h.a((Context) this);
        cn.com.smartdevices.bracelet.j.h.d(Utils.k((Context) this));
        Utils.q(this);
        cn.com.smartdevices.bracelet.chart.typeface.c.a(cn.com.smartdevices.bracelet.chart.typeface.b.a());
        C0401a.a(h.k.a.booleanValue(), cn.com.smartdevices.bracelet.config.b.x, h.k.b.booleanValue(), (Context) this);
        cn.com.smartdevices.bracelet.h.a.a((Context) this);
        if (t.d(l)) {
            t.a((Context) this, (int) kankan.wheel.widget.a.ax);
        }
        cn.com.smartdevices.bracelet.f.e.a().a(Utils.n(this));
        B.a().a((Context) this);
        a(false);
        cn.com.smartdevices.bracelet.gps.a.b(this);
        cn.com.smartdevices.bracelet.shoes.a.a(this);
    }

    public void onTerminate() {
        super.onTerminate();
        if (cn.com.smartdevices.bracelet.config.b.h().d.a.booleanValue()) {
            h.a((Context) this).c();
        }
        if (cn.com.smartdevices.bracelet.config.b.h().q.a.booleanValue()) {
            this.m.b();
        }
        com.activeandroid.a.b();
    }
}
