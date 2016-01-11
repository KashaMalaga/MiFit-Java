package com.f.a.c;

import java.util.Comparator;

final class h implements Comparator<String> {
    h() {
    }

    public int a(String str, String str2) {
        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((String) obj, (String) obj2);
    }
}
