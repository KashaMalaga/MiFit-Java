package cn.com.smartdevices.bracelet.gps.services.b;

import android.content.Context;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.TimerTask;

class f extends TimerTask {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    f(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public void run() {
        this.b.a(this.a, 0, 0.0f, GeocodeSearch.GPS);
    }
}
