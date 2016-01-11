package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.DeviceNotFoundActivity;
import cn.com.smartdevices.bracelet.activity.MultiDevicesErrActivity;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.shoes.EventDeviceBoundState;
import cn.com.smartdevices.bracelet.model.BtDevice;
import com.huami.android.view.b;
import com.huami.android.view.c;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.e.a;
import com.xiaomi.hm.health.bt.e.f;
import com.xiaomi.hm.health.bt.e.g;
import com.xiaomi.hm.health.bt.e.h;
import com.xiaomi.hm.health.bt.profile.Weight.WeightHwInfo;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"NewApi"})
public class SearchWeightScaleActivity extends SystemBarTintActivity implements OnClickListener, h {
    private static final String a = "search weight";
    private static final int b = 8193;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 5;
    private static final int g = 60000;
    private static final int h = 60000;
    private e A = null;
    private TextView B;
    private ImageView C;
    private boolean D;
    private HashMap<String, String> E;
    private final a F = a.a();
    private f G = null;
    private LinePieChartView i;
    private TextView j;
    private R k;
    private View l;
    private ListView m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ArrayList<BtDevice> s;
    private Handler t;
    private int u;
    private Activity v;
    private boolean w;
    private BluetoothDevice x;
    private BroadcastReceiver y;
    private e z;

    private void a() {
        this.t = new C0773dv(this);
        this.y = new C0774dw(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLEService.c);
        registerReceiver(this.y, intentFilter);
    }

    private void a(int i) {
        C0596r.e(a, "connect status:" + i);
        if (i == c) {
            this.t.sendEmptyMessage(d);
        } else if (i == d) {
        } else {
            if (i == 0) {
                this.t.sendEmptyMessage(d);
            } else if (i == 4) {
                this.t.sendEmptyMessage(d);
            } else if (i == e) {
                f();
            }
        }
    }

    private void a(BluetoothDevice bluetoothDevice) {
        C0596r.e(a, "connect :" + bluetoothDevice.getAddress());
        com.xiaomi.hm.health.bt.bleservice.a.a(bluetoothDevice, true);
        this.t.sendEmptyMessageDelayed(f, d.g);
    }

    private void b() {
        this.k = new R(this, this.s);
        this.l = findViewById(l.search_single_device_list_area);
        this.mHomeBack.setText(r.weight_device_list);
        this.m = (ListView) findViewById(l.device_list_lv);
        this.m.setAdapter(this.k);
        this.m.setOnItemClickListener(new C0775dx(this));
        this.n = findViewById(l.search_single_area);
        this.o = (TextView) findViewById(l.search_devices_title);
        this.p = (TextView) findViewById(l.search_devices_info);
        this.o.setText(r.find_weight_scale_info);
        this.p.setText(com.xiaomi.e.a.f);
        this.j = (TextView) findViewById(l.search_devices_exit);
        this.j.setText(Html.fromHtml("<u>" + getString(r.donot_bind) + "</u>"));
        this.j.setOnClickListener(this);
        this.j.setVisibility(0);
        this.q = (TextView) findViewById(l.search_devices_not_response);
        this.q.setOnClickListener(this);
        this.q.setVisibility(8);
        this.r = (ImageView) findViewById(l.search_devices_mili_icon);
        this.r.setImageResource(k.mi_logo);
        this.i = (LinePieChartView) findViewById(l.searching_pie_chart);
        LayoutParams layoutParams = (LayoutParams) this.i.getLayoutParams();
        layoutParams.width = (int) getResources().getDimension(j.draw_weight_icon_w);
        layoutParams.height = (int) getResources().getDimension(j.draw_weight_icon_w);
        this.i.a(4);
        this.i.d_();
        this.B = (TextView) findViewById(l.search_devices_weight_value);
        this.C = (ImageView) findViewById(l.search_devices_weight_smile);
        findViewById(l.search_single_frame).setBackgroundColor(getResources().getColor(i.bg_mode_weight));
    }

    private boolean c() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), b);
        return false;
    }

    private void d() {
        C0596r.e(a, "----------start scan------------");
        this.F.a(this.v, this.G);
    }

    private void e() {
        C0596r.e(a, "----------stop scan------------");
        this.F.a(this.G);
        if (this.t != null) {
            this.t.removeMessages(e);
            this.t.removeMessages(f);
            return;
        }
        C0596r.e(a, "mHandler is NULL!!!!!!!!!!!!!!!!!");
    }

    private void f() {
        b.a(this.v, (int) r.bind_weight_ok, 0).show();
        com.xiaomi.hm.health.bt.model.i iVar = null;
        com.xiaomi.hm.health.bt.profile.Weight.f i = com.xiaomi.hm.health.bt.bleservice.a.i();
        if (i != null) {
            iVar = i.z();
        }
        WeightHwInfo weightHwInfo = new WeightHwInfo();
        weightHwInfo.name = this.x.getName();
        weightHwInfo.address = this.x.getAddress();
        if (iVar != null) {
            weightHwInfo.fwVersion = iVar.c;
            weightHwInfo.deviceId = iVar.a;
        }
        DeviceSource.bindWeight(weightHwInfo);
        if (Utils.l(this.v)) {
            g();
        }
        if (this.A != null) {
            EventBus.getDefault().post(this.A);
        }
        this.t.sendEmptyMessageDelayed(c, 0);
        EventBus.getDefault().post(new EventDeviceBoundState(c, c));
    }

    private void g() {
        cn.com.smartdevices.bracelet.j.j.a(this.v, cn.com.smartdevices.bracelet.j.l.a(getApplicationContext(), (int) c), new C0776dy(this), true);
    }

    private void h() {
        com.xiaomi.hm.health.bt.bleservice.a.h();
    }

    private void i() {
        e();
        h();
        setResult(-1);
        Intent intent = new Intent(this.v, MultiDevicesErrActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(Utils.a, Utils.d);
        startActivity(intent);
        finish();
    }

    private void j() {
        e();
        h();
        setResult(-1);
        Intent intent = new Intent(this.v, DeviceNotFoundActivity.class);
        intent.putExtra(Utils.a, Utils.d);
        startActivity(intent);
        finish();
    }

    public void a(f fVar) {
        C0596r.e(a, "onScanError");
    }

    public void a(com.xiaomi.hm.health.bt.model.e eVar) {
        if (eVar == null || eVar.n == null || eVar.a == null) {
            C0596r.d(a, "weight Data is null or device is null!");
            return;
        }
        this.z = eVar.n;
        if (this.E == null) {
            this.E = new HashMap();
        }
        if (!this.E.containsKey(eVar.a.getAddress())) {
            this.E.put(eVar.a.getAddress(), com.xiaomi.e.a.f);
        }
        C0596r.e(a, "onEventMainThread, weight = " + this.z.j() + " stable = " + this.z.f() + ", isMeasure= " + this.z.c() + ", isFinish = " + this.z.d());
        this.B.setText(this.z.j() + com.xiaomi.e.a.f);
        this.C.setVisibility(8);
        if (this.z.f() && !this.z.d()) {
            e();
            C0596r.e(a, "broadcasts number = " + this.E.size());
            if (this.E.size() <= c) {
                this.x = eVar.a;
                a(eVar.a);
            } else if (!this.D) {
                this.x = eVar.a;
                C0596r.e(a, "device addr=" + this.x.getAddress());
                this.A = this.z;
                Bundle bundle = new Bundle();
                bundle.putString(Constant.aJ, this.z.j() + com.xiaomi.e.a.f);
                C0596r.e(a, "found weight = " + this.z.j());
                c.showPanel((Activity) this, aM.class, bundle);
                C0401a.a(this.v, C0409b.at, C0410c.q, this.x.getAddress());
                this.D = true;
                C0401a.a(this.v, C0401a.fY);
            }
        }
    }

    public void a(com.xiaomi.hm.health.bt.model.e eVar, f fVar) {
        C0596r.e(a, "onScanedDevice");
        if (eVar == null) {
            C0596r.e(a, "Adv data is null");
        } else {
            this.t.post(new C0777dz(this, eVar));
        }
    }

    protected void a(boolean z) {
        this.w = z;
        if (this.w) {
            this.n.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.n.setVisibility(0);
        this.l.setVisibility(8);
    }

    public void b(f fVar) {
    }

    public void b(boolean z) {
        if (z) {
            C0401a.a(this.v, C0409b.av, C0410c.q, this.x.getAddress());
            this.o.setText(r.pairing);
            a(this.x);
        } else {
            C0401a.a(this.v, C0409b.au, C0410c.q, this.x.getAddress());
            d();
        }
        this.D = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C0596r.e(a, "requestCode =" + i + ", resultCode=" + i2);
        if (i == b) {
            switch (i2) {
                case kankan.wheel.widget.a.b.a /*-1*/:
                    this.t.removeMessages(e);
                    this.t.sendEmptyMessageDelayed(e, d.g);
                    d();
                    break;
                case kankan.wheel.widget.a.i /*0*/:
                    b.a((Context) this, getString(r.failed_enable_bt), (int) c).show();
                    finish();
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.search_devices_exit /*2131296720*/:
                C0401a.a(this.v, C0401a.fU);
                C0401a.a((Context) this, C0409b.an, C0410c.n, Constants.VIA_TO_TYPE_QQ_GROUP);
                setResult(-1);
                finish();
                return;
            case l.search_devices_not_response /*2131296721*/:
                i();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_search_single_bracelet);
        this.v = this;
        this.G = new g().a((int) h).a((h) this).a(com.xiaomi.hm.health.bt.profile.Weight.a.y_).a();
        this.s = new ArrayList();
        Intent intent = getIntent();
        if (intent != null) {
            this.w = intent.getBooleanExtra(kankan.wheel.widget.a.bz, false);
            C0596r.e(a, "mDevMode = " + this.w);
        } else {
            this.w = false;
        }
        b();
        a();
        a(this.w);
        h();
        e();
        boolean c = c();
        C0401a.a(this.v, C0409b.ak, C0410c.m, c ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        if (c) {
            this.t.removeMessages(e);
            this.t.sendEmptyMessageDelayed(e, d.g);
            C0401a.a(this.v, C0409b.ao);
            d();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        e();
        unregisterReceiver(this.y);
    }

    protected void onResume() {
        super.onResume();
        if (this.E != null) {
            this.E.clear();
        }
        this.D = false;
    }
}
