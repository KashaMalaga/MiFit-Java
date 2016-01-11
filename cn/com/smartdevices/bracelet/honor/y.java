package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;

class y implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ MedalManager b;

    y(MedalManager medalManager, Context context) {
        this.b = medalManager;
        this.a = context;
    }

    public void run() {
        while (!this.b.r.isEmpty()) {
            String str = (String) this.b.r.poll();
            C0596r.e("MedalManager", "onSync medal data:" + str);
            D.a(this.a, str, false, new z(this, str));
        }
    }
}
