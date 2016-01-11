package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.DeviceNotFoundActivity;
import cn.com.smartdevices.bracelet.activity.MultiDevicesErrActivity;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.shoes.EventDeviceBoundState;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.BtDevice;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.e.a;
import com.xiaomi.hm.health.bt.e.f;
import com.xiaomi.hm.health.bt.e.g;
import com.xiaomi.hm.health.bt.e.h;
import com.xiaomi.hm.health.bt.model.BraceletBtInfo;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.e;
import com.xiaomi.hm.health.bt.profile.a.i;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import com.xiaomi.hm.health.s;
import com.xiaomi.hm.view.GifView;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchSingleBraceletActivity extends SystemBarTintActivity implements OnClickListener, h {
    private static final int C = 30000;
    private static final int D = 1000;
    private static final int E = 90000;
    private static final int F = 60000;
    public static final String a = "REF_NOT_KNOCKED";
    public static final int c = 2000;
    public static final int d = 0;
    public static final int e = 1;
    private static final String f = "SearchSingleBraceletActivity";
    private static final int g = 2000;
    private static final int h = 30;
    private static final boolean i = false;
    private static final int j = 8193;
    private static final int k = 4097;
    private static final int l = 4098;
    private static final int m = 4099;
    private static final int n = 4100;
    private static final int o = 4101;
    private static final int p = 4102;
    private static final int q = 4103;
    private static final int r = 4104;
    private static final int s = 4105;
    private static final int t = 4106;
    private static Handler v = null;
    private Context A = null;
    private BluetoothDevice B = null;
    private BtDevice G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private View L;
    private BraceletBtInfo M;
    private GifView N;
    private boolean O;
    private LinePieChartView P;
    private ImageView Q;
    private boolean R;
    private ImageButton S;
    private View T;
    private boolean U = i;
    private b V = b.h();
    private BroadcastReceiver W = null;
    private a X = a.a();
    private f Y = null;
    private long Z = 0;
    private long aa = 0;
    private HashMap<String, String> ab = new HashMap();
    private long ac = 0;
    private boolean ad = i;
    public boolean b = i;
    private long u = -1;
    private ListView w = null;
    private ArrayList<BtDevice> x = new ArrayList();
    private ArrayList<BtDevice> y = new ArrayList();
    private R z = null;

    private void a(BluetoothDevice bluetoothDevice) {
        C0596r.e(f, "connect : " + bluetoothDevice.getAddress());
        this.B = bluetoothDevice;
        UserInfo p = Utils.p();
        if (p == null) {
            C0401a.c(C0401a.es);
        }
        p.j = Keeper.readSwitchOperator().enableClearData ? (byte) 1 : (byte) 0;
        com.xiaomi.hm.health.bt.bleservice.a.a(bluetoothDevice, (boolean) i, p);
        v.sendEmptyMessage(k);
        v.removeMessages(o);
        v.sendEmptyMessageDelayed(o, d.g);
        C0401a.c(this.A, C0401a.dH);
    }

    private void b(boolean z) {
        if (z) {
            h();
            this.H.setText(r.bind_bracelet);
            this.I.setText(r.found_bracelet_info);
            this.J.setVisibility(4);
            this.K.setVisibility(d);
            this.K.setText(Html.fromHtml("<u>" + getString(r.device_not_response) + "</u>"));
            this.P.setVisibility(4);
            this.Q.setVisibility(4);
            this.ac = System.currentTimeMillis();
            return;
        }
        i();
        this.H.setText(r.search_devices_title);
        this.I.setText(r.search_devices_info);
        this.J.setVisibility(d);
        this.K.setVisibility(8);
        this.P.setVisibility(d);
        this.Q.setVisibility(d);
        this.R = i;
    }

    private void g() {
        this.z = new R(this, this.x);
        this.T = findViewById(l.search_single_device_list_area);
        this.w = (ListView) findViewById(l.device_list_lv);
        this.w.setAdapter(this.z);
        this.w.setOnItemClickListener(new C0767dp(this));
        this.N = (GifView) findViewById(l.bracelet_hand_gifview);
        this.L = findViewById(l.search_single_area);
        this.H = (TextView) findViewById(l.search_devices_title);
        this.I = (TextView) findViewById(l.search_devices_info);
        this.J = (TextView) findViewById(l.search_devices_exit);
        this.J.setText(Html.fromHtml("<u>" + getString(r.donot_bind) + "</u>"));
        this.J.setOnClickListener(this);
        this.J.setVisibility(d);
        this.K = (TextView) findViewById(l.search_devices_not_response);
        this.K.setOnClickListener(this);
        this.K.setVisibility(8);
        this.Q = (ImageView) findViewById(l.search_devices_mili_icon);
        this.S = (ImageButton) findViewById(l.toggle_display_mode_btn);
        this.S.setOnClickListener(this);
        this.P = (LinePieChartView) findViewById(l.searching_pie_chart);
        this.P.a(2);
        this.P.d_();
    }

    private void h() {
        this.N.setVisibility(d);
        this.N.c(k.bracelet_bind);
        this.N.setOnClickListener(this);
        this.N.a(com.xiaomi.hm.view.f.COVER);
        this.N.b((int) ChartData.d);
    }

    private void i() {
        this.N.setVisibility(8);
    }

    private boolean j() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), j);
        return i;
    }

    private void k() {
        v = new C0768dq(this);
        this.W = new C0769dr(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLEService.b);
        intentFilter.addAction(BLEService.g);
        registerReceiver(this.W, intentFilter);
    }

    private void l() {
        i q = Utils.q();
        SwitchOperator readSwitchOperator = Keeper.readSwitchOperator();
        int i = d;
        SportDay sportDay = new SportDay();
        long j = cn.com.smartdevices.bracelet.e.a.f(this.A).uid;
        if (readSwitchOperator.type == e && readSwitchOperator.lastUid != j) {
            Summary c = C0591m.a().c(sportDay);
            if (c != null) {
                int steps = c.getSteps();
                readSwitchOperator.steps = steps;
                readSwitchOperator.date = sportDay.getKey();
                Keeper.keepSwitchOperator(readSwitchOperator);
                C0596r.d(f, "uid:" + j + ",summary steps:" + steps);
            } else {
                C0596r.d(f, "uid:" + j + ",no summary steps!!!");
            }
        }
        if (readSwitchOperator.isValidBaseSteps()) {
            i = readSwitchOperator.steps;
        }
        new com.xiaomi.hm.health.bt.a.l(q, i, new C0770ds(this)).g();
    }

    private void m() {
        p();
        if (v != null) {
            v.removeMessages(l);
            v.removeMessages(m);
            v.removeMessages(o);
            return;
        }
        C0596r.e(f, "mHandler is NULL!!!!!!!!!!!!!!!!!");
    }

    private void n() {
        com.xiaomi.hm.health.bt.bleservice.a.b();
    }

    @TargetApi(18)
    private void o() {
        C0596r.e(f, "startScanNew........");
        this.Z = System.currentTimeMillis();
        this.x.clear();
        this.z.notifyDataSetChanged();
        C0401a.c(this, C0401a.dE);
        this.X.a(this.A, this.Y);
        v.removeMessages(l);
        v.sendEmptyMessageDelayed(l, 90000);
        v.removeMessages(m);
        v.sendEmptyMessageDelayed(m, 30000);
    }

    @SuppressLint({"NewApi"})
    private void p() {
        if (this.Y != null) {
            this.X.a(this.Y);
        }
    }

    private void q() {
        j a = com.xiaomi.hm.health.bt.bleservice.a.a();
        if (a != null) {
            a.C();
        }
    }

    private void r() {
        cn.com.smartdevices.bracelet.j.j.a(this.A, cn.com.smartdevices.bracelet.j.l.a(getApplicationContext(), (int) d), new C0771dt(this), true);
    }

    private void s() {
        m();
        n();
        Intent intent = new Intent(this.A, MultiDevicesErrActivity.class);
        intent.putExtra(Utils.a, Utils.b);
        if (this.O) {
            intent.putExtra(a, r.device_not_found_not_knocked);
        }
        startActivity(intent);
        setResult(-1);
        finish();
    }

    private void t() {
        m();
        n();
        Intent intent = new Intent(this.A, DeviceNotFoundActivity.class);
        intent.putExtra(Utils.a, Utils.b);
        startActivity(intent);
        setResult(-1);
        finish();
    }

    protected void a() {
        C0596r.e(f, "onHideApp: finish()");
        n();
        finish();
    }

    public void a(BluetoothDevice bluetoothDevice, int i) {
        BtDevice btDevice = new BtDevice(bluetoothDevice, i);
        v.removeMessages(m);
        v.sendEmptyMessageDelayed(m, 30000);
        if (this.b) {
            synchronized (this.y) {
                this.y.add(btDevice);
                v.sendEmptyMessage(s);
            }
        } else {
            this.x.add(btDevice);
        }
        C0596r.d(f, "found mili:" + btDevice.device.getAddress() + ", " + btDevice.device.getName() + ", " + btDevice.signal + ", divice count:" + this.x.size());
        if (this.M == null || !btDevice.device.getAddress().equals(this.M.b)) {
            if (this.G == null) {
                this.G = btDevice;
            } else if (btDevice.signal > this.G.signal) {
                C0596r.e(f, "Found a bigger signal : " + btDevice.signal);
                this.G = btDevice;
            }
            if (this.x.size() > h || this.G.signal == 0) {
                p();
                this.ab.clear();
                this.aa = System.currentTimeMillis();
                this.ab.put(C0410c.o, this.x != null ? this.x.size() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                this.ab.put(C0410c.p, this.G != null ? this.G.signal + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                this.ab.put(C0410c.q, this.G != null ? this.G.getAddress() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                this.ab.put(C0410c.c, (this.aa - this.Z) + com.xiaomi.e.a.f);
                C0401a.a(this.A, C0409b.W, this.ab);
                v.sendEmptyMessage(l);
                v.removeMessages(m);
                C0596r.e(f, "============= Reach the scan limit, start connecting ==============");
                return;
            }
            return;
        }
        C0596r.e(f, "FOUND last device:" + this.M.b);
        this.G = btDevice;
        v.removeMessages(m);
        v.removeMessages(l);
        v.sendEmptyMessage(l);
        this.ab.clear();
        this.aa = System.currentTimeMillis();
        this.ab.put(C0410c.o, this.x != null ? this.x.size() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        this.ab.put(C0410c.p, this.G != null ? this.G.signal + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        this.ab.put(C0410c.q, this.G != null ? this.G.getAddress() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
        this.ab.put(C0410c.c, (this.aa - this.Z) + com.xiaomi.e.a.f);
        C0401a.a(this.A, C0409b.W, this.ab);
        p();
    }

    public void a(f fVar) {
    }

    public void a(e eVar, f fVar) {
        C0596r.d(f, "onScanedDevice:\n" + eVar);
        if (eVar.b == 0 || eVar.b() || eVar.a()) {
            v.sendMessage(v.obtainMessage(t, eVar));
        } else {
            C0596r.d(f, "connected bracelet advertising!!!");
        }
    }

    protected void a(boolean z) {
        this.b = z;
        if (this.b) {
            this.L.setVisibility(8);
            this.T.setVisibility(d);
            this.M = null;
            return;
        }
        this.M = Keeper.readBraceletBtInfo();
        this.L.setVisibility(d);
        this.T.setVisibility(8);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.u == -1) {
            com.huami.android.view.b.a((Context) this, (int) r.app_exit_press_again, (int) d).show();
            this.u = currentTimeMillis;
            v.sendEmptyMessageDelayed(n, 2000);
        } else if (currentTimeMillis - this.u < 2000) {
            this.u = -1;
            a();
        }
    }

    public void b(f fVar) {
    }

    public void c() {
        C0596r.e(f, "onAuthenticationFailed");
        b(true);
        if (this.b) {
            com.huami.android.view.b.a(this.A, (int) r.please_knock_bracelet, (int) e).show();
        }
    }

    public void d() {
        C0596r.e(f, "onResetAuthentiacationFailed");
        if (this.b) {
            com.huami.android.view.b.a(this.A, (int) r.device_not_found_not_knocked, (int) d).show();
        }
        this.O = true;
    }

    @TargetApi(17)
    public void e() {
        C0596r.e(f, "onDeviceConnetedSuccess: Compaire OK!");
        if (this.U) {
            C0596r.e(f, "onDeviceConnetedSuccess: Compaire OK!, But the activity has been destroyed");
            return;
        }
        com.xiaomi.hm.health.bt.model.h g = com.xiaomi.hm.health.bt.bleservice.a.g();
        if (g == null || this.B == null) {
            C0596r.d(f, "onDeviceConnetedSuccess, DeviceInfo is null!");
            return;
        }
        BraceletBtInfo braceletBtInfo = new BraceletBtInfo();
        braceletBtInfo.c = this.B.getName();
        braceletBtInfo.b = this.B.getAddress();
        braceletBtInfo.d = g.k();
        if (g.a()) {
            C0596r.d(f, "Device is 1S !");
            braceletBtInfo.e = g.p();
            braceletBtInfo.a = 4;
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            readPersonInfo.setBinded1S(true);
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        } else if (g.b()) {
            C0596r.d(f, "Device is 1A !");
            braceletBtInfo.a = 5;
        } else {
            C0596r.d(f, "Device is 1!");
            braceletBtInfo.a = d;
        }
        DeviceSource.bindBracelet(braceletBtInfo);
        DeviceSource.unbindSensorHub();
        cn.com.smartdevices.bracelet.e.a.a(this.A, g.a);
        r();
        LuaEvent.getInstance(this.A).setDefaultMsgs();
        this.P.b();
        if (this.U) {
            C0596r.e(f, "onDeviceConnetedSuccess: Compaire OK!, But the activity has been destroyed");
            return;
        }
        int i;
        if (this.R) {
            Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
            Keeper.keepPlayEnterAnimationType(e);
            i = d;
        } else {
            this.P.d();
            this.H.setText(r.bind_bracelet_ok);
            this.I.setText(r.welcom_back);
            this.Q.setImageResource(k.ok_mark);
            this.S.setVisibility(8);
            this.J.setVisibility(8);
            Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
            Keeper.keepPlayEnterAnimationType(2);
            this.ab.clear();
            this.ab.put(C0410c.c, (System.currentTimeMillis() - this.ac) + com.xiaomi.e.a.f);
            this.ab.put(C0410c.q, this.G != null ? this.G.getAddress() : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
            C0401a.a(this.A, C0409b.ae, this.ab);
            i = g;
        }
        if (this.U) {
            C0596r.e(f, "onDeviceConnetedSuccess: Compaire OK!, But the activity has been destroyed");
            return;
        }
        v.postDelayed(new C0772du(this), (long) i);
        C0401a.a(this.A, C0401a.dG, C0401a.dA);
        EventBus.getDefault().post(new EventDeviceBoundState(d, e));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C0596r.e(f, "requestCode =" + i + ", resultCode=" + i2);
        if (i == j) {
            switch (i2) {
                case kankan.wheel.widget.a.b.a /*-1*/:
                    o();
                    break;
                case d /*0*/:
                    com.huami.android.view.b.a((Context) this, getString(r.failed_enable_bt), (int) e).show();
                    finish();
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        DeviceSource.unbindBracelet();
        if (this.b) {
            q();
            finish();
            return;
        }
        b();
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case l.toggle_display_mode_btn /*2131296712*/:
                m();
                if (j()) {
                    o();
                }
                if (this.b) {
                    z = i;
                }
                a(z);
                return;
            case l.search_devices_exit /*2131296720*/:
                m();
                n();
                setResult(-1);
                finish();
                startActivity(new Intent(this, MainUIActivity.class));
                C0401a.a((Context) this, C0401a.dI);
                C0401a.a((Context) this, C0409b.V, C0410c.n, Constants.VIA_TO_TYPE_QQ_GROUP);
                return;
            case l.search_devices_not_response /*2131296721*/:
                if (this.W != null) {
                    unregisterReceiver(this.W);
                    this.W = null;
                }
                q();
                s();
                this.R = true;
                HashMap hashMap = new HashMap();
                hashMap.put(C0410c.o, this.x != null ? this.x.size() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                hashMap.put(C0410c.p, this.G != null ? this.G.signal + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                hashMap.put(C0410c.q, this.G != null ? this.G.getAddress() + com.xiaomi.e.a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                C0401a.a(this.A, C0409b.Z, hashMap);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_search_single_bracelet);
        getWindow().setWindowAnimations(s.NoneTransition);
        this.U = i;
        C0596r.e(f, "onCreate");
        this.Y = new g().a((int) E).a((h) this).a(true).a(com.xiaomi.hm.health.bt.profile.a.a.h_).a();
        this.A = this;
        k();
        b bVar = this.V;
        if (!b.x) {
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
        g();
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getBooleanExtra(kankan.wheel.widget.a.bz, i);
            C0596r.e(f, "mDevMode = " + this.b);
        } else {
            this.b = i;
        }
        if (DeviceSource.hasBindSensorHub()) {
            Utils.b(this.A, (int) d);
        }
        n();
        m();
        boolean j = j();
        C0401a.a(this.A, C0409b.U, C0410c.m, j ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        if (j) {
            C0401a.a(this.A, C0409b.T);
            o();
        }
        a(this.b);
        EventBus.getDefault().removeStickyEvent(HwConnStatus.class);
        EventBus.getDefault().removeStickyEvent(HwSyncDataStatus.class);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        C0596r.e(f, "onDestroy");
        this.U = true;
        m();
        if (this.N != null) {
            try {
                this.N.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.N = null;
        }
        if (this.W != null) {
            unregisterReceiver(this.W);
            this.W = null;
        }
    }

    protected void onHomeBackPressed() {
        m();
        super.onHomeBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case l.dev_mode /*2131297661*/:
                p();
                a(!this.b ? true : i);
                if (!j()) {
                    return true;
                }
                o();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        super.onPause();
        C0596r.e(f, "onPause");
        String str = C0401a.q;
        if (this.b) {
            str = C0401a.r;
        }
        C0401a.b(str);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        this.O = i;
        this.N.e();
        C0596r.e(f, "onResume");
        String str = C0401a.q;
        if (this.b) {
            str = C0401a.r;
        }
        C0401a.a(str);
        C0401a.a((Activity) this);
    }
}
