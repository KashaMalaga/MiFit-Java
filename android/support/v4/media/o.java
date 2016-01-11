package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

class o extends BroadcastReceiver {
    final /* synthetic */ l a;

    o(l lVar) {
        this.a = lVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            this.a.d.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        } catch (Throwable e) {
            Log.w("TransportController", e);
        }
    }
}
