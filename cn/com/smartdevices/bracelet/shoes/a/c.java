package cn.com.smartdevices.bracelet.shoes.a;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import kankan.wheel.widget.a;

public class c {
    private static final int a = 12;

    public static d a(String str) {
        int i = 2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("/");
        if (indexOf == -1 || indexOf - 12 < 0) {
            return null;
        }
        String substring = str.substring(indexOf - 12, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length());
        String substring3 = str.substring(0, indexOf - 12);
        int length = substring.length();
        StringBuilder stringBuilder = new StringBuilder(substring.substring(0, 2));
        while (i < length) {
            stringBuilder.append(a.ci);
            stringBuilder.append(substring.substring(i, i + 2));
            i += 2;
        }
        String stringBuilder2 = stringBuilder.toString();
        C0596r.d(C0410c.q, "parseQR macAddress:" + stringBuilder2 + ",sn:" + substring2 + ",brand:" + substring3);
        return BluetoothAdapter.checkBluetoothAddress(stringBuilder2) ? new d(substring3, stringBuilder2, substring2) : null;
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
        } else if (str.length() < a) {
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

    private void b(String str) {
        if (str.contains("//") && str.length() >= a) {
            str.substring(str.length() - 12);
        }
    }
}
