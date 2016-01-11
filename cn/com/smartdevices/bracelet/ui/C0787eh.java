package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import de.greenrobot.event.EventBus;

class C0787eh implements OnCheckedChangeListener {
    final /* synthetic */ C0784ee a;

    C0787eh(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.k.setMiliVibrate(z);
        this.a.k.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.a.k);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
    }
}
