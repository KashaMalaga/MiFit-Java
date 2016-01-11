package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;

class C0697b extends BroadcastReceiver {
    final /* synthetic */ AlarmActivity a;

    C0697b(AlarmActivity alarmActivity) {
        this.a = alarmActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C0596r.e("AlarmActivity", "Receive: " + intent.getAction());
        this.a.a();
    }
}
