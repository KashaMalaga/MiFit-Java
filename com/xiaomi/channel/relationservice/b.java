package com.xiaomi.channel.relationservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.relationservice.data.BuddyData;
import com.xiaomi.channel.relationservice.data.d;

class b extends BroadcastReceiver {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (a.b.equals(intent.getAction()) && this.a.i != null) {
            Object stringExtra = intent.getStringExtra(d.b);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(this.a.i.c)) {
                BuddyData buddyData = (BuddyData) intent.getParcelableExtra(d.a);
                if (buddyData != null) {
                    this.a.i.a(buddyData);
                }
            }
        }
    }
}
