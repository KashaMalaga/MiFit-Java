package cn.com.smartdevices.bracelet.shoes.ui;

import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.calibrate.a;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.sync.C0632i;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.view.b;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;

public class ShoesCalibrateActivity extends CustomActionBarActivity implements OnClickListener {
    public static final String a = "start_by_bind_success";
    private static final String b = "v0.1.4";
    private static final String j = "ShoesUI";
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 1000;
    private static final int n = 5;
    private ImageView A;
    private View B;
    private Animation C;
    private C0632i D;
    private e E;
    private boolean F = false;
    private boolean G = true;
    private boolean H;
    private int I;
    private f J;
    private G K = null;
    private Context L;
    private boolean c;
    private boolean d = true;
    private a f;
    private boolean g = true;
    private String h;
    private F i = null;
    private View o;
    private ImageView p;
    private TextView q;
    private Button r;
    private View s;
    private ImageView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private TextView x;
    private Button y;
    private TextView z;

    public ShoesCalibrateActivity() {
        super(C0401a.bW, C0401a.ar);
    }

    private void b(boolean z) {
        this.g = z;
    }

    private void f() {
        this.r.setVisibility(8);
        this.B.setVisibility(k);
        this.A.startAnimation(this.C);
        this.y.setVisibility(8);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.isEnabled()) {
                g();
            } else {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), k);
            }
        }
    }

    private void g() {
        if (this.D.a(true)) {
            r();
        }
    }

    private void h() {
        if (this.H) {
            C0401a.a(this.L, C0409b.bn, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        }
        if (this.G) {
            C0401a.a(this.L, C0409b.bi, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        } else {
            C0401a.a(this.L, C0409b.bj, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        }
        b.a((Context) this, getResources().getString(m.shoes_calibrate_success), (int) l).show();
        if (this.G) {
            p();
        }
        finish();
    }

    private a i() {
        return this.f;
    }

    private void j() {
        if (this.H) {
            C0401a.a(this.L, C0409b.bn, C0410c.t, Constants.VIA_RESULT_SUCCESS);
        }
        if (this.G) {
            C0401a.a(this.L, C0409b.bi, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        } else {
            C0401a.a(this.L, C0409b.bj, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
        }
        this.A.clearAnimation();
        this.B.setVisibility(8);
        this.r.setVisibility(8);
        this.t.clearAnimation();
        this.p.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(k);
        this.x.setVisibility(k);
        this.y.setVisibility(k);
        this.o.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.c.e.shoes_gray_bg));
        c(getResources().getColor(com.xiaomi.hm.health.c.e.shoes_gray_bg));
    }

    private void k() {
        this.q.setVisibility(8);
        this.B.setVisibility(8);
        this.A.clearAnimation();
        this.p.setVisibility(k);
        this.s.setVisibility(k);
        this.v.setVisibility(k);
        this.I = n;
        TextView textView = this.u;
        Resources resources = getResources();
        int i = m.shoes_count_down_text;
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(this.I);
        textView.setText(resources.getString(i, objArr));
        this.t.startAnimation(this.C);
        this.K.sendEmptyMessageDelayed(10, 1000);
    }

    private void l() {
        this.I--;
        TextView textView = this.u;
        Resources resources = getResources();
        int i = m.shoes_count_down_text;
        Object[] objArr = new Object[l];
        objArr[k] = Integer.valueOf(this.I);
        textView.setText(resources.getString(i, objArr));
        if (this.I != 0) {
            this.K.sendEmptyMessageDelayed(10, 1000);
        } else if (this.d) {
            C0596r.e(j, "count down to zero");
            this.f.c();
            if (this.f.b() == cn.com.smartdevices.bracelet.shoes.calibrate.b.SUCCESS) {
                h();
            } else if (this.f.b() == cn.com.smartdevices.bracelet.shoes.calibrate.b.FAIL) {
                j();
            }
        }
    }

    private void m() {
        c(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
        this.o = findViewById(h.shoes_outer_layout);
        this.p = (ImageView) findViewById(h.shoes_calibrate_illustration);
        this.q = (TextView) findViewById(h.shoes_calibrate_suggestion);
        this.r = (Button) findViewById(h.shoes_start_calibrate_btn);
        this.s = findViewById(h.shoes_calibrating_count_layout);
        this.t = (ImageView) findViewById(h.shoes_calibrating_circle);
        this.u = (TextView) findViewById(h.shoes_count_down_text);
        this.v = (TextView) findViewById(h.shoes_calibrating_text);
        this.w = (ImageView) findViewById(h.shoes_calibrate_failed_icon);
        this.x = (TextView) findViewById(h.shoes_calibrate_failed_text);
        this.y = (Button) findViewById(h.shoes_recalibrate_btn);
        this.A = (ImageView) findViewById(h.shoes_calibrate_connecting_icon);
        this.B = findViewById(h.shoes_calibrate_connecting);
        this.C = AnimationUtils.loadAnimation(this, com.xiaomi.hm.health.c.b.shoes_loading_rotate);
        this.C.setRepeatCount(-1);
        this.z = (TextView) findViewById(h.debug_view);
        this.r.setOnClickListener(this);
        this.y.setOnClickListener(this);
    }

    private boolean n() {
        return this.g;
    }

    private void o() {
        this.r.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.p.setVisibility(k);
        this.q.setVisibility(k);
        this.B.setVisibility(k);
        this.A.startAnimation(this.C);
        this.o.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
        c(getResources().getColor(com.xiaomi.hm.health.c.e.font_color_c7_v2));
    }

    private void p() {
        Intent intent = new Intent(this, ShoesDetailActivity.class);
        intent.putExtra(CaptureActivity.l, this.E);
        startActivity(intent);
    }

    private void q() {
        if (!this.c) {
            this.A.clearAnimation();
            this.v.setVisibility(8);
            this.B.setVisibility(8);
            this.s.setVisibility(8);
            this.r.setVisibility(k);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.r.setText(getResources().getString(m.shoes_calibrate_connect_failed));
            this.H = true;
            this.K.removeMessages(10);
        }
    }

    private void r() {
        if (this.y.getVisibility() != 0) {
            this.A.clearAnimation();
            this.B.setVisibility(8);
            this.r.setVisibility(k);
            this.r.setText(getResources().getString(m.shoes_start_calibrate));
        }
    }

    public void a(boolean z) {
        this.F = z;
    }

    protected String b() {
        return getResources().getString(m.shoes_static_calibrate);
    }

    public void d() {
        this.h = this.D.e();
        if (!TextUtils.isEmpty(this.h) && this.h.compareTo(b) > 0) {
            this.d = false;
        }
    }

    protected String g_() {
        return getResources().getString(m.shoes_skip);
    }

    protected void h_() {
        C0401a.a(this.L, C0409b.bl);
        p();
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            if (i2 == -1) {
                g();
            } else if (i2 == 0) {
                try {
                    startActivityForResult(new Intent("cn.com.smartdevices.bracelet.intent.action.ENABLE_BLUETOOTH"), l);
                } catch (ActivityNotFoundException e) {
                    C0596r.e(j, "EnableBluetoothActivity not found, may be the module is running alone");
                }
            }
        } else if (i != l) {
        } else {
            if (i2 == -1) {
                g();
            } else if (i2 == 0) {
                finish();
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (this.F) {
            if (id == h.shoes_recalibrate_btn) {
                C0401a.a(this.L, C0409b.bk);
            }
            if (id == h.shoes_start_calibrate_btn || id == h.shoes_recalibrate_btn) {
                this.c = true;
                o();
                if (this.d) {
                    this.g = true;
                    this.f = new a();
                    this.J = new D(this);
                    this.f.a(this.J, this.E, this, this.D);
                    return;
                }
                this.D.b(new E(this));
                return;
            }
            return;
        }
        f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FwUpgradeManager.setUpgradeState(this, false);
        setContentView(i.activity_shoes_calibrate);
        this.L = getApplicationContext();
        m();
        this.G = getIntent().getBooleanExtra(a, true);
        if (this.G) {
            getActionBar().setDisplayHomeAsUpEnabled(false);
        }
        this.E = (e) getIntent().getSerializableExtra(CaptureActivity.l);
        if (this.E == null || TextUtils.isEmpty(this.E.g())) {
            finish();
            return;
        }
        this.K = new G(this);
        this.D = new C0632i(this, this.E.e());
        this.i = new F();
        this.D.a(this.i);
        f();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (!this.G) {
            menu.removeItem(h.custom_action_bar_menu);
        }
        return true;
    }

    public void onDestroy() {
        FwUpgradeManager.setUpgradeState(this, true);
        if (this.D != null) {
            this.J = null;
            if (this.i != null) {
                this.D.b(this.i);
            }
            if (this.c) {
                if (this.d) {
                    this.f.a();
                } else {
                    this.D.m();
                }
            }
            this.D.close();
        }
        if (this.K != null) {
            this.K.a();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (i == 4 && this.G) ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        super.onPause();
    }
}
