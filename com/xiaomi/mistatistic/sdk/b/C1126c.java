package com.xiaomi.mistatistic.sdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.e.a;

class C1126c implements p {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ J c;

    C1126c(J j, Context context, String str) {
        this.c = j;
        this.a = context;
        this.b = str;
    }

    public void a() {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        long a = E.a(this.a.getApplicationContext(), "session_begin", 0);
        long a2 = E.a(this.a.getApplicationContext(), "last_deactivate", 0);
        String a3 = E.a(this.a.getApplicationContext(), "pv_path", a.f);
        if (a <= 0) {
            E.b(this.a.getApplicationContext(), "session_begin", currentTimeMillis);
        } else if (a2 <= 0) {
            E.b(this.a.getApplicationContext(), "session_begin", currentTimeMillis);
            if (!TextUtils.isEmpty(a3)) {
                this.c.b(this.a, a3);
                a3 = a.f;
            }
        }
        if (a2 > 0 && currentTimeMillis - a2 > J.c) {
            this.c.a(this.a, a, a2);
            if (TextUtils.isEmpty(a3)) {
                str = a3;
            } else {
                this.c.b(this.a, a3);
                str = a.f;
            }
            E.b(this.a.getApplicationContext(), "session_begin", currentTimeMillis);
            a3 = str;
        }
        str = TextUtils.isEmpty(this.b) ? this.a.getClass().getName() : this.b;
        CharSequence packageName = this.a.getPackageName();
        if (str.startsWith(packageName)) {
            str = str.replace(packageName, a.f);
        }
        if (!a3.endsWith(str)) {
            E.b(this.a.getApplicationContext(), "pv_path", this.c.a(a3, str));
        }
    }
}
