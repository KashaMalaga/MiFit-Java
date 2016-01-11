package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentProviderResult;
import android.content.Context;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.j;
import cn.com.smartdevices.bracelet.shoes.model.k;
import java.util.List;

public class t {
    private t() {
    }

    public static h a(Context context, String str, c cVar) {
        return l.a(context, str, cVar);
    }

    public static h a(Context context, String str, c cVar, boolean z) {
        return l.a(context, str, cVar, z);
    }

    public static List<String> a(Context context, c cVar, String str, String str2) {
        return l.a(context, cVar, str, str2, true);
    }

    public static void a(Context context) {
        s.a(context).b();
    }

    public static boolean a(Context context, long j) {
        return o.a(context, j);
    }

    public static boolean a(Context context, long j, c cVar) {
        return o.a(context, j, cVar);
    }

    public static boolean a(Context context, a aVar) {
        if (aVar != null) {
            aVar.f(k.STATE_UNSYNCED.a());
        }
        return q.a(context, aVar);
    }

    public static boolean a(Context context, c cVar) {
        return q.a(context, cVar);
    }

    public static boolean a(Context context, c cVar, String str) {
        return q.a(context, cVar, str);
    }

    public static boolean a(Context context, e eVar) {
        return v.a(context, eVar);
    }

    public static boolean a(Context context, h hVar) {
        return l.b(context, hVar);
    }

    public static ContentProviderResult[] a(Context context, List<h> list) {
        return l.a(context, (List) list);
    }

    public static List<h> b(Context context) {
        return l.a(context);
    }

    public static List<h> b(Context context, c cVar) {
        return l.a(context, cVar);
    }

    public static List<String> b(Context context, c cVar, String str, String str2) {
        return l.a(context, cVar, str, str2, false);
    }

    public static boolean b(Context context, c cVar, String str) {
        return l.a(context, cVar, str);
    }

    public static boolean b(Context context, e eVar) {
        return q.a(context, eVar);
    }

    public static boolean b(Context context, List<j> list) {
        return v.a(context, (List) list);
    }

    public static a c(Context context, c cVar) {
        return q.a(context, cVar, k.SYNC_STATE_DEFAULT);
    }

    public static List<h> c(Context context) {
        return l.a(context, null);
    }

    public static boolean c(Context context, List<j> list) {
        return v.b(context, list);
    }

    public static String[] c(Context context, c cVar, String str, String str2) {
        return l.a(context, cVar, str, str2);
    }

    public static a d(Context context, c cVar) {
        return q.a(context, cVar, k.STATE_UNSYNCED);
    }

    public static List<e> d(Context context) {
        return v.a(context);
    }

    public static a e(Context context) {
        return q.a(context);
    }

    public static List<a> e(Context context, c cVar) {
        return q.b(context, cVar);
    }

    public static long f(Context context, c cVar) {
        return o.a(context, cVar);
    }

    public static List<a> f(Context context) {
        return q.b(context);
    }

    public static List<a> g(Context context) {
        return q.b(context, null);
    }

    public static String[] g(Context context, c cVar) {
        return l.b(context, cVar);
    }

    public static long h(Context context) {
        return o.a(context);
    }

    public static boolean h(Context context, c cVar) {
        return (1 & q.c(context, cVar)) & l.c(context, cVar);
    }

    public static List<j> i(Context context) {
        return v.b(context);
    }

    public static boolean i(Context context, c cVar) {
        return q.e(context, cVar);
    }

    public static boolean j(Context context, c cVar) {
        return l.d(context, cVar);
    }

    public static String[] j(Context context) {
        return l.b(context, null);
    }

    public static boolean k(Context context) {
        return o.b(context);
    }

    public static boolean k(Context context, c cVar) {
        return l.e(context, cVar);
    }

    public static boolean l(Context context, c cVar) {
        return l.f(context, cVar);
    }

    public static boolean m(Context context, c cVar) {
        return q.g(context, cVar);
    }
}
