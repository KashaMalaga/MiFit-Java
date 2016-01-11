package cn.com.smartdevices.bracelet.weight.family;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weight.J;

public class UserInfoActivity extends SystemBarTintActivity {
    private static final String a = UserInfoActivity.class.getSimpleName();
    private int b = -1;
    private h c;

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        h hVar = (h) getFragmentManager().findFragmentByTag(h.class.getName());
        if (hVar != null) {
            hVar.onActivityResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.b = getIntent().getIntExtra(MemberInfoBaseActivity.b, -1);
            C0596r.e(a, "UserInfoActivity receive the infomation uid " + this.b);
            C0596r.e(a, "userinfo " + J.a().a(this.b).toString());
        }
        this.c = (h) h.a(this.b);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.c, h.class.getName());
        beginTransaction.commit();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
