package com.xiaomi.mistatistic.sdk.b;

import android.content.Context;
import android.text.TextUtils;
import kankan.wheel.widget.a;

class s implements p {
    private Context a;

    public s(Context context) {
        this.a = context;
    }

    public void a() {
        String a = E.a(this.a, a.ak, com.xiaomi.e.a.f);
        if (TextUtils.isEmpty(a)) {
            r.a = r.a(this.a);
            E.b(this.a, a.ak, r.a);
            return;
        }
        r.a = a;
    }
}
