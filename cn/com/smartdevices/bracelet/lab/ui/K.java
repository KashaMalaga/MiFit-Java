package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;

final class K extends Handler {
    public static final int a = 1;
    private static final int d = 1;
    private static final int e = 0;
    final /* synthetic */ SportAnalyserActivity b;
    private long c;

    private K(SportAnalyserActivity sportAnalyserActivity) {
        this.b = sportAnalyserActivity;
        this.c = 0;
    }

    private void a(long j) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = d;
        obtainMessage.obj = Long.valueOf(j);
        obtainMessage.arg1 = d;
        sendMessageDelayed(obtainMessage, 1000);
    }

    public void a() {
        removeMessages(d);
    }

    public void b() {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = d;
        obtainMessage.obj = Integer.valueOf(0);
        obtainMessage.arg1 = d;
        sendMessage(obtainMessage);
    }

    public void c() {
        removeMessages(d);
        Message obtainMessage = obtainMessage();
        obtainMessage.what = d;
        obtainMessage.obj = Integer.valueOf(0);
        obtainMessage.arg1 = 0;
        sendMessage(obtainMessage);
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case d /*1*/:
                this.b.l.setText(this.b.i.format(message.obj));
                if (message.arg1 == d) {
                    this.c += 1000;
                    a(this.c);
                    return;
                } else if (message.arg1 == 0) {
                    this.c = 0;
                    return;
                } else {
                    return;
                }
            case MainUIActivity.c /*520*/:
                this.b.c = -1;
                return;
            default:
                return;
        }
    }
}
