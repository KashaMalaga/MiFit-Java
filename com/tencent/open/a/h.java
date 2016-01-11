package com.tencent.open.a;

import android.text.format.Time;
import android.util.Log;
import com.a.a.a.C0908q;
import com.a.a.a.C0911t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public final class h {
    public static final h a = new h();

    public final String a(int i) {
        switch (i) {
            case l.a /*1*/:
                return C0911t.b;
            case a.k /*2*/:
                return "D";
            case a.aQ /*4*/:
                return "I";
            case a.ba /*8*/:
                return C0908q.b;
            case a.bp /*16*/:
                return C0908q.a;
            case a.bl /*32*/:
                return C0911t.a;
            default:
                return "-";
        }
    }

    public String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(i)).append('/').append(time.format("%Y-%m-%d %H:%M:%S")).append('.');
        if (j2 < 10) {
            stringBuilder.append("00");
        } else if (j2 < 100) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j2).append(' ').append('[');
        if (thread == null) {
            stringBuilder.append("N/A");
        } else {
            stringBuilder.append(thread.getName());
        }
        stringBuilder.append(']').append('[').append(str).append(']').append(' ').append(str2).append('\n');
        if (th != null) {
            stringBuilder.append("* Exception : \n").append(Log.getStackTraceString(th)).append('\n');
        }
        return stringBuilder.toString();
    }
}
