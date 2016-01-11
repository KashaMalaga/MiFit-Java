package com.g.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.bW;
import b.a.bX;
import com.g.a.c.a;
import com.g.a.c.n;
import com.g.a.c.u;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class f {
    private static final String a = "input map is null";
    private static final s b = new s();

    public static s a() {
        return b;
    }

    public static void a(long j) {
        C1059a.n = j;
    }

    public static void a(Context context) {
        b.c(context);
    }

    public static void a(Context context, String str) {
        b.a(context, str);
    }

    public static void a(Context context, String str, int i) {
        b.a(context, str, null, -1, i);
    }

    public static void a(Context context, String str, long j) {
        if (j <= 0) {
            bX.a(p.e, "duration is not valid in onEventDuration");
        } else {
            b.a(context, str, null, j, 1);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            bX.b(p.e, "unexpected null context in onResume");
        } else if (str == null || str.length() == 0) {
            bX.b(p.e, "unexpected empty appkey in onResume");
        } else {
            C1059a.a(str);
            C1059a.b(str2);
            b.b(context);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            bX.a(p.e, "label is null or empty");
        } else {
            b.a(context, str, str2, -1, i);
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        if (TextUtils.isEmpty(str2)) {
            bX.a(p.e, "label is null or empty");
        } else if (j <= 0) {
            bX.a(p.e, "duration is not valid in onEventDuration");
        } else {
            b.a(context, str, str2, j, 1);
        }
    }

    public static void a(Context context, String str, String str2, C1060b c1060b, int i) {
        if (TextUtils.isEmpty(str)) {
            bX.c(p.e, "userID is null or empty");
            str = null;
        }
        if (TextUtils.isEmpty(str2)) {
            bX.a(p.e, "id source is null or empty");
            str2 = null;
        }
        if (i <= 0 || i >= v.C) {
            bX.a(p.e, "not a valid age!");
            i = -1;
        }
        B.a(context).a(str, str2, i, c1060b.d);
    }

    public static void a(Context context, String str, Map<String, String> map) {
        if (map == null) {
            bX.b(p.e, a);
            return;
        }
        b.a(context, str, new HashMap(map), -1);
    }

    public static void a(Context context, String str, Map<String, String> map, int i) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i));
        b.a(context, str, hashMap, -1);
    }

    public static void a(Context context, String str, Map<String, String> map, long j) {
        if (j <= 0) {
            bX.a(p.e, "duration is not valid in onEventDuration");
        } else if (map == null) {
            bX.b(p.e, a);
        } else {
            b.a(context, str, new HashMap(map), j);
        }
    }

    public static void a(Context context, String str, Map<String, String> map, String str2) {
        if (map == null) {
            bX.b(p.e, a);
        } else {
            b.a(context, str, new HashMap(map), str2);
        }
    }

    public static void a(Context context, String str, a... aVarArr) {
        if (context == null) {
            bX.b(p.e, "context is null in onShareEvent");
            return;
        }
        u.e = Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP;
        n.a(context, str, aVarArr);
    }

    public static void a(Context context, Throwable th) {
        b.a(context, th);
    }

    public static void a(Context context, a... aVarArr) {
        if (context == null) {
            bX.b(p.e, "context is null in onShareEvent");
            return;
        }
        u.e = Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP;
        n.a(context, aVarArr);
    }

    public static void a(com.g.a.b.a aVar) {
        b.a(aVar);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            bX.b(p.e, "pageName is null or empty");
        } else {
            b.a(str);
        }
    }

    public static void a(String str, String str2) {
        b.a(str, str2);
    }

    public static void a(GL10 gl10) {
        if (gl10 != null) {
            String[] a = bW.a(gl10);
            if (a.length == 2) {
                C1059a.d = a[0];
                C1059a.e = a[1];
            }
        }
    }

    public static void a(boolean z) {
    }

    public static void b(Context context) {
        if (context == null) {
            bX.b(p.e, "unexpected null context in onResume");
        } else {
            b.b(context);
        }
    }

    public static void b(Context context, String str) {
        b.a(context, str, null, -1, 1);
    }

    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bX.a(p.e, "label is null or empty");
        } else {
            b.a(context, str, str2, -1, 1);
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            bX.b(p.e, "pageName is null or empty");
        } else {
            b.b(str);
        }
    }

    public static void b(boolean z) {
        C1059a.m = z;
    }

    public static void c(Context context) {
        b.d(context);
    }

    public static void c(Context context, String str) {
        b.a(context, str, null);
    }

    public static void c(Context context, String str, String str2) {
        b.a(context, str, str2);
    }

    public static void c(boolean z) {
        C1059a.l = z;
    }

    public static void d(Context context) {
        b.a(context);
    }

    public static void d(Context context, String str) {
        b.b(context, str, null);
    }

    public static void d(Context context, String str, String str2) {
        b.b(context, str, str2);
    }

    public static void d(boolean z) {
        C1059a.j = z;
    }

    public static String e(Context context, String str) {
        return B.a(context).g().getString(str, com.xiaomi.e.a.f);
    }

    public static void e(Context context) {
        b.e(context);
    }

    public static void e(Context context, String str, String str2) {
        b.c(context, str, str2);
    }

    public static void e(boolean z) {
        bX.a = z;
        u.v = z;
    }

    public static void f(Context context, String str, String str2) {
        if (str == null || str.length() == 0) {
            bX.b(p.e, "unexpected empty appkey in onResume");
            return;
        }
        C1059a.a(str);
        C1059a.b(str2);
        b.a(context);
    }
}
