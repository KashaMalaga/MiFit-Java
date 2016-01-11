package cn.com.smartdevices.bracelet.lab.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.xiaomi.hm.health.bt.a.q;

class C0571g implements OnCheckedChangeListener {
    final /* synthetic */ LabFactoryConnectedAdvActivity a;

    C0571g(LabFactoryConnectedAdvActivity labFactoryConnectedAdvActivity) {
        this.a = labFactoryConnectedAdvActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        new q(new C0572h(this, z), z).g();
    }
}
