package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class i extends Handler {
    final /* synthetic */ GifView a;

    i(GifView gifView) {
        this.a = gifView;
    }

    public void handleMessage(Message message) {
        try {
            this.a.m();
        } catch (Exception e) {
            Log.e("GifView", e.toString());
        }
    }
}
