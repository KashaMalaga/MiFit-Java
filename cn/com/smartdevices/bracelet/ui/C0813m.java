package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;

class C0813m implements OnCheckedChangeListener {
    final /* synthetic */ C0812l a;

    C0813m(C0812l c0812l) {
        this.a = c0812l;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.o = z;
        Keeper.setShowBabyWeight(this.a.o);
    }
}
