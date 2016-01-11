package cn.com.smartdevices.bracelet.shoes.sync.c;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class d {
    public static String a(String str) {
        return a(str, null);
    }

    public static String a(String str, String str2) {
        String str3 = null;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "yyyy-MM-dd";
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                simpleDateFormat.setLenient(false);
                str3 = simpleDateFormat.format(simpleDateFormat.parse(str));
            } catch (Exception e) {
                C0596r.d("TimeVerifier", e.getMessage());
            }
        }
        return str3;
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) ? false : Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
