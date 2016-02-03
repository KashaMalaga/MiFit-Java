package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.hm.health.R;

public class BindGoogleFitActivity extends SystemBarTintActivity {
    private static final String d = "GoogleFitUtil";
    private Button a;
    private TextView b;
    private Context c = this;
    private boolean e = false;

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bind_googlefit_health);
    }
}
