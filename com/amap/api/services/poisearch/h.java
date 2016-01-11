package com.amap.api.services.poisearch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.channel.b.a;

class h extends Handler {
    final /* synthetic */ PoiSearch a;

    h(PoiSearch poiSearch) {
        this.a = poiSearch;
    }

    public void handleMessage(Message message) {
        if (this.a.e != null) {
            Bundle data;
            if (message.what == 100) {
                data = message.getData();
                if (data != null) {
                    this.a.e.onPoiSearched((PoiResult) message.obj, data.getInt(a.c));
                }
            } else if (message.what == ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE) {
                data = message.getData();
                if (data != null) {
                    this.a.e.onPoiItemDetailSearched((PoiItemDetail) message.obj, data.getInt(a.c));
                }
            }
        }
    }
}
