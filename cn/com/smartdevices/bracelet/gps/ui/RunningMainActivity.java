package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.RunningData;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.e.o;
import cn.com.smartdevices.bracelet.gps.f.d;
import cn.com.smartdevices.bracelet.gps.services.C0463w;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import cn.com.smartdevices.bracelet.shoes.ui.ShoesDetailActivity;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.b.a.b;
import com.xiaomi.hm.health.b.a.f;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;

public class RunningMainActivity extends CustomActionBarActivity implements OnClickListener, d {
    private static final String E = "settings_fragment_tag";
    private static final String f = "RunningMainActivity";
    private static final int q = 1000;
    private static final int r = 10001;
    private static final boolean s = true;
    private static final int t = 200;
    private static final int u = 200;
    private static final String v = "RunningMain";
    private static final String w = "has_show_running_tips";
    private static final float x = 0.95f;
    private Animation A = null;
    private View B = null;
    private ViewGroup C = null;
    private boolean D = false;
    private final RunningData F = new RunningData();
    private final h G = c.a();
    private Context H;
    private C0639p a;
    private HwStatusReceiver b;
    private e c;
    private View d = null;
    private View g = null;
    private View h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k;
    private TextView l = null;
    private ImageView m = null;
    private View n = null;
    private DialogFragment o = null;
    private C0515ba p = null;
    private boolean y = false;
    private C0516bb z = null;

    public class HwStatusReceiver extends BroadcastReceiver {
        final /* synthetic */ RunningMainActivity a;

        protected HwStatusReceiver(RunningMainActivity runningMainActivity) {
            this.a = runningMainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (BLEService.b.equals(intent.getAction())) {
                HwConnStatus hwConnStatus = (HwConnStatus) intent.getParcelableExtra(BLEService.j);
                if (hwConnStatus.b() == com.xiaomi.hm.health.bt.b.c.SHOES) {
                    this.a.a(hwConnStatus.a());
                }
            }
        }
    }

    public RunningMainActivity() {
        super(C0401a.bl, C0401a.ak);
    }

    private void a(int i) {
        if (i == 6) {
            this.k.setText(n.running_shoes_connected);
        } else {
            this.k.setText(n.running_shoes_not_connected);
        }
    }

    private void a(boolean z) {
        Intent intent = new Intent(this, GPSMainActivity.class);
        intent.putExtra(GPSMainActivity.a, z);
        intent.putExtra(GPSMainActivity.b, this.F);
        startActivity(intent, ActivityOptions.makeCustomAnimation(this, b.running_main_enter, b.running_main_exit).toBundle());
    }

    private void d() {
        this.g = findViewById(i.history);
        this.g.setOnClickListener(this);
        this.h = findViewById(i.start_running_button);
        this.d = findViewById(i.start_running_bg);
        this.h.setOnClickListener(this);
        this.h.setEnabled(false);
        this.l = (TextView) findViewById(i.gps_title);
        this.m = (ImageView) findViewById(i.gps_img);
        this.A = AnimationUtils.loadAnimation(this, b.running_main_start_button);
        this.n = findViewById(i.binding_shoes);
        this.i = (TextView) findViewById(i.shoes_type);
        this.j = (TextView) findViewById(i.shoes_subtitle);
        this.k = (TextView) findViewById(i.shoes_state);
        this.n.setOnClickListener(this);
        findViewById(i.gps_info).setOnClickListener(this);
    }

    private void d(int i) {
        this.z.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        this.z.sendMessage(obtain);
    }

    private void e(int i) {
        if (i == C0463w.AVAILABLE.a()) {
            if (this.F != null && this.F.a() == -1) {
                this.F.a(System.currentTimeMillis());
            }
            this.l.setText(getString(n.running_signal_strong));
            this.m.setImageDrawable(getResources().getDrawable(com.xiaomi.hm.health.b.a.h.running_gps_available));
            this.y = s;
            return;
        }
        this.l.setText(getString(n.running_signal_weak));
        this.m.setImageDrawable(getResources().getDrawable(com.xiaomi.hm.health.b.a.h.running_gps_unavailable_gray));
        this.y = false;
    }

    private void f() {
        this.c = o.a(this);
        if (this.c == null || !this.c.k()) {
            this.n.setVisibility(4);
            return;
        }
        this.n.setVisibility(0);
        C0401a.a(this.H, C0409b.bp, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        CharSequence string = getString(n.running_main_mileage_one, new Object[]{this.c.b()});
        if (k.British == this.G.a()) {
            string = getString(n.running_shoes_mile_unit, new Object[]{this.c.b()});
        }
        this.j.setText(string);
        this.k.setVisibility(0);
        if (this.c.f()) {
            this.j.setTextColor(getResources().getColor(f.shoes_life_expired));
        } else {
            this.j.setTextColor(getResources().getColor(f.running_main_shoes_attribute));
        }
    }

    private void g() {
        C0596r.e(getClass().getName(), "on start button clicked");
        if (cn.com.smartdevices.bracelet.gps.h.f.a(this)) {
            aD.a(this, aD.class);
        } else if (this.y) {
            a((boolean) s);
        } else {
            K k = new K();
            k.a(new aV(this, k));
            k.show(getFragmentManager(), getClass().getName());
        }
    }

    private void h() {
        aT aTVar = new aT();
        aTVar.a(new aW(this, aTVar));
        aTVar.show(getFragmentManager(), getClass().getName());
    }

    private boolean i() {
        this.D = false;
        if (this.B == null || this.C.findViewById(i.start_up) == null) {
            return false;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{x, 0.0f});
        ofFloat.setDuration(200);
        ofFloat.addListener(new aX(this));
        ofFloat.addUpdateListener(new aY(this));
        ofFloat.start();
        return s;
    }

    private void j() {
        Bundle bundle = new Bundle();
        bundle.putString(com.huami.android.widget.f.a, getString(n.running_unlogin_notice));
        C0487a.a(this, bundle).setOpClickListener(new aZ(this));
    }

    private void k() {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    private void l() {
        RunningSettingActivity.a((Context) this);
        C0401a.a((Context) this, C0401a.bi);
    }

    public void a(int i, int i2) {
        C0596r.g(f, "onGPSStateChanged|signalLevel:" + i);
        d(i);
    }

    public void a(cn.com.smartdevices.bracelet.gps.model.c cVar) {
    }

    protected String b() {
        return getResources().getString(n.running_main_title);
    }

    protected String g_() {
        return getResources().getString(n.running_settings);
    }

    protected void h_() {
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == r) {
        }
        if (i == 1 && cn.com.smartdevices.bracelet.gps.h.f.a(this) && this.F != null) {
            this.F.b(System.currentTimeMillis());
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == i.history) {
            k();
            cn.com.smartdevices.bracelet.gps.a.b.b(this);
        } else if (id == i.start_running_button) {
            g();
            cn.com.smartdevices.bracelet.gps.a.b.j(this);
        } else if (id == i.binding_shoes) {
            if (this.c != null && this.c.k()) {
                C0401a.a(this.H, C0409b.bo);
                Intent intent = new Intent(this.H, ShoesDetailActivity.class);
                intent.putExtra(CaptureActivity.l, this.c);
                startActivity(intent);
            }
        } else if (id != i.gps_info) {
        }
    }

    public void onCreate(Bundle bundle) {
        e();
        super.onCreate(bundle);
        this.H = getApplicationContext();
        setContentView(j.activity_running_main);
        this.p = new C0515ba(this, this);
        this.p.a((d) this);
        this.z = new C0516bb(this);
        this.C = (ViewGroup) getWindow().getDecorView();
        this.b = new HwStatusReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLEService.b);
        registerReceiver(this.b, intentFilter);
        this.a = new C0639p(this, false, false);
        d();
        cn.com.smartdevices.bracelet.gps.a.b.t(this);
        if (cn.com.smartdevices.bracelet.gps.h.f.a(this) && this.F != null) {
            this.F.b(System.currentTimeMillis());
        }
    }

    public void onDestroy() {
        if (this.p != null) {
            this.p.a((Context) this);
        }
        if (this.z != null) {
            this.z.a();
        }
        if (this.a != null) {
            this.a.a();
        }
        if (this.b != null) {
            unregisterReceiver(this.b);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.D) {
            return super.onKeyDown(i, keyEvent);
        }
        i();
        return s;
    }

    public void onPause() {
        super.onPause();
        this.d.clearAnimation();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(v, 0);
        if (!sharedPreferences.getBoolean(w, false)) {
            com.xiaomi.hm.health.bt.model.h f = a.f();
            if (cn.com.smartdevices.bracelet.gps.e.a.g() || (f != null && f.a())) {
                h();
                Editor edit = sharedPreferences.edit();
                edit.putBoolean(w, s);
                edit.commit();
            }
        }
    }

    public void onResume() {
        super.onResume();
        f();
        e(this.p.a());
        this.d.startAnimation(this.A);
    }

    public void onStart() {
        super.onStart();
        this.z.removeMessages(1);
        this.z.sendEmptyMessageDelayed(1, 1000);
    }
}
