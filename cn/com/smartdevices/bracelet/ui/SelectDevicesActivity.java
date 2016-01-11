package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import com.huami.android.view.b;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;

public class SelectDevicesActivity extends SystemBarTintActivity implements OnClickListener {
    private static final boolean a = true;
    private static final int b = 0;
    private static final int c = 1;
    private static final long d = 600;
    private View e;
    private View f;
    private View g;
    private View h;
    private TextView i;
    private TextView j;
    private AlphaAnimation k;
    private AnimationSet l;
    private RotateAnimation m;
    private AnimationSet n;

    private void a() {
        this.l = new AnimationSet(a);
        this.n = new AnimationSet(a);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) getResources().getDimensionPixelSize(j.band_translate_y));
        translateAnimation.setDuration(d);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.54f, 1.0f, 1.54f, c, 0.5f, 2, 0.0f);
        this.m = new RotateAnimation(0.0f, 90.0f, c, 0.5f, c, 0.5f);
        this.m.setDuration(d);
        this.m.setFillAfter(a);
        this.l.addAnimation(scaleAnimation);
        this.l.addAnimation(translateAnimation);
        this.l.setDuration(d);
        this.l.setFillAfter(a);
        translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getResources().getDimensionPixelSize(j.weight_trans_y)));
        scaleAnimation = new ScaleAnimation(1.0f, 1.378f, 1.0f, 1.378f, c, 0.5f, 2, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.7f);
        this.n.addAnimation(scaleAnimation);
        this.n.addAnimation(translateAnimation);
        this.n.addAnimation(alphaAnimation);
        this.n.setDuration(d);
        this.n.setFillAfter(a);
        this.k = new AlphaAnimation(1.0f, 0.0f);
        this.k.setDuration(d);
        this.k.setFillAfter(a);
    }

    private void b() {
        this.h = findViewById(l.select_devices_band_area);
        this.g = findViewById(l.select_devices_scale_area);
        this.e = findViewById(l.select_devices_band_icon);
        this.f = findViewById(l.select_devices_scale_icon);
        this.i = (TextView) findViewById(l.select_devices_band_txt);
        this.j = (TextView) findViewById(l.select_devices_scale_txt);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        findViewById(l.select_devices_exit).setOnClickListener(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 0 || i == c) && i2 == -1) {
            finish();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.select_devices_band_icon /*2131297457*/:
                if (DeviceSource.hasBindBracelet()) {
                    b.a((Context) this, (int) r.bind_bracelet_ok, (int) c).show();
                    finish();
                    return;
                }
                C0401a.a((Context) this, C0409b.S);
                this.i.startAnimation(this.k);
                this.g.startAnimation(this.k);
                this.e.startAnimation(this.m);
                this.h.startAnimation(this.l);
                this.e.postDelayed(new dA(this), 550);
                return;
            case l.select_devices_scale_icon /*2131297460*/:
                if (DeviceSource.hasBindWeight()) {
                    b.a((Context) this, (int) r.bind_weight_ok, (int) c).show();
                    finish();
                    return;
                }
                C0401a.a((Context) this, C0409b.aj);
                this.j.startAnimation(this.k);
                this.h.startAnimation(this.k);
                this.g.startAnimation(this.n);
                this.j.postDelayed(new dB(this), 550);
                return;
            case l.select_devices_exit /*2131297462*/:
                C0401a.a((Context) this, C0409b.V, C0410c.n, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP);
                C0401a.a((Context) this, C0409b.an, C0410c.n, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP);
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, SettingActivity.class);
        intent.putExtra(SettingActivity.a, a);
        startActivity(intent);
        finish();
    }
}
