package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.hm.health.R;

public class FwLowBatteryActivity extends SystemBarTintActivity {
    private TextView a = null;
    private Button b = null;

    private void a() {
        startActivity(new Intent(this, FwUpgradeFailedActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fw_low_battery);
        this.a = (TextView) findViewById(R.id.fw_low_battery_help_tv);
        this.a.getPaint().setFlags(8);
        this.a.setOnClickListener(new aO(this));
        this.b = (Button) findViewById(R.id.fw_low_battery_confirm_btn);
        this.b.setOnClickListener(new aP(this));
    }
}
