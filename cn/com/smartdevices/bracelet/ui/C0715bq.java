package cn.com.smartdevices.bracelet.ui;

import android.support.v4.view.bz;
import cn.com.smartdevices.bracelet.C0596r;

class C0715bq implements bz {
    final /* synthetic */ InstructionWeightActivity a;

    C0715bq(InstructionWeightActivity instructionWeightActivity) {
        this.a = instructionWeightActivity;
    }

    public void a(int i) {
        this.a.s = i;
        C0596r.e(InstructionWeightActivity.O, "selected  ---> position : " + i);
        this.a.d(i);
        this.a.b(i);
        this.a.a(i);
        this.a.c(i);
        this.a.Q = i;
        C0596r.e(InstructionWeightActivity.O, "selected  ---> lastPager : " + this.a.Q);
    }

    public void a(int i, float f, int i2) {
        this.a.a(i, Float.valueOf(f));
        this.a.a(i, f);
    }

    public void b(int i) {
        switch (i) {
        }
        C0596r.e(InstructionWeightActivity.O, " Scroll state :" + i);
    }
}
