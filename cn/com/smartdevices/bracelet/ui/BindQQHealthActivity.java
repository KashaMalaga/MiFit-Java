package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.QQLogin.QQUserInfo;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import com.huami.android.view.c;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.IUiListener;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;

public class BindQQHealthActivity extends SystemBarTintActivity {
    private QQLogin a;
    private QQHealth b;
    private b c = b.h();
    private IUiListener d = new C(this);
    private IUiListener e = new D(this);
    private Button f;
    private TextView g;

    private void a() {
        this.a = QQLogin.getInstance(getApplicationContext());
        this.a.setLoginListener(this.d);
        this.a.setUserInfoListener(this.e);
        this.b = QQHealth.getInstance(getApplicationContext());
    }

    public static void a(Activity activity) {
        QQLogin instance = QQLogin.getInstance();
        boolean a = a(instance);
        C0596r.e("QQ.Login", "Check Need Login : " + a);
        if (a && !(activity instanceof BindQQHealthActivity)) {
            if ((activity instanceof LoginActivity) && instance.mIsFromQQ) {
                instance.mIsFromQQ = false;
                a(activity, instance);
            } else if (instance.getLaunchActivity() == null || instance.getLaunchActivity() == activity.getClass()) {
                instance.setLaunchActivity(null);
                activity.startActivity(new Intent(activity, BindQQHealthActivity.class));
            }
        }
    }

    private static void a(Activity activity, QQLogin qQLogin) {
        c.showPanel(activity, new H());
        qQLogin.setLaunchActivity(MainUIActivity.class);
    }

    private void a(Button button, TextView textView) {
        if (this.a.isLoginValid()) {
            button.setText(r.unbind);
            QQUserInfo qQUserInfo = this.a.getQQUserInfo();
            if (qQUserInfo == null || TextUtils.isEmpty(qQUserInfo.getNickName())) {
                textView.setVisibility(4);
                textView.setText(a.f);
                return;
            }
            textView.setVisibility(0);
            textView.setText(getString(r.state_binded_nickname, new Object[]{qQUserInfo.getNickName()}));
            return;
        }
        button.setText(r.bind_qq_health);
        textView.setVisibility(4);
        textView.setText(a.f);
    }

    public static boolean a(Activity activity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        for (String str : extras.keySet()) {
            C0596r.e("QQ.Login", "K : " + str + ", V : " + extras.get(str));
        }
        boolean equals = "qqhealth".equals(extras.getString(QQLogin.KEY_FROM));
        if (!equals) {
            return equals;
        }
        QQLogin instance = QQLogin.getInstance(activity.getApplicationContext());
        instance.mIsFromQQ = equals;
        String string = extras.getString(SocialConstants.PARAM_OPEN_ID);
        String openId = instance.getTencent().getOpenId();
        C0596r.e("QQ.Login", "FromQQ OpenId : " + string + ", Last OpenId : " + openId);
        if (openId == null || !openId.equals(string)) {
            C0596r.e("QQ.Login", "Need Login!!");
            instance.setNeedLogin(true);
            if (openId != null) {
                C0596r.e("QQ.Login", "Need Switch Login!!");
                instance.setNeedSwitchLogin(true);
            }
        }
        activity.setIntent(new Intent());
        instance.setLoginCanceled(false);
        return equals;
    }

    private static boolean a(QQLogin qQLogin) {
        if (qQLogin == null || qQLogin.isLoginCanceled()) {
            return false;
        }
        boolean z = (qQLogin.getTencent().getOpenId() == null || qQLogin.isLoginValid()) ? false : true;
        return qQLogin.isNeedLogin() || z;
    }

    private void b() {
        DialogFragment f = new F(this);
        Bundle bundle = new Bundle();
        bundle.putString("Msg", getString(r.bind_qq_health_tip_another_qq));
        f.setArguments(bundle);
        c.showPanel((Activity) this, f);
    }

    private void c() {
        new Handler().postDelayed(new G(this), 1000);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.c.c.d.booleanValue()) {
            this.a.onResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_bind_qq_health);
        if (this.c.c.d.booleanValue()) {
            a();
        }
        this.f = (Button) findViewById(l.start_bind);
        this.f.setOnClickListener(new E(this));
        this.g = (TextView) findViewById(l.binded_qq_nickname);
        a(this.f, this.g);
    }

    protected void onDestroy() {
        if (this.c.c.d.booleanValue()) {
            super.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.c.c.d.booleanValue()) {
            C0401a.b(C0401a.V);
            C0401a.b((Activity) this);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.c.c.d.booleanValue()) {
            C0401a.a((Activity) this);
            C0401a.a(C0401a.V);
            boolean a = a(this.a);
            C0596r.e("QQ.Login", "Check Need Login : " + a);
            if (!a) {
                return;
            }
            if (this.a.isNeedSwitchLogin()) {
                b();
            } else {
                c();
            }
        }
    }
}
