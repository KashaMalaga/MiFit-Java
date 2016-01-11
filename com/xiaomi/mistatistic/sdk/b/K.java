package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.e.a;

class K extends Handler {
    final /* synthetic */ J a;

    K(J j, Looper looper) {
        this.a = j;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 31415927:
                long a = E.a(C1125b.a(), "session_begin", 0);
                long a2 = E.a(C1125b.a(), "last_deactivate", 0);
                String a3 = E.a(C1125b.a(), "pv_path", a.f);
                if (a > 0 && a2 > a) {
                    this.a.a(C1125b.a(), a, a2);
                }
                if (!TextUtils.isEmpty(a3)) {
                    this.a.b(C1125b.a(), a3);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
