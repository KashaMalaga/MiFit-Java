package cn.com.smartdevices.bracelet.shoes.a;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import java.util.HashMap;
import java.util.Map;
import kankan.wheel.widget.a;

public class c {
    private static final String a = "http://iot.qq.com/add?";
    private static final String b = "http://iot.qq.com/add?pid=1700002201&sn=H157";
    private static final int c = 12;

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(b)) {
            return d(str);
        }
        d c = str.startsWith(a) ? c(str) : b(str);
        C0596r.d("capture", "qrResult:" + c);
        return c;
    }

    public static String a(String str, String str2) {
        int i = 2;
        C0596r.d(C0410c.q, "parseMacAddress scanResult = " + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String substring;
        if (!str.contains("//")) {
            int indexOf = str.indexOf("/");
            if (indexOf == -1) {
                return null;
            }
            if (indexOf - 12 < 0) {
                return null;
            }
            substring = str.substring(indexOf - 12, indexOf);
        } else if (str.length() < c) {
            return null;
        } else {
            substring = str.substring(str.length() - 12);
        }
        int length = substring.length();
        StringBuilder stringBuilder = new StringBuilder(substring.substring(0, 2));
        while (i < length) {
            stringBuilder.append(a.ci);
            stringBuilder.append(substring.substring(i, i + 2));
            i += 2;
        }
        substring = stringBuilder.toString().toUpperCase();
        return !BluetoothAdapter.checkBluetoothAddress(substring) ? null : substring;
    }

    private static d b(String str) {
        int indexOf = str.indexOf("/");
        if (indexOf == -1 || indexOf - 12 < 0) {
            return null;
        }
        Object e = e(str.substring(indexOf - 12, indexOf));
        return !TextUtils.isEmpty(e) ? new d(str.substring(0, indexOf - 12), e, str.substring(indexOf + 1, str.length())) : null;
    }

    private static d c(String str) {
        Map f = f(str);
        Object e = e((String) f.get(g.q));
        return TextUtils.isEmpty(e) ? null : new d((String) f.get("pid"), e, (String) f.get(g.p));
    }

    private static d d(String str) {
        Map f = f(str);
        String str2 = (String) f.get(g.p);
        String str3 = (String) f.get("pid");
        Object e = e(str2.substring(4));
        return TextUtils.isEmpty(e) ? null : new d(str3, e, str2);
    }

    private static String e(String str) {
        int i = 2;
        if (str.length() != c) {
            return null;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(str.substring(0, 2));
        while (i < length) {
            stringBuilder.append(a.ci);
            stringBuilder.append(str.substring(i, i + 2));
            i += 2;
        }
        String toUpperCase = stringBuilder.toString().toUpperCase();
        return BluetoothAdapter.checkBluetoothAddress(toUpperCase) ? toUpperCase : null;
    }

    private static Map<String, String> f(String str) {
        Map hashMap = new HashMap();
        String g = g(str);
        if (g != null) {
            for (String split : g.split("[&]")) {
                String[] split2 = split.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                } else if (split2[0] != com.xiaomi.e.a.f) {
                    hashMap.put(split2[0], com.xiaomi.e.a.f);
                }
            }
        }
        return hashMap;
    }

    private static String g(String str) {
        String toLowerCase = str.trim().toLowerCase();
        String[] split = toLowerCase.split("[?]");
        return (toLowerCase.length() <= 1 || split.length <= 1 || split[1] == null) ? null : split[1];
    }

    private void h(String str) {
        if (str.contains("//") && str.length() >= c) {
            str.substring(str.length() - 12);
        }
    }
}
