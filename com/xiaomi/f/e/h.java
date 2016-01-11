package com.xiaomi.f.e;

import android.content.Context;
import android.util.Base64;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.push.service.G;
import java.security.MessageDigest;

public class h {
    private static Context a;
    private static String b;

    public static String a() {
        if (b == null) {
            String b = G.b(a);
            if (b != null) {
                try {
                    b = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(b.getBytes()), 8).substring(0, 16);
                } catch (Throwable e) {
                    c.a(e);
                }
            }
        }
        return b;
    }

    public static void a(Context context) {
        a = context;
    }
}
