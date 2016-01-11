package cn.com.smartdevices.bracelet.shoes.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import com.huami.android.zxing.CaptureActivity;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.bt.a.w;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.c.A;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.d.d;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.profile.a;
import com.xiaomi.hm.health.bt.profile.b.j;
import com.xiaomi.hm.health.bt.profile.c.g;
import com.xiaomi.hm.health.bt.profile.c.h;
import com.xiaomi.hm.health.c.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ShoesBindTestActivity extends Activity implements A, b, d, f, com.xiaomi.hm.health.bt.profile.c.f {
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 1;
    private static final String k = "ShoesBindTestActivity";
    private h h = h.UNKNOWN;
    private j i = null;
    private long j = 0;
    private final String l = "v1.2.2";
    private Button m = null;
    private String n = null;
    private Handler o = null;
    private Button p = null;
    private TextView q = null;
    private Context r = null;
    private Button s = null;
    private com.xiaomi.hm.health.bt.profile.c.d t = com.xiaomi.hm.health.bt.profile.c.d.a();
    private WakeLock u = null;
    private com.xiaomi.hm.health.bt.profile.a.j v = null;
    private ProgressDialog w = null;
    private int x = 0;

    private void a() {
        RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(d)).play();
    }

    private void a(String str) {
        Message message = new Message();
        message.what = g;
        message.obj = str;
        this.o.sendMessage(message);
    }

    private void a(List<com.xiaomi.hm.health.bt.model.b<com.xiaomi.hm.health.bt.model.d>> list) {
        for (com.xiaomi.hm.health.bt.model.b bVar : list) {
            C0596r.e(k, bVar.toString());
            for (com.xiaomi.hm.health.bt.model.d dVar : bVar.b) {
                C0596r.d(k, dVar.toString());
            }
        }
    }

    private void b() {
        g gVar = new g(this.n);
        gVar.a(true).a(c.SHOES).a((com.xiaomi.hm.health.bt.profile.c.f) this).a(g, 60000).b(false);
        this.j = System.currentTimeMillis();
        this.i = (j) this.t.a(getApplicationContext(), gVar);
    }

    private void b(int i) {
        C0596r.d(k, "onDeviceStatusChanged:" + i);
    }

    private void c() {
        if (this.i != null) {
            this.t.a(this.i);
        }
    }

    private void d() {
        if (this.u == null) {
            this.u = ((PowerManager) getSystemService("power")).newWakeLock(26, getClass().getCanonicalName());
            this.u.acquire();
        }
    }

    private void e() {
        if (this.u != null && this.u.isHeld()) {
            this.u.release();
            this.u = null;
        }
    }

    private Intent f() {
        Intent c = CaptureActivity.c(this);
        c.putExtra(CaptureActivity.d, getResources().getString(m.shoes_bind_prompt));
        c.putExtra(CaptureActivity.f, getResources().getString(m.shoes_bind_title));
        c.putExtra(CaptureActivity.h, true);
        c.putExtra(CaptureActivity.g, true);
        c.putExtra(CaptureActivity.j, g);
        c.putExtra(CaptureActivity.k, 8);
        return c;
    }

    private void f(BluetoothDevice bluetoothDevice) {
        C0596r.e(k, "connectOldShoe");
        this.v = new com.xiaomi.hm.health.bt.profile.a.j(this, bluetoothDevice, this);
        this.v.a(false);
        this.v.a(new C0661r(this));
        this.v.a();
    }

    private void g() {
        List arrayList = new ArrayList(d);
        cn.com.smartdevices.bracelet.shoes.model.j jVar = new cn.com.smartdevices.bracelet.shoes.model.j("LNA", g);
        jVar.h = 100;
        jVar.g = "Hello my name is GuangSu";
        jVar.c = "http://g.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=625a044bd21b0ef478e5900cbcad3abf/08f790529822720eca6bae9f7bcb0a46f21fab2a.jpg";
        arrayList.add(jVar);
        jVar = new cn.com.smartdevices.bracelet.shoes.model.j("LNA", d);
        jVar.h = v.C;
        jVar.g = "Hello my name is LieJun";
        jVar.c = "http://g.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=625a044bd21b0ef478e5900cbcad3abf/08f790529822720eca6bae9f7bcb0a46f21fab2a.jpg";
        arrayList.add(jVar);
        t.c((Context) this, arrayList);
    }

    private void h() {
        C0596r.e(k, "sendUserInfo");
        new w(this.v, new UserInfo(259665048, (byte) 0, (byte) 23, (byte) -86, (byte) 65, "txd".getBytes()), new C0662s(this)).f();
    }

    private void i() {
        String str = Environment.getExternalStorageDirectory().getPath() + "/running.fw";
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream open = getResources().getAssets().open("running.fw");
            C0596r.e(k, "new fw length:" + open.available());
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            open.close();
            fileOutputStream.close();
            if (this.i != null) {
                i e = this.i.e();
                if (e != null) {
                    String str2 = e.c;
                    C0596r.e(k, "new version:v1.2.2,current version:" + str2);
                    if (a.a(str2) >= a.a("v1.2.2")) {
                        Toast.makeText(this.r, "\u8dd1\u978b\u56fa\u4ef6\u662f\u6700\u65b0\u7684\uff0c\u65e0\u9700\u5347\u7ea7\uff01", 0).show();
                        return;
                    } else {
                        this.i.a(str, (b) this);
                        return;
                    }
                }
            }
            Toast.makeText(this.r, "\u672a\u8fde\u63a5\u8dd1\u978b\uff0c\u5347\u7ea7\u5931\u8d25\uff01", 0).show();
        } catch (Exception e2) {
            C0596r.e(k, e2.getMessage());
        }
    }

    private void j() {
        C0596r.e(k, "fwUpgrade");
        try {
            InputStream open = getResources().getAssets().open("running.fw");
            C0596r.e(k, "new fw length:" + open.available());
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            new com.xiaomi.hm.health.bt.a.h(this.v, this.n, bArr, this).f();
        } catch (IOException e) {
        }
    }

    private void k() {
        if (this.i != null) {
            this.i.a((f) this);
        }
    }

    private void l() {
        if (this.i != null) {
            this.i.d();
        }
    }

    private void m() {
        if (this.i != null) {
            this.i.c(new C0663t(this));
        }
    }

    public void a(int i) {
        C0596r.e(k, "sensor data onStatusChanged:" + i);
    }

    public void a(BluetoothDevice bluetoothDevice) {
        C0596r.d(k, "onDeviceConnected");
        a("\u5df2\u7ecf\u8fde\u4e0aGATT");
    }

    public void a(com.xiaomi.hm.health.bt.model.m mVar) {
        C0596r.e(k, "new steps:" + mVar);
        Message message = new Message();
        message.what = d;
        message.arg1 = mVar.d();
        message.arg2 = mVar.d();
        this.o.sendMessage(message);
    }

    public void a(h hVar) {
        C0596r.e(k, "ProfileStatus:" + hVar);
        a(hVar.toString());
        switch (C0664u.a[hVar.ordinal()]) {
            case g /*1*/:
                C0596r.e(k, "===========================================");
                C0596r.e(k, "==============connect<" + (System.currentTimeMillis() - this.j) + "ms>==============");
                C0596r.e(k, "===========================================");
                break;
            case d /*2*/:
                if (this.h == h.CONNECTED) {
                    a();
                    break;
                }
                break;
            case e /*3*/:
                C0596r.e(k, "===========================================");
                C0596r.e(k, "==============search<" + (System.currentTimeMillis() - this.j) + "ms>==============");
                C0596r.e(k, "===========================================");
                break;
        }
        this.h = hVar;
    }

    public void a(short s, short s2, short s3) {
        C0596r.e(k, "[" + s + com.xiaomi.mipush.sdk.f.i + s2 + com.xiaomi.mipush.sdk.f.i + s3 + "]");
    }

    public void b(BluetoothDevice bluetoothDevice) {
        C0596r.d(k, "onDeviceConnectionFailed");
        a("\u8fde\u63a5\u5931\u8d25");
    }

    public void c(BluetoothDevice bluetoothDevice) {
        C0596r.d(k, "onDeviceDisconnected");
        a("\u8fde\u63a5\u65ad\u5f00");
    }

    public void d(BluetoothDevice bluetoothDevice) {
        C0596r.d(k, "onInitializationFailed");
        a("\u521d\u59cb\u5316\u5931\u8d25");
    }

    public void e(BluetoothDevice bluetoothDevice) {
        C0596r.d(k, "onInitializationSuccess");
        a("\u521d\u59cb\u5316\u6210\u529f");
        if (this.v != null) {
            this.o.sendEmptyMessage(e);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == g) {
            if (i2 == -1) {
                intent.getByteArrayExtra(CaptureActivity.a);
                String stringExtra = intent.getStringExtra(CaptureActivity.b);
                if (stringExtra != null) {
                    stringExtra = cn.com.smartdevices.bracelet.shoes.a.c.a(stringExtra, cn.com.smartdevices.bracelet.shoes.model.d.k);
                    if (stringExtra == null) {
                        ((TextView) findViewById(com.xiaomi.hm.health.c.h.shoes_mac)).setText("\u975e\u674e\u5b81\u8dd1\u978b\u4e8c\u7ef4\u7801");
                        return;
                    }
                    this.n = stringExtra;
                    ((TextView) findViewById(com.xiaomi.hm.health.c.h.shoes_mac)).setText("\u8dd1\u978b\u84dd\u7259\u5730\u5740:" + this.n);
                    return;
                }
            }
            ((TextView) findViewById(com.xiaomi.hm.health.c.h.shoes_mac)).setText(com.xiaomi.e.a.f);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.xiaomi.hm.health.c.i.activity_shoes_bind_test);
        this.r = this;
        d();
        findViewById(com.xiaomi.hm.health.c.h.scan).setOnClickListener(new x(this));
        this.m = (Button) findViewById(com.xiaomi.hm.health.c.h.shoe_bind);
        this.m.setOnClickListener(new y(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_sync_data).setOnClickListener(new z(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_fw_upgrade).setOnClickListener(new A(this));
        this.q = (TextView) findViewById(com.xiaomi.hm.health.c.h.shoe_rt_steps);
        this.p = (Button) findViewById(com.xiaomi.hm.health.c.h.shoe_sensor_data);
        this.p.setOnClickListener(new B(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_disconnect).setOnClickListener(new C(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_get_realtime_steps).setOnClickListener(new C0652i(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_get_battery_level).setOnClickListener(new C0653j(this));
        this.s = (Button) findViewById(com.xiaomi.hm.health.c.h.shoe_calibrate_new);
        this.s.setTag("start_calibrate");
        this.s.setOnClickListener(new C0655l(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_latency).setOnClickListener(new C0657n(this));
        findViewById(com.xiaomi.hm.health.c.h.shoe_quit).setOnClickListener(new C0659p(this));
        this.o = new C0660q(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        c();
        e();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == f ? true : super.onKeyDown(i, keyEvent);
    }

    public void onStart(int i) {
        C0596r.d(k, "onStart:" + i);
        runOnUiThread(new C0651h(this));
    }

    public void onStop(int i) {
        C0596r.d(k, "onStop:" + i);
        runOnUiThread(new C0665v(this, i));
    }

    public void report(int i) {
        C0596r.d(k, "report:" + i);
        runOnUiThread(new C0666w(this, i));
    }

    public void setMax(int i) {
        C0596r.d(k, "setMax:" + i);
        this.x = i;
    }
}
