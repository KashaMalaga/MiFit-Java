package cn.com.smartdevices.bracelet.weight;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.n;

public class BabyTipsDetailActivity extends SystemBarTintActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_baby_tips_detail);
    }
}
