package cn.com.smartdevices.bracelet.j;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import com.tencent.open.SocialConstants;

public abstract class e {
    protected static final String m = "huami.health.";
    protected static final String n = "huami.sport.";
    protected static final String o = "huami.partner.";
    protected static final String p = "json";
    protected static final String q = "huami.shoes.";
    protected static final String r = "huami.user.";
    protected static final String s = "huami.device.";
    public static boolean t = false;
    public static final String u = null;

    public static String a(String str) {
        String str2 = "https://hm.mi-ae.com/";
        String str3 = b.e() + str;
        if (t) {
            str3 = str2 + str;
        }
        if (!TextUtils.isEmpty(u)) {
            str3 = u + str;
        }
        C0596r.e(SocialConstants.PARAM_URL, str3);
        return str3;
    }
}
