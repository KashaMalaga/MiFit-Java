package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import de.greenrobot.event.EventBus;

public class LabFactoryConnectedAdvActivity extends SystemBarTintActivity {
    private LinearLayout a = null;
    private Switch b = null;
    private View c = null;
    private PersonInfo d = null;

    private void a(boolean z) {
        if (z) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_lab_factory_connected_adv);
        this.d = Keeper.readPersonInfo();
        findViewById(R.id.home_back).setOnClickListener(new C0569e(this));
        this.a = (LinearLayout) findViewById(R.id.lab_factory_connected_adv);
        this.a.setOnClickListener(new C0570f(this));
        this.b = (Switch) findViewById(R.id.lab_factory_connected_adv_switch);
        this.b.setChecked(this.d.isEnableConnectedBtAdv());
        this.b.setOnCheckedChangeListener(new C0571g(this));
        this.c = findViewById(R.id.lab_factory_connected_adv_mask_view);
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        a(hwConnStatus.k());
        applyStatusBarTintAuto();
    }

    protected void onResume() {
        super.onResume();
        a(a.c());
    }
}
