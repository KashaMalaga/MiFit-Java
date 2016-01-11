package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;

class C0799et implements OnCheckedChangeListener {
    final /* synthetic */ C0798es a;

    C0799et(C0798es c0798es) {
        this.a = c0798es;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.c.getMiliConfig().setWeightMergeResult(z);
        Keeper.keepPersonInfo(this.a.c);
        Utils.a(this.a.getActivity(), this.a.c);
    }
}
