package com.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mistatistic.sdk.d;
import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0919d extends BroadcastReceiver {
    final /* synthetic */ C0916a a;

    private C0919d(C0916a c0916a) {
        this.a = c0916a;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (this.a.h != null) {
                        this.a.k = this.a.h.getScanResults();
                        this.a.z = ao.a();
                        if (this.a.k == null) {
                            this.a.k = new ArrayList();
                        }
                    }
                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    if (this.a.h != null) {
                        int i = 4;
                        try {
                            i = this.a.h.getWifiState();
                        } catch (SecurityException e) {
                        }
                        switch (i) {
                            case a.i /*0*/:
                                this.a.o();
                                return;
                            case l.a /*1*/:
                                this.a.o();
                                return;
                            case a.aQ /*4*/:
                                this.a.o();
                                return;
                            default:
                                return;
                        }
                        th.printStackTrace();
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    this.a.g();
                    this.a.p();
                    Q.i = 10000;
                    Q.j = 30000;
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    if (this.a.B >= 5) {
                        Q.i = 20000;
                        Q.j = d.g;
                    }
                } else if (action.equals("android.intent.action.AIRPLANE_MODE")) {
                    this.a.w = ao.a(context);
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    this.a.a(true, 2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
