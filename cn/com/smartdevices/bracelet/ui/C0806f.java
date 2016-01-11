package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.p;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;

class C0806f implements OnCheckedChangeListener {
    final /* synthetic */ AlarmClockItem a;
    final /* synthetic */ C0778e b;

    C0806f(C0778e c0778e, AlarmClockItem alarmClockItem) {
        this.b = c0778e;
        this.a = alarmClockItem;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.setEnabled(z);
        AlarmActivity.a(this.a, this.b.a.p);
        C0401a.a(this.b.a.p, C0401a.gx, z + a.f);
        C0596r.e("AlarmAdapter", "set clocks item:" + this.a.toJson());
        this.b.notifyDataSetChanged();
        new p(this.b.a.u, new C0807g(this, z)).f();
    }
}
