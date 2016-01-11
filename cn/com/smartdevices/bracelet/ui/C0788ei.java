package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;

class C0788ei implements OnCheckedChangeListener {
    final /* synthetic */ C0784ee a;

    C0788ei(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C0401a.a(this.a.getActivity(), z ? C0401a.hb : C0401a.hc);
        this.a.Z.a(z, new C0789ej(this));
        this.a.k.setMiliSleepAssist(z);
        this.a.k.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a.k);
    }
}
