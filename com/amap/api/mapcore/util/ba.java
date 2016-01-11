package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

class ba extends bh {
    private static boolean a = true;

    protected ba(Context context) {
        super(context);
    }

    protected String a() {
        return bg.d;
    }

    protected boolean a(Context context) {
        if (z.g(context) != 1 || !a) {
            return false;
        }
        a = false;
        synchronized (Looper.getMainLooper()) {
            ar arVar = new ar(context);
            at a = arVar.a();
            if (a == null) {
                return true;
            } else if (a.c()) {
                a.c(false);
                arVar.a(a);
                return true;
            } else {
                return false;
            }
        }
    }

    protected int b() {
        return 2;
    }
}
