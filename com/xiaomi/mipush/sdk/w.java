package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.a.d.a;
import com.xiaomi.push.service.ae;

class w extends ContentObserver {
    final /* synthetic */ u a;

    w(u uVar, Handler handler) {
        this.a = uVar;
        super(handler);
    }

    public void onChange(boolean z) {
        this.a.g = Integer.valueOf(ae.a(this.a.c).b());
        if (this.a.g.intValue() != 0) {
            this.a.c.getContentResolver().unregisterContentObserver(this);
            if (a.d(this.a.c)) {
                this.a.c();
            }
        }
    }
}
