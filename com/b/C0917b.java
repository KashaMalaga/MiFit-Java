package com.b;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0917b extends PhoneStateListener {
    final /* synthetic */ C0916a a;

    C0917b(C0916a c0916a) {
        this.a = c0916a;
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
        if (cellLocation != null) {
            try {
                if (!this.a.q()) {
                    this.a.H = cellLocation;
                    this.a.y = ao.a();
                    this.a.x = ao.a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onServiceStateChanged(ServiceState serviceState) {
        try {
            switch (serviceState.getState()) {
                case l.a /*1*/:
                    this.a.j.clear();
                    this.a.p = -113;
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSignalStrengthChanged(int i) {
        int i2 = -113;
        try {
            switch (this.a.f) {
                case l.a /*1*/:
                    i2 = ao.a(i);
                    break;
                case a.k /*2*/:
                    i2 = ao.a(i);
                    break;
            }
            this.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        int i = -113;
        try {
            switch (this.a.f) {
                case l.a /*1*/:
                    i = ao.a(signalStrength.getGsmSignalStrength());
                    break;
                case a.k /*2*/:
                    i = signalStrength.getCdmaDbm();
                    break;
            }
            this.a.b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
