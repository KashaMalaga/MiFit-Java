package b.a;

import android.content.Context;

public class du {
    private static C0368da a = null;
    private static ds b = null;

    public static synchronized C0368da a(Context context) {
        C0368da c0368da;
        synchronized (du.class) {
            if (a == null) {
                a = new C0368da(context);
                a.a(new dr(context));
                a.a(new dt(context));
                a.a(new C0313be(context));
                a.a(new dv(context));
                a.e();
            }
            c0368da = a;
        }
        return c0368da;
    }

    public static synchronized ds b(Context context) {
        ds dsVar;
        synchronized (du.class) {
            if (b == null) {
                b = new ds(context);
                b.b();
            }
            dsVar = b;
        }
        return dsVar;
    }
}
