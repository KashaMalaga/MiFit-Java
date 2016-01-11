package com.xiaomi.mistatistic.sdk.c;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.mistatistic.sdk.b.C;
import com.xiaomi.mistatistic.sdk.b.C1125b;
import org.json.JSONObject;

public class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private long d;
    private long e;
    private int f;
    private String g;
    private String h;
    private long i;
    private String j;
    private long k;
    private String l;
    private String m;
    private String n;
    private int o;

    public a(String str, long j) {
        this(str, j, -1, null);
    }

    public a(String str, long j, int i, String str2) {
        this(str, j, 0, i, str2);
    }

    public a(String str, long j, long j2) {
        this(str, j, j2, -1, null);
    }

    public a(String str, long j, long j2, int i) {
        this(str, j, j2, i, null);
    }

    public a(String str, long j, long j2, int i, String str2) {
        this.i = System.currentTimeMillis();
        this.k = 0;
        this.o = a;
        this.j = str;
        this.d = j;
        this.f = i;
        this.g = str2;
        this.k = j2;
        c();
    }

    public a(String str, long j, String str2) {
        this(str, j, -1, str2);
    }

    public a(String str, String str2) {
        this(str, -1, -1, str2);
    }

    public String a() {
        return this.j;
    }

    public void a(int i) {
        this.o = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.h = str;
    }

    public long b() {
        return this.e;
    }

    public void b(String str) {
        this.j = str;
    }

    public void c() {
        if (C1125b.a() == null) {
            this.h = "NULL";
            return;
        }
        String b = C.b(C1125b.a());
        if (TextUtils.isEmpty(b)) {
            this.h = "NULL";
            return;
        }
        this.h = b;
        if (!"WIFI".equalsIgnoreCase(b)) {
            this.l = ((TelephonyManager) C1125b.a().getSystemService("phone")).getSimOperator();
        }
    }

    public void c(String str) {
        this.m = str;
    }

    public int d() {
        return this.o;
    }

    public void d(String str) {
        this.n = str;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("net", this.h);
        if (this.d > 0) {
            jSONObject.put("cost", this.d);
        }
        if (this.e > 0) {
            jSONObject.put("first_byte_t", this.e);
        }
        if (this.f != -1) {
            jSONObject.put(b.a, this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("exception", this.g);
        }
        if (!TextUtils.isEmpty(this.l)) {
            jSONObject.put("op", this.l);
        }
        if (this.k > 0) {
            jSONObject.put("flow", this.k);
        }
        if (this.o == b || this.o == c) {
            jSONObject.put("flow_status", this.o);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("rid", this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("dns", this.n);
        }
        jSONObject.put(C0454m.c, this.i);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.j, aVar.j) && TextUtils.equals(this.h, aVar.h) && TextUtils.equals(this.g, aVar.g) && TextUtils.equals(this.n, aVar.n) && this.f == aVar.f && this.d == aVar.d && this.i == aVar.i && this.k == aVar.k && this.o == aVar.o && TextUtils.equals(this.m, aVar.m) && this.e == aVar.e;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.n;
    }
}
