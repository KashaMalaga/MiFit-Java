package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.ui.widget.c;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.bleservice.a;

public class SettingActivity_old extends SystemBarTintActivity {
    private static final String a = "SettingActivity";
    private c b;
    private ViewPager c;
    private ValueAnimator d;
    private TextView e;
    private TextView f;
    private C0674ad g;
    private Context h = this;

    private void c() {
        this.c = (ViewPager) findViewById(R.id.pager);
        this.g = new C0674ad(getFragmentManager());
        if (!DeviceSource.hasBindBracelet() && DeviceSource.hasBindWeight()) {
            C0401a.a(this.h, C0401a.fJ, "01");
        } else if (DeviceSource.hasBindBracelet() && DeviceSource.hasBindWeight()) {
            C0401a.a(this.h, C0401a.fJ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        }
        this.c.a(this.g);
        this.b = (c) findViewById(R.id.indicator);
        this.b.a(this.c);
        this.e = (TextView) findViewById(R.id.band_txt);
        this.f = (TextView) findViewById(R.id.weight_txt);
        if (!b.h().l.a.booleanValue()) {
            this.f.setVisibility(8);
        }
        a();
        this.b.a(new dP(this));
        this.e.setOnClickListener(new dQ(this));
        this.f.setOnClickListener(new dR(this));
    }

    private void d() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Utils.a);
            C0596r.e(a, "type = " + stringExtra);
            if (Utils.c.equals(stringExtra)) {
                this.c.a(1, true);
                this.f.setAlpha(1.0f);
                this.e.setAlpha(0.5f);
            }
        }
        if (t.a()) {
            this.e.setTextSize(14.0f);
            this.f.setTextSize(14.0f);
        }
    }

    public void a() {
        getResources().getColor(R.color.bg_color_grey);
        int color = DeviceSource.hasBindBracelet() ? a.c() ? getResources().getColor(R.color.bg_mode_step) : getResources().getColor(R.color.bg_color_grey) : getResources().getColor(R.color.bg_color_grey);
        int color2 = DeviceSource.hasBindWeight() ? getResources().getColor(R.color.bg_mode_weight) : getResources().getColor(R.color.bg_color_grey);
        this.c.a(this.c.c(), true);
        this.d = (ValueAnimator) cn.com.smartdevices.bracelet.chart.util.a.a(color, color2, new dS(this), this.c);
        if (this.c.c() == 0) {
            this.c.setBackgroundColor(color);
        } else {
            this.c.setBackgroundColor(color2);
        }
    }

    public void b() {
        super.applyStatusBarTintAuto();
        a();
        this.g.c();
    }

    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0784ee c0784ee = (C0784ee) getFragmentManager().findFragmentByTag(C0784ee.class.getName());
        C0596r.e(a, "setting fragment =" + c0784ee);
        if (c0784ee != null) {
            c0784ee.onActivityResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings_old);
        c();
        d();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0596r.e(a, "onNewIntent");
    }

    protected void onPause() {
        super.onPause();
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
        if (DeviceSource.getDeviceCount() <= 1) {
            ((View) this.b).setVisibility(8);
        }
    }
}
