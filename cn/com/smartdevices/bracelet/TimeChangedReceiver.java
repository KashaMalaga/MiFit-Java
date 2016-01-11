package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.eventbus.EventTimeChanged;
import com.xiaomi.hm.health.bt.a.s;
import de.greenrobot.event.EventBus;
import java.util.Calendar;

public class TimeChangedReceiver extends BroadcastReceiver {
    private static String a = "TimeChangedReceiver";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            C0596r.d(a, "intent:" + intent);
            if (action.equals("android.intent.action.TIME_SET")) {
                C0596r.d(a, "ACTION_TIME_CHANGED");
            } else if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                C0596r.d(a, "ACTION_TIMEZONE_CHANGED");
            } else if (action.equals("android.intent.action.DATE_CHANGED")) {
                C0596r.d(a, "ACTION_DATE_CHANGED");
            }
            C0596r.d(a, "new date:" + Calendar.getInstance().getTime().toString());
            new s(new M(this)).g();
            EventBus.getDefault().post(new EventTimeChanged());
        }
    }
}
