package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.C0401a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class SettingAboutUserAgreementActivity extends SystemBarTintActivity {
    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_setting_about_user_agreement);
        if (bundle == null) {
            getFragmentManager().beginTransaction().add(l.container, Fragment.instantiate(this, dM.class.getName())).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
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
