package b.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class cB {
    private final ByteArrayOutputStream a;
    private final C0376dm b;
    private cY c;

    public cB() {
        this(new cR());
    }

    public cB(db dbVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new C0376dm(this.a);
        this.c = dbVar.a(this.b);
    }

    public String a(cq cqVar, String str) {
        try {
            return new String(a(cqVar), str);
        } catch (UnsupportedEncodingException e) {
            throw new C0339cy("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public byte[] a(cq cqVar) {
        this.a.reset();
        cqVar.b(this.c);
        return this.a.toByteArray();
    }

    public String b(cq cqVar) {
        return new String(a(cqVar));
    }
}
