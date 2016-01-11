package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class C0540w extends Handler {
    private WeakReference<C0530l> a = null;

    public C0540w(C0530l c0530l) {
        this.a = new WeakReference(c0530l);
    }

    public void handleMessage(Message message) {
        C0530l c0530l = (C0530l) this.a.get();
        if (c0530l != null) {
            switch (message.what) {
                case l.a /*1*/:
                    c0530l.a();
                    return;
                case a.k /*2*/:
                    c0530l.f();
                    c0530l.h.start();
                    return;
                case a.l /*3*/:
                    c0530l.i.start();
                    return;
                default:
                    return;
            }
        }
    }
}
