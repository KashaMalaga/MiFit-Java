package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class FwUpgradeFailedActivity extends SystemBarTintActivity implements OnClickListener {
    public void onClick(View view) {
        switch (view.getId()) {
            case l.fw_help_screen_home_back /*2131296397*/:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_fw_failed_help);
        findViewById(l.fw_help_screen_home_back).setOnClickListener(this);
    }
}
