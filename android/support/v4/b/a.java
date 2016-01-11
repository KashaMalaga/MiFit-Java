package android.support.v4.b;

import android.text.TextUtils;

public class a {
    private a() {
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : TextUtils.isEmpty(str2) ? str : "(" + str + ") AND (" + str2 + ")";
    }

    public static String[] a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        Object obj = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        System.arraycopy(strArr2, 0, obj, strArr.length, strArr2.length);
        return obj;
    }
}
