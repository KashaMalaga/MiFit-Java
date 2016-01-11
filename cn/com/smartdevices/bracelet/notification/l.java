package cn.com.smartdevices.bracelet.notification;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v7.widget.N;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.hm.health.n;

public class l extends N<k> {
    final /* synthetic */ NotificationSettingActivity a;
    private PackageManager b;

    public l(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
        this.b = notificationSettingActivity.getPackageManager();
    }

    public int a() {
        return this.a.b.b();
    }

    public /* synthetic */ aj a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public void a(k kVar, int i) {
        j jVar;
        a a = this.a.b.a(i);
        j jVar2 = null;
        if (a != null) {
            try {
                jVar = new j(this.a, this.b, this.b.getApplicationInfo(a.a, 0));
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            jVar = null;
        }
        jVar2 = jVar;
        if (jVar2 != null) {
            jVar2.a();
            kVar.r.setImageDrawable(jVar2.c());
            kVar.s.setText(jVar2.b());
            kVar.t.setChecked(a.b);
            kVar.t.setEnabled(this.a.b.f());
            kVar.t.setOnClickListener(new m(this, a, kVar));
        }
    }

    public k c(ViewGroup viewGroup, int i) {
        return new k(LayoutInflater.from(viewGroup.getContext()).inflate(n.view_notifi_picked_apps_item, viewGroup, false));
    }
}
