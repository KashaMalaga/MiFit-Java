package a.a.a;

import android.content.Context;
import android.os.RemoteException;

public class C0001I extends B {
    public C0001I(Context context, String str, G g) {
        super(context, str, g);
    }

    public void a(C0002K c0002k) {
        if (c0002k != null) {
            a(1, new J(this, c0002k));
        }
    }

    public boolean a() {
        if (f()) {
            try {
                return this.C.d(this.B, this.F);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(String str) {
        if (f()) {
            try {
                return this.C.a(this.B, this.F, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean d(int i) {
        if (f()) {
            try {
                return this.C.b(this.B, this.F, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void h() {
        c(1);
    }
}
