package cn.com.smartdevices.bracelet.ui.person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;

public class PersonInfoBaseActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String c = "PersonInfoBaseActivity";
    protected PersonInfo a = null;
    protected Context b;
    private View d = null;
    private View e = null;

    protected void a() {
        this.d = findViewById(R.id.right_button);
        this.d.setOnClickListener(this);
        this.e = findViewById(R.id.left_button);
        this.e.setOnClickListener(this);
    }

    public void b() {
        C0596r.e(c, "onCancel");
        Keeper.keepPersonInfo(this.a);
        setResult(0);
        finish();
    }

    public void c() {
        C0596r.e(c, "onNext(), personInfo = " + this.a);
        Keeper.keepPersonInfo(this.a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(c, "onActivityResult: " + getLocalClassName() + ", requestCode=" + i + ", result:" + i2);
        if (i != 6) {
            return;
        }
        if (i2 == -1) {
            C0596r.e(c, "finish page: " + getLocalClassName());
            setResult(-1);
            finish();
            return;
        }
        this.a = Keeper.readPersonInfo();
    }

    public void onBackPressed() {
        super.onBackPressed();
        b();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_button:
                b();
                return;
            case R.id.right_button:
                c();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = Keeper.readPersonInfo();
        this.b = this;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
