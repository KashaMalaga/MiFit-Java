package com.xiaomi.channel.b;

import android.app.Activity;
import android.content.Intent;

class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Activity b;
    final /* synthetic */ a c;

    j(a aVar, String str, Activity activity) {
        this.c = aVar;
        this.a = str;
        this.b = activity;
    }

    public void run() {
        Intent intent = new Intent("com.xiaomi.channel.VIEW_NOTIFICATION");
        intent.putExtra("notification_url", this.a);
        this.b.startActivity(intent);
    }
}
