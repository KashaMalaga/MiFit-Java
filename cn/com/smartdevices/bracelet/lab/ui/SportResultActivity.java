package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0826v;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.lab.k;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.hm.health.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SportResultActivity extends SystemBarTintActivity implements OnClickListener, IWXAPIEventHandler {
    private TextView a = null;
    private TextView b = null;
    private ImageView c = null;
    private TextView d = null;
    private TextView e = null;
    private TextView f = null;
    private TextView g = null;
    private View h = null;
    private TextView i = null;
    private ShareData j = null;
    private Bitmap k = null;
    private String l = null;
    private TextView m = null;
    private TextView n = null;
    private String o = null;
    private Bitmap p = null;
    private boolean q = false;
    private String r = null;

    private ShareData a(Intent intent) {
        ShareData shareData = (ShareData) intent.getParcelableExtra("share_data");
        if (shareData != null) {
            return shareData;
        }
        shareData = new ShareData();
        shareData.type = intent.getIntExtra(a.h, 100);
        shareData.title = intent.getStringExtra(SocialConstants.PARAM_TITLE);
        shareData.content = intent.getStringExtra(ParamKey.CONTENT);
        shareData.contentUnit = intent.getStringExtra("unit");
        shareData.time = intent.getStringExtra(g.f);
        shareData.description = intent.getStringExtra(SocialConstants.PARAM_COMMENT);
        shareData.time_tips = intent.getStringExtra("time_tips");
        return shareData;
    }

    private void a() {
        File file;
        if (this.l != null) {
            file = new File(this.l);
            if (file.exists()) {
                file.delete();
            }
        }
        this.l = cn.com.smartdevices.bracelet.a.a.c();
        file = new File(this.l);
        if (file.exists()) {
            file.delete();
        }
    }

    private void a(ShareData shareData) {
        this.o = getIntent().getStringExtra(kankan.wheel.widget.a.ca);
        if (this.o != null) {
            g();
        }
        this.b.setText(shareData.time);
        if (!TextUtils.isEmpty(shareData.contentUnit)) {
            this.f.setText(shareData.contentUnit);
        }
        this.h.setBackgroundColor(shareData.color);
        this.i.setText(shareData.title);
        this.g.setText(shareData.description);
        this.e.setText(shareData.content);
        a(shareData.ranking);
    }

    private void a(String str) {
        if (this.n != null) {
            if (TextUtils.isEmpty(str)) {
                this.n.setVisibility(8);
            }
            this.n.setText(Html.fromHtml(str));
            this.n.setVisibility(0);
        }
    }

    private void b() {
        this.a = (TextView) findViewById(R.id.back_btn);
        this.a.setOnClickListener(this);
        c();
    }

    private void c() {
        if (this.j != null) {
            switch (this.j.type) {
                case kankan.wheel.widget.a.ar /*100*/:
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    this.a.setText(R.string.lab_factory_sport_type_ropeskipping);
                    return;
                case ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD /*102*/:
                case ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE /*103*/:
                    this.a.setText(R.string.lab_factory_sport_type_situp);
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        this.c = (ImageView) findViewById(R.id.share_person_avatar_iv);
        this.d = (TextView) findViewById(R.id.share_person_name_tv);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        Utils.a(readPersonInfo, this.c);
        this.d.setText(readPersonInfo.nickname);
        this.e = (TextView) findViewById(R.id.share_main_content);
        this.f = (TextView) findViewById(R.id.share_main_content_unit);
        this.g = (TextView) findViewById(R.id.share_description);
        this.h = findViewById(R.id.share_background_v);
        this.i = (TextView) findViewById(R.id.share_title);
        this.b = (TextView) findViewById(R.id.sport_name);
        this.n = (TextView) findViewById(R.id.ranking);
        this.m = (TextView) findViewById(R.id.share);
        if (this.m != null) {
            this.m.setOnClickListener(this);
        }
    }

    private void e() {
        Intent intent = new Intent(C0826v.b);
        intent.putExtra(k.h, this.r);
        startActivity(intent);
    }

    private void f() {
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra("share_data", this.j);
        startActivity(intent);
    }

    private void g() {
        this.p = BitmapFactory.decodeFile(this.o);
        ((TextView) findViewById(R.id.share_from_mi_band_txt)).setText(getString(R.string.come_from_xiaomi_bracelet) + " " + new SimpleDateFormat(getString(R.string.date_month_day)).format(new Date()));
    }

    public void onBackPressed() {
        super.onBackPressed();
        e();
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                f();
                C0401a.a((Context) this, C0401a.aZ, C0401a.cx);
                finish();
                return;
            case R.id.back_btn:
                e();
                finish();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_lab_sport_result);
        Intent intent = getIntent();
        this.j = a(intent);
        this.q = intent.getBooleanExtra("timeout", false);
        this.r = intent.getStringExtra(k.h);
        b();
        d();
        a(this.j);
    }

    public void onDestroy() {
        if (this.k != null) {
            if (!this.k.isRecycled()) {
                this.k.recycle();
            }
            this.k = null;
        }
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
        if (this.o != null) {
            File file = new File(this.o);
            if (file.exists()) {
                file.delete();
            }
        }
        a();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.ab);
        C0401a.b((Activity) this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
    }

    public void onResume() {
        super.onResume();
        if (this.q) {
            Bundle bundle = new Bundle();
            bundle.putString(ae.a, getString(R.string.confirm));
            bundle.putString(ae.b, getString(R.string.lab_factory_sport_monitor_timeout_notice));
            bundle.putString(ae.c, getString(R.string.lab_factory_sport_finish_desc));
            ae.a(this, ae.class, bundle, new ac());
        }
        C0401a.a(C0401a.ab);
        C0401a.a((Activity) this);
    }
}
