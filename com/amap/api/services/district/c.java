package com.amap.api.services.district;

import android.os.Handler;
import android.os.Message;

class c extends Handler {
    final /* synthetic */ DistrictSearch a;

    c(DistrictSearch districtSearch) {
        this.a = districtSearch;
    }

    public void handleMessage(Message message) {
        if (this.a.d != null) {
            this.a.d.onDistrictSearched((DistrictResult) message.obj);
        }
    }
}
