package cn.com.smartdevices.bracelet.shoes.c;

import android.os.Build;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;

public class b {
    public static final String a = "HUAWEI";
    public static final String b = "PLK";

    private b() {
    }

    public static boolean a() {
        Object obj = Build.MANUFACTURER;
        Object obj2 = Build.MODEL;
        C0596r.d("Model", "manufacture:" + obj + ",model:" + obj2);
        return (TextUtils.isEmpty(obj) || !obj.contains(a)) ? !TextUtils.isEmpty(obj2) && obj2.contains(b) : true;
    }
}
