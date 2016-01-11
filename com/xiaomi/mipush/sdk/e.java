package com.xiaomi.mipush.sdk;

import android.content.Intent;

public class e {
    private PushMessageReceiver a;
    private Intent b;

    public e(Intent intent, PushMessageReceiver pushMessageReceiver) {
        this.a = pushMessageReceiver;
        this.b = intent;
    }

    public PushMessageReceiver a() {
        return this.a;
    }

    public Intent b() {
        return this.b;
    }
}
