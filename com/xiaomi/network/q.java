package com.xiaomi.network;

import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kankan.wheel.widget.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class q implements Comparable<q> {
    public String a;
    protected int b;
    private final LinkedList<a> c;
    private long d;

    public q() {
        this(null, 0);
    }

    public q(String str) {
        this(str, 0);
    }

    public q(String str, int i) {
        this.c = new LinkedList();
        this.d = 0;
        this.a = str;
        this.b = i;
    }

    public int a(q qVar) {
        return qVar == null ? 1 : qVar.b - this.b;
    }

    public synchronized q a(JSONObject jSONObject) {
        this.d = jSONObject.getLong("tt");
        this.b = jSONObject.getInt("wt");
        this.a = jSONObject.getString(o.A);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.c.add(new a().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized ArrayList<a> a() {
        ArrayList<a> arrayList;
        arrayList = new ArrayList();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.c() > this.d) {
                arrayList.add(aVar);
            }
        }
        this.d = System.currentTimeMillis();
        return arrayList;
    }

    protected synchronized void a(a aVar) {
        if (aVar != null) {
            o.a().b();
            this.c.add(aVar);
            int a = aVar.a();
            if (a > 0) {
                this.b += aVar.a();
            } else {
                int i = 0;
                int size = this.c.size() - 1;
                while (size >= 0 && ((a) this.c.get(size)).a() < 0) {
                    i++;
                    size--;
                }
                this.b += a * i;
            }
            if (this.c.size() > 30) {
                this.b -= ((a) this.c.remove()).a();
            }
        }
    }

    public synchronized JSONObject b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.d);
        jSONObject.put("wt", this.b);
        jSONObject.put(o.A, this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).f());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((q) obj);
    }

    public String toString() {
        return this.a + a.ci + this.b;
    }
}
