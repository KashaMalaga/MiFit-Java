package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import java.util.HashMap;

class C0769dr extends BroadcastReceiver {
    final /* synthetic */ SearchSingleBraceletActivity a;

    C0769dr(SearchSingleBraceletActivity searchSingleBraceletActivity) {
        this.a = searchSingleBraceletActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(BLEService.b)) {
            HwConnStatus hwConnStatus = (HwConnStatus) intent.getParcelableExtra(BLEService.j);
            if (hwConnStatus.i() || hwConnStatus.h()) {
                this.a.aa = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put(C0410c.o, this.a.x != null ? this.a.x.size() + a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                hashMap.put(C0410c.p, this.a.G != null ? this.a.G.signal + a.f : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                hashMap.put(C0410c.c, (this.a.aa - this.a.Z) + a.f);
                C0401a.a(this.a.A, C0409b.aa, hashMap);
                SearchSingleBraceletActivity.v.removeMessages(4101);
                SearchSingleBraceletActivity.v.sendEmptyMessage(4101);
            } else if (hwConnStatus.k()) {
                this.a.l();
            }
        } else if (action.equals(BLEService.g)) {
            int intExtra = intent.getIntExtra(BLEService.j, -1);
            if (intExtra == 6) {
                SearchSingleBraceletActivity.v.sendEmptyMessage(4103);
            } else if (intExtra == 9) {
                SearchSingleBraceletActivity.v.sendEmptyMessage(4104);
            }
        }
    }
}
