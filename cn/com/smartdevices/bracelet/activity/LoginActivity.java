package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0667t;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.m;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.shoes.sync.J;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetNameActivity;
import com.c.a.C0993k;
import com.xiaomi.account.openauth.h;
import com.xiaomi.account.openauth.i;
import com.xiaomi.account.openauth.l;
import com.xiaomi.account.openauth.p;
import com.xiaomi.hm.health.R;
import java.util.Locale;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends SystemBarTintActivity implements OnClickListener {
    private static t C = null;
    private static final String g = "login";
    private static final boolean h = false;
    private static final int i = 256;
    private static final int j = 257;
    private static boolean k = h;
    private static boolean l = h;
    private String A;
    private String B;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    private b m = b.h();
    private Button n = null;
    private Button o = null;
    private LoginActivity p;
    private LoginInfo q;
    private View r;
    private ValueAnimator s;
    private TextView t;
    private TextView u;
    private Handler v;
    private View w;
    private WebView x;
    private TextView y;
    private boolean z;

    private void a() {
        WebSettings settings = this.x.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        this.x.setLayerType(1, null);
        this.x.setBackgroundColor(0);
        this.x.setInitialScale((getResources().getDisplayMetrics().densityDpi * 100) / a.ax);
        this.x.loadUrl("file:///android_asset/startup.gif");
        this.x.setOnTouchListener(new k(this));
        new Handler().postDelayed(new l(this), 4800);
        this.u.setEnabled(h);
        this.n.setEnabled(h);
        this.o.setEnabled(h);
    }

    private void a(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        C0596r.e(g, "response=\n" + Utils.b(bArr));
        n a = n.a(this.p.getApplicationContext(), b);
        if (a.c()) {
            try {
                JSONObject optJSONObject = new JSONObject(b).optJSONObject(com.xiaomi.channel.gamesdk.b.b);
                if (optJSONObject != null) {
                    this.q = (LoginInfo) new C0993k().a(optJSONObject.toString(), LoginInfo.class);
                    C0596r.e(g, "loginInfo = " + this.q);
                    a(this.q);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        com.huami.android.view.b.a(this.p, getString(R.string.login_failed) + "\uff0c" + getString(R.string.error_code) + a.ci + a.h, 1).show();
        i();
        C0596r.d(g, "Login webstatus fail, code = " + a.h + Utils.b(bArr));
    }

    public static void a(Context context, t tVar) {
        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
        C = tVar;
    }

    private void a(LoginInfo loginInfo) {
        C0596r.e(g, "getXiaoMiProfile, algo = " + loginInfo.mac_algorithm);
        a(new p().a(this.p, this.m.b.a.longValue(), h.u, loginInfo.access_token, loginInfo.mac_key, loginInfo.mac_algorithm), new C0408g(this));
    }

    private <V> void a(i<V> iVar, u uVar) {
        new C0407f(this, iVar, uVar).execute(new Void[0]);
    }

    private void a(l lVar) {
        String i = lVar.i();
        this.B = i;
        if (i != null) {
            this.z = true;
            C0596r.e(g, "get code = " + this.B);
            cn.com.smartdevices.bracelet.j.l.b(this.B, new s(this));
            return;
        }
        this.z = h;
        int j = lVar.j();
        C0596r.d(g, "onFail: errorCode," + j + ";errorMessage," + lVar.k());
        this.v.post(new r(this));
    }

    private void a(String str) {
        C0596r.e(g, "onGetProfileResult: " + str);
        m.a(this.q, str);
        if (this.q.userid <= 0) {
            C0596r.d(g, "Login miid is empty!");
            com.huami.android.view.b.a(this.p, (int) R.string.login_failed, 1).show();
        } else if (a(this.q.userid)) {
            cn.com.smartdevices.bracelet.j.l.a(this.q, cn.com.smartdevices.bracelet.e.a.d(this.p), new h(this));
        }
    }

    private void a(boolean z) {
        finish();
        l();
        Utils.c(this.p);
        Intent intent = new Intent();
        if (z && Keeper.readPersonInfo().isValid()) {
            intent.setClass(this.p, MainUIActivity.class);
        } else {
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            if (this.q != null) {
                if (this.q.miliaoIcon_320 == null || this.q.miliaoIcon_320.length() <= 0) {
                    readPersonInfo.avatarUrl = this.q.miliaoIcon;
                } else {
                    readPersonInfo.avatarUrl = this.q.miliaoIcon_320;
                }
                Keeper.keepPersonInfo(readPersonInfo);
            }
            J.c(this.p);
            C0596r.e(g, "person nickname is " + readPersonInfo.nickname);
            if ((readPersonInfo.nickname.isEmpty() || readPersonInfo.nickname.equals(readPersonInfo.uid + com.xiaomi.e.a.f)) && !readPersonInfo.isValid()) {
                C0596r.e(g, "personinfo set name");
                intent.setClass(this.p, PersonInfoSetNameActivity.class);
            } else {
                C0596r.e(g, "personinfo set gender");
                intent.setClass(this.p, PersonInfoSetGenderActivity.class);
            }
        }
        Utils.z(getApplicationContext());
        Keeper.setActiveHistory(4);
        if (C != null) {
            C.a();
            return;
        }
        C0596r.e(g, "startActivity: " + intent);
        startActivity(intent);
    }

    private boolean a(long j) {
        boolean z = true;
        if (j <= Constant.aU) {
            e.t = h;
            C0596r.e(g, "overseas = false");
        } else if (j <= Constant.aT) {
            e.t = true;
        } else {
            com.huami.android.view.b.a((Context) this, (int) R.string.miid_not_support, 1).show();
            z = h;
        }
        C0596r.d(g, "BasicServerDef.USE_HOST_OVERSEAS:" + e.t);
        return z;
    }

    private void b(l lVar) {
        C0596r.e(g, "result:" + lVar.toString());
        this.f = lVar.b();
        this.d = lVar.c();
        this.e = lVar.d();
        this.a = lVar.e();
        this.b = lVar.f();
        this.c = lVar.g();
        if (this.q == null) {
            this.q = new LoginInfo();
        }
        this.q.access_token = this.f;
        this.q.mac_key = this.c;
        this.q.expiresIn = this.d;
        this.q.mac_algorithm = lVar.h();
        this.v.sendEmptyMessage(j);
        this.z = true;
    }

    private boolean b() {
        return (Keeper.readShowedUserAgreement() || !(Utils.k() || l)) ? h : true;
    }

    private void c() {
        Object string;
        SpannableString spannableString;
        this.x = (WebView) findViewById(R.id.bracelet_login_webview);
        this.w = findViewById(R.id.bracelet_login_part_2);
        this.r = findViewById(R.id.bracelet_login_title);
        this.t = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.y = (TextView) findViewById(R.id.buy_band_txt);
        if (Locale.getDefault().toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
            string = getString(R.string.donot_have_band);
            spannableString = new SpannableString(string);
            spannableString.setSpan(new n(this), 0, string.length(), 33);
            Utils.a(this.y, spannableString);
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
        this.n = (Button) findViewById(R.id.mi_login_btn);
        this.n.setOnClickListener(this);
        this.o = (Button) findViewById(R.id.mi_register_btn);
        this.o.setOnClickListener(this);
        this.u = (TextView) findViewById(R.id.bracelet_login_info);
        string = getString(R.string.user_agreement);
        this.u.setText(getResources().getString(R.string.bracelet_login_info_2));
        spannableString = new SpannableString(string);
        spannableString.setSpan(new o(this), 0, string.length(), 33);
        Utils.a(this.u, spannableString);
        if (l) {
            this.u.setVisibility(8);
            LayoutParams layoutParams = (LayoutParams) this.x.getLayoutParams();
            layoutParams.topMargin = (int) (((float) layoutParams.topMargin) + TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
            return;
        }
        this.u.setVisibility(0);
    }

    private void d() {
        this.v.sendEmptyMessageDelayed(i, 300);
        k();
        if (k) {
            f();
        } else {
            e();
        }
    }

    private void e() {
        int[] iArr = new int[]{1, 2};
        boolean g = g();
        C0596r.d(g, "getOAuthCode->redirect url = " + this.A);
        a(new p().a(this.m.b.a.longValue()).a(this.A).a(iArr).b(g).a((boolean) h).b(this.p), new p(this));
    }

    private void f() {
        C0596r.e(g, "start getOAuthAccessToken");
        int[] iArr = new int[]{1, 2};
        a(new p().a(this.m.b.a.longValue()).a(this.A).a(iArr).b(g()).a((boolean) h).a(this.p), new q(this));
    }

    private boolean g() {
        return (C0667t.a(this) && (VERSION.SDK_INT <= 18)) ? true : h;
    }

    private void h() {
        new C0405d(this).execute(new Void[0]);
    }

    private void i() {
        l();
        com.huami.android.view.b.a(this.p, (int) R.string.login_failed, 1).show();
    }

    private void j() {
        com.huami.android.view.b.a(this.p, (int) R.string.login_failed, 0).show();
        l();
    }

    private void k() {
        Utils.a((Activity) this, (int) R.string.logining);
    }

    private void l() {
        Utils.a((Activity) this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (C != null) {
            C.b();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mi_login_btn:
                if (Utils.l(this)) {
                    d();
                    C0401a.a((Context) this, C0401a.dv, C0401a.dw);
                    return;
                }
                com.huami.android.view.b.a((Context) this, (int) R.string.network_error, 1).show();
                return;
            case R.id.mi_register_btn:
                if (Utils.l(this)) {
                    Intent intent = new Intent();
                    intent.putExtra(a.d, 0);
                    intent.setClass(this.p, WebActivity.class);
                    startActivityForResult(intent, 1);
                    C0401a.a((Context) this, C0401a.dv, C0401a.dx);
                    return;
                }
                com.huami.android.view.b.a((Context) this, (int) R.string.network_error, 1).show();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = this;
        l = !Locale.getDefault().toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) ? true : h;
        C0596r.e(g, "is global = " + this.m.w);
        if (this.m.w.booleanValue()) {
            this.m.b.getClass();
            this.A = "https://hm.mi-ae.com/huami.health.loginview.do";
        } else {
            this.m.b.getClass();
            this.A = "https://hm.xiaomi.com/huami.health.loginview.do";
        }
        if (!TextUtils.isEmpty(e.u)) {
            this.A = e.u + "huami.health.loginview.do";
        }
        setContentView((int) R.layout.activity_login);
        disableAutoApplyStatusBarTint();
        applyStatusBarTintResDrawable(R.drawable.bg_login);
        this.v = new C0404c(this);
        c();
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        C0596r.e(g, "onDestroy");
        if (C != null) {
            C = null;
        }
    }

    protected void onPause() {
        super.onPause();
        C0596r.e(g, "onPause");
        this.v.removeMessages(i);
        C0401a.b(C0401a.n);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0596r.e(g, "onResume");
        if (this.z) {
            k();
            this.z = h;
        }
        C0401a.a(C0401a.n);
        C0401a.a((Activity) this);
    }
}
