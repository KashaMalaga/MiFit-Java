package cn.com.smartdevices.bracelet.gps.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaScannerConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.c;
import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkBar.Watermark;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkFragment.WatermarkTag;
import com.activeandroid.b;
import com.huami.android.bitmapfun.D;
import com.huami.android.bitmapfun.y;
import com.huami.android.picture.GalleryPickerActivity;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.view.CustomViewPager;
import com.huami.android.view.a;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.b.a.g;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.market.sdk.p;
import java.util.ArrayList;
import java.util.List;

public class WatermarkActivity extends ActionBarActivity implements OnClickListener, bs {
    private static final int H = 100;
    private static final int I = 101;
    private static final String a = "WatermarkActivity";
    private static final int b = 1;
    private Handler A = null;
    private final OnTouchListener B = new bh(this);
    private List<Watermark> C;
    private boolean D;
    private boolean E = true;
    private boolean F = true;
    private final List<Fragment> G = new ArrayList(b);
    private Bitmap J = null;
    private a K;
    private ImageView c;
    private ImageView d;
    private ImageButton e;
    private ImageButton f;
    private ImageButton g;
    private ImageButton h;
    private Button i;
    private CustomViewPager j;
    private RelativeLayout k;
    private View l;
    private RelativeLayout m;
    private RelativeLayout n;
    private FrameLayout o;
    private LinearLayout p;
    private WatermarkTag q;
    private WatermarkBar r;
    private bu s;
    private int t;
    private int u;
    private int v;
    private long w = -1;
    private aa x = null;
    private MediaScannerConnection y = null;
    private boolean z;

    public WatermarkActivity() {
        super(C0401a.bD, C0401a.aA);
    }

    public WatermarkActivity(String str, String str2) {
        super(C0401a.bD, C0401a.aA);
    }

    private void a(String str) {
        if (this.y != null && this.y.isConnected()) {
            this.y.disconnect();
            this.y = null;
        }
        this.y = new MediaScannerConnection(this, new bm(this, str));
        this.y.connect();
    }

    private void b(boolean z) {
        if (z) {
            c(false);
            ActionBar actionBar = getActionBar();
            actionBar.setDisplayShowCustomEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            return;
        }
        c(true);
        o();
    }

    private void c(boolean z) {
        LayoutParams attributes = getWindow().getAttributes();
        if (z) {
            attributes.flags |= b.a;
        } else {
            attributes.flags &= -1025;
        }
        getWindow().setAttributes(attributes);
    }

    private void d(boolean z) {
        this.E = z;
        this.s.a(z);
    }

    private void e(boolean z) {
        if (this.e != null) {
            this.D = z;
            if (z) {
                this.s.a("torch");
                this.e.setImageResource(h.watermark_share_icon_flash_lamp_on);
                return;
            }
            this.s.a("off");
            this.e.setImageResource(h.watermark_share_icon_flash_lamp_off);
        }
    }

    private void f() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), LabelInputActivity.class);
        startActivityForResult(intent, H);
    }

    private void g() {
        new Thread(new bj(this)).start();
    }

    private WatermarkFragment h() {
        return this.G != null ? (WatermarkFragment) this.G.get(this.t) : null;
    }

    private Bitmap i() {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{p.a, "_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        if (query.moveToLast()) {
                            String string = query.getString(b);
                            C0596r.e("Mask", "getLastAvatar fileName = " + string);
                            Options options = new Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(string, options);
                            int dimensionPixelSize = getResources().getDimensionPixelSize(g.avatar_thumbnail_size);
                            options.inSampleSize = y.a(dimensionPixelSize, dimensionPixelSize, options);
                            options.inJustDecodeBounds = false;
                            Bitmap decodeFile = BitmapFactory.decodeFile(string, options);
                            if (query == null) {
                                return decodeFile;
                            }
                            query.close();
                            return decodeFile;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void j() {
        this.k = (RelativeLayout) findViewById(i.rl_share_area);
        this.p = (LinearLayout) findViewById(i.share_pane_container);
        this.m = (RelativeLayout) findViewById(i.rl_share_area_mark);
        this.o = (FrameLayout) findViewById(i.fl_camera);
        this.c = (ImageView) findViewById(i.iv_cover);
        this.d = (ImageView) findViewById(i.avatar_mask);
        this.j = (CustomViewPager) findViewById(i.vp_mark_pager);
        this.j.b(false);
        this.r = (WatermarkBar) findViewById(i.h_scrollview);
        this.n = (RelativeLayout) findViewById(i.ll_panel);
        this.g = (ImageButton) findViewById(i.btn_takephoto);
        this.h = (ImageButton) findViewById(i.btn_share_back);
        this.i = (Button) findViewById(i.btn_save);
        this.k.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.v));
        this.s = bu.a();
        getFragmentManager().beginTransaction().replace(i.fl_camera, this.s).commit();
        this.j.a(new bq(this, getFragmentManager()));
        this.j.a(new bl(this));
        this.j.setOnTouchListener(this.B);
        this.j.setVisibility(4);
        this.j.a(this.t);
        this.r.a(this.C);
        this.r.setVisibility(8);
        this.r.a((bs) this);
        this.d.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.A.sendEmptyMessageDelayed(b, 250);
        this.q = new WatermarkTag(this);
        this.m.addView(this.q, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void k() {
        this.C = new ArrayList(b);
        Watermark watermark = new Watermark();
        watermark.p = b;
        watermark.o = 2;
        watermark.m = this.x.d();
        watermark.v = cn.com.smartdevices.bracelet.gps.h.h.b(this.x.l() / 1000.0f, 2);
        this.C.add(watermark);
        this.G.add(WatermarkFragment.a((Watermark) this.C.get(0)));
    }

    private void l() {
        this.F = true;
        b(false);
        this.p.setVisibility(0);
        this.i.setVisibility(8);
        this.o.setVisibility(0);
        this.c.setVisibility(8);
        this.j.setVisibility(8);
        if (this.t == 0) {
            WatermarkFragment watermarkFragment = (WatermarkFragment) this.G.get(this.t);
            if (watermarkFragment != null) {
                watermarkFragment.b();
            }
        }
    }

    private void m() {
        this.F = false;
        b(true);
        this.p.setVisibility(8);
        this.i.setVisibility(0);
        this.o.setVisibility(8);
        this.c.setVisibility(0);
        this.j.setVisibility(0);
        C0401a.a((Context) this, C0409b.z);
    }

    private void n() {
        cn.com.smartdevices.bracelet.gps.a.b.a(this);
        if (this.J != null) {
            this.J.recycle();
            this.J = null;
        }
        startActivityForResult(new Intent(this, GalleryPickerActivity.class), I);
    }

    private void o() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        this.l = getLayoutInflater().inflate(j.activity_watermark_camer_header, null);
        actionBar.setCustomView(this.l, new ActionBar.LayoutParams(-1, -1));
        this.e = (ImageButton) this.l.findViewById(i.flash_lamp);
        this.f = (ImageButton) this.l.findViewById(i.cam_switch);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    private void p() {
        C0401a.a((Context) this, C0401a.bH);
        d(!this.E);
    }

    private void q() {
        C0401a.a((Context) this, C0401a.bG);
        e(!this.D);
    }

    private void r() {
        cn.com.smartdevices.bracelet.gps.a.b.i(this);
        this.s.a(new bn(this));
    }

    private void s() {
        C0401a.a((Context) this, C0401a.bJ);
        h().a();
        this.m.setDrawingCacheEnabled(true);
        this.m.destroyDrawingCache();
        this.m.buildDrawingCache();
        Bitmap drawingCache = this.m.getDrawingCache();
        String i = cn.com.smartdevices.bracelet.a.a.i("watermark_" + System.currentTimeMillis() + ".jpg");
        boolean a = c.a(i, drawingCache, 30);
        if (drawingCache != null) {
            drawingCache.recycle();
        }
        if (a) {
            a(i);
            WatermarkShareActivity.start(this, i);
            finish();
            return;
        }
        com.huami.android.view.b.a((Context) this, n.running_share_img_failed_to_create, 0).show();
    }

    public static void start(Context context, long j) {
        Intent intent = new Intent(context, WatermarkActivity.class);
        intent.putExtra(C0483q.a, j);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
        }
    }

    public void a(int i) {
        this.j.a(i);
    }

    public void a(boolean z) {
        this.z = z;
    }

    public int b() {
        return this.u;
    }

    public aa c() {
        return this.x;
    }

    public void d() {
        this.l.setVisibility(8);
        this.K = new bi(this);
        Bundle bundle = new Bundle();
        bundle.putInt(SocialConstants.PARAM_TITLE, n.alert_title_unable_start_camera);
        bundle.putInt(SocialConstants.PARAM_SEND_MSG, n.alert_msg_unable_start_camera);
        this.K.setArguments(bundle);
        this.K.setCanceledOnTouchOutside(false);
        com.huami.android.view.c.showPanel((Activity) this, this.K);
    }

    public int i_() {
        return this.v;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            switch (i) {
                case H /*100*/:
                    if (i2 == -1) {
                        this.q.a(intent.getExtras().getString("text_input"));
                        return;
                    }
                    return;
                case I /*101*/:
                    String stringExtra = intent.getStringExtra(GalleryPickerActivity.c);
                    if (stringExtra != null) {
                        this.J = y.a(stringExtra, this.u, this.v);
                        Resources resources = getResources();
                        if (this.J != null) {
                            BitmapDrawable bitmapDrawable = VERSION.SDK_INT >= 11 ? new BitmapDrawable(resources, this.J) : new D(resources, this.J);
                            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), bitmapDrawable});
                            this.c.setImageDrawable(transitionDrawable);
                            transitionDrawable.startTransition(v.C);
                            C0401a.a((Context) this, C0401a.bL);
                        }
                        m();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (this.i.isShown()) {
            l();
        } else {
            finish();
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == i.flash_lamp) {
                q();
            } else if (id == i.cam_switch) {
                p();
            } else if (id == i.btn_takephoto) {
                r();
            } else if (id == i.btn_share_back) {
                C0401a.a((Context) this, C0401a.bI);
                finish();
            } else if (id == i.btn_save) {
                WatermarkFragment h = h();
                if (h != null) {
                    h.c();
                }
                s();
            } else if (id == i.avatar_mask) {
                n();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        C0401a.a((Context) this, C0401a.bD);
        getWindow().addFlags(b.a);
        super.onCreate(bundle);
        setContentView(j.activity_watermark_main);
        o();
        this.A = new bp(this);
        this.w = getIntent().getLongExtra(C0483q.a, -1);
        if (bundle != null) {
            this.t = bundle.getInt(cn.com.smartdevices.bracelet.gps.c.a.a, 0);
            this.w = bundle.getLong(cn.com.smartdevices.bracelet.gps.c.a.b, -1);
            this.F = bundle.getBoolean(cn.com.smartdevices.bracelet.gps.c.a.b, true);
        }
        if (this.w <= 0) {
            throw new IllegalArgumentException();
        }
        this.x = cn.com.smartdevices.bracelet.gps.c.a.p.f((Context) this, this.w);
        k();
        this.u = getResources().getDisplayMetrics().widthPixels;
        this.v = this.u + getResources().getDimensionPixelSize(g.watermark_icon_part_size);
        j();
        g();
    }

    protected void onDestroy() {
        cn.com.smartdevices.bracelet.gps.a.b.a((Context) this, this.z);
        if (this.y != null && this.y.isConnected()) {
            this.y.disconnect();
        }
        this.A.removeCallbacksAndMessages(null);
        if (this.J != null) {
            this.J.recycle();
            this.J = null;
        }
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        e(false);
        C0401a.b(C0401a.aA);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.aA);
        C0401a.a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(cn.com.smartdevices.bracelet.gps.c.a.a, this.t);
        bundle.putLong(cn.com.smartdevices.bracelet.gps.c.a.b, this.w);
        bundle.putBoolean(cn.com.smartdevices.bracelet.gps.c.a.d, this.F);
    }
}
