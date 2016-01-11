package com.xiaomi.c.a;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kankan.wheel.widget.a;

public final class C1079j extends C1078u {
    private static final Pattern a = Pattern.compile("<body(?:[\t\n\r ][^>]*?)?(/>|>)", 64);
    private final Map<C1076h, String> b;
    private final String c;
    private final AtomicReference<String> d;

    private C1079j(Map<C1076h, String> map, String str) {
        this.d = new AtomicReference();
        this.b = map;
        this.c = str;
    }

    public static C1081l a() {
        return new C1081l();
    }

    private String a(String str) {
        return str.replace("'", "&apos;");
    }

    private String g() {
        C1076h f = C1078u.f();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(f.b());
        for (Entry entry : this.b.entrySet()) {
            stringBuilder.append(" ");
            C1076h c1076h = (C1076h) entry.getKey();
            String c = c1076h.c();
            if (c != null && c.length() > 0) {
                stringBuilder.append(c);
                stringBuilder.append(a.ci);
            }
            stringBuilder.append(c1076h.b());
            stringBuilder.append("='");
            stringBuilder.append(a((String) entry.getValue()));
            stringBuilder.append("'");
        }
        stringBuilder.append(" ");
        stringBuilder.append("xmlns");
        stringBuilder.append("='");
        stringBuilder.append(f.a());
        stringBuilder.append("'>");
        if (this.c != null) {
            stringBuilder.append(this.c);
        }
        stringBuilder.append("</body>");
        return stringBuilder.toString();
    }

    public C1081l b() {
        return C1081l.b(this);
    }

    public Map<C1076h, String> c() {
        return Collections.unmodifiableMap(this.b);
    }

    public String d() {
        String str = (String) this.d.get();
        if (str != null) {
            return str;
        }
        str = g();
        this.d.set(str);
        return str;
    }

    public String e() {
        return this.c;
    }
}
