package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.C0151az;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.l;
import com.c.b.c.b;
import com.c.b.g;
import com.huami.android.widget.share.m;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.C1116c;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Map;

public class BindWeixinActivity extends SystemBarTintActivity implements OnClickListener {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 500;
    private static final int h = 500;
    private static final int i = 1;
    private static final int j = 0;
    private static final String k = "BindWeixinActivity";
    private Button l = null;
    private Handler m = null;
    private String n = a.f;
    private MediaScannerConnection o = null;
    private String p = null;
    private Button q;
    private View r;
    private Context s = null;

    private Intent a(String str) {
        return getPackageManager().getLaunchIntentForPackage(str);
    }

    private void a() {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, m.j);
        createWXAPI.registerApp(m.j);
        if (createWXAPI.isWXAppInstalled()) {
            createWXAPI.openWXApp();
        }
    }

    private void a(int i) {
        if (i == i) {
            a(this.l, false);
            a(this.q, true);
        } else {
            a(this.l, true);
            a(this.q, false);
        }
        if (a(WXApp.WXAPP_PACKAGE_NAME) == null) {
            a(this.q, false);
            this.q.setText(R.string.start_weixin_not_installed);
        }
    }

    private void a(Button button, boolean z) {
        button.setEnabled(z);
        if (z) {
            button.setTextColor(getResources().getColor(R.color.main_ui_content_color));
        } else {
            button.setTextColor(getResources().getColor(R.color.disabled_text_color));
        }
    }

    private void b() {
        new C1116c(new K(this)).f();
    }

    private boolean b(String str) {
        boolean compress;
        Exception e;
        try {
            Map hashtable = new Hashtable();
            hashtable.put(g.CHARACTER_SET, kankan.wheel.widget.a.bO);
            b a = new com.c.b.i.b().a(str, com.c.b.a.QR_CODE, h, h, hashtable);
            int[] iArr = new int[250000];
            for (int i = j; i < h; i += i) {
                for (int i2 = j; i2 < h; i2 += i) {
                    if (a.a(i2, i)) {
                        iArr[(i * h) + i2] = C0151az.s;
                    } else {
                        iArr[(i * h) + i2] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(h, h, Config.ARGB_8888);
            createBitmap.setPixels(iArr, j, h, j, j, h, h);
            OutputStream fileOutputStream = new FileOutputStream(new File(this.p));
            compress = createBitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return compress;
            }
        } catch (Exception e3) {
            e = e3;
            compress = false;
            e.printStackTrace();
            return compress;
        }
        return compress;
    }

    private void c() {
        this.m.sendEmptyMessage(c);
    }

    private void d() {
        this.m.sendEmptyMessage(d);
    }

    private void e() {
        l.c(cn.com.smartdevices.bracelet.e.a.f(this.s), cn.com.smartdevices.bracelet.e.a.d(this.s), new L(this));
    }

    private void f() {
        new Thread(new M(this)).start();
    }

    private void g() {
        if (this.o != null && this.o.isConnected()) {
            this.o.disconnect();
        }
        this.o = new MediaScannerConnection(this, new N(this));
        this.o.connect();
    }

    private void h() {
        Utils.a((Activity) this, (int) R.string.bind_weixin_now);
    }

    private void i() {
        Utils.a((Activity) this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_weixin_btn:
                a();
                C0401a.a((Context) this, C0401a.dR, C0401a.dU);
                return;
            case R.id.gen_qr_code_btn:
                if (Utils.l(this)) {
                    b();
                } else {
                    com.huami.android.view.b.a((Context) this, (int) R.string.no_network_connection, (int) j).show();
                }
                C0401a.a((Context) this, C0401a.dR, C0401a.dT);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bind_weixin);
        this.s = getApplicationContext();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
        if (!file.exists()) {
            file.mkdirs();
        }
        this.p = file.getAbsolutePath() + "/" + getString(R.string.bind_weixin_qrcode_name) + ".jpg";
        this.l = (Button) findViewById(R.id.gen_qr_code_btn);
        this.l.setOnClickListener(this);
        this.q = (Button) findViewById(R.id.start_weixin_btn);
        this.q.setOnClickListener(this);
        this.r = findViewById(R.id.mask_view);
        this.m = new J(this);
        a((int) j);
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.o != null && this.o.isConnected()) {
            this.o.disconnect();
        }
        this.m.removeCallbacksAndMessages(null);
        this.m = null;
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        C0596r.e(k, "onBleStatusChanged, status = " + hwConnStatus);
        if (hwConnStatus.k()) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(j);
        }
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.U);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.U);
        C0401a.a((Activity) this);
    }
}
