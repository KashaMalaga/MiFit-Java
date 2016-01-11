package cn.com.smartdevices.bracelet.ui;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.o;

public class SettingFirmwareActivity extends SystemBarTintActivity {
    private dW a = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        this.a = (dW) Fragment.instantiate(this, dW.class.getName());
        beginTransaction.add(16908290, this.a);
        beginTransaction.commit();
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(o.ota, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == l.action_local_ota && this.a != null && this.a.isVisible()) {
            this.a.a();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
