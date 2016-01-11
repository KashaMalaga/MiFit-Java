package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

class be extends bh {
    private static boolean a = true;

    protected be(Context context) {
        super(context);
    }

    protected String a() {
        return bg.b;
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
            } else if (a.b()) {
                a.b(false);
                arVar.a(a);
                return true;
            } else {
                return false;
            }
        }
    }

    protected int b() {
        return 1;
    }
}
