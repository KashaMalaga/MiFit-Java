package cn.com.smartdevices.bracelet.notification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.hm.health.R;

public class NotificationSettingActivity extends SystemBarTintActivity {
    private static final String a = "NotificationSettingActivity";
    private h b;
    private Switch c;
    private RecyclerView d;
    private l e;

    private void a() {
        if (this.b.f()) {
            this.d.setAlpha(1.0f);
        } else {
            this.d.setAlpha(0.5f);
        }
    }

    public void onClickEnableNotification(View view) {
        if (this.b.e()) {
            this.b.a(((Switch) view).isChecked());
        } else {
            this.b.a(true);
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }
        a();
        this.e.d();
    }

    public void onClickPickNotificationApps(View view) {
        startActivity(new Intent(this, NotificationAppsActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_notification_setting);
        this.b = h.a((Context) this);
        this.c = (Switch) findViewById(R.id.enable_notification);
        this.d = (RecyclerView) findViewById(R.id.notifi_app_list);
        this.d.a(true);
        this.d.a(new LinearLayoutManager(this));
        this.e = new l(this);
        this.d.a(this.e);
    }

    protected void onResume() {
        super.onResume();
        this.c.setChecked(this.b.f());
        a();
        this.e.d();
    }
}
