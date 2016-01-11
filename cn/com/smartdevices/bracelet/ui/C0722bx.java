package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.h;

class C0722bx extends h {
    final /* synthetic */ InstructionWeightActivity c;

    public C0722bx(InstructionWeightActivity instructionWeightActivity, FragmentManager fragmentManager) {
        this.c = instructionWeightActivity;
        super(fragmentManager);
    }

    public Fragment a(int i) {
        return (Fragment) this.c.r.get(i);
    }

    public int b() {
        return this.c.r.size();
    }
}
