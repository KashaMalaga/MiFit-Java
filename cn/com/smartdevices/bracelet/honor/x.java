package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class x implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ MedalManager b;

    x(MedalManager medalManager, Context context) {
        this.b = medalManager;
        this.a = context;
    }

    public void run() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Map hashMap = new HashMap();
        this.b.a(this.a, hashMap, arrayList, arrayList2);
        this.b.a(this.a, 3);
        if (arrayList != null) {
            arrayList.clear();
        }
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
