package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import com.xiaomi.hm.health.bt.profile.a.a;

public class StatisticActivity extends SystemBarTintActivity {
    public static final String EXTRA_SYNC_ACTION = "sync_action";
    private StatisticFragment a;

    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        disableAutoApplyStatusBarTint();
        Intent intent = getIntent();
        Bundle bundle2 = null;
        if (intent != null) {
            bundle2 = intent.getExtras();
        }
        this.a = (StatisticFragment) Fragment.instantiate(this, StatisticFragment.class.getName(), bundle2);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(16908290, this.a);
        beginTransaction.commit();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case a.Z /*21*/:
                    this.a.b.f();
                    return true;
                case a.aa /*22*/:
                    this.a.b.g();
                    return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        long j = Keeper.readPersonInfo().uid;
        C0401a.a((Activity) this);
    }
}
