package cn.com.smartdevices.bracelet.weibo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.c;
import com.huami.android.widget.share.m;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.net.RequestListener;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class BindHealthActivity extends SystemBarTintActivity {
    public static int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final String e = "BindWeiboHealthActivity";
    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 3;
    private static final int n = 4;
    private int f;
    private Button g;
    private TextView h;
    private n i = null;
    private v j;
    private Handler o = new C0855b(this);
    private boolean p = true;
    private AuthInfo q;
    private ThirdLoginState r;
    private SsoHandler s;
    private RequestListener t = new i(this);

    private void a() {
        new Thread(new g(this)).start();
    }

    private void a(int i) {
        C0596r.e(e, "refresh bind state " + i);
        if (k == i) {
            String i2 = q.i(this);
            C0596r.e(e, "nickName " + i2);
            if (!a.f.equals(i2)) {
                this.h.setVisibility(0);
                TextView textView = this.h;
                Object[] objArr = new Object[k];
                objArr[0] = i2;
                textView.setText(getString(R.string.state_binded_nickname_weibo, objArr));
            }
            this.g.setText(getString(R.string.unbind));
        }
        if (i == 0) {
            this.h.setVisibility(8);
            this.g.setText(getString(R.string.bind_weibo_health));
        }
        if (-1 == i) {
            this.h.setVisibility(8);
            this.g.setText(getString(R.string.rebind_weibo_health));
        }
        this.g.setTag(Integer.valueOf(i));
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BindHealthActivity.class);
        context.startActivity(intent);
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("action_type", i);
        intent.setClass(context, BindHealthActivity.class);
        context.startActivity(intent);
    }

    private void a(String str) {
        Message message = new Message();
        message.what = n;
        message.obj = str;
        this.o.sendMessage(message);
    }

    private void b() {
        this.g.setClickable(false);
        new Thread(new h(this)).start();
    }

    private void b(int i) {
        Message message = new Message();
        message.what = k;
        message.obj = Integer.valueOf(i);
        this.o.sendMessage(message);
    }

    private void c() {
        C0596r.e(e, "SSO");
        this.g.setClickable(false);
        this.s.authorize(new l(this));
    }

    private void c(int i) {
        Message message = new Message();
        message.what = l;
        message.arg1 = i;
        this.o.sendMessage(message);
    }

    public void a(boolean z) {
        Message message = new Message();
        message.what = m;
        if (z) {
            message.arg1 = 0;
        } else {
            message.arg1 = k;
        }
        this.o.sendMessage(message);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.s != null) {
            this.s.authorizeCallBack(i, i2, intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (a == l) {
            this.j.c(this);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bind_weibo_health);
        this.g = (Button) findViewById(R.id.start_bind);
        this.h = (TextView) findViewById(R.id.binded_qq_nickname);
        this.g.setOnClickListener(new C0856c(this));
        this.j = v.a();
        this.f = q.a(this);
        a(this.f);
        findViewById(R.id.home_back).setOnClickListener(new C0857d(this));
        this.q = new AuthInfo(this, m.l, o.b, o.c);
        this.s = new SsoHandler(this, this.q);
        Intent intent = getIntent();
        if (intent != null) {
            a = intent.getIntExtra("action_type", -1);
        }
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(getApplicationContext());
        if (f == null || !f.isValid()) {
            this.p = false;
            this.i = new e(this);
            this.i.setCanceledOnTouchOutside(false);
            c.showPanel((Activity) this, this.i);
        } else if (a == k && this.f == 0) {
            c();
        }
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        C0401a.a(C0401a.aD);
        C0401a.a((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.b(C0401a.aD);
        C0401a.b((Activity) this);
    }
}
