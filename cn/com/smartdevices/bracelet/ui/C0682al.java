package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;

class C0682al extends Handler {
    final /* synthetic */ C0681ak a;

    C0682al(C0681ak c0681ak) {
        this.a = c0681ak;
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            this.a.J = this.a.I.n();
            this.a.K = this.a.I.m();
            this.a.L = this.a.I.k();
            this.a.M = this.a.I.l();
        } else if (message.what == 1) {
            this.a.a(this.a.K);
        }
        C0596r.e("Dynamic.Detail", "Today : " + this.a.J + " , StartDay : " + this.a.L + " , StopDay : " + this.a.M + " , CurrentDay : " + this.a.K);
        if (this.a.K.equals(this.a.M) && this.a.K.equals(this.a.L)) {
            this.a.F.setEnabled(false);
            this.a.G.setEnabled(false);
        } else if (this.a.K.equals(this.a.M)) {
            this.a.F.setEnabled(true);
            this.a.G.setEnabled(false);
        } else if (this.a.K.equals(this.a.L)) {
            this.a.F.setEnabled(false);
            this.a.G.setEnabled(true);
        } else {
            this.a.F.setEnabled(true);
            this.a.G.setEnabled(true);
        }
        this.a.B.m().b();
        this.a.B.b();
        this.a.B.b(0);
    }
}
