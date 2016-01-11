package cn.com.smartdevices.bracelet.weight.a;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.i.a.f;
import cn.com.smartdevices.bracelet.i.c;

class h extends f {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void then(c cVar) {
        if (cVar.h()) {
            this.a.success();
            C0596r.e(this.a.tag(), "Keep Weights Sync To Local State : Successed!!");
            Keeper.keepScaleSyncedWeightInfosFromServer(true);
        }
    }
}
