package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.account.openauth.h;

final class av extends BroadcastReceiver {
    final /* synthetic */ SubGPSSportService a;

    private av(SubGPSSportService subGPSSportService) {
        this.a = subGPSSportService;
    }

    public IntentFilter a() {
        return new IntentFilter("android.intent.action.PHONE_STATE");
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "android.intent.action.PHONE_STATE".equals(action)) {
                int intExtra = intent.getIntExtra(h.N, 0);
                SubGPSSportService subGPSSportService = this.a;
                if (1 == intExtra || 2 == intExtra) {
                    z = true;
                }
                subGPSSportService.o = z;
                if (this.a.p != null) {
                    this.a.p.a(this.a.o);
                }
            }
        }
    }
}
