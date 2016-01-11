package com.xiaomi.mistatistic.sdk;

import com.xiaomi.mistatistic.sdk.a.b;
import com.xiaomi.mistatistic.sdk.a.d;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.C1124a;
import com.xiaomi.mistatistic.sdk.b.u;
import com.xiaomi.mistatistic.sdk.c.a;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

public class e {
    private static final Map a = new HashMap();
    private static final List b = new ArrayList();
    private static final List c = new ArrayList();
    private static final List d = new ArrayList();
    private static final List e = new ArrayList();
    private static Boolean f = null;

    static {
        b.add("file");
        b.add("ftp");
        b.add("http");
        b.add("https");
        b.add("jar");
        c.add("http");
    }

    public static URLConnection a(URLConnection uRLConnection) {
        return uRLConnection instanceof HttpURLConnection ? new b((HttpURLConnection) uRLConnection) : uRLConnection instanceof HttpsURLConnection ? new d((HttpsURLConnection) uRLConnection) : uRLConnection;
    }

    public static void a(C1124a c1124a) {
        u.a().a(c1124a);
    }

    public static void a(a aVar) {
        u.a().a(aVar);
    }

    public static boolean a() {
        if (f != null) {
            return f.booleanValue();
        }
        try {
            for (String url : b) {
                URL url2 = new URL(url, "www.xiaomi.com", com.xiaomi.e.a.f);
            }
            Field declaredField = URL.class.getDeclaredField("streamHandlers");
            declaredField.setAccessible(true);
            Hashtable hashtable = (Hashtable) declaredField.get(null);
            for (String str : b) {
                a.put(str, (URLStreamHandler) hashtable.get(str));
            }
            URL.setURLStreamHandlerFactory(new h());
            f = Boolean.valueOf(true);
        } catch (Throwable th) {
            new A().a("failed to enable url interceptor", th);
        }
        f = Boolean.valueOf(false);
        return f.booleanValue();
    }

    public static void b() {
        for (a aVar : u.a().b()) {
            try {
                System.out.println("EVENT: " + aVar.a() + ": " + aVar.e().toString());
            } catch (JSONException e) {
            }
        }
    }
}
