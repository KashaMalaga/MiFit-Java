package com.f.a.b.d;

import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.e.a;
import java.util.Locale;

public enum d {
    HTTP("http"),
    HTTPS("https"),
    FILE("file"),
    CONTENT(ParamKey.CONTENT),
    ASSETS("assets"),
    DRAWABLE("drawable"),
    UNKNOWN(a.f);
    
    private String h;
    private String i;

    private d(String str) {
        this.h = str;
        this.i = str + "://";
    }

    public static d a(String str) {
        if (str != null) {
            for (d dVar : values()) {
                if (dVar.d(str)) {
                    return dVar;
                }
            }
        }
        return UNKNOWN;
    }

    private boolean d(String str) {
        return str.toLowerCase(Locale.US).startsWith(this.i);
    }

    public String b(String str) {
        return this.i + str;
    }

    public String c(String str) {
        if (d(str)) {
            return str.substring(this.i.length());
        }
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.h}));
    }
}
