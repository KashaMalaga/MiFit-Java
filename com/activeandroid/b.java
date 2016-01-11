package com.activeandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.l.i;
import com.activeandroid.c.e;
import java.util.Collection;

public final class b {
    public static final int a = 1024;
    private static Context b;
    private static h c;
    private static f d;
    private static i<String, g> e;
    private static boolean f = false;

    private b() {
    }

    public static synchronized g a(Class<? extends g> cls, long j) {
        g gVar;
        synchronized (b.class) {
            gVar = (g) e.a(a((Class) cls, Long.valueOf(j)));
        }
        return gVar;
    }

    public static synchronized j a(Class<? extends g> cls) {
        j a;
        synchronized (b.class) {
            a = c.a((Class) cls);
        }
        return a;
    }

    public static String a(g gVar) {
        return a(gVar.getClass(), gVar.getId());
    }

    public static String a(Class<? extends g> cls, Long l) {
        return c((Class) cls) + "@" + l;
    }

    public static synchronized void a() {
        synchronized (b.class) {
            e.a();
            com.activeandroid.d.b.a("Cache cleared.");
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (f) {
                com.activeandroid.d.b.a("ActiveAndroid already initialized.");
            } else {
                b = cVar.a();
                c = new h(cVar);
                d = new f(cVar);
                e = new i(cVar.g());
                d();
                f = true;
                com.activeandroid.d.b.a("ActiveAndroid initialized successfully.");
            }
        }
    }

    public static synchronized e b(Class<?> cls) {
        e b;
        synchronized (b.class) {
            b = c.b(cls);
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (b.class) {
            e();
            e = null;
            c = null;
            d = null;
            f = false;
            com.activeandroid.d.b.a("ActiveAndroid disposed. Call initialize to use library.");
        }
    }

    public static synchronized void b(g gVar) {
        synchronized (b.class) {
            e.a(a(gVar), gVar);
        }
    }

    public static synchronized String c(Class<? extends g> cls) {
        String b;
        synchronized (b.class) {
            b = c.a((Class) cls).b();
        }
        return b;
    }

    public static synchronized void c(g gVar) {
        synchronized (b.class) {
            e.b(a(gVar));
        }
    }

    public static boolean c() {
        return f;
    }

    public static synchronized SQLiteDatabase d() {
        SQLiteDatabase writableDatabase;
        synchronized (b.class) {
            writableDatabase = d.getWritableDatabase();
        }
        return writableDatabase;
    }

    public static synchronized void e() {
        synchronized (b.class) {
            d.close();
        }
    }

    public static Context f() {
        return b;
    }

    public static synchronized Collection<j> g() {
        Collection<j> a;
        synchronized (b.class) {
            a = c.a();
        }
        return a;
    }
}
