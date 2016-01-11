package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class j implements k {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final String e = "messageId";
    private static final String f = "messageType";
    private static final String g = "content";
    private static final String h = "alias";
    private static final String i = "topic";
    private static final String j = "user_account";
    private static final String k = "passThrough";
    private static final String l = "notifyType";
    private static final String m = "notifyId";
    private static final String n = "isNotified";
    private static final String o = "description";
    private static final String p = "title";
    private static final String q = "category";
    private static final String r = "extra";
    private static final long serialVersionUID = 1;
    private int A;
    private boolean B;
    private String C;
    private String D;
    private String E;
    private HashMap<String, String> F = new HashMap();
    private String s;
    private int t;
    private String u;
    private String v;
    private String w;
    private String x;
    private int y;
    private int z;

    public static j a(Bundle bundle) {
        j jVar = new j();
        jVar.s = bundle.getString(e);
        jVar.t = bundle.getInt(f);
        jVar.y = bundle.getInt(k);
        jVar.v = bundle.getString(h);
        jVar.x = bundle.getString(j);
        jVar.w = bundle.getString(i);
        jVar.u = bundle.getString(g);
        jVar.C = bundle.getString(o);
        jVar.D = bundle.getString(p);
        jVar.B = bundle.getBoolean(n);
        jVar.A = bundle.getInt(m);
        jVar.z = bundle.getInt(l);
        jVar.E = bundle.getString(q);
        jVar.F = (HashMap) bundle.getSerializable(r);
        return jVar;
    }

    public String a() {
        return this.s;
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(String str) {
        this.s = str;
    }

    public void a(Map<String, String> map) {
        this.F.clear();
        if (map != null) {
            this.F.putAll(map);
        }
    }

    public void a(boolean z) {
        this.B = z;
    }

    public int b() {
        return this.t;
    }

    public void b(int i) {
        this.z = i;
    }

    public void b(String str) {
        this.u = str;
    }

    public String c() {
        return this.u;
    }

    public void c(int i) {
        this.A = i;
    }

    public void c(String str) {
        this.v = str;
    }

    public String d() {
        return this.v;
    }

    public void d(int i) {
        this.y = i;
    }

    public void d(String str) {
        this.x = str;
    }

    public String e() {
        return this.x;
    }

    public void e(String str) {
        this.w = str;
    }

    public String f() {
        return this.w;
    }

    public void f(String str) {
        this.C = str;
    }

    public int g() {
        return this.z;
    }

    public void g(String str) {
        this.D = str;
    }

    public int h() {
        return this.A;
    }

    public void h(String str) {
        this.E = str;
    }

    public boolean i() {
        return this.B;
    }

    public String j() {
        return this.C;
    }

    public String k() {
        return this.D;
    }

    public String l() {
        return this.E;
    }

    public int m() {
        return this.y;
    }

    public Map<String, String> n() {
        return this.F;
    }

    public Bundle o() {
        Bundle bundle = new Bundle();
        bundle.putString(e, this.s);
        bundle.putInt(k, this.y);
        bundle.putInt(f, this.t);
        if (!TextUtils.isEmpty(this.v)) {
            bundle.putString(h, this.v);
        }
        if (!TextUtils.isEmpty(this.x)) {
            bundle.putString(j, this.x);
        }
        if (!TextUtils.isEmpty(this.w)) {
            bundle.putString(i, this.w);
        }
        bundle.putString(g, this.u);
        if (!TextUtils.isEmpty(this.C)) {
            bundle.putString(o, this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            bundle.putString(p, this.D);
        }
        bundle.putBoolean(n, this.B);
        bundle.putInt(m, this.A);
        bundle.putInt(l, this.z);
        if (!TextUtils.isEmpty(this.E)) {
            bundle.putString(q, this.E);
        }
        if (this.F != null) {
            bundle.putSerializable(r, this.F);
        }
        return bundle;
    }

    public String toString() {
        return "messageId={" + this.s + "},passThrough={" + this.y + "},alias={" + this.v + "},topic={" + this.w + "},userAccount={" + this.x + "},content={" + this.u + "},description={" + this.C + "},title={" + this.D + "},isNotified={" + this.B + "},notifyId={" + this.A + "},notifyType={" + this.z + "}, category={" + this.E + "}, extra={" + this.F + "}";
    }
}
