package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaomi.hm.health.R;

public class FwUpgradeFailedActivity extends SystemBarTintActivity implements OnClickListener {
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fw_help_screen_home_back:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fw_failed_help);
        findViewById(R.id.fw_help_screen_home_back).setOnClickListener(this);
    }
}
