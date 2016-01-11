package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import de.greenrobot.event.EventBus;

class C0790ek implements OnCheckedChangeListener {
    final /* synthetic */ C0784ee a;

    C0790ek(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.k.getMiliConfig().setDailySportNotify(z ? C0401a.fG : C0401a.fH);
        this.a.k.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a.k);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
    }
}
