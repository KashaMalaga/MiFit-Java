package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.h.f;
import java.lang.ref.WeakReference;

final class C0516bb extends Handler {
    static final int a = 1;
    static final int b = 2;
    private WeakReference<Context> c = null;

    public C0516bb(Context context) {
        this.c = new WeakReference(context);
    }

    public void a() {
        removeMessages(b);
        removeMessages(a);
    }

    public void handleMessage(Message message) {
        Context context = (Context) this.c.get();
        if (context != null) {
            switch (message.what) {
                case a /*1*/:
                    if (!f.a(context) || ((RunningMainActivity) context).o == null) {
                        sendEmptyMessageDelayed(a, 1000);
                        return;
                    }
                    ((RunningMainActivity) context).o.dismiss();
                    ((RunningMainActivity) context).o = null;
                    return;
                case b /*2*/:
                    ((RunningMainActivity) context).e(message.arg1);
                    return;
                default:
                    return;
            }
        }
    }
}
