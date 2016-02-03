package cn.com.smartdevices.bracelet.weight;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserPicked;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightChanged;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.view.WeightUserAvatar;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.huami.android.ui.a;
import com.huami.android.view.c;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.mipush.sdk.f;
import de.greenrobot.event.EventBus;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeightReportActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String a = "WeightReportActivity";
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private String[] G = new String[0];
    private boolean H = false;
    private float I = 0.0f;
    private as J;
    private boolean K = false;
    private Context b = this;
    private TextView c = null;
    private TextView d = null;
    private TextView e = null;
    private LinearLayout f;
    private RelativeLayout g;
    private ImageButton h;
    private RelativeLayout i;
    private TextView j;
    private boolean k = false;
    private WeightInfo l;
    private UserInfo m;
    private e n;
    private int o;
    private int p;
    private TextView q;
    private TextView r;
    private TextView s;
    private WeightUserAvatar t;
    private TextView u;
    private ImageButton v = null;
    private RelativeLayout w;
    private TextView x;
    private TextView y;
    private TextView z;

    private void a() {
        this.v = (ImageButton) findViewById(R.id.weight_report_dele_btn);
        this.v.setOnClickListener(this);
        this.t = (WeightUserAvatar) findViewById(R.id.user_icon);
        this.u = (TextView) findViewById(R.id.user_name);
        this.f = (LinearLayout) findViewById(R.id.bg_layout);
        this.h = (ImageButton) findViewById(R.id.wr_share);
        this.g = (RelativeLayout) findViewById(R.id.app_share_layout);
        this.h.setOnClickListener(this);
        this.q = (TextView) findViewById(R.id.current_weight_title);
        this.r = (TextView) findViewById(R.id.current_weight_value);
        this.s = (TextView) findViewById(R.id.current_weight_tips);
        this.c = (TextView) findViewById(R.id.wr_bmi_tips_tv);
        this.d = (TextView) findViewById(R.id.wr_figure_tips_tv);
        if (Utils.m()) {
            C0596r.e(a, "isNoChinese");
            this.c.setTextSize((float) Utils.a(5.0f, this.b));
            this.d.setTextSize((float) Utils.a(5.0f, this.b));
        } else {
            C0596r.e(a, "isChinese");
            this.c.setTextSize((float) Utils.a(10.0f, this.b));
            this.d.setTextSize((float) Utils.a(10.0f, this.b));
        }
        this.e = (TextView) findViewById(R.id.wr_home_back);
        this.e.setOnClickListener(this);
        this.i = (RelativeLayout) findViewById(R.id.bmi_layout);
        this.i.setOnClickListener(this);
        this.j = (TextView) findViewById(R.id.share_text);
        this.j.setText(getString(R.string.app_name) + " " + new SimpleDateFormat(getString(R.string.date_month_day)).format(new Date()));
        C0596r.e("SHARE", "share time text " + this.j.getText().toString());
        b();
    }

    private void a(int i, int i2) {
        this.G = Utils.a(i, i2, this.n.h());
        this.z.setText(Utils.i(this.G[2]));
        this.A.setText(Utils.i(this.G[3]));
        this.B.setText(Utils.i(this.G[4]));
        this.C.setText(Utils.i(this.G[5]));
        this.D.setText(Utils.i(this.G[6]));
        this.E.setText(Utils.i(this.G[7]));
        this.F.setText(Utils.i(this.G[8]));
        this.x.setText(Utils.d(this.b, i) + getString(R.string.weight_ref) + "(" + aA.a(this.b, this.n.h()) + ")");
    }

    private void a(Bundle bundle) {
        if (!this.K) {
            Bitmap drawingCache;
            this.K = true;
            if (this.J == null) {
                this.J = (as) Fragment.instantiate(this.b, as.class.getName());
                this.J.setArguments(bundle);
                this.J.a(new aq(this));
            }
            View decorView;
            if (a.b(this.b)) {
                decorView = getWindow().getDecorView();
                decorView.buildDrawingCache();
                drawingCache = decorView.getDrawingCache();
            } else {
                decorView = findViewById(16908290);
                if (decorView != null) {
                    decorView.buildDrawingCache();
                    drawingCache = decorView.getDrawingCache();
                } else {
                    drawingCache = null;
                }
            }
            this.J.a(drawingCache);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.addToBackStack(null);
            this.J.show(beginTransaction, null);
        }
    }

    private void a(UserInfo userInfo, boolean z) {
        if (!(userInfo == null || this.n == null)) {
            C0596r.e(a, "onActivityResult notify UI  " + userInfo.toString() + " weight  " + this.n.toString());
            C0596r.e(a, "timestamp " + this.n.e());
        }
        e eVar = new e();
        eVar.b(this.n.j());
        eVar.a(this.I);
        eVar.a(this.n.h());
        eVar.a(this.n.e());
        String a = z ? aA.a(this.n.e(), 0) : aA.a(this.n.e(), this.p);
        ah a2 = ah.a();
        WeightInfo b = a2.b(eVar.e());
        if (b != null) {
            a2.a(b, userInfo.uid);
        } else {
            C0596r.e(a, "can not go here,something wrong!!!");
        }
        C0891z.a(this.b).a(this.n, userInfo, a);
        if (z) {
            EventBus.getDefault().post(new EventWeightChanged(true, userInfo.uid));
        } else {
            EventBus.getDefault().post(new EventWeightChanged(this.p, userInfo.uid));
        }
    }

    private void b() {
        this.w = (RelativeLayout) findViewById(R.id.baby_layout);
        this.x = (TextView) findViewById(R.id.left_title);
        this.y = (TextView) findViewById(R.id.right_title);
        this.y.setOnClickListener(new ao(this));
        this.z = (TextView) findViewById(R.id.content_min_3);
        this.A = (TextView) findViewById(R.id.content_min_2);
        this.B = (TextView) findViewById(R.id.content_min_1);
        this.C = (TextView) findViewById(R.id.content_min_0);
        this.D = (TextView) findViewById(R.id.content_add_1);
        this.E = (TextView) findViewById(R.id.content_add_2);
        this.F = (TextView) findViewById(R.id.content_add_3);
    }

    private void c() {
        this.u.setText(this.m.name.isEmpty() ? getString(R.string.visitor) : this.m.name);
        this.t.a(this.m.name.isEmpty() ? getString(R.string.visitor) : this.m.name);
        Utils.a(this.m, this.t);
        this.r.setText(aA.c(this.n.j()) + com.xiaomi.e.a.f);
        this.q.setText(getString(R.string.current_weight) + "(" + aA.a(this.b, this.n.h()) + ")");
        this.f.setBackgroundResource(R.drawable.weight_report_bg);
        this.H = this.m.targetWeight > 0.0f;
        this.I = aA.a(this.m.height, Birthday.fromStr(this.m.birthday).getAge(), aA.a(this.n.j(), this.n.h()));
        int ageInMonths = Birthday.fromStr(this.m.birthday).getAgeInMonths();
        if (ageInMonths <= 83) {
            this.i.setVisibility(8);
            this.w.setVisibility(0);
            a(ageInMonths, this.m.gender);
        } else {
            this.i.setVisibility(0);
            this.w.setVisibility(8);
            if (this.m.height >= 100) {
                this.c.setText(aA.b(this.I));
                this.d.setText(aA.a(this.b, this.I, Birthday.fromStr(this.m.birthday).getAge(), this.m.gender));
            }
        }
        if (this.m.uid == 0) {
            return;
        }
        float c;
        if (this.H) {
            c = aA.c(((float) ((int) aA.b(this.m.targetWeight, this.n.h()))) - this.n.j(), 1);
            if (c > 0.0f) {
                this.s.setText(getString(R.string.lighter_than_goal, new Object[]{Math.abs(c) + aA.a(this.b, this.n.h())}));
                return;
            } else if (c < 0.0f) {
                this.s.setText(getString(R.string.heavier_than_goal, new Object[]{Math.abs(c) + aA.a(this.b, this.n.h())}));
                return;
            } else {
                this.s.setText(getString(R.string.weight_reach_goal));
                return;
            }
        }
        WeightInfo a = ah.a().a(this.m.uid, this.n.e());
        if (a != null) {
            c = aA.c(this.n.j() - aA.b(a.weight, this.n.h()), 1);
            if (c > 0.0f) {
                this.s.setText(getString(R.string.add_than_last_time, new Object[]{c + aA.a(this.b, this.n.h())}));
            } else if (c < 0.0f) {
                c = Math.abs(c);
                this.s.setText(getString(R.string.less_than_last_time, new Object[]{c + aA.a(this.b, this.n.h())}));
            }
        }
    }

    private void d() {
        Parcelable e = e();
        Intent intent = new Intent();
        intent.setClass(this.b, ShareActivity.class);
        intent.putExtra("share_data", e);
        startActivity(intent);
    }

    private ShareData e() {
        C0596r.e(a, "prepareShareData...");
        ShareData shareData = new ShareData();
        shareData.type = v.C;
        shareData.fuid = this.m.uid;
        shareData.weightTitle = this.q.getText().toString();
        shareData.weightValue = this.r.getText().toString();
        shareData.weightTips = this.s.getText().toString();
        shareData.weightFigure = this.d.getText().toString();
        shareData.weightBMI = this.c.getText().toString();
        shareData.babyMonthsStr = this.x.getText().toString();
        String str = com.xiaomi.e.a.f;
        C0596r.e(a, "mRefWeightDatas " + this.G);
        String str2 = str;
        for (String str3 : this.G) {
            C0596r.e(a, "from str " + str3);
            String str32 = Utils.i(str32);
            C0596r.e(a, "to str " + str32);
            str2 = str2 + str32 + f.i;
        }
        if (str2.isEmpty()) {
            shareData.babyRefWeights = com.xiaomi.e.a.f;
        } else {
            shareData.babyRefWeights = str2.substring(0, str2.length() - 1);
        }
        C0596r.e("SHARE_REF_WEIGHT", "from weight report " + shareData.babyRefWeights);
        return shareData;
    }

    public void onBackPressed() {
        C0596r.e(a, "onBackPressed " + this.k);
        Intent intent = new Intent();
        if (!this.k) {
            intent.putExtra("RESULT_INTENT_DATA", this.o);
        }
        setResult(-1, intent);
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wr_share:
                d();
                C0401a.a(this.b, C0401a.gn);
                return;
            case R.id.wr_home_back:
                onBackPressed();
                return;
            case R.id.bmi_layout:
                Bundle bundle = new Bundle();
                bundle.putFloat(as.a, this.I);
                bundle.putInt(as.b, Birthday.fromStr(this.m.birthday).getAge());
                bundle.putInt(as.c, this.m.gender);
                bundle.putInt(as.d, this.m.height);
                a(bundle);
                C0401a.a(this.b, C0401a.go);
                return;
            case R.id.weight_report_dele_btn:
                C0401a.a(this.b, C0401a.fA);
                String string = getString(R.string.sure_to_delete_weight);
                DialogFragment arVar = new ar();
                arVar.setOpClickListener(new ap(this, arVar));
                Bundle bundle2 = new Bundle();
                bundle2.putString("Msg", string);
                c.showPanel((Activity) this, arVar, bundle2);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_weight_report);
        a();
        Intent intent = getIntent();
        if (intent != null) {
            this.m = UserInfo.fromJsonString(intent.getStringExtra(UserInfo.USERINFO_KEY));
            this.n = e.b(intent.getStringExtra(e.d));
            if (this.m == null) {
                C0596r.e(a, "info is null");
                this.m = new UserInfo();
                this.m.name = getString(R.string.visitor);
                this.m.uid = 0;
                this.m.height = kankan.wheel.widget.a.aC;
                this.m.birthday = "2000-10";
                this.m.targetWeight = GroundOverlayOptions.NO_DIMENSION;
            } else {
                this.m.avatarSource = J.a().a(this.m.uid).avatarSource;
                C0596r.e(a, "info is not null");
            }
            C0596r.e(a, "receive userinfo " + this.m);
            C0596r.e(a, "receive weightadvdata " + this.n);
            this.k = intent.getBooleanExtra("NEW_USER", false);
            this.p = this.m.uid;
            this.o = this.p;
        }
        this.l = ah.a().b(this.n.e());
        c();
        if (this.k && this.m.uid != 0) {
            a(this.m, true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onEvent(EventUserPicked eventUserPicked) {
        C0596r.e(a, "onEventUserSelect " + eventUserPicked.uid);
        this.o = eventUserPicked.uid;
        this.m = J.a().a(this.o);
        c();
        a(this.m, false);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aQ);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aQ);
        C0401a.a((Activity) this);
    }
}
