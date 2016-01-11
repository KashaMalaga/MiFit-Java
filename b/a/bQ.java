package b.a;

import com.xiaomi.market.sdk.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class bQ implements cq<bQ, bV>, Serializable, Cloneable {
    public static final Map<bV, cI> j;
    private static final C0371de k = new C0371de("UMEnvelope");
    private static final cT l = new cT(o.x, C0374dh.i, (short) 1);
    private static final cT m = new cT("address", C0374dh.i, (short) 2);
    private static final cT n = new cT(o.g, C0374dh.i, (short) 3);
    private static final cT o = new cT("serial_num", (byte) 8, (short) 4);
    private static final cT p = new cT("ts_secs", (byte) 8, (short) 5);
    private static final cT q = new cT("length", (byte) 8, (short) 6);
    private static final cT r = new cT("entity", C0374dh.i, (short) 7);
    private static final cT s = new cT("guid", C0374dh.i, (short) 8);
    private static final cT t = new cT("checksum", C0374dh.i, (short) 9);
    private static final Map<Class<? extends di>, dj> u = new HashMap();
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    private byte y;

    static {
        u.put(dk.class, new bS());
        u.put(dl.class, new bU());
        Map enumMap = new EnumMap(bV.class);
        enumMap.put(bV.VERSION, new cI(o.x, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(bV.ADDRESS, new cI("address", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(bV.SIGNATURE, new cI(o.g, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(bV.SERIAL_NUM, new cI("serial_num", (byte) 1, new cJ((byte) 8)));
        enumMap.put(bV.TS_SECS, new cI("ts_secs", (byte) 1, new cJ((byte) 8)));
        enumMap.put(bV.LENGTH, new cI("length", (byte) 1, new cJ((byte) 8)));
        enumMap.put(bV.ENTITY, new cI("entity", (byte) 1, new cJ((byte) C0374dh.i, true)));
        enumMap.put(bV.GUID, new cI("guid", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(bV.CHECKSUM, new cI("checksum", (byte) 1, new cJ(C0374dh.i)));
        j = Collections.unmodifiableMap(enumMap);
        cI.a(bQ.class, j);
    }

    public bQ() {
        this.y = (byte) 0;
    }

    public bQ(bQ bQVar) {
        this.y = (byte) 0;
        this.y = bQVar.y;
        if (bQVar.e()) {
            this.a = bQVar.a;
        }
        if (bQVar.i()) {
            this.b = bQVar.b;
        }
        if (bQVar.l()) {
            this.c = bQVar.c;
        }
        this.d = bQVar.d;
        this.e = bQVar.e;
        this.f = bQVar.f;
        if (bQVar.y()) {
            this.g = C0357cs.d(bQVar.g);
        }
        if (bQVar.B()) {
            this.h = bQVar.h;
        }
        if (bQVar.E()) {
            this.i = bQVar.i;
        }
    }

    public bQ(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.y = (byte) 0;
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

    public void A() {
        this.h = null;
    }

    public boolean B() {
        return this.h != null;
    }

    public String C() {
        return this.i;
    }

    public void D() {
        this.i = null;
    }

    public boolean E() {
        return this.i != null;
    }

    public void F() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'version' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new C0340cZ("Required field 'address' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new C0340cZ("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new C0340cZ("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new C0340cZ("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i == null) {
            throw new C0340cZ("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public bQ a() {
        return new bQ(this);
    }

    public bQ a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public bQ a(String str) {
        this.a = str;
        return this;
    }

    public bQ a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public bQ a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(cY cYVar) {
        ((dj) u.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public bQ b(String str) {
        this.b = str;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return e(i);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = v;
        e(false);
        this.e = v;
        f(false);
        this.f = v;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public void b(cY cYVar) {
        ((dj) u.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public bQ c(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public bQ c(String str) {
        this.c = str;
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public bQ d(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public bQ d(String str) {
        this.h = str;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        this.y = C0353cn.a(this.y, (int) v, z);
    }

    public bQ e(String str) {
        this.i = str;
        return this;
    }

    public bV e(int i) {
        return bV.a(i);
    }

    public void e(boolean z) {
        this.y = C0353cn.a(this.y, (int) w, z);
    }

    public boolean e() {
        return this.a != null;
    }

    public String f() {
        return this.b;
    }

    public void f(boolean z) {
        this.y = C0353cn.a(this.y, (int) x, z);
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public void h() {
        this.b = null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
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

    public int m() {
        return this.d;
    }

    public void n() {
        this.y = C0353cn.b(this.y, (int) v);
    }

    public boolean o() {
        return C0353cn.a(this.y, (int) v);
    }

    public int p() {
        return this.e;
    }

    public void q() {
        this.y = C0353cn.b(this.y, (int) w);
    }

    public boolean r() {
        return C0353cn.a(this.y, (int) w);
    }

    public int s() {
        return this.f;
    }

    public void t() {
        this.y = C0353cn.b(this.y, (int) x);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMEnvelope(");
        stringBuilder.append("version:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("address:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("signature:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("serial_num:");
        stringBuilder.append(this.d);
        stringBuilder.append(", ");
        stringBuilder.append("ts_secs:");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append("length:");
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append("entity:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            C0357cs.a(this.g, stringBuilder);
        }
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.h);
        }
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.i == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.i);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean u() {
        return C0353cn.a(this.y, (int) x);
    }

    public byte[] v() {
        a(C0357cs.c(this.g));
        return this.g == null ? null : this.g.array();
    }

    public ByteBuffer w() {
        return this.g;
    }

    public void x() {
        this.g = null;
    }

    public boolean y() {
        return this.g != null;
    }

    public String z() {
        return this.h;
    }
}
