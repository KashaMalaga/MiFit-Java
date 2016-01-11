package a.a.a;

import android.os.ParcelUuid;
import android.util.Log;

class D extends i {
    final /* synthetic */ B b;

    D(B b) {
        this.b = b;
    }

    public void a(ParcelUuid parcelUuid, int i) {
        Log.d("MiBleProfile", "onConnectionState() sate=" + i);
        if (this.b.F.equals(parcelUuid)) {
            this.b.M = i;
            this.b.L.sendMessage(this.b.L.obtainMessage(1, i, 0));
        }
    }
}
