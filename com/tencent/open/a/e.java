package com.tencent.open.a;

import android.util.Log;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public final class e extends i {
    public static final e a = new e();

    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        switch (i) {
            case l.a /*1*/:
                Log.v(str, str2, th);
                return;
            case a.k /*2*/:
                Log.d(str, str2, th);
                return;
            case a.aQ /*4*/:
                Log.i(str, str2, th);
                return;
            case a.ba /*8*/:
                Log.w(str, str2, th);
                return;
            case a.bp /*16*/:
                Log.e(str, str2, th);
                return;
            case a.bl /*32*/:
                Log.e(str, str2, th);
                return;
            default:
                return;
        }
    }
}
