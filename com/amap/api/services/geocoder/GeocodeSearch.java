package com.amap.api.services.geocoder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.d;
import com.amap.api.services.core.e;
import com.amap.api.services.core.i;
import com.amap.api.services.core.u;
import java.util.List;

public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String GPS = "gps";
    Handler a = new b(this);
    private Context b;
    private OnGeocodeSearchListener c;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        d.a(context);
        this.b = context.getApplicationContext();
    }

    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) {
        return (RegeocodeAddress) new u(regeocodeQuery, e.a(this.b)).getData();
    }

    public void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        new Thread(new Runnable(this) {
            final /* synthetic */ GeocodeSearch b;

            public void run() {
                Message message = new Message();
                try {
                    message.what = ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE;
                    RegeocodeAddress fromLocation = this.b.getFromLocation(regeocodeQuery);
                    message.arg1 = 0;
                    message.obj = new RegeocodeResult(regeocodeQuery, fromLocation);
                } catch (AMapException e) {
                    message.arg1 = e.getErrorCode();
                } finally {
                    this.b.a.sendMessage(message);
                }
            }
        }).start();
    }

    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) {
        return (List) new i(geocodeQuery, e.a(this.b)).getData();
    }

    public void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        new Thread(new Runnable(this) {
            final /* synthetic */ GeocodeSearch b;

            public void run() {
                Message message = new Message();
                try {
                    message.what = 100;
                    List fromLocationName = this.b.getFromLocationName(geocodeQuery);
                    message.arg1 = 0;
                    message.obj = new GeocodeResult(geocodeQuery, fromLocationName);
                } catch (AMapException e) {
                    message.arg1 = e.getErrorCode();
                } finally {
                    this.b.a.sendMessage(message);
                }
            }
        }).start();
    }

    public void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        this.c = onGeocodeSearchListener;
    }
}
