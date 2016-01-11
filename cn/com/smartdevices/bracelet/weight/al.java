package cn.com.smartdevices.bracelet.weight;

import android.content.Context;
import cn.com.smartdevices.bracelet.eventbus.weight.EventWeightSyncedServer;
import de.greenrobot.event.EventBus;

class al implements aE {
    final /* synthetic */ Context a;
    final /* synthetic */ ah b;

    al(ah ahVar, Context context) {
        this.b = ahVar;
        this.a = context;
    }

    public void a() {
        EventBus.getDefault().post(new EventWeightSyncedServer(true));
        this.b.b(this.a);
    }

    public void b() {
    }
}
