package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;

public class DynamicDetailActivity extends SystemBarTintActivity {
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
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(16908290, Fragment.instantiate(this, C0681ak.class.getName(), bundle2));
        beginTransaction.commit();
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
        long j = Keeper.readPersonInfo().uid;
        C0401a.a((Activity) this);
    }
}
