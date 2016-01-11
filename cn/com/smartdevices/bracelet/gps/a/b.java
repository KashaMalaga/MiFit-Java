package cn.com.smartdevices.bracelet.gps.a;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.gps.h.f;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.util.HashMap;

public class b {
    private b() {
    }

    public static void a(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.y);
    }

    public static void a(Context context, int i) {
        C0401a.a(context.getApplicationContext(), C0409b.p, C0410c.g, i > 10 ? "10+" : a.f + i);
    }

    public static void a(Context context, long j) {
        C0401a.a(context.getApplicationContext(), C0409b.s, C0410c.c, a.f + j);
    }

    public static void a(Context context, long j, long j2) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            boolean a = f.a(applicationContext);
            HashMap hashMap = new HashMap(3);
            hashMap.put(C0410c.a, a ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
            hashMap.put(C0410c.d, String.valueOf(j));
            hashMap.put(C0410c.e, String.valueOf(j2));
            C0401a.a(applicationContext, C0409b.f, hashMap);
        }
    }

    public static void a(Context context, boolean z) {
        C0401a.a(context.getApplicationContext(), C0409b.A, C0410c.b, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
    }

    public static void a(Context context, boolean z, long j) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(C0410c.f, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
            hashMap.put(C0410c.c, a.f + j);
            C0401a.a(context.getApplicationContext(), C0409b.m, hashMap);
        }
    }

    public static void b(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.e);
        }
    }

    public static void b(Context context, boolean z) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.d, C0410c.b, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public static void c(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.r);
    }

    public static void c(Context context, boolean z) {
        C0401a.a(context.getApplicationContext(), C0409b.B, C0410c.b, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
    }

    public static void d(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.t);
    }

    public static void d(Context context, boolean z) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.l, C0410c.b, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public static void e(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.j);
        }
    }

    public static void e(Context context, boolean z) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.b, C0410c.b, z ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public static void f(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.w);
    }

    public static void g(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.E);
    }

    public static void h(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.u);
    }

    public static void i(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.x);
    }

    public static void j(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            C0401a.a(applicationContext, C0409b.c, C0410c.a, f.a(applicationContext) ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public static void k(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.k);
        }
    }

    public static void l(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.q);
    }

    public static void m(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.z);
    }

    public static void n(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.i);
        }
    }

    public static void o(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.h);
        }
    }

    public static void p(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.D);
    }

    public static void q(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.C);
    }

    public static void r(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.F);
    }

    public static void s(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.v);
    }

    public static void t(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            C0401a.a(applicationContext, C0409b.a, C0410c.a, f.a(applicationContext) ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public static void u(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.o);
    }

    public static void v(Context context) {
        C0401a.a(context.getApplicationContext(), C0409b.n);
    }
}
