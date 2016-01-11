package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.v;
import android.telephony.TelephonyManager;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.bt.a.C1115b;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class PhoneStateReceiver extends BroadcastReceiver {
    private static final String a = "PhoneState";
    private static Timer b = null;
    private static TimerTask c = null;
    private static C1115b d = null;

    private static void a(Context context, int i) {
        C0596r.d(a, "in startTimerTask");
        WeakReference weakReference = new WeakReference(context);
        b = new Timer();
        c = new E(weakReference);
        b.schedule(c, (long) i);
    }

    private static void b() {
        C0596r.d(a, "in stopTimerTask");
        if (b != null) {
            C0596r.d(a, "cancel timer...");
            b.cancel();
            b.purge();
            b = null;
        }
        if (c != null) {
            C0596r.d(a, "canel task...");
            c.cancel();
            c = null;
        }
        if (d != null) {
            new C1115b((byte) 0, null).g();
            d = null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        C0596r.d(a, "onReceive......");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent intent2 = new Intent("android.intent.action.PHONE_STATE");
        intent2.putExtra(h.N, telephonyManager.getCallState());
        v.a(context).a(intent2);
        if (B.a().f()) {
            C0596r.d(a, "Incoming call by Miui , app not handle !");
            return;
        }
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        if (readPersonInfo.isInComingCallEnabled()) {
            switch (telephonyManager.getCallState()) {
                case a.i /*0*/:
                    C0596r.d(a, "incoming IDLE");
                    C0401a.a(context, C0401a.eI);
                    b();
                    return;
                case l.a /*1*/:
                    C0596r.d(a, "RINGING :" + intent.getStringExtra("incoming_number"));
                    C0401a.a(context, C0401a.eG);
                    a(context, readPersonInfo.getInComingCallTime() * h.E);
                    return;
                case a.k /*2*/:
                    C0596r.d(a, "incoming ACCEPT :" + intent.getStringExtra("incoming_number"));
                    C0401a.a(context, C0401a.eH);
                    b();
                    return;
                default:
                    return;
            }
        }
        C0596r.d(a, "Incoming call notify is disabled!!!");
    }
}
