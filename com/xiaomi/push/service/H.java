package com.xiaomi.push.service;

import android.content.Context;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.Locale;

public class H {
    public final String a;
    protected final String b;
    protected final String c;
    protected final String d;
    protected final String e;
    protected final String f;
    protected final int g;

    public H(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = i;
    }

    private static boolean a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public Z a(XMPushService xMPushService) {
        Z z = new Z(xMPushService);
        z.a = xMPushService.getPackageName();
        z.b = this.a;
        z.i = this.c;
        z.c = this.b;
        z.h = Constants.VIA_SHARE_TYPE_TEXT;
        z.d = "XMPUSH-PASS";
        z.e = false;
        z.f = "sdk_ver:2";
        String str = a((Context) xMPushService) ? "1000271" : this.d;
        z.g = String.format("%1$s:%2$s,%3$s:%4$s", new Object[]{SocialConstants.PARAM_APP_ID, str, "locale", Locale.getDefault().toString()});
        z.k = xMPushService.e();
        return z;
    }
}
