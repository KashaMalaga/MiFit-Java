package cn.com.smartdevices.bracelet.gps.ui;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.model.f;
import cn.com.smartdevices.bracelet.gps.services.ac;

class bA implements ac {
    final /* synthetic */ WatermarkFragment a;

    bA(WatermarkFragment watermarkFragment) {
        this.a = watermarkFragment;
    }

    public void a(f fVar) {
        if (fVar != null) {
            Object obj = fVar.a;
            Object obj2 = fVar.b;
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2)) {
                this.a.G = obj + "." + obj2;
                this.a.a(this.a.G);
            }
        }
    }
}
