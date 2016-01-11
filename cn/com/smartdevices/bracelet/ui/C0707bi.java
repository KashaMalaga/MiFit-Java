package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.support.v4.view.bz;
import java.util.Iterator;
import kankan.wheel.widget.a;

class C0707bi implements bz {
    final /* synthetic */ InstructionActivity a;

    C0707bi(InstructionActivity instructionActivity) {
        this.a = instructionActivity;
    }

    public void a(int i) {
        this.a.e = i;
    }

    public void a(int i, float f, int i2) {
        Iterator it = this.a.d.iterator();
        while (it.hasNext()) {
            ((C0709bk) ((Fragment) it.next())).a();
        }
    }

    public void b(int i) {
        switch (i) {
            case a.i /*0*/:
                ((C0709bk) this.a.d.get(this.a.e)).b();
                return;
            default:
                return;
        }
    }
}
