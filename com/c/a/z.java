package com.c.a;

import com.c.a.b.w;
import java.util.Map.Entry;
import java.util.Set;

public final class z extends w {
    private final w<String, w> a = new w();

    private w a(Object obj) {
        return obj == null ? y.a : new C(obj);
    }

    public w a(String str) {
        return (w) this.a.remove(str);
    }

    z a() {
        z zVar = new z();
        for (Entry entry : this.a.entrySet()) {
            zVar.a((String) entry.getKey(), ((w) entry.getValue()).o());
        }
        return zVar;
    }

    public void a(String str, w wVar) {
        Object obj;
        if (wVar == null) {
            obj = y.a;
        }
        this.a.put(str, obj);
    }

    public void a(String str, Boolean bool) {
        a(str, a((Object) bool));
    }

    public void a(String str, Character ch) {
        a(str, a((Object) ch));
    }

    public void a(String str, Number number) {
        a(str, a((Object) number));
    }

    public void a(String str, String str2) {
        a(str, a((Object) str2));
    }

    public Set<Entry<String, w>> b() {
        return this.a.entrySet();
    }

    public boolean b(String str) {
        return this.a.containsKey(str);
    }

    public w c(String str) {
        return (w) this.a.get(str);
    }

    public C d(String str) {
        return (C) this.a.get(str);
    }

    public t e(String str) {
        return (t) this.a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof z) && ((z) obj).a.equals(this.a));
    }

    public z f(String str) {
        return (z) this.a.get(str);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* synthetic */ w o() {
        return a();
    }
}
