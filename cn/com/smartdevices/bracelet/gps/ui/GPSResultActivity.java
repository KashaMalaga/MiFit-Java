package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.j;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.az;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.shoes.model.d;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.WeightedLatLng;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.widget.share.h;
import com.huami.android.widget.share.l;
import com.huami.android.widget.share.q;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.util.List;

public class GPSResultActivity extends CustomActionBarActivity implements OnClickListener, ar, OnMapLoadedListener, OnMapScreenShotListener {
    public static final String a = "trackcontour";
    public static final int b = 1;
    private static final String i = "sharedMap.jpg";
    private static final String j = "tmpmap.jpg";
    private static final String k = "GPSResultActivity";
    private static final String l = "yyyy/M/d  HH:mm";
    private String A = null;
    private TextView B = null;
    private TextView C = null;
    private final TextView D = null;
    private TextView E = null;
    private File F = null;
    private long G = -1;
    private j H = null;
    private final l I = null;
    private ImageView J = null;
    private boolean K = false;
    private h L = null;
    private View M = null;
    private Bitmap N = null;
    private Bitmap O = null;
    private View P = null;
    private Bitmap Q = null;
    private TextView R = null;
    private TextView S = null;
    private TextView T = null;
    private cn.com.smartdevices.bracelet.gps.e.h U = null;
    private View V = null;
    private k c;
    private TextView d;
    private List<c> f = null;
    private boolean g = false;
    private boolean h = false;
    private final TextView m = null;
    private AMap n = null;
    private TextView o = null;
    private String p = a.f;
    private TextView q = null;
    private TextView r = null;
    private MapView s = null;
    private J t = null;
    private boolean u;
    private boolean v = false;
    private View w = null;
    private TextView x = null;
    private Button y = null;
    private View z = null;

    public GPSResultActivity() {
        super(C0401a.am, C0401a.am);
    }

    public GPSResultActivity(String str, String str2) {
        super(C0401a.am, C0401a.am);
    }

    private int a(C0466z c0466z) {
        if (c0466z.y() < 0) {
            return -1;
        }
        if (c0466z.f() >= 0) {
            return c0466z.f();
        }
        long z = c0466z.z() - c0466z.x();
        if (c0466z.z() <= 0) {
            z = c0466z.F();
        }
        return z > 0 ? (int) (((long) (c0466z.y() * 60)) / z) : 0;
    }

    private Point a(View view) {
        int left = view.getLeft() + view.getPaddingLeft();
        int top = view.getTop() + view.getPaddingTop();
        ViewParent parent = view.getParent();
        int i = left;
        left = top;
        while (parent != null && (parent instanceof View)) {
            i += ((View) parent).getLeft();
            top = ((View) parent).getTop() + left;
            parent = parent.getParent();
            left = top;
        }
        return new Point(i, left);
    }

    private synchronized l a(Bitmap bitmap) {
        l lVar = null;
        synchronized (this) {
            if (this.L == null) {
                bitmap.recycle();
            } else if (this.N == null || this.N.isRecycled()) {
                throw new IllegalStateException();
            } else {
                c(this.A);
                Bitmap a = cn.com.smartdevices.bracelet.gps.h.c.a(bitmap, this.N, 5);
                bitmap.recycle();
                a = cn.com.smartdevices.bracelet.gps.h.c.a(a, this.O, (a.getWidth() - this.O.getWidth()) / 2, 30);
                Bitmap a2 = cn.com.smartdevices.bracelet.gps.h.c.a(a, this.Q, 5);
                boolean a3 = cn.com.smartdevices.bracelet.gps.h.c.a(this.A, a2, 90);
                a2.recycle();
                a.recycle();
                if (a3) {
                    lVar = b(this.A);
                }
            }
        }
        return lVar;
    }

    private boolean a(long j) {
        C0596r.g(k, "isWithPaceDetailList");
        return j > 0 && p.h((Context) this, j);
    }

    private l b(String str) {
        l lVar = new l();
        lVar.a = getString(n.running_share_to_sport_trace);
        b.h().g.getClass();
        lVar.d = "http://paopaotuan.org/";
        lVar.c = a.f;
        lVar.e = str;
        lVar.b = getString(n.running_share_to_topic);
        return lVar;
    }

    private void b(C0466z c0466z) {
        if (c0466z != null) {
            cn.com.smartdevices.bracelet.gps.e.j a = this.U.a((double) (c0466z.C() / 1000.0f));
            this.q.setText(cn.com.smartdevices.bracelet.gps.h.h.b((float) a.a, 2));
            if ((this.c == k.British || !a(this.G)) && (this.c != k.British || a.a - WeightedLatLng.DEFAULT_INTENSITY <= 0.0d)) {
                findViewById(i.to_pace_detail).setVisibility(8);
            } else {
                this.V = findViewById(i.distance_container);
                this.V.setOnClickListener(this);
            }
            this.E.setText(cn.com.smartdevices.bracelet.gps.ui.b.a.a(c0466z.F(), true));
            int a2 = a(c0466z);
            if (a2 >= 0) {
                this.C.setText(String.valueOf(a2));
            } else {
                this.C.setText(getResources().getString(n.data_not_supported));
            }
            if (this.D != null) {
                this.D.setText(String.valueOf(c0466z.y()));
            }
            if (((double) cn.com.smartdevices.bracelet.gps.h.i.b(c0466z.e())) < 0.01d) {
                this.x.setText(cn.com.smartdevices.bracelet.gps.ui.b.a.a(0));
            } else {
                this.x.setText(cn.com.smartdevices.bracelet.gps.ui.b.a.a((long) this.U.b((double) cn.com.smartdevices.bracelet.gps.h.i.c(c0466z.d())).a));
            }
            if (this.m != null) {
                this.m.setText(c0466z.m()[0] + "/" + c0466z.m()[b]);
            }
            this.o.setText(a.f + ((int) c0466z.i()));
            az A = c0466z.A();
            if (A == null || !A.g().contains(d.k)) {
                this.J.setImageDrawable(getResources().getDrawable(com.xiaomi.hm.health.b.a.h.running_shoes_1));
            } else {
                this.J.setImageDrawable(getResources().getDrawable(com.xiaomi.hm.health.b.a.h.running_shoes_2));
                if (c0466z.l() >= 0) {
                    this.r.setText(c0466z.l() + "%");
                }
            }
            if (cn.com.smartdevices.bracelet.gps.e.b.d()) {
                a2 = c0466z.g();
                this.d.setText(HeartRateInfo.isHRValueValid(a2) ? String.valueOf(a2) : getResources().getString(n.hr_empty_data));
                return;
            }
            Object[] objArr = new Object[b];
            objArr[0] = Double.valueOf((this.U.a((double) c0466z.C()).a / ((double) c0466z.F())) * 3.6d);
            this.B.setText(String.format("%.2f", objArr));
        }
    }

    private void c(Bundle bundle) {
        e.a("GPS", "init");
        this.s = (MapView) findViewById(i.map);
        this.s.onCreate(bundle);
        this.n = this.s.getMap();
        this.n.setOnMapLoadedListener(this);
        UiSettings uiSettings = this.n.getUiSettings();
        uiSettings.setRotateGesturesEnabled(false);
        uiSettings.setScaleControlsEnabled(false);
        uiSettings.setTiltGesturesEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        this.n.setMyLocationEnabled(false);
        this.n.setMyLocationType(b);
        this.H = new j(this, new C(this.n));
        this.H.a(new H());
        h();
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private synchronized void d() {
        this.K = false;
        this.L = null;
    }

    private void d(String str) {
        e.a("GPS", "notifyContourResult|uri:" + str + ",mIsNeedTakeContourTrack:" + this.v);
        C0596r.g(k, "notifyContourResult");
        if (this.v) {
            l lVar = new l();
            lVar.d = str;
            a(lVar);
        }
    }

    private void f() {
        F f = new F(this);
        Long[] lArr = new Long[b];
        lArr[0] = Long.valueOf(this.G);
        f.execute(lArr);
    }

    private void g() {
        this.c = this.U.a();
        if (this.c == k.British) {
            this.R.setText(getResources().getString(n.running_mile));
            this.S.setText(getResources().getString(n.running_detail_pace_desc_br));
            if (this.T != null) {
                this.T.setText(getResources().getString(n.running_detail_speed_desc_br));
            }
        } else {
            this.R.setText(getResources().getString(n.running_kilometers));
            this.S.setText(getResources().getString(n.running_detail_pace_desc));
            if (this.T != null) {
                this.T.setText(getResources().getString(n.running_detail_speed_desc));
            }
        }
        this.q.setText(cn.com.smartdevices.bracelet.gps.h.h.b(0.0f, 2));
        this.E.setText(cn.com.smartdevices.bracelet.gps.ui.b.a.a(0, true));
        if (this.D != null) {
            this.D.setText(String.valueOf(0));
        }
        TextView textView = this.x;
        int i = n.running_pace_detail;
        Object[] objArr = new Object[b];
        objArr[0] = cn.com.smartdevices.bracelet.gps.ui.b.a.a(0);
        textView.setText(getString(i, objArr));
        if (this.m != null) {
            this.m.setText("0.0/0.0");
        }
        this.C.setText(getResources().getString(n.data_not_supported));
        textView = this.o;
        i = n.running_cal_burnt;
        objArr = new Object[b];
        objArr[0] = Integer.valueOf(0);
        textView.setText(getString(i, objArr));
    }

    private void h() {
        View findViewById;
        e.a("GPS", "initUI");
        Resources resources = getResources();
        if (cn.com.smartdevices.bracelet.gps.e.b.d()) {
            ((ViewStub) findViewById(i.layout_infos_hr)).inflate();
            this.M = findViewById(i.share_detail_hr_infos);
            this.d = (TextView) findViewById(i.hr);
            findViewById(i.hr_help).setOnClickListener(this);
        } else {
            ((ViewStub) findViewById(i.layout_infos)).inflate();
            this.M = findViewById(i.share_detail_infos);
            findViewById = findViewById(i.speed);
            this.B = (TextView) findViewById.findViewById(i.value);
            this.T = (TextView) findViewById.findViewById(i.desc);
        }
        this.P = findViewById(i.share_logo_container);
        this.q = (TextView) findViewById(i.info_distance);
        this.R = (TextView) findViewById(i.distance_unit);
        this.y = (Button) findViewById(i.share_normal);
        this.V = findViewById(i.distance_container);
        findViewById = findViewById(i.time_cost);
        this.E = (TextView) findViewById.findViewById(i.value);
        ((TextView) findViewById.findViewById(i.desc)).setText(resources.getString(n.running_detail_time_cost_desc));
        findViewById = findViewById(i.pace);
        this.x = (TextView) findViewById.findViewById(i.value);
        this.S = (TextView) findViewById.findViewById(i.desc);
        if (cn.com.smartdevices.bracelet.gps.c.b.h(this)) {
            findViewById.setOnLongClickListener(new G(this));
        }
        View findViewById2 = findViewById(i.step_frequency);
        this.C = (TextView) findViewById2.findViewById(i.value);
        ((TextView) findViewById2.findViewById(i.desc)).setText(resources.getString(n.running_detail_step_frequency_desc));
        this.r = (TextView) findViewById(i.forefoot_value);
        TextView textView = (TextView) findViewById(i.forefoot_desc);
        this.J = (ImageView) findViewById(i.forefoot_icon);
        textView.setText(resources.getString(n.running_detail_forefoot_desc));
        findViewById2.findViewById(i.pace_freq_help).setOnClickListener(this);
        findViewById(i.forefoot_help).setOnClickListener(this);
        findViewById = findViewById(i.calorie);
        this.o = (TextView) findViewById.findViewById(i.value);
        ((TextView) findViewById.findViewById(i.desc)).setText(resources.getString(n.running_detail_cal_desc));
        g();
        if (this.G >= 0) {
            C0466z a = this.H.a(this, this.G);
            a(cn.com.smartdevices.bracelet.gps.ui.b.a.a(a != null ? a.x() : 0, l, false));
            if (a != null) {
                this.p = a.h();
                b(a);
            }
        }
        this.z = findViewById(i.share_content);
        this.w = findViewById(i.loading_track);
    }

    private void i() {
        if (this.N == null) {
            this.M.setDrawingCacheEnabled(true);
            this.N = Bitmap.createBitmap(this.M.getDrawingCache(true));
        }
        if (this.O == null) {
            this.e.setDrawingCacheEnabled(true);
            this.O = Bitmap.createBitmap(this.e.getDrawingCache(true));
        }
        if (this.Q == null) {
            this.P.setDrawingCacheEnabled(true);
            this.Q = Bitmap.createBitmap(this.P.getDrawingCache(true));
        }
    }

    private void j() {
        if (this.N != null) {
            this.N.recycle();
            this.N = null;
        }
        if (this.O != null) {
            this.O.recycle();
            this.O = null;
        }
        if (this.Q != null) {
            this.Q.recycle();
            this.N = null;
        }
    }

    private void k() {
        cn.com.smartdevices.bracelet.gps.a.b.d(this);
        Intent intent = new Intent(this, PaceDetailActivity.class);
        intent.putExtra(C0483q.a, this.G);
        startActivity(intent);
    }

    public void a(Bundle bundle) {
    }

    public void a(l lVar) {
        C0596r.g(k, "onShareContentReady");
        if (lVar == null) {
            throw new IllegalArgumentException();
        } else if (TextUtils.isEmpty(lVar.d) || !new File(lVar.d).exists()) {
            com.huami.android.view.b.a((Context) this, n.running_contour_track_failed_to_create, 0).show();
        } else {
            WatermarkActivity.start(this, this.G);
        }
    }

    public boolean a(int i, l lVar) {
        return false;
    }

    public void b(Bundle bundle) {
    }

    String c() {
        return this.p;
    }

    public h e_() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(h.d, true);
        bundle.putBoolean(q.b, false);
        bundle.putBoolean(v.e, true);
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }

    public void f_() {
        e.a("GPS", "takeContourTrack");
        C0596r.g(k, "takeContourTrack");
        this.v = true;
        if (!TextUtils.isEmpty(this.p)) {
            d(this.p);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == i.distance_container) {
            this.t.removeMessages(3);
            this.t.obtainMessage(3).sendToTarget();
        } else if (id == i.pace_freq_help) {
            IllustrateActivity.a(this, b);
        } else if (id == i.forefoot_help) {
            IllustrateActivity.a(this, 17);
        } else if (id == i.hr_help) {
            IllustrateActivity.a(this, cn.com.smartdevices.bracelet.weight.family.h.d);
        }
    }

    public void onCreate(Bundle bundle) {
        e();
        super.onCreate(bundle);
        setContentView(com.xiaomi.hm.health.b.a.j.activity_running_result);
        this.t = new J(this);
        this.F = cn.com.smartdevices.bracelet.a.a.a(j);
        this.G = getIntent().getLongExtra(C0483q.a, -1);
        if (bundle != null) {
            this.G = bundle.getLong(cn.com.smartdevices.bracelet.gps.c.a.b, -1);
            this.u = bundle.getBoolean(cn.com.smartdevices.bracelet.gps.c.a.c, false);
        }
        this.A = cn.com.smartdevices.bracelet.a.a.e(i);
        this.U = cn.com.smartdevices.bracelet.gps.e.c.a();
        c(bundle);
        this.s.post(new C(this));
    }

    protected void onDestroy() {
        j();
        if (this.t != null) {
            this.t.a();
        }
        if (this.H != null) {
            this.H.b();
            this.H.a();
        }
        this.s.onDestroy();
        super.onDestroy();
    }

    public void onMapLoaded() {
        e.a("GPS", "onMapLoaded");
        if (!(TextUtils.isEmpty(this.p) || j.a(this.p))) {
            a(new Bundle());
        }
        synchronized (this) {
            this.g = true;
            if (this.h && this.f != null) {
                this.H.a(this.f);
            }
        }
        C0596r.e("Map", "onMapLoaded");
    }

    public void onMapScreenShot(Bitmap bitmap) {
        I i = new I();
        Bitmap[] bitmapArr = new Bitmap[b];
        bitmapArr[0] = bitmap;
        i.execute(bitmapArr);
    }

    public void onPause() {
        super.onPause();
        this.s.onPause();
        C0401a.b(C0401a.am);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        this.s.onResume();
        this.H.a(true);
        C0401a.a(C0401a.am);
        C0401a.a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(cn.com.smartdevices.bracelet.gps.c.a.b, this.G);
        bundle.putBoolean(cn.com.smartdevices.bracelet.gps.c.a.c, this.u);
    }

    public void onShare(View view) {
        cn.com.smartdevices.bracelet.gps.a.b.h(this);
        if (!this.K) {
            this.u = true;
            this.K = true;
            if (this.I == null) {
                i();
                this.L = e_();
                this.L.a(new D(this));
                this.L.a(new E(this));
                this.L.show(getFragmentManager(), C0401a.aY);
                this.n.getMapScreenShot(this);
            }
        }
    }

    public void onWatermark(View view) {
        cn.com.smartdevices.bracelet.gps.a.b.f(this);
        this.u = false;
        f_();
    }
}
