package cn.com.smartdevices.bracelet.ui;

import a.a.a.C0001I;
import a.a.a.C0002K;
import a.a.a.G;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0623s;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.a.m;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.g;

public class UnlockScreenHelperActivity extends SystemBarTintActivity implements OnClickListener, OnCheckedChangeListener {
    private static final int A = -50;
    private static final int B = -70;
    private static final int C = -90;
    private static final boolean F = true;
    private static final int a = 0;
    private static final int b = 1;
    private static final String c = "unlockscreen";
    private View D;
    private boolean E = false;
    private G G = new fk(this);
    private C0002K H = new fl(this);
    private View d;
    private View e;
    private View f;
    private View g = null;
    private View h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private TextView o = null;
    private View p = null;
    private TextView q = null;
    private FrameLayout r = null;
    private TextView s = null;
    private View t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private C0001I x;
    private int y = a;
    private int z = 10;

    private void a() {
        this.t = findViewById(l.set_rssi_layout);
        this.u = (RadioButton) findViewById(l.rb_very_close);
        this.v = (RadioButton) findViewById(l.rb_close);
        this.w = (RadioButton) findViewById(l.rb_nearby);
        this.D = findViewById(l.set_success_tv);
        this.u.setOnCheckedChangeListener(this);
        this.v.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.r.setOnClickListener(this);
    }

    private void a(int i) {
        Intent intent = new Intent();
        if (i == b) {
            intent.putExtra("android.bluetooth.device.extra.NAME", Keeper.readBraceletBtInfo().b);
        }
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.MiuiSecurityBluetoothSettings"));
        startActivity(intent);
    }

    private void a(boolean z) {
        int i = z ? 8 : a;
        int i2 = z ? g.bg_color_blue : g.bg_color_grey;
        this.p.setVisibility(i);
        this.d.setBackgroundColor(getResources().getColor(i2));
        applyStatusBarTintAuto();
    }

    private void b() {
        if (C0623s.a(this)) {
            this.e.setVisibility(8);
            this.f.setVisibility(a);
            if (a.c()) {
                a((boolean) F);
                return;
            } else {
                a(false);
                return;
            }
        }
        boolean c = c();
        if (c) {
            this.g.setEnabled(false);
            this.j.setText(getString(r.unlock_screen_set_password_tips_has_set));
            this.k.setTextColor(getResources().getColor(g.disabled_text_color));
            this.h.setEnabled(F);
            this.i.setTextColor(getResources().getColor(g.main_ui_title_color));
        } else {
            this.g.setEnabled(F);
            this.j.setText(getString(r.unlock_screen_set_password_tips_set));
            this.k.setTextColor(getResources().getColor(g.main_ui_title_color));
            this.h.setEnabled(false);
            this.i.setTextColor(getResources().getColor(g.disabled_text_color));
        }
        if (c && Utils.o(getApplicationContext())) {
            this.o.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setVisibility(a);
            if (Integer.parseInt(Utils.f((Context) this)) < 4) {
                this.n.setText(r.unlock_screen_modify_unlock_v5);
            }
        } else if (d()) {
            this.o.setVisibility(a);
            this.m.setVisibility(a);
            this.l.setVisibility(8);
            this.d.setBackgroundColor(getResources().getColor(g.bg_color_blue));
            this.s.setVisibility(8);
            if (a.c()) {
                a((boolean) F);
            } else {
                a(false);
            }
        } else {
            this.o.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setVisibility(8);
            this.d.setBackgroundColor(getResources().getColor(g.bg_color_grey));
            this.s.setVisibility(a);
        }
    }

    private void b(int i) {
        C0596r.d(c, "setRssi rssi = " + i);
        boolean d;
        try {
            if (this.x == null) {
                if (!this.E) {
                    b.a((Context) this, (int) r.set_rssi_failed, (int) a).show();
                }
                this.E = false;
                return;
            }
            d = this.x.d(i);
            C0596r.d(c, "setRssi resturn = " + d);
            if (d) {
                Keeper.setRssiSignal(i);
                if (!this.E) {
                    b.a((Context) this, (int) r.set_rssi_success, (int) a).show();
                }
            } else if (!this.E) {
                b.a((Context) this, (int) r.set_rssi_failed, (int) a).show();
            }
            this.E = false;
        } catch (Exception e) {
            e.printStackTrace();
            C0596r.d(c, "setRssi Exception e = " + e);
            d = false;
        }
    }

    private void c(int i) {
        LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
        }
        layoutParams.topMargin = Utils.a(getApplicationContext(), (float) i);
        this.D.setLayoutParams(layoutParams);
    }

    @SuppressLint({"NewApi"})
    private boolean c() {
        return ((KeyguardManager) getSystemService("keyguard")).isKeyguardSecure();
    }

    private void d(int i) {
        this.t.setVisibility(i);
        switch (i) {
            case a /*0*/:
                c(13);
                return;
            case kankan.wheel.widget.a.ba /*8*/:
                c(76);
                return;
            default:
                return;
        }
    }

    private boolean d() {
        return Utils.m(this);
    }

    private void e() {
        boolean rssiLayoutVisible = Keeper.getRssiLayoutVisible();
        C0596r.d(c, "isVisible = " + rssiLayoutVisible);
        Keeper.setRssiLayoutVisible(!rssiLayoutVisible ? F : false);
        f();
    }

    private void f() {
        if (c() && Utils.o(getApplicationContext())) {
            boolean rssiLayoutVisible = Keeper.getRssiLayoutVisible();
            if (rssiLayoutVisible) {
                if (this.x == null) {
                    try {
                        this.x = new C0001I(this, Keeper.readBraceletBtInfo().b, this.G);
                        this.x.d();
                        C0596r.d(c, "invoke mUnlockProfile.connect()...");
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.x = null;
                    }
                }
                if (rssiLayoutVisible) {
                    d(a);
                    int rssiSignal = Keeper.getRssiSignal();
                    this.E = F;
                    switch (rssiSignal) {
                        case C /*-90*/:
                            this.w.setChecked(F);
                            return;
                        case B /*-70*/:
                            this.v.setChecked(F);
                            return;
                        case A /*-50*/:
                            this.u.setChecked(F);
                            return;
                        case a /*0*/:
                            this.w.setChecked(F);
                            return;
                        default:
                            return;
                    }
                }
                return;
            }
            d(8);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case l.rb_very_close /*2131297330*/:
                if (z) {
                    b((int) A);
                    return;
                }
                return;
            case l.rb_close /*2131297331*/:
                if (z) {
                    b((int) B);
                    return;
                }
                return;
            case l.rb_nearby /*2131297332*/:
                C0596r.d(c, "onCheckedChanged init...");
                if (z) {
                    b((int) C);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.unlock_screen_header_fl /*2131296821*/:
                this.y += b;
                if (this.y == this.z) {
                    this.y = a;
                    e();
                    return;
                }
                return;
            case l.unlock_screen_set_password_ll /*2131296825*/:
                a((int) a);
                return;
            case l.unlock_screen_set_unlock_ll /*2131296827*/:
                a((int) b);
                return;
            case l.unlock_screen_invalid_tv /*2131296833*/:
                Intent intent = new Intent(this, HelpActivity.class);
                intent.putExtra(Utils.a, Utils.e);
                startActivity(intent);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_unlock_screen_helper);
        this.d = findViewById(l.content);
        this.e = findViewById(l.unlock_for_miuilock);
        this.f = findViewById(l.unlock_for_smartlock);
        this.g = findViewById(l.unlock_screen_set_password_ll);
        this.g.setOnClickListener(this);
        this.h = findViewById(l.unlock_screen_set_unlock_ll);
        this.h.setOnClickListener(this);
        this.i = (TextView) findViewById(l.unlock_screen_set_unlock_tv);
        this.l = (LinearLayout) findViewById(l.has_unlock_with_bracelet_ll);
        this.m = (LinearLayout) findViewById(l.not_unlock_with_bracelet_ll);
        this.n = (TextView) findViewById(l.unlock_screen_modify_unlock_tv);
        this.p = findViewById(l.unlock_screen_mask_view);
        this.o = (TextView) findViewById(l.unlock_screen_tips_tv);
        this.q = (TextView) findViewById(l.unlock_screen_invalid_tv);
        this.q.getPaint().setFlags(this.q.getPaint().getFlags() | 8);
        this.q.setOnClickListener(this);
        this.j = (TextView) findViewById(l.unlock_screen_set_password_tips);
        this.k = (TextView) findViewById(l.unlock_screen_set_password_tv);
        this.r = (FrameLayout) findViewById(l.unlock_screen_header_fl);
        this.s = (TextView) findViewById(l.unlock_screen_miui_not_support_tv);
        a();
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        C0596r.d(c, "onDestroy...");
        if (this.x != null) {
            this.x.h();
            this.x.e();
        }
        if (Utils.o(this)) {
            C0401a.a((Context) this, C0401a.dS, C0401a.fG);
        } else {
            C0401a.a((Context) this, C0401a.dS, C0401a.fH);
        }
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        if (hwConnStatus.k()) {
            a((boolean) F);
        } else if (!c() || !Utils.o(getApplicationContext())) {
            a(false);
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.S);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        b();
        f();
        C0401a.a(C0401a.S);
        C0401a.a((Activity) this);
    }

    public void onStartSettingClick(View view) {
        if (C0623s.a(this)) {
            C0596r.e(c, "Start Setting For SmartLock!!");
            findViewById(l.start_setting).setEnabled(false);
            C0401a.a((Context) this, C0401a.fh);
            b.a((Context) this, (int) r.unlock_for_smartlock_pair_start_tip, (int) b).show();
            new m(new fj(this)).f();
        }
    }
}
