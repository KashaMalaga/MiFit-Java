package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.honor.a.a;
import cn.com.smartdevices.bracelet.honor.a.c;
import cn.com.smartdevices.bracelet.honor.a.e;
import cn.com.smartdevices.bracelet.honor.a.f;
import cn.com.smartdevices.bracelet.honor.a.g;
import cn.com.smartdevices.bracelet.honor.a.h;
import com.c.a.C0993k;
import com.c.a.r;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C0545a {
    public static C0993k a = new r().i();
    private static final String b = "Medal_Keeper";
    private static final String c = "honor_medal";
    private static final String d = "config_medal_cache";
    private static final String e = "acquired_meal_table";
    private static final String f = "unacquired_meal_table";
    private static final String g = "step_table";
    private static final String h = "sleep_table";
    private static final String i = "run_table";
    private static final String j = "share_table";
    private static final String k = "sync_medal_table";

    public static Map<Integer, Map<Integer, List<String>>> a(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(d, null);
        C0596r.e(b, "getSupportConfigCache:" + string);
        if (string == null) {
            return null;
        }
        return (Map) a.a(string, new C0546b().getType());
    }

    public static void a(Context context, e eVar) {
        String b = a.b(eVar, new C0549e().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(i, b);
        edit.apply();
    }

    public static void a(Context context, f fVar) {
        String b = a.b(fVar, new C0551g().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(j, b);
        edit.apply();
    }

    public static void a(Context context, g gVar) {
        String b = a.b(gVar, new C0547c().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(h, b);
        edit.apply();
    }

    public static void a(Context context, h hVar) {
        String b = a.b(hVar, new r().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(g, b);
        edit.apply();
    }

    public static void a(Context context, List<a> list) {
        String b = a.b(list, new C0558n().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(e, b);
        edit.apply();
    }

    public static void a(Context context, Map<Integer, Map<Integer, List<String>>> map) {
        String b = a.b(map, new C0556l().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(d, b);
        edit.apply();
    }

    public static List<a> b(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(e, null);
        C0596r.e(b, "getAcquiredMedalCache:" + string);
        if (string == null) {
            return null;
        }
        return (List) a.a(string, new C0557m().getType());
    }

    public static void b(Context context, List<a> list) {
        String b = a.b(list, new C0560p().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putString(f, b);
        edit.apply();
    }

    public static List<a> c(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(f, null);
        C0596r.e(b, "getUnacquiredMedalCache:" + string);
        if (string == null) {
            return null;
        }
        return (List) a.a(string, new C0559o().getType());
    }

    public static void c(Context context, List<c> list) {
        String b = a.b(list, new C0555k().getType());
        Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        C0596r.e(b, "synMedalTable:" + b);
        edit.putString(k, b);
        edit.apply();
    }

    public static h d(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(g, null);
        C0596r.e(b, "getStepCache:" + string);
        if (string == null) {
            return null;
        }
        return (h) a.a(string, new q().getType());
    }

    public static g e(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(h, null);
        if (string == null) {
            return null;
        }
        return (g) a.a(string, new s().getType());
    }

    public static e f(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(i, null);
        if (string == null) {
            return null;
        }
        return (e) a.a(string, new C0548d().getType());
    }

    public static f g(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(j, null);
        if (string == null) {
            return null;
        }
        return (f) a.a(string, new C0550f().getType());
    }

    public static List<c> h(Context context) {
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(k, null);
        if (string == null) {
            return null;
        }
        return (List) a.a(string, new C0552h().getType());
    }

    public static boolean i(Context context) {
        List h = C0545a.h(context);
        if (h != null) {
            int size = h.size();
            for (int i = 0; i < size; i++) {
                if (!((c) h.get(i)).i) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String j(Context context) {
        List list;
        C0993k i = new r().a(new C0553i()).i();
        String string = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(k, null);
        Type type = new C0554j().getType();
        if (string != null) {
            list = (List) a.a(string, type);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((c) it.next()).i) {
                        it.remove();
                    }
                }
            }
        } else {
            list = null;
        }
        return (list == null || list.size() <= 0) ? null : i.b(list, type);
    }

    public static void k(Context context) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(c, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
            edit.clear();
            edit.apply();
        }
    }
}
