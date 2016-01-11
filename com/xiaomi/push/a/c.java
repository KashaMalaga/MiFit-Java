package com.xiaomi.push.a;

import android.util.Log;
import com.xiaomi.channel.a.a.a;
import com.xiaomi.channel.a.c.d;

class c extends d {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void b() {
        if (!b.f.isEmpty()) {
            try {
                if (a.d()) {
                    this.a.b();
                } else {
                    Log.w(this.a.d, "SDCard is unavailable.");
                }
            } catch (Throwable e) {
                Log.e(this.a.d, com.xiaomi.e.a.f, e);
            }
        }
    }
}
