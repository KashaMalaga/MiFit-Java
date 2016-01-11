package cn.com.smartdevices.bracelet.gps.sync;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.List;

class L {
    private List<C0477j> a;

    public L() {
        this.a = null;
        this.a = new ArrayList();
    }

    private void a(C0474g c0474g) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NewList: ");
        for (Long longValue : c0474g.a) {
            stringBuilder.append(longValue.longValue()).append(f.i);
        }
        stringBuilder.append("\nDeletedList: ");
        for (Long longValue2 : c0474g.b) {
            stringBuilder.append(longValue2.longValue()).append(f.i);
        }
        C0596r.e("Sync", "COMMAND_TWO_SYNC_DIFF_DATA_IN_RANGE diff = " + stringBuilder.toString());
    }

    DataSyncObject a(String str) {
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        bundle.putString(SyncShoesDataService.d, str);
        bundle.putBoolean(C0483q.g, false);
        bundle.putInt(com.huami.android.widget.f.a, 3);
        dataSyncObject.b = bundle;
        dataSyncObject.a = str;
        return dataSyncObject;
    }

    DataSyncObject a(String str, boolean z, long j, boolean z2) {
        DataSyncObject dataSyncObject = new DataSyncObject();
        Bundle bundle = new Bundle();
        dataSyncObject.b = bundle;
        dataSyncObject.a = str;
        bundle.putBoolean(C0483q.g, z);
        bundle.putLong(C0483q.b, j);
        if (z) {
            bundle.putInt(com.huami.android.widget.f.a, z2 ? 1 : 0);
        } else {
            bundle.putInt(com.huami.android.widget.f.a, 2);
        }
        return dataSyncObject;
    }

    public void a() {
        if (this.a != null) {
            this.a.clear();
        }
    }

    void a(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j d : this.a) {
                d.d(dataSyncObject);
            }
        }
    }

    void a(C0477j c0477j) {
        if (this.a != null && !this.a.contains(c0477j)) {
            this.a.add(c0477j);
        }
    }

    void a(String str, long j, long j2, boolean z, boolean z2) {
        DataSyncObject a = a(str, z, -2, z2);
        a.b.putLong(C0483q.e, j);
        a.b.putLong(C0483q.f, j2);
        a(a);
        C0596r.e("Sync", "COMMAND_TWO_SYNC_DIFF_DATA_IN_RANGE syncSummaryFromServerBatch isSucceeded = " + z);
    }

    void a(String str, C0482p c0482p, long j, long j2) {
        boolean z = c0482p.a;
        boolean z2 = c0482p.c != null && c0482p.c.size() > 0;
        DataSyncObject a = a(str, z, c0482p.d, z2);
        a.b.putLong(C0483q.e, j);
        a.b.putLong(C0483q.f, j2);
        f(a);
    }

    void b(DataSyncObject dataSyncObject) {
        if (this.a != null) {
        }
    }

    void b(C0477j c0477j) {
        if (c0477j != null && this.a != null && this.a.contains(c0477j)) {
            this.a.remove(c0477j);
        }
    }

    void c(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j a : this.a) {
                a.a(dataSyncObject);
            }
        }
    }

    void d(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j b : this.a) {
                b.b(dataSyncObject);
            }
        }
    }

    void e(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j c : this.a) {
                c.c(dataSyncObject);
            }
        }
    }

    void f(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j e : this.a) {
                e.e(dataSyncObject);
            }
        }
    }

    void g(DataSyncObject dataSyncObject) {
        if (this.a != null) {
            for (C0477j f : this.a) {
                f.f(dataSyncObject);
            }
        }
    }
}
