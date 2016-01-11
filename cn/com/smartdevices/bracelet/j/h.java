package cn.com.smartdevices.bracelet.j;

import android.os.SystemClock;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Pattern;
import kankan.wheel.widget.a;

public class h {
    private static String a = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
    private static String b;

    public static long a() {
        return new Date().getTime();
    }

    public static String a(String str) {
        int nextInt = new Random(SystemClock.currentThreadTimeMillis()).nextInt(90) + 10;
        return b(nextInt + str) + a.ci + nextInt;
    }

    public static String a(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> arrayList = new ArrayList();
        b h = b.h();
        for (Entry key : hashMap.entrySet()) {
            arrayList.add(key.getKey());
        }
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        for (String str : arrayList) {
            stringBuffer.append((String) hashMap.get(str));
        }
        h.getClass();
        stringBuffer.append("c18c24046606b2e084edd37f9fe9f94d");
        return b(stringBuffer.toString());
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        b h = b.h();
        String c = c(SocialConstants.PARAM_APP_ID);
        h.getClass();
        hashMap.put(c, c("1uMqYWpHo3MoLH"));
        hashMap.put(c(f.c), c(com.xiaomi.e.a.f + a()));
        c = c(SportBaseInfo.VERSION);
        h.getClass();
        hashMap.put(c, c("1.0"));
        hashMap.put(c(f.e), c(Locale.getDefault().getLanguage()));
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(f.h, a(hashMap));
        return hashMap;
    }

    public static boolean a(String str, String str2) {
        return str != null && str.length() >= 1 && str2 != null && str2.length() >= 6 && str2.length() <= 25 && Pattern.compile(a).matcher(str).matches();
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(com.d.a.a.h.DEFAULT_CHARSET));
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & HeartRateInfo.HR_EMPTY_VALUE) < 16) {
                    stringBuilder.append(Constants.VIA_RESULT_SUCCESS);
                }
                stringBuilder.append(Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    public static String b(String str, String str2) {
        if (b == null || com.xiaomi.e.a.f.equalsIgnoreCase(b)) {
            return str;
        }
        if (str2 == null || com.xiaomi.e.a.f.equalsIgnoreCase(str2)) {
            str2 = String.valueOf(System.currentTimeMillis());
        }
        if (str != null) {
            try {
                if (str.length() > 0 && str.lastIndexOf("/") == str.length() - 1) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (Exception e) {
                return str;
            }
        }
        String rawQuery = URI.create(str).getRawQuery();
        return rawQuery == null ? str + "?t=" + str2 + "&r=" + b : com.xiaomi.e.a.f.equalsIgnoreCase(rawQuery) ? str + "t=" + str2 + "&r=" + b : str + "&t=" + str2 + "&r=" + b;
    }

    public static HashMap<String, String> b(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        b h = b.h();
        String c = c(SocialConstants.PARAM_APP_ID);
        h.getClass();
        hashMap.put(c, c("1uMqYWpHo3MoLH"));
        hashMap.put(c(f.c), c(com.xiaomi.e.a.f + a()));
        c = c(SportBaseInfo.VERSION);
        h.getClass();
        hashMap.put(c, c("1.0"));
        hashMap.put(c(f.e), c(Locale.getDefault().getLanguage()));
        hashMap2.putAll(hashMap);
        if (map != null) {
            hashMap2.putAll(map);
        }
        hashMap.put(f.h, a(hashMap2));
        return hashMap;
    }

    public static String c(String str) {
        String str2 = null;
        try {
            str2 = URLEncoder.encode(str, com.d.a.a.h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    public static void d(String str) {
        b = str;
    }
}
