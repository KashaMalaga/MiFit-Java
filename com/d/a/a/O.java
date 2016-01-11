package com.d.a.a;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class O {
    public static final String a = "application/octet-stream";
    protected static final String b = "RequestParams";
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected final ConcurrentHashMap<String, String> f;
    protected final ConcurrentHashMap<String, R> g;
    protected final ConcurrentHashMap<String, Q> h;
    protected final ConcurrentHashMap<String, Object> i;
    protected String j;

    public O() {
        this((Map) null);
    }

    public O(String str, String str2) {
        this(new C1011P(str, str2));
    }

    public O(Map<String, String> map) {
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = h.DEFAULT_CHARSET;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public O(Object... objArr) {
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = h.DEFAULT_CHARSET;
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            a(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
        }
    }

    private List<BasicNameValuePair> b(String str, Object obj) {
        List<BasicNameValuePair> linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            List arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (Object next : arrayList) {
                if (next instanceof String) {
                    Object obj2 = map.get(next);
                    if (obj2 != null) {
                        String str2;
                        if (str == null) {
                            str2 = (String) next;
                        } else {
                            str2 = String.format("%s[%s]", new Object[]{str, next});
                        }
                        linkedList.addAll(b(str2, obj2));
                    }
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            r3 = list.size();
            for (r0 = 0; r0 < r3; r0++) {
                linkedList.addAll(b(String.format("%s[%d]", new Object[]{str, Integer.valueOf(r0)}), list.get(r0)));
            }
        } else if (obj instanceof Object[]) {
            for (Object b : (Object[]) obj) {
                linkedList.addAll(b(String.format("%s[%d]", new Object[]{str, Integer.valueOf(r0)}), b));
            }
        } else if (obj instanceof Set) {
            for (Object b2 : (Set) obj) {
                linkedList.addAll(b(str, b2));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    private HttpEntity b(S s) {
        boolean z = (this.h.isEmpty() && this.g.isEmpty()) ? false : true;
        HttpEntity g = new G(s, z);
        for (Entry entry : this.f.entrySet()) {
            g.a((String) entry.getKey(), entry.getValue());
        }
        for (Entry entry2 : this.i.entrySet()) {
            g.a((String) entry2.getKey(), entry2.getValue());
        }
        for (Entry entry22 : this.h.entrySet()) {
            g.a((String) entry22.getKey(), entry22.getValue());
        }
        for (Entry entry222 : this.g.entrySet()) {
            R r = (R) entry222.getValue();
            if (r.a != null) {
                g.a((String) entry222.getKey(), R.a(r.a, r.b, r.c, r.d));
            }
        }
        return g;
    }

    private HttpEntity c() {
        try {
            return new UrlEncodedFormEntity(a(), this.j);
        } catch (Throwable e) {
            Log.e(b, "createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity c(S s) {
        HttpEntity v = new V(s);
        v.a(this.c);
        for (Entry entry : this.f.entrySet()) {
            v.a((String) entry.getKey(), (String) entry.getValue());
        }
        for (BasicNameValuePair basicNameValuePair : b(null, this.i)) {
            v.a(basicNameValuePair.getName(), basicNameValuePair.getValue());
        }
        for (Entry entry2 : this.g.entrySet()) {
            R r = (R) entry2.getValue();
            if (r.a != null) {
                v.a((String) entry2.getKey(), r.b, r.a, r.c);
            }
        }
        for (Entry entry22 : this.h.entrySet()) {
            Q q = (Q) entry22.getValue();
            v.a((String) entry22.getKey(), q.a, q.b);
        }
        return v;
    }

    protected List<BasicNameValuePair> a() {
        List<BasicNameValuePair> linkedList = new LinkedList();
        for (Entry entry : this.f.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        linkedList.addAll(b(null, this.i));
        return linkedList;
    }

    public HttpEntity a(S s) {
        return this.d ? b(s) : (this.g.isEmpty() && this.h.isEmpty()) ? c() : c(s);
    }

    public void a(String str) {
        if (str != null) {
            this.j = str;
        } else {
            Log.d(b, "setContentEncoding called with null attribute");
        }
    }

    public void a(String str, int i) {
        if (str != null) {
            this.f.put(str, String.valueOf(i));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.f.put(str, String.valueOf(j));
        }
    }

    public void a(String str, File file) {
        a(str, file, null);
    }

    public void a(String str, File file, String str2) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (str != null) {
            this.h.put(str, new Q(file, str2));
        }
    }

    public void a(String str, InputStream inputStream) {
        a(str, inputStream, null);
    }

    public void a(String str, InputStream inputStream, String str2) {
        a(str, inputStream, str2, null);
    }

    public void a(String str, InputStream inputStream, String str2, String str3) {
        a(str, inputStream, str2, str3, this.e);
    }

    public void a(String str, InputStream inputStream, String str2, String str3, boolean z) {
        if (str != null && inputStream != null) {
            this.g.put(str, R.a(inputStream, str2, str3, z));
        }
    }

    public void a(String str, Object obj) {
        if (str != null && obj != null) {
            this.i.put(str, obj);
        }
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f.put(str, str2);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    protected String b() {
        return URLEncodedUtils.format(a(), this.j);
    }

    public void b(String str) {
        this.f.remove(str);
        this.g.remove(str);
        this.h.remove(str);
        this.i.remove(str);
    }

    public void b(String str, String str2) {
        if (str != null && str2 != null) {
            Object obj = this.i.get(str);
            if (obj == null) {
                obj = new HashSet();
                a(str, obj);
            }
            if (obj instanceof List) {
                ((List) obj).add(str2);
            } else if (obj instanceof Set) {
                ((Set) obj).add(str2);
            }
        }
    }

    public void b(boolean z) {
        this.d = z;
    }

    public String c(String str) {
        return this.f != null ? (String) this.f.get(str) : null;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.f.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        for (Entry entry2 : this.g.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry2.getKey());
            stringBuilder.append("=");
            stringBuilder.append("STREAM");
        }
        for (Entry entry22 : this.h.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry22.getKey());
            stringBuilder.append("=");
            stringBuilder.append("FILE");
        }
        for (BasicNameValuePair basicNameValuePair : b(null, this.i)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(basicNameValuePair.getName());
            stringBuilder.append("=");
            stringBuilder.append(basicNameValuePair.getValue());
        }
        return stringBuilder.toString();
    }
}
