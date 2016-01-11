package com.c.b.b.a;

import com.c.b.s;
import com.xiaomi.mipush.sdk.f;
import java.util.Map;
import java.util.regex.Pattern;

public final class C1007i extends u {
    private static final Pattern a = Pattern.compile(f.i);

    public C1006h a(s sVar) {
        String[] strArr = null;
        String c = u.c(sVar);
        if (!c.startsWith("mailto:") && !c.startsWith("MAILTO:")) {
            return C1008j.a(c) ? new C1006h(c) : null;
        } else {
            String[] split;
            String str;
            String str2;
            String substring = c.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            CharSequence e = u.e(substring);
            String[] split2 = !e.isEmpty() ? a.split(e) : null;
            Map d = u.d(c);
            if (d != null) {
                String[] split3;
                if (split2 == null) {
                    substring = (String) d.get("to");
                    if (substring != null) {
                        split = a.split(substring);
                        substring = (String) d.get("cc");
                        split3 = substring == null ? a.split(substring) : null;
                        substring = (String) d.get("bcc");
                        if (substring != null) {
                            strArr = a.split(substring);
                        }
                        substring = (String) d.get("subject");
                        str = (String) d.get("body");
                        split2 = split;
                        split = strArr;
                        strArr = split3;
                        str2 = substring;
                    }
                }
                split = split2;
                substring = (String) d.get("cc");
                if (substring == null) {
                }
                substring = (String) d.get("bcc");
                if (substring != null) {
                    strArr = a.split(substring);
                }
                substring = (String) d.get("subject");
                str = (String) d.get("body");
                split2 = split;
                split = strArr;
                strArr = split3;
                str2 = substring;
            } else {
                str = null;
                str2 = null;
                split = null;
            }
            return new C1006h(split2, strArr, split, str2, str);
        }
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
