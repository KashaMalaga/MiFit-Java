package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.h;

class C0708bj extends h {
    final /* synthetic */ InstructionActivity c;

    public C0708bj(InstructionActivity instructionActivity, FragmentManager fragmentManager) {
        this.c = instructionActivity;
        super(fragmentManager);
    }

    public Fragment a(int i) {
        return (Fragment) this.c.d.get(i);
    }

    public int b() {
        return this.c.d.size();
    }
}
