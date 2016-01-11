package com.amap.api.services.geocoder;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.model.ShareData;

class b extends Handler {
    final /* synthetic */ GeocodeSearch a;

    b(GeocodeSearch geocodeSearch) {
        this.a = geocodeSearch;
    }

    public void handleMessage(Message message) {
        GeocodeResult geocodeResult = null;
        if (this.a.c != null) {
            if (message.what == ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE) {
                RegeocodeResult regeocodeResult;
                if (message.arg2 == 0) {
                    regeocodeResult = (RegeocodeResult) message.obj;
                }
                this.a.c.onRegeocodeSearched(regeocodeResult, message.arg1);
                return;
            }
            if (message.arg2 == 0) {
                geocodeResult = (GeocodeResult) message.obj;
            }
            this.a.c.onGeocodeSearched(geocodeResult, message.arg1);
        }
    }
}
