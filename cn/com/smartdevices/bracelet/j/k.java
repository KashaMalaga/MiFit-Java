package cn.com.smartdevices.bracelet.j;

import com.xiaomi.e.a;
import java.util.HashMap;

public class k {
    private static HashMap<String, String> a = new HashMap();
    private static final String b = "https://openmobile.qq.com/v3/health/";
    private static final String c = "http://weatherapi.market.xiaomi.com/wtr-v2";
    private static final String d = "&source=mihealth";
    private static final String e = "https://openmobile.qq.com/v3/health/report_steps";
    private static final String f = "https://openmobile.qq.com/v3/health/report_sleep";
    private static final String g = "https://openmobile.qq.com/v3/health/report_weight";
    private static final String h = "http://weatherapi.market.xiaomi.com/wtr-v2/city/positioning?longitude=%s&latitude=%s&source=mihealth";
    private static final String i = "http://weatherapi.market.xiaomi.com/wtr-v2/city/datasource?cityNames=%s&longitude=%s&latitude=%s&phoneCode=%s&areaCode=%s&source=mihealth";
    private static final String j = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=%s&source=mihealth";

    static {
        a.put("URL_POST_STEPS", e);
        a.put("URL_POST_SLEEP", f);
        a.put("URL_POST_WEIGHT", g);
        a.put("URL_REQUEST_CITY", h);
        a.put("URL_REQUEST_CITY_CODE", i);
        a.put("URL_REQUEST_WEATHER", j);
    }

    public static String a(String str) {
        return (str == null || a.f.equals(str)) ? a.f : (String) a.get(str);
    }

    public static boolean b(String str) {
        return (str == null || a.f.equals(str)) ? false : str.indexOf(c) == 0 || str.indexOf(b) == 0;
    }
}
