package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.bt.a.f;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import de.greenrobot.event.EventBus;

public class LabFactoryReminderActivity extends SystemBarTintActivity {
    private final String a = "LabFactoryReminderActivity";
    private PersonInfo b = null;
    private LinearLayout c = null;
    private Switch d = null;
    private View e = null;

    private void a(boolean z) {
        new f(new C0573i(this, z), z ? (byte) 1 : (byte) 0).f();
    }

    private void b(boolean z) {
        if (z) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_lab_factory_reminder);
        findViewById(l.lab_factory_reminder_back).setOnClickListener(new C0574j(this));
        this.b = Keeper.readPersonInfo();
        this.c = (LinearLayout) findViewById(l.lab_factory_reminder);
        this.c.setOnClickListener(new C0575k(this));
        this.d = (Switch) findViewById(l.lab_factory_reminder_switch);
        C0596r.e("LabFactoryReminderActivity", "reminder:" + this.b.getMiliDisconnectedReminder());
        this.d.setChecked(this.b.getMiliDisconnectedReminder() == 1);
        this.d.setOnCheckedChangeListener(new C0576l(this));
        this.e = findViewById(l.lab_factory_reminder_mask_view);
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        b(hwConnStatus.k());
        applyStatusBarTintAuto();
    }

    protected void onResume() {
        super.onResume();
        if (this.b.getNeedSyncServer() != 0) {
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        }
        b(a.c());
    }
}
