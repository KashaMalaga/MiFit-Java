package com.xiaomi.market.sdk;

import com.d.a.a.h;
import com.xiaomi.e.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;

public class m {
    final /* synthetic */ h a;
    private TreeMap b;

    public m(h hVar) {
        this(hVar, true);
    }

    public m(h hVar, boolean z) {
        this.a = hVar;
        this.b = new TreeMap();
        if (z) {
            hVar.d = this;
        }
    }

    public m a(String str, String str2) {
        Object obj;
        if (str2 == null) {
            obj = a.f;
        }
        this.b.put(str, obj);
        return this;
    }

    public m a(String str, boolean z) {
        if (z) {
            this.b.put(str, "true");
        } else {
            this.b.put(str, "false");
        }
        return this;
    }

    public String a(String str) {
        return (String) this.b.get(str);
    }

    public boolean a() {
        return this.b.isEmpty();
    }

    public TreeMap b() {
        return this.b;
    }

    public String toString() {
        if (this.b.isEmpty()) {
            return a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.b.keySet()) {
            stringBuilder.append(str);
            stringBuilder.append("=");
            try {
                stringBuilder.append(URLEncoder.encode((String) this.b.get(str), h.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
            }
            stringBuilder.append("&");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
