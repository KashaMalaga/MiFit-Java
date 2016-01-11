package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.gps.sync.DataSyncObject;
import com.huami.android.widget.f;
import java.lang.ref.WeakReference;

final class C0503an extends Handler {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = 4;
    static final int f = 5;
    private WeakReference<C0500ak> g = null;

    public C0503an(C0500ak c0500ak) {
        this.g = new WeakReference(c0500ak);
    }

    public void a() {
        removeCallbacksAndMessages(null);
    }

    public void dispatchMessage(Message message) {
        C0500ak c0500ak = (C0500ak) this.g.get();
        if (c0500ak != null) {
            DataSyncObject dataSyncObject;
            switch (message.what) {
                case a /*0*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        dataSyncObject = (DataSyncObject) message.obj;
                        if (c0500ak.b != null) {
                            c0500ak.b.a(dataSyncObject.b.getInt(C0483q.n));
                            return;
                        }
                        return;
                    }
                    return;
                case b /*1*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        dataSyncObject = (DataSyncObject) message.obj;
                        if (c0500ak.b != null) {
                            c0500ak.b.a(dataSyncObject.b.getBoolean(C0483q.g), dataSyncObject.b.getInt(f.a));
                            return;
                        }
                        return;
                    }
                    return;
                case c /*2*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        c0500ak.b((DataSyncObject) message.obj);
                        return;
                    }
                    return;
                case d /*3*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        c0500ak.a((DataSyncObject) message.obj);
                        return;
                    }
                    return;
                case e /*4*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        dataSyncObject = (DataSyncObject) message.obj;
                        if (c0500ak.b != null) {
                            c0500ak.b.a(dataSyncObject.b.getLong(C0483q.a), dataSyncObject.b.getInt(C0483q.n), dataSyncObject.b.getBoolean(C0483q.g));
                            return;
                        }
                        return;
                    }
                    return;
                case f /*5*/:
                    if (message.obj != null && (message.obj instanceof DataSyncObject)) {
                        dataSyncObject = (DataSyncObject) message.obj;
                        if (c0500ak.b != null) {
                            c0500ak.b.a(dataSyncObject.b.getBoolean(C0483q.g));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
