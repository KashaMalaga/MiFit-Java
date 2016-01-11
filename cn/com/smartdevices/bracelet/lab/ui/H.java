package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Message;
import cn.com.smartdevices.bracelet.lab.d;
import com.xiaomi.e.a;

final class H extends C0565b {
    public static final String a = "preparing";
    public static final String b = "group";
    final /* synthetic */ SportAnalyserActivity c;
    private String d = a.f;

    public H(SportAnalyserActivity sportAnalyserActivity, String str, long j, long j2) {
        this.c = sportAnalyserActivity;
        super(j, str);
        this.d = str;
    }

    public void b() {
        if (a.equals(this.d)) {
            this.c.n.setEnabled(false);
            this.c.g.a();
            this.c.c(2);
            this.c.G = true;
            this.c.d(true);
            this.c.finish();
        } else if (b.equals(this.d)) {
            Message obtainMessage = this.c.g.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = 1;
            this.c.g.sendMessage(obtainMessage);
            d.a(this.c).a(this.c, this.c.o);
        }
    }
}
