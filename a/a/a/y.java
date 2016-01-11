package a.a.a;

import android.content.Context;
import android.os.RemoteException;

public class y extends B {
    public y(Context context, String str, G g) {
        super(context, str, g);
    }

    public void a() {
        c(4);
    }

    public void a(A a) {
        if (a != null) {
            a(4, new z(this, a));
        }
    }

    public boolean a(byte[] bArr) {
        if (f()) {
            try {
                return this.C.a(this.B, this.F, bArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public byte[] b(byte[] bArr) {
        if (f()) {
            try {
                return this.C.b(this.B, this.F, bArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
