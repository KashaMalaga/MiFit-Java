package com.c.b.b.a;

import com.c.b.s;
import java.util.List;

public final class G extends u {
    private static String a(CharSequence charSequence, String str, boolean z) {
        List b = F.b(charSequence, str, z, false);
        return (b == null || b.isEmpty()) ? null : (String) b.get(0);
    }

    private static String a(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List a = F.a(charSequence, str, z, false);
        if (a == null || a.isEmpty()) {
            return null;
        }
        int size = a.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) ((List) a.get(i)).get(0);
        }
        return strArr;
    }

    public C1005g a(s sVar) {
        String c = u.c(sVar);
        if (c.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String a = a("SUMMARY", c, true);
        String a2 = a("DTSTART", c, true);
        if (a2 == null) {
            return null;
        }
        double d;
        double d2;
        String a3 = a("DTEND", c, true);
        String a4 = a("DURATION", c, true);
        String a5 = a("LOCATION", c, true);
        String a6 = a(a("ORGANIZER", c, true));
        String[] b = b("ATTENDEE", c, true);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                b[i] = a(b[i]);
            }
        }
        String a7 = a("DESCRIPTION", c, true);
        String a8 = a("GEO", c, true);
        if (a8 == null) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else {
            int indexOf = a8.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d = Double.parseDouble(a8.substring(0, indexOf));
                d2 = Double.parseDouble(a8.substring(indexOf + 1));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        try {
            return new C1005g(a, a2, a3, a4, a5, a6, b, a7, d, d2);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
