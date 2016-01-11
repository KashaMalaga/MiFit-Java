package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.config.b;

class dN implements OnCheckedChangeListener {
    final /* synthetic */ dM a;

    dN(dM dMVar) {
        this.a = dMVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Keeper.keepUserAgreement(z);
        C0596r.e(this.a.f, "UmengAnalyticsTracker  after set is ====== " + z);
        C0401a.a(z, b.x, this.a.e.k.b.booleanValue(), BraceletApp.a());
    }
}
