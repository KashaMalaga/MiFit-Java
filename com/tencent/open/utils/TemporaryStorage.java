package com.tencent.open.utils;

import java.util.HashMap;

public class TemporaryStorage {
    private static HashMap<String, Object> a = new HashMap();

    public static Object get(String str) {
        return a.remove(str);
    }

    public static void remove(String str) {
        a.remove(str);
    }

    public static Object set(String str, Object obj) {
        return a.put(str, obj);
    }
}
