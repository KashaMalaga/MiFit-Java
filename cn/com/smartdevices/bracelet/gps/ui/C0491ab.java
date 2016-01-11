package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.hm.health.b.a.n;

final class C0491ab extends Handler {
    static final int a = 2;
    static final int b = 1;
    static final int c = 1;
    static final int d = 0;
    static final int e = 3;
    final /* synthetic */ HistoryActivity f;

    private C0491ab(HistoryActivity historyActivity) {
        this.f = historyActivity;
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case c /*1*/:
                if (this.f.h != null) {
                    this.f.h.setVisibility(8);
                }
                if (this.f.j != null) {
                    this.f.j.setVisibility(d);
                    return;
                }
                return;
            case a /*2*/:
                int i = message.arg1;
                if (this.f.h != null) {
                    this.f.h.setVisibility(d);
                    if (i == c) {
                        this.f.i.setText(n.running_history_no_more_data);
                        this.f.h.setClickable(false);
                    } else {
                        this.f.h.setClickable(true);
                    }
                }
                if (this.f.j != null) {
                    this.f.j.setVisibility(8);
                    return;
                }
                return;
            case e /*3*/:
                this.f.i();
                return;
            default:
                return;
        }
    }
}
