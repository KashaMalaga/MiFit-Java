package com.c.b;

import java.util.EnumMap;
import java.util.Map;

public final class s {
    private final String a;
    private final byte[] b;
    private u[] c;
    private final a d;
    private Map<t, Object> e;
    private final long f;

    public s(String str, byte[] bArr, u[] uVarArr, a aVar) {
        this(str, bArr, uVarArr, aVar, System.currentTimeMillis());
    }

    public s(String str, byte[] bArr, u[] uVarArr, a aVar, long j) {
        this.a = str;
        this.b = bArr;
        this.c = uVarArr;
        this.d = aVar;
        this.e = null;
        this.f = j;
    }

    public String a() {
        return this.a;
    }

    public void a(t tVar, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(t.class);
        }
        this.e.put(tVar, obj);
    }

    public void a(Map<t, Object> map) {
        if (map == null) {
            return;
        }
        if (this.e == null) {
            this.e = map;
        } else {
            this.e.putAll(map);
        }
    }

    public void a(u[] uVarArr) {
        Object obj = this.c;
        if (obj == null) {
            this.c = uVarArr;
        } else if (uVarArr != null && uVarArr.length > 0) {
            Object obj2 = new u[(obj.length + uVarArr.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(uVarArr, 0, obj2, obj.length, uVarArr.length);
            this.c = obj2;
        }
    }

    public byte[] b() {
        return this.b;
    }

    public u[] c() {
        return this.c;
    }

    public a d() {
        return this.d;
    }

    public Map<t, Object> e() {
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public String toString() {
        return this.a;
    }
}
