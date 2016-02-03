package cn.com.smartdevices.bracelet.heartrate;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.lua.MyListView;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.LayoutParams;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.ui.fe;
import cn.com.smartdevices.bracelet.ui.fg;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.huami.android.view.b;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.d.c;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.profile.a.d;
import com.xiaomi.hm.health.bt.profile.a.j;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Timer;
import kankan.wheel.widget.a;

public class HeartRateMainActivity extends SystemBarTintActivity implements OnClickListener, c {
    private static final String a = "HeartRateMainActivity";
    private static final int o = 1;
    private t A;
    private w B;
    private v C;
    private BluetoothAdapter D;
    private TextView E;
    private View F;
    private j G;
    private d H = null;
    private u I = new u(this);
    private u J = new u(this);
    private TextView K;
    private final PanelSlideListener L = new r(this);
    private Context b;
    private Resources c = null;
    private DynamicPieChartView d;
    private int e = 0;
    private View f;
    private View g;
    private MyListView h;
    private ArrayList<HeartRateItem> i;
    private SlidingUpPanelLayout j;
    private View k;
    private Timer l = new Timer();
    private Handler m = new k(this);
    private boolean n;
    private int p = v.C;
    private TextView q;
    private WebView r;
    private int s;
    private TextView t;
    private TextView u;
    private TextView v;
    private View w;
    private View x;
    private b y;
    private h z;

    private void a() {
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
        if (this.B != null) {
            this.B.cancel();
            this.B = null;
        }
    }

    private void a(ArrayList<HeartRateItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.K.setText(R.string.no_measure_data);
            return;
        }
        this.i.addAll(arrayList);
        this.t.setText(String.valueOf(((HeartRateItem) this.i.get(0)).hr));
        this.z.a(this.i);
    }

    private void a(boolean z, boolean z2) {
        this.n = false;
        a();
        runOnUiThread(new l(this, z, z2));
    }

    private int b(int i) {
        return i < 60 ? 0 : (i < 60 || i >= 100) ? 3 : o;
    }

    static /* synthetic */ int b(HeartRateMainActivity heartRateMainActivity, int i) {
        int i2 = heartRateMainActivity.p + i;
        heartRateMainActivity.p = i2;
        return i2;
    }

    private void b() {
        this.b = this;
        this.c = getResources();
        this.e = (int) Utils.b((float) CropOverlayView.a, (Context) this);
        EventBus.getDefault().register(this);
        this.i = new ArrayList();
        d();
        this.D = BluetoothAdapter.getDefaultAdapter();
        this.y = b.a((Context) this);
        new Thread(new n(this)).start();
    }

    static /* synthetic */ int c(HeartRateMainActivity heartRateMainActivity, int i) {
        int i2 = heartRateMainActivity.p - i;
        heartRateMainActivity.p = i2;
        return i2;
    }

    private void c() {
        this.d = (DynamicPieChartView) findViewById(R.id.chart);
        this.d.a((int) ChartData.d);
        this.d.a(35200.0f);
        this.f = findViewById(R.id.center_host);
        this.j = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.j.setOverlayed(true);
        this.j.setEnableDragViewTouchEvents(true);
        this.j.setPanelSlideListener(this.L);
        this.k = findViewById(R.id.dragView);
        this.h = (MyListView) findViewById(R.id.list);
        this.z = new h(this, this.i);
        this.h.setAdapter(this.z);
        this.h.setParentPanelLayout(this.j);
        this.j.setListAdapter(this.z);
        f();
        this.E = (TextView) findViewById(R.id.fail_msg);
        this.F = findViewById(R.id.fail_icon);
        this.K = (TextView) findViewById(R.id.hr_label);
        this.g = findViewById(R.id.measure_container);
        this.x = findViewById(R.id.error_container);
        this.I.execute(new Void[0]);
        this.q = (TextView) findViewById(R.id.bt_measure);
        this.q.setOnClickListener(this);
        this.t = (TextView) findViewById(R.id.hr);
        this.u = (TextView) findViewById(R.id.measuring);
        this.w = findViewById(R.id.hr_container);
        this.v = (TextView) findViewById(R.id.hr_label);
        this.r = (WebView) findViewById(R.id.heartrate_waveview);
        WebSettings settings = this.r.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        this.r.setLayerType(o, null);
        this.r.setBackgroundColor(0);
        this.r.setFocusable(false);
        this.r.setClickable(false);
        this.r.setOverScrollMode(2);
        this.r.setOnTouchListener(new o(this));
        this.r.setInitialScale((getResources().getDisplayMetrics().densityDpi * 100) / a.ax);
    }

    private void d() {
        this.G = com.xiaomi.hm.health.bt.bleservice.a.a();
        if (this.G != null) {
            this.G.a((c) this);
        }
    }

    private void e() {
        this.q.setVisibility(4);
        this.u.setVisibility(0);
        this.w.setVisibility(8);
        this.r.setVisibility(0);
        this.x.setVisibility(8);
        this.H.b(true, new p(this));
        this.n = true;
        this.r.loadUrl("file:///android_asset/heartrate_wave_1.gif");
        this.r.postDelayed(new q(this), 2000);
        this.s = -1;
        this.p = v.C;
        this.u.setText(R.string.measuring);
        this.B = new w();
        this.l.schedule(this.B, 0, 50);
    }

    private void f() {
        fg a = new fe(this).a();
        if (a.d()) {
            int e = a.e();
            this.j.setPanelHeight(this.c.getDimensionPixelSize(R.dimen.main_ui_panel_height) - e);
            this.k.setLayoutParams(new LayoutParams(-1, this.c.getDimensionPixelSize(R.dimen.main_ui_dragview_height) - e));
        }
        if (t.d(this)) {
            this.j.setPanelHeight((int) t.a((Context) this, 250.0f));
        }
    }

    public void a(int i) {
        C0596r.d(a, "onHeartRate hr:" + i);
        this.s = i;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == o && i2 == -1) {
            e();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_measure:
                C0401a.a(this.b, C0401a.gW);
                h f = com.xiaomi.hm.health.bt.bleservice.a.f();
                if (!DeviceSource.hasBind1S() && Keeper.readPersonInfo().hasBinded1S()) {
                    startActivity(new Intent(this, HeartRateBuyGuideActivity.class));
                    return;
                } else if (!DeviceSource.hasBindBracelet() || (f != null && !f.a())) {
                    b.a((Context) this, getString(R.string.cannot_heartrate), 0).show();
                    return;
                } else if (!com.xiaomi.hm.health.bt.bleservice.a.c()) {
                    b.a((Context) this, getString(R.string.bracelet_disconnected), 0).show();
                    return;
                } else if (Keeper.getHRIfDirection()) {
                    e();
                    return;
                } else {
                    startActivityForResult(new Intent(this, HeartRateGuideActivity.class), o);
                    overridePendingTransition(R.anim.hr_guide_in, 0);
                    return;
                }
            case R.id.btn:
                finish();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_heart_main);
        disableAutoApplyStatusBarTint();
        applyStatusBarTintRes(R.color.bg_mode_heartrate);
        b();
        c();
        this.H = new d();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.n) {
            this.l.cancel();
            a();
            if (this.C != null) {
                this.C.cancel();
                this.C = null;
            }
            this.H.b(false, new s(this));
        }
        if (!(this.I == null || this.I.isCancelled())) {
            this.I.cancel(true);
            this.I = null;
        }
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(a aVar) {
        this.J.execute(new Void[0]);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b() == com.xiaomi.hm.health.bt.b.c.MILI) {
            if (hwConnStatus.a() == 6 && this.G != null) {
                d();
            }
            if (!this.n) {
                return;
            }
            if (!this.D.isEnabled()) {
                a(false, false);
                this.E.setText(R.string.open_bluetooth_tips);
            } else if (hwConnStatus.b() == com.xiaomi.hm.health.bt.b.c.MILI && hwConnStatus.a() != 6) {
                a(false, false);
                this.E.setText(R.string.bracelet_disconnect_tips);
            }
        }
    }
}
