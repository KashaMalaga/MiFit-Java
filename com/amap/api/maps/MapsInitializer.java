package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.ai;
import com.amap.api.mapcore.util.x;
import com.xiaomi.e.a;

public final class MapsInitializer {
    private static boolean a = true;
    public static String sdcardDir = a.f;

    public static boolean getNetWorkEnable() {
        return a;
    }

    public static void initialize(Context context) {
        ai.a = context.getApplicationContext();
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            x.a(str);
        }
    }

    public static void setNetWorkEnable(boolean z) {
        a = z;
    }
}
