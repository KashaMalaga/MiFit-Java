package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

class bc extends bh {
    private static boolean a = true;

    protected bc(Context context) {
        super(context);
    }

    protected String a() {
        return bg.c;
    }

    protected boolean a(Context context) {
        if (!a) {
            return false;
        }
        a = false;
        synchronized (Looper.getMainLooper()) {
            ar arVar = new ar(context);
            at a = arVar.a();
            if (a == null) {
                return true;
            } else if (a.a()) {
                a.a(false);
                arVar.a(a);
                return true;
            } else {
                return false;
            }
        }
    }

    protected int b() {
        return 0;
    }
}
