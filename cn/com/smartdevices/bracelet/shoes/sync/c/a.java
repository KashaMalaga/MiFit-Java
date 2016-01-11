package cn.com.smartdevices.bracelet.shoes.sync.c;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.regex.Pattern;

public class a {
    private a() {
    }

    public static String a(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace("FFFE", com.xiaomi.e.a.f);
            int length = replace.length();
            if (length == 12) {
                StringBuilder stringBuilder = new StringBuilder(replace);
                int i = 0;
                int i2 = 2;
                while (i2 < length) {
                    try {
                        stringBuilder.insert(i2 + i, kankan.wheel.widget.a.ci);
                        i++;
                        i2 += 2;
                    } catch (IndexOutOfBoundsException e) {
                        C0596r.d("AddressConvertion", e.getMessage());
                    }
                }
                str2 = stringBuilder.toString();
            }
        }
        return str2;
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) ? false : Pattern.compile("^[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}$").matcher(str).find();
    }
}
