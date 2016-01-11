package cn.com.smartdevices.bracelet.gps.services.b;

import android.content.Context;
import java.util.TimerTask;

class g extends TimerTask {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    g(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public void run() {
        this.b.a();
        this.b.a(this.a, 30000);
    }
}
