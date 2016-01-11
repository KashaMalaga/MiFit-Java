package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0401a;

public class SettingInComingCallActivity extends SystemBarTintActivity {
    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(16908290, new C0796eq(), C0796eq.class.getName());
        beginTransaction.commit();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a((Activity) this);
    }
}
