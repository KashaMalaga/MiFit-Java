package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetNameActivity;
import cn.com.smartdevices.bracelet.weibo.BindHealthActivity;
import cn.com.smartdevices.bracelet.weibo.v;

public class MainActivity extends Activity {
    private static final String a = "MainActivity";
    private static final int b = 1;
    private v c = v.a();
    private final b d = b.h();

    private void a() {
        Intent intent = new Intent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        LoginData f = a.f(getApplicationContext());
        if (f == null || !f.isValid()) {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        PersonInfo readPersonInfoBase = Keeper.readPersonInfoBase();
        if (!C0596r.b()) {
            if (readPersonInfoBase == null) {
            }
            intent.setClass(this, PersonInfoSetNameActivity.class);
            startActivity(intent);
            finish();
        } else if (readPersonInfoBase == null && readPersonInfoBase.isValid()) {
            intent.setClass(this, MainUIActivity.class);
            startActivity(intent);
            finish();
        } else {
            intent.setClass(this, PersonInfoSetNameActivity.class);
            startActivity(intent);
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == b) {
            a();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent;
        if (VERSION.SDK_INT == 18) {
            LoginData f = a.f(getApplicationContext());
            if (f == null || !f.isValid()) {
                intent = new Intent();
                intent.setClass(this, SystemLowActivity.class);
                startActivityForResult(intent, b);
                return;
            }
        } else if (VERSION.SDK_INT < 18 && !(com.xiaomi.hm.health.bt.bleservice.a.a((Context) this) && Utils.a())) {
            intent = new Intent();
            intent.setClass(this, SystemNotSupportActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        if (this.d.c.f.booleanValue() && this.c.a(getIntent())) {
            C0401a.a((Context) this, C0401a.aE);
            BindHealthActivity.a((Context) this, (int) b);
            finish();
            return;
        }
        a();
    }
}
