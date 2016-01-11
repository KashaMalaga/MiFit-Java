package cn.com.smartdevices.bracelet.lab;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.a.a;
import cn.com.smartdevices.bracelet.config.a.c;
import cn.com.smartdevices.bracelet.config.a.d;
import cn.com.smartdevices.bracelet.config.b;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h {
    private static final Map<String, List<String>> a = new HashMap(3);

    private h() {
    }

    public static void a(Context context) {
        Object b = Utils.b(context);
        if (!TextUtils.isEmpty(b) && !b.equals(Keeper.readApkVersion())) {
            String readFeatureVisited = Keeper.readFeatureVisited();
            Keeper.clearFeatureVisited();
            for (List<String> it : a.values()) {
                for (String str : it) {
                    if (readFeatureVisited.contains(str)) {
                        Keeper.keepFeatureVisited(str);
                    }
                }
            }
        }
    }

    public static void a(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            Class cls = obj.getClass();
            String canonicalName = cls.getCanonicalName();
            List list = (List) a.get(canonicalName);
            if (list == null) {
                list = new ArrayList();
            }
            for (String str2 : str.split(f.i)) {
                try {
                    if (!Boolean.parseBoolean(cls.getDeclaredField("ENABLE_" + str2).get(obj).toString())) {
                    }
                } catch (NoSuchFieldException e) {
                } catch (IllegalAccessException e2) {
                } catch (IllegalArgumentException e3) {
                }
                list.add(str2);
            }
            a.put(canonicalName, list);
        }
    }

    public static boolean a() {
        String readFeatureVisited = Keeper.readFeatureVisited();
        for (List<String> it : a.values()) {
            for (String contains : it) {
                if (!readFeatureVisited.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        List<String> list = (List) a.get(obj.getClass().getName());
        if (list == null || list.size() <= 0) {
            return false;
        }
        String readFeatureVisited = Keeper.readFeatureVisited();
        for (String contains : list) {
            if (!readFeatureVisited.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (Keeper.readFeatureVisited().contains(str)) {
            return false;
        }
        for (List<String> it : a.values()) {
            for (String equals : it) {
                if (equals.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b() {
        b h = b.h();
        a aVar = h.e;
        h.o.getClass();
        a(aVar, com.xiaomi.e.a.f);
        d dVar = h.f;
        h.o.getClass();
        a(dVar, com.xiaomi.e.a.f);
        c cVar = h.g;
        h.o.getClass();
        a(cVar, "RUNNING");
        cn.com.smartdevices.bracelet.config.a.b bVar = h.p;
        h.o.getClass();
        a(bVar, "RELATION");
        String readFeatureVisited = Keeper.readFeatureVisited();
        if (!TextUtils.isEmpty(readFeatureVisited)) {
            if (readFeatureVisited.contains("LAB")) {
                Keeper.keepFeatureVisited(cn.com.smartdevices.bracelet.config.f.e);
            }
            if (readFeatureVisited.contains("SERVICE")) {
                Keeper.keepFeatureVisited(cn.com.smartdevices.bracelet.config.f.f);
            }
        }
    }

    public static void b(String str) {
        if (!Keeper.readFeatureVisited().contains(str)) {
            Keeper.keepFeatureVisited(str);
        }
    }
}
