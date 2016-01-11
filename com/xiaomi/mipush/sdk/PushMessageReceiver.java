package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class PushMessageReceiver extends BroadcastReceiver implements d {
    public final void onReceive(Context context, Intent intent) {
        MessageHandleService.a(new e(intent, this));
        try {
            context.startService(new Intent(context, MessageHandleService.class));
        } catch (Exception e) {
        }
    }
}
