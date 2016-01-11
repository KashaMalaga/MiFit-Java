package com.amap.api.mapcore.util;

import com.xiaomi.e.a;

class au {
    au() {
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        String b = aa.b(str.getBytes());
        return ((char) ((b.length() % 26) + 65)) + b;
    }

    static String b(String str) {
        return str.length() < 2 ? a.f : aa.a(str.substring(1));
    }
}
