package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class HomeKeyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C0596r.d("HomeKeyReceiver", "onReceive intent : " + intent);
        try {
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra != null && stringExtra.equals("homekey")) {
                    Keeper.setEnterAppTrace(3);
                    Keeper.setActiveHistory(3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
