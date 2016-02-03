package cn.com.smartdevices.bracelet.weight.family;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;

public class MemberInfoBaseActivity extends SystemBarTintActivity implements OnClickListener {
    protected static final String a = "MemberInfoBaseActivity";
    public static final String b = "USER_INFO_UID";
    public static final String c = "set_visitor_mode";
    public static final String d = "weight_choose_user";
    protected boolean e = false;
    protected boolean f = false;
    protected e g;
    private View h = null;
    private View i = null;

    protected void b() {
        this.h = findViewById(R.id.right_button);
        this.h.setOnClickListener(this);
        this.i = findViewById(R.id.left_button);
        this.i.setOnClickListener(this);
    }

    public void c() {
        C0596r.e(a, "onCancel");
        setResult(0);
        finish();
    }

    public void d() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(a, "onActivityResult ");
        if (i != 6) {
            return;
        }
        if (i2 == -1) {
            setResult(-1, intent);
            finish();
        } else if (i2 == 0) {
            setResult(0);
        }
    }

    public void onBackPressed() {
        c();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_button:
                c();
                return;
            case R.id.right_button:
                d();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
