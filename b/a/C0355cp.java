package b.a;

import com.huami.android.widget.f;
import com.tencent.open.SocialConstants;

public class C0355cp extends C0339cy {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final C0371de j = new C0371de("TApplicationException");
    private static final cT k = new cT(f.a, C0374dh.i, (short) 1);
    private static final cT l = new cT(SocialConstants.PARAM_TYPE, (byte) 8, (short) 2);
    private static final long m = 1;
    protected int i = a;

    public C0355cp(int i) {
        this.i = i;
    }

    public C0355cp(int i, String str) {
        super(str);
        this.i = i;
    }

    public C0355cp(String str) {
        super(str);
    }

    public static C0355cp a(cY cYVar) {
        cYVar.j();
        String str = null;
        int i = a;
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                return new C0355cp(i, str);
            }
            switch (l.c) {
                case b /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    str = cYVar.z();
                    break;
                case c /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    i = cYVar.w();
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public int a() {
        return this.i;
    }

    public void b(cY cYVar) {
        cYVar.a(j);
        if (getMessage() != null) {
            cYVar.a(k);
            cYVar.a(getMessage());
            cYVar.c();
        }
        cYVar.a(l);
        cYVar.a(this.i);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
