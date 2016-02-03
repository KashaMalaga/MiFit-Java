package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.R;

public class SettingActivity extends SystemBarTintActivity implements OnClickListener {
    public static final String a = "select_device";
    private boolean b = false;

    public void a() {
    }

    public void b() {
    }

    public void onClick(View view) {
        if (view.getId() == R.id.skip_bind) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings);
        DeviceListFragment deviceListFragment = (DeviceListFragment) getFragmentManager().findFragmentById(R.id.content);
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getBooleanExtra(a, false);
            if (this.b) {
                deviceListFragment.a(2);
                ((TextView) findViewById(R.id.title)).setText(getResources().getString(R.string.select_devices));
                View findViewById = findViewById(R.id.settings_parent);
                View findViewById2 = findViewById(R.id.skip_bind);
                findViewById.post(new dO(this, findViewById2, findViewById));
                findViewById2.setVisibility(0);
                findViewById2.setOnClickListener(this);
                findViewById(R.id.home_back).setVisibility(4);
            }
        }
        if (!DeviceSource.hasBindBracelet() && DeviceSource.hasBindWeight()) {
            C0401a.a((Context) this, C0401a.fJ, "01");
        } else if (DeviceSource.hasBindBracelet() && DeviceSource.hasBindWeight()) {
            C0401a.a((Context) this, C0401a.fJ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
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
