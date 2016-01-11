package cn.com.smartdevices.bracelet.gps.services.b;

import android.content.Context;
import android.location.Location;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationManagerProxy;
import java.util.TimerTask;

class e extends TimerTask {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    e(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public void run() {
        if (this.b.i) {
            this.b.b();
            new StringBuilder().append("locationBuffer_:");
            if (this.b.k != null) {
                this.b.k.setTime(System.currentTimeMillis());
                this.b.onLocationChanged((Location) new AMapLocation(this.b.k));
            }
        }
        this.b.k;
        this.b.a(this.a, 0, 0.0f, LocationManagerProxy.NETWORK_PROVIDER);
        this.b.a(this.a, 0, 0.0f, LocationManagerProxy.NETWORK_PROVIDER);
    }
}
