package b.a;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class C0320bl implements cq<C0320bl, C0325bq>, Serializable, Cloneable {
    public static final Map<C0325bq, cI> d;
    private static final C0371de e = new C0371de("Response");
    private static final cT f = new cT("resp_code", (byte) 8, (short) 1);
    private static final cT g = new cT(SocialConstants.PARAM_SEND_MSG, C0374dh.i, (short) 2);
    private static final cT h = new cT("imprint", C0374dh.j, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    public int a;
    public String b;
    public C0300as c;
    private byte k;
    private C0325bq[] l;

    static {
        i.put(dk.class, new C0322bn());
        i.put(dl.class, new C0324bp());
        Map enumMap = new EnumMap(C0325bq.class);
        enumMap.put(C0325bq.RESP_CODE, new cI("resp_code", (byte) 1, new cJ((byte) 8)));
        enumMap.put(C0325bq.MSG, new cI(SocialConstants.PARAM_SEND_MSG, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0325bq.IMPRINT, new cI("imprint", (byte) 2, new cN(C0374dh.j, C0300as.class)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0320bl.class, d);
    }

    public C0320bl() {
        this.k = (byte) 0;
        this.l = new C0325bq[]{C0325bq.MSG, C0325bq.IMPRINT};
    }

    public C0320bl(int i) {
        this();
        this.a = i;
        a(true);
    }

    public C0320bl(C0320bl c0320bl) {
        this.k = (byte) 0;
        this.l = new C0325bq[]{C0325bq.MSG, C0325bq.IMPRINT};
        this.k = c0320bl.k;
        this.a = c0320bl.a;
        if (c0320bl.i()) {
            this.b = c0320bl.b;
        }
        if (c0320bl.l()) {
            this.c = new C0300as(c0320bl.c);
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.k = (byte) 0;
            a(new C0337cQ(new C0376dm((InputStream) objectInputStream)));
        } catch (C0339cy e) {
            throw new IOException(e.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            b(new C0337cQ(new C0376dm((OutputStream) objectOutputStream)));
        } catch (C0339cy e) {
            throw new IOException(e.getMessage());
        }
    }

    public C0320bl a() {
        return new C0320bl(this);
    }

    public C0320bl a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public C0320bl a(C0300as c0300as) {
        this.c = c0300as;
        return this;
    }

    public C0320bl a(String str) {
        this.b = str;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.k = C0353cn.a(this.k, 0, z);
    }

    public /* synthetic */ cz b(int i) {
        return c(i);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public int c() {
        return this.a;
    }

    public C0325bq c(int i) {
        return C0325bq.a(i);
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void d() {
        this.k = C0353cn.b(this.k, 0);
    }

    public boolean e() {
        return C0353cn.a(this.k, 0);
    }

    public String f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.b = null;
    }

    public boolean i() {
        return this.b != null;
    }

    public C0300as j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public void m() {
        if (this.c != null) {
            this.c.n();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.a);
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
