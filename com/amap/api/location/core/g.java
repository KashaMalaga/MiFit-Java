package com.amap.api.location.core;

import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.a.a.a.C0907p;
import com.a.a.a.C0908q;
import com.a.a.a.C0910s;
import com.a.a.a.C0911t;
import com.a.a.a.C0912u;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kankan.wheel.widget.a;

public class g {
    private static final String[] a = new String[]{c.b, c.d, GroupItemBaseInfo.KEY_COUNT, "d", GroupItemBaseInfo.KEY_END_TIME, "f", "g", C0454m.a, "i", "j", "k", "l", "m", "n", "o", c.a, WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, "r", GroupItemBaseInfo.KEY_START_TIME, C0454m.c, "u", SportBaseInfo.VERSION, "w", "x", "y", "z", Constants.VIA_RESULT_SUCCESS, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_SSO_LOGIN, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_TO_TYPE_QZONE, Constants.VIA_SHARE_TYPE_TEXT, Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", C0911t.a, "B", "C", "D", C0908q.a, "F", "G", "H", "I", "J", C0910s.a, "L", C0912u.b, C0910s.c, "O", "P", "Q", "R", C0907p.b, C0912u.a, "U", C0911t.b, C0908q.b, "X", "Y", "Z"};

    public static String a(String str) {
        MessageDigest instance;
        byte[] bArr = null;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            instance = null;
        }
        if (instance != null) {
            try {
                instance.update(str.getBytes(a.bO));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (instance != null) {
            bArr = instance.digest();
        }
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return com.xiaomi.e.a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
