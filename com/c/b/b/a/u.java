package com.c.b.b.a;

import com.c.b.s;
import com.d.a.a.h;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class u {
    private static final u[] a = new u[]{new C1004f(), new C1001c(), new C1008j(), new C1000b(), new F(), new C1003e(), new G(), new C1007i(), new y(), new A(), new v(), new x(), new n(), new K(), new E(), new D(), new p(), new t(), new l(), new I()};
    private static final Pattern b = Pattern.compile("\\d+");
    private static final Pattern c = Pattern.compile("&");
    private static final Pattern d = Pattern.compile("=");
    private static final String e = "\ufeff";

    protected static int a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], e(split[1]));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    protected static void a(String str, StringBuilder stringBuilder) {
        if (str != null) {
            stringBuilder.append('\n');
            stringBuilder.append(str);
        }
    }

    protected static void a(String[] strArr, StringBuilder stringBuilder) {
        if (strArr != null) {
            for (String str : strArr) {
                stringBuilder.append('\n');
                stringBuilder.append(str);
            }
        }
    }

    protected static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && b.matcher(charSequence).matches();
    }

    protected static boolean a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null || i2 <= 0) {
            return false;
        }
        int i3 = i + i2;
        return charSequence.length() >= i3 && b.matcher(charSequence.subSequence(i, i3)).matches();
    }

    static String[] a(String str, String str2, char c, boolean z) {
        int length = str2.length();
        int i = 0;
        List list = null;
        while (i < length) {
            i = str2.indexOf(str, i);
            if (i < 0) {
                break;
            }
            int length2 = i + str.length();
            Object obj = 1;
            List list2 = list;
            int i2 = length2;
            while (obj != null) {
                int indexOf = str2.indexOf(c, i2);
                if (indexOf < 0) {
                    i2 = str2.length();
                    obj = null;
                } else if (b(str2, indexOf) % 2 != 0) {
                    i2 = indexOf + 1;
                } else {
                    if (list2 == null) {
                        list2 = new ArrayList(3);
                    }
                    String c2 = c(str2.substring(length2, indexOf));
                    if (z) {
                        c2 = c2.trim();
                    }
                    if (!c2.isEmpty()) {
                        list2.add(c2);
                    }
                    i2 = indexOf + 1;
                    obj = null;
                }
            }
            int i3 = i2;
            list = list2;
            i = i3;
        }
        return (list == null || list.isEmpty()) ? null : (String[]) list.toArray(new String[list.size()]);
    }

    private static int b(CharSequence charSequence, int i) {
        int i2 = 0;
        int i3 = i - 1;
        while (i3 >= 0 && charSequence.charAt(i3) == '\\') {
            i2++;
            i3--;
        }
        return i2;
    }

    static String b(String str, String str2, char c, boolean z) {
        String[] a = a(str, str2, c, z);
        return a == null ? null : a[0];
    }

    protected static String[] b(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String c(s sVar) {
        String a = sVar.a();
        return a.startsWith(e) ? a.substring(1) : a;
    }

    protected static String c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length - 1);
        stringBuilder.append(str.toCharArray(), 0, indexOf);
        indexOf = 0;
        for (int i = indexOf; i < length; i++) {
            char charAt = str.charAt(i);
            if (indexOf == 0 && charAt == '\\') {
                indexOf = 1;
            } else {
                stringBuilder.append(charAt);
                indexOf = 0;
            }
        }
        return stringBuilder.toString();
    }

    public static q d(s sVar) {
        for (u b : a) {
            q b2 = b.b(sVar);
            if (b2 != null) {
                return b2;
            }
        }
        return new B(sVar.a(), null);
    }

    static Map<String, String> d(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        Map hashMap = new HashMap(3);
        for (CharSequence a : c.split(str.substring(indexOf + 1))) {
            a(a, hashMap);
        }
        return hashMap;
    }

    static String e(String str) {
        try {
            return URLDecoder.decode(str, h.DEFAULT_CHARSET);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract q b(s sVar);
}
