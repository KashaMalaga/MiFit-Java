package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.xiaomi.hm.health.b.a.h;

class bg implements OnCheckedChangeListener {
    final /* synthetic */ RunningSettingActivity a;

    bg(RunningSettingActivity runningSettingActivity) {
        this.a = runningSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.a.f.g(this.a.h());
            this.a.n.setThumbDrawable(this.a.a.getDrawable(h.switch_thumb_enable));
        } else {
            this.a.n.setThumbDrawable(this.a.a.getDrawable(h.switch_thumb_disable));
        }
        this.a.f.f(z);
        this.a.d();
    }
}
