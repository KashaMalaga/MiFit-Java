package com.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

final class C0934s extends BroadcastReceiver {
    final /* synthetic */ C0930o a;

    private C0934s(C0930o c0930o) {
        this.a = c0930o;
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if (this.a.d != null && this.a.A != null && this.a.z != null && intent.getAction() != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    List scanResults = this.a.d.getScanResults();
                    synchronized (this) {
                        this.a.z.clear();
                        this.a.s = System.currentTimeMillis();
                        if (scanResults != null && scanResults.size() > 0) {
                            for (int i = 0; i < scanResults.size(); i++) {
                                this.a.z.add((ScanResult) scanResults.get(i));
                            }
                        }
                    }
                    TimerTask c0935t = new C0935t(this);
                    synchronized (this) {
                        if (this.a.A != null) {
                            this.a.A.cancel();
                            this.a.A = null;
                        }
                        this.a.A = new Timer();
                        this.a.A.schedule(c0935t, (long) C0930o.D);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
