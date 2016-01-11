package b.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class C0362d extends M implements dF {
    public C0362d() {
        a(System.currentTimeMillis());
        a(S.LEGIT);
    }

    public C0362d(String str) {
        this();
        a(str);
    }

    public C0362d(Throwable th) {
        this();
        a(a(th));
    }

    private String a(Throwable th) {
        String str = null;
        if (th != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                str = stringWriter.toString();
                printWriter.close();
                stringWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public C0362d a(boolean z) {
        a(z ? S.LEGIT : S.ALIEN);
        return this;
    }

    public void a(bE bEVar, String str) {
        if (bEVar.s() > 0) {
            for (aE aEVar : bEVar.u()) {
                if (str.equals(aEVar.c())) {
                    break;
                }
            }
        }
        aE aEVar2 = null;
        if (aEVar2 == null) {
            aEVar2 = new aE();
            aEVar2.a(str);
            bEVar.a(aEVar2);
        }
        aEVar2.a((M) this);
    }
}
