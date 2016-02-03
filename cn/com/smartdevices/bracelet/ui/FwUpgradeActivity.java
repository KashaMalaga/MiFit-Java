package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.a.C0113o;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.upgrade.FwUpgradeManager;
import cn.com.smartdevices.bracelet.upgrade.c;
import cn.com.smartdevices.bracelet.upgrade.d;
import cn.com.smartdevices.bracelet.upgrade.e;
import cn.com.smartdevices.bracelet.view.FirmwareUpgradeShoesView;
import com.xiaomi.hm.health.R;

public class FwUpgradeActivity extends Activity {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final String d = "FwUpgradeActivity";
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private static final int i = 1000;
    private Animator A;
    private Context j = null;
    private Handler k = null;
    private boolean l = false;
    private int m = a;
    private View n;
    private TextView o = null;
    private TextView p = null;
    private TextView q = null;
    private LinePieChartView r = null;
    private RelativeLayout s;
    private FirmwareUpgradeShoesView t = null;
    private FwUpgradeManager u;
    private long v = 0;
    private long w = 0;
    private int x = a;
    private int y = a;
    private int z;

    private void a(int i) {
        TextView textView;
        Object[] objArr;
        Object[] objArr2;
        if (i == 0) {
            this.s.setVisibility(8);
            this.r.setVisibility(a);
            textView = this.p;
            objArr = new Object[e];
            objArr[a] = getString(R.string.devices_miband_label);
            textView.setText(getString(R.string.fw_upgrade_sub_title, objArr));
            this.r.a(6);
            int i2 = (this.u == null || !this.u.isExceptForHrFw()) ? a : e;
            this.n.setBackgroundColor(getResources().getColor(i2 != 0 ? R.color.bg_mode_mili_hr_fw_upgrade : R.color.bg_mode_mili_fw_upgrade));
            TextView textView2 = this.o;
            objArr2 = new Object[e];
            objArr2[a] = getString(i2 != 0 ? R.string.devices_miband_hr_label : R.string.devices_miband_label);
            textView2.setText(getString(R.string.fw_upgrade_title, objArr2));
        } else if (i == e) {
            this.s.setVisibility(8);
            this.r.setVisibility(a);
            textView = this.o;
            objArr = new Object[e];
            objArr[a] = getString(R.string.devices_scale_label);
            textView.setText(getString(R.string.fw_upgrade_title, objArr));
            textView = this.p;
            objArr2 = new Object[e];
            objArr2[a] = getString(R.string.devices_scale_label);
            textView.setText(getString(R.string.fw_upgrade_sub_title, objArr2));
            this.r.a(5);
            this.n.setBackgroundColor(getResources().getColor(R.color.bg_mode_weight_fw_upgrade));
        } else if (i == f) {
            this.s.setVisibility(a);
            textView = this.o;
            objArr = new Object[e];
            objArr[a] = getString(R.string.devices_shoes_label);
            textView.setText(getString(R.string.fw_upgrade_title, objArr));
            textView = this.p;
            objArr2 = new Object[e];
            objArr2[a] = getString(R.string.devices_shoes_label);
            textView.setText(getString(R.string.fw_upgrade_sub_title, objArr2));
            this.r.setVisibility(8);
            this.n.setBackgroundColor(getResources().getColor(R.color.bg_mode_shoes_fw_upgrade));
        }
    }

    private void a(int i, int i2) {
        if (this.A != null && this.A.isStarted()) {
            this.A.end();
        }
        int[] iArr = new int[f];
        iArr[a] = i;
        iArr[e] = i2;
        Animator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.addUpdateListener(new aX(this));
        ofInt.setDuration(1000);
        ofInt.start();
        this.A = ofInt;
    }

    private void c() {
        getWindow().addFlags(C0113o.h);
    }

    private void d() {
        getWindow().clearFlags(C0113o.h);
    }

    private void e() {
        C0596r.e(d, "updateProgress, " + this.x + ", " + this.y);
        a(this.x, this.y);
        this.x = this.y;
    }

    public void a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadein);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadein);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadein);
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadein);
        loadAnimation.setStartOffset(0);
        loadAnimation2.setStartOffset(100);
        loadAnimation3.setStartOffset(150);
        loadAnimation4.setStartOffset(200);
        loadAnimation4.setAnimationListener(new aS(this));
        Interpolator decelerateInterpolator = new DecelerateInterpolator(2.0f);
        loadAnimation.setInterpolator(decelerateInterpolator);
        loadAnimation2.setInterpolator(decelerateInterpolator);
        loadAnimation3.setInterpolator(decelerateInterpolator);
        loadAnimation4.setInterpolator(decelerateInterpolator);
        if (this.m == f) {
            this.t.startAnimation(loadAnimation);
        } else {
            this.r.startAnimation(loadAnimation);
        }
        this.o.startAnimation(loadAnimation2);
        this.p.startAnimation(loadAnimation3);
        this.q.startAnimation(loadAnimation4);
    }

    public void b() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadeout);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadeout);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadeout);
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.fw_item_fadeout);
        loadAnimation.setStartOffset(0);
        loadAnimation4.setStartOffset(100);
        loadAnimation3.setStartOffset(150);
        loadAnimation2.setStartOffset(200);
        loadAnimation.setAnimationListener(new aT(this));
        loadAnimation2.setAnimationListener(new aU(this));
        loadAnimation3.setAnimationListener(new aV(this));
        loadAnimation4.setAnimationListener(new aW(this));
        Interpolator accelerateInterpolator = new AccelerateInterpolator(2.0f);
        loadAnimation.setInterpolator(accelerateInterpolator);
        loadAnimation2.setInterpolator(accelerateInterpolator);
        loadAnimation3.setInterpolator(accelerateInterpolator);
        loadAnimation4.setInterpolator(accelerateInterpolator);
        if (this.m == f) {
            this.t.startAnimation(loadAnimation);
        } else {
            this.r.startAnimation(loadAnimation);
        }
        this.o.startAnimation(loadAnimation2);
        this.p.startAnimation(loadAnimation3);
        this.q.startAnimation(loadAnimation4);
    }

    public void onBackPressed() {
        if (this.l) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_fw_upgrade);
        this.j = getApplicationContext();
        this.u = FwUpgradeManager.getDefault(this);
        this.u.register(this);
        this.n = findViewById(R.id.fw_upgrade_all);
        this.o = (TextView) findViewById(R.id.fw_title_tv);
        this.p = (TextView) findViewById(R.id.fw_tips_tv);
        this.r = (LinePieChartView) findViewById(R.id.line_pie_chart);
        this.s = (RelativeLayout) findViewById(R.id.shoes_layout);
        this.t = (FirmwareUpgradeShoesView) findViewById(R.id.shoe_update_progress);
        this.q = (TextView) findViewById(R.id.fw_progress_tv);
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getIntExtra(SettingContainerActivity.a, a);
        }
        a(this.m);
        this.k = new aR(this);
        c();
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.k.removeCallbacksAndMessages(null);
        this.k = null;
        d();
        this.u.clean(this);
    }

    public void onEvent(c cVar) {
        if (this.k != null) {
            this.k.post(new aQ(this));
        }
    }

    public void onEvent(d dVar) {
        if (this.k != null) {
            Message message = new Message();
            message.what = h;
            message.arg1 = this.u.getResult();
            this.k.sendMessage(message);
        }
    }

    public void onEvent(e eVar) {
        if (this.k != null) {
            this.m = this.u.getCurrentUpgradeType();
            this.y = this.u.getCurrentProgress();
            this.z = this.u.getMaxProgress();
            this.k.sendEmptyMessage(e);
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.X);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
        C0401a.a(C0401a.X);
    }
}
