package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class X {
    private static X a;
    private ConcurrentHashMap<String, HashMap<String, Z>> b = new ConcurrentHashMap();
    private List<Y> c = new ArrayList();

    private X() {
    }

    public static synchronized X a() {
        X x;
        synchronized (X.class) {
            if (a == null) {
                a = new X();
            }
            x = a;
        }
        return x;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(Context context) {
        for (HashMap values : this.b.values()) {
            for (Z a : values.values()) {
                a.a(ab.unbind, 1, 3, null, null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap values : this.b.values()) {
            for (Z a : values.values()) {
                a.a(ab.unbind, 2, i, null, null);
            }
        }
    }

    public synchronized void a(Y y) {
        this.c.add(y);
    }

    public synchronized void a(Z z) {
        HashMap hashMap = (HashMap) this.b.get(z.h);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.b.put(z.h, hashMap);
        }
        hashMap.put(d(z.b), z);
        for (Y a : this.c) {
            a.a();
        }
    }

    public synchronized void a(String str) {
        HashMap hashMap = (HashMap) this.b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.b.remove(str);
        }
        for (Y a : this.c) {
            a.a();
        }
    }

    public synchronized void a(String str, String str2) {
        HashMap hashMap = (HashMap) this.b.get(str);
        if (hashMap != null) {
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        for (Y a : this.c) {
            a.a();
        }
    }

    public synchronized Z b(String str, String str2) {
        HashMap hashMap;
        hashMap = (HashMap) this.b.get(str);
        return hashMap == null ? null : (Z) hashMap.get(d(str2));
    }

    public synchronized ArrayList<Z> b() {
        ArrayList<Z> arrayList;
        arrayList = new ArrayList();
        for (HashMap values : this.b.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    public synchronized List<String> b(String str) {
        List<String> arrayList;
        arrayList = new ArrayList();
        for (HashMap values : this.b.values()) {
            for (Z z : values.values()) {
                if (str.equals(z.a)) {
                    arrayList.add(z.h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int c() {
        return this.b.size();
    }

    public synchronized Collection<Z> c(String str) {
        return !this.b.containsKey(str) ? new ArrayList() : ((HashMap) ((HashMap) this.b.get(str)).clone()).values();
    }

    public synchronized void d() {
        this.b.clear();
    }

    public synchronized void e() {
        this.c.clear();
    }
}
