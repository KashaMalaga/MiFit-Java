package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.xiaomi.e.a;

class dD extends BroadcastReceiver {
    final /* synthetic */ SettingAboutActivity a;

    dD(SettingAboutActivity settingAboutActivity) {
        this.a = settingAboutActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C0596r.e(MiPushMessageReceiver.PUSH_TYPE_INTENT, a.f + intent.getLongExtra("extra_download_id", 0));
        Utils.b(this.a);
    }
}
