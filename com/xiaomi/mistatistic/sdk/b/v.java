package com.xiaomi.mistatistic.sdk.b;

import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.c.a;

class v implements C1124a {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public a a(a aVar) {
        Object a = aVar.a();
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        aVar.b(a.split("\\?")[0]);
        return aVar;
    }
}
