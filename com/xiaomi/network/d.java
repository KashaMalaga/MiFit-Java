package com.xiaomi.network;

import android.text.TextUtils;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private String a;
    private final ArrayList<c> b = new ArrayList();

    public d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized c a() {
        c cVar;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            cVar = (c) this.b.get(size);
            if (!cVar.b()) {
                this.b.remove(size);
            } else if (cVar.a()) {
                f.a().b(cVar.d());
                break;
            }
        }
        cVar = null;
        return cVar;
    }

    public synchronized d a(JSONObject jSONObject) {
        this.a = jSONObject.getString(o.A);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.b.add(new c(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized void a(c cVar) {
        int i = 0;
        while (i < this.b.size()) {
            if (((c) this.b.get(i)).a(cVar)) {
                this.b.set(i, cVar);
                break;
            }
            i++;
        }
        if (i >= this.b.size()) {
            this.b.add(cVar);
        }
    }

    public ArrayList<c> b() {
        return this.b;
    }

    public synchronized void c() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            if (!((c) this.b.get(size)).b()) {
                this.b.remove(size);
            }
        }
    }

    public String d() {
        return this.a;
    }

    public synchronized JSONObject e() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(o.A, this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(((c) it.next()).g());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("\n");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuilder.append((c) it.next());
        }
        return stringBuilder.toString();
    }
}
