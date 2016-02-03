package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Intent;
import android.os.Binder;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.channel.relationservice.data.a;
import kankan.wheel.widget.l;

final class P extends Binder implements C0467k {
    final /* synthetic */ SyncSportDataService a;

    private P(SyncSportDataService syncSportDataService) {
        this.a = syncSportDataService;
    }

    private Intent b(DataSyncObject dataSyncObject) {
        if (dataSyncObject.b == null) {
            throw new IllegalArgumentException();
        }
        Intent intent = new Intent();
        switch (dataSyncObject.b.getInt(C0483q.i)) {
            case l.a /*1*/:
                intent.putExtra(a.h, 0);
                break;
            case kankan.wheel.widget.a.k /*2*/:
                intent.putExtra(a.h, 4);
                break;
            case kankan.wheel.widget.a.l /*3*/:
                intent.putExtra(a.h, 9);
                break;
        }
        intent.putExtra(SyncShoesDataService.a, dataSyncObject.b);
        intent.putExtra(SyncShoesDataService.d, dataSyncObject.a);
        return intent;
    }

    public void a(DataSyncObject dataSyncObject) {
        C0596r.e("Sync", "SyncBinder syncData");
        if (dataSyncObject == null || TextUtils.isEmpty(dataSyncObject.a) || dataSyncObject.b == null) {
            throw new IllegalArgumentException("Argument DataSyncObject.mID and bundle must be not null");
        }
        this.a.a(b(dataSyncObject), -1);
    }

    public void a(C0477j c0477j) {
        if (c0477j != null) {
            this.a.l.a(c0477j);
        }
    }

    public void b(C0477j c0477j) {
        if (c0477j != null) {
            this.a.l.b(c0477j);
        }
    }
}
