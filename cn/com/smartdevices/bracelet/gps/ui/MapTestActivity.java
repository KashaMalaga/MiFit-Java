package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.g;
import cn.com.smartdevices.bracelet.gps.f.n;
import cn.com.smartdevices.bracelet.gps.h.f;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.az;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.xiaomi.hm.health.R;
import java.util.List;

public class MapTestActivity extends SystemBarTintActivity implements OnClickListener, a, OnMapLoadedListener {
    static final int a = 100;
    private static final int b = 50;
    private static final int c = 0;
    private static final int d = 1;
    private static final double m = 0.001d;
    private static final double n = 0.002d;
    private static final int r = 1000;
    private static final int s = 300;
    private g e = null;
    private MapView f = null;
    private final View g = null;
    private final TextView h = null;
    private final long i = -1;
    private aC j = aC.STOPPED;
    private AMap k = null;
    private n l = null;
    private int o = -1;
    private boolean p = true;
    private final Handler q = new aB(this);
    private List<c> t = null;

    private void a() {
        if (this.f != null) {
            try {
                this.f.onDestroy();
            } catch (Exception e) {
                C0596r.d("Run", e.getMessage());
            }
        }
    }

    private void b() {
        this.t = B.a();
    }

    private void c() {
        this.k.setMyLocationType(d);
    }

    private void d() {
        this.k.setMyLocationType(2);
    }

    private void e() {
        this.k.setMyLocationType(2);
    }

    private void f() {
        this.k.setMyLocationType(d);
    }

    public void a(int i, boolean z) {
    }

    public void a(long j) {
    }

    public void a(az azVar) {
        if (azVar != null) {
            Message obtain = Message.obtain();
            obtain.what = d;
            obtain.obj = azVar;
        }
    }

    public void b(int i, int i2) {
    }

    public void onBackPressed() {
        if (this.j == aC.STOPPED) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_nav_right:
                startActivity(new Intent(this, HistoryActivity.class));
                return;
            case R.id.left_button:
                if (this.j != aC.PAUSED) {
                    this.j = aC.PAUSED;
                    c();
                    this.h.setText("resume");
                    return;
                }
                this.j = aC.RESUMED;
                d();
                this.h.setText("pause");
                return;
            case R.id.right_button:
                this.j = aC.STOPPED;
                f();
                Intent intent = new Intent(getApplicationContext(), GPSResultActivity.class);
                intent.putExtra(C0483q.a, -1);
                startActivity(intent);
                this.g.setVisibility(c);
                finish();
                return;
            case R.id.start:
                this.j = aC.STARTED;
                e();
                this.g.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_running_gps_main);
        this.f = (MapView) findViewById(R.id.map);
        this.f.onCreate(bundle);
        this.k = this.f.getMap();
        this.k.setOnMapLoadedListener(this);
        UiSettings uiSettings = this.k.getUiSettings();
        uiSettings.setRotateGesturesEnabled(false);
        uiSettings.setScaleControlsEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setTiltGesturesEnabled(false);
        this.k.setMyLocationEnabled(false);
        this.k.setMyLocationType(d);
        this.e = new g(this, new C(this.k));
        this.e.a(this.f.getMap());
        this.e.d((int) d);
        this.e.a((a) this);
        this.l = new n(this, this.k);
        b();
    }

    public void onDestroy() {
        if (this.e != null) {
            this.e.a((Context) this);
        }
        a();
        super.onDestroy();
        C0596r.e("Run", "onDestroy");
    }

    public void onMapLoaded() {
        Message obtain = Message.obtain();
        obtain.what = r;
        this.q.sendMessageDelayed(obtain, 300);
    }

    public void onPause() {
        this.f.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f.onResume();
        this.e.a(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        if (!f.b(this)) {
            com.huami.android.view.c.showPanel((Activity) this, aD.class);
        }
    }
}
