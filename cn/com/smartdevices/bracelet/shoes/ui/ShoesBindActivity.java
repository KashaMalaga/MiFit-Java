package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b;
import cn.com.smartdevices.bracelet.shoes.c.d;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.sync.C0632i;
import cn.com.smartdevices.bracelet.shoes.sync.J;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import com.xiaomi.hm.health.c.m;
import com.xiaomi.market.sdk.q;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.a;

public class ShoesBindActivity extends CustomActionBarActivity {
    public static final String a = "updating";
    public static final String b = "old_shoes_version";
    public static final String c = "mac_address";
    private static final String d = "ShoesBindActivity";
    private static final int f = 1000;
    private boolean g = false;
    private boolean h;
    private boolean i = false;
    private e j = null;
    private C0632i k = null;
    private TextView l = null;
    private C0649f m = null;
    private C0650g n = null;
    private Context o;
    private c p = null;
    private boolean q = false;
    private ImageView r;
    private TextView s;

    public ShoesBindActivity() {
        super(C0401a.ca, C0401a.av);
    }

    public static Intent a(Context context, e eVar) {
        Intent a = CaptureActivity.a(context);
        a.putExtra(CaptureActivity.i, "com.xiaomi.hm.health.action.SHOES_BIND");
        a.putExtra(q.c, context.getPackageName());
        a.putExtra(CaptureActivity.d, context.getResources().getString(m.shoes_bind_prompt));
        a.putExtra(CaptureActivity.f, context.getResources().getString(m.shoes_bind_title));
        a.putExtra(CaptureActivity.h, true);
        a.putExtra(CaptureActivity.g, true);
        a.putExtra(CaptureActivity.e, true);
        a.putExtra(CaptureActivity.n, eVar.e);
        a.putExtra(CaptureActivity.o, String.valueOf(eVar.f));
        a.putExtra(CaptureActivity.j, 1);
        a.putExtra(CaptureActivity.k, 8);
        a.putExtra(CaptureActivity.l, eVar);
        return a;
    }

    private void a(Message message) {
        switch (message.what) {
            case a.l /*3*/:
            case a.bt /*6*/:
            case a.bc /*7*/:
                this.g = true;
                C0596r.e(d, "FAILED_TO_SCAN | FALIED_TO_CONNECT = " + message.what);
                C0401a.a(this.o, C0409b.bg, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
                d();
                C0401a.a(this.o, C0409b.bh, C0410c.t, Constants.VIA_TO_TYPE_QQ_GROUP);
                return;
            case a.X /*5*/:
                C0596r.e(d, "CONNECTED = " + message.what + ",mFoundFailedToConnect:" + this.g);
                if (!this.g) {
                    this.p.a(this.k.d());
                    C0401a.a(this.o, C0409b.bg, C0410c.t, Constants.VIA_RESULT_SUCCESS);
                    J.a(this.o, this.k.f());
                    C0401a.a(this.o, C0409b.bh, C0410c.t, Constants.VIA_RESULT_SUCCESS);
                    FwUpgradeManager.checkFwUpgrade(this.o, 2, new C0645b(this));
                    return;
                }
                return;
            case f /*1000*/:
                h();
                return;
            default:
                return;
        }
    }

    private boolean a(Context context, c cVar, e eVar) {
        if (t.e(context) != null) {
            t.m(context, cVar);
        }
        eVar.a(cVar);
        return t.b(context, eVar);
    }

    private void b(String str) {
        C0596r.d(b.a, str);
    }

    private void d() {
        k();
        d.a(this, m.shoes_bind_alert_title, m.shoes_bind_alert_msg, new C0647d(this));
    }

    private void f() {
        setResult(-1, getIntent());
        finish();
    }

    private void g() {
        f();
        startActivity(a(this.o, this.j));
    }

    private void h() {
        f();
        startActivity(ShoesPrepareCalibrateActivity.a(this.o, this.j, true));
    }

    private void i() {
        k();
        d.a(this, m.shoes_scanf_alert_title, m.shoes_scanf_alert_msg, new C0648e(this));
    }

    private void j() {
        this.s.setVisibility(0);
        this.r.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, com.xiaomi.hm.health.c.b.shoes_loading_rotate);
        loadAnimation.setRepeatCount(-1);
        this.r.startAnimation(loadAnimation);
    }

    private void k() {
        this.r.clearAnimation();
        this.r.setVisibility(8);
        this.s.setVisibility(8);
    }

    private void l() {
        this.r = (ImageView) findViewById(h.shoes_binding_circle);
        this.s = (TextView) findViewById(h.shoes_binding_loading_tips);
        this.l = (TextView) findViewById(h.debug_view);
    }

    public void onBackPressed() {
        super.onBackPressed();
        g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = getApplicationContext();
        setContentView(i.activity_shoes_bind);
        l();
        EventBus.getDefault().register(this);
        if (bundle != null) {
            this.h = bundle.getBoolean(b);
            this.i = bundle.getBoolean(a);
            this.j = (e) bundle.getSerializable(CaptureActivity.l);
        } else {
            this.j = (e) getIntent().getSerializableExtra(CaptureActivity.l);
        }
        if (this.j == null) {
            finish();
            return;
        }
        cn.com.smartdevices.bracelet.shoes.a.d a = cn.com.smartdevices.bracelet.shoes.a.c.a(getIntent().getStringExtra(CaptureActivity.b));
        if (a == null || TextUtils.isEmpty(a.b()) || !(TextUtils.isEmpty(a.a()) || a.a().startsWith(this.j.a()))) {
            i();
            this.q = true;
            return;
        }
        this.m = new C0649f(this);
        this.p = new c(a.b(), a.c());
        if (this.i) {
            this.q = true;
            if (!this.h) {
                this.m.sendEmptyMessage(f);
                return;
            } else if (FwUpgradeManager.shoesFwUpgradeReslut(this)) {
                a(this.o, this.p, this.j);
                this.m.sendEmptyMessage(f);
                return;
            } else {
                g();
                return;
            }
        }
        this.k = new C0632i(this, new c(a.b(), a.c()), true);
        this.n = new C0650g();
        this.k.a(this.n);
        this.k.a(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("START SCAN, brand = ").append(this.j.e).append(" subModel = ").append(this.j.f).append(" macAddress = ").append(a.b()).append(" status: " + this.k.c());
        b(stringBuilder.toString());
    }

    public void onDestroy() {
        if (this.k != null) {
            if (this.n != null) {
                this.k.b(this.n);
            }
            this.k.close();
            this.k = null;
        }
        if (this.m != null) {
            this.m.a();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(cn.com.smartdevices.bracelet.upgrade.a.a aVar) {
        C0596r.e(d, aVar.toString());
        if (2 == aVar.a()) {
            C0596r.e(d, "EventFwUpgradeComplete OldShoesVersion " + this.h);
            if (!this.h) {
                this.m.sendEmptyMessage(f);
            } else if (aVar.b() == 0) {
                a(this.o, this.p, this.j);
                this.m.sendEmptyMessage(f);
                C0596r.e(d, "EventFwUpgradeComplete success");
            } else {
                runOnUiThread(new C0646c(this));
            }
        }
    }

    public void onPause() {
        super.onPause();
        k();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    protected void onResume() {
        super.onResume();
        if (!this.q) {
            j();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0596r.e(d, "onSaveInstanceState");
        bundle.putBoolean(b, this.h);
        bundle.putBoolean(a, this.i);
        bundle.putSerializable(CaptureActivity.l, this.j);
    }
}
