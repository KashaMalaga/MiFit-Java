package b.a;

import com.xiaomi.e.a;

public class cT {
    public final String a;
    public final byte b;
    public final short c;

    public cT() {
        this(a.f, (byte) 0, (short) 0);
    }

    public cT(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public boolean a(cT cTVar) {
        return this.b == cTVar.b && this.c == cTVar.c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
    }
}
