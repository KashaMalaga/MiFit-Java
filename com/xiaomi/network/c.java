package com.xiaomi.network;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.amap.api.services.district.DistrictSearchQuery;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mistatistic.sdk.d;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private long i;
    private ArrayList<q> j = new ArrayList();
    private String k;
    private double l = 0.1d;
    private String m = "s.mi1.cc";
    private long n = d.h;

    public c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.i = System.currentTimeMillis();
        this.j.add(new q(str, -1));
        this.a = f.a().b();
        this.b = str;
    }

    private synchronized void d(String str) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(((q) it.next()).a, str)) {
                it.remove();
            }
        }
    }

    public synchronized c a(JSONObject jSONObject) {
        this.a = jSONObject.optString("net");
        this.n = jSONObject.getLong("ttl");
        this.l = jSONObject.getDouble(ay.p);
        this.i = jSONObject.getLong(ay.H);
        this.d = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.b = jSONObject.optString(o.A);
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new q().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.b)) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = c().iterator();
            while (it.hasNext()) {
                arrayList.add(new URL(url.getProtocol(), (String) it.next(), url.getPort(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public void a(double d) {
        this.l = d;
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.n = j;
    }

    public synchronized void a(q qVar) {
        d(qVar.a);
        this.j.add(qVar);
    }

    public void a(String str, int i, long j, long j2, Exception exception) {
        a(str, new a(i, j, j2, exception));
    }

    public void a(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void a(String str, long j, long j2, Exception exception) {
        a(str, -1, j, j2, exception);
    }

    public synchronized void a(String str, a aVar) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (TextUtils.equals(str, qVar.a)) {
                qVar.a(aVar);
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            for (CharSequence equals : strArr) {
                if (TextUtils.equals(((q) this.j.get(size)).a, equals)) {
                    this.j.remove(size);
                    break;
                }
            }
        }
        Iterator it = this.j.iterator();
        int i = 0;
        while (it.hasNext()) {
            q qVar = (q) it.next();
            i = qVar.b > i ? qVar.b : i;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            a(new q(strArr[i2], (strArr.length + i) - i2));
        }
    }

    public boolean a() {
        return TextUtils.equals(this.a, f.a().b());
    }

    public boolean a(c cVar) {
        return TextUtils.equals(this.a, cVar.a);
    }

    public synchronized void b(String str) {
        a(new q(str));
    }

    public boolean b() {
        return System.currentTimeMillis() - this.i < this.n;
    }

    public synchronized ArrayList<String> c() {
        ArrayList<String> arrayList;
        q[] qVarArr = new q[this.j.size()];
        this.j.toArray(qVarArr);
        Arrays.sort(qVarArr);
        arrayList = new ArrayList();
        for (q qVar : qVarArr) {
            arrayList.add(qVar.a);
        }
        return arrayList;
    }

    public void c(String str) {
        this.m = str;
    }

    public synchronized String d() {
        String str;
        if (!TextUtils.isEmpty(this.k)) {
            str = this.k;
        } else if (TextUtils.isEmpty(this.e)) {
            str = "hardcode_isp";
        } else {
            this.k = f.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            str = this.k;
        }
        return str;
    }

    public ArrayList<q> e() {
        return this.j;
    }

    public double f() {
        return this.l < 1.0E-5d ? 0.1d : this.l;
    }

    public synchronized JSONObject g() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.a);
        jSONObject.put("ttl", this.n);
        jSONObject.put(ay.p, this.l);
        jSONObject.put(ay.H, this.i);
        jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put(o.A, this.b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            jSONArray.put(((q) it.next()).b());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("\n");
        stringBuilder.append(d());
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            stringBuilder.append("\n");
            stringBuilder.append(qVar.toString());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
