package cn.com.smartdevices.bracelet.gps.sync;

import android.os.Bundle;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;

final class O implements N {
    final /* synthetic */ SyncSportDataService a;
    private String b = a.f;

    public O(SyncSportDataService syncSportDataService, String str) {
        this.a = syncSportDataService;
        this.b = str;
    }

    private DataSyncObject a(long j, boolean z, int i) {
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        dataSyncObject.b = bundle;
        dataSyncObject.a = this.b;
        if (j > 0) {
            bundle.putLong(C0483q.a, j);
        }
        if (i >= 0) {
            bundle.putInt(C0483q.n, i);
        }
        bundle.putBoolean(C0483q.g, z);
        return dataSyncObject;
    }

    public void a() {
        this.a.l.e(a(-1, true, 100));
    }

    public void a(long j, int i, boolean z) {
        this.a.l.g(a(j, z, i));
    }

    public void a(long j, long j2, boolean z) {
        this.a.l.a(Constants.VIA_RESULT_SUCCESS, j, j2, z, true);
    }

    public void a(boolean z) {
        this.a.l.d(a(-1, z, 100));
    }
}
