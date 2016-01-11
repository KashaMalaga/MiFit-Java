package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.C0203a;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.RunningData;
import cn.com.smartdevices.bracelet.gps.a.b;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.d;
import cn.com.smartdevices.bracelet.gps.f.g;
import cn.com.smartdevices.bracelet.gps.h.f;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.C0463w;
import cn.com.smartdevices.bracelet.gps.services.I;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.az;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.gps.ui.gadget.CustomRoundProgressBar;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.MapView;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.e;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.l;

public class GPSMainActivity extends ActionBarActivity implements OnClickListener, d, a, OnMapLoadedListener, OnMapTouchListener, e {
    private static final int B = 300;
    private static final int C = 100;
    public static final String a = "StartOnLoad";
    public static final String b = "RunningData";
    private static final int e = 5000;
    private static final String f = "GPSMainActivity";
    private static final float z = 3.0f;
    private ImageView A = null;
    private final Point D = new Point();
    private final ValueAnimator E = ValueAnimator.ofInt(new int[]{C, 0});
    private final ValueAnimator F = ValueAnimator.ofInt(new int[]{0, C});
    private final cn.com.smartdevices.bracelet.gps.a.a G = new cn.com.smartdevices.bracelet.gps.a.a();
    private final AnimatorUpdateListener H = new C0514b(this);
    private double I = 0.0d;
    private CustomRoundProgressBar J = null;
    private View K = null;
    private RunningData L = null;
    private com.xiaomi.hm.health.bt.profile.a.d c;
    private boolean d = false;
    private AMap g = null;
    private C0530l h = null;
    private C0526h i = null;
    private final TextView j = null;
    private MapView k = null;
    private TextView l = null;
    private ImageView m = null;
    private C0529k n = null;
    private g o = null;
    private C0541x p = null;
    private float q = C0203a.b;
    private View r = null;
    private TextView s = null;
    private C0543z t = null;
    private View u = null;
    private C0528j v = C0528j.STOPPED;
    private long w = -1;
    private List<a> x = new LinkedList();
    private int y = 0;

    public GPSMainActivity() {
        super(C0401a.bl, C0401a.ak);
    }

    public GPSMainActivity(String str, String str2) {
        super(C0401a.bl, C0401a.ak);
    }

    private void a(int i) {
        this.n.removeMessages(2);
        Message obtainMessage = this.n.obtainMessage(2);
        obtainMessage.arg1 = i;
        this.n.sendMessage(obtainMessage);
    }

    private void a(int i, boolean z, boolean z2) {
        switch (i) {
            case l.a /*1*/:
                c(z, z2);
                return;
            case kankan.wheel.widget.a.k /*2*/:
                a(z, z2);
                return;
            case kankan.wheel.widget.a.l /*3*/:
                b(z, z2);
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                d(z, z2);
                return;
            default:
                return;
        }
    }

    private void a(C0528j c0528j) {
        this.v = c0528j;
        if (C0528j.STARTED == c0528j) {
            c(0);
            this.g.setMyLocationType(2);
        } else if (C0528j.PAUSED == c0528j) {
            this.g.setMyLocationType(1);
        } else if (C0528j.RESUMED == c0528j) {
            this.g.setMyLocationType(2);
        } else if (C0528j.STOPPED == c0528j) {
            this.g.setMyLocationType(1);
        }
    }

    private void a(AMap aMap) {
        this.o = new C0527i(this, this, new C(aMap));
        this.o.a(this.k.getMap());
        this.o.d(1);
        this.o.a((a) this);
        this.o.a((d) this);
    }

    private void a(boolean z, boolean z2) {
        a(C0528j.PAUSED);
        this.h.c();
        if (!z2) {
            return;
        }
        if (z) {
            this.o.c(3);
            d(0);
            C0401a.a((Context) this, C0401a.bn);
            return;
        }
        d(1);
        C0401a.a((Context) this, C0401a.bo);
    }

    private void b() {
        if (this.i != null) {
            if (this.i == C0526h.Normal) {
                s();
            } else if (this.i == C0526h.Map) {
                t();
                b.o(this);
            }
        }
    }

    private void b(int i) {
        CharSequence string;
        Drawable drawable;
        if (!f.a(this)) {
            string = getResources().getString(n.running_signal_weak);
            drawable = getResources().getDrawable(h.running_gps_unavailable_gray);
        } else if (i == C0463w.AVAILABLE.a()) {
            if (this.L != null && this.L.a() == -1) {
                this.L.a(System.currentTimeMillis());
            }
            string = getResources().getString(n.running_signal_strong);
            drawable = getResources().getDrawable(h.running_gps_available);
            if (!this.G.c) {
                this.G.b = (System.currentTimeMillis() - this.G.a) / 1000;
                this.G.c = true;
            }
        } else {
            string = getResources().getString(n.running_signal_weak);
            drawable = getResources().getDrawable(h.running_gps_unavailable_gray);
        }
        this.l.setText(string);
        this.m.setImageDrawable(drawable);
    }

    private void b(long j) {
        if (this.x != null) {
            for (a a : this.x) {
                a.a(j);
            }
        }
    }

    private void b(az azVar) {
        if (this.x != null) {
            for (a a : this.x) {
                a.a(azVar);
            }
        }
    }

    private void b(boolean z, boolean z2) {
        a(C0528j.RESUMED);
        this.h.d();
        if (z2) {
            if (z) {
                this.o.c(2);
                C0401a.a((Context) this, C0401a.bp);
            } else {
                C0401a.a((Context) this, C0401a.bq);
            }
        }
        d(0);
    }

    private void c() {
        Intent intent = new Intent(getApplicationContext(), GPSResultActivity.class);
        intent.putExtra(C0483q.a, this.w);
        startActivity(intent);
        finish();
    }

    private void c(int i, int i2) {
        Message obtainMessage = this.n.obtainMessage(11);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        this.n.sendMessage(obtainMessage);
    }

    private void c(long j) {
        Message obtainMessage = this.n.obtainMessage(7);
        obtainMessage.obj = Long.valueOf(j);
        this.n.sendMessage(obtainMessage);
    }

    private void c(az azVar) {
        this.n.removeMessages(1);
        this.n.obtainMessage(1, azVar).sendToTarget();
    }

    private void c(boolean z, boolean z2) {
        a(C0528j.STARTED);
        if (z && z2) {
            this.o.c(1);
            this.w = this.o.d();
            C0401a.a((Context) this, C0401a.bm);
        }
        d(0);
    }

    private void d(int i) {
        this.n.removeMessages(3);
        Message obtainMessage = this.n.obtainMessage(3);
        obtainMessage.arg1 = i;
        this.n.sendMessage(obtainMessage);
    }

    private void d(int i, int i2) {
        if (this.x != null) {
            for (a b : this.x) {
                b.b(i, i2);
            }
        }
    }

    private void d(boolean z, boolean z2) {
        long j = -1;
        this.c.c(false, new C0525g(this));
        if (this.L != null) {
            if (this.L.a() != -1) {
                j = (this.L.a() - this.L.b()) / 1000;
            }
            b.a((Context) this, this.L.c(), j);
        } else {
            C0596r.d(f, "running data should not be null");
        }
        a(C0528j.STOPPED);
        if (z && z2) {
            this.o.c(4);
            C0401a.a((Context) this, C0401a.br);
        }
        d(0);
    }

    private boolean d() {
        return ((float) this.y) >= this.q;
    }

    private void f() {
        this.F.addUpdateListener(this.H);
        this.E.addUpdateListener(this.H);
        this.F.setDuration(300);
        this.E.setDuration(300);
        this.F.addListener(new C0520c(this));
        this.E.addListener(new C0521d(this));
        this.I = Math.sqrt((double) ((this.D.x * this.D.x) + (this.D.y * this.D.y)));
    }

    private void g() {
        if (this.p == null) {
            this.p = new C0541x();
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(i.fragment_container, this.p);
            beginTransaction.commit();
            a(this.p);
        }
    }

    private void h() {
        if (this.t == null) {
            this.t = new C0543z();
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(i.fragment_container, this.t);
            beginTransaction.commit();
            a(this.t);
        }
    }

    private void i() {
        this.L = (RunningData) getIntent().getParcelableExtra(b);
        if (this.L == null) {
            C0596r.d(f, "RunningData is null");
            return;
        }
        this.L.a(cn.com.smartdevices.bracelet.gps.e.a.f());
    }

    private void j() {
        this.u = findViewById(i.settings_container);
        this.u.setOnClickListener(this);
        this.l = (TextView) findViewById(i.gps_signal_value);
        this.m = (ImageView) findViewById(i.gps_signal_icon);
        this.s = (TextView) findViewById(i.mode);
        this.r = findViewById(i.mode_container);
        this.r.setOnClickListener(this);
        this.A = (ImageView) findViewById(i.model_icon);
        this.K = findViewById(i.overlayer);
        this.K.setVisibility(0);
        this.h = (C0530l) Fragment.instantiate(this, C0530l.class.getName());
        this.h.a(new C0523e(this));
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(i.control_container, this.h);
        beginTransaction.commit();
    }

    private void k() {
        this.s.setText(getResources().getString(n.running_normal_mode));
        this.A.setImageDrawable(getResources().getDrawable(h.running_black));
        if (this.J != null) {
            this.J.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.b.a.f.running_pause_button_map));
            this.J.c(0.0f);
        }
        this.i = C0526h.Map;
    }

    private void l() {
        C0596r.g(f, "transferToNormalFragment");
        this.s.setText(getResources().getString(n.running_map_mode));
        this.A.setImageDrawable(getResources().getDrawable(h.running_map));
        if (this.J != null) {
            C0596r.g(f, "mPauseButton is not null");
            this.J.c((float) z);
            this.J.d(getResources().getColor(com.xiaomi.hm.health.b.a.f.running_pause_button_strock));
            this.J.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.b.a.f.running_pause_button_normal));
        }
        this.i = C0526h.Normal;
    }

    private void m() {
        this.w = this.o.d();
        C0596r.d("RunUI", "SERVICE_READY mTrackId = " + this.w + ",Op = " + this.o.e() + ",state = " + this.o.b());
        if (this.w > 0) {
            az a = this.o.a(this.w);
            if (a != null) {
                this.y = (int) a.l();
            }
            if (!(a == null || this.n == null)) {
                c(a);
            }
            a(this.o.b(), this.o.e() != -1, false);
            c(this.o.c());
        }
    }

    private void n() {
        RunningSettingActivity.a((Context) this);
        C0401a.a((Context) this, C0401a.bi);
    }

    private void o() {
        Bundle bundle = new Bundle();
        bundle.putString(com.huami.android.widget.f.a, getResources().getString(n.running_stop_sport_confirm));
        bundle.putString(cn.com.smartdevices.bracelet.tag.a.a, getResources().getString(n.running_btn_continue));
        bundle.putString(cn.com.smartdevices.bracelet.tag.a.b, getResources().getString(n.running_btn_confirm));
        C0487a.a(this, bundle, f).setOpClickListener(this);
    }

    private void p() {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        cn.com.smartdevices.bracelet.gps.ui.a.a a = cn.com.smartdevices.bracelet.gps.ui.a.a.a(3);
        a.a(new C0524f(this));
        a.show(beginTransaction, null);
    }

    private void q() {
        n();
        C0401a.a((Context) this, C0401a.bi);
    }

    private void r() {
        d(true, true);
        finish();
    }

    private void s() {
        if (this.i == C0526h.Normal) {
            this.F.start();
            this.i = C0526h.None;
        }
    }

    private void t() {
        if (this.i == C0526h.Map) {
            this.E.start();
            this.i = C0526h.None;
        }
    }

    private void u() {
        cn.com.smartdevices.bracelet.gps.h.e.a("GPSMain", "updateUIFromService");
        this.n.removeMessages(4);
        this.n.sendMessage(this.n.obtainMessage(4));
    }

    public void a(int i, int i2) {
        cn.com.smartdevices.bracelet.gps.h.e.a("GPSMain", "onGPSStateChanged|signalLevel:" + i + ",state:" + i2);
        a(i);
    }

    public void a(int i, boolean z) {
        a(i, false, true);
    }

    public void a(long j) {
        c(j);
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void a(c cVar) {
        if (cn.com.smartdevices.bracelet.gps.c.b.h(this) && this.w > 0) {
            cn.com.smartdevices.bracelet.gps.d.c.a(this, this.w, cVar);
        }
        if (!this.G.f) {
            this.G.e = (System.currentTimeMillis() - this.G.d) / 1000;
            this.G.f = true;
            b.a(getApplicationContext(), this.G.b, this.G.e);
        }
    }

    public void a(a aVar) {
        if (this.x == null) {
            this.x = new LinkedList();
        }
        if (!this.x.contains(aVar)) {
            this.x.add(aVar);
        }
    }

    public void a(az azVar) {
        this.y = (int) azVar.l();
        c(azVar);
    }

    public void b(int i, int i2) {
        if (i2 == I.e && !this.d) {
            Bundle bundle = new Bundle();
            bundle.putInt(aM.a, 17);
            bundle.putInt(C0543z.e, i2);
            aM.a(this, bundle);
            this.d = true;
        }
        c(i, i2);
    }

    public void b(DialogFragment dialogFragment) {
        if (this.v == C0528j.PAUSED) {
            b(true, true);
        }
        C0401a.a((Context) this, C0401a.bs);
        b.d(getApplicationContext(), false);
    }

    public void b(a aVar) {
        if (this.x != null) {
            this.x.remove(aVar);
        }
    }

    public void c(DialogFragment dialogFragment) {
        d(true, true);
        c();
        b.d(getApplicationContext(), true);
    }

    public void onBackPressed() {
        if (this.v == C0528j.STOPPED) {
            finish();
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == i.header_history) {
            Intent intent = new Intent(this, HistoryActivity.class);
            if (!this.v.equals(C0528j.STOPPED)) {
                intent.putExtra(C0483q.a, this.w);
            }
            startActivity(intent);
        } else if (id == i.header_more) {
            n();
            C0401a.a((Context) this, C0401a.bi);
        } else if (id == i.mode_container) {
            b();
        } else if (id == i.settings_container) {
            q();
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(j.activity_running_gps_main);
        this.n = new C0529k(this);
        this.q = cn.com.smartdevices.bracelet.gps.c.b.e(this);
        getWindowManager().getDefaultDisplay().getSize(this.D);
        this.c = new com.xiaomi.hm.health.bt.profile.a.d();
        i();
        j();
        g();
        k();
        h();
        f();
        C0401a.a((Context) this, C0401a.bc, "Running");
        this.G.a = System.currentTimeMillis();
        this.G.d = this.G.a;
    }

    public void onDestroy() {
        if (this.n != null) {
            this.n.a();
        }
        if (this.o != null) {
            this.o.a((Context) this);
        }
        if (this.x != null) {
            this.x.clear();
        }
        super.onDestroy();
    }

    public void onMapLoaded() {
        cn.com.smartdevices.bracelet.gps.h.e.a("GPSMain", "onMapLoaded");
        this.o.j();
    }

    public void onPause() {
        super.onPause();
        if (this.p != null) {
            this.p.c();
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.J = this.h.e();
        this.k = this.p.b();
        this.g = this.p.a();
        a(this.g);
        l();
    }

    public void onResume() {
        super.onResume();
        if (this.p != null) {
            this.p.d();
        }
        a(this.o.a());
        String a = cn.com.smartdevices.bracelet.gps.c.b.a(this);
        if (!TextUtils.isEmpty(a)) {
            try {
                this.o.c(new c(Double.parseDouble(a.split(com.xiaomi.mipush.sdk.f.i)[0]), Double.parseDouble(a.split(com.xiaomi.mipush.sdk.f.i)[1]), 0.0d));
            } catch (Exception e) {
                C0596r.a("Run", e.getMessage());
            }
        }
        this.o.a(true);
    }

    public void onTouch(MotionEvent motionEvent) {
        this.g.setMyLocationType(1);
        this.n.removeMessages(5);
        this.n.sendMessageDelayed(this.n.obtainMessage(5), 5000);
    }
}
