package com.xiaomi.mistatistic.sdk.c;

import com.xiaomi.mistatistic.sdk.b.A;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends b {
    protected long b;
    private String c;
    private String d;
    private Map e;

    public e(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public e(String str, String str2, long j, Map map) {
        this.c = str;
        this.d = str2;
        this.b = j;
        if (map == null) {
            this.e = null;
        } else {
            this.e = new HashMap(map);
        }
    }

    private String a(Map map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    return jSONObject.toString();
                }
            } catch (Throwable e) {
                new A().a("json error", e);
            }
        }
        return null;
    }

    public i a() {
        i iVar = new i();
        iVar.a = this.c;
        iVar.c = this.d;
        iVar.b = this.a;
        iVar.d = b();
        iVar.e = String.valueOf(this.b);
        iVar.f = a(this.e);
        return iVar;
    }

    public String b() {
        return "numeric";
    }
}
