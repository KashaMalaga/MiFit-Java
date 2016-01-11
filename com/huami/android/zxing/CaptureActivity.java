package com.huami.android.zxing;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.services.core.AMapException;
import com.c.b.a;
import com.c.b.e;
import com.c.b.s;
import com.huami.android.a.h;
import com.huami.android.a.l;
import com.huami.android.picture.GalleryPickerActivity;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.c;
import com.huami.android.widget.f;
import com.huami.android.zxing.a.g;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CaptureActivity extends ActionBarActivity implements Callback, OnClickListener {
    public static final String a = "scan_result";
    public static final String b = "scan_result_text";
    public static final String c = "scan_result_time";
    public static final String d = "scan_prompt";
    public static final String e = "hide_album_button";
    public static final String f = "scan_title";
    public static final String g = "show_back_button";
    public static final String h = "hide_close_button";
    public static final String i = "bind_shoes_action";
    public static final String j = "desired_zoom";
    public static final String k = "zxing_block_size_power";
    public static final String l = "shoes";
    public static final String m = "call_type";
    public static final String n = "brand";
    public static final String o = "shoes_id";
    public static final String p = "package_name";
    public static final int q = 0;
    public static final int r = 1;
    private static final String s = CaptureActivity.class.getSimpleName();
    private static final int t = 1;
    private static final int u = 2;
    private boolean A;
    private String B;
    private String C = null;
    private String D;
    private String E;
    private int F = -1;
    private int G = -1;
    private Collection<a> H;
    private Map<e, ?> I;
    private String J;
    private n K;
    private b L;
    private C1066a M;
    private View N;
    private View O;
    private boolean P = true;
    private Context Q;
    private String R = null;
    private String S = null;
    private boolean T;
    private boolean U;
    private Serializable V;
    private View W;
    private TextView X;
    private f Y;
    private com.huami.android.view.a Z;
    private int v;
    private g w;
    private d x;
    private File y;
    private ViewfinderView z;

    public CaptureActivity() {
        super(C0401a.gQ, C0401a.gF);
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, CaptureActivity.class);
        intent.putExtra(m, t);
        return intent;
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.w.a()) {
            Log.w(s, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.w.a(surfaceHolder);
                if (this.x == null) {
                    this.x = new d(this, this.H, this.I, this.J, this.w);
                }
                a(null);
            } catch (Throwable e) {
                Log.w(s, e);
                j();
            } catch (Throwable e2) {
                Log.w(s, "Unexpected error initializing camera", e2);
                j();
            }
        }
    }

    private void a(File file) {
        if (this.x == null) {
            this.y = file;
            return;
        }
        if (file != null) {
            this.y = file;
        }
        if (this.y != null) {
            this.x.sendMessage(Message.obtain(this.x, l.h, this.y));
        }
        this.y = null;
    }

    private void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(C0410c.t, z ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP);
        hashMap.put(C0410c.x, this.D);
        hashMap.put(C0410c.A, this.E);
        C0401a.a(this.Q, C0409b.bf, hashMap);
    }

    public static Intent b(Context context) {
        Intent intent = new Intent(context, CaptureActivity.class);
        intent.putExtra(m, q);
        return intent;
    }

    public static Intent c(Context context) {
        return new Intent(context, CaptureActivity.class);
    }

    private void j() {
        this.O.setVisibility(8);
        this.N.setVisibility(8);
        this.W.setVisibility(8);
        this.X.setVisibility(8);
        this.Z = new c(this);
        Bundle bundle = new Bundle();
        bundle.putInt(SocialConstants.PARAM_TITLE, l.alert_title_unable_start_camera);
        bundle.putInt(SocialConstants.PARAM_SEND_MSG, l.alert_msg_unable_start_camera);
        this.Z.setArguments(bundle);
        this.Z.setCanceledOnTouchOutside(false);
        c.showPanel((Activity) this, this.Z);
    }

    private void k() {
        this.z.setVisibility(q);
    }

    public void a(s sVar) {
        this.K.a();
        this.L.b();
        if (this.Y != null) {
            this.Y.dismiss();
        }
        Intent intent = new Intent();
        intent.putExtra(a, sVar.b());
        intent.putExtra(b, sVar.a());
        intent.putExtra(c, sVar.f());
        if (this.v == t) {
            intent.setAction(this.B);
            if (!TextUtils.isEmpty(this.C)) {
                intent.setPackage(this.C);
            }
            this.V = getIntent().getSerializableExtra(l);
            intent.putExtra(l, this.V);
            startActivityForResult(intent, u);
            a(true);
            return;
        }
        setResult(-1, intent);
        finish();
    }

    ViewfinderView b() {
        return this.z;
    }

    public Handler c() {
        return this.x;
    }

    g d() {
        return this.w;
    }

    public int f() {
        return this.G;
    }

    public void g() {
        if (this.v == t) {
            a(false);
        }
    }

    public void h() {
        this.z.a();
    }

    public void i() {
        if (this.Y != null) {
            this.Y.dismiss();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == t) {
            if (i2 == -1) {
                a(new File(intent.getStringExtra(GalleryPickerActivity.c)));
                this.Y = f.a(getFragmentManager());
            }
        } else if (i != u) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            finish();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == com.huami.android.a.g.close_button || id == com.huami.android.a.g.back_button) {
            finish();
        } else if (id == com.huami.android.a.g.album_button) {
            startActivityForResult(new Intent(this, GalleryPickerActivity.class), t);
            if (this.v == 0) {
                C0401a.a((Context) this, C0409b.aH);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Q = getApplicationContext();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        c(q);
        setContentView(h.activity_capture);
        this.R = getIntent().getStringExtra(d);
        this.v = getIntent().getIntExtra(m, q);
        if (!TextUtils.isEmpty(this.R)) {
            ((ViewfinderView) findViewById(com.huami.android.a.g.scan_view)).a(this.R);
        }
        this.X = (TextView) findViewById(com.huami.android.a.g.title);
        this.S = getIntent().getStringExtra(f);
        if (!TextUtils.isEmpty(this.S)) {
            this.X.setText(this.S);
            this.X.setVisibility(q);
        }
        this.O = findViewById(com.huami.android.a.g.album_button);
        this.O.setOnClickListener(this);
        this.P = getIntent().getBooleanExtra(e, false);
        if (this.P) {
            this.O.setVisibility(8);
        }
        this.N = findViewById(com.huami.android.a.g.close_button);
        this.N.setOnClickListener(this);
        this.T = getIntent().getBooleanExtra(h, false);
        if (this.T) {
            this.N.setVisibility(8);
        }
        this.W = findViewById(com.huami.android.a.g.back_button);
        this.U = getIntent().getBooleanExtra(g, false);
        if (this.U) {
            this.W.setVisibility(q);
            this.W.setOnClickListener(this);
        }
        if (this.v == t) {
            this.B = getIntent().getStringExtra(i);
            this.C = getIntent().getStringExtra(p);
            this.D = Constants.VIA_TO_TYPE_QQ_GROUP.equals(getIntent().getStringExtra(o)) ? Constants.VIA_RESULT_SUCCESS : Constants.VIA_TO_TYPE_QQ_GROUP;
            this.E = getIntent().getStringExtra(n);
        }
        this.F = getIntent().getIntExtra(j, -1);
        this.G = getIntent().getIntExtra(k, -1);
        this.A = false;
        this.K = new n(this);
        this.L = new b(this);
        this.M = new C1066a(this);
    }

    protected void onDestroy() {
        this.K.d();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case kankan.wheel.widget.a.aQ /*4*/:
                setResult(q);
                finish();
                return true;
            case AMapException.ERROR_CODE_INVALID_PARAMETER /*24*/:
                this.w.a(true);
                return true;
            case AMapException.ERROR_CODE_NULL_PARAMETER /*25*/:
                this.w.a(false);
                return true;
            case com.xiaomi.hm.health.bt.profile.a.a.ab /*27*/:
            case cn.com.smartdevices.bracelet.gps.c.a.h /*80*/:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    protected void onPause() {
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        this.K.b();
        this.M.stop();
        this.L.close();
        this.w.b();
        if (!this.A) {
            ((SurfaceView) findViewById(com.huami.android.a.g.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C0596r.e(s, "onRestoreInstanceState");
        this.v = bundle.getInt(m);
        this.F = bundle.getInt(j);
        this.G = bundle.getInt(k);
        this.P = bundle.getBoolean(e);
        this.T = bundle.getBoolean(h);
        this.U = bundle.getBoolean(g);
        this.R = bundle.getString(d);
        this.S = bundle.getString(f);
        this.B = bundle.getString(i);
        this.C = bundle.getString(p);
        this.E = bundle.getString(n);
        this.V = bundle.getSerializable(l);
    }

    protected void onResume() {
        super.onResume();
        this.w = new g(getApplication());
        this.w.a(this.F);
        this.z = (ViewfinderView) findViewById(com.huami.android.a.g.scan_view);
        this.z.a(this.w);
        k();
        SurfaceHolder holder = ((SurfaceView) findViewById(com.huami.android.a.g.preview_view)).getHolder();
        if (this.A) {
            a(holder);
        } else {
            holder.addCallback(this);
        }
        this.L.a();
        this.M.start(this.w);
        this.K.c();
        Intent intent = getIntent();
        this.H = null;
        this.J = null;
        if (intent != null) {
            int intExtra;
            this.H = h.a(intent);
            this.I = j.a(intent);
            if (intent.hasExtra(v.l) && intent.hasExtra(v.m)) {
                intExtra = intent.getIntExtra(v.l, q);
                int intExtra2 = intent.getIntExtra(v.m, q);
                if (intExtra > 0 && intExtra2 > 0) {
                    this.w.a(intExtra, intExtra2);
                }
            }
            if (intent.hasExtra(v.j)) {
                intExtra = intent.getIntExtra(v.j, -1);
                if (intExtra >= 0) {
                    this.w.b(intExtra);
                }
            }
            this.J = intent.getStringExtra(v.k);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0596r.e(s, "onSaveInstanceState");
        bundle.putInt(m, this.v);
        bundle.putInt(j, this.F);
        bundle.putInt(k, this.G);
        bundle.putBoolean(e, this.P);
        bundle.putBoolean(h, this.T);
        bundle.putBoolean(g, this.U);
        bundle.putString(d, this.R);
        bundle.putString(f, this.S);
        bundle.putString(i, this.B);
        bundle.putString(p, this.C);
        bundle.putString(n, this.E);
        bundle.putSerializable(l, this.V);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(s, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.A) {
            this.A = true;
            a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A = false;
        this.w.d();
        this.w.b();
    }
}
