package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.huami.android.widget.share.q;
import com.huami.android.widget.share.s;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import com.xiaomi.mipush.sdk.f;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kankan.wheel.widget.i;

public class ShareActivity extends SystemBarTintActivity implements s {
    private WeightUserAvatar A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private RelativeLayout F;
    private LinearLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private TextView R;
    private Context S = this;
    private q T;
    boolean a = false;
    private ImageView b = null;
    private TextView c = null;
    private ImageView d = null;
    private TextView e = null;
    private TextView f = null;
    private TextView g = null;
    private TextView h = null;
    private TextView i = null;
    private View j = null;
    private TextView k = null;
    private ShareData l = null;
    private TextView m;
    private Bitmap n = null;
    private String o = null;
    private TextView p;
    private TextView q;
    private TextView r;
    private String s = null;
    private Bitmap t = null;
    private View u;
    private String v;
    private View w;
    private TextView x;
    private TextView y;
    private TextView z;

    private String a(String str) {
        float f = GroundOverlayOptions.NO_DIMENSION;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
        }
        return f < 0.0f ? a.f : f + a.f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
        r7 = this;
        r6 = 11;
        r5 = 0;
        r4 = 8;
        r1 = r7.s;
        r0 = r7.l;
        r0 = r0.type;
        if (r0 != r6) goto L_0x009c;
    L_0x000d:
        r0 = r7.getIntent();
        r2 = "SharePreviewPath";
        r0 = r0.getStringExtra(r2);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x009c;
    L_0x001d:
        r1 = r7.b;
        r1.setVisibility(r5);
        r0 = android.graphics.BitmapFactory.decodeFile(r0);
        r7.t = r0;
        r0 = r7.b;
        r1 = r7.t;
        r0.setImageBitmap(r1);
        r0 = 2131296914; // 0x7f090292 float:1.8211758E38 double:1.0530005863E-314;
        r0 = r7.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = new java.text.SimpleDateFormat;
        r2 = 2131362186; // 0x7f0a018a float:1.8344145E38 double:1.053032835E-314;
        r2 = r7.getString(r2);
        r1.<init>(r2);
        r2 = new java.util.Date;
        r2.<init>();
        r1 = r1.format(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = 2131362578; // 0x7f0a0312 float:1.834494E38 double:1.0530330286E-314;
        r3 = r7.getString(r3);
        r2 = r2.append(r3);
        r3 = " ";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r1 = r1.toString();
        r0.setText(r1);
        r1 = r7.l;
        r1 = r1.type;
        if (r1 != r6) goto L_0x0091;
    L_0x0074:
        r1 = r7.d;
        r1.setVisibility(r4);
        r1 = r7.e;
        r1.setVisibility(r4);
        r1 = r7.getIntent();
        r2 = "EventPageType";
        r1 = r1.getIntExtra(r2, r5);
        r2 = 1;
        if (r1 != r2) goto L_0x0092;
    L_0x008b:
        r1 = -863790; // 0xfffffffffff2d1d2 float:NaN double:NaN;
        r0.setTextColor(r1);
    L_0x0091:
        return;
    L_0x0092:
        r0 = r0.getParent();
        r0 = (android.view.View) r0;
        r0.setVisibility(r4);
        goto L_0x0091;
    L_0x009c:
        r0 = r1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.ui.ShareActivity.a():void");
    }

    private void a(ShareData shareData) {
        this.s = getIntent().getStringExtra(kankan.wheel.widget.a.ca);
        if (this.s != null) {
            a();
        }
        C0596r.e(NativeInterface.SHARE, shareData.toString());
        this.c.setText(shareData.time);
        this.g.setText(shareData.contentUnit);
        this.j.setBackgroundColor(shareData.color);
        this.k.setText(shareData.title);
        this.h.setText(shareData.description);
        this.m.setText(shareData.time_tips);
        Bundle bundle = this.l.mExtraData;
        if (shareData.isSleepType()) {
            int intValue;
            try {
                intValue = Integer.valueOf(shareData.content).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                intValue = 0;
            }
            int i = intValue % 60;
            this.f.setText((intValue / 60) + a.f);
            this.q.setText(i + a.f);
            this.r.setVisibility(0);
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        } else {
            this.f.setText(shareData.content);
        }
        if (shareData.getType() != 9 && shareData.getType() != 8 && shareData.getType() != 10 && !shareData.isSleepType()) {
            Object obj = shareData.ranking;
            C0596r.e("TAG", "ranking = " + shareData.ranking);
            if (TextUtils.isEmpty(obj)) {
                Utils.a((Context) this, bundle, new eF(this));
            } else {
                this.i.setText(Html.fromHtml(obj));
            }
        }
    }

    private void b(ShareData shareData) {
        int i;
        if (shareData.fuid == -1) {
            this.B.setText(Keeper.readPersonInfo().nickname);
            this.A.a(Keeper.readPersonInfo().nickname);
            Utils.a(J.a().a(-1), this.A);
            i = Keeper.readPersonInfo().gender;
            i = Birthday.fromStr(Keeper.readPersonInfo().birthday).getAgeInMonths();
        } else if (shareData.fuid == 0) {
            this.B.setText(getString(r.visitor));
            this.A.a(getString(r.visitor));
            this.A.setBackgroundResource(k.default_userinfo);
            i = 0;
        } else {
            UserInfo a = J.a().a(shareData.fuid);
            this.B.setText(a.name);
            this.A.a(a.name);
            Utils.a(a, this.A);
            int i2 = a.gender;
            i = Birthday.fromStr(a.birthday).getAgeInMonths();
        }
        this.G.setBackgroundResource(k.weight_report_bg);
        C0401a.a(this.S, C0401a.hv, i + a.f);
        if (i <= 83) {
            this.H.setVisibility(8);
            this.I.setVisibility(0);
        } else {
            this.H.setVisibility(0);
            this.I.setVisibility(8);
        }
        this.x.setText(shareData.weightTitle);
        this.y.setText(shareData.weightValue);
        this.z.setText(shareData.weightTips);
        this.C.setText(shareData.weightFigure);
        this.D.setText(shareData.weightBMI);
        this.J.setText(shareData.babyMonthsStr);
        C0596r.e("SHARE_REF_WEIGHT", "from weight receive " + shareData.babyRefWeights);
        if (!shareData.babyRefWeights.isEmpty()) {
            String[] split = shareData.babyRefWeights.split(f.i);
            this.L.setText(a(split[2]));
            this.M.setText(a(split[3]));
            this.N.setText(a(split[4]));
            this.O.setText(a(split[5]));
            this.P.setText(a(split[6]));
            this.Q.setText(a(split[7]));
            this.R.setText(a(split[8]));
        }
        this.E.setText(getString(i.app_name) + " " + new SimpleDateFormat(getString(r.date_month_day)).format(new Date()));
        C0596r.e("SHARE", "share time text " + this.E.getText().toString());
    }

    private void c() {
        this.w = findViewById(l.share_pane_container);
        this.F = (RelativeLayout) findViewById(l.share_content_ll);
        this.G = (LinearLayout) findViewById(l.share_content_for_weight);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        C0596r.e("WPJ", readPersonInfo.toString());
        this.b = (ImageView) findViewById(l.share_pic_iv);
        this.u = findViewById(l.share_logo);
        this.d = (ImageView) findViewById(l.share_person_avatar_iv);
        Utils.a(readPersonInfo, this.d);
        this.e = (TextView) findViewById(l.share_person_name_tv);
        this.e.setText(readPersonInfo.nickname);
        this.f = (TextView) findViewById(l.share_main_content);
        this.r = (TextView) findViewById(l.share_main_content_hour_unit);
        this.q = (TextView) findViewById(l.share_main_content_minute);
        this.p = (TextView) findViewById(l.share_main_content_minute_unit);
        this.g = (TextView) findViewById(l.share_main_content_unit);
        this.h = (TextView) findViewById(l.share_description);
        this.j = findViewById(l.share_background_v);
        this.k = (TextView) findViewById(l.share_title);
        this.c = (TextView) findViewById(l.share_time);
        this.m = (TextView) findViewById(l.share_time_tips);
        this.i = (TextView) findViewById(l.ranking);
        this.x = (TextView) findViewById(l.current_weight_title);
        this.y = (TextView) findViewById(l.current_weight_value);
        this.z = (TextView) findViewById(l.current_weight_tips);
        this.A = (WeightUserAvatar) findViewById(l.user_icon);
        this.B = (TextView) findViewById(l.user_name);
        this.C = (TextView) findViewById(l.wr_figure_tips_tv);
        this.D = (TextView) findViewById(l.wr_bmi_tips_tv);
        this.E = (TextView) findViewById(l.share_text);
        if (Utils.m()) {
            this.D.setTextSize((float) Utils.a(5.0f, this.S));
            this.C.setTextSize((float) Utils.a(5.0f, this.S));
        } else {
            this.D.setTextSize((float) Utils.a(10.0f, this.S));
            this.C.setTextSize((float) Utils.a(10.0f, this.S));
        }
        this.H = (RelativeLayout) findViewById(l.bmi_layout);
        this.I = (RelativeLayout) findViewById(l.baby_layout);
        this.J = (TextView) findViewById(l.left_title);
        this.K = (TextView) findViewById(l.right_title);
        this.L = (TextView) findViewById(l.content_min_3);
        this.M = (TextView) findViewById(l.content_min_2);
        this.N = (TextView) findViewById(l.content_min_1);
        this.O = (TextView) findViewById(l.content_min_0);
        this.P = (TextView) findViewById(l.content_add_1);
        this.Q = (TextView) findViewById(l.content_add_2);
        this.R = (TextView) findViewById(l.content_add_3);
    }

    private void d() {
        if (findViewById(l.share_pane_container) != null) {
            this.T = new q();
            Bundle bundle = new Bundle();
            bundle.putBoolean(v.e, true);
            this.T.setArguments(bundle);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(l.share_pane_container, this.T);
            this.T.a((s) this);
            beginTransaction.commit();
        }
    }

    private void e() {
        if (!TextUtils.isEmpty(this.o)) {
            File file = new File(this.o);
            if (file.exists()) {
                file.delete();
                this.o = null;
            }
        }
    }

    private com.huami.android.widget.share.l f() {
        com.huami.android.widget.share.l lVar = new com.huami.android.widget.share.l();
        if (this.a) {
            this.o = Utils.a(this.G, getApplicationContext());
        } else {
            this.o = Utils.a(this.F, getApplicationContext());
        }
        if (this.l.type == 2 || this.l.type == 3 || this.l.type == 4) {
            lVar.c = getString(r.share_to_content_sleep);
        } else if (this.l.type == v.C) {
            lVar.c = getString(r.share_to_content_weight);
        } else if (this.l.type != 11) {
            lVar.c = getString(r.share_to_content_step);
        }
        lVar.a = getString(r.share_to_title);
        lVar.b = getString(r.share_to_topic);
        lVar.e = this.o;
        return lVar;
    }

    public void b() {
        runOnUiThread(new eG(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_share);
        c();
        d();
        Intent intent = getIntent();
        if (intent != null) {
            this.l = (ShareData) intent.getParcelableExtra("share_data");
            if (this.l == null) {
                this.l = new ShareData();
                this.l.setType(intent.getIntExtra(SocialConstants.PARAM_TYPE, 7));
                this.l.title = intent.getStringExtra(SocialConstants.PARAM_TITLE);
                this.l.content = intent.getStringExtra(ParamKey.CONTENT);
                this.l.contentUnit = intent.getStringExtra("unit");
                this.l.time = intent.getStringExtra(g.f);
                this.l.description = intent.getStringExtra(SocialConstants.PARAM_COMMENT);
                this.l.time_tips = intent.getStringExtra("time_tips");
                this.l.color = intent.getIntExtra(cn.com.smartdevices.bracelet.push.f.n, 0);
                this.l.ranking = intent.getStringExtra("ranking");
            }
            this.v = intent.getStringExtra(kankan.wheel.widget.a.cz);
            if (TextUtils.isEmpty(this.v)) {
                this.v = getText(r.share_to_topic).toString();
            }
        }
        if (this.l.getType() != v.C) {
            this.a = false;
            this.w.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.i.share_panel_bg));
            this.F.setVisibility(0);
            this.G.setVisibility(8);
            a(this.l);
            return;
        }
        this.a = true;
        this.w.setBackgroundColor(getResources().getColor(com.xiaomi.hm.health.i.share_weight_panel_bg));
        this.F.setVisibility(8);
        this.G.setVisibility(0);
        b(this.l);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.n != null) {
            if (!this.n.isRecycled()) {
                this.n.recycle();
            }
            this.n = null;
        }
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
        }
        if (this.s != null) {
            File file = new File(this.s);
            if (file.exists()) {
                file.delete();
            }
        }
        e();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.W);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.W);
        C0401a.a((Activity) this);
    }
}
