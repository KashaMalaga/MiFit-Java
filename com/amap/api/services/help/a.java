package com.amap.api.services.help;

import android.os.Handler;
import android.os.Message;
import java.util.List;

class a extends Handler {
    final /* synthetic */ Inputtips a;

    a(Inputtips inputtips) {
        this.a = inputtips;
    }

    public void handleMessage(Message message) {
        if (this.a.c != null) {
            List list = null;
            if (message.what == 0) {
                list = (List) message.obj;
            }
            this.a.c.onGetInputtips(list, message.what);
        }
    }
}
