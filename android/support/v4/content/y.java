package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.view.a.C0113o;

class y {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    y(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.a = intentFilter;
        this.b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
