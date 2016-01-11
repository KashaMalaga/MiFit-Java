package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import de.greenrobot.event.EventBus;

public class SettingAboutActivity extends SystemBarTintActivity {
    private static final String a = "SettingAboutActivity";
    private dE b = null;
    private BroadcastReceiver c;
    private b d = b.h();

    private void a() {
        this.c = new dD(this);
        registerReceiver(this.c, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        EventBus.getDefault().register(this);
    }

    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(Constant.aN);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        this.b = (dE) Fragment.instantiate(this, dE.class.getName(), bundleExtra);
        beginTransaction.add(16908290, this.b);
        beginTransaction.commit();
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.c);
        this.c = null;
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventApkupgrade eventApkupgrade) {
        C0596r.e(a, "onEvent force=" + eventApkupgrade.isForceCheck() + " HasWindowfocus=" + hasWindowFocus());
        if (hasWindowFocus()) {
            Utils.b((Activity) this, eventApkupgrade.isForceCheck());
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

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
