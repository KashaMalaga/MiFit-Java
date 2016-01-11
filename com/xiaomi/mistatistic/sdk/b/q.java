package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

class q extends HandlerThread {
    final /* synthetic */ m a;

    public q(m mVar, String str) {
        this.a = mVar;
        super(str);
    }

    protected void onLooperPrepared() {
        this.a.c = new Handler();
        ArrayList arrayList = null;
        synchronized (this.a.d) {
            if (!this.a.d.isEmpty()) {
                arrayList = (ArrayList) this.a.d.clone();
                this.a.d.clear();
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((p) it.next()).a();
            }
        }
        super.onLooperPrepared();
    }
}
