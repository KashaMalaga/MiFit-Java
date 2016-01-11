package com.b;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class C0932q extends PhoneStateListener {
    private /* synthetic */ C0930o a;

    private C0932q(C0930o c0930o) {
        this.a = c0930o;
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        try {
            this.a.t = System.currentTimeMillis();
            this.a.x = cellLocation;
            super.onCellLocationChanged(cellLocation);
        } catch (Exception e) {
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        try {
            if (serviceState.getState() == 0) {
                this.a.k = true;
                String[] a = C0930o.b(this.a.b);
                this.a.o = Integer.parseInt(a[0]);
                this.a.p = Integer.parseInt(a[1]);
            } else {
                this.a.k = false;
            }
            super.onServiceStateChanged(serviceState);
        } catch (Exception e) {
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        try {
            if (this.a.i) {
                this.a.j = signalStrength.getCdmaDbm();
            } else {
                this.a.j = signalStrength.getGsmSignalStrength();
                if (this.a.j == 99) {
                    this.a.j = -1;
                } else {
                    this.a.j = (this.a.j * 2) - 113;
                }
            }
            super.onSignalStrengthsChanged(signalStrength);
        } catch (Exception e) {
        }
    }
}
