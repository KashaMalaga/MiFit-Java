package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import de.greenrobot.event.EventBus;

class C0791el implements OnCheckedChangeListener {
    final /* synthetic */ C0784ee a;

    C0791el(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.k.getMiliConfig().setDailySleepNotify(z);
        this.a.k.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a.k);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
    }
}
