package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;

class C0792em implements OnCheckedChangeListener {
    final /* synthetic */ C0784ee a;

    C0792em(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.Z.c(z, new C0793en(this));
        Keeper.keepEnableRtHeartrate(z);
    }
}
