package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Message;
import cn.com.smartdevices.bracelet.gps.sync.C0477j;
import cn.com.smartdevices.bracelet.gps.sync.DataSyncObject;

final class C0502am implements C0477j {
    final /* synthetic */ C0500ak a;

    private C0502am(C0500ak c0500ak) {
        this.a = c0500ak;
    }

    private void a(int i, DataSyncObject dataSyncObject) {
        Message obtainMessage = this.a.g.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = dataSyncObject;
        this.a.g.sendMessage(obtainMessage);
    }

    public void a(DataSyncObject dataSyncObject) {
        if (dataSyncObject == null) {
            throw new IllegalArgumentException();
        }
        a(5, dataSyncObject);
    }

    public void b(DataSyncObject dataSyncObject) {
        if (DataSyncObject.a(dataSyncObject)) {
            throw new IllegalArgumentException("Result is null or id, bundle is null");
        }
        a(1, dataSyncObject);
    }

    public void c(DataSyncObject dataSyncObject) {
        if (DataSyncObject.a(dataSyncObject)) {
            throw new IllegalArgumentException("Result is null or id, bundle is null");
        }
        a(0, dataSyncObject);
    }

    public void d(DataSyncObject dataSyncObject) {
        if (DataSyncObject.a(dataSyncObject)) {
            throw new IllegalArgumentException("Result is null or id, bundle is null");
        }
        a(3, dataSyncObject);
    }

    public void e(DataSyncObject dataSyncObject) {
        if (DataSyncObject.a(dataSyncObject)) {
            throw new IllegalArgumentException("Result is null or id, bundle is null");
        }
        a(2, dataSyncObject);
    }

    public void f(DataSyncObject dataSyncObject) {
        if (DataSyncObject.a(dataSyncObject)) {
            throw new IllegalArgumentException("Result is null or bundle is null");
        }
        a(4, dataSyncObject);
    }
}
