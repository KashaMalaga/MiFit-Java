package cn.com.smartdevices.bracelet.j;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.C1012a;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.Y;
import com.d.a.a.h;
import com.xiaomi.channel.gamesdk.b;
import org.json.JSONObject;

public class a {
    private static final int a = 1;
    private static final int b = 2;
    private static final String c = "AdvHttpClient";

    private static void a(C1012a c1012a, int i, String str, O o, Y y) {
        String b = h.b(str, o == null ? String.valueOf(System.currentTimeMillis()) : o.c(f.c));
        S bVar = new b(b, y);
        if (i == b) {
            c1012a.b(b, o, bVar);
        } else if (i == a) {
            c1012a.c(b, o, bVar);
        }
    }

    private static void a(C1012a c1012a, int i, String str, O o, h hVar) {
        String b = h.b(str, o == null ? String.valueOf(System.currentTimeMillis()) : o.c(f.c));
        S cVar = new c(b, hVar);
        if (i == b) {
            c1012a.b(b, o, cVar);
        } else if (i == a) {
            c1012a.c(b, o, cVar);
        }
    }

    public static void a(C1012a c1012a, String str, O o, Y y) {
        a(c1012a, (int) b, str, o, y);
    }

    public static void a(C1012a c1012a, String str, O o, h hVar) {
        a(c1012a, (int) b, str, o, hVar);
    }

    private static boolean a(String str) {
        return k.b(str);
    }

    private static String b(byte[] bArr) {
        String str = com.xiaomi.e.a.f;
        if (bArr == null || bArr.length <= 0) {
            return str;
        }
        try {
            return new String(bArr);
        } catch (Exception e) {
            C0596r.e("chenee", "Utils.java getStringFromBytes error:" + e.getMessage());
            return str;
        }
    }

    public static void b(C1012a c1012a, String str, O o, Y y) {
        a(c1012a, (int) a, str, o, y);
    }

    public static void b(C1012a c1012a, String str, O o, h hVar) {
        a(c1012a, (int) a, str, o, hVar);
    }

    private static void b(String str, String str2) {
        try {
            if (!a(str2) && ((Integer) new JSONObject(str).get(b.a)).intValue() != 0) {
            }
        } catch (Exception e) {
            C0596r.d(c, e.toString());
        }
    }
}
