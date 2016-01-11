package cn.com.smartdevices.bracelet.shoes.sync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.shoes.model.c;
import java.util.concurrent.ConcurrentHashMap;

final class C0636m extends Handler {
    public static final int a = 1;
    public static final int b = 2;
    private static final int d = 1;
    final /* synthetic */ C0635l c;

    public C0636m(C0635l c0635l) {
        this.c = c0635l;
        super(Looper.getMainLooper());
    }

    public Message a(c cVar, boolean z) {
        Message obtainMessage;
        if (z) {
            obtainMessage = obtainMessage(b);
            obtainMessage.arg1 = d;
        } else {
            removeMessages(d);
            obtainMessage = obtainMessage(d);
        }
        obtainMessage.obj = cVar;
        return obtainMessage;
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case d /*1*/:
                if (message.obj != null && (message.obj instanceof c)) {
                    c cVar = (c) message.obj;
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.c.i.get(cVar.b());
                    if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                        this.c.a(cVar);
                        return;
                    }
                    return;
                }
                return;
            case b /*2*/:
                if (message.obj != null && (message.obj instanceof c)) {
                    this.c.a((c) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
