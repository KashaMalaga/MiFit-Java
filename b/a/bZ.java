package b.a;

import com.xiaomi.e.a;

public class bZ extends cf {
    private static final String a = bZ.class.getName();

    public C0347ce a(C0344cc c0344cc) {
        C0346cd c0346cd = (C0346cd) a((C0343cg) c0344cc, C0346cd.class);
        return c0346cd == null ? C0347ce.FAIL : c0346cd.a;
    }

    public void a(C0344cc c0344cc, C0341ca c0341ca) {
        try {
            new C0342cb(this, c0344cc, c0341ca).execute(new Integer[0]);
        } catch (Exception e) {
            bX.b(a, a.f, e);
            if (c0341ca != null) {
                c0341ca.a(C0347ce.FAIL);
            }
        }
    }
}
