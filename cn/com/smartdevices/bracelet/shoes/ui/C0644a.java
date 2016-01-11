package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.xiaomi.e.a;

public class C0644a {
    public static String a(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return a.f;
        }
        for (e eVar : t.d(context)) {
            if (eVar.e.equals(str) && eVar.f == i) {
                return eVar.d();
            }
        }
        return a.f;
    }
}
