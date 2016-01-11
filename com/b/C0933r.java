package com.b;

import android.location.GpsStatus.NmeaListener;

final class C0933r implements NmeaListener {
    private /* synthetic */ C0930o a;

    private C0933r(C0930o c0930o) {
        this.a = c0930o;
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            this.a.l = j;
            this.a.m = str;
        } catch (Exception e) {
        }
    }
}
