package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.l;
import com.huami.android.view.b;
import com.huami.android.widget.share.m;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.C1116c;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;

public class BindWeixinActivityNew extends SystemBarTintActivity implements OnClickListener {
    private static final String a = "BindWeixinActivityNew";
    private static final int b = 0;
    private static final int c = 2;
    private static final int d = 3;
    private Button e = null;
    private Handler f = null;
    private View g;
    private View h = null;
    private ImageView i = null;
    private TextView j = null;
    private IWXAPI k = null;
    private Context l = null;

    private void a() {
        l.c(a.f(this.l), a.d(this.l), new C0669P(this));
    }

    private void b() {
        this.g.setVisibility(8);
        this.mHomeBack.setBackgroundResource(R.color.bg_color_blue);
        this.h.setBackgroundResource(R.color.bg_color_blue);
        this.i.setBackgroundResource(R.drawable.bind_weixin_help_new);
        this.j.setText(R.string.bind_weixin_new_tips);
        this.e.setVisibility(b);
    }

    private void c() {
        this.g.setVisibility(b);
        this.mHomeBack.setBackgroundResource(R.color.bg_color_grey);
        this.h.setBackgroundResource(R.color.bg_color_grey);
        this.i.setBackgroundResource(R.drawable.bind_weixin_help_new_disable);
        this.j.setText(R.string.bind_weixin_new_disable_tips);
        this.e.setVisibility(8);
    }

    private void d() {
        this.f.sendEmptyMessage(c);
    }

    private void e() {
        this.f.sendEmptyMessage(d);
    }

    private void f() {
        Utils.a((Activity) this, (int) R.string.bind_weixin_new_now);
    }

    private void g() {
        Utils.a((Activity) this);
    }

    private void h() {
        new C1116c(new Q(this)).f();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_weixin_btn:
                if (Utils.l(this)) {
                    h();
                } else {
                    b.a((Context) this, (int) R.string.no_network_connection, (int) b).show();
                }
                C0401a.a((Context) this, C0401a.dR, C0401a.dT);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bind_weixin_new);
        this.l = getApplicationContext();
        this.e = (Button) findViewById(R.id.start_weixin_btn);
        this.e.setOnClickListener(this);
        this.g = findViewById(R.id.mask_view);
        this.h = findViewById(R.id.bind_weixin_new_img_ll);
        this.i = (ImageView) findViewById(R.id.bind_weixin_new_help_iv);
        this.j = (TextView) findViewById(R.id.bind_weixin_new_tips_tv);
        this.f = new O(this);
        EventBus.getDefault().register(this);
        this.k = WXAPIFactory.createWXAPI(this, m.j);
        this.k.registerApp(m.j);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(a, "onBleStatusChanged, status = " + hwConnStatus);
        if (hwConnStatus.k()) {
            b();
            applyStatusBarTintAuto();
            return;
        }
        c();
        applyStatusBarTintAuto();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.U);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        if (com.xiaomi.hm.health.bt.bleservice.a.c()) {
            b();
        } else {
            c();
        }
        C0401a.a((Activity) this);
        C0401a.a(C0401a.U);
    }
}
