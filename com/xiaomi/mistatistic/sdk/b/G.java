package com.xiaomi.mistatistic.sdk.b;

import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.b.a.c;

class G implements c {
    final /* synthetic */ F a;

    G(F f) {
        this.a = f;
    }

    public void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            F.b = false;
            return;
        }
        this.a.a = j;
        this.a.a(str);
    }
}
