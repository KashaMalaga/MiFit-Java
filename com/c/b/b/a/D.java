package com.c.b.b.a;

import com.c.b.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class D extends u {
    private static final Pattern a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean a(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        matcher = b.matcher(str);
        return matcher.find() && matcher.start() == 0;
    }

    public C a(s sVar) {
        String c = u.c(sVar);
        if (c.startsWith("URL:") || c.startsWith("URI:")) {
            return new C(c.substring(4).trim(), null);
        }
        c = c.trim();
        return a(c) ? new C(c, null) : null;
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
