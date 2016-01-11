package a.a.a;

import android.os.Message;
import android.os.ParcelUuid;
import android.util.Log;

class E extends l {
    final /* synthetic */ B b;

    E(B b) {
        this.b = b;
    }

    public void a(ParcelUuid parcelUuid, int i, byte[] bArr) {
        Log.d("MiBleProfile", "mPropertyCallback() property=" + i);
        if (this.b.F.equals(parcelUuid)) {
            Message obtainMessage = this.b.L.obtainMessage(2);
            obtainMessage.arg1 = i;
            obtainMessage.obj = bArr;
            this.b.L.sendMessage(obtainMessage);
        }
    }
}
