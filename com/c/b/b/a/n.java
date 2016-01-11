package com.c.b.b.a;

import com.c.b.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n extends u {
    private static final Pattern a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    public m a(s sVar) {
        double d = 0.0d;
        Matcher matcher = a.matcher(u.c(sVar));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble > 90.0d || parseDouble < -90.0d) {
                return null;
            }
            double parseDouble2 = Double.parseDouble(matcher.group(2));
            if (parseDouble2 > 180.0d || parseDouble2 < -180.0d) {
                return null;
            }
            if (matcher.group(3) != null) {
                double parseDouble3 = Double.parseDouble(matcher.group(3));
                if (parseDouble3 < 0.0d) {
                    return null;
                }
                d = parseDouble3;
            }
            return new m(parseDouble, parseDouble2, d, group);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public /* synthetic */ q b(s sVar) {
        return a(sVar);
    }
}
