package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;
import kankan.wheel.widget.l;

public final class a {

    public final class a {
        public static Object a(int i, String str) {
            switch (i) {
                case l.a /*1*/:
                    return Integer.valueOf(str);
                case kankan.wheel.widget.a.k /*2*/:
                    return Long.valueOf(str);
                case kankan.wheel.widget.a.l /*3*/:
                    return str;
                case kankan.wheel.widget.a.aQ /*4*/:
                    return Boolean.valueOf(str);
                case kankan.wheel.widget.a.X /*5*/:
                    return Float.valueOf(str);
                case kankan.wheel.widget.a.bt /*6*/:
                    return Double.valueOf(str);
                default:
                    try {
                        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
            }
        }
    }

    public final class b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
