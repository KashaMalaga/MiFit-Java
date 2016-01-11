package com.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class C0937v extends BroadcastReceiver {
    C0937v(at atVar) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction().equals("android.location.GPS_FIX_CHANGE")) {
                    at.b = false;
                }
            } catch (Exception e) {
            }
        }
    }
}
