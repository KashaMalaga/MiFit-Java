package b.a;

import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.xiaomi.market.sdk.o;
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

public class bK implements cq<bK, bP>, Serializable, Cloneable {
    public static final Map<bP, cI> e;
    private static final C0371de f = new C0371de(QQLogin.KEY_USER_INFO);
    private static final cT g = new cT(f.B, (byte) 8, (short) 1);
    private static final cT h = new cT(f.am, (byte) 8, (short) 2);
    private static final cT i = new cT(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final cT j = new cT(o.L, C0374dh.i, (short) 4);
    private static final Map<Class<? extends di>, dj> k = new HashMap();
    private static final int l = 0;
    public Z a;
    public int b;
    public String c;
    public String d;
    private byte m;
    private bP[] n;

    static {
        k.put(dk.class, new bM());
        k.put(dl.class, new bO());
        Map enumMap = new EnumMap(bP.class);
        enumMap.put(bP.GENDER, new cI(f.B, (byte) 2, new cH(C0374dh.n, Z.class)));
        enumMap.put(bP.AGE, new cI(f.am, (byte) 2, new cJ((byte) 8)));
        enumMap.put(bP.ID, new cI(SyncShoesDataService.d, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(bP.SOURCE, new cI(o.L, (byte) 2, new cJ(C0374dh.i)));
        e = Collections.unmodifiableMap(enumMap);
        cI.a(bK.class, e);
    }

    public bK() {
        this.m = (byte) 0;
        this.n = new bP[]{bP.GENDER, bP.AGE, bP.ID, bP.SOURCE};
    }

    public bK(bK bKVar) {
        this.m = (byte) 0;
        this.n = new bP[]{bP.GENDER, bP.AGE, bP.ID, bP.SOURCE};
        this.m = bKVar.m;
        if (bKVar.e()) {
            this.a = bKVar.a;
        }
        this.b = bKVar.b;
        if (bKVar.l()) {
            this.c = bKVar.c;
        }
        if (bKVar.o()) {
            this.d = bKVar.d;
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.m = (byte) 0;
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

    public bK a() {
        return new bK(this);
    }

    public bK a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public bK a(Z z) {
        this.a = z;
        return this;
    }

    public bK a(String str) {
        this.c = str;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public bK b(String str) {
        this.d = str;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return c(i);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
        this.d = null;
    }

    public void b(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.m = C0353cn.a(this.m, 0, z);
    }

    public Z c() {
        return this.a;
    }

    public bP c(int i) {
        return bP.a(i);
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.m = C0353cn.b(this.m, 0);
    }

    public boolean i() {
        return C0353cn.a(this.m, 0);
    }

    public String j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public String m() {
        return this.d;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public void p() {
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("UserInfo(");
        Object obj2 = 1;
        if (e()) {
            stringBuilder.append("gender:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj2 = null;
        }
        if (i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("age:");
            stringBuilder.append(this.b);
            obj2 = null;
        }
        if (l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("id:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        } else {
            obj = obj2;
        }
        if (o()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("source:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
