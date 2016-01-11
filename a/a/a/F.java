package a.a.a;

import android.os.Handler.Callback;
import android.os.Message;

class F implements Callback {
    final /* synthetic */ B a;

    F(B b) {
        this.a = b;
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            if (this.a.E != null) {
                this.a.E.a(message.arg1);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i2 = message.arg1;
            C0000H c0000h = (C0000H) this.a.K.get(i2);
            if (c0000h != null) {
                c0000h.a(i2, (byte[]) message.obj);
            }
            return true;
        }
    }
}
