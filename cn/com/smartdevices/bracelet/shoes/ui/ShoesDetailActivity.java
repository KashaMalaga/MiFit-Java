package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b.d;
import cn.com.smartdevices.bracelet.shoes.b.g;
import cn.com.smartdevices.bracelet.shoes.b.i;
import cn.com.smartdevices.bracelet.shoes.b.l;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.sync.C0632i;
import cn.com.smartdevices.bracelet.shoes.sync.C0635l;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.m;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.a.b;

public class ShoesDetailActivity extends CustomActionBarActivity implements OnClickListener {
    private static final int c = 1;
    private static final int d = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final String i = "ShoesUI";
    private static final int j = 0;
    private static final int k = 1;
    private static final float l = 0.56f;
    private static final float m = 1.0f;
    private static final int n = 5;
    private View A;
    private View B;
    private View C;
    private View D;
    private Button E;
    private boolean F;
    private int G;
    private M H = null;
    private c I = null;
    public C0639p a;
    private TextView b;
    private e o = null;
    private C0632i p;
    private TextView q;
    private TextView r;
    private TextView s = null;
    private TextView t = null;
    private TextView u;
    private ImageView v;
    private L w = null;
    private Context x;
    private final g y = d.a();
    private RelativeLayout z;

    public ShoesDetailActivity() {
        super(C0401a.bU, C0401a.ap);
    }

    private void a(int i) {
        if (this.t.getVisibility() == 0) {
            this.t.setVisibility(g);
        }
        if (this.b.getVisibility() == g) {
            this.b.setVisibility(j);
        }
        if (this.s.getVisibility() == g) {
            this.s.setVisibility(j);
        }
        if (this.v.getVisibility() == 0) {
            this.v.setVisibility(8);
        }
        this.s.setText(i);
        this.z.setClickable(false);
        a(true);
    }

    private void a(int i, boolean z) {
        if (i >= 0 && this.t != null) {
            TextView textView;
            int i2;
            Object[] objArr;
            if (z) {
                this.t.setVisibility(j);
                if (i > n) {
                    textView = this.t;
                    i2 = m.shoes_show_battery_okay;
                    objArr = new Object[k];
                    objArr[j] = Integer.valueOf(i);
                    textView.setText(getString(i2, objArr));
                    return;
                }
                textView = this.t;
                i2 = m.shoes_show_battery_low;
                objArr = new Object[k];
                objArr[j] = Integer.valueOf(i);
                textView.setText(getString(i2, objArr));
            } else if (i <= n) {
                this.t.setVisibility(j);
                textView = this.t;
                i2 = m.shoes_show_battery_low;
                objArr = new Object[k];
                objArr[j] = Integer.valueOf(i);
                textView.setText(getString(i2, objArr));
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            this.A.setAlpha(l);
            this.B.setAlpha(l);
            this.B.setClickable(false);
            this.z.setAlpha(l);
            if (this.F) {
                this.C.setAlpha(l);
                this.C.setClickable(false);
                return;
            }
            return;
        }
        this.A.setAlpha(m);
        this.B.setAlpha(m);
        this.B.setClickable(true);
        this.z.setAlpha(m);
        if (this.F) {
            this.C.setAlpha(m);
            this.C.setClickable(true);
        }
    }

    private boolean a(Context context, int i) {
        if (i < 0) {
            return false;
        }
        a e = t.e(context);
        if (e == null || i == e.a()) {
            return false;
        }
        e.b(i);
        return t.a(context, e);
    }

    private void b(boolean z) {
        if (this.p != null) {
            this.p.a(new J(this, z));
        }
    }

    private void d() {
        if (this.e != null) {
            this.e.setOnLongClickListener(new I(this));
        }
    }

    private void d(int i) {
        C0596r.e(i, "updateUIState " + i);
        switch (i) {
            case k /*1*/:
                a(m.shoes_bt_disable_lable);
                return;
            case d /*2*/:
                a(m.shoes_not_connected);
                return;
            case f /*3*/:
                if (this.t.getVisibility() == g) {
                    this.t.setVisibility(j);
                }
                if (this.b.getVisibility() == g) {
                    this.b.setVisibility(j);
                }
                if (this.s.getVisibility() == g) {
                    this.s.setVisibility(j);
                }
                if (this.v.getVisibility() == 0) {
                    this.v.setVisibility(8);
                }
                this.s.setText(m.shoes_connecting);
                this.t.setText(m.shoes_connection_attension);
                this.z.setClickable(false);
                a(true);
                return;
            case g /*4*/:
                if (this.t.getVisibility() == 0) {
                    this.t.setVisibility(g);
                }
                if (this.b.getVisibility() == 0) {
                    this.b.setVisibility(g);
                }
                if (this.s.getVisibility() == g) {
                    this.s.setVisibility(j);
                }
                if (this.v.getVisibility() == 0) {
                    this.v.setVisibility(8);
                }
                this.s.setText(m.shoes_connected);
                this.z.setClickable(false);
                b(false);
                if (this.p != null) {
                    CharSequence e = this.p.e();
                    if (!TextUtils.isEmpty(e)) {
                        this.q.setText(e);
                    }
                }
                a(false);
                FwUpgradeManager.checkFwUpgrade(this.x, (int) d, new K(this));
                return;
            case n /*5*/:
                if (this.t.getVisibility() == 0) {
                    this.t.setVisibility(g);
                }
                if (this.b.getVisibility() == 0) {
                    this.b.setVisibility(g);
                }
                if (this.s.getVisibility() == g) {
                    this.s.setVisibility(j);
                }
                TextView textView = this.s;
                int i2 = m.shoes_sync_data_progress;
                Object[] objArr = new Object[k];
                objArr[j] = String.valueOf(this.G);
                textView.setText(getString(i2, objArr));
                this.z.setClickable(false);
                a(false);
                return;
            default:
                return;
        }
    }

    private boolean f() {
        return this.F;
    }

    private void g() {
        if (h()) {
            int i = m.shoes_usage;
            Object[] objArr = new Object[k];
            objArr[j] = this.o.b();
            CharSequence string = getString(i, objArr);
            if (i.British == this.y.a()) {
                i = m.shoes_mile_unit;
                objArr = new Object[k];
                objArr[j] = this.o.b();
                string = getString(i, objArr);
            }
            this.r.setText(string);
            if (this.o.f()) {
                this.r.setTextColor(getResources().getColor(com.xiaomi.hm.health.c.e.shoes_life_expired));
                return;
            } else {
                this.r.setTextColor(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c2));
                return;
            }
        }
        finish();
    }

    private boolean h() {
        a e = t.e(this);
        if (!this.o.e.equals(e.c())) {
            return false;
        }
        this.o.b(e.e());
        this.o.b(e.i());
        return true;
    }

    private void i() {
        if (this.a == null) {
            this.a = new C0639p(this.x);
        }
        this.a.h();
    }

    private void j() {
        startActivity(ShoesPrepareCalibrateActivity.a(this, this.o, false));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            switch (i2) {
                case b.a /*-1*/:
                    if (this.p != null) {
                        this.p.a(true);
                        break;
                    }
                    break;
                case j /*0*/:
                    d((int) k);
                    break;
            }
        }
        if (i == k) {
            switch (i2) {
                case b.a /*-1*/:
                    finish();
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == h.static_calibrate_layout) {
            C0401a.a(this.x, C0409b.bj);
            j();
        } else if (id == h.release_binding_btn) {
            C0401a.a(this.x, C0409b.bj);
            if (cn.com.smartdevices.bracelet.shoes.model.d.k.equals(this.o.e)) {
                if (this.o.f == k) {
                    C0401a.a(this.x, C0409b.bC, C0410c.t, Constants.VIA_RESULT_SUCCESS);
                } else if (this.o.f == d) {
                    C0401a.a(this.x, C0409b.bC, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
                }
            }
            Intent intent = new Intent(this, ShoesUnbindActivity.class);
            intent.putExtra(CaptureActivity.l, this.o);
            startActivityForResult(intent, k);
        } else if (id == h.shoes_statistics_layout) {
            C0401a.a(this.x, C0409b.bw);
            l.a(this);
        } else if (id == h.firmware_version_layout) {
            C0401a.a(this.x, C0409b.bF);
            FwUpgradeManager.checkFwUpgrade(this.x, (int) d, new H(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.xiaomi.hm.health.c.i.activity_shoes_detail);
        this.x = getApplicationContext();
        this.H = new M(this);
        EventBus.getDefault().register(this);
        c(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
        this.o = (e) getIntent().getSerializableExtra(CaptureActivity.l);
        if (this.o == null) {
            C0596r.d(i, "Detail shoes is empty from extra");
            finish();
            return;
        }
        this.I = this.o.e();
        if (this.I == null || this.I.e()) {
            C0596r.d(i, "Detail shoes identity is empty from extra identity:" + this.I);
            finish();
            return;
        }
        CharSequence d = this.o.d();
        if (TextUtils.isEmpty(d)) {
            d = this.o.h();
        }
        Resources resources = getResources();
        int i = m.shoes_smart_shoes;
        Object[] objArr = new Object[k];
        objArr[j] = d;
        a(resources.getString(i, objArr));
        this.r = (TextView) findViewById(h.used_distance);
        this.B = findViewById(h.static_calibrate_layout);
        this.E = (Button) findViewById(h.release_binding_btn);
        this.C = findViewById(h.shoes_statistics_layout);
        this.D = findViewById(h.split_line2);
        this.z = (RelativeLayout) findViewById(h.firmware_version_layout);
        this.u = (TextView) findViewById(h.shoes_tvs_step);
        this.B.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.F = cn.com.smartdevices.bracelet.shoes.b.a.a();
        if (!this.F) {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
        }
        this.q = (TextView) findViewById(h.firmware_version);
        this.s = (TextView) findViewById(h.shoes_brand_name);
        this.t = (TextView) findViewById(h.connection_attension);
        this.t.setVisibility(j);
        this.b = (TextView) findViewById(h.reminder);
        this.b.setVisibility(j);
        this.v = (ImageView) findViewById(h.shoes_ic_fw_new);
        this.A = findViewById(h.used_distance_layout);
    }

    public void onDestroy() {
        if (this.H != null) {
            this.H.a();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(HwSyncDataStatus hwSyncDataStatus) {
        if (hwSyncDataStatus.h().d()) {
            if (hwSyncDataStatus.b() || hwSyncDataStatus.c()) {
                this.G = hwSyncDataStatus.f();
                this.G = Math.max(j, Math.min(100, this.G));
                d((int) n);
            }
            if (hwSyncDataStatus.d()) {
                if (this.u != null) {
                    int h = C0635l.a(this.x).h();
                    if (h < 0) {
                        h = j;
                    }
                    TextView textView = this.u;
                    int i = m.shoes_summary_step;
                    Object[] objArr = new Object[k];
                    objArr[j] = String.valueOf(h);
                    textView.setText(getString(i, objArr));
                }
                d((int) g);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        g();
    }

    public void onStart() {
        super.onStart();
        if (this.I != null && !this.I.e()) {
            this.p = new C0632i(this, this.I);
            this.w = new L();
            this.p.a(this.w);
            int b = this.p.b();
            if (b == n) {
                C0401a.a(this.x, C0409b.bx, C0410c.t, Constants.VIA_RESULT_SUCCESS);
            } else {
                C0401a.a(this.x, C0409b.bx, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
            }
            this.H.sendEmptyMessage(b);
            if (cn.com.smartdevices.bracelet.shoes.c.a.a(this, true, j)) {
                d((int) d);
                this.p.a(true);
            } else {
                d((int) k);
            }
            CharSequence e = this.p.e();
            if (!TextUtils.isEmpty(e)) {
                this.q.setText(e);
            }
            g();
        }
    }

    public void onStop() {
        if (this.p != null) {
            if (this.w != null) {
                this.p.b(this.w);
            }
            this.p.close();
            this.p = null;
        }
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        super.onStop();
    }
}
